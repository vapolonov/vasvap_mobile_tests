package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobile.properties"})
public interface BrowserstackConfig extends Config {
    String username();

    String password();

    String appUrl();

    String remoteUrl();

    String videoUrl();
}
