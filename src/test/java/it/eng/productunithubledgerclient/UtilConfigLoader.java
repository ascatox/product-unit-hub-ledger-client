package it.eng.productunithubledgerclient;

import it.eng.productunithubledgerclient.api.config.ConfigManager;
import it.eng.productunithubledgerclient.api.config.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilConfigLoader {

    @Before
    public void start() {
    }

    @After
    public void stop() {
    }

    @Test
    public void testConfigLoaderFromJSON() {

        Configuration configuration = new Configuration(  );
        configuration.setCryptoconfigdir( "1" );
        configuration.setTimeout( 10 );
        configuration.setChanneName( "2" );
        configuration.setName( "3" );
        configuration.setType( "4" );

        try{
            Configuration configuration1 =  ConfigManager.loadConfigurationFromJSONFile();
            assertFalse( "Configuration is empty", null == configuration1 || StringUtils.isEmpty( configuration1.getChanneName() ) );
            //assertEquals( "Test equals Configuration!", configuration, configuration1 );

        }catch (Exception e) {
            assertFalse( e.getMessage(), true );
        }


    }
}
