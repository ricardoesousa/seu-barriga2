package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

public class Cadastro {

    @FindBy(css="#nome")
    private WebElement txtNome;

    @FindBy(css="#email")
    private WebElement txtEmail;

    @FindBy(css="#senha")
    private WebElement txtSenha;

    @FindBy(css="input[type='submit']")
    private WebElement btnCadastrar;

    public void preencheFormulario(String nome, String email, String senha) {

        txtNome.sendKeys(nome);
        txtEmail.sendKeys(email);
        txtSenha.sendKeys(senha);
        Report.tiraFotoDaTela();
    }

    public void salvaCadastro() {
        btnCadastrar.click();
    }

}
