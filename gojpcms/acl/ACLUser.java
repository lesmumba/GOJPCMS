package gojpcms.acl;

import gojpcms.acl.ACLProject.PERMISSION;
import gojpcms.user.User;

public class ACLUser {
	User user;
	PERMISSION permission;
	public ACLUser(User user){
		this.user = user;
	}
	
	public void setPermission(PERMISSION permission){
		this.permission = permission;
	}
	
	
	public void setUserRole(){
		/*
		 * set the user role of task to be performed
		 */
	}
	
	private void checkUserType(){
		/*
		 * check user type to see if the user ass the correct role to perform such action
		 */
		
	}

	public PERMISSION getPermission() {
		// TODO Auto-generated method stub
		return this.permission;
	}
	
	public static class UserPermissionException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public UserPermissionException(String message){
			super(message);			
		}		
	}

}
