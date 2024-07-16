package edu.b11.tp.tax.qs.control;

import edu.b11.tp.tax.qs.persistence.ITaxBracketDAO;
import edu.b11.tp.tax.qs.persistence.TaxBracketDAO_JDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

@ComponentScan(basePackages ="edu.b11.tp.tax.qs.api")

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class QuebecServiceApplication {

@Bean
	ITaxBracketDAO getTaxBracketDAO() {
	    return new TaxBracketDAO_JDBC();
}
/*@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(QuebecServiceApplication.class, args);
	}


}
