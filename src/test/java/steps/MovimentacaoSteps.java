package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.support.PageFactory;
import pages.Login;
import pages.Movimentacao;
import pages.NavBar;

import static org.junit.Assert.assertTrue;

public class MovimentacaoSteps extends DriverManagerFactory implements DefaultProperties {

    private NavBar navBar = PageFactory.initElements(getDriver(), NavBar.class);
    private Login login = PageFactory.initElements(getDriver(), Login.class);
    private Movimentacao movimentacao = PageFactory.initElements(getDriver(), Movimentacao.class);

    @Dado("eu esteja logado e tenha acessado a página de movimentação")
    public void euEstejaLogadoETenhaAcessadoAPáginaDeMovimentação() {
        login.acessaAplicacao();
        login.entra(EMAIL,SENHA);
        navBar.criaMovimentacao();
    }

    @Quando("eu criar a movimentação com dados válidos")
    public void euCriarAMovimentaçãoComDadosVálidos() {
        movimentacao.preencheFormulario(DESPESA, HOJE, ONTEM
                ,DESCRICAO,INTERESSADO,VALOR,CONTA,PAGO);
        movimentacao.salvaMovimentacao();
    }

    @Entao("eu devo ver uma mensagem indicando que a movimentação foi criada com sucesso")
    public void euDevoVerUmaMensagemIndicandoQueAMovimentaçãoFoiCriadaComSucesso() {
        assertTrue(movimentacao.validaMovimentacao(MSG_MOVIMENTACAO_SUCESSO));
    }

    @Quando("eu criar a movimentação com data posterior à atual")
    public void euCriarAMovimentaçãoComDataPosteriorÀAtual() {
        movimentacao.preencheFormulario(DESPESA, AMANHA, ONTEM
                ,DESCRICAO,INTERESSADO,VALOR,CONTA,PAGO);
        movimentacao.salvaMovimentacao();
    }

    @Entao("eu devo ver uma mensagem indicando que a data está fora dos parâmetros")
    public void euDevoVerUmaMensagemIndicandoQueADataEstáForaDosParâmetros() {
        assertTrue(movimentacao.validaMovimentacaoDataMenor(MSG_MOVIMENTACAO_DATA_MENOR));

    }
}
