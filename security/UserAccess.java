package gojpcms.security;
import gojpcms.project.Project;


/**
 * Write a description of class UserAccess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserAccess
{
    // instance variables - replace the example below with your own
    private String user_id;
    private Project project;
    

    /**
     * Constructor for objects of class UserAccess
     */
    public UserAccess(String user_id)
    {
        // initialise instance variables
        this.user_id = user_id;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void checkProjectPermission(int project_id)
    {
        // put your code here
        this.project = new Project(project_id);
        String owner_id = this.project.getOwner();
        if( owner_id == this.user_id){
            /*
             * Perform user action
             */
        }else{
            
        }        
    }
}
