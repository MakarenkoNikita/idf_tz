package framework.utilities;

import org.json.JSONObject;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.String.*;

public class JsonConfigFile {

    private static JSONObject content;

    public static void getConfigFileContent(Path paths) {
        content = new JSONObject(getFileContent(paths));
    }

    public static String getValue(String jsonPath) {
        return content.get(jsonPath).toString();
    }

    private static String getFileContent(Path path) {
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new UncheckedIOException(format("Content of file %s can't be read as String", path), e);
        }
    }
}
