package buscaprecos

class Precos {

    String tipo
    Double preco
    Date data
    String origem
    String destino
    Date dataConsulta



    static constraints = {
        tipo nullable: false, inList: ["IDA","VOLTA"]
    }

    String toString(){
        return tipo + ' ' + preco + ' ' + data + ' ' + origem + ' ' + destino + ' '+ dataConsulta
    }
}
