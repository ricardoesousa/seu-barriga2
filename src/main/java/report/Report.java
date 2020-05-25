package report;

import driver.DriverManagerFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Report {

    @Attachment(value = "Foto da Tela", type = "image/png")
    public static byte[] tiraFotoDaTela() {
        return ((TakesScreenshot) DriverManagerFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
