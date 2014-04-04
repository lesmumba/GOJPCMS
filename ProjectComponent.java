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
    String project_id;
    String project_name;
    String owner_id;
    String project_type;
    String description;
    String economic_sector;
    String project_location;
    Boolean id_taken;

    /**
     * Constructor for objects of class Project
     */
    public ProjectComponent(String project_name, String description, String owner_id, String project_type){
      // initialise instance variables
      this.project_name = project_name;
      this.description = description;
      this.owner_id = owner_id;
      this.project_type = project_type;
    }

    public String addProject(
      String project_name, String description, String project_type, String
      economic_sector, String project_owner)

    {
      //if (ACLComponent.hasAccess(System.CurrentUser))
      id_taken = true;
      while (id_taken)
      {
        Random generator = new Random();
        int random_int = generator.nextInt();
        /* 
         * Check if project with ID exists
        Project check_project = getProject(random_int);
        if (check_project = None) {
            id_taken = False;
        } */
      }
      Project project = new Project(project_name, description, owner_id, project_type);

      return project_id;
    }

    public Project getProject(String project_id)
    {
      /*
       * Get the project form the database. If found, return the Object.
       * Else return none... Or something.
       */
      Project project = new Project(project_name, description, owner_id, project_type);
      return project;
    }
    public String editProject(String project_id, String description,
                              String project_owner, String economic_sector)
    {
      /* if (ACLComponent.hasAccess(System.CurrentUser))
      {

      } */
      return "Success";
    }
}
