package edu.b11.tp.tax.cs.persistence;

public class SQL_Box {

    // Find all tax brackets for a given authority and income amount
    public static final String FindAllTaxBrackets ="SELECT * FROM tax_brackets WHERE authority = ? ";


}
