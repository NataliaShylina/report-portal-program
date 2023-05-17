package org.example.reader;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private final Properties properties;

    public PropertyReader(String propertyFileName) {
        this.properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(propertyFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
