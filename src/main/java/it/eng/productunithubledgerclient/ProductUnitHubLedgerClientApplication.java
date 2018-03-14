package it.eng.productunithubledgerclient;

import it.eng.productunithubledgerclient.convert.XMLToJsonConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ProductUnitHubLedgerClientApplication {
	private final static Logger log = LogManager.getLogger(ProductUnitHubLedgerClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductUnitHubLedgerClientApplication.class, args);
		String xml = ("<root>" +
				"<!-- thïs ïs à cómmënt. -->" +
				"  <el ampersand=\"    a &amp;    b\">" +
				"    <selfClosing/>" +
				"  </el>" +
				"</root>");

		String convert = XMLToJsonConverter.Companion.convert(xml);
		log.debug("DATA Converted in JSON: "+convert);
	}
}
