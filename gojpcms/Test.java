package gojpcms;

import gojpcms.project.Project;
import gojpcms.user.ProjectOfficer;
import gojpcms.user.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ProjectOfficer oshane = new ProjectOfficer("b4oshany", "Oshane", "Bailey");
		oshane.setPassword("oshany1991");
		oshane.registerUser();
		User.login("b4oshany", "oshany1991");
		User osh = User.getCurrentUser();
		System.out.println(oshane.getName());
		
		
		Project ohomes = new Project("Ohomes", "Real Estate Website", Project.TYPE.CAPITAL);
		ohomes.setEconomicSector(Project.ECONOMIC_SECTOR.SERVICE);
		ohomes.set(Project.INFO.PROJECT_LOCATION, "Spanish Town");
		String id = ohomes.get(Project.INFO.PROJECT_ID);
		System.out.println("Project id, "+id);
		ohomes.registerProject();
		Project oh = Project.getProject(id);
		System.out.println("Project owner id, "+oh.get(Project.INFO.PROJECT_OWNER));
		
	}

}
