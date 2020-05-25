package pages;

import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

import static org.junit.Assert.assertEquals;

public class Login extends DriverManagerFactory implements DefaultProperties {

    @FindBy(css="#email")
    private WebElement txtEmail;

    @FindBy(css="#senha")
    private WebElement txtSenha;

    @FindBy(css="button[type='submit']")
    private WebElement btnEntrar;



    @FindBy(css="div.alert.alert-success")
    private WebElement msgUsuarioInseridoComSucesso;

    public void acessaAplicacao() {
        getDriver().get(URL_BASE);
        Report.tiraFotoDaTela();
    }

    public boolean validaCadastro(String valCadastro) {
        String txtUsuarioInseridoComSucesso = msgUsuarioInseridoComSucesso.getText();
        assertEquals(valCadastro, txtUsuarioInseridoComSucesso);
        Report.tiraFotoDaTela();
        return true;
    }

    public void entra(String email, String senha) {
        txtEmail.sendKeys(email);
        txtSenha.sendKeys(senha);
        Report.tiraFotoDaTela();
        btnEntrar.click();
    }



}
