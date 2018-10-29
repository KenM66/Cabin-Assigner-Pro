/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Cabin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5208161686864457853L;
	private String cabinName;
	private Integer ageMin;
	private Integer ageMax;
	private char cabinGender;

	private Integer capacity;
	
	
	
	private Integer numberOfCounselors;
	
	Cabin(){
		
	}
	
	Cabin(String cabinName, char cabinGender, Integer ageMin, Integer ageMax){
		this.cabinName= cabinName;
		this.cabinGender= cabinGender;
		this.ageMin= ageMin;
		this.ageMax= ageMax; 
/*
 * Minimum and Maximum age are not hard limits, but for the purposes of flagging potential errors by the user. 
 * The camper capacity is a hard limit as assigning more campers than bunks can be a serious error.  
 * The number of counselors can be assigned over with confirmation by the user.  If not enough
 * counselors are a assigned to a cabin, the user will get notified each time they switch to another cabin or click
 * the close button on the buttom of the assignment screen. 
 * 
 */
		
		
	}
	
	Cabin(String cabinName){
		this.cabinName= cabinName;
		
	}
	public String getCabinName(){
		return cabinName;
	}
	
	public char getCabinGender(){
		return cabinGender;
	}
	
	public Integer getAgeMin(){
		return ageMin;
	}
	
	public Integer getAgeMax(){
		return ageMax;
	}
	
	public void setAgeMin(Integer min){
		ageMin= min;
	}
	public void setAgeMax(Integer max){
		ageMax= max;
	}
	public void setGender(char g){
		cabinGender=g;
	}
	public void setCabinName(String name){
		cabinName=name;
	}
	

	
	
	
	
	public void setCapacity(Integer cap){
		capacity= cap;
		
	}
	public Integer getCapacity(){
		return capacity;
	}
	
	
	public Integer getNumberOfCounselors(){
		return numberOfCounselors;
	}

	public String toString(){
		String cabin= getCabinName()+"("+getCabinGender()+")"+"("+getAgeMin()+"-"+getAgeMax()+")";
		return cabin;
	}
	
	Integer checkNumber(String number, Cabin cabin, Integer currentNumber){
		//This method will only be used when editing the capacity or age ranges.  
		//This was created to avoid having to re-use a JFrame when not necessary. 
		while(true){
			try{
				return Integer.valueOf(number);
			}
			catch(Exception e){
				if(number==null){
					return currentNumber;
				}
				JOptionPane.showMessageDialog(null, number+" is not a number.  Please enter an integer.");
				return null;
			}
		
		}
	}

	public void setNumCounselors(Integer counselors) {
		
		numberOfCounselors= counselors;
	}
}
