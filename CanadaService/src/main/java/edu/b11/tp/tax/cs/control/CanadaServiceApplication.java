package edu.b11.tp.tax.cs.control;

import edu.b11.tp.tax.cs.persistence.ITaxBracketDAO;
import edu.b11.tp.tax.cs.persistence.TaxBracketDAO_JDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages ="edu.b11.tp.tax.cs.api")

@SpringBootApplication
public class CanadaServiceApplication {

@Bean
	ITaxBracketDAO getTaxBracketDAO() {
	    return new TaxBracketDAO_JDBC();
}

	public static void main(String[] args) {
		SpringApplication.run(CanadaServiceApplication.class, args);
	}


}
