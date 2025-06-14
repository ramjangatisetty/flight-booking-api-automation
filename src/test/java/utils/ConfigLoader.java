package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ConfigLoader {

	private static final Properties props = new Properties();

	static {
		String env = System.getProperty("env", "qa");
		String fileName = String.format("config/%s.properties", env);
		try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName)) {
			if (input == null) {
				throw new RuntimeException("Unable to find config file: " + fileName);
			}
			props.load(input);
			log.info("Loaded config for environment: {}", env.toUpperCase());
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config: " + e.getMessage(), e);
		}
	}

	public static String get(String key) {
		String value = props.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Property not found: " + key);
		}
		return value;
	}
}
