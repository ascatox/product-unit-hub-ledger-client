package it.eng.productunithubledgerclient.convert;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.ChassisDTO;
import it.eng.productunithubledgerclient.model.ProcessStep;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class JsonConverter {
    private final static Logger log = LogManager.getLogger(JsonConverter.class);

    public enum TypeOfModel {
        ChassisDTO, ProcessStep, ProcessStepResultDTO
    }


    public static String convertToJson(Object obj) throws ProductUnitHubException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE); //This property put data in upper camel case
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
    }

    public static Object convertFromJson(String json, Class clazz, boolean isCollection) throws ProductUnitHubException {
        try {
            if (StringUtils.isEmpty(json))
                throw new ProductUnitHubException("Json data is EMPTY");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true); //This property serialize/deserialize not considering the case of fields
            if (isCollection) {
                ObjectReader objectReader = null;
                if (clazz.getSimpleName().equals(TypeOfModel.ChassisDTO.name()))
                    objectReader = mapper.reader().forType(new TypeReference<List<ChassisDTO>>() {
                    });
                else if (clazz.getSimpleName().equals(TypeOfModel.ProcessStep.name()))
                    objectReader = mapper.reader().forType(new TypeReference<List<ProcessStep>>() {
                    });
                return objectReader.readValue(json);
            }
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error(e);
            throw new ProductUnitHubException(e);
        }
    }

}


