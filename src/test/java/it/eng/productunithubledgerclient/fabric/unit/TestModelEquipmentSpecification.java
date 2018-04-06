package it.eng.productunithubledgerclient.fabric.unit;

import it.eng.productunithubledgerclient.model.EquipmentSpecification;
import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TestModelEquipmentSpecification {

    private EquipmentSpecification equipmentSpecification = new EquipmentSpecification(  );

    @Before
    public void start() {
    }

    @After
    public void stop() {
    }

    @Test
    public void testModelQeuipmentSpecification(){
        try {
            equipmentSpecification.setSequenceNo( 20 );
            assertNotNull("SequenceNo is empty", equipmentSpecification.getSequenceNo() );


        } catch (Exception e) {
            assertFalse(e.getMessage(), true);
        }

    }
}
