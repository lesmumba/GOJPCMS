package database;
import acl.UserPermission;


/**
 * Write a description of class UserAccess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class User{
    // instance variables - replace the example below with your own
    String user_id, first_name, last_name, user_type;
    UserPermission user_permission;

    /**
     * Constructor for objects of class UserAccess
     */
    public User(String user_id){
        // initialise instance variables
        this.user_id = user_id;
        
    }
    
    public User(String user_id, String first_name, String last_name){
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.user_id = user_id;
    }
    
    public void setUserId(String user_id){
    	this.user_id = user_id;
    }
    
    public void setFirstName(String first_name){
    	this.first_name = first_name;
    }
    
    public void setLastName(String last_name){
    	this.last_name = last_name;
    }
    

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName(){
        // put your code here
       return this.first_name+" "+this.last_name;       
    }
    
    /**
     * 
     * @return
     */
    public String getUserId(){
    	return this.user_id;
    }
    
    
}
