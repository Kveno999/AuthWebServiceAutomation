package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;

@Log4j2
public class YamlSerializerUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

    @SneakyThrows
    public static <T> T deserialize(File file, Class<T> clazz) {
        try {
            return objectMapper.readValue(file, clazz);
        } catch (IOException e) {
            log.error(String.format("Error while parsing yaml file! :: %s", e.getMessage()));
            throw new IOException();
        }
    }

}
