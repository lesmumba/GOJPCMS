package gojpcms.fiscal;
import java.util.UUID;


/**
 * Write a description of class Expenditure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class Expenditure{
        String expenditure_id;
        String details;
        double amount;
        /**
         * Constructor for objects of class Budget
         * @param budget_id - the budget object will check if the existing budget id is in the budgetting database, if so, then the budget_id will be set to the object
         * else the it will throw an error
        */
        public Expenditure(double amount)
        {
            this.expenditure_id = UUID.randomUUID().toString();
            this.amount = amount;
        }
        
        public void setDetails(String details){
            this.details = details;
        }
        
        public Expenditure(String expenditure_id){
            this.expenditure_id = expenditure_id;
        }
        
        public String getDetails(){
            return this.details;
        }
        
        public void setAmount(double amount){
            this.amount = amount;
        }
        
        /**
         * Summarize the expenditure object
         * @return a formatted string describing the reason for the expense, the expensee amount and the expenditure id
         */
        public String expenditureSumary(){
            /*
             * Format expenditure summary to be printed
             */
            return null;
        }
        
    }


