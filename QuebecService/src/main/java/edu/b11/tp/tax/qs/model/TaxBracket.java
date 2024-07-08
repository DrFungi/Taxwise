package edu.b11.tp.tax.qs.model;

public class TaxBracket {
    private double minIncome;
    private double maxIncome;
    private double taxRate;
    public TaxBracket(double minIncome, double maxIncome, double taxRate) {
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.taxRate = taxRate;
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
