import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigReader {

    private static final String DEFAULT_PATHS = "paths";
    Properties properties;

    ConfigReader(String filePath) throws IOException {
        properties = new Properties();
        properties.load(new FileReader(filePath));
    }

    public List<String> getOperationPaths() {
        String pathsStr = properties.getProperty(DEFAULT_PATHS);
        List<String> res = new ArrayList<>();
        String[] oparations = pathsStr.split(",");
        for (String op : oparations) {
            res.add(op);
        }
        return res;
    }
}
