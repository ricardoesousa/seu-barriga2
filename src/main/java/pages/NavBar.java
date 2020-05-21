package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

public class NavBar {

    @FindBy(css="a[href='/cadastro']")
    private WebElement lnkNovoUsuario;

    @FindBy(css="a[href='/movimentacao']")
    private WebElement lnkCriarMovimentacao;

    @FindBy(css="a[href='/logout']")
    private WebElement lnkSair;

    @FindBy(css="a[class=dropdown-toggle]")
    private WebElement lnkCriarConta;

    @FindBy(css="a[href='/addConta']")
    private WebElement drpAdicionar;

    public void criaNovoUsuario() {
        lnkNovoUsuario.click();
    }

    public void criaMovimentacao ()
    {
        lnkCriarMovimentacao.click();
    }

    public void criaConta ()
    {
        lnkCriarConta.click();
        drpAdicionar.click();
    }

    public void sai()
    {
        lnkSair.click();
        Report.takeScreenshot();
    }
}
