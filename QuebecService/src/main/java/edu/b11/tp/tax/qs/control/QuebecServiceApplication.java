package edu.b11.tp.tax.qs.control;

import edu.b11.tp.tax.qs.persistence.ITaxBracketDAO;
import edu.b11.tp.tax.qs.persistence.TaxBracketDAO_JDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages ="edu.b11.tp.tax.qs.api")

@SpringBootApplication
public class QuebecServiceApplication {

@Bean
	ITaxBracketDAO getTaxBracketDAO() {
	    return new TaxBracketDAO_JDBC();
}

	public static void main(String[] args) {
		SpringApplication.run(QuebecServiceApplication.class, args);
	}


}
