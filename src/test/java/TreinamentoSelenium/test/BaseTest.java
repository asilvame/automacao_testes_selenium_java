package TreinamentoSelenium.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected static WebDriver driver;
    //private static final String URL_BASE = "https://www.saucedemo.com/";
    private static final String URL_BASE = "http://automationpractice.pl/index.php";
    private static final String CAMINHO_DRIVER = "src/test/java/TreinamentoSelenium/resource/chromedriver.exe";


    @BeforeClass
    public static void Iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterClass
    public static void Encerrar(){
        driver.quit();
        System.out.println("Quit");
    }

}
