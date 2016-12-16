package buscaprecos

class AgendaConsulta {

    String horaConsulta
    String origem
    String destino
    Date dataIda
    Date dataVolta
    Integer duracao


    static constraints = {
        horaConsulta nullable: false
        origem nullable: false, inList: ["NAT","YYZ"]
        destino nullable: false, inList: ["YYZ","NAT"]
        dataIda nullable: false
        dataVolta nullable: false
        duracao nullable: false
    }
}
