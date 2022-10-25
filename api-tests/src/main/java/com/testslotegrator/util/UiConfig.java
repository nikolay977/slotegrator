package com.testslotegrator.util;

import org.aeonbits.owner.Config;

@Config.Sources("file:./src/main/resources/UiConfig.properties")
public interface UiConfig extends Config {

    @Key("base.url")
    String baseUrl();

    @Key("base.path")
    String basePath();

    @Key("username")
    String userName();

    @Key("pass")
    String pass();

    @Key("oauth2.token")
    String oauth2Token();
}
