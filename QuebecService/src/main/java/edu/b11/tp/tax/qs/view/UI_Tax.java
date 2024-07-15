package edu.b11.tp.tax.qs.view;

import edu.b11.tp.tax.qs.persistence.ITaxBracketDAO;
import edu.b11.tp.tax.qs.persistence.TaxBracketDAO_JDBC;
import edu.b11.tp.tax.qs.service.TaxCalculator;

public class UI_Tax {

    public TaxCalculator taxCalculatorCanada;


    public UI_Tax(){
        ITaxBracketDAO dao_tax = new TaxBracketDAO_JDBC();
        //ITaxBracketDAO dao_tax = new TaxBracketDAO_JPA;  if this implementation exists
        this.taxCalculatorCanada = new TaxCalculator(dao_tax);

    } // end of constructor

    public double displayTaxToPayCanada(String taxAuthority, double income) {
        return taxCalculatorCanada.calculateTax(taxAuthority, income);
    }




    public static void main(String[] args) {
        UI_Tax tax = new UI_Tax();
        //String taxAuthorityQ = "Quebec";
        //double incomeQ = 25000;
        //double taxToPayQ = calculateTax(taxAuthorityQ, incomeQ);
        String taxAuthorityC = "Quebec";
        double incomeC = 25000;
        double taxToPayC = tax.displayTaxToPayCanada(taxAuthorityC, incomeC);
        //double taxToPayT = taxToPayC + taxToPayQ;
        //System.out.println("the tax to pay quebec is:");
        //System.out.println("$ "+taxToPayQ);
        System.out.println("the tax to pay Quebec is:");
        System.out.println("$ "+taxToPayC);
        //System.out.println("the tax to pay combined is:");
        //System.out.println("$ " +taxToPayT);
    }
}
