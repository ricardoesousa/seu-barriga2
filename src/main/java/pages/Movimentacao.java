package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import report.Report;

import static org.junit.Assert.assertEquals;

public class Movimentacao  {

    @FindBy (css="#tipo")
    private WebElement txtTipodeMovimentacao;

    @FindBy (css="#data_transacao")
    private WebElement txtDataDaMovimentacao;

    @FindBy (css="#data_pagamento")
    private WebElement txtDataDoPagamento;

    @FindBy (css="#descricao")
    private WebElement txtDescricao;

    @FindBy (css="#interessado")
    private WebElement txtInteressado;

    @FindBy (css="#valor")
    private WebElement txtValor;

    @FindBy (css="#conta")
    private WebElement txtConta;

    @FindBy (css="#status_pendente")
    private WebElement rdoPendente;

    @FindBy (css="#status_pago")
    private WebElement rdoPago;

    @FindBy(css="button[type='submit']")
    private WebElement btnSalvar;

    @FindBy(css="div.alert.alert-success")
    private WebElement msgMovimentacaoAdicionadaComSucesso;

    @FindBy(css="div.alert.alert-danger")
    private WebElement msgMovimentacaoComDataMenor;

    public void preencheFormulario (String tipoMovimentacao, String dataMovimentacao, String dataPagamento, String descricao, String interessado, String valor, String conta, String situacao ) {

        new Select(txtTipodeMovimentacao).selectByVisibleText(tipoMovimentacao);
        txtDataDaMovimentacao.sendKeys(dataMovimentacao);
        txtDataDoPagamento.sendKeys(dataPagamento);
        txtDescricao.sendKeys(descricao);
        txtInteressado.sendKeys(interessado);
        txtValor.sendKeys(valor);
        txtConta.sendKeys(conta);
        if(situacao == "pendente"){
            rdoPendente.click();}
        if (situacao == "pago"){
            rdoPago.click();}
        Report.tiraFotoDaTela();

    }

    public void salvaMovimentacao() {
        btnSalvar.click();
    }

    public boolean validaMovimentacao (String valMovimentacao) {
        String txtMovimentacaoAdicionadaComSucesso = msgMovimentacaoAdicionadaComSucesso.getText();
        assertEquals(valMovimentacao, txtMovimentacaoAdicionadaComSucesso);
        Report.tiraFotoDaTela();
        return true;
    }

    public boolean validaMovimentacaoDataMenor (String valMovimentacaoDataMenor) {
        String txtMovimentacaoComDataMenor = msgMovimentacaoComDataMenor.getText();
        assertEquals(valMovimentacaoDataMenor, txtMovimentacaoComDataMenor);
        Report.tiraFotoDaTela();
        return true;
    }
}