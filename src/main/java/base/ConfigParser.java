package base;

import base.services.ParserService;
import data.models.config.ServiceConfig;
import utils.YamlSerializerUtils;

import java.io.File;

public class ConfigParser implements ParserService<ServiceConfig> {
    @Override
    public ServiceConfig deserialize() {
        return YamlSerializerUtils
                .deserialize(new File("src/test/resources/service_config.yaml"), ServiceConfig.class);
    }
}
