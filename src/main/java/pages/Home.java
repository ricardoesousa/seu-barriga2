package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

import static org.junit.Assert.assertEquals;

public class Home {

    @FindBy(css="div.alert.alert-success")
    private WebElement msgBemVindo;

    public boolean validaEntrada(String valEntrada) {
        String txtBemVindo = msgBemVindo.getText();
        assertEquals(valEntrada, txtBemVindo);
        Report.takeScreenshot();
        return true;
    }

}

