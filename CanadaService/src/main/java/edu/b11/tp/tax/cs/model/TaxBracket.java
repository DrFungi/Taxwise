package edu.b11.tp.tax.cs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaxBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double minIncome;
    private double maxIncome;
    private double taxRate;

     public TaxBracket() {

     }
    public TaxBracket(double minIncome, double maxIncome, double taxRate) {
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.taxRate = taxRate;
    }
    public Long getId() {
        return id;
    }

    public double getMinIncome() {
        return minIncome;
    }
    public double getMaxIncome() {
        return maxIncome;
    }
    public double getTaxRate() {
        return taxRate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMinIncome(double minIncome) {
        this.minIncome = minIncome;
    }

    public void setMaxIncome(double maxIncome) {
        this.maxIncome = maxIncome;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }


    @Override
    public String toString() {
        return "TaxBracket{" +
                "minIncome=" + minIncome +
                ", maxIncome=" + maxIncome +
                ", taxRate=" + taxRate +
                '}';
    }
}
