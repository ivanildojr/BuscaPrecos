package buscaprecos

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import groovy.json.JsonSlurper

import java.nio.file.Paths

@Transactional(readOnly = true)
class AirportCodesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def code(){
	        JsonSlurper slurper = new JsonSlurper()
        def game
        File f = new File("C:\\Users\\ivanildo.junior\\Downloads\\airport-codes.json")
        f.withReader { reader ->
            game = slurper.parse(reader)
        }

        game.each {
            if(it.iata_code){
                AirportCodes  codigos = new AirportCodes()
                codigos.continent = it.continent
                codigos.elevation_ft = it.elevation_ft
                codigos.gps_code = it.gps_code
                codigos.iata_code = it.iata_code
                codigos.ident = it.ident
                codigos.iso_country = it.iso_country
                codigos.iso_region = it.iso_region
                codigos.latitude_deg = it.latitude_deg
                codigos.local_code = it.local_code
                codigos.longitude_deg = it.longitude_deg
                codigos.municipality = it.municipality
                codigos.name = it.name
                codigos.type_airport = it.type_airport
                codigos.save(flush: true, failOnError: true);
                println codigos.toString()
            }else{
                println "iataCodeVazio"
            }

        }
	}
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AirportCodes.list(params), model:[airportCodesCount: AirportCodes.count()]
    }

    def show(AirportCodes airportCodes) {
        respond airportCodes
    }

    def create() {
        respond new AirportCodes(params)
    }

    @Transactional
    def save(AirportCodes airportCodes) {
        if (airportCodes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (airportCodes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond airportCodes.errors, view:'create'
            return
        }

        airportCodes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'airportCodes.label', default: 'AirportCodes'), airportCodes.id])
                redirect airportCodes
            }
            '*' { respond airportCodes, [status: CREATED] }
        }
    }

    def edit(AirportCodes airportCodes) {
        respond airportCodes
    }

    @Transactional
    def update(AirportCodes airportCodes) {
        if (airportCodes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (airportCodes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond airportCodes.errors, view:'edit'
            return
        }

        airportCodes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'airportCodes.label', default: 'AirportCodes'), airportCodes.id])
                redirect airportCodes
            }
            '*'{ respond airportCodes, [status: OK] }
        }
    }

    @Transactional
    def delete(AirportCodes airportCodes) {

        if (airportCodes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        airportCodes.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'airportCodes.label', default: 'AirportCodes'), airportCodes.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'airportCodes.label', default: 'AirportCodes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
