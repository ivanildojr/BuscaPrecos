package buscaprecos

import grails.converters.JSON
import org.grails.core.DefaultGrailsDomainClass
import org.quartz.SimpleScheduleBuilder
import org.quartz.Trigger
import org.quartz.TriggerBuilder

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AgendaConsultaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def repeticaoBusca = 6

    def buscaAeroportos(String codigo){
        println codigo

        def aeroportos = AirportCodes.findAllByNameLikeOrMunicipalityLikeOrIata_code("%"+codigo+"%","%"+codigo+"%",codigo)

        List<String> array = new ArrayList()
        aeroportos.each {
            array.add(it.iata_code + " - " + it.name)

        }

        render array as JSON


    }

    def schedule(){

        def agenda = AgendaConsulta.findById(params.id)
        println "Job está rodando: " +agenda.jobRodando
        if(!agenda.jobRodando) {
            String dataFormatada = Date.parse("yyyy-MM-dd HH:mm:ss", params.horaConsulta).format("dd/MM/yyyy")
            Date dataFinal = Date.parse("dd/MM/yyyy", dataFormatada)
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(params.id, "Busca")
            //.startNow()
                    .startAt(Date.parse("yyyy-MM-dd HH:mm:ss", params.horaConsulta))
                    .withSchedule(
                    SimpleScheduleBuilder.simpleSchedule()
                                   .withIntervalInHours(repeticaoBusca).repeatForever()
//                            .withIntervalInSeconds(120).repeatForever()
            )
                    .usingJobData("origem", params.origem)
                    .usingJobData("destino", params.destino)
                    .usingJobData("dataIda", params.dataIda)
                    .usingJobData("dataVolta", params.dataVolta)
                    .usingJobData("adultos", params.adultos)
                    .usingJobData("criancas", params.criancas)
                    .usingJobData("duracao", params.duracao)
                    .usingJobData("dataLimiteSaida", params.dataLimiteSaida)
                    .build();



            BuscaPassagemJob.schedule(trigger)

            flash.message = message(code: 'default.created.message', args: [message(code: 'agendaConsulta.label', default: 'Job'), params.id])
            redirect(controller: "agendaConsulta", view: "index")
        }else {
            flash.message = message(code: 'default.job.existe', args: [message(code: 'agendaConsulta.label', default: 'Job'), params.id])
            redirect(controller: "agendaConsulta", view: "index")
        }
    }
    def unschedule(){
        println "Job:" + params.id + "encerrado"
        BuscaPassagemJob.unschedule(params.id,"Busca")
        def agenda = AgendaConsulta.findById(params.id)
        println "Job foi encerrado: " +agenda.jobRodando
        agenda.jobRodando = false
        agenda.save flush:true

        flash.message = message(code: 'default.deleted.message', args: [message(code: 'agendaConsulta.label', default: 'Job'), params.id])
        redirect(controller:"agendaConsulta",view:"index")

    }


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def nomes = new DefaultGrailsDomainClass(AgendaConsulta.class)
        List fields = new ArrayList()
        nomes.properties.each {
            if(!it.name.equalsIgnoreCase("version") && !it.name.equalsIgnoreCase("id"))
            fields.add(it.name)
        }
        fields.add("Jobs")

        List finalFields = new ArrayList()
        finalFields.add(fields.get(fields.indexOf("origem")))
        finalFields.add(fields.get(fields.indexOf("destino")))
        finalFields.add(fields.get(fields.indexOf("dataIda")))
        finalFields.add(fields.get(fields.indexOf("dataVolta")))
        finalFields.add(fields.get(fields.indexOf("horaConsulta")))
        finalFields.add(fields.get(fields.indexOf("adultos")))
        finalFields.add(fields.get(fields.indexOf("criancas")))
        finalFields.add(fields.get(fields.indexOf("duracao")))
        finalFields.add(fields.get(fields.indexOf("dataLimiteSaida")))
        finalFields.add(fields.get(fields.indexOf("Jobs")))

        respond AgendaConsulta.list(params), model:[agendaConsultaCount: AgendaConsulta.count(), fields:finalFields]
    }

    def show(AgendaConsulta agendaConsulta) {
        respond agendaConsulta
    }

    def create() {

        respond new AgendaConsulta(params)
    }

    @Transactional
    def save(AgendaConsulta agendaConsulta) {

        if (agendaConsulta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (agendaConsulta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond agendaConsulta.errors, view:'create'
            return
        }


        agendaConsulta.jobRodando = true
        agendaConsulta.save flush:true

        /* Inicial Job*/
        String dataFormatada = agendaConsulta.horaConsulta.format("dd/MM/yyyy")
        Date dataFinal = Date.parse("dd/MM/yyyy",dataFormatada)

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(agendaConsulta.id.toString(),"Busca")
        //.startNow()
                .startAt(Date.parse("yyyy-MM-dd HH:mm:ss",agendaConsulta.horaConsulta.format("yyyy-MM-dd HH:mm:ss")))
                .withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                /*Alterar para intervalor de horas fixo*/
                        .withIntervalInHours(repeticaoBusca).repeatForever()
        )
                .usingJobData("origem",agendaConsulta.origem)
                .usingJobData("destino",agendaConsulta.destino)
                .usingJobData("dataIda",agendaConsulta.dataIda.format("yyyy-MM-dd HH:mm:ss"))
                .usingJobData("dataVolta",agendaConsulta.dataVolta.format("yyyy-MM-dd HH:mm:ss"))
                .usingJobData("adultos",agendaConsulta.adultos.toString())
                .usingJobData("criancas",agendaConsulta.criancas.toString())
                .usingJobData("duracao", agendaConsulta.duracao.toString())
                .usingJobData("dataLimiteSaida", agendaConsulta.dataLimiteSaida.format("yyyy-MM-dd HH:mm:ss"))
                .build();
        BuscaPassagemJob.schedule(trigger)
        /**/


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'agendaConsulta.label', default: 'AgendaConsulta e Job'), agendaConsulta.id])
                redirect agendaConsulta
            }
            '*' { respond agendaConsulta, [status: CREATED] }
        }
    }

    def edit(AgendaConsulta agendaConsulta) {
        respond agendaConsulta
    }

    @Transactional
    def update(AgendaConsulta agendaConsulta) {
        if (agendaConsulta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (agendaConsulta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond agendaConsulta.errors, view:'edit'
            return
        }

        agendaConsulta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'agendaConsulta.label', default: 'AgendaConsulta'), agendaConsulta.id])
                redirect agendaConsulta
            }
            '*'{ respond agendaConsulta, [status: OK] }
        }
    }

    @Transactional
    def delete(AgendaConsulta agendaConsulta) {

        if (agendaConsulta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        agendaConsulta.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'agendaConsulta.label', default: 'AgendaConsulta'), agendaConsulta.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'agendaConsulta.label', default: 'AgendaConsulta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
