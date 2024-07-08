package edu.b11.tp.tax.cs.persistence;

import edu.b11.tp.tax.cs.model.TaxBracket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;

public class TaxBracketDAO implements ITaxBracketDAO {

    private EntityManagerFactory emf;
    EntityManager em;

     public TaxBracketDAO() {
        PersistenceUnitInfo tax_pu = (PersistenceUnitInfo) new TaxBracket_PersistenceUnitInfo();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(tax_pu, new HashMap());
            this.em = emf.createEntityManager();
        }


    @Override
    public List<TaxBracket> findAllBrackets(String authority, double amount) {
         List<TaxBracket> taxBrackets = em.createQuery(SQL_Box.FindAllTaxBrackets, TaxBracket.class)
               .setParameter("amount", amount)
               .setParameter("authority", authority)
               .getResultList();

        return taxBrackets;
    }


}
