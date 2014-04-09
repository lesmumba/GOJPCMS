package gojpcms.user;

import gojpcms.document.Contract;

public class Consultant extends User {
	Contract contract;
	
	public Consultant(String user_id) {
		super(user_id);
		// TODO Auto-generated constructor stub
	}
	
	public Consultant(String user_id, String first_name, String last_name){
    	super(first_name, last_name,user_id);
    }
	
	public String displayContract(){
		return this.contract.toString();
	}
	
	public void signContract(){
		//contract = new Contract(this);
	}

}
