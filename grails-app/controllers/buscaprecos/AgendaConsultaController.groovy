package buscaprecos

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AgendaConsultaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AgendaConsulta.list(params), model:[agendaConsultaCount: AgendaConsulta.count()]
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
