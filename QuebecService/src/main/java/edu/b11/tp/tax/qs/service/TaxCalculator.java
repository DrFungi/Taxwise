package edu.b11.tp.tax.qs.service;

import edu.b11.tp.tax.qs.persistence.ITaxBracketDAO;
import edu.b11.tp.tax.qs.model.TaxBracket;
import edu.b11.tp.tax.qs.model.TaxAuthority;

import java.util.List;

public class TaxCalculator {
    private ITaxBracketDAO taxBracketDao;

    public TaxCalculator(ITaxBracketDAO taxBracketDao) {
         this.taxBracketDao = taxBracketDao;
     }

public double calculateTax(String taxAuthority, double income) {
        TaxAuthority authority = this.taxBracketDao.getTaxAuthorityByLabel(taxAuthority);
        double taxFreeThreshold = authority.getTaxFreeThreshold();
        if (taxFreeThreshold >= income){
            return 0.0;
        }
        List<TaxBracket> taxBracketList = this.taxBracketDao.getTaxBracketsByAuthorityId(authority.getId());
        double taxOwed = 0.0;
        double maxIncomeInBracket = 0.0;
        double incomeInBracket = 0.0;
        for (TaxBracket item : taxBracketList){
            if (income > item.getMinIncome()) {
                //find maxIncomeInBracket
                if (item.getMaxIncome() != 0.0){
                    if (income < item.getMaxIncome()){
                        maxIncomeInBracket = income;
                    }else {
                        maxIncomeInBracket = item.getMaxIncome();
                    }
                }else {
                    maxIncomeInBracket = income;
                }
                incomeInBracket = maxIncomeInBracket - item.getMinIncome();
                taxOwed += incomeInBracket * (item.getTaxRate()/100);
            }// end if
        }
        return taxOwed;
    }




}
