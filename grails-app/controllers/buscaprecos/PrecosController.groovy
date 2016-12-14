package buscaprecos

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

    def buscaPrecos

    def buscaCotacoes(){
        String tabela = buscaPrecos.busca()

        render(view:"resultado",model:[tabela:tabela])
    }
}
