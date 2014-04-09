package gojpcms.acl;

import gojpcms.project.Project;
import gojpcms.project.Project.ATTRIBUTES;
import gojpcms.user.User;

public class ACLProject {
	Project project;
	User user;
	ACLUser uperm;
	public static enum PERMISSION{
		UPDATE("update"), VIEW_ONLY("view only"), NO_ACCESS("no access");
		private String value;
		private PERMISSION(String value) {
			this.value = value;
		}   	
	};
	
	public ACLProject(Project project, User user){
		this.project = project;
		this.uperm = new ACLUser(user);
	}
	
	public boolean hasPermission(PERMISSION permission){
		return uperm.getPermission() == permission;
	}
	
	public boolean hasFullPermission(){
		if(project.get(ATTRIBUTES.PROJECT_OWNER).equals(user.getUserId())){
			return true;
		}
		return false;		
	}
	
	public boolean hasFullPermission(User user){
		if(project.get(ATTRIBUTES.PROJECT_OWNER).equals(user.getUserId())){
			return true;
		}
		return false;
	}
	
}
