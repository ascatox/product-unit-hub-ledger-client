package it.eng.productunithubledgerclient.api;

import it.eng.productunithubledgerclient.api.config.ConfigManager;
import it.eng.productunithubledgerclient.api.config.Configuration;
import it.eng.productunithubledgerclient.api.config.Organization;
import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.api.helper.Function;
import it.eng.productunithubledgerclient.api.helper.InvokeReturn;
import it.eng.productunithubledgerclient.api.helper.LedgerInteractionHelper;
import it.eng.productunithubledgerclient.api.helper.QueryReturn;
import it.eng.productunithubledgerclient.convert.JsonConverter;
import it.eng.productunithubledgerclient.model.ChassisDTO;
import it.eng.productunithubledgerclient.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


final public class LedgerClient implements it.eng.productunithubledgerclient.api.base.LedgerClient {

    private final static Logger log = LogManager.getLogger(LedgerClient.class);

    private LedgerInteractionHelper ledgerInteractionHelper;
    private ConfigManager configManager;
    private Validator validator;

    public LedgerClient() throws ProductUnitHubException {
        doLedgerClient();
    }


    public void doLedgerClient() throws ProductUnitHubException {
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
            configManager = new ConfigManager();
            Configuration configuration = configManager.getConfiguration();
            if (null == configuration || null == configuration.getOrganizations() || configuration.getOrganizations().isEmpty()) {
                log.error("Configuration missing!!! Check you config file!!!");
                throw new ProductUnitHubException("Configuration missing!!! Check you config file!!!");
            }
            List<Organization> organizations = configuration.getOrganizations();
            //for (Organization org : organizations) {
            //FIXME multiple Organizations
            ledgerInteractionHelper = new LedgerInteractionHelper(configManager, organizations.get(0));
            //}
        } catch (Exception e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
    }

    public void storeProcessStepRouting(List<ChassisDTO> chassisDTOs) throws ProductUnitHubException {
        if (chassisDTOs == null || chassisDTOs.isEmpty())
            throw new ProductUnitHubException(Function.storeProcessStepRouting.name() + " is in error, No input data!");
        for (ChassisDTO chassisDTO : chassisDTOs) {
            Set<ConstraintViolation<ChassisDTO>> violations = validator.validate(chassisDTO);
            Utils.getMessageViolations(violations);
        }
        String json = JsonConverter.convertToJson(chassisDTOs);
        final String payload = doInvokeByJson(Function.storeProcessStepRouting, json);
    }


    public void storeProcessStepResult(ChassisDTO chassisDTO) throws ProductUnitHubException {
        if (chassisDTO == null || StringUtils.isEmpty(chassisDTO.getChassisId()))
            throw new ProductUnitHubException(Function.storeProcessStepResult.name() + " is in error, No input data!");
        String json = JsonConverter.convertToJson(chassisDTO);
        final String payload = doInvokeByJson(Function.storeProcessStepResult, json);
    }

    @Override
    public void storeProcessStepRouting(String json) throws ProductUnitHubException {
        if (null == json || json.isEmpty())
            throw new ProductUnitHubException(Function.storeProcessStepRouting.name() + " is in error, No input data!");
        final String payload = doInvokeByJson(Function.storeProcessStepRouting, json);
    }

    @Override
    public void storeProcessStepResult(String json) throws ProductUnitHubException {
        if (null == json || json.isEmpty())
            throw new ProductUnitHubException(Function.storeProcessStepResult.name() + " is in error, No input data!");
        final String payload = doInvokeByJson(Function.storeProcessStepResult, json);
    }

    public List<ChassisDTO> getProcessStepRouting(String component, String subComponent) throws ProductUnitHubException {
        if (StringUtils.isEmpty(component) || StringUtils.isEmpty(subComponent))
            throw new ProductUnitHubException(Function.getProcessStepRouting.name() + " is in error, No input data!");
        List<String> args = new ArrayList<>();
        args.add(component);
        args.add(subComponent);
        return doQueryByJson(Function.getProcessStepRouting, args);
    }

    public ChassisDTO getProcessStepResult(String chassisID, String component, String subComponent) throws ProductUnitHubException {
        if (StringUtils.isEmpty(component) || StringUtils.isEmpty(subComponent))
            throw new ProductUnitHubException(Function.getProcessStepResult.name() + " is in error, No input data!");
        List<String> args = new ArrayList<>();
        args.add(chassisID);
        args.add(component);
        args.add(subComponent);
        List<ChassisDTO> chassisDTOS = doQueryByJson(Function.getProcessStepResult, args);
        if(null == chassisDTOS || chassisDTOS.isEmpty()) return null;
        return chassisDTOS.get(0);
    }


    private String doInvokeByJson(Function fcn, String json) throws ProductUnitHubException {
        List<String> args = new ArrayList<>();
        args.add(json);
        final InvokeReturn invokeReturn = ledgerInteractionHelper.invokeChaincode(fcn.name(), args);
        try {
            invokeReturn.getCompletableFuture().get(Utils.getTimeout(), TimeUnit.MILLISECONDS);
            final String payload = invokeReturn.getPayload();
            return payload;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
    }


    private List<ChassisDTO> doQueryByJson(Function fcn, List<String> args) throws ProductUnitHubException {
        List<ChassisDTO> chassisDTOS = new ArrayList<>();
        try {
            final List<QueryReturn> queryReturns = ledgerInteractionHelper.queryChainCode(fcn.name(), args, null);
            for (QueryReturn queryReturn: queryReturns) {
                ChassisDTO fromJson =(ChassisDTO) JsonConverter.convertFromJson(queryReturn.getPayload(), ChassisDTO.class);
                chassisDTOS.add(fromJson);
            }
            return chassisDTOS;
        } catch (Exception e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
    }

}
