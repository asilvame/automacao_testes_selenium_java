package TreinamentoSelenium.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    public LoginPO (WebDriver driver){
        super(driver);
    }

    @FindBy(id = "user-name")
    public WebElement INPUsername;

    @FindBy(id = "password")
    public WebElement INPPassword;

    @FindBy(xpath = "//*[@value = 'Login']")
    public WebElement BTNLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement MSGErro;

    @FindBy(className = "header_secondary_container")
    public WebElement LBLProducts;

    public void preencherUsername(String username){
        INPUsername.sendKeys(username);
    }

    public void preencherPassword(String password){
        INPPassword.sendKeys(password);
    }

    public void clicarNoBotaoLogin(){
        BTNLogin.click();
    }

    public String retornarMensagemDeErro(){
        return MSGErro.getText();
    }
    
}
