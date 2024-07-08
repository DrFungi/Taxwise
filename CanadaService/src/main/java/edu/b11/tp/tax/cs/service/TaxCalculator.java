package edu.b11.tp.tax.cs.service;

import edu.b11.tp.tax.cs.persistence.ITaxBracketDAO;
import edu.b11.tp.tax.cs.model.TaxBracket;

import java.util.List;

public class TaxCalculator {
    private ITaxBracketDAO taxBracketDao;

     public TaxCalculator(ITaxBracketDAO taxBracketDao) {
         this.taxBracketDao = taxBracketDao;
     }

     public double calculateTax(double amount, String authority) {
          List<TaxBracket> brackets = taxBracketDao.findAllBrackets(authority,amount);
          double tax = 0;
          for (TaxBracket bracket : brackets) {
               if (amount >= bracket.getMinIncome() && amount <= bracket.getMaxIncome()) {
                    tax += amount * bracket.getTaxRate();
               }
          }
          return tax;
     }




}
