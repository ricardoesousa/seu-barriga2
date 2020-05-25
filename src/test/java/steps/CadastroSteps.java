package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.support.PageFactory;
import pages.Cadastro;
import pages.Login;
import pages.NavBar;
import report.Report;

import static org.junit.Assert.assertTrue;

public class CadastroSteps extends DriverManagerFactory implements DefaultProperties {

    private NavBar navBar = PageFactory.initElements(getDriver(), NavBar.class);
    private Login login = PageFactory.initElements(getDriver(), Login.class);
    private Cadastro cadastro = PageFactory.initElements(getDriver(), Cadastro.class);

    @Dado("eu tenha acessado a aplicação e esteja na página de cadastro de novo usuário")
    public void euTenhaAcessadoAAplicaçãoEEstejaNaPáginaDeCadastroDeNovoUsuário() {
        login.acessaAplicacao();
        navBar.criaNovoUsuario();
    }

    @Quando("eu criar um novo usuário com dados válidos")
    public void euCriarUmNovoUsuárioComDadosVálidos() {
        cadastro.preencheFormulario(NOME,EMAIL,SENHA);
        cadastro.salvaCadastro();
    }

    @Entao("eu devo ver uma mensagem indicando que o usuário foi criado com sucesso")
    public void euDevoVerUmaMensagemIndicandoQueOUsuarioFoiCriadoComSucesso() {
        assertTrue(login.validaCadastro(MSG_CADASTRO_SUCESSO));
    }

    @Quando("eu criar um novo usuário com email inválido")
    public void euCriarUmNovoUsuárioComEmailInválido() {
        cadastro.preencheFormulario(NOME, EMAIL_FORMATO_INVALIDO,SENHA);
        cadastro.salvaCadastro();
    }

    @Entao("eu devo ver uma mensagem indicando que o o email está no formato inválido")
    public void euDevoVerUmaMensagemIndicandoQueOOEmailEstáNoFormatoInválido() {
        Report.tiraFotoDaTela();
    }
}
