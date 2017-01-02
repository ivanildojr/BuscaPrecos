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
        def precosTAM1 = Precos.findAllByOrigemAndDestinoAndEmpresaAndData("NAT","YYZ","TAM",Date.parse("yyyy-MM-dd","2017-09-08"))
        def precosGOL1 = Precos.findAllByOrigemAndDestinoAndEmpresaAndData("NAT","YYZ","GOL",Date.parse("yyyy-MM-dd","2017-09-08"))
        def precosTAM2 = Precos.findAllByOrigemAndDestinoAndEmpresaAndData("YYZ","NAT","TAM",Date.parse("yyyy-MM-dd","2017-10-18"))
        def precosGOL2 = Precos.findAllByOrigemAndDestinoAndEmpresaAndData("YYZ","NAT","GOL",Date.parse("yyyy-MM-dd","2017-10-18"))


//        def listaTAM1 = new ArrayList()
//        def index = 0
//        precosTAM1.each {
//            if(it.first()){
//                listaTAM1.add(it)
//            }else{
//                if(it.preco < listaTAM1.get(index).preco){
//                    listaTAM1.remove(index)
//                }
//            }
//        }

        def eixoX1 = precosGOL1.dataConsulta as JSON
        def yTAM1 = precosTAM1.preco as JSON
        def yGOL1 = precosGOL1.preco as JSON
//        String titulo1 = "\"Preços de " + precosTAM1.get(0).tipo + " de " + precosTAM1.get(0).origem + " para " + precosTAM1.get(0).destino + "\""
        String titulo1 = "\"Preços TAM  de " + precosTAM1.get(0).origem + "(" + precosTAM1.get(0).data.clearTime() + ")"  + " para " + precosTAM1.get(0).destino + "(" + precosTAM2.get(0).data.clearTime() + ")"  + "\""

        def eixoX2 = precosGOL2.dataConsulta as JSON
        def yTAM2 = precosTAM2.preco as JSON
        def yGOL2 = precosGOL2.preco as JSON
//        String titulo2 = "\"Preços de " + precosTAM2.get(0).tipo + " de " + precosTAM2.get(0).origem + " para " + precosTAM2.get(0).destino + "\""
        String titulo2 = "\"Preços de GOL de " + precosGOL1.get(0).origem + "(" + precosGOL1.get(0).data.clearTime() + ")" + " para " + precosGOL1.get(0).destino+ "(" + precosGOL2.get(0).data.clearTime() + ")"  + "\""

        render(view:"grafico",model:[grafico1:"IDA",titulo1:titulo1,eixoX1:eixoX1,yTAM1:yTAM1,yGOL1:yGOL1,grafico2:"VOLTA"
                                     ,titulo2:titulo2,eixoX2:eixoX2,yTAM2:yTAM2,yGOL2:yGOL2])
    }
}
