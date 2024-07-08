package edu.b11.tp.tax.qs.model;

public class TaxAutority {
    private String label;
    private double taxFreeThreshold;
    public TaxAutority(String label, double taxFreeThreshold) {
        this.label = label;
        this.taxFreeThreshold = taxFreeThreshold;
    }
    public String getLabel() {
        return label;
    }
    public double getTaxFreeThreshold() {
        return taxFreeThreshold;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setTaxFreeThreshold(double taxFreeThreshold) {
        this.taxFreeThreshold = taxFreeThreshold;
    }
    @Override
    public String toString() {
        return "TaxAuthority{" +
                "label='" + label + '\'' +
                ", taxFreeThreshold=" + taxFreeThreshold +
                '}';
    }
}
