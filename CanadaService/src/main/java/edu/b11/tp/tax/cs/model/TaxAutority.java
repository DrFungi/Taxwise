package edu.b11.tp.tax.cs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class TaxAutority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private double taxFreeThreshold;

    @OneToMany(mappedBy = "taxAuthority")

    private List<TaxBracket> taxBrackets;

    public TaxAutority() {

    }

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
