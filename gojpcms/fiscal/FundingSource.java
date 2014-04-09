package gojpcms.fiscal;


/**
 * Write a description of class FundingSource here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FundingSource
{
    // instance variables - replace the example below with your own
    String fund_id;
    String funding_source;
    double amount;
    
    public FundingSource(String funding_source, double amount){
        this.amount = amount;
        this.funding_source = funding_source;
    }
    
    public FundingSource(String fund_id){
        this.fund_id = fund_id;
        /*
         * Get funding information based on the fund_id
         */
    }
    
    public void setFundingAmount(double amount){
        this.amount = amount;
        /*
         * 
         */
    }
    
    /**
     * Summarize the fund object
     * @return a formatted string describing the fund source and the amount funded
     */
    public String fundingSumary(){
        /*
         * format object fields to be printed or shown to the user
         */
        return null;
    }
    
}
