package it.eng.productunithubledgerclient;

import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.convert.JsonConverter;
import it.eng.productunithubledgerclient.model.InstructionText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ProductUnitHubLedgerClientApplication {
	private final static Logger log = LogManager.getLogger(ProductUnitHubLedgerClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductUnitHubLedgerClientApplication.class, args);
		InstructionText instructionText = new InstructionText( );
		instructionText.setText( "ciao" );
		instructionText.setRtf( "hello" );
		String result = null;
		try {
			 result = JsonConverter.convertToJson(instructionText);
		} catch (ProductUnitHubException e) {
			e.printStackTrace();
			log.error( e );
		}
		log.info( "Object arrived: "+ result);
	}
}
