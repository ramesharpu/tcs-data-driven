package utils;

import java.io.InputStream;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

/**
 * Utility class for reading YAML files and converting them into a {@link HashMap}.
 * 
 * This class uses SnakeYAML library to parse YAML content from the resource folder.
 * 
 * Author: ramesh
 */
public class ReadFiles {

    /**
     * Reads a YAML file from the classpath and converts it into a {@link HashMap}.
     * 
     * @param fileName The name of the YAML file to read (e.g., "user.yaml").
     * @return A {@link HashMap} representing the YAML content as key-value pairs.
     *         Returns {@code null} if the file is not found or can't be loaded.
     * 
     * @throws RuntimeException if the file is missing or malformed.
     */
    public HashMap<String, Object> readYamlFile(String fileName) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new RuntimeException("YAML file not found: " + fileName);
        }

        HashMap<String, Object> map = yaml.load(inputStream);
        return map;
    }
}
