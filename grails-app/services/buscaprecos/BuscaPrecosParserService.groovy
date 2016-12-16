package buscaprecos

import grails.transaction.Transactional
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

import java.text.NumberFormat

@Transactional
class BuscaPrecosParserService {

    def precosIda(String precos,String origem, String destino, String dataIda){
        /*Obtem os precos de ida*/
        Document doc = Jsoup.parse(precos);
        Element ida = doc.getElementById("outbound_list_flight");
        Elements idas = ida.getElementsByAttributeValue("data-cell-fare-family","ACJJLANA");

        Document doc2 = Jsoup.parseBodyFragment(idas.toString());
        Elements valor = doc2.getElementsByTag("strong");


        List<Precos> lista = new ArrayList();

        for(int i =0; i<valor.size();i++) {
            Precos preco = new Precos();

            NumberFormat format = NumberFormat.getInstance(Locale.US)
            Number numero = format.parse(valor?.get(i).text())
            preco.preco = numero.doubleValue()

            preco.tipo = "IDA"
            String dataFormatada = Date.parse("yyyyMMddHHmm",dataIda).format("dd/MM/yyyy")
            Date dataFinal = Date.parse("dd/MM/yyyy",dataFormatada)

            preco.data = dataFinal
            preco.origem = origem
            preco.destino = destino
            preco.dataConsulta = new Date().clearTime()
            preco.save(flush:true)
            lista.add(preco);
        }


        return lista;
    }

    def precosVolta(String precos,String origem, String destino, String dataIda){
        /*Obtem os precos de volta*/
        Document doc = Jsoup.parse(precos);
        Element volta = doc.getElementById("inbound_list_flight");
        Elements voltas = volta.getElementsByAttributeValue("data-cell-fare-family","ACJJLANA");

        Document doc2 = Jsoup.parseBodyFragment(voltas.toString());
        Elements valor = doc2.getElementsByTag("strong");

        List<Precos> lista = new ArrayList();

        for(int i =0; i<valor.size();i++) {
            Precos preco = new Precos();

            NumberFormat format = NumberFormat.getInstance(Locale.US)
            Number numero = format.parse(valor?.get(i).text())
            preco.preco = numero.doubleValue()

            preco.tipo = "VOLTA"
            String dataFormatada = Date.parse("yyyyMMddHHmm",dataIda).format("dd/MM/yyyy")
            Date dataFinal = Date.parse("dd/MM/yyyy",dataFormatada)

            preco.data = dataFinal
            preco.origem = origem
            preco.destino = destino
            preco.dataConsulta = new Date().clearTime()
            preco.save(flush:true)
            lista.add(preco);
        }


        return lista;





    }

}
