package edu.b11.tp.tax.webtaxfront;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebServlet("/calculate")
public class TaxServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double income;

        try {
            income = Double.parseDouble(req.getParameter("income"));

        } catch (NumberFormatException e){
            req.setAttribute("error", "Invalid income format. Please enter a valid number");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        String authority = req.getParameter("province");
        boolean calculateFederal = req.getParameter("calculateFederal") != null;

        //get the variables to know the tax to pay

        double taxToPayCa = 0.0;
        double taxToPayQc = getTaxQc(authority, income);
        // check if federal tax is requested
        if (calculateFederal){
            String authorityCa = "Canada";
            taxToPayCa = getTaxCa(authorityCa, income);
        }

        //calculate total tax to pay

        double totalTax = taxToPayQc + taxToPayCa;

        String formatedTaxToPayQ = String.format("%.2f", taxToPayQc);
        String formatedTaxToPayC = String.format("%.2f",taxToPayCa);
        String formatedTotalTax = String.format("%.2f",totalTax);
        req.setAttribute("taxQ", formatedTaxToPayQ);
        req.setAttribute("taxC", formatedTaxToPayC);
        req.setAttribute("taxT", formatedTotalTax);
        req.setAttribute("calculateFederal", calculateFederal);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    private double getTaxQc(String authority, double income) {
         String uri = "http://localhost:8084/api/qs/quebecTax?authority=" + authority + "&income=" + income;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return Double.parseDouble(response.body());
            } else {
                // Handle non-200 response codes if needed
                System.out.println("Failed to get Quebec tax. Status code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return 0.0d; // Default return value in case of error
    }

    //http://localhost:8083/api/cs/canadaTax?authority=Canada&income=25000
    private double getTaxCa(String authority, double income) {
        String uri = "http://localhost:8083/api/cs/canadaTax?authority=" + authority + "&income=" + income;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return Double.parseDouble(response.body());
            } else {
                // Handle non-200 response codes if needed
                System.out.println("Failed to get Canada tax. Status code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }

        return 0.0d; // Default return value in case of error
    }

}
