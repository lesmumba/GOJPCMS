package gojpcms.document;
import java.util.Calendar;
import java.util.UUID;

import gojpcms.util.Date;



/**
 * Write a description of class Contract here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Contract
{
    // instance variables - replace the example below with your own
    String contract_id, description, descrepancies[];
    public static enum PAYMENT_SCHEDULE { BIWEEKLY, MONTHLY, YEARLY };
    public static enum TYPE{USER_CONTRACT, PROJECT_CONTRACT};
    TYPE type;
    PAYMENT_SCHEDULE payment_schema;
    long start_date, end_date;

    /**
     * Constructor for objects of class Contract
     */
    public Contract() {
        // initialise instance variables
        generateContractId();
    }
    
    public void setContractType(TYPE type){
    	this.type = type;
    }
        
    public Contract(String contractId){
    	this.contract_id = contractId;    	
    }
    
    private void generateContractId(){
    	this.contract_id = UUID.randomUUID().toString();
    }
    
    public void terminateContract(){
    	this.end_date = Calendar.getInstance().getTimeInMillis();
    }
    
    public void initiateContract(){
    	
    }
    
    public String summaryDescrepancy(){
    	return null;
    }    
    
}
