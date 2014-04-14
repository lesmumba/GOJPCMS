package gojpcms.project;

import gojpcms.database.ObjectDatabase;
import gojpcms.user.ProjectOfficer;
import gojpcms.user.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Write a description of class Project Component here.
 * 
 * @author Mumba Sambo
 * @version Mar 31, 2014
 */
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1418592198185344672L;
	// instance variables - replace the example below with your own
	String projectId, projectName, parentProjectId = null, ownerId,
			description, economicSector, location;
	Boolean idTaken;
	ArrayList<String> subproject_id = new ArrayList<String>();

	public static enum TYPE {
		CAPITAL("capital"), TECHNICAL_ASSISTANCE("technical assistance");
		private String value;

		private TYPE(String value) {
			this.value = value;
		}

	};

	public static enum LIFECYCLE {
		PREPARATION("preparation"), IMPLEMENTATION("implementation"), TERMINATION(
				"termination");
		private String value;

		private LIFECYCLE(String value) {
			this.value = value;
		}
	};

	public static enum ECONOMIC_SECTOR {
		AGRICULTURE("agriculture"), MINING("mining"), SERVICE("service"), OTHER(
				"other");
		private String value;

		private ECONOMIC_SECTOR(String value) {
			this.value = value;
		}
	};

	public static enum INFO {
		PROJECT_LOCATION, PROJECT_NAME, PROJECT_OWNER, PROJECT_ID, PROJECT_DESCRIPTION, PARENT_PROJECT
	};

	TYPE type;
	LIFECYCLE stage;
	ECONOMIC_SECTOR economic_sector;

	/**
	 * Constructor for objects of class Project This constructor is used to
	 * create the blueprint or basic project registration field before adding
	 * the project
	 * 
	 * @param projectName
	 *            - defines the name of the project
	 * @param description
	 *            - defines the information about the project
	 * @paran ownerId - defines the onwer id of the project
	 * @param projectType
	 *            - defines what type of a project it is, whether it is a
	 *            Capital Project [which involve contracts that detail the work
	 *            to be done and cost.] or a Technical Assistance project [which
	 *            involve hiring consultants who provide services to the project
	 *            beneficiaries.]
	 */
	public Project(String projectName, String description, TYPE projectType) {
		// initialise instance variables
		if (User.getCurrentUser() != null) {
			this.projectName = projectName;
			this.description = description;
			ProjectOfficer officer = (ProjectOfficer) User.getCurrentUser();
			this.ownerId = officer.getUserId();
			this.type = projectType;
			this.projectId = generateProjectId();
		} else {
			throw new NullPointerException(
					"No User was initiated as current user");
		}
	}

	/**
	 * Constructor for objects of class Project This constructor is used to
	 * create the blueprint or basic project registration field of a subproject
	 * before adding the project
	 * 
	 * @param projectName
	 *            - defines the name of the project
	 * @param description
	 *            - defines the information about the project
	 * @paran ownerId - defines the onwer id of the project
	 * @param projectType
	 *            - defines what type of a project it is, whether it is a
	 *            Capital Project [which involve contracts that detail the work
	 *            to be done and cost.] or a Technical Assistance project [which
	 *            involve hiring consultants who provide services to the project
	 *            beneficiaries.]
	 * @parentProjectId - defines the parent project id that new Project object
	 *                  directly stem from.
	 */
	public Project(String projectName, String description,
			String parentProjectId, TYPE projectType) {
		// initialise instance variables
		this.projectName = projectName;
		this.description = description;
		ProjectOfficer officer = (ProjectOfficer) User.getCurrentUser();
		this.ownerId = officer.getUserId();
		this.type = projectType;
		this.projectId = generateProjectId();
		this.parentProjectId = parentProjectId;
	}

	/**
	 * addProject method is used to register a project within the system
	 * database
	 * 
	 * @param economicSector
	 *            - defines the economic sector which the project belongs, such
	 *            as agriculture, mining, service or other. this is done by
	 *            calling the static enum variable Project.ECONOMIC_SECTOR
	 * @param project_location
	 *            - is a location object that defines the address and cordinates
	 *            of the project on the google map
	 */
	public void setEconomicSector(ECONOMIC_SECTOR economicSector) {
		/*
		 * Check if user has permission if user has permission then call the
		 * project database manager object and register the project in the
		 * database
		 */
		this.economic_sector = economicSector;
	}

	public String getEconomicSection() {
		return this.economic_sector.value;
	}

	public void registerProject() {
		ObjectDatabase odb = new ObjectDatabase(Project.class);
		if (projectId != null && projectName != null && ownerId != null) {
			odb.add(projectId, this);
			odb.saveObject();
		} else {
			throw new NullPointerException(
					"Basic user requirements has not met, (user_id, password)");
		}
	}

	public static Project getProject(String project_id) {
		/*
		 * Get the project form the database. If found, return the Object. Else
		 * return none... Or something.
		 */
		ObjectDatabase odb = new ObjectDatabase(Project.class);
		odb.readDatabase();
		return (Project) odb.getObject(project_id);
	}

	public Project addSubProject(String subprojectName,
			String subprojectDescription, TYPE subprojectType) {
		/*
		 * check if user has permission to do this action
		 */
		Project subproject = new Project(subprojectName, subprojectDescription,
				this.projectId, subprojectType);
		this.subproject_id.add(subproject.get(INFO.PROJECT_ID));
		return subproject;

	}

	public Project getSubProject(String project_id) {
		/*
		 * if (ACLComponent.hasAccess(System.CurrentUser)) {
		 * 
		 * }
		 */
		if(subproject_id.contains(project_id)){
			return getProject(project_id);
		}
		return null;
	}
	


	public Project[] getSubProjects() {
		/*
		 * if (ACLComponent.hasAccess(System.CurrentUser)) {
		 * 
		 * }
		 */
		if(subproject_id != null){
			Project[] projects = new Project[subproject_id.size()];
			int counter = 0;
			for (String project_id : subproject_id) {
				projects[counter++] = getProject(project_id);
			}
			return projects;
		}
		return null;
	}
	
	
	

	/**
	 * generateProjectId - generates an unique id using java UUID
	 * 
	 * @return the budget_id
	 */
	private String generateProjectId() {
		idTaken = true;
		String projectId;
		do {
			projectId = UUID.randomUUID().toString();
			/*
			 * Check if project with ID exists Project check_project =
			 * getProject(random_int); if (check_project = None) { id_taken =
			 * False; }
			 */
			return projectId;
		} while (idTaken);
	}

	/**
	 * changeProjectLifeCycle changes the stage or the life cycle of the project
	 * form the current life cycle to another
	 * 
	 * @param stage
	 *            is defined as a LIFECYCLE enumerated type that is defined by
	 *            the different stages in the life cycle of the project stage
	 *            value can be set using LIFECYCLE.IMPLEMENTATION,
	 *            LIFECYCLE.PREPARATION and LIFECYCLE.TERMINATION
	 */
	public void changeProjectLifeCycle(LIFECYCLE stage) {
		this.stage = stage;
	}

	/**
	 * get method gets the project information based on the given input
	 * 
	 * @param attributes
	 *            is a ATTRIBUTE enumeration type that defines the data which
	 *            the user allow to view
	 */
	public String get(INFO attributes) {
		/*
		 * check for acl user permission
		 */
		switch (attributes) {
		case PROJECT_LOCATION:
			return this.location;
		case PROJECT_NAME:
			return this.projectName;
		case PROJECT_OWNER:
			/*
			 * Perform a check for the user
			 */
			return this.ownerId;
		case PROJECT_DESCRIPTION:
			return this.description;
		case PARENT_PROJECT:
			/*
			 * Perform a check for the project id
			 */
			return this.parentProjectId;
		case PROJECT_ID:
			return this.projectId;
		default:
			return null;
		}
	}

	/**
	 * set method is used to set the project information based on the given
	 * attribute type to the given value INFO{PROJECT_LOCATION, PROJECT_NAME,
	 * PROJECT_OWNER, PROJECT_ID, PROJECT_DESCRIPTION, PARENT_PROJECT};
	 * 
	 * @param attributes
	 * @param value
	 */
	public void set(INFO attributes, String value) {
		/*
		 * check for acl user permission set the information to the project
		 * object
		 */
		switch (attributes) {
		case PROJECT_LOCATION:
			this.location = value;
			break;
		case PROJECT_NAME:
			this.projectName = value;
			break;
		case PROJECT_OWNER:
			/*
			 * Perform a check for the user
			 */
			this.ownerId = value;
			break;
		case PROJECT_DESCRIPTION:
			this.description = value;
			break;
		case PARENT_PROJECT:
			/*
			 * Perform a check for the project id
			 */
			this.parentProjectId = value;
			break;
		default:
			break;
		}
	}
}
