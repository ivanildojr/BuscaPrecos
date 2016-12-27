package buscaprecos

class AgendaConsulta {

    Date horaConsulta //= new Date().getTimeString()
    String origem
    String destino
    Date dataIda
    Date dataVolta
    Integer adultos
    Integer criancas
    Integer duracao
    Date dataLimiteSaida
    Boolean jobRodando = false


    static constraints = {
        origem nullable: false//, inList: ["NAT","YYZ"]
        destino nullable: false//, inList: ["YYZ","NAT"]
        dataIda nullable: false
        dataVolta nullable: false
        adultos nullable: false
        criancas nullable: false
        horaConsulta nullable: false
        jobRodando nullable:  false
        duracao nullable: false
        dataLimiteSaida nullable: false
    }
}
