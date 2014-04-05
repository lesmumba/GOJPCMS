package project;
import java.util.*;

/**
 * Write a description of class Project Component here.
 *
 * @author Mumba Sambo
 * @version Mar 31, 2014
 */
public class Project
{
    // instance variables - replace the example below with your own
    String projectId, projectName, parentProjectId = null;
    String ownerId;
    String description;
    String economicSector;
    String location;
    Boolean idTaken;
    static enum TYPE {CAPITAL("capital"), TECHNICAL_ASSISTANCE("technical assistance");    
        private String value;
		private TYPE(String value) {
			this.value = value;
		}
    
    };
    static enum LIFECYCLE {PREPARATION("preparation"), IMPLEMENTATION("implementation"), TERMINATION("termination");    
        private String value;
		private LIFECYCLE(String value) {
			this.value = value;
		}    
    };
    static enum ECONOMIC_SECTOR {AGRICULTURE("agriculture"), MINING("mining"), SERVICE("service"), OTHER("other");    
        private String value;
		private ECONOMIC_SECTOR(String value) {
			this.value = value;
		}    
    };
    
    
    TYPE type;
    LIFECYCLE stage;
    ECONOMIC_SECTOR economci_sector;
    
    

    /**
     * Constructor for objects of class Project
     * This constructor is used to create the blueprint or basic project registration field before adding the project
     * @param projectName - defines the name of the project
     * @param description - defines the information about the project
     * @paran ownerId - defines the onwer id of the project
     * @param projectType - defines what type of a project it is, whether it is a Capital Project [which involve contracts that detail the work to be done and cost.]
     * or a Technical Assistance project [which involve hiring consultants who provide services to the project beneficiaries.]
     */
    public Project(String projectName, String description, String ownerId, TYPE projectType){
        // initialise instance variables
        this.projectName = projectName;
        this.description = description;
        this.ownerId = ownerId;
        this.type = projectType;
        this.projectId = generateProjectId();
    }
    
     /**
     * Constructor for objects of class Project
     * This constructor is used to create the blueprint or basic project registration field of a subproject before adding the project
     * @param projectName - defines the name of the project
     * @param description - defines the information about the project
     * @paran ownerId - defines the onwer id of the project
     * @param projectType - defines what type of a project it is, whether it is a Capital Project [which involve contracts that detail the work to be done and cost.]
     * or a Technical Assistance project [which involve hiring consultants who provide services to the project beneficiaries.]
     * @parentProjectId - defines the parent project id that new Project object directly stem from.
     */
    public Project(String projectName, String description, String ownerId, String parentProjectId, TYPE projectType){
        // initialise instance variables
        this.projectName = projectName;
        this.description = description;
        this.ownerId = ownerId;
        this.type = projectType;
        this.projectId = generateProjectId();
        this.parentProjectId = parentProjectId;
    }
    
    /**
     * Constructor for objects class Project
     * This constructor is used to call already existing projects that are within the database
     */
    public Project(String project_id){
        /*
         * check if the current logged in user has the permission to view a project
         * if so, then get the project from the database
         */        
    }
    
    /**
     * addProject method is used to register a project within the system database
     * @param economicSector - defines the economic sector which the project belongs, such as agriculture, mining, service or other. this is done by calling the 
     * static enum variable Project.ECONOMIC_SECTOR
     * @param project_location - is a location object that defines the address and cordinates of the project on the google map
     */
    public void addProject(ECONOMIC_SECTOR economicSector, String project_location)
    {
        /*
         * Check if user has permission
         * if user has permission then call the project database manager object and register the project in the database
         */
        
        
    }

    public Project getProject(String project_id)
    {
        /*
         * Get the project form the database. If found, return the Object.
         * Else return none... Or something.
         */
        return null;
    }

    public Project addSubProject(String subprojectName, String subprojectDescription, TYPE subprojectType)
    {
       /*
        * check if user has permission to do this action
        */
       return new Project(subprojectName, subprojectDescription, this.ownerId, this.projectId, subprojectType);
        
    }

    public Project getSubProjects(int project_id)
    {
        /* if (ACLComponent.hasAccess(System.CurrentUser))
         * {
    
         *  } */
         return null;
    }
    
    /**
     * generateProjectId - generates an unique id using java UUID
     * @return the budget_id
     */
    private String generateProjectId(){
        idTaken = true;
        String projectId;
        do{
            projectId = UUID.randomUUID().toString();
            /* 
             * Check if project with ID exists
             * Project check_project = getProject(random_int);
             * if (check_project = None) {
             *     id_taken = False;
             *  } */
            return projectId;
        }
        while (idTaken);
    }
}
