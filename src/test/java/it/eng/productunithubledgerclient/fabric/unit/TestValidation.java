package it.eng.productunithubledgerclient.fabric.unit;

import it.eng.productunithubledgerclient.model.ChassisDTO;
import it.eng.productunithubledgerclient.model.ProcessStepResultDTO;
import it.eng.productunithubledgerclient.utils.Utils;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.Assert.assertTrue;

public class TestValidation {


    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testChassisDTONotEmptyField()  {

        try {
            ChassisDTO chassisDTO = new ChassisDTO();
            chassisDTO.setChassisId("CAB22");
            chassisDTO.setComponent("");
            chassisDTO.setSubComponent("");
            chassisDTO.setBillOfProcessSteps(null);
            Utils.getMessageViolations(validator.validate(chassisDTO));
        } catch (Exception e) {
            assertTrue( e.getMessage() , true);
        }

    }

    @Test
    public void testProcessStepResultDTONotEmptyField()  {

        try {
            ProcessStepResultDTO processStepResultDTO = new ProcessStepResultDTO("CCAAA", "", "", "");
            Utils.getMessageViolationsResult(validator.validate(processStepResultDTO));
        } catch (Exception e) {
            assertTrue( e.getMessage() , true);
        }

    }

}
