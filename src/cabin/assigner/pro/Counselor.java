/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;

import java.io.Serializable;

public class Counselor implements Serializable {    /**
	 * 
	 */
	private static final long serialVersionUID = -4679204982585565560L;

	
	/**
	 * 
	 */
	
	private String lastName;
	private String firstName;
	private char gender;
	private String request;
	
	//The request String if not null or blank will appear when trying to assign a counselor to a cabin to make
	//sure the user knows of that counselor's request. 
	
	
	Counselor(){
		
	}
	
	Counselor(String lastName, String firstName, char gender){
		this.lastName= lastName;
		this.firstName= firstName;
		this.gender= gender;
		
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public char getGender(){
		return gender;
	}

	public String toString(){
		String display = getLastName()+", "+ getFirstName()+ "("+ getGender()+")";
		return display;
	}

	public void setFirstName(String name) {
		firstName=name;
		
	}
	public void setLastName(String name){
		lastName=name;
	}
	public void setGender(char g){
		gender=g;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
}
