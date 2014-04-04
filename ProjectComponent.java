import java.util.*;

/**
 * Write a description of class Project Component here.
 *
 * @author Mumba Sambo
 * @version Mar 31, 2014
 */
public class ProjectComponent
{
    // instance variables - replace the example below with your own
    int projectId;
    String projectName;
    String ownerId;
    String projectType;
    String description;
    String economicSector;
    String projectLocation;
    Boolean idTaken;

    /**
     * Constructor for objects of class Project
     */
    public ProjectComponent(String projectName, String description, String ownerId, String projectType){
        // initialise instance variables
        this.projectName = projectName;
        this.description = description;
        this.ownerId = ownerId;
        this.projectType = projectType;
    }

    public int register_project(String projectName, String description, String projectType, String economicSector, String projectOwner)
    {
        //if (ACLComponent.hasAccess(System.CurrentUser))
        idTaken = true;
        while (idTaken)
        {
            projectId = generateProjectId();
            /* 
             * Check if project with ID exists
             * Project check_project = getProject(random_int);
             * if (check_project = None) {
             *     id_taken = False;
             *  } */
        }
        Project project = new Project(projectName, description, ownerId, projectType, projectId);

        return projectId;
    }

    public Project getProject(int project_id)
    {
        /*
         * Get the project form the database. If found, return the Object.
         * Else return none... Or something.
         */
        Project project = new Project(projectName, description, ownerId, projectType, projectId);
        if (project == null) {
            return null;
        }
        else {
            return project;
        }
    }

    public int addSubProject(int parentId, String subprojectName, String subprojectDescription, String subprojectType, String
      economicSector, String subProjectOwner)
    {
        Project parentProject = getProject(parentId);
        if (parentProject == null) {
            return 0;
        }
        else {
            int subprojectId = register_project(subprojectName, subprojectDescription, subprojectType, economicSector, subProjectOwner);
            return subprojectId;
        }
        
    }

    public Project getSubProjects(int project_id)
    {
        /* if (ACLComponent.hasAccess(System.CurrentUser))
         * {
    
         *  } */
         return null;
    }
    
    public int generateProjectId()
    {
        Random generator = new Random();
        int generated_id = generator.nextInt();
        return generated_id;
    }
}
