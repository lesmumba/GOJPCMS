package gojpcms.user;

import gojpcms.project.Project;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ProjectOfficer extends User{
	ArrayList<String> project_owned;

	public ProjectOfficer(String user_id) {
		super(user_id);
		project_owned = new ArrayList<String>();
	}
	
	public ProjectOfficer(String user_id, String first_name, String last_name){
		super(user_id, first_name, last_name);
		project_owned = new ArrayList<String>();
    }
	
	public void addProjectOwned(String project_id){
		if(!project_owned.contains(project_id))
			project_owned.add(project_id);
	}
	
	public void removeProjectOwned(String project_id){
		project_owned.remove(project_owned.indexOf(project_id));
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getProjectOwned(){
		if(project_owned != null)
			return project_owned;
		return null;
	}
	
	public void requestProjectAssignment(Project project, Consultant consultant){
		
	}
	

}
