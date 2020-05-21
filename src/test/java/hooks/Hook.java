package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;

import java.util.concurrent.TimeUnit;

public class Hook extends DriverManagerFactory implements DefaultProperties{

    DriverManager driverManager;

    @Before
    public void init(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(DefaultProperties.TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
