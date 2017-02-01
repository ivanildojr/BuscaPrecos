import buscaprecos.LogConsultas;
import buscaprecos.LogConsultasController;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.quartz.utils.PoolingConnectionProvider.DB_URL;


/**
 * Created by ivanildo.junior on 14/12/2016.
 */
public class BuscaPrecosTAM {
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
        System.out.println(url);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getenv("PHANTOMJS")+"\\phantomjs.exe");


        WebDriver ghostDriver = new PhantomJSDriver(caps);

        Element ida = null,volta=null;
        try {
            ghostDriver.get(url);

//            LogConsultas log = new LogConsultas();
//            log.setConsulta(url);
//            log.setEmpresa("GOL");
//            log.setDataConsulta(new Date());
//            LogConsultasController controler = new LogConsultasController();
//            controler.save(log);


            Document doc = null;
            doc = Jsoup.parse(ghostDriver.getPageSource());
            ida = doc.getElementById("outbound_list_flight");
            volta = doc.getElementById("inbound_list_flight");
            if(ida != null && volta != null){
//                System.out.println("<html><head></head><body>");
//                System.out.println(ida.toString());
//                System.out.println(volta.toString());
//                System.out.println("</body></html>");
//                System.out.println(ida.toString()+" ---- \n"+volta.toString());
                return ida.toString()+volta.toString();
            }
        } catch (NullPointerException n){
            System.out.println("Document igual a null");
        } finally {
            ghostDriver.quit();
        }

        return null;









//        Document doc = null;
//        Element ida = null,volta=null;
//        doc = Jsoup.parse(tabela+tabela2+tabela3+tabela4+tabela5+tabela6);
        /*Obtem as passagens de ida*/
//        ida = doc.getElementById("outbound_list_flight");
        /*Obtem as passagens de volta*/
//        volta = doc.getElementById("inbound_list_flight");
//        return ida.toString()+volta.toString();
    }
}
