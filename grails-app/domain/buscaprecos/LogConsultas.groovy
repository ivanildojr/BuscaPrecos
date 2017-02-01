package buscaprecos

class LogConsultas {

    String consulta
    String empresa
    Date dataConsulta


    static constraints = {
        consulta nullable: true
        empresa nullable: false
        dataConsulta nullable: false
    }
}
