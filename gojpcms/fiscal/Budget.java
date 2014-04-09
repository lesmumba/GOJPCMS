package gojpcms.fiscal;

import java.util.ArrayList;
import java.util.UUID;


/**
 * Write a description of class Budget here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Budget
{
    // instance variables - replace the example below with your own
    double current_balance, estimated_cost, initial_balance;    
    String budget_id;
    ArrayList<String> expenditure_history = new ArrayList<String>();
    ArrayList<String> funding_history = new ArrayList<String>();
    

    /**
     * Constructor for objects of class Budget
     * @param budget_id - the budget object will check if the existing budget id is in the budgetting database, if so, then the budget_id will be set to the object
     * else the it will throw an error
     */
    public Budget(String budget_id)
    {
        // initialise instance variables
        //this.budget_id = budget_id;
        /*
         * Call the budget database class and search for the budget by its id
         * if the budget exist then extract the budget information, else throw a error message
         */
    }
    
    /**
     * Constructor for objects of class Budget
     * @param amount - will set the intial budget balance to the amount given as parameter. Afterwards a default budget id will be generated 
     * and attach to the budget object
     */
    public Budget(double amount){
        /*
         * Set the default budget to the amount given and generate a budget id
         */
        this.initial_balance = amount;
        this.budget_id = generateBudgetId();
        
    }
    
    /**
     * generateBudgetId - generates an unique id using java UUID
     * @return the budget_id
     */
    private String generateBudgetId(){
        return UUID.randomUUID().toString();
    }
    
    /**
     * Set the cost of the project being funded
     */    
    public void setEstimatedCost(double cost){
        this.estimated_cost = cost;
    }
    
    /**
     * budgetSummary is evalevent to the toString method, whereby the information contain within the budget object is converted as string and displayed to the user
     */
    public String budgetSummary(){
        /*
         * Format the budget variables to be printed
         */
        return null;
    }
    
    /**
     * Add expenditure to the budget
     * @param expense - adds a expenditure object to the budget that will be used to calculate th current budget balance
     */    
    public void addExpenditure(Expenditure expense){
       /* if(!this.expenditure_history.contains(expense.expenditure_id)){
            this.expenditure_history.add(expenditure_id);
            System.out.println("Expenditure has been added");
        }else
            System.out.println("Expense has already being added");      */      
    }
    
    /**
     * Add funds to the budget
     * @param the funds object contains a funding source and the amount being funded which is used to calculate the current budget
     */
    public void addFunds(FundingSource funder){
        /*
         * Extract the funding amount and calculate the current budget balance
         * Extract other funding information such as funding source and source it in the funding history variable;
         */
        
    }
    
           
    
}
