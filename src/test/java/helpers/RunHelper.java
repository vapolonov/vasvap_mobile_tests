package helpers;

import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import drivers.SelenoidMobileDriver;

public class RunHelper {
    public static String deviceHost = System.getProperty("deviceHost");

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        if (deviceHost == null) {
            throw new RuntimeException("Необходимо ввести обязательный параметр -DdeviceHost");
        }

        switch (deviceHost) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "selenoid":
                return SelenoidMobileDriver.class;
            case "local":
                return LocalMobileDriver.class;
            default:
                throw new RuntimeException("Параметр -DdeviceHost может принимать только одно из следующих значений: " +
                        "browserstack/selenoid/emulation/real");
        }
    }
}
