package buscaprecos

import grails.transaction.Transactional
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.springframework.scheduling.annotation.Scheduled

import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException

@Transactional
class BuscaPrecosParserService {
    def precosIdaGOL(String precos, String origem, String destino, String dataIda){
        Document doc = Jsoup.parse(precos)

//        println "GOL Ida: " + doc.toString()

        Element ida = doc.getElementById("ida");
        Document docIda = Jsoup.parse( ida.toString());
        Elements idas = docIda.getElementsByClass("taxaPromocional")
        if(idas.size()==0) idas = docIda.getElementsByClass("taxaProgramada")
        if(idas.size()==0) idas = docIda.getElementsByClass("taxaFlexivel")
        List<Precos> lista = new ArrayList();
        if(idas){
                idas.each {
                    Document docIdas = Jsoup.parse(it.toString())
                    Elements p = docIdas.getElementsByClass("fareValue")
                    p.eachWithIndex { item, index ->
                        Precos preco = new Precos();


                        String numero = item.text().replaceAll("[R\$]","").replaceAll("[.]","").replaceAll("[,]",".").replace("\u00A0","").trim()

                        preco.preco = numero.toDouble()
                        preco.tipo = "IDA"
                        String dataFormatada = Date.parse("ddMMyyyy",dataIda).format("dd/MM/yyyy")
                        Date dataFinal = Date.parse("dd/MM/yyyy",dataFormatada)

                        preco.data = dataFinal
                        preco.origem = origem
                        preco.destino = destino
                        preco.dataConsulta = new Date()
                        preco.empresa = "GOL"
                        preco.save(flush:true)
                        lista.add(preco);
                    }
                }
        }else{
            Precos preco = new Precos();

            preco.preco = 0;

            preco.tipo = "IDA"
            String dataFormatada = Date.parse("ddMMyyyy", dataIda).format("dd/MM/yyyy")
            Date dataFinal = Date.parse("dd/MM/yyyy", dataFormatada)

            preco.data = dataFinal
            preco.origem = origem
            preco.destino = destino
            preco.dataConsulta = new Date()
            preco.empresa = "GOL"
            preco.save(flush: true)
            lista.add(preco);
        }

        return lista;

    }

    def precosVoltaGOL(String precos, String origem, String destino, String dataIda){
        Document doc = Jsoup.parse(precos)

//        println "GOL Volta: " + doc.toString()

        Element volta = doc.getElementById("volta");
        Document docVolta = Jsoup.parse( volta.toString());
        Elements voltas = docVolta.getElementsByClass("taxaPromocional")
        if(voltas.size()==0) voltas = docVolta.getElementsByClass("taxaProgramada")
        if(voltas.size()==0) voltas = docVolta.getElementsByClass("taxaFlexivel")
        List<Precos> lista = new ArrayList();
        if(voltas){
            voltas.each {
                Document docVoltas = Jsoup.parse(it.toString())
                Elements p =  docVoltas.getElementsByClass("fareValue")
                p.eachWithIndex { item, index ->
                    Precos preco = new Precos();


                    String numero = item.text().replaceAll("[R\$]","").replaceAll("[.]","").replaceAll("[,]",".").replace("\u00A0","").trim()

                    preco.preco = numero.toDouble()
                    preco.tipo = "VOLTA"
                    String dataFormatada = Date.parse("ddMMyyyy",dataIda).format("dd/MM/yyyy")
                    Date dataFinal = Date.parse("dd/MM/yyyy",dataFormatada)

                    preco.data = dataFinal
                    preco.origem = destino
                    preco.destino = origem
                    preco.dataConsulta = new Date()
                    preco.empresa = "GOL"
                    preco.save(flush:true)
                    lista.add(preco);
                }
            }
        }else{
            Precos preco = new Precos();

            preco.preco = 0;

            preco.tipo = "VOLTA"
            String dataFormatada = Date.parse("ddMMyyyy", dataIda).format("dd/MM/yyyy")
            Date dataFinal = Date.parse("dd/MM/yyyy", dataFormatada)

            preco.data = dataFinal
            preco.origem = destino
            preco.destino = origem
            preco.dataConsulta = new Date()
            preco.empresa = "GOL"
            preco.save(flush: true)
            lista.add(preco);
        }

        return lista;
    }


