package document;
import java.util.UUID;



/**
 * Write a description of class Contract here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contract
{
    // instance variables - replace the example below with your own
    private String contract_id, task_id[], description, descrepancies[];
    public enum PAYMENT_SCHEDULE { BIWEEKLY, MONTHLY, YEARLY }
    private PAYMENT_SCHEDULE payment_schema;

    /**
     * Constructor for objects of class Contract
     */
    public Contract()
    {
        // initialise instance variables
        this.contract_id = UUID.randomUUID().toString();
    }
}
