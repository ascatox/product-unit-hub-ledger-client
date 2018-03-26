package it.eng.productunithubledgerclient;

import it.eng.productunithubledgerclient.model.ProcessStep;
import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TestModelProcessStep {

    private ProcessStep processStep = new ProcessStep(  );


    @Before
    public void start() {
    }

    @After
    public void stop() {
    }

    @Test
    public void testModelProcessStep(){
        try {
            processStep.setPlannedProductionTime( 1 );
            processStep.setSequenceNo( 2 );


            assertNotNull("plannedProductionTime is empty", processStep.getPlannedProductionTime() );
            assertNotNull( "SequenceNo is empty", processStep.getSequenceNo() );

        } catch (Exception e) {
            assertFalse(e.getMessage(), true);
        }

    }
}




