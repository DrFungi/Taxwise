package edu.b11.tp.tax.cs.persistence;


import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class TaxBracket_PersistenceUnitInfo implements PersistenceUnitInfo {

@Override
    public String getPersistenceUnitName() {
        return "TaxBracket_PersistenceUnitInfo";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        List<String> names = new ArrayList<>();
        names.add("edu.b11.tp.tax.cs.model.TaxBracket;");
        names.add("edu.b11.tp.tax.cs.model.TaxAuthority;");

        return names;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        Properties props = new Properties();
        // connection string config
        props.setProperty("javax.persistence.jdbc.driver","org.mariadb.jdbc.Driver");
        props.setProperty("javax.persistence.jdbc.url","jdbc:mariadb://mysql-hajar.alwaysdata.net:3306/hajar_tp");
        props.setProperty("javax.persistence.jdbc.user","hajar_tax");
        props.setProperty("javax.persistence.jdbc.password","Taxwise123");

         // Hibernate config
        props.setProperty("hibernate.format_sql","false");
        props.setProperty("hibernate.use_sql_comments","false");
        props.setProperty("hibernate.show_sql","false");
        props.setProperty("hibernate.ejb.interceptor","org.hibernate.ejb.interceptor.EmptyInterceptor");
        props.setProperty("hibernate.dialect","org.hibernate.dialect.MariaDBDialect");

        return props;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
