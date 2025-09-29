package utilities;


import org.aeonbits.owner.Config;

@Config.Sources({"file:environmentConfig/${environment}.properties"})
public interface EnvironmentConfig extends Config {

    @Key("App.Url")
    String appUrl();

    @Key("App.User")
    String appUsername();

    @Key("App.Pass")
    String appPassword();
}
