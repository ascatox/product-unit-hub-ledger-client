package it.eng.productunithubledgerclient;

import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.convert.JsonConverter;
import it.eng.productunithubledgerclient.model.InstructionText;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJsonConverter {


    @Before
    public void start() {
    }

    @After
    public void stop() {
    }

    @Test
    public void testConvertToJsonInstructionTest() {
        InstructionText instructionText = new InstructionText();
        instructionText.setText( "ciao" );
        instructionText.setRtf( "hello" );
        try {
            String toJson = JsonConverter.convertToJson( instructionText );
            assertFalse( "Json returned is empty", StringUtils.isEmpty( toJson ) );
            Object object = JsonConverter.convertFromJson( toJson, InstructionText.class );
            InstructionText instructionText1 = (InstructionText) object;
            assertEquals( "Test equals instructionText!", instructionText, instructionText1 );
        } catch (ProductUnitHubException e) {
            assertFalse( e.getMessage(), true );
        }
    }

}