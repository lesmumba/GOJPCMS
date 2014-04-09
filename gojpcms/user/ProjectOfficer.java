package gojpcms.user;

import gojpcms.project.Project;

public class ProjectOfficer extends User{
	Project project_owned[];

	public ProjectOfficer(String user_id) {
		super(user_id);
		// TODO Auto-generated constructor stub
	}
	
	public ProjectOfficer(String user_id, String first_name, String last_name){
		super(user_id, first_name, last_name);
    }
	
	public void requestProjectAssignment(Consultant consultant){
		
	}
	

}
