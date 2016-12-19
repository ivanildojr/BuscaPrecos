package buscaprecos

class AgendaConsulta {

    Date horaConsulta //= new Date().getTimeString()
    String origem
    String destino
    Date dataIda
    Date dataVolta
    Integer adultos
    Integer criancas


    static constraints = {
        origem nullable: false, inList: ["NAT","YYZ"]
        destino nullable: false, inList: ["YYZ","NAT"]
        dataIda nullable: false
        dataVolta nullable: false
        adultos nullable: false
        criancas nullable: false
        horaConsulta nullable: false
    }
}
