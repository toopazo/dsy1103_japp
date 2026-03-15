package jdemo;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private Properties props = new Properties();

    public Config() {
        try (InputStream input = getClass()
                .getResourceAsStream("/application.properties")) {
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAppName() {
        return props.getProperty("app.name");
    }

    public int getMaxConnections() {
        return Integer.parseInt(
                props.getProperty("app.max.connections", "10"));
    }
}
