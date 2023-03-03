package structure.configuration;

import framework.utilities.JsonConfigFile;

import java.nio.file.Path;
import java.nio.file.Paths;

import static framework.utilities.JsonConfigFile.*;

public class Configuration {

    private Configuration() {
        throw new InstantiationError("Should not instantiate static class");
    }

    public static void readConfigFile() {
        Path configPath = Paths.get("src/main/resources/config.json");
        JsonConfigFile.getConfigFileContent(configPath);
    }

    public static String getStartUrl() {
        return getValue("startUrl");
    }

    public static String getApiUrl() {
        return getValue("apiUrl");
    }

    public static int getTimeoutPageLoad() {
        return Integer.parseInt(getValue("timeoutPageLoad"));
    }

    public static int getImplicitWait() {
        return Integer.parseInt(getValue("timeoutImplicit"));
    }
}
