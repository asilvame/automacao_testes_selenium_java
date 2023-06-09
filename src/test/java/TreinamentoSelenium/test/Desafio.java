package TreinamentoSelenium.test;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.runners.MethodSorters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TreinamentoSelenium.Page.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Desafio extends BaseTest {
    private static CustomerPO customerPG;

    @BeforeClass
    public static void preparaTestes(){
    	customerPG = new CustomerPO(driver);
    	String url = "http://automationpractice.pl/index.php";
    	driver.get(url);        
    }
        
    public boolean Acessar_Pagina_Login_or_Create() {

        WebElement BotaoLogin = driver.findElement(By.className("login"));        
        //System.out.println(BotaoLogin.getTagName()); 
        BotaoLogin.click();
        WebElement PgHeading = driver.findElement(By.className("page-heading")); 
        System.out.println(PgHeading.getText());
        //<h1 class="page-heading">Create an account</h1>
        
        new WebDriverWait(driver, 10)
        .until(ExpectedConditions.presenceOfElementLocated(By.id("create-account_form")));
        
        new WebDriverWait(driver, 10)
        .until(ExpectedConditions.presenceOfElementLocated(By.id("login_form")));
        
        WebElement FormCreateAccount = driver.findElement(By.id("create-account_form"));
        WebElement FormLogin = driver.findElement(By.id("login_form"));            
        //From de Create Account e Login presente
        return (FormCreateAccount.isDisplayed()&& FormLogin.isDisplayed() );
    }
    
    @Test
    public void T001_Acessar_Pagina_Login_or_CreateAccount() {
        assertTrue( this.Acessar_Pagina_Login_or_Create());
    }
    
    @Test
    public void T002_RealizarLoginComSucesso() {
    	
    	WebElement FormLogin = driver.findElement(By.id("login_form"));            
        //From Login presente
        assertTrue(FormLogin.isDisplayed());
        WebElement TxfEmail = driver.findElement(By.id("email"));
        TxfEmail.sendKeys("andre@test.com");
        
        WebElement TxfPassword = driver.findElement(By.id("passwd"));
        TxfPassword.sendKeys("12345");
        
        WebElement BotaoLogin = driver.findElement(By.id("SubmitLogin"));         
        BotaoLogin.click();
        
        new WebDriverWait(driver, 10)
        .until(ExpectedConditions.presenceOfElementLocated(By.id("my-account")));
                 
        WebElement PgHeading = driver.findElement(By.className("page-heading")); 
        System.out.println(PgHeading.getText());    
        assertTrue(PgHeading.getText().equals("MY ACCOUNT"));
        //WebElement PagLogin = driver.findElement(By.id("my-account"));        
        //assertTrue(PagLogin.isDisplayed());            	
    }       
    
    @Test
    public void T003_Efetuar_Logoff() {
        WebElement BotaoLogout = driver.findElement(By.className("logout"));        
        //System.out.println(BotaoLogout.getTagName()); 
        BotaoLogout.click();
        WebElement BotaoLogin = driver.findElement(By.className("login"));   
        assertTrue(BotaoLogin.isDisplayed());  
    }
        
    @Test
    public void T004_RealizarLoginComFalha() {    
    //this.Acessar_Pagina_Login_Create();
    assertTrue( Acessar_Pagina_Login_or_Create());
    WebElement TxfEmail = driver.findElement(By.id("email"));
    TxfEmail.sendKeys("andre@test.com");    
    WebElement TxfPassword = driver.findElement(By.id("passwd"));
    TxfPassword.sendKeys("123456");    
    WebElement BotaoLogin = driver.findElement(By.id("SubmitLogin"));         
    BotaoLogin.click();   
    
    new WebDriverWait(driver, 10)
    .until(ExpectedConditions.presenceOfElementLocated(By.className("alert-danger")));  
    WebElement MsgAlert = driver.findElement(By.className("alert-danger"));    
    assertTrue(MsgAlert.isDisplayed());
    assertTrue(MsgAlert.getText().contains("Authentication failed.") );
    
    }
        
    @Test
    public void TPG_001_RealizarLoginComSucesso() {    	
    	customerPG.abrirPaginaLogin();
    	customerPG.preencherEmail("andre@test.com");
    	customerPG.preencherPassword("12345");
    	customerPG.clicarNoBotaoLogin();       
        assertTrue(customerPG.retornarMensagem().equals("MY ACCOUNT"));
    }    
    
    @Test
    public void TPG_002_Efetuar_Logoff() {
    	customerPG.clicarNoBotaoLogout();   
        assertTrue(customerPG.retornarMensagem().equals("logout"));          
    }
        
    @Test
    public void TPG_003_RealizarLoginComFalha() {    	    	    
    	customerPG.abrirPaginaLogin();
    	customerPG.preencherEmail("andre@test.com");
    	customerPG.preencherPassword("123456");
    	customerPG.clicarNoBotaoLogin();      
    	assertTrue(customerPG.retornarMensagem().contains("Authentication failed.")); 
    
    }
    
}
