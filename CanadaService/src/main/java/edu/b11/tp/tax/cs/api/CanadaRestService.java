package edu.b11.tp.tax.cs.api;

import edu.b11.tp.tax.cs.persistence.ITaxBracketDAO;
import edu.b11.tp.tax.cs.service.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
//http://localhost:8083/
@RequestMapping("/api/cs")
public class CanadaRestService {

 private static final String template = "Exchange REST Controller, %s!";
    private final AtomicLong counter = new AtomicLong();

@Autowired
private ITaxBracketDAO dao;
/*@Autowired
private WebClient.Builder webClientBuilder;
*/
//http://localhost:8083/api/cs/canadaTax?authority=Canada&income=25000
    @RequestMapping("/canadaTax")
     public double getCanadaTax(@RequestParam Map<String,String> allParams) {

        double income;
        double tax=0.0;

        try {
            income = Double.parseDouble(allParams.get("income"));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Income must be a decimal number");
        }
        String authority = allParams.get("authority");
        //http://localhost:8084/api/qs/quebecTax?authority=Quebec&income=25000
        /*String request = "localhost:8083/api/cs/canadaTax?authority="+authority+"&income="+income;

        tax = webClientBuilder.build()
                .get()
                .uri(request)
                .retrieve()
                .bodyToMono(Double.class)
                .block();*/

        TaxCalculator service = new TaxCalculator(dao);
        return service.calculateTax(authority, income);
    }
}
