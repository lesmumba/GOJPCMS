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
    int projectId;
    String projectName;
    String ownerId;
    String projectType;
    String description;
    String economicSector;
    String projectLocation;
    //Contract contract;

    /**
     * Constructor for objects of class Project
     */
    public Project(String projectName, String description, String owner_id, String project_type, int projectId)
    {
        // initialise instance variables
    this.projectName = projectName;
    this.description=description;
    }

    
}
