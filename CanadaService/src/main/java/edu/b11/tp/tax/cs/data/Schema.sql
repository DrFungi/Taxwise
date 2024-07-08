

-- Créer les tables
CREATE TABLE TaxAuthority (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    label VARCHAR(255) NOT NULL,
    taxFreeThreshold DOUBLE NOT NULL
);

CREATE TABLE TaxBracket (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    minIncome DOUBLE NOT NULL,
    maxIncome DOUBLE NOT NULL,
    taxRate DOUBLE NOT NULL,
    tax_authority_id BIGINT,
    CONSTRAINT fk_tax_authority
        FOREIGN KEY (tax_authority_id)
        REFERENCES TaxAuthority(id)
);