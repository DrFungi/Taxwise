package edu.b11.tp.tax.cs.control;

import edu.b11.tp.tax.cs.persistence.ITaxBracketDAO;
import edu.b11.tp.tax.cs.persistence.TaxBracketDAO_JDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

@ComponentScan(basePackages ="edu.b11.tp.tax.cs.api")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CanadaServiceApplication {

@Bean
	ITaxBracketDAO getTaxBracketDAO() {
	return new TaxBracketDAO_JDBC();
}
/*@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(CanadaServiceApplication.class, args);
	}


}
