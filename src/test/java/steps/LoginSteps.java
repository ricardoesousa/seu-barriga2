package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import report.Report;

import static org.junit.Assert.assertTrue;

public class LoginSteps extends DriverManagerFactory implements DefaultProperties {

    private Home home = PageFactory.initElements(getDriver(), Home.class);
    private Login login = PageFactory.initElements(getDriver(), Login.class);

    @Dado("eu tenha acessado a aplicação e esteja na página de login")
    public void euTenhaAcessadoAAplicaçãoEEstejaNaPáginaDeLogin() {
        login.acessaAplicacao();
    }

    @Quando("eu logar no sistema com dados válidos")
    public void euLogarNoSistemaComDadosVálidos() {
        login.entra(EMAIL,SENHA);
    }

    @Entao("eu devo acessar a home e ver uma mensagem com o nome de usuário")
    public void euDevoAcessarAHomeEVerUmaMensagemComONomeDeUsuário() {
        assertTrue(home.validaEntrada(MSG_BEM_VINDO));
    }

    @Quando("eu logar no sistema com senha inválida")
    public void euLogarNoSistemaComSenhaInválida() {
        login.entra(EMAIL, SENHA_ERRADA);
    }

    @Entao("eu devo ver uma mensagem indicando que houve problema no login")
    public void euDevoVerUmaMensagemIndicandoQueHouveProblemaNoLogin() {
        Report.tiraFotoDaTela();
    }
}
