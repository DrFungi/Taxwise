package edu.b11.tp.tax.qs.persistence;


import edu.b11.tp.tax.qs.model.TaxAuthority;
import edu.b11.tp.tax.qs.model.TaxBracket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaxBracketDAO_JDBC implements ITaxBracketDAO {
    Connection connection;

    public TaxBracketDAO_JDBC(){
        // call the singleton
        this.connection = SQL_Connector.getInstance().getConnection();
    }

    @Override
    public TaxAuthority getTaxAuthorityByLabel(String taxAuthority) {
        //TaxAuthority authority = null;

        try {
            PreparedStatement pstm = connection.prepareStatement(SQLBox.FIND_ALL_AUTHORITIES);
            pstm.setString(1,taxAuthority);
            ResultSet reader = pstm.executeQuery();
            if (reader.next()){
                int Id = reader.getInt("id");
                String label = reader.getString("label");
                double threshold = reader.getDouble("taxFreeThreshold");
                return new TaxAuthority(Id, label, threshold);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }// end of getTaxAuthorityByLabel

    @Override
    public List<TaxBracket> getTaxBracketsByAuthorityId(int authorityId){
        List<TaxBracket> taxBracketList = new ArrayList<>();
        try {
            PreparedStatement pstm = connection.prepareStatement(SQLBox.FIND_TAX_BRACKETS_BY_AUTHORITY_ID);
            pstm.setInt(1, authorityId);
            ResultSet reader = pstm.executeQuery();
            while (reader.next()){
                double minIncome = reader.getDouble("minIncome");
                double maxIncome = reader.getDouble("maxIncome");
                double taxRate = reader.getDouble("taxRate");
                int id = reader.getInt("taxAuthorityId");
                taxBracketList.add(new TaxBracket(minIncome, maxIncome, taxRate, id));
            }
            return taxBracketList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }// end of getTaxBracketsByAuthorityId
}
