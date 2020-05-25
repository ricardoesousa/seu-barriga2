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

public class ContaSteps extends DriverManagerFactory implements DefaultProperties {

    private NavBar navBar = PageFactory.initElements(getDriver(), NavBar.class);
    private Contas contas = PageFactory.initElements(getDriver(), Contas.class);
    private Login login = PageFactory.initElements(getDriver(), Login.class);

    @Dado("eu esteja logado e tenha acessado a página de contas")
    public void euEstejaLogadoETenhaAcessadoAPáginaDeContas() {
        login.acessaAplicacao();
        login.entra(EMAIL,SENHA);
        navBar.criaConta();
    }

    @Quando("eu criar uma nova conta com dados válidos")
    public void euCriarUmaNovaContaComDadosVálidos() {
        contas.preencheFormulario(CONTA);
        contas.salvaConta();
    }

    @Entao("eu devo ver uma mensagem indicando que a conta foi cadastrada com sucesso")
    public void euDevoVerUmaMensagemIndicandoQueAContaFoiCadastradaComSucesso() {
        assertTrue(contas.validaConta(MSG_CONTA_SUCESSO));
    }

    @Quando("eu criar uma nova conta com nome não preenchido")
    public void euCriarUmaNovaContaComNomeNãoPreenchido() {
        contas.preencheFormulario(CONTA_VAZIA);
        contas.salvaConta();
    }

    @Entao("eu devo ver uma mensagem indicando que o dado deve ser informado")
    public void euDevoVerUmaMensagemIndicandoQueODadoDeveSerInformado() {
        Report.tiraFotoDaTela();
    }
}