    def precosIdaTAM(String precos, String origem, String destino, String dataIda){
        /*Obtem os precos de ida*/
        Document doc = Jsoup.parse(precos);
        Element ida = doc.getElementById("outbound_list_flight");
        Elements idas = ida.getElementsByAttributeValue("data-cell-fare-family","ACJJLANA");
        if(idas.size()==0) idas = ida.getElementsByAttributeValue("data-cell-fare-family","NOVOBASICO");
        if(idas.size()==0) idas = ida.getElementsByAttributeValue("data-cell-fare-family","NOVOFLEX");
        Document doc2 = Jsoup.parseBodyFragment(idas.toString());
        Elements valor = doc2.getElementsByTag("strong");
        if(valor.size()==0) valor = doc2.getElementsByClass("price");

        println "Preco Ida: " + valor.toString()

        List<Precos> lista = new ArrayList();

        if(valor){
            for(int i =0; i<valor.size();i++) {
                Precos preco = new Precos();


//                NumberFormat format = NumberFormat.getInstance(Locale.US)
//                Number numero = format.parse(valor?.get(i).text())
                String precoIda =  valor?.get(i).text().replaceAll("[.]","").replaceAll("[,]",".")
//                preco.preco = numero.doubleValue()
                preco.preco = precoIda.toDouble()


                preco.tipo = "IDA"
                String dataFormatada = Date.parse("yyyyMMddHHmm",dataIda).format("dd/MM/yyyy")
                Date dataFinal = Date.parse("dd/MM/yyyy",dataFormatada)

                preco.data = dataFinal
                preco.origem = origem
                preco.destino = destino
                preco.dataConsulta = new Date()
                preco.empresa = "TAM"
                preco.save(flush:true)
                lista.add(preco);
            }
        }else{
            Precos preco = new Precos();

            preco.preco = 0;

            preco.tipo = "IDA"
            String dataFormatada = Date.parse("yyyyMMddHHmm", dataIda).format("dd/MM/yyyy")
            Date dataFinal = Date.parse("dd/MM/yyyy", dataFormatada)

            preco.data = dataFinal
            preco.origem = origem
            preco.destino = destino
            preco.dataConsulta = new Date()
            preco.empresa = "TAM"
            preco.save(flush: true)
            lista.add(preco);
        }

        return lista;
    }

    def precosVoltaTAM(String precos, String origem, String destino, String dataIda){
        /*Obtem os precos de volta*/
        Document doc = Jsoup.parse(precos);
        Element volta = doc.getElementById("inbound_list_flight");
        Elements voltas = volta.getElementsByAttributeValue("data-cell-fare-family","ACJJLANA");
        if(voltas.size()==0) voltas = volta.getElementsByAttributeValue("data-cell-fare-family","NOVOBASICO");
        if(voltas.size()==0) voltas = volta.getElementsByAttributeValue("data-cell-fare-family","NOVOFLEX");


        Document doc2 = Jsoup.parseBodyFragment(voltas.toString());
        Elements valor = doc2.getElementsByTag("strong");
        if(valor.size()==0) valor = doc2.getElementsByClass("price");
//        println "TAM Volta: " + doc.toString()

        List<Precos> lista = new ArrayList();

        if(valor) {

            for (int i = 0; i < valor.size(); i++) {
                Precos preco = new Precos();

//                NumberFormat format = NumberFormat.getInstance(Locale.US)
//                Number numero = format.parse(valor?.get(i).text())
                String precoIda =  valor?.get(i).text().replaceAll("[.]","").replaceAll("[,]",".")
//                preco.preco = numero.doubleValue()
                preco.preco = precoIda.toDouble()

                preco.tipo = "VOLTA"
                String dataFormatada = Date.parse("yyyyMMddHHmm", dataIda).format("dd/MM/yyyy")
                Date dataFinal = Date.parse("dd/MM/yyyy", dataFormatada)

                preco.data = dataFinal
                preco.origem = destino
                preco.destino = origem
                preco.dataConsulta = new Date()
                preco.empresa = "TAM"
                preco.save(flush: true)
                lista.add(preco);
            }
        }else{
            Precos preco = new Precos();

            preco.preco = 0;

            preco.tipo = "VOLTA"
            String dataFormatada = Date.parse("yyyyMMddHHmm", dataIda).format("dd/MM/yyyy")
            Date dataFinal = Date.parse("dd/MM/yyyy", dataFormatada)

            preco.data = dataFinal
            preco.origem = destino
            preco.destino = origem
            preco.dataConsulta = new Date()
            preco.empresa = "TAM"
            preco.save(flush: true)
            lista.add(preco);
        }

        return lista;





    }

}
