package it.eng.productunithubledgerclient.fabric.unit;

import it.eng.productunithubledgerclient.model.Material;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;

import static org.junit.Assert.assertFalse;

public class TestModelMaterial {

    private Material material = new Material(  );



    @Before
    public void start() {
    }

    @After
    public void stop() {
    }

    @Test
    public void testModelMaterial(){
        try {
            material.setPartNo( "1" );

            assertFalse("partNo is empty", null == material || StringUtils.isEmpty(material.getPartNo()));


        } catch (Exception e) {
            assertFalse(e.getMessage(), true);
        }

    }

}
