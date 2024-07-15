package edu.b11.tp.tax.qs.persistence;


import edu.b11.tp.tax.qs.model.TaxAuthority;
import edu.b11.tp.tax.qs.model.TaxBracket;

import java.util.List;

public interface ITaxBracketDAO {
    TaxAuthority getTaxAuthorityByLabel(String taxAuthority);

    List<TaxBracket> getTaxBracketsByAuthorityId(int authorityId);
}
