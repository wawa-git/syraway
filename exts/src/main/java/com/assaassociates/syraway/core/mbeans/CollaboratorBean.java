package com.assaassociates.syraway.core.mbeans;


public class CollaboratorBean{
	
	private String strFirstName;
	private String strLastName;
	
	public String getFirstName(){
		return this.strFirstName;
	}
	
	public void setFirstName(String pFirstName){
		this.strFirstName = pFirstName;
	}
	
	public String getLastName(){
		return this.strLastName;
	}
	
	public void setLastName(String pLastName){
		this.strLastName = pLastName;
	}
	
}