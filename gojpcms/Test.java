package gojpcms;

import java.util.ArrayList;
import java.util.HashMap;

import gojpcms.project.Project;
import gojpcms.user.ProjectOfficer;
import gojpcms.user.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*ProjectOfficer oshane = new ProjectOfficer("b4oshany", "Oshane", "Bailey");
		oshane.setPassword("oshany1991");
		oshane.registerUser();*/
		User.login("b4oshany", "oshany1991");
		User osh = User.getCurrentUser();
		
		
		//registerProject();
		listProjects();
		
		
	}
	
	public static void listProjects(){
		ProjectOfficer owner = (ProjectOfficer) User.getCurrentUser();
		@SuppressWarnings("unchecked")
		ArrayList<String> project_ids = owner.getProjectOwned();
		if(project_ids != null){
			HashMap<String, Object> projects = Project.getProjects();
			for(String project_id : project_ids){
				System.out.println("Project owner id, "+project_id);
				Project project = (Project) projects.get(project_id);
				System.out.println("Project project name, "+project.get(Project.INFO.PROJECT_NAME));				
			}
		}
	}
	
	public static void registerProject(){
		Project ohomes = new Project("Ohomesa", "Real Estate Website", Project.TYPE.CAPITAL);
		ohomes.setEconomicSector(Project.ECONOMIC_SECTOR.SERVICE);
		ohomes.set(Project.INFO.PROJECT_LOCATION, "Spanish Town");
		String id = ohomes.get(Project.INFO.PROJECT_ID);
		System.out.println("Project id, "+id);
		ohomes.registerProject();
		Project oh = Project.getProject(id);
		System.out.println("Project owner id, "+oh.get(Project.INFO.PROJECT_OWNER));
	}

}
