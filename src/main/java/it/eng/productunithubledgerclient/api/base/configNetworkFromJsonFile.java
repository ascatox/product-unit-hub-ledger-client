/*package it.eng.productunithubledgerclient.api.base;

import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;

public class configNetworkFromJsonFile {

    JSONParser parser = new JSONParser( );
    try{
        Object obj = parser.parse( new FileReader( "C:\Users\Claudio\Desktop\ENG_STAGE\config.json"  ));
        JSONObject jsonObject = (JSONPObject) obj;

        String name = (String) jsonObject.get("name");
        String type = (String) jsonObject.get("type");
        String mspID = (String) jsonObject.get("mspID");

        JSONArray peers = (JSONArray) jsonObject.get("peers");
        JSONArray ca = (JSONArray) jsonObject.get("ca");
        JSONArray orderers = (JSONArray) jsonObject.get("orderers");

        String channel = (String) jsonObject.get("channel");
        Integer timeout = (Integer) jsonObject.get("timeout");





    }





}
*/
