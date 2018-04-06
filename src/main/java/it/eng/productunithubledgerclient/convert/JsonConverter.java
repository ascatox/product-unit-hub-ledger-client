package it.eng.productunithubledgerclient.convert;


import com.fasterxml.jackson.databind.ObjectMapper;
import it.eng.productunithubledgerclient.exception.ProductUnitHubException;


public class JsonConverter {

    public static String convertToJson(Object obj) throws ProductUnitHubException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString( obj );
        } catch (Exception e) {
            throw new ProductUnitHubException();
        }
    }

    public static Object convertFromJson(String json, Class clazz) throws ProductUnitHubException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue( json, clazz );
        } catch (Exception e) {
            throw new ProductUnitHubException();
        }
    }

}

