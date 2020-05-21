package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

import static org.junit.Assert.assertEquals;

public class Contas  {

    @FindBy(css="#nome")
    private WebElement txtNome;

    @FindBy(css="button[type='submit']")
    private WebElement btnSalvar;

    @FindBy(css="div.alert.alert-success")
    private WebElement msgContaAdicionadaComSucesso;


    public void preencheFormulario (String nome) {
        txtNome.sendKeys(nome);
        Report.takeScreenshot();
    }

    public void salvaConta (){
        btnSalvar.click();
    }

    public boolean validaConta(String valConta) {
        String txtContaAdicionadaComSucesso = msgContaAdicionadaComSucesso.getText();
        assertEquals(valConta, txtContaAdicionadaComSucesso);
        Report.takeScreenshot();
        return true;
    }

}
