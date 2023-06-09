package TreinamentoSelenium.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPO extends BasePO {

	public CustomerPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private String msg = "";
	private String url = "http://automationpractice.pl/index.php";
    @FindBy(id = "id_gender1")
    public WebElement optM;
    
    @FindBy(id = "id_gender2")
    public WebElement optF;
	
    @FindBy(id = "customer_firstname")
    public WebElement INPfirstname;
    
    @FindBy(id = "customer_lastname")
    public WebElement INPlastname;    
    
    @FindBy(id = "email")
    public WebElement INPemail;    
    
    @FindBy(id = "passwd")
    public WebElement INPPassword;    
    
    @FindBy(id = "submitAccount")
    public WebElement BTNSubmitAccount;
    
    @FindBy(id = "SubmitLogin")
    public WebElement BTNSubmitLogint;
    
    @FindBy(className = "page-heading")
    public WebElement PgHeading;
    
    @FindBy(className = "logout")
    public WebElement BTNLogout;
    
    @FindBy(className = "login")
    public WebElement LinkLogin;
    
    public void preencherGenero(String genero){
    	
    	if(genero.equals("M")) {
    		optM.click();
    	}
    	else if (genero.equals("F")) {
    		optF.clear();
    	}
//    	else {}    	    	
    }
    @FindBy(className = "alert-danger")
    public WebElement MSGErro;
    
    public void abrirPaginaLogin() {    	
    	driver.get(url); 
    	LinkLogin.click();
    }
    public void preencherNome(String nome){
    	INPfirstname.sendKeys(nome);
    }
    public void preencherSobrenome(String sobrenome){
    	INPlastname.sendKeys(sobrenome);
    }
        
    public void preencherEmail(String email){
    	INPemail.sendKeys(email);
    }

    public void preencherPassword(String password){
        INPPassword.sendKeys(password);
    }

    public void clicarNoBotaoLogin(){
    	BTNSubmitLogint.click();    	    	
    	try {
			msg = MSGErro.getText();
		} catch (Exception e) {			
			// TODO: handle exception
			//e.getMessage();
			msg="";
		}    	
    	msg += PgHeading.getText();
    } 
    
    public void clicarNoBotaoLogout(){
    	BTNLogout.click();
    	if(LinkLogin.isDisplayed()) {
    	msg = "logout";
    	} else msg ="";
    }   
    
    public void clicarNoCriarConta(){
    	BTNSubmitAccount.click();
    }
    
    public String retornarMensagemDeErro(){
        return MSGErro.getText();
    }  
    
    public String retornarMensagem(){
        return msg;
    }     
    
}
