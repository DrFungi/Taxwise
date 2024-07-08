package edu.b11.tp.tax.cs.persistence;

import edu.b11.tp.tax.cs.model.TaxBracket;

import java.util.List;

public interface ITaxBracketDAO {
    List<TaxBracket> findAllBrackets(String authority, double amount);
}
