package TreinamentoSelenium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import TreinamentoSelenium.Page.LoginPO;

public class aula1 extends BaseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void preparaTestes(){
        loginPage = new LoginPO(driver);        
    	String url = "https://www.saucedemo.com/";;
    	driver.get(url);             
    }
        
    @AfterClass
    public static void finalizadTestes() {
    	System.out.println("Acabou");
    	driver.close();
    }
    
    @Test
    public void T001_RealizarLoginComSucesso() {
    	driver.get("https://www.saucedemo.com/");
        /*WebElement CampoUsername = driver.findElement(By.id("user-name"));
        CampoUsername.sendKeys("standard_user");
        WebElement credenciais = driver.findElement(By.xpath("//div[@class = 'login_credentials_wrap']"));
        System.out.println(credenciais.getText());
        WebElement CampoPassword = driver.findElement(By.id("password"));
        CampoPassword.sendKeys("secret_sauce");
        WebElement BotaoLogin = driver.findElement(By.xpath("//*[@value = 'Login']"));
        BotaoLogin.click();
          WebElement Products = driver.findElement(By.className("header_secondary_container"));
        assertTrue(Products.isDisplayed());*/

        //Segunda Refatoração
        /*loginPage.INPUsername.sendKeys("standard_user");
          loginPage.INPPassword.sendKeys("secret_sauce");*/

        loginPage.preencherUsername("standard_user");
        loginPage.preencherPassword("secret_sauce");
        loginPage.clicarNoBotaoLogin();
        //Realizando a assertiva do nosso teste
        assertTrue(loginPage.LBLProducts.isDisplayed());
                     
    }

    @Test
    public void T002_RealizarLoginComErro(){
    	driver.get("https://www.saucedemo.com/");
        loginPage.preencherUsername("locked_out_user");
        loginPage.preencherPassword("secret_sauce");
        loginPage.clicarNoBotaoLogin();

        //Realizando a assertiva do nosso teste
        //String mensagemErro = loginPage.MSGErro.getText();
        //System.out.println("O que esta vindo dentro do elemento: "+ mensagemErro);
        assertEquals("Epic sadface: Sorry, this user has been locked out.",
        loginPage.retornarMensagemDeErro());
        assertTrue(loginPage.MSGErro.isDisplayed());

    }

}
