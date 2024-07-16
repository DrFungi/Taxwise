package edu.b11.tp.tax.qs.api;


import edu.b11.tp.tax.qs.service.TaxCalculator;
import edu.b11.tp.tax.qs.persistence.ITaxBracketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@RestController
//http://localhost:8084/
@RequestMapping("/api/qs")
public class QuebecRestService {
@Autowired
    private ITaxBracketDAO dao;
/*@Autowired
private WebClient.Builder webClientBuilder;*/
//http://localhost:8084/api/qs/quebecTax?authority=Quebec&income=25000
    @RequestMapping("/quebecTax")
     public double getQuebecTax(@RequestParam Map<String,String> allParams) {

        double income;
        double tax=0.0;
        try {
            income = Double.parseDouble(allParams.get("income"));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Income must be a decimal number");
        }
        String authority = allParams.get("authority");
          /*String request = "localhost:8084/api/qs/quebecTax?authority="+authority+"&income="+income;

            tax = webClientBuilder.build()
                .get()
                .uri(request)
                .retrieve()
                .bodyToMono(Double.class)
                .block();
*/
        TaxCalculator service = new TaxCalculator(dao);
        return service.calculateTax(authority, income);
    }
}
