package it.eng.productunithubledgerclient.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.StringWriter;


public class ConfigManager {

    private final static Logger log = LogManager.getLogger( ConfigManager.class );


    public static Configuration loadConfigurationFromJSONFile() {

        try {
            Resource resource = new ClassPathResource("config.json");
            File file = resource.getFile();
            ObjectMapper objectMapper = new ObjectMapper();
            Configuration configuration = objectMapper.readValue( file, Configuration.class );

            objectMapper.configure( SerializationFeature.INDENT_OUTPUT, true );

            StringWriter stringEmp = new StringWriter();
            objectMapper.writeValue(stringEmp, configuration);
            log.debug( "Configuration JSON is\n"+stringEmp);

            return configuration;
        } catch (Exception e) {
            log.error( e );
            return null;
        }

    }
}