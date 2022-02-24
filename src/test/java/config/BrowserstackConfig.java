package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})

public interface BrowserstackConfig extends Config {

    String username();
    String password();
    String appUrl();
    String remoteUrl();
    String videoUrl();
    String device();
    @Key("os_version")
    String osVersion();
    String project();
    String build();
    String name();
}
