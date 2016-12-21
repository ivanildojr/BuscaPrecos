import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ProtocolHandshake;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ivanildo.junior on 20/12/2016.
 */
public class BuscaPrecosGOL {

    public static void main(String args[]) throws InterruptedException {
        String url = "https://compre2.voegol.com.br/Search.aspx";

//	DesiredCapabilities caps = new DesiredCapabilities();
//
//	String[] phantomArgs = new  String[] {
//		    "--webdriver-loglevel=NONE"
//		};
//
//    caps.setJavascriptEnabled(true);
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\ivanildo.junior\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomArgs);
//    caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, "--webdriver-loglevel=NONE");
//
//    Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
//    Logger.getLogger(ProtocolHandshake.class.getName()).setLevel(Level.OFF);
//
//	WebDriver ghostDriver = new PhantomJSDriver(caps);


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivanildo.junior\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver ghostDriver = new ChromeDriver();




        try {
            ghostDriver.get(url);

            Actions actions = new Actions(ghostDriver);
            actions.moveToElement(ghostDriver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"))).build().perform();
            new WebDriverWait(ghostDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"))).click();



            Document doc = null;
            doc = Jsoup.parse(ghostDriver.getPageSource());
//            Elements origem = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1");
//            Elements destino = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketDestination1");
//            Elements dateIda = doc.getElementsByAttributeValue("id", "dateIda");
//            Elements dateVolta = doc.getElementsByAttributeValue("id", "dateVolta");
//            Elements adultosSelect = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT");
//            Elements criancasSelect = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_CHD");
//            Elements botao = doc.getElementsByAttributeValue("name", "ControlGroupSearchView$ButtonSubmit");

//            Document adultosDoc = Jsoup.parse(adultosSelect.toString());
//		Elements adultosOpcoes = adultosDoc.getElementsByTag("option");
//            Elements adultosOpcoes = adultosDoc.getElementsByAttributeValue("value", "2");

//            Document criancasDoc = Jsoup.parse(adultosSelect.toString());
//		Elements criancasOpcoes = adultosDoc.getElementsByTag("option");
//            Elements criancasOpcoes = adultosDoc.getElementsByAttributeValue("value", "2");


            WebElement origemTxt = ghostDriver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketOrigin1"));
            origemTxt.sendKeys("NATAL");

            WebElement destinoTxt = ghostDriver.findElement(By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$TextBoxMarketDestination1"));
            destinoTxt.sendKeys("YYZ");

            WebElement dataIda = ghostDriver.findElement(By.id("dateIda"));
            dataIda.sendKeys("09092017");
            dataIda.sendKeys(Keys.TAB);

            WebElement dataVolta = ghostDriver.findElement(By.id("dateVolta"));
            dataVolta.sendKeys("18102017");
            dataVolta.sendKeys(Keys.TAB);

            Select adultos = new Select(ghostDriver.findElement(
                    By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_ADT")));
            adultos.selectByValue("2");

            Select criancas = new Select(ghostDriver.findElement(
                    By.name("ControlGroupSearchView$AvailabilitySearchInputSearchView$DropDownListPassengerType_CHD")));
            criancas.selectByValue("2");


            WebElement botao = ghostDriver.findElement(By.name("ControlGroupSearchView$ButtonSubmit"));
            botao.click();

//            Thread.sleep(2000);

            WebElement tabelaIda = ghostDriver.findElement(By.id("ida"));

            System.out.println("Voss de IDA:");
            List<WebElement> preco = tabelaIda.findElements(By.className("fareValue"));
            for (WebElement e: preco) {
                System.out.println(e.getText());
            }

            WebElement tabelaVolta = ghostDriver.findElement(By.id("ida"));

            System.out.println("Voss de VOLTA:");
            preco = tabelaVolta.findElements(By.className("fareValue"));
            for (WebElement e: preco) {
                System.out.println(e.getText());
            }


//		List<WebElement> allOptions = select.findElements(By.tagName("option"));
//		for (WebElement option : allOptions) {
//
//		    if(option.getAttribute("value").equalsIgnoreCase("2")){
//		    	System.out.println(String.format("Value is: %s", option.getAttribute("value")));
//
//		    	option.click();
//		    }
//
//		}



//		List lista = new ArrayList();
//
//		lista.add(origem);
//		lista.add(destino);
//		lista.add(dateIda);
//		lista.add(dateVolta);
//		lista.add(adultosSelect);
//		lista.add(adultosOpcoes);
//		lista.add(criancasSelect);
//		lista.add(botao);
//
//		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
//			Elements object = (Elements) iterator.next();
//			System.out.println(object.toString());
//		}


        } catch (NullPointerException n){
            System.out.println("Document igual a null");
        } finally {
            ghostDriver.quit();
        }


    }
}
