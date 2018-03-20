package it.eng.productunithubledgerclient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ProductUnitHubLedgerClientApplication {
	private final static Logger log = LogManager.getLogger(ProductUnitHubLedgerClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductUnitHubLedgerClientApplication.class, args);
	}
}
