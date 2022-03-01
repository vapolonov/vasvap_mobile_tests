package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/selenoid.properties"
})
public interface SelenoidConfig extends Config {

    String selenoidUser();
    String selenoidPassword();
    String apkUrl();
    String videoStorageURL();
}
