package it.eng.productunithubledgerclient.unit;

import it.eng.productunithubledgerclient.model.OperationStep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TestModelOperationStep {
    private OperationStep operationStep = new OperationStep(  );

    @Before
    public void start() {
    }

    @After
    public void stop() {
    }

    @Test
    public void testModelOperationStep(){
        try {
            operationStep.setSequenceNo( 2 );
            assertNotNull("SequenceNo is empty", operationStep.getSequenceNo() );


        } catch (Exception e) {
            assertFalse(e.getMessage(), true);
        }

    }


}

