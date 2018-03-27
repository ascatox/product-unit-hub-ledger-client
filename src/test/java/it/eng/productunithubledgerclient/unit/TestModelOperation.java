package it.eng.productunithubledgerclient.unit;

import it.eng.productunithubledgerclient.model.Operation;
import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TestModelOperation {

    private Operation operation = new Operation(  );

    @Before
    public void start() {
    }

    @After
    public void stop() {
    }

    @Test
    public void testModelOperation(){
        try {
            operation.setSequenceNo( 2 );
            assertNotNull("SequenceNo is empty", operation.getSequenceNo() );


        } catch (Exception e) {
            assertFalse(e.getMessage(), true);
        }

    }


}
