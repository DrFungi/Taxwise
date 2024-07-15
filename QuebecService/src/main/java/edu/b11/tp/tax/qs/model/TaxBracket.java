package edu.b11.tp.tax.qs.model;

public class TaxBracket {
    private double minIncome;
    private double maxIncome;
    private double taxRate;
    private int taxAuthorityId;


    public TaxBracket(double minIncome, double maxIncome, double taxRate, int taxAuthorityId) {
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.taxRate = taxRate;
        this.taxAuthorityId = taxAuthorityId;
    }

    public double getMinIncome() {
        return minIncome;
    }

    public void setMinIncome(double minIncome) {
        this.minIncome = minIncome;
    }

    public double getMaxIncome() {
        return maxIncome;
    }

    public void setMaxIncome(double maxIncome) {
        this.maxIncome = maxIncome;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public int getTaxAuthorityId() {
        return taxAuthorityId;
    }

    public void setTaxAuthorityId(int taxAuthorityId) {
        this.taxAuthorityId = taxAuthorityId;
    }

    @Override
    public String toString() {
        return "TaxBracket{" +
                "minIncome=" + minIncome +
                ", maxIncome=" + maxIncome +
                ", taxRate=" + taxRate +
                ", taxAuthorityId=" + taxAuthorityId +
                '}';
    }
}
