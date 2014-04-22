package gojpcms.user;
import java.io.Serializable;

import gojpcms.acl.ACLUser;
import gojpcms.database.ObjectDatabase;
import gojpcms.util.Encryption;
import gojpcms.util.Encryption.TYPE;


/**
 * Write a description of class UserAccess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5796086992165104986L;
	// instance variables - replace the example below with your own
    String user_id, first_name, last_name, password;
    ACLUser user_permission;
    static Object CURRENT_USER;
    Class<?> user_type;
	ObjectDatabase odb;

    /**
     * Constructor for objects of class UserAccess
     */
    public User(String user_id){
        // initialise instance variables
        this.user_id = user_id;
        user_type = this.getClass();
        odb = new ObjectDatabase(user_type);
    }
    
    public User(String user_id, String first_name, String last_name){
    	this.first_name = first_name;
    	this.last_name = last_name;
    	this.user_id = user_id;
        user_type = this.getClass();
        odb = new ObjectDatabase(user_type);
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
    
    public boolean isUser(String user_id, String password){
    	String enpass = Encryption.encrypt(TYPE.MD5, password);
    	if(this.user_id.equals(user_id) && this.password.equals(enpass)){
    		return true;
    	}
    	return false;
    }
    
    public static boolean login(String user_id, String password){
    	User user = getUser(user_id);
    	if(user.isUser(user_id, password)){
    		CURRENT_USER = user;
    		return true;
    	}
    	return false;
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
    
    public void setPassword(String password){
    	this.password = Encryption.encrypt(TYPE.MD5, password);
    }
    
    public boolean registerUser(){
    	if(this.password != null && this.user_id != null){
    		odb.add(this.user_id, this);
    		odb.saveObject();
    		return true;
    	}else{
    		throw new NullPointerException("Basic user requirements has not met, (user_id, password)");
    	}
    }
    
    public static User getUser(String user_id){
    	System.out.println("Attempting user extraction "+user_id);
    	ObjectDatabase odb = new ObjectDatabase(ProjectOfficer.class);
    	odb.readDatabase();
    	return (User) odb.getObject(user_id);
    }

	public static User getCurrentUser() {
		// TODO Auto-generated method stub
		if(CURRENT_USER != null)
			return (User) CURRENT_USER;
		return null;
	}    
	
	public String toString(){
		return first_name+" "+last_name;
	}
    
}
