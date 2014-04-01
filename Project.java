import java.util.*;

/**
 * Write a description of class Project here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Project
{
    // instance variables - replace the example below with your own
    int project_id;
    String project_name;
    String owner_id;
    String project_type;
    String description;
    String economic_sector;
    String project_location;
    //Contract contract;

    /**
     * Constructor for objects of class Project
     */
    public Project(String name, String description)
    {
        // initialise instance variables
    this.project_name=name;
    this.description=description;
    }

    
}
