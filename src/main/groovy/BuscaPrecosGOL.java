import buscaprecos.LogConsultas;
import buscaprecos.LogConsultasController;
import buscaprecos.Precos;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ProtocolHandshake;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ivanildo.junior on 20/12/2016.
 */
public class BuscaPrecosGOL {

    public String busca(String origem, String destino, String dataPartida, String dataRetorno, String qtdeAdultos, String qtdeCriancas){
        String url = "https://compre2.voegol.com.br/Search.aspx";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivanildo JR\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(-2000, 0));

        try {
            driver.get(url);

//            LogConsultas log = new LogConsultas();
//            log.setConsulta(url);
//            log.setEmpresa("GOL");
//            log.setDataConsulta(new Date());
//            LogConsultasController controler = new LogConsultasController();
//            controler.save(log);


            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"))).build().perform();
            new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"))).click();


            WebElement origemTxt = driver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"));
            origemTxt.sendKeys(origem);




            WebElement destinoTxt = driver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketDestination1"));
            destinoTxt.sendKeys(destino);
            destinoTxt.sendKeys(Keys.ENTER);

            Thread.sleep(2000);

            System.out.println("Destino: " + destino );


            WebElement dataIda = driver.findElement(By.id("dateIda"));
            dataIda.sendKeys(dataPartida);
            dataIda.sendKeys(Keys.TAB);

            Thread.sleep(2000);


            WebElement dataVolta = driver.findElement(By.id("dateVolta"));
            dataVolta.sendKeys(dataRetorno);
            dataVolta.sendKeys(Keys.TAB);

            Thread.sleep(2000);

            Select adultos = new Select(driver.findElement(
                    By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT")));
            adultos.selectByValue(qtdeAdultos);

            Thread.sleep(2000);

            Select criancas = new Select(driver.findElement(
                    By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_CHD")));
            criancas.selectByValue(qtdeCriancas);

            Thread.sleep(2000);


            WebElement botao = driver.findElement(By.name("ControlGroupSearchView$ButtonSubmit"));
            botao.click();

            Thread.sleep(2000);

            Document doc = Jsoup.parse(driver.getPageSource());
            Element ida = doc.getElementById("ida");
            Element volta = doc.getElementById("volta");
            return ida.toString()+volta.toString();


        } catch (NullPointerException n){
            System.out.println("Document igual a null");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }



        return null;

    }

    public static void main(String args[]) throws InterruptedException {
        String url = "https://compre2.voegol.com.br/Search.aspx";

//	DesiredCapabilities caps = new DesiredCapabilities();
//
//	String[] phantomArgs = new  String[] {
//		    "--webdriver-loglevel=NONE"
//		};
//
//    caps.setJavascriptEnabled(true);
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getenv("PHANTOMJS")+"\\phantomjs.exe");
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomArgs);
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, "--webdriver-loglevel=NONE");
//
//
//    Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
//    Logger.getLogger(ProtocolHandshake.class.getName()).setLevel(Level.OFF);
//
//	WebDriver ghostDriver = new PhantomJSDriver(caps);


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivanildo JR\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(-2000, 0));



        try {
            driver.get(url);

            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"))).build().perform();
            new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfElementLocated(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"))).click();

//            FileUtils.copyFile(scr, new File("C:\\Users\\Ivanildo JR\\Downloads\\arquivo2.jpg"),true);


            WebElement origemTxt = driver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"));
            origemTxt.sendKeys("NATAL");




            WebElement destinoTxt = driver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketDestination1"));
            destinoTxt.sendKeys("YYZ");


            WebElement dataIda = driver.findElement(By.id("dateIda"));
            dataIda.sendKeys("08092017");
            dataIda.sendKeys(Keys.TAB);



            WebElement dataVolta = driver.findElement(By.id("dateVolta"));
            dataVolta.sendKeys("18102017");
            dataVolta.sendKeys(Keys.TAB);

            Select adultos = new Select(driver.findElement(
                    By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT")));
            adultos.selectByValue("2");

            Select criancas = new Select(driver.findElement(
                    By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_CHD")));
            criancas.selectByValue("2");




            WebElement botao = driver.findElement(By.name("ControlGroupSearchView$ButtonSubmit"));
            botao.click();


            Thread.sleep(1000);

            WebElement tabelaIda = driver.findElement(By.id("ida"));

            System.out.println("Voos de IDA:");
            List<WebElement> preco = tabelaIda.findElements(By.className("taxaPromocional"));

//            for (WebElement e: preco) {
//                List<WebElement> p = e.findElements(By.className("fareValue"));
//
//                for (WebElement i: p) {
//                    System.out.println(i.getText());
//                }
//            }

            WebElement tabelaVolta = driver.findElement(By.id("volta"));

            System.out.println("Voos de VOLTA:");
            preco = tabelaIda.findElements(By.className("taxaPromocional"));

            for (WebElement e: preco) {
                List<WebElement> p = e.findElements(By.className("fareValue"));

                for (WebElement i: p) {
//                    System.out.println(i.getText());
                }
            }

            Document doc = Jsoup.parse(driver.getPageSource());
            Element ida = doc.getElementById("ida");
            Element volta = doc.getElementById("volta");
//            System.out.println(ida.toString()+volta.toString());


            Document doc2 = Jsoup.parse(ida.toString()+volta.toString());
            Element testIda = doc2.getElementById("ida");
            Document doc3 = Jsoup.parse(testIda.toString());
            Elements idas = doc3.getElementsByClass("taxaPromocional");
            for(int i =0 ; i<idas.size();i++) {
                Document docIdas = Jsoup.parse(idas.get(i).toString());
                Elements p = docIdas.getElementsByClass("fareValue");

                for(int j = 0; j < p.size(); j++){
                    String precoIda = p.get(j).text();
                    System.out.println(precoIda);
                }
            }


        } catch (NullPointerException n){
            System.out.println("Document igual a null");
        } finally {
            driver.quit();
        }





    }
}
