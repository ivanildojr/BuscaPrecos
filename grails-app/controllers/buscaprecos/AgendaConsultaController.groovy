package buscaprecos

import org.grails.core.DefaultGrailsDomainClass
import org.quartz.SimpleScheduleBuilder
import org.quartz.Trigger
import org.quartz.TriggerBuilder

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AgendaConsultaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]



    def schedule(){
        String dataFormatada = Date.parse("yyyy-MM-dd HH:mm:ss",params.horaConsulta).format("dd/MM/yyyy")
        Date dataFinal = Date.parse("dd/MM/yyyy",dataFormatada)
        println params.horaConsulta
        println dataFinal

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(params.id,"Busca")
                //.startNow()
                .startAt(Date.parse("yyyy-MM-dd HH:mm:ss",params.horaConsulta))
                .withSchedule(
                    SimpleScheduleBuilder.simpleSchedule()
                    /*Alterar para intervalor de horas fixo*/
                                                .withIntervalInSeconds(1).repeatForever()
                )
                .usingJobData("origem",params.origem)
                .usingJobData("destino",params.destino)
                .usingJobData("dataIda",params.dataIda)
                .usingJobData("dataVolta",params.dataVolta)
                .usingJobData("adultos",params.adultos)
                .usingJobData("criancas",params.criancas)
                .build();



        BuscaPassagemJob.schedule(trigger)

        flash.message = message(code: 'default.created.message', args: [message(code: 'agendaConsulta.label', default: 'Job'), params.id])
        redirect(controller:"agendaConsulta",view:"index")

    }
    def unschedule(){
        println "Job:" + params.id + "encerrado"
        BuscaPassagemJob.unschedule(params.id,"Busca")


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
        respond AgendaConsulta.list(params), model:[agendaConsultaCount: AgendaConsulta.count(), fields:fields]
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



        agendaConsulta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'agendaConsulta.label', default: 'AgendaConsulta'), agendaConsulta.id])
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
