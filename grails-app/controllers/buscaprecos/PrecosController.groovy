package buscaprecos

import grails.converters.JSON
import org.springframework.scheduling.annotation.Scheduled

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PrecosController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Precos.list(params), model:[precosCount: Precos.count()]
    }

    def show(Precos precos) {
        respond precos
    }

    def create() {
        respond new Precos(params)
    }

    @Transactional
    def save(Precos precos) {
        if (precos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (precos.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond precos.errors, view:'create'
            return
        }

        precos.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'precos.label', default: 'Precos'), precos.id])
                redirect precos
            }
            '*' { respond precos, [status: CREATED] }
        }
    }

    def edit(Precos precos) {
        respond precos
    }

    @Transactional
    def update(Precos precos) {
        if (precos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (precos.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond precos.errors, view:'edit'
            return
        }

        precos.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'precos.label', default: 'Precos'), precos.id])
                redirect precos
            }
            '*'{ respond precos, [status: OK] }
        }
    }

    @Transactional
    def delete(Precos precos) {

        if (precos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        precos.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'precos.label', default: 'Precos'), precos.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'precos.label', default: 'Precos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def buscaCotacoes(){

        def tabela =  Precos.findAll() as JSON//valoresIda as JSON
        render(view:"resultado",model:[gridData:tabela])
    }

    def grafico(){
        def TAMCriteria = Precos.createCriteria()
        def queryTAM = TAMCriteria.list{
            eq("empresa","TAM")
            and{
                or{
                    eq("origem",params.iata_code)
                    eq("destino",params.iata_code)
                }

            }
            and{
                ge("dataConsulta", new Date().minus(Integer.parseInt(params.vencimento)).clearTime())
            }

            order("data","asc")
            projections{
                groupProperty("data","data")

                property("origem","origem")
                property("destino","destino")
                property("empresa","empresa")
                avg("preco","media")
                max("preco","maximo")
                min("preco","minimo")
            }
        }


        def datasTAM1 = new ArrayList()
        def precosTAM1 = new ArrayList()
        def precosMinTAM1 = new ArrayList()
        def precosMaxTAM1 = new ArrayList()
        queryTAM.each {
            datasTAM1.add(it.getAt(0).toString().substring(5,10))
            precosTAM1.add(it.getAt(4))
            precosMaxTAM1.add(it.getAt(5))
            precosMinTAM1.add(it.getAt(6))
        }

        def GOLCriteria = Precos.createCriteria()
        def queryGOL = GOLCriteria.list{
            eq("empresa","GOL")
            and{
                or{
                    eq("origem",params.iata_code)
                    eq("destino",params.iata_code)
                }

            }
            and{
                ge("dataConsulta",  new Date().minus(Integer.parseInt(params.vencimento)).clearTime())
            }

            order("data","asc")
            projections{
                groupProperty("data","data")

                property("origem","origem")
                property("destino","destino")
                property("empresa","empresa")
                avg("preco","media")
                max("preco","maximo")
                min("preco","minimo")
            }
        }


        def datasGOL1 = new ArrayList()
        def precosGOL1 = new ArrayList()
        def precosMinGOL1 = new ArrayList()
        def precosMaxGOL1 = new ArrayList()
        queryGOL.each {
            datasGOL1.add(it.getAt(0).toString().substring(5,10))
            precosGOL1.add(it.getAt(4))
            precosMaxGOL1.add(it.getAt(5))
            precosMinGOL1.add(it.getAt(6))
        }


        def eixoX1 = datasTAM1 as JSON
        def yTAM1 = precosTAM1 as JSON
        def yGOL1 = precosGOL1 as JSON

        String titulo1 = "\"Precos medios de Ida ou Volta de/para "+ params.iata_code +" - TAM\""

        def eixoX2 = datasGOL1 as JSON
        def yTAM2 = precosMinTAM1 as JSON
        def yGOL2 = precosMinGOL1 as JSON
        String titulo2 = "\"Precos medios de Ida ou Volta  de/para "+ params.iata_code +" -  GOL\""

        def yTAM3 = precosMaxTAM1 as JSON
        def yGOL3 = precosMaxGOL1 as JSON

        render(view:"grafico",model:[grafico1:"IDA",titulo1:titulo1,eixoX1:eixoX1,yTAM1:yTAM1,yGOL1:yGOL1,grafico2:"VOLTA"
                                     ,titulo2:titulo2,eixoX2:eixoX2,yTAM2:yTAM2,yGOL2:yGOL2,yTAM3:yTAM3,yGOL3:yGOL3])
    }
    def graficoDia(){
        def TAMCriteria = Precos.createCriteria()
        def queryTAM = TAMCriteria.list{
            eq("empresa","TAM")
            and{
                or{
                    eq("origem",params.iata_code)
                    eq("destino",params.iata_code)
                }

            }
            and{
                ge("dataConsulta", new Date().minus(Integer.parseInt(params.vencimento)).clearTime())
            }
            and{
                eq("data", new Date().parse("yyyy-MM-dd",params.dataViagem).clearTime())
            }

            order("data","asc")
            projections{
                groupProperty("dataConsulta","data")

                property("origem","origem")
                property("destino","destino")
                property("empresa","empresa")
                avg("preco","media")
                max("preco","maximo")
                min("preco","minimo")
            }
        }

        println queryTAM.toString()

        def datasTAM1 = new ArrayList()
        def precosTAM1 = new ArrayList()
        def precosMinTAM1 = new ArrayList()
        def precosMaxTAM1 = new ArrayList()
        queryTAM.each {
            datasTAM1.add(it.getAt(0).toString().substring(5,10))
            precosTAM1.add(it.getAt(4))
            precosMaxTAM1.add(it.getAt(5))
            precosMinTAM1.add(it.getAt(6))
        }

        def GOLCriteria = Precos.createCriteria()
        def queryGOL = GOLCriteria.list{
            eq("empresa","GOL")
            and{
                or{
                    eq("origem",params.iata_code)
                    eq("destino",params.iata_code)
                }

            }
            and{
                ge("dataConsulta",  new Date().minus(Integer.parseInt(params.vencimento)).clearTime())
            }
            and{
                eq("data", new Date().parse("yyyy-MM-dd",params.dataViagem).clearTime())
            }

            order("data","asc")
            projections{
                groupProperty("dataConsulta","data")

                property("origem","origem")
                property("destino","destino")
                property("empresa","empresa")
                avg("preco","media")
                max("preco","maximo")
                min("preco","minimo")
            }
        }


        def datasGOL1 = new ArrayList()
        def precosGOL1 = new ArrayList()
        def precosMinGOL1 = new ArrayList()
        def precosMaxGOL1 = new ArrayList()
        queryGOL.each {
            datasGOL1.add(it.getAt(0).toString().substring(5,10))
            precosGOL1.add(it.getAt(4))
            precosMaxGOL1.add(it.getAt(5))
            precosMinGOL1.add(it.getAt(6))
        }


        def eixoX1 = datasTAM1 as JSON
        def yTAM1 = precosTAM1 as JSON
        def yGOL1 = precosGOL1 as JSON

        String titulo1 = "\"Precos para o dia " + params.dataViagem + " de/para " + params.iata_code +" - TAM\""

        def eixoX2 = datasGOL1 as JSON
        def yTAM2 = precosMinTAM1 as JSON
        def yGOL2 = precosMinGOL1 as JSON
        String titulo2 = "\"Precos para o dia " + params.dataViagem + " de/para " + params.iata_code +" - GOL\""

        def yTAM3 = precosMaxTAM1 as JSON
        def yGOL3 = precosMaxGOL1 as JSON

        render(view:"grafico",model:[grafico1:"IDA",titulo1:titulo1,eixoX1:eixoX1,yTAM1:yTAM1,yGOL1:yGOL1,grafico2:"VOLTA"
                                     ,titulo2:titulo2,eixoX2:eixoX2,yTAM2:yTAM2,yGOL2:yGOL2,yTAM3:yTAM3,yGOL3:yGOL3])
    }
    def indexGrafico(){
        println params
        render(view:"indexGrafico")
    }
}
