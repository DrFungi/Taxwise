package edu.b11.tp.tax.cs.model;

public class TaxAuthority {
    private int id;
    private String label;
    private double taxFreeThreshold;

    public TaxAuthority(int id, String label, double taxFreeThreshold) {
        this.id = id;
        this.label = label;
        this.taxFreeThreshold = taxFreeThreshold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getTaxFreeThreshold() {
        return taxFreeThreshold;
    }

    public void setTaxFreeThreshold(double taxFreeThreshold) {
        this.taxFreeThreshold = taxFreeThreshold;
    }

    @Override
    public String toString() {
        return "TaxAuthority{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", taxFreeThreshold=" + taxFreeThreshold +
                '}';
    }
}
