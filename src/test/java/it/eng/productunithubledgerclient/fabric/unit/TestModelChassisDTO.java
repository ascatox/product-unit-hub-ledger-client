package it.eng.productunithubledgerclient.fabric.unit;

import it.eng.productunithubledgerclient.model.ChassisDTO;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TestModelChassisDTO {

    private ChassisDTO chassisDTO = new ChassisDTO();

    @Before
    public void start() {
    }

    @After
    public void stop() {
    }

    @Test
    public void testModelChassisDTO() {
        try {
            chassisDTO.setChassisId( "1" );
            chassisDTO.setComponent( "comp" );
            chassisDTO.setSubComponent( "subcomp" );
            assertFalse( "ChassisDTO is empty", null == chassisDTO || StringUtils.isEmpty( chassisDTO.getChassisId() ) );
            assertFalse( "ChassisDTO is empty", null == chassisDTO || StringUtils.isEmpty( chassisDTO.getComponent() ) );
            assertFalse( "ChassisDTO is empty", null == chassisDTO || StringUtils.isEmpty( chassisDTO.getSubComponent() ) );


        } catch (Exception e) {
            assertFalse( e.getMessage(), true );
        }
    }
}
