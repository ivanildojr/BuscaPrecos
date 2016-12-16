import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by ivanildo.junior on 14/12/2016.
 */
public class BuscaPrecos {
    public String busca(String origem, String destino, String dataIda, String dataVolta, String qtdeAdultos, String qtdeCriancas) {
        String url = "https://book.latam.com/TAM/dyn/air/booking/upslDispatcher?"
                + "B_LOCATION_1="+origem
                + "&"
                + "E_LOCATION_1="+destino
                + "&"
                + "TRIP_TYPE=R"
                + "&"
                + "B_DATE_1="+dataIda//201709120000
                + "&"
                + "B_DATE_2="+dataVolta//201710100000
                + "&"
                + "adults="+qtdeAdultos
                + "&"
                + "children="+qtdeCriancas
                + "&"
                + "infants=0"
                + "&"
                + "LANGUAGE=BR"
                + "&"
                + "SITE=JJBKJJBK"
                + "&"
                + "WDS_MARKET=BR"
                + "&"
                + "MARKETING_CABIN=E";

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\ivanildo.junior\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//
//
//        WebDriver ghostDriver = new PhantomJSDriver(caps);
//
//        Element ida = null,volta=null;
//        try {
//            ghostDriver.get(url);
//            Document doc = null;
//            doc = Jsoup.parse(ghostDriver.getPageSource());
//            ida = doc.getElementById("outbound_list_flight");
//            volta = doc.getElementById("inbound_list_flight");
//            System.out.println("<html><head></head><body>");
//            System.out.println(ida.toString());
//            System.out.println(volta.toString());
//            System.out.println("</body></html>");
//        } catch (NullPointerException n){
//            System.out.println("Document igual a null");
//        } finally {
//            ghostDriver.quit();
//        }
//
//        return ida.toString()+volta.toString();





        String tabela = "<table class=\"outbound realTable bound family-nth4 list_flight sticky-enabled toggle plus\" id=\"outbound_list_flight\" style=\"margin: 0px; width: 100%;\"> \n" +
                " <thead> \n" +
                "  <tr class=\"sticky-header-row\"> \n" +
                "   <th class=\"caption right sortable fromTh tbf-col-1\">\n" +
                "    <div class=\"tbf-col-1\"></div><strong>De:</strong><small></small></th> \n" +
                "   <th class=\"caption right sortable toTh tbf-col-2\">\n" +
                "    <div class=\"tbf-col-2\"></div><strong>Para:</strong><small></small></th> \n" +
                "   <th class=\"caption notSortable tbf-col-3 right\">\n" +
                "    <div class=\"tbf-col-3\"></div><strong>Voo:</strong></th> \n" +
                "   <th class=\"caption right sortable bl-ie durationTh tbf-col-4\">\n" +
                "    <div class=\"tbf-col-4\"></div><strong>Duração:</strong><small></small></th> \n" +
                "   <th class=\"family f_ACJJLANA tc right sortable ff-0 f1 tbf-col-5\" data-ff-index=\"0\" data-ff-translatedname=\"BASE\" data-ff-fareconditions=\"<style type=&quot;text/css&quot;>\n" +
                "<!--\n" +
                ".style2 {\n" +
                " color: #FFFFFF;\n" +
                " font-weight: bold;\n" +
                "}\n";
        String tabela2 = "-->\n" +
                "</style>\n" +
                "<table border=&quot;0&quot; cellpadding=&quot;0&quot; cellspacing=&quot;0&quot; style=&quot; background-color: #004d83; border-radius: 10px; border: 3px solid #dddddd;&quot;>\n" +
                "  <tr>\n" +
                "  <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Condições válidas para voos LATAM Airlines Brasil (JJ)<br></strong></span><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Demais voos, consulte a parceira</br></span></div><br></td>\n" +
                "  <tr>\n" +
                "    <td width=&quot;835&quot; colspan=&quot;6&quot; style=&quot; border-top-left-radius: 7px;&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>BASE - CLASSE ECONÔMICA</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REEMBOLSO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não reembolsável</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>US$ 150.00</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO ÁSIA</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Origem Coréia do Sul e Coréia do Norte: US$ 100<br />\n" +
                "      Outras origens Ásia: US$ 150 </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n";
        String tabela3 =
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>PONTOS NO PROGRAMA LATAM FIDELIDADE</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Para saber quantos pontos você vai acumular com sua viagem no Latam Fidelidade, consulte a página\n" +
                "<a href=&quot;http://www.tam.com.br/pt_br/tam-fidelidade/como-ganhar-mais-pontos/pontos-em-voos/&quot; target=&quot;_blank&quot;>Pontos em voos</a>.<br>\n" +
                "\n" +
                "*Pontuação mínima por trecho para EUA: 5000 pontos.<br />\n" +
                "    </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    \n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>SERVIÇOS PRIORITÁRIOS NO AEROPORTO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>FRANQUIA DE BAGAGEM</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>EUA: 2 peças / Europa:2 peças / Am. Sul: 23Kg / Am. Central: 23Kg / Entre EUA e Canadá: 1 peça</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TRANSFER CARRO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  \n" +
                "  <tr> </tr>\n" +
                "</table>\" data-ff-name=\"Nome da marca ainda não definido.\"> \n" +
                "    <div class=\"tbf-col-5\"></div> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <span>BASE</span> \n" +
                "     <small></small> \n" +
                "    </div> <a href=\"#\" title=\"BASE\"></a> </th> \n" +
                "   <th class=\"family f_FLJJLANA tc right sortable ff-1 f2 tbf-col-6\" data-ff-index=\"1\" data-ff-translatedname=\"ACCESS\" data-ff-fareconditions=\"<style type=&quot;text/css&quot;>\n" +
                "<!--\n" +
                ".style2 {\n" +
                " color: #FFFFFF;\n" +
                " font-weight: bold;\n" +
                "}\n" +
                "-->\n" +
                "</style>\n" +
                "<table border=&quot;0&quot; cellpadding=&quot;0&quot; cellspacing=&quot;0&quot; style=&quot; background-color: #004d83; border-radius: 10px; border: 3px solid #dddddd;&quot;>\n" +
                "  <tr>\n" +
                "  <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Condições válidas para voos LATAM Airlines Brasil (JJ)<br></strong></span><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Demais voos, consulte a parceira</br></span></div><br></td>\n" +
                "  </tr>\n" +
                "    <td width=&quot;835&quot; colspan=&quot;6&quot; style=&quot; border-top-left-radius: 7px;&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>CLASSE ECONÔMICA - ACCESS</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REEMBOLSO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não reembolsável<br>\n" +
                " Exceção: Europa a Peru/Equador; US$ 200. Europa a Brasil; US$ 280.</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>US$ 100</span></strong></div></td>\n" +
                "  </tr>\n" +
                "    <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>PONTOS NO PROGRAMA LATAM FIDELIDADE</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Para saber quantos pontos você vai acumular com sua viagem no Latam Fidelidade, consulte a página\n" +
                "<a href=&quot;http://www.tam.com.br/pt_br/tam-fidelidade/como-ganhar-mais-pontos/pontos-em-voos/&quot; target=&quot;_blank&quot;>Pontos em voos</a>.<br>\n" +
                "\n" +
                "*Pontuação mínima por trecho para EUA: 5000 pontos.<br/>\n" +
                "      Voos operados pela LAN - VER PONTUAÇÃO EM FIDELIDADE > COMO ACUMULAR PONTOS<br />\n" +
                "    </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    \n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>SERVIÇOS PRIORITÁRIOS NO AEROPORTO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>FRANQUIA DE BAGAGEM</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>EUA: 2 peças / Europa:2 peças / Am. Sul: 23Kg / Am. Central: 23Kg / Entre EUA e Canadá: 1 peça</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TRANSFER CARRO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  \n" ;
            String tabela4 =
                "  <tr> </tr>\n" +
                "</table>\" data-ff-name=\"Nome da marca ainda não definido.\"> \n" +
                "    <div class=\"tbf-col-6\"></div> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <span>ACCESS</span> \n" +
                "     <small></small> \n" +
                "    </div> <a href=\"#\" title=\"ACCESS\"></a> </th> \n" +
                "   <th class=\"family f_PLJJLANA tc right sortable ff-2 f3 tbf-col-7\" data-ff-index=\"2\" data-ff-translatedname=\"CONTROL\" data-ff-fareconditions=\"<style type=&quot;text/css&quot;>\n" +
                "<!--\n" +
                ".style2 {\n" +
                " color: #FFFFFF;\n" +
                " font-weight: bold;\n" +
                "}\n" +
                "-->\n" +
                "</style>\n" +
                "<table border=&quot;0&quot; cellpadding=&quot;0&quot; cellspacing=&quot;0&quot; style=&quot; background-color: #004d83; border-radius: 10px; border: 3px solid #dddddd;&quot;>\n" +
                "  <tr>\n" +
                "  <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Condições válidas para voos LATAM Airlines Brasil (JJ)<br></strong></span><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Demais voos, consulte a parceira</br></span></div><br></td>\n" +
                "  </tr>\n" +
                "    <td width=&quot;835&quot; colspan=&quot;6&quot; style=&quot; border-top-left-radius: 7px;&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>CONTROL </span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REEMBOLSO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Sem custo </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Sem custo </span></strong></div></td>\n" +
                "  </tr>\n" +
                "    <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>PONTOS NO PROGRAMA LATAM FIDELIDADE</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Para saber quantos pontos você vai acumular com sua viagem no Latam Fidelidade, consulte a página\n" +
                "<a href=&quot;http://www.tam.com.br/pt_br/tam-fidelidade/como-ganhar-mais-pontos/pontos-em-voos/&quot; target=&quot;_blank&quot;>Pontos em voos</a>.<br>\n" +
                "\n" +
                "*Pontuação mínima por trecho para EUA: 5000 pontos.<br />\n" +
                "    </span></strong></div></td>\n" +
                "  </tr>\n" +
                " \n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>SERVIÇOS PRIORITÁRIOS NO AEROPORTO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não Incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>FRANQUIA DE BAGAGEM</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>EUA:2 peças / Europa:2 peças / Am. Sul:23Kg / Am. Central: 23Kg / Entre EUA e Canadá: 1 peça</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TRANSFER CARRO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n";
        String tabela5 =
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr> </tr>\n" +
                "</table>\" data-ff-name=\"Nome da marca ainda não definido.\"> \n" +
                "    <div class=\"tbf-col-7\"></div> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <span>CONTROL</span> \n" +
                "     <small></small> \n" +
                "    </div> <a href=\"#\" title=\"CONTROL\"></a> </th> \n" +
                "   <th class=\"family f_CLJJLANA tc right sortable ff-3 f4 tbf-col-8\" data-ff-index=\"3\" data-ff-translatedname=\"<strong>PREMIUM BUSINESS<br>ACCESS</strong>\" data-ff-fareconditions=\"<style type=&quot;text/css&quot;>\n" +
                "<!--\n" +
                ".style2 {\n" +
                " color: #FFFFFF;\n" +
                " font-weight: bold;<\n" +
                "}\n" +
                "-->\n" +
                "</style>\n" +
                "\n" +
                "\n" +
                "<table border=&quot;0&quot; cellpadding=&quot;0&quot; cellspacing=&quot;0&quot; style=&quot; background-color: #004d83; border-radius: 10px; border: 3px solid #dddddd;&quot;>\n" +
                "  <tr>\n" +
                "  <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Condições válidas para voos LATAM Airlines Brasil (JJ)<br></strong></span><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Demais voos, consulte a parceira</br></span></div><br></td>\n" +
                "  </tr>\n" +
                "    <td width=&quot;835&quot; colspan=&quot;6&quot; style=&quot; border-top-left-radius: 7px;&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>Premium Business Access</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REEMBOLSO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>US$ 320</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>US$ 250</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>PONTOS NO PROGRAMA LATAM FIDELIDADE</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Para saber quantos pontos você vai acumular com sua viagem no Latam Fidelidade, consulte a página\n" +
                "<a href=&quot;http://www.tam.com.br/pt_br/tam-fidelidade/como-ganhar-mais-pontos/pontos-em-voos/&quot; target=&quot;_blank&quot;>Pontos em voos</a>.<br>\n" +
                "\n" +
                "*Pontuação mínima por trecho para EUA: 5000 pontos.<br />\n" +
                "    </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>SERVIÇOS PRIORITÁRIOS NO AEROPORTO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Check-in / Embarque / Bagagem</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>FRANQUIA DE BAGAGEM</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>EUA: 3 peças / Europa: 3 peças / Am. Sul: 43Kg / Entre EUA e Canadá: 3 peças</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TRANSFER CARRO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  \n" +
                "  <tr> </tr>\n" +
                "</table>\" data-ff-name=\"Nome da marca ainda não definido.\"> \n" +
                "    <div class=\"tbf-col-8\"></div> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <span><strong>PREMIUM BUSINESS<br>ACCESS</strong></span> \n" +
                "     <small></small> \n" +
                "    </div> <a href=\"#\" title=\"PREMIUM BUSINESSACCESS\"></a> </th> \n" +
                "   <th class=\"sortable rjsTh hidden-col right\" style=\"\"></th> \n" +
                "  </tr> \n" +
                " </thead> \n" +
                " <tbody class=\"\" data-wdk-toggle-transition=\"none\"> \n" +
                "  <tr class=\"flight flightId-1 flightType-Connection\" data-blocationfull=\"International\" data-departuredate=\"Tue Sep 12 13:41:00 GMT 2017\" data-departuretime=\"1505223660000\" data-departurecitycode=\"NAT\" data-departureairportcode=\"NAT\" data-elocationfull=\"Guarulhos International\" data-arrivaldate=\"Tue Sep 12 17:05:00 GMT 2017\" data-arrivaltime=\"1505235900000\" data-arrivalcitycode=\"SAO\" data-arrivalairportcode=\"GRU\" data-aircraft=\"Airbus Industrie A321\" data-airlinecode=\"JJ\" data-rpduration=\"    12240000   \" data-operatedby=\"JJ\" data-airlinecompany=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=3708&amp;date=20170912\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"JJ3708\" data-number-of-stops=\"0\" data-nextday=\"0\"> \n" +
                "   <td class=\"th rightF bottomF fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1505223660000\"> <strong>13:41</strong> <span class=\"bLocation\" data-hasqtip=\"0\">NAT</span> </td> \n" +
                "   <td class=\"th rightF bottomF toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1505235900000\"> <strong>17:05</strong> <span class=\"eLocation\" data-hasqtip=\"1\">GRU</span> </td> \n" +
                "   <td class=\"th rightF bottomF flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico latam\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"JJ3708\" data-operated-by=\"\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Airbus Industrie A321\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=3708&amp;date=20170912\">JJ3708</a> <small class=\"op block em1 tr\"> </small> </td> \n" +
                "   <td class=\"th bottomF durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"80520000\"> 3:24 </td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-0 ff-ACJJLANA    outBorder tbf-col-5 disabled\" rowspan=\"6\" data-cell-fare-family=\"ACJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"56\" data-cell-flight-id=\"1\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"7362.1\" data-cell-fee-waived=\"\" data-cell-amountreference=\"7.362,10\" data-cell-price-in-reporting-currency=\"7.362,10\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"I\" data-cell-cabin-1=\"Executiva\" data-cell-rbd-2=\"Y\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"IEEEV6GW\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"7362.1\" data-cell-price-chd=\"6994.66\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"7362.1\" data-cell-price-chd-new=\"6994.66\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"80520000\"> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <small class=\"fr\"></small> --- \n" +
                "    </div> </td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-1 ff-FLJJLANA    outBorder tbf-col-6\" rowspan=\"6\" data-cell-fare-family=\"FLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"64\" data-cell-flight-id=\"1\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"10523.44\" data-cell-fee-waived=\"\" data-cell-amountreference=\"10.523,44\" data-cell-price-in-reporting-currency=\"10.523,44\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"V\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"V\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"VLXLE98W\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"10523.44\" data-cell-price-chd=\"9987.17\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"10523.44\" data-cell-price-chd-new=\"9987.17\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"80520000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     2.145,07\n" +
                "    </div></td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-2 ff-PLJJLANA    outBorder tbf-col-7\" rowspan=\"6\" data-cell-fare-family=\"PLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"71\" data-cell-flight-id=\"1\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"11860.8\" data-cell-fee-waived=\"\" data-cell-amountreference=\"11.860,80\" data-cell-price-in-reporting-currency=\"11.860,80\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"K\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"K\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"KLXFXD6W\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"11860.8\" data-cell-price-chd=\"11860.8\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"11860.8\" data-cell-price-chd-new=\"11860.8\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"80520000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     3.482,43\n" +
                "    </div></td> \n" +
                "   <td class=\"f1-brcolor  tc ff index-3 ff-CLJJLANA    outBorder tbf-col-8\" rowspan=\"6\" data-cell-fare-family=\"CLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"72\" data-cell-flight-id=\"1\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"14274.01\" data-cell-fee-waived=\"\" data-cell-amountreference=\"14.274,01\" data-cell-price-in-reporting-currency=\"14.274,01\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"I\" data-cell-cabin-1=\"Executiva\" data-cell-rbd-2=\"Y\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"IEEEV6GW\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"14274.01\" data-cell-price-chd=\"14274.01\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"14274.01\" data-cell-price-chd-new=\"14274.01\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"80520000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     5.895,64\n" +
                "    </div></td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"1\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"stopDuration flightNextSegment\"> \n" +
                "   <td class=\"em1 rightE bottomF caption3\" colspan=\"3\">Tempo em conexão GRU:</td> \n" +
                "   <td class=\"em1 bottomF caption3 tc\">5:25</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flightNextSegment flightType-Connection\" data-blocationfull=\"Guarulhos International\" data-departuredate=\"Tue Sep 12 22:30:00 GMT 2017\" data-departuretime=\"1505255400000\" data-departurecitycode=\"SAO\" data-departureairportcode=\"GRU\" data-elocationfull=\"John F Kennedy International\" data-arrivaldate=\"Wed Sep 13 07:10:00 GMT 2017\" data-arrivaltime=\"1505286600000\" data-arrivalcitycode=\"NYC\" data-arrivalairportcode=\"JFK\" data-aircraft=\"Boeing 777-300\" data-airlinecode=\"JJ\" data-rpduration=\"    34800000   \" data-operatedby=\"JJ\" data-airlinecompany=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=8080&amp;date=20170912\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"JJ8080\" data-number-of-stops=\"0\" data-nextday=\"1\"> \n" +
                "   <td class=\"th rightF bottomF fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1505255400000\"> <strong>22:30</strong> <span class=\"bLocation\" data-hasqtip=\"2\">GRU</span> </td> \n" +
                "   <td class=\"th rightF bottomF toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1505286600000\"> <strong>07:10</strong> <span class=\"eLocation\" data-hasqtip=\"3\">JFK</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF bottomF flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico latam\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"JJ8080\" data-operated-by=\"\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Boeing 777-300\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=8080&amp;date=20170912\">JJ8080</a> <small class=\"op block em1 tr\"> </small> </td> \n" +
                "   <td class=\"th bottomF durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"80520000\"> 9:40 </td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"1\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"stopDuration flightNextSegment\"> \n" +
                "   <td class=\"em1 rightE bottomF caption3\" colspan=\"3\">Tempo em conexão JFK:</td> \n" +
                "   <td class=\"em1 bottomF caption3 tc\">2:15</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flightNextSegment flightType-Connection\" data-blocationfull=\"John F Kennedy International\" data-departuredate=\"Wed Sep 13 09:25:00 GMT 2017\" data-departuretime=\"1505294700000\" data-departurecitycode=\"NYC\" data-departureairportcode=\"JFK\" data-elocationfull=\"Lester B. Pearson Internacional\" data-arrivaldate=\"Wed Sep 13 11:03:00 GMT 2017\" data-arrivaltime=\"1505300580000\" data-arrivalcitycode=\"YTO\" data-arrivalairportcode=\"YYZ\" data-aircraft=\"Embraer RJ145\" data-airlinecode=\"AA\" data-rpduration=\"    5880000   \" data-operatedby=\"ONEWORLD_ALLIANCE\" data-operatedbyairlinename=\"TRANS STATES AS AMERICAN EAGLE\" data-airlinecompany=\"TRANS STATES AS AMERICAN EAGLE\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=AA&amp;flightNumber=4338&amp;date=20170913\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"AA4338\" data-number-of-stops=\"0\" data-nextday=\"0\"> \n" +
                "   <td class=\"th rightF  fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1505294700000\"> <strong>09:25</strong> <span class=\"bLocation\" data-hasqtip=\"4\">JFK</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF  toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1505300580000\"> <strong>11:03</strong> <span class=\"eLocation\" data-hasqtip=\"5\">YYZ</span> </td> \n" +
                "   <td class=\"th rightF  flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico oneworld\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"AA4338\" data-operated-by=\"TRANS STATES AS AMERICAN EAGLE\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Embraer RJ145\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"TRANS STATES AS AMERICAN EAGLE\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=AA&amp;flightNumber=4338&amp;date=20170913\">AA4338</a> <small class=\"op block em1 tr\"> <small><strong>Operado por:</strong>&nbsp;TRANS STATES AS AMERICAN EAGLE</small> </small> </td> \n" +
                "   <td class=\"th  durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"80520000\"> 1:38 </td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"1\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"totalDurationRow flightNextSegment\"> \n" +
                "   <td class=\"topF caption3 rightE caption3\" colspan=\"3\">Duração total da viagem</td> \n" +
                "   <td class=\"topF durationTh caption3 tc\">22:22</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"blankRow tbl-spacer\"> \n" +
                "   <td colspan=\"8\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flight flightId-0 flightType-Connection\" data-blocationfull=\"International\" data-departuredate=\"Tue Sep 12 22:55:00 GMT 2017\" data-departuretime=\"1505256900000\" data-departurecitycode=\"NAT\" data-departureairportcode=\"NAT\" data-elocationfull=\"Guarulhos International\" data-arrivaldate=\"Wed Sep 13 02:20:00 GMT 2017\" data-arrivaltime=\"1505269200000\" data-arrivalcitycode=\"SAO\" data-arrivalairportcode=\"GRU\" data-aircraft=\"Airbus Industrie A321\" data-airlinecode=\"JJ\" data-rpduration=\"    12300000   \" data-operatedby=\"JJ\" data-airlinecompany=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=3307&amp;date=20170912\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"JJ3307\" data-number-of-stops=\"0\" data-nextday=\"1\"> \n" +
                "   <td class=\"th rightF bottomF fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1505256900000\"> <strong>22:55</strong> <span class=\"bLocation\" data-hasqtip=\"6\">NAT</span> </td> \n" +
                "   <td class=\"th rightF bottomF toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1505269200000\"> <strong>02:20</strong> <span class=\"eLocation\" data-hasqtip=\"7\">GRU</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF bottomF flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico latam\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"JJ3307\" data-operated-by=\"\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Airbus Industrie A321\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=3307&amp;date=20170912\">JJ3307</a> <small class=\"op block em1 tr\"> </small> </td> \n" +
                "   <td class=\"th bottomF durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"91800000\"> 3:25 </td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-0 ff-ACJJLANA    outBorder tbf-col-5 lowest selectedFF em3 family1\" rowspan=\"6\" data-cell-fare-family=\"ACJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"63\" data-cell-flight-id=\"0\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"9844.83\" data-cell-fee-waived=\"\" data-cell-amountreference=\"9.844,83\" data-cell-price-in-reporting-currency=\"9.844,83\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"O\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"O\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"OEESP96W\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"9844.83\" data-cell-price-chd=\"9477.38\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"9844.83\" data-cell-price-chd-new=\"9477.38\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"91800000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <small class=\"fr\"><small class=\"ico cheap\"></small></small>\n" +
                "     <strong>1.466,46</strong>\n" +
                "    </div></td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-1 ff-FLJJLANA    outBorder tbf-col-6\" rowspan=\"6\" data-cell-fare-family=\"FLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"64\" data-cell-flight-id=\"0\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"10523.44\" data-cell-fee-waived=\"\" data-cell-amountreference=\"10.523,44\" data-cell-price-in-reporting-currency=\"10.523,44\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"V\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"V\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"VLXLE98W\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"10523.44\" data-cell-price-chd=\"9987.17\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"10523.44\" data-cell-price-chd-new=\"9987.17\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"91800000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     2.145,07\n" +
                "    </div></td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-2 ff-PLJJLANA    outBorder tbf-col-7\" rowspan=\"6\" data-cell-fare-family=\"PLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"71\" data-cell-flight-id=\"0\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"11860.8\" data-cell-fee-waived=\"\" data-cell-amountreference=\"11.860,80\" data-cell-price-in-reporting-currency=\"11.860,80\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"K\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"K\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"KLXFXD6W\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"11860.8\" data-cell-price-chd=\"11860.8\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"11860.8\" data-cell-price-chd-new=\"11860.8\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"91800000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     3.482,43\n" +
                "    </div></td> \n" +
                "   <td class=\"f1-brcolor  tc ff index-3 ff-CLJJLANA    outBorder tbf-col-8\" rowspan=\"6\" data-cell-fare-family=\"CLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"73\" data-cell-flight-id=\"0\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"14274.01\" data-cell-fee-waived=\"\" data-cell-amountreference=\"14.274,01\" data-cell-price-in-reporting-currency=\"14.274,01\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"I\" data-cell-cabin-1=\"Executiva\" data-cell-rbd-2=\"I\" data-cell-cabin-2=\"Executiva\" data-cell-fareclass=\"IEEEV6GW\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"14274.01\" data-cell-price-chd=\"14274.01\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"14274.01\" data-cell-price-chd-new=\"14274.01\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"91800000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     5.895,64\n" +
                "    </div></td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"2\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"stopDuration flightNextSegment\"> \n" +
                "   <td class=\"em1 rightE bottomF caption3\" colspan=\"3\">Tempo em conexão GRU:</td> \n" +
                "   <td class=\"em1 bottomF caption3 tc\">8:15</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flightNextSegment flightType-Connection\" data-blocationfull=\"Guarulhos International\" data-departuredate=\"Wed Sep 13 10:35:00 GMT 2017\" data-departuretime=\"1505298900000\" data-departurecitycode=\"SAO\" data-departureairportcode=\"GRU\" data-elocationfull=\"Miami Internacional\" data-arrivaldate=\"Wed Sep 13 17:50:00 GMT 2017\" data-arrivaltime=\"1505325000000\" data-arrivalcitycode=\"MIA\" data-arrivalairportcode=\"MIA\" data-aircraft=\"Airbus Industrie A350\" data-airlinecode=\"JJ\" data-rpduration=\"    29700000   \" data-operatedby=\"JJ\" data-airlinecompany=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=8094&amp;date=20170913\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"JJ8094\" data-number-of-stops=\"0\" data-nextday=\"0\"> \n" +
                "   <td class=\"th rightF bottomF fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1505298900000\"> <strong>10:35</strong> <span class=\"bLocation\" data-hasqtip=\"8\">GRU</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF bottomF toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1505325000000\"> <strong>17:50</strong> <span class=\"eLocation\" data-hasqtip=\"9\">MIA</span> </td> \n" +
                "   <td class=\"th rightF bottomF flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico latam\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"JJ8094\" data-operated-by=\"\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Airbus Industrie A350\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=8094&amp;date=20170913\">JJ8094</a> <small class=\"op block em1 tr\"> </small> </td> \n" +
                "   <td class=\"th bottomF durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"91800000\"> 8:15 </td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"2\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"stopDuration flightNextSegment\"> \n" +
                "   <td class=\"em1 rightE bottomF caption3\" colspan=\"3\">Tempo em conexão MIA:</td> \n" +
                "   <td class=\"em1 bottomF caption3 tc\">2:15</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flightNextSegment flightType-Connection\" data-blocationfull=\"Miami Internacional\" data-departuredate=\"Wed Sep 13 20:05:00 GMT 2017\" data-departuretime=\"1505333100000\" data-departurecitycode=\"MIA\" data-departureairportcode=\"MIA\" data-elocationfull=\"Lester B. Pearson Internacional\" data-arrivaldate=\"Wed Sep 13 23:25:00 GMT 2017\" data-arrivaltime=\"1505345100000\" data-arrivalcitycode=\"YTO\" data-arrivalairportcode=\"YYZ\" data-aircraft=\"Airbus Industrie A320\" data-airlinecode=\"AA\" data-rpduration=\"    12000000   \" data-operatedby=\"ONEWORLD_ALLIANCE\" data-operatedbyairlinename=\"American Airlines\" data-airlinecompany=\"American Airlines\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=AA&amp;flightNumber=0403&amp;date=20170913\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"AA0403\" data-number-of-stops=\"0\" data-nextday=\"0\"> \n" +
                "   <td class=\"th rightF  fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1505333100000\"> <strong>20:05</strong> <span class=\"bLocation\" data-hasqtip=\"10\">MIA</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF  toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1505345100000\"> <strong>23:25</strong> <span class=\"eLocation\" data-hasqtip=\"11\">YYZ</span> </td> \n" +
                "   <td class=\"th rightF  flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico oneworld\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"AA0403\" data-operated-by=\"American Airlines\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Airbus Industrie A320\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"American Airlines\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=AA&amp;flightNumber=0403&amp;date=20170913\">AA0403</a> <small class=\"op block em1 tr\"> <small><strong>Operado por:</strong>&nbsp;American Airlines</small> </small> </td> \n" +
                "   <td class=\"th  durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"91800000\"> 3:20 </td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"2\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"totalDurationRow flightNextSegment\"> \n" +
                "   <td class=\"topF caption3 rightE caption3\" colspan=\"3\">Duração total da viagem</td> \n" +
                "   <td class=\"topF durationTh caption3 tc\">25:30</td> \n" +
                "  </tr>\n" +
                "  <tr class=\"details dotted  first  border \">\n" +
                "   <td class=\"rowspan\" rowspan=\"4\" colspan=\"2\"><button class=\"short block wrap seatMap\"><small class=\"fl ico gseat\"></small><span>Mapa de assentos</span></button><button class=\"short block br wrap compareFare\"><small class=\"fl ico zoom\"></small><span>Compare Tarifas</span></button><button class=\"short block br wrap legalNotice\"><small class=\"fl ico book\"></small>*Regras</button></td>\n" +
                "   <td class=\"right  ffamilyr1\" colspan=\"2\"><img alt=\"\" class=\"fl\" src=\"https://book.latam.com/TAM/cui-tam_30.126_281116/air/skin/tam/desktopLATAM/img/benefits/tamLogo.png\">&nbsp;<strong class=\"fl grid2-2\">Acúmulo LATAM Fidelidade*&nbsp;</strong></td>\n" +
                "   <td class=\"tc  ffamilyr1\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     100% da distância\n" +
                "    </div></td>\n" +
                "   <td class=\"tc cfamily2\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     125% da distância\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     150% da distância\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     200% da distância\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details dotted  border \">\n" +
                "   <td class=\"right  ffamilyr1\" colspan=\"2\"><img alt=\"\" class=\"fl\" src=\"https://book.latam.com/TAM/cui-tam_30.126_281116/air/skin/tam/desktopLATAM/img/benefits/plane.png\">&nbsp;<strong class=\"fl grid2-2\">Alteração de voos*&nbsp;</strong></td>\n" +
                "   <td class=\"tc  ffamilyr1\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <span class=\"ico ok\"></span>\n" +
                "     <br>Até US$ 150,00+\n" +
                "    </div></td>\n" +
                "   <td class=\"tc cfamily2\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <span class=\"ico ok\"></span>\n" +
                "     <br>Até US$ 150,00+\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <span class=\"ico ok\"></span>\n" +
                "     <br>Até US$ 100,00+\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <span class=\"ico ok\"></span>\n" +
                "     <br>Sem custo\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details dotted  border \">\n" +
                "   <td class=\"right  ffamilyr1\" colspan=\"2\"><img alt=\"\" class=\"fl\" src=\"https://book.latam.com/TAM/cui-tam_30.126_281116/air/skin/tam/desktopLATAM/img/benefits/luggage.png\">&nbsp;<strong class=\"fl grid2-2\">Franquia de Bagagem*&nbsp;<small class=\"ico info tooltip-link baggageAllowanceLink\"></small></strong></td>\n" +
                "   <td class=\"tc  ffamilyr1\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     2 peças*\n" +
                "    </div></td>\n" +
                "   <td class=\"tc cfamily2\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     2 peças*\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     2 peças*\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     3 peças*\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details dotted  bordert \">\n" +
                "   <td class=\"right  ffamilyr1\" colspan=\"2\"><img alt=\"\" class=\"fl\" src=\"https://book.latam.com/TAM/cui-tam_30.126_281116/air/skin/tam/desktopLATAM/img/benefits/traveller.png\">&nbsp;<strong class=\"fl grid2-2\">Reembolso*&nbsp;</strong></td>\n" +
                "   <td class=\"tc  ffamilyr1 last\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     Não Reembolsável\n" +
                "    </div></td>\n" +
                "   <td class=\"tc cfamily2 last\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     Não Reembolsável\n" +
                "    </div></td>\n" +
                "   <td class=\"tc  last\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     Sem custo\n" +
                "    </div></td>\n" +
                "   <td class=\"tc  last\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     US$ 320\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details mark \">\n" +
                "   <td colspan=\"4\" class=\"indent grid-1  ffamilyr1\"></td>\n" +
                "   <td class=\"pnone-imp tc right grid-1  ffamilyr1\"></td>\n" +
                "   <td class=\"pnone-imp tc right grid-1 cfamily2\"><span class=\"slope family sfamily2\"></span></td>\n" +
                "   <td class=\"pnone-imp tc right grid-1 \"></td>\n" +
                "   <td class=\"pnone-imp tc right grid-1 \"></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details last teaserInfo\">\n" +
                "   <td colspan=\"8\" class=\"family2 family relative\"><p class=\"hr upgrade-main 2 \" data-ff=\"2\"><button class=\"fr\">Alterar</button><strong>Por mais BRL 678.61, você pode mudar para a tarifa ACCESS </strong></p><p class=\"caption3 tr upgrade-toggle\"><strong class=\"em\">Minimizar <small class=\"ico hide\"></small></strong> &nbsp;</p></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details vcp none\">\n" +
                "   <td colspan=\"8\">\n" +
                "    <div class=\"warning w4 wdk-errorpanel\" style=\"display: none;\">\n" +
                "     <ul class=\"wdk-errorpanel-list\"></ul>\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details connectionindifferentairportwarning none\">\n" +
                "   <td colspan=\"8\">\n" +
                "    <div class=\"warning w4 wdk-errorpanel\" style=\"display: none;\">\n" +
                "     <ul class=\"wdk-errorpanel-list\"></ul>\n" +
                "    </div></td>\n" +
                "  </tr> \n" +
                "  <tr class=\"blankRow tbl-spacer\"> \n" +
                "   <td colspan=\"8\"></td> \n" +
                "  </tr> \n" +
                " </tbody> \n" +
                "</table>\n" +
                "<table class=\"inbound realTable bound family-nth4 list_flight sticky-enabled toggle plus\" id=\"inbound_list_flight\" style=\"margin: 0px; width: 100%;\"> \n" +
                " <thead> \n";
        String tabela6 =
                "  <tr class=\"sticky-header-row\"> \n" +
                "   <th class=\"caption right sortable fromTh tbf-col-1\">\n" +
                "    <div class=\"tbf-col-1\"></div><strong>De:</strong><small></small></th> \n" +
                "   <th class=\"caption right sortable toTh tbf-col-2\">\n" +
                "    <div class=\"tbf-col-2\"></div><strong>Para:</strong><small></small></th> \n" +
                "   <th class=\"caption notSortable tbf-col-3 right\">\n" +
                "    <div class=\"tbf-col-3\"></div><strong>Voo:</strong></th> \n" +
                "   <th class=\"caption right sortable bl-ie durationTh tbf-col-4\">\n" +
                "    <div class=\"tbf-col-4\"></div><strong>Duração:</strong><small></small></th> \n" +
                "   <th class=\"family f_ACJJLANA tc right sortable ff-0 f1 tbf-col-5\" data-ff-index=\"0\" data-ff-translatedname=\"BASE\" data-ff-fareconditions=\"<style type=&quot;text/css&quot;>\n" +
                "<!--\n" +
                ".style2 {\n" +
                " color: #FFFFFF;\n" +
                " font-weight: bold;\n" +
                "}\n" +
                "-->\n" +
                "</style>\n" +
                "<table border=&quot;0&quot; cellpadding=&quot;0&quot; cellspacing=&quot;0&quot; style=&quot; background-color: #004d83; border-radius: 10px; border: 3px solid #dddddd;&quot;>\n" +
                "  <tr>\n" +
                "  <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Condições válidas para voos LATAM Airlines Brasil (JJ)<br></strong></span><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Demais voos, consulte a parceira</br></span></div><br></td>\n" +
                "  <tr>\n" +
                "    <td width=&quot;835&quot; colspan=&quot;6&quot; style=&quot; border-top-left-radius: 7px;&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>BASE - CLASSE ECONÔMICA</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REEMBOLSO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não reembolsável</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>US$ 150.00</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO ÁSIA</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Origem Coréia do Sul e Coréia do Norte: US$ 100<br />\n" +
                "      Outras origens Ásia: US$ 150 </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>PONTOS NO PROGRAMA LATAM FIDELIDADE</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Para saber quantos pontos você vai acumular com sua viagem no Latam Fidelidade, consulte a página\n" +
                "<a href=&quot;http://www.tam.com.br/pt_br/tam-fidelidade/como-ganhar-mais-pontos/pontos-em-voos/&quot; target=&quot;_blank&quot;>Pontos em voos</a>.<br>\n" +
                "\n" +
                "*Pontuação mínima por trecho para EUA: 5000 pontos.<br />\n" +
                "    </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    \n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>SERVIÇOS PRIORITÁRIOS NO AEROPORTO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>FRANQUIA DE BAGAGEM</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>EUA: 2 peças / Europa:2 peças / Am. Sul: 23Kg / Am. Central: 23Kg / Entre EUA e Canadá: 1 peça</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TRANSFER CARRO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  \n" +
                "  <tr> </tr>\n" +
                "</table>\" data-ff-name=\"Nome da marca ainda não definido.\"> \n" +
                "    <div class=\"tbf-col-5\"></div> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <span>BASE</span> \n" +
                "     <small></small> \n" +
                "    </div> <a href=\"#\" title=\"BASE\"></a> </th> \n" +
                "   <th class=\"family f_FLJJLANA tc right sortable ff-1 f2 tbf-col-6\" data-ff-index=\"1\" data-ff-translatedname=\"ACCESS\" data-ff-fareconditions=\"<style type=&quot;text/css&quot;>\n" +
                "<!--\n" +
                ".style2 {\n" +
                " color: #FFFFFF;\n" +
                " font-weight: bold;\n" +
                "}\n" +
                "-->\n" +
                "</style>\n" +
                "<table border=&quot;0&quot; cellpadding=&quot;0&quot; cellspacing=&quot;0&quot; style=&quot; background-color: #004d83; border-radius: 10px; border: 3px solid #dddddd;&quot;>\n" +
                "  <tr>\n" +
                "  <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Condições válidas para voos LATAM Airlines Brasil (JJ)<br></strong></span><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Demais voos, consulte a parceira</br></span></div><br></td>\n" +
                "  </tr>\n" +
                "    <td width=&quot;835&quot; colspan=&quot;6&quot; style=&quot; border-top-left-radius: 7px;&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>CLASSE ECONÔMICA - ACCESS</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REEMBOLSO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não reembolsável<br>\n" +
                " Exceção: Europa a Peru/Equador; US$ 200. Europa a Brasil; US$ 280.</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>US$ 100</span></strong></div></td>\n" +
                "  </tr>\n" +
                "    <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>PONTOS NO PROGRAMA LATAM FIDELIDADE</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Para saber quantos pontos você vai acumular com sua viagem no Latam Fidelidade, consulte a página\n" +
                "<a href=&quot;http://www.tam.com.br/pt_br/tam-fidelidade/como-ganhar-mais-pontos/pontos-em-voos/&quot; target=&quot;_blank&quot;>Pontos em voos</a>.<br>\n" +
                "\n" +
                "*Pontuação mínima por trecho para EUA: 5000 pontos.<br/>\n" +
                "      Voos operados pela LAN - VER PONTUAÇÃO EM FIDELIDADE > COMO ACUMULAR PONTOS<br />\n" +
                "    </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    \n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>SERVIÇOS PRIORITÁRIOS NO AEROPORTO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>FRANQUIA DE BAGAGEM</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>EUA: 2 peças / Europa:2 peças / Am. Sul: 23Kg / Am. Central: 23Kg / Entre EUA e Canadá: 1 peça</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TRANSFER CARRO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  \n" +
                "  <tr> </tr>\n" +
                "</table>\" data-ff-name=\"Nome da marca ainda não definido.\"> \n" +
                "    <div class=\"tbf-col-6\"></div> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <span>ACCESS</span> \n" +
                "     <small></small> \n" +
                "    </div> <a href=\"#\" title=\"ACCESS\"></a> </th> \n" +
                "   <th class=\"family f_PLJJLANA tc right sortable ff-2 f3 tbf-col-7\" data-ff-index=\"2\" data-ff-translatedname=\"CONTROL\" data-ff-fareconditions=\"<style type=&quot;text/css&quot;>\n" +
                "<!--\n" +
                ".style2 {\n" +
                " color: #FFFFFF;\n" +
                " font-weight: bold;\n" +
                "}\n" +
                "-->\n" +
                "</style>\n" +
                "<table border=&quot;0&quot; cellpadding=&quot;0&quot; cellspacing=&quot;0&quot; style=&quot; background-color: #004d83; border-radius: 10px; border: 3px solid #dddddd;&quot;>\n" +
                "  <tr>\n" +
                "  <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Condições válidas para voos LATAM Airlines Brasil (JJ)<br></strong></span><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Demais voos, consulte a parceira</br></span></div><br></td>\n" +
                "  </tr>\n" +
                "    <td width=&quot;835&quot; colspan=&quot;6&quot; style=&quot; border-top-left-radius: 7px;&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>CONTROL </span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REEMBOLSO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Sem custo </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Sem custo </span></strong></div></td>\n" +
                "  </tr>\n" +
                "    <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>PONTOS NO PROGRAMA LATAM FIDELIDADE</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Para saber quantos pontos você vai acumular com sua viagem no Latam Fidelidade, consulte a página\n" +
                "<a href=&quot;http://www.tam.com.br/pt_br/tam-fidelidade/como-ganhar-mais-pontos/pontos-em-voos/&quot; target=&quot;_blank&quot;>Pontos em voos</a>.<br>\n" +
                "\n" +
                "*Pontuação mínima por trecho para EUA: 5000 pontos.<br />\n" +
                "    </span></strong></div></td>\n" +
                "  </tr>\n" +
                " \n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>SERVIÇOS PRIORITÁRIOS NO AEROPORTO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não Incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>FRANQUIA DE BAGAGEM</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>EUA:2 peças / Europa:2 peças / Am. Sul:23Kg / Am. Central: 23Kg / Entre EUA e Canadá: 1 peça</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TRANSFER CARRO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr> </tr>\n" +
                "</table>\" data-ff-name=\"Nome da marca ainda não definido.\"> \n" +
                "    <div class=\"tbf-col-7\"></div> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <span>CONTROL</span> \n" +
                "     <small></small> \n" +
                "    </div> <a href=\"#\" title=\"CONTROL\"></a> </th> \n" +
                "   <th class=\"family f_CLJJLANA tc right sortable ff-3 f4 tbf-col-8\" data-ff-index=\"3\" data-ff-translatedname=\"<strong>PREMIUM BUSINESS<br>ACCESS</strong>\" data-ff-fareconditions=\"<style type=&quot;text/css&quot;>\n" +
                "<!--\n" +
                ".style2 {\n" +
                " color: #FFFFFF;\n" +
                " font-weight: bold;<\n" +
                "}\n" +
                "-->\n" +
                "</style>\n" +
                "\n" +
                "\n" +
                "<table border=&quot;0&quot; cellpadding=&quot;0&quot; cellspacing=&quot;0&quot; style=&quot; background-color: #004d83; border-radius: 10px; border: 3px solid #dddddd;&quot;>\n" +
                "  <tr>\n" +
                "  <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Condições válidas para voos LATAM Airlines Brasil (JJ)<br></strong></span><span style=&quot; font-size:small; color: #666666; font-family: Arial;&quot;>Demais voos, consulte a parceira</br></span></div><br></td>\n" +
                "  </tr>\n" +
                "    <td width=&quot;835&quot; colspan=&quot;6&quot; style=&quot; border-top-left-radius: 7px;&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>Premium Business Access</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REEMBOLSO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>US$ 320</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TAXA DE REMARCAÇÃO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>US$ 250</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>PONTOS NO PROGRAMA LATAM FIDELIDADE</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Para saber quantos pontos você vai acumular com sua viagem no Latam Fidelidade, consulte a página\n" +
                "<a href=&quot;http://www.tam.com.br/pt_br/tam-fidelidade/como-ganhar-mais-pontos/pontos-em-voos/&quot; target=&quot;_blank&quot;>Pontos em voos</a>.<br>\n" +
                "\n" +
                "*Pontuação mínima por trecho para EUA: 5000 pontos.<br />\n" +
                "    </span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>SERVIÇOS PRIORITÁRIOS NO AEROPORTO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Check-in / Embarque / Bagagem</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>FRANQUIA DE BAGAGEM</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>EUA: 3 peças / Europa: 3 peças / Am. Sul: 43Kg / Entre EUA e Canadá: 3 peças</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td colspan=&quot;6&quot; bgcolor=&quot;#bf282d&quot;><div align=&quot;center&quot; class=&quot;style2&quot;><span style=&quot;font-size: x-small; font-family: Arial;&quot;>TRANSFER CARRO</span></div></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=&quot;#FFFFFF&quot;><div align=&quot;center&quot;><strong><span style=&quot; font-size: x-small; color: #666666; font-family: Arial;&quot;>Não incluso</span></strong></div></td>\n" +
                "  </tr>\n" +
                "  \n" +
                "  <tr> </tr>\n" +
                "</table>\" data-ff-name=\"Nome da marca ainda não definido.\"> \n" +
                "    <div class=\"tbf-col-8\"></div> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <span><strong>PREMIUM BUSINESS<br>ACCESS</strong></span> \n" +
                "     <small></small> \n" +
                "    </div> <a href=\"#\" title=\"PREMIUM BUSINESSACCESS\"></a> </th> \n" +
                "   <th class=\"sortable rjsTh hidden-col right\" style=\"\"></th> \n" +
                "  </tr> \n" +
                " </thead> \n" +
                " <tbody class=\"\" data-wdk-toggle-transition=\"none\"> \n" +
                "  <tr class=\"flight flightId-0 flightType-Connection\" data-blocationfull=\"Lester B. Pearson Internacional\" data-departuredate=\"Tue Oct 10 17:05:00 GMT 2017\" data-departuretime=\"1507655100000\" data-departurecitycode=\"YTO\" data-departureairportcode=\"YYZ\" data-elocationfull=\"Miami Internacional\" data-arrivaldate=\"Tue Oct 10 20:26:00 GMT 2017\" data-arrivaltime=\"1507667160000\" data-arrivalcitycode=\"MIA\" data-arrivalairportcode=\"MIA\" data-aircraft=\"Airbus Industrie A319\" data-airlinecode=\"AA\" data-rpduration=\"    12060000   \" data-operatedby=\"ONEWORLD_ALLIANCE\" data-operatedbyairlinename=\"American Airlines\" data-airlinecompany=\"American Airlines\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=AA&amp;flightNumber=0466&amp;date=20171010\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"AA0466\" data-number-of-stops=\"0\" data-nextday=\"0\"> \n" +
                "   <td class=\"th rightF bottomF fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1507655100000\"> <strong>17:05</strong> <span class=\"bLocation\" data-hasqtip=\"12\">YYZ</span> </td> \n" +
                "   <td class=\"th rightF bottomF toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1507667160000\"> <strong>20:26</strong> <span class=\"eLocation\" data-hasqtip=\"13\">MIA</span> </td> \n" +
                "   <td class=\"th rightF bottomF flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico oneworld\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"AA0466\" data-operated-by=\"American Airlines\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Airbus Industrie A319\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"American Airlines\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=AA&amp;flightNumber=0466&amp;date=20171010\">AA0466</a> <small class=\"op block em1 tr\"> <small><strong>Operado por:</strong>&nbsp;American Airlines</small> </small> </td> \n" +
                "   <td class=\"th bottomF durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"75300000\"> 3:21 </td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-0 ff-ACJJLANA    outBorder tbf-col-5 lowest selectedFF family1\" rowspan=\"6\" data-cell-fare-family=\"ACJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"63\" data-cell-flight-id=\"0\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"9844.83\" data-cell-fee-waived=\"\" data-cell-amountreference=\"9.844,83\" data-cell-price-in-reporting-currency=\"9.844,83\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"O\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"O\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"OEESP96W\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"9844.83\" data-cell-price-chd=\"9477.38\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"9844.83\" data-cell-price-chd-new=\"9477.38\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"75300000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <small class=\"fr\"><small class=\"ico cheap\"></small></small>\n" +
                "     <strong>1.466,46</strong>\n" +
                "    </div></td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-1 ff-FLJJLANA    outBorder tbf-col-6 disabled\" rowspan=\"6\" data-cell-fare-family=\"FLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"64\" data-cell-flight-id=\"0\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"10523.44\" data-cell-fee-waived=\"\" data-cell-amountreference=\"10.523,44\" data-cell-price-in-reporting-currency=\"10.523,44\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"V\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"V\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"VLXLE98W\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"10523.44\" data-cell-price-chd=\"9987.17\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"10523.44\" data-cell-price-chd-new=\"9987.17\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"75300000\"> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <small class=\"fr\"></small> --- \n" +
                "    </div> </td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-2 ff-PLJJLANA    outBorder tbf-col-7\" rowspan=\"6\" data-cell-fare-family=\"PLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"71\" data-cell-flight-id=\"0\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"11860.8\" data-cell-fee-waived=\"\" data-cell-amountreference=\"11.860,80\" data-cell-price-in-reporting-currency=\"11.860,80\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"K\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"K\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"KLXFXD6W\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"11860.8\" data-cell-price-chd=\"11860.8\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"11860.8\" data-cell-price-chd-new=\"11860.8\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"75300000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     4.432,49\n" +
                "    </div></td> \n" +
                "   <td class=\"f1-brcolor  tc ff index-3 ff-CLJJLANA    outBorder tbf-col-8\" rowspan=\"6\" data-cell-fare-family=\"CLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"73\" data-cell-flight-id=\"0\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"14274.01\" data-cell-fee-waived=\"\" data-cell-amountreference=\"14.274,01\" data-cell-price-in-reporting-currency=\"14.274,01\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"I\" data-cell-cabin-1=\"Executiva\" data-cell-rbd-2=\"I\" data-cell-cabin-2=\"Executiva\" data-cell-fareclass=\"IEEEV6GW\" data-cell-tax-adt=\"473.95\" data-cell-tax-chd=\"473.95\" data-cell-tax-inf=\"\" data-cell-price-adt=\"14274.01\" data-cell-price-chd=\"14274.01\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"14274.01\" data-cell-price-chd-new=\"14274.01\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"75300000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     8.378,37\n" +
                "    </div></td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"1\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"stopDuration flightNextSegment\"> \n" +
                "   <td class=\"em1 rightE bottomF caption3\" colspan=\"3\">Tempo em conexão MIA:</td> \n" +
                "   <td class=\"em1 bottomF caption3 tc\">2:44</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flightNextSegment flightType-Connection\" data-blocationfull=\"Miami Internacional\" data-departuredate=\"Tue Oct 10 23:10:00 GMT 2017\" data-departuretime=\"1507677000000\" data-departurecitycode=\"MIA\" data-departureairportcode=\"MIA\" data-elocationfull=\"Galeao A.C Jobim International\" data-arrivaldate=\"Wed Oct 11 08:45:00 GMT 2017\" data-arrivaltime=\"1507711500000\" data-arrivalcitycode=\"RIO\" data-arrivalairportcode=\"GIG\" data-aircraft=\"Boeing 767-300/300ER\" data-airlinecode=\"JJ\" data-rpduration=\"    30900000   \" data-operatedby=\"JJ\" data-airlinecompany=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=8057&amp;date=20171010\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"JJ8057\" data-number-of-stops=\"0\" data-nextday=\"1\"> \n" +
                "   <td class=\"th rightF bottomF fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1507677000000\"> <strong>23:10</strong> <span class=\"bLocation\" data-hasqtip=\"14\">MIA</span> </td> \n" +
                "   <td class=\"th rightF bottomF toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1507711500000\"> <strong>08:45</strong> <span class=\"eLocation\" data-hasqtip=\"15\">GIG</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF bottomF flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico latam\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"JJ8057\" data-operated-by=\"\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Boeing 767-300/300ER\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=8057&amp;date=20171010\">JJ8057</a> <small class=\"op block em1 tr\"> </small> </td> \n" +
                "   <td class=\"th bottomF durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"75300000\"> 8:35 </td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"1\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"stopDuration flightNextSegment\"> \n" +
                "   <td class=\"em1 rightE bottomF caption3\" colspan=\"3\">Tempo em conexão GIG:</td> \n" +
                "   <td class=\"em1 bottomF caption3 tc\">3:10</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flightNextSegment flightType-Connection\" data-blocationfull=\"Galeao A.C Jobim International\" data-departuredate=\"Wed Oct 11 11:55:00 GMT 2017\" data-departuretime=\"1507722900000\" data-departurecitycode=\"RIO\" data-departureairportcode=\"GIG\" data-elocationfull=\"International\" data-arrivaldate=\"Wed Oct 11 15:00:00 GMT 2017\" data-arrivaltime=\"1507734000000\" data-arrivalcitycode=\"NAT\" data-arrivalairportcode=\"NAT\" data-aircraft=\"Airbus Industrie A320\" data-airlinecode=\"JJ\" data-rpduration=\"    11100000   \" data-operatedby=\"JJ\" data-airlinecompany=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=3388&amp;date=20171011\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"JJ3388\" data-number-of-stops=\"0\" data-nextday=\"0\"> \n" +
                "   <td class=\"th rightF  fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1507722900000\"> <strong>11:55</strong> <span class=\"bLocation\" data-hasqtip=\"16\">GIG</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF  toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1507734000000\"> <strong>15:00</strong> <span class=\"eLocation\" data-hasqtip=\"17\">NAT</span> </td> \n" +
                "   <td class=\"th rightF  flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico latam\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"JJ3388\" data-operated-by=\"\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Airbus Industrie A320\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=3388&amp;date=20171011\">JJ3388</a> <small class=\"op block em1 tr\"> </small> </td> \n" +
                "   <td class=\"th  durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"75300000\"> 3:05 </td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"1\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"totalDurationRow flightNextSegment\"> \n" +
                "   <td class=\"topF caption3 rightE caption3\" colspan=\"3\">Duração total da viagem</td> \n" +
                "   <td class=\"topF durationTh caption3 tc\">20:55</td> \n" +
                "  </tr>\n" +
                "  <tr class=\"details dotted  first  border \">\n" +
                "   <td class=\"rowspan\" rowspan=\"4\" colspan=\"2\"><button class=\"short block wrap seatMap\"><small class=\"fl ico gseat\"></small><span>Mapa de assentos</span></button><button class=\"short block br wrap compareFare\"><small class=\"fl ico zoom\"></small><span>Compare Tarifas</span></button><button class=\"short block br wrap legalNotice\"><small class=\"fl ico book\"></small>*Regras</button></td>\n" +
                "   <td class=\"right  ffamilyr1\" colspan=\"2\"><img alt=\"\" class=\"fl\" src=\"https://book.latam.com/TAM/cui-tam_30.126_281116/air/skin/tam/desktopLATAM/img/benefits/tamLogo.png\">&nbsp;<strong class=\"fl grid2-2\">Acúmulo LATAM Fidelidade*&nbsp;</strong></td>\n" +
                "   <td class=\"tc  ffamilyr1\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     100% da distância\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     125% da distância\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     150% da distância\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     200% da distância\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details dotted  border \">\n" +
                "   <td class=\"right  ffamilyr1\" colspan=\"2\"><img alt=\"\" class=\"fl\" src=\"https://book.latam.com/TAM/cui-tam_30.126_281116/air/skin/tam/desktopLATAM/img/benefits/plane.png\">&nbsp;<strong class=\"fl grid2-2\">Alteração de voos*&nbsp;</strong></td>\n" +
                "   <td class=\"tc  ffamilyr1\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <span class=\"ico ok\"></span>\n" +
                "     <br>Até US$ 150,00+\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <span class=\"ico ok\"></span>\n" +
                "     <br>Até US$ 150,00+\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <span class=\"ico ok\"></span>\n" +
                "     <br>Até US$ 100,00+\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     <span class=\"ico ok\"></span>\n" +
                "     <br>Sem custo\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details dotted  border \">\n" +
                "   <td class=\"right  ffamilyr1\" colspan=\"2\"><img alt=\"\" class=\"fl\" src=\"https://book.latam.com/TAM/cui-tam_30.126_281116/air/skin/tam/desktopLATAM/img/benefits/luggage.png\">&nbsp;<strong class=\"fl grid2-2\">Franquia de Bagagem*&nbsp;<small class=\"ico info tooltip-link baggageAllowanceLink\"></small></strong></td>\n" +
                "   <td class=\"tc  ffamilyr1\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     2 peças*\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     2 peças*\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     2 peças*\n" +
                "    </div></td>\n" +
                "   <td class=\"tc \">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     3 peças*\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details dotted  bordert \">\n" +
                "   <td class=\"right  ffamilyr1\" colspan=\"2\"><img alt=\"\" class=\"fl\" src=\"https://book.latam.com/TAM/cui-tam_30.126_281116/air/skin/tam/desktopLATAM/img/benefits/traveller.png\">&nbsp;<strong class=\"fl grid2-2\">Reembolso*&nbsp;</strong></td>\n" +
                "   <td class=\"tc  ffamilyr1 last\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     Não Reembolsável\n" +
                "    </div></td>\n" +
                "   <td class=\"tc  last\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     Não Reembolsável\n" +
                "    </div></td>\n" +
                "   <td class=\"tc  last\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     Sem custo\n" +
                "    </div></td>\n" +
                "   <td class=\"tc  last\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     US$ 320\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details mark \">\n" +
                "   <td colspan=\"4\" class=\"indent grid-1  ffamilyr1\"></td>\n" +
                "   <td class=\"pnone-imp tc right grid-1  ffamilyr1\"></td>\n" +
                "   <td class=\"pnone-imp tc right grid-1 \"></td>\n" +
                "   <td class=\"pnone-imp tc right grid-1 \"></td>\n" +
                "   <td class=\"pnone-imp tc right grid-1 \"></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details last teaserInfo\">\n" +
                "   <td colspan=\"8\" class=\"family2 family relative\"><p class=\"caption3 tr\"><strong class=\"em\">Minimizar <small class=\"ico hide\"></small></strong> &nbsp;</p></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details vcp none\">\n" +
                "   <td colspan=\"8\">\n" +
                "    <div class=\"warning w4 wdk-errorpanel\" style=\"display: none;\">\n" +
                "     <ul class=\"wdk-errorpanel-list\"></ul>\n" +
                "    </div></td>\n" +
                "  </tr>\n" +
                "  <tr class=\"details connectionindifferentairportwarning none\">\n" +
                "   <td colspan=\"8\">\n" +
                "    <div class=\"warning w4 wdk-errorpanel\" style=\"display: none;\">\n" +
                "     <ul class=\"wdk-errorpanel-list\"></ul>\n" +
                "    </div></td>\n" +
                "  </tr> \n" +
                "  <tr class=\"blankRow tbl-spacer\"> \n" +
                "   <td colspan=\"8\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flight flightId-1 flightType-Connection\" data-blocationfull=\"Lester B. Pearson Internacional\" data-departuredate=\"Tue Oct 10 12:15:00 GMT 2017\" data-departuretime=\"1507637700000\" data-departurecitycode=\"YTO\" data-departureairportcode=\"YYZ\" data-elocationfull=\"John F Kennedy International\" data-arrivaldate=\"Tue Oct 10 13:56:00 GMT 2017\" data-arrivaltime=\"1507643760000\" data-arrivalcitycode=\"NYC\" data-arrivalairportcode=\"JFK\" data-aircraft=\"Embraer RJ145\" data-airlinecode=\"AA\" data-rpduration=\"    6060000   \" data-operatedby=\"ONEWORLD_ALLIANCE\" data-operatedbyairlinename=\"TRANS STATES AS AMERICAN EAGLE\" data-airlinecompany=\"TRANS STATES AS AMERICAN EAGLE\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=AA&amp;flightNumber=4338&amp;date=20171010\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"AA4338\" data-number-of-stops=\"0\" data-nextday=\"0\"> \n" +
                "   <td class=\"th rightF bottomF fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1507637700000\"> <strong>12:15</strong> <span class=\"bLocation\" data-hasqtip=\"18\">YYZ</span> </td> \n" +
                "   <td class=\"th rightF bottomF toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1507643760000\"> <strong>13:56</strong> <span class=\"eLocation\" data-hasqtip=\"19\">JFK</span> </td> \n" +
                "   <td class=\"th rightF bottomF flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico oneworld\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"AA4338\" data-operated-by=\"TRANS STATES AS AMERICAN EAGLE\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Embraer RJ145\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"TRANS STATES AS AMERICAN EAGLE\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=AA&amp;flightNumber=4338&amp;date=20171010\">AA4338</a> <small class=\"op block em1 tr\"> <small><strong>Operado por:</strong>&nbsp;TRANS STATES AS AMERICAN EAGLE</small> </small> </td> \n" +
                "   <td class=\"th bottomF durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"90840000\"> 1:41 </td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-0 ff-ACJJLANA    outBorder tbf-col-5 disabled\" rowspan=\"6\" data-cell-fare-family=\"ACJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"58\" data-cell-flight-id=\"1\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"7362.1\" data-cell-fee-waived=\"\" data-cell-amountreference=\"7.362,10\" data-cell-price-in-reporting-currency=\"7.362,10\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"O\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"O\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"OEESP96W\" data-cell-tax-adt=\"474.76\" data-cell-tax-chd=\"474.76\" data-cell-tax-inf=\"\" data-cell-price-adt=\"7362.1\" data-cell-price-chd=\"6994.66\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"7362.1\" data-cell-price-chd-new=\"6994.66\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"90840000\"> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <small class=\"fr\"></small> --- \n" +
                "    </div> </td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-1 ff-FLJJLANA    outBorder tbf-col-6 disabled\" rowspan=\"6\" data-cell-fare-family=\"FLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"59\" data-cell-flight-id=\"1\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"8040.71\" data-cell-fee-waived=\"\" data-cell-amountreference=\"8.040,71\" data-cell-price-in-reporting-currency=\"8.040,71\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"V\" data-cell-cabin-1=\"Econômica\" data-cell-rbd-2=\"V\" data-cell-cabin-2=\"Econômica\" data-cell-fareclass=\"VLXLE98W\" data-cell-tax-adt=\"474.76\" data-cell-tax-chd=\"474.76\" data-cell-tax-inf=\"\" data-cell-price-adt=\"8040.71\" data-cell-price-chd=\"7504.45\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"8040.71\" data-cell-price-chd-new=\"7504.45\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"90840000\"> \n" +
                "    <div class=\"cell-inside\"> \n" +
                "     <small class=\"fr\"></small> --- \n" +
                "    </div> </td> \n" +
                "   <td class=\"f1-brcolor rightE tc ff index-2 ff-PLJJLANA    outBorder tbf-col-7\" rowspan=\"6\" data-cell-fare-family=\"PLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"68\" data-cell-flight-id=\"1\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"10328.13\" data-cell-fee-waived=\"\" data-cell-amountreference=\"10.328,13\" data-cell-price-in-reporting-currency=\"10.328,13\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"I\" data-cell-cabin-1=\"Executiva\" data-cell-rbd-2=\"I\" data-cell-cabin-2=\"Executiva\" data-cell-fareclass=\"IEEEV6GW\" data-cell-tax-adt=\"474.76\" data-cell-tax-chd=\"474.76\" data-cell-tax-inf=\"\" data-cell-price-adt=\"10328.13\" data-cell-price-chd=\"10328.13\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"10328.13\" data-cell-price-chd-new=\"10328.13\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"90840000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     4.432,49\n" +
                "    </div></td> \n" +
                "   <td class=\"f1-brcolor  tc ff index-3 ff-CLJJLANA    outBorder tbf-col-8\" rowspan=\"6\" data-cell-fare-family=\"CLJJLANA\" data-cell-ticket-designator=\"\" data-cell-reco-id=\"70\" data-cell-flight-id=\"1\" data-cell-flight-id-1=\"\" data-cell-flight-id-2=\"\" data-cell-original-price-data-available=\"\" data-cell-value=\"11787.97\" data-cell-fee-waived=\"\" data-cell-amountreference=\"11.787,97\" data-cell-price-in-reporting-currency=\"11.787,97\" data-cell-rbd-0=\"Y\" data-cell-cabin-0=\"Econômica\" data-cell-rbd-1=\"I\" data-cell-cabin-1=\"Executiva\" data-cell-rbd-2=\"I\" data-cell-cabin-2=\"Executiva\" data-cell-fareclass=\"IEEEV6GW\" data-cell-tax-adt=\"474.76\" data-cell-tax-chd=\"474.76\" data-cell-tax-inf=\"\" data-cell-price-adt=\"11787.97\" data-cell-price-chd=\"11787.97\" data-cell-price-inf=\"\" data-cell-price-adt-new=\"11787.97\" data-cell-price-chd-new=\"11787.97\" data-cell-price-inf-new=\"\" data-cell-refund-balance=\"\" data-cell-rebook-fee=\"\" data-cell-collect-balance=\"\" data-cell-total-duration=\"90840000\">\n" +
                "    <div class=\"cell-inside\">\n" +
                "     5.895,64\n" +
                "    </div></td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"2\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"stopDuration flightNextSegment\"> \n" +
                "   <td class=\"em1 rightE bottomF caption3\" colspan=\"3\">Tempo em conexão JFK:</td> \n" +
                "   <td class=\"em1 bottomF caption3 tc\">5:34</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flightNextSegment flightType-Connection\" data-blocationfull=\"John F Kennedy International\" data-departuredate=\"Tue Oct 10 19:30:00 GMT 2017\" data-departuretime=\"1507663800000\" data-departurecitycode=\"NYC\" data-departureairportcode=\"JFK\" data-elocationfull=\"Guarulhos International\" data-arrivaldate=\"Wed Oct 11 06:25:00 GMT 2017\" data-arrivaltime=\"1507703100000\" data-arrivalcitycode=\"SAO\" data-arrivalairportcode=\"GRU\" data-aircraft=\"Boeing 777-300\" data-airlinecode=\"JJ\" data-rpduration=\"    35700000   \" data-operatedby=\"JJ\" data-airlinecompany=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=8081&amp;date=20171010\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"JJ8081\" data-number-of-stops=\"0\" data-nextday=\"1\"> \n" +
                "   <td class=\"th rightF bottomF fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1507663800000\"> <strong>19:30</strong> <span class=\"bLocation\" data-hasqtip=\"20\">JFK</span> </td> \n" +
                "   <td class=\"th rightF bottomF toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1507703100000\"> <strong>06:25</strong> <span class=\"eLocation\" data-hasqtip=\"21\">GRU</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF bottomF flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico latam\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"JJ8081\" data-operated-by=\"\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Boeing 777-300\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=8081&amp;date=20171010\">JJ8081</a> <small class=\"op block em1 tr\"> </small> </td> \n" +
                "   <td class=\"th bottomF durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"90840000\"> 9:55 </td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"2\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"stopDuration flightNextSegment\"> \n" +
                "   <td class=\"em1 rightE bottomF caption3\" colspan=\"3\">Tempo em conexão GRU:</td> \n" +
                "   <td class=\"em1 bottomF caption3 tc\">4:50</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"flightNextSegment flightType-Connection\" data-blocationfull=\"Guarulhos International\" data-departuredate=\"Wed Oct 11 11:15:00 GMT 2017\" data-departuretime=\"1507720500000\" data-departurecitycode=\"SAO\" data-departureairportcode=\"GRU\" data-elocationfull=\"International\" data-arrivaldate=\"Wed Oct 11 14:29:00 GMT 2017\" data-arrivaltime=\"1507732140000\" data-arrivalcitycode=\"NAT\" data-arrivalairportcode=\"NAT\" data-aircraft=\"Airbus Industrie A321\" data-airlinecode=\"JJ\" data-rpduration=\"    11640000   \" data-operatedby=\"JJ\" data-airlinecompany=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=3707&amp;date=20171011\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-flightnumber=\"JJ3707\" data-number-of-stops=\"0\" data-nextday=\"0\"> \n" +
                "   <td class=\"th rightF  fromTh w65p bottomF  tbf-col-1\" data-cell-value=\"1507720500000\"> <strong>11:15</strong> <span class=\"bLocation\" data-hasqtip=\"22\">GRU</span> <small class=\"em\">+1</small> </td> \n" +
                "   <td class=\"th rightF  toTh w65p bottomF  tbf-col-2\" data-cell-value=\"1507732140000\"> <strong>14:29</strong> <span class=\"eLocation\" data-hasqtip=\"23\">NAT</span> </td> \n" +
                "   <td class=\"th rightF  flightNumber grid0 bottomF  tbf-col-3\" data-segment-length=\"3\"><small class=\"ico latam\"></small> <a href=\"javascript:void(0)\" class=\"em linkFlif\" data-flight-number=\"JJ3707\" data-operated-by=\"\" data-baggage-allowance=\"\" data-baggage-allowance-link=\"https://www.latam.com/pt_br/informacao-para-sua-viagem/bagagem/bagagem-de-mao/\" data-aircraft=\"Airbus Industrie A321\" data-anac-link=\"https://www.latam.com/pt_br/conheca-nos/sobre-nos/nossa-frota/B777/\" data-airline-company=\"LATAM Airlines Brasil\" data-ontime-performance=\"https://www.latam.com/b2c/jsp/latam/viajefacil/anac/pontualidadeVooTemp.jsp?airline=JJ&amp;flightNumber=3707&amp;date=20171011\">JJ3707</a> <small class=\"op block em1 tr\"> </small> </td> \n" +
                "   <td class=\"th  durationTh grid0 bottomF  tc tbf-col-4\" data-cell-value=\"90840000\"> 3:14 </td> \n" +
                "   <td class=\"rjsTh hidden-col\" data-cell-value=\"2\"></td> \n" +
                "   <td class=\"destiantionTh hidden-col\"></td> \n" +
                "  </tr> \n" +
                "  <tr class=\"totalDurationRow flightNextSegment\"> \n" +
                "   <td class=\"topF caption3 rightE caption3\" colspan=\"3\">Duração total da viagem</td> \n" +
                "   <td class=\"topF durationTh caption3 tc\">25:14</td> \n" +
                "  </tr> \n" +
                "  <tr class=\"blankRow tbl-spacer\"> \n" +
                "   <td colspan=\"8\"></td> \n" +
                "  </tr> \n" +
                " </tbody> \n" +
                "</table>";

        Document doc = null;
        Element ida = null,volta=null;
        doc = Jsoup.parse(tabela+tabela2+tabela3+tabela4+tabela5+tabela6);
        /*Obtem as passagens de ida*/
        ida = doc.getElementById("outbound_list_flight");
        /*Obtem as passagens de volta*/
        volta = doc.getElementById("inbound_list_flight");
        return ida.toString()+volta.toString();
    }
}
