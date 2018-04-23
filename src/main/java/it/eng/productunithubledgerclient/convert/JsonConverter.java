package it.eng.productunithubledgerclient.convert;


import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import it.eng.productunithubledgerclient.exception.ProductUnitHubException;


public class JsonConverter {

    public static String convertToJson(Object obj) throws ProductUnitHubException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE); //This property put data in upper camel case
            return mapper.writeValueAsString( obj );
        } catch (Exception e) {
            throw new ProductUnitHubException();
        }
    }

    public static Object convertFromJson(String json, Class clazz) throws ProductUnitHubException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true); //This property serialize/deserialize not considering the case of fields
            return mapper.readValue( json, clazz );
        } catch (Exception e) {
            throw new ProductUnitHubException();
        }
    }

}

