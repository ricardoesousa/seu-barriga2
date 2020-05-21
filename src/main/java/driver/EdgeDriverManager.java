package driver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

import java.io.File;

public class EdgeDriverManager extends DriverManager {

    EdgeDriverService edgeService;

    @Override
    void startService() {
        if (edgeService == null) {
            edgeService = new EdgeDriverService.Builder()
                    .usingDriverExecutable(new File("src\\test\\resources\\msedgedriver.exe"))
                    .usingAnyFreePort()
                    .build();
        }
    }

    @Override
    void stopService() {
        if (edgeService != null && edgeService.isRunning()) {
            edgeService.stop();
        }
    }

    @Override
    void createDriver() {
    driver = new EdgeDriver(edgeService);
    }
}
