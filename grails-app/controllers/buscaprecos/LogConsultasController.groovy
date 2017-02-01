package buscaprecos

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LogConsultasController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LogConsultas.list(params), model:[logConsultasCount: LogConsultas.count()]
    }

    def show(LogConsultas logConsultas) {
        respond logConsultas
    }

    def create() {
        respond new LogConsultas(params)
    }

    @Transactional
    def save(LogConsultas logConsultas) {
        if (logConsultas == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (logConsultas.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond logConsultas.errors, view:'create'
            return
        }

        logConsultas.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'logConsultas.label', default: 'LogConsultas'), logConsultas.id])
                redirect logConsultas
            }
            '*' { respond logConsultas, [status: CREATED] }
        }
    }

    def edit(LogConsultas logConsultas) {
        respond logConsultas
    }

    @Transactional
    def update(LogConsultas logConsultas) {
        if (logConsultas == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (logConsultas.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond logConsultas.errors, view:'edit'
            return
        }

        logConsultas.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'logConsultas.label', default: 'LogConsultas'), logConsultas.id])
                redirect logConsultas
            }
            '*'{ respond logConsultas, [status: OK] }
        }
    }

    @Transactional
    def delete(LogConsultas logConsultas) {

        if (logConsultas == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        logConsultas.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'logConsultas.label', default: 'LogConsultas'), logConsultas.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'logConsultas.label', default: 'LogConsultas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
