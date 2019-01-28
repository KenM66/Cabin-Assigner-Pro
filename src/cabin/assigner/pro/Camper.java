/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Camper implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7005900758822683271L;
	public Camper(){
		
	}
	public Camper(String lastName, String firstName, char gender){
		this.lastName= lastName;
		this.firstName= firstName;
		this.gender= gender;
	}
	
	private String firstName;
	private String lastName;
	private String allergies;
	private String medications;
	private String specialNeeds;
	private String disorders;
	private String dietaryPreferences;
	private String specialRequest;
	private String emergencyContact1;
	private String emergencyContact2;
	private String emergencyContactRelationship1;
	private String emergencyContactRelationship2;
	private String emergencyContactPhone1;
	private String emergencyContactPhone2;
                   private int camperNumber;
                   private Cabin cabin;

    public boolean isValuesChanged() {
        return valuesChanged;
    }

    public void setValuesChanged(boolean valuesChanged) {
        this.valuesChanged = valuesChanged;
    }
                   private boolean valuesChanged= false;

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public int getCamperNumber() {
        return camperNumber;
    }

    public void setCamperNumber(int camperNumber) {
        this.camperNumber = camperNumber;
    }
	
	ArrayList<String> disordersList= new ArrayList<String>();
    //The disorders list was created to ensure the same spelling of common disorders.  Any that are not included can be manually entered on the disorders String.
	//The special request string is for the purposes of notifying the user when assigning the cabin that the parents had a special request for their cabin assignment.
	private char gender;
	protected LocalDate dateOfBirth;
	protected static final DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/dd/yyyy");
	public char getGender() {
		return gender;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	public int calculateAge (LocalDate dob, LocalDate campDate) throws ParseException{
		this.dateOfBirth= dob;
		
		
			return Period.between(dob, campDate).getYears();
		}
		
	
	
	public void setDob(String dob){
	      
		dateOfBirth= checkFormat(dob);
		
		}
	
	public String getDob(){
		return formatter.format(dateOfBirth);
	}
	
	public void setFirstName(String name){
		firstName= name;
	}
	
	public void setLastName(String name){
		lastName= name;
	}
	
	public void setGender(char g){
		gender=g;
	}
	
	public String getMedications(){
		return medications;
	}
	public void setMedications(String m){
		medications=m;
	}
	public void setAllergies(String a){
		allergies=a;
	}
	public String getAllergies(){
		return allergies;
	}
	public void setSpecialNeeds(String s){
		specialNeeds=s;
	}
	public String getSpecialNeeds(){
		return specialNeeds;
	}
	public void setDisorders(String d){
		disorders=d;
	}
	public String getDisorders(){
		return disorders;
	}
	public void setDietaryPreferences(String dp){
		dietaryPreferences= dp;
	}
	public String getDietaryPreferences(){
		return dietaryPreferences;
	}

	
   public String toString(){ 
        String display= null;
		try {
			 display= getLastName()+", "+getFirstName()+"("+calculateAge(dateOfBirth, CampInformation.dateOfCamp)+getGender()+")";
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return display;
	} 
	   
	LocalDate checkFormat(String dateEntered){
		while(true){
			
			try{
				return LocalDate.parse(dateEntered, formatter);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Please enter the correct date format: MM/DD/YYYY");
			
			}
			return null;
		}
	}

	public String getSpecialRequest() {
		return specialRequest;
	}

	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}

	public String getEmergencyContact1() {
		return emergencyContact1;
	}

	public void setEmergencyContact1(String emergencyContact1) {
		this.emergencyContact1 = emergencyContact1;
	}

	public String getEmergencyContact2() {
		return emergencyContact2;
	}

	public void setEmergencyContact2(String emergencyContact2) {
		this.emergencyContact2 = emergencyContact2;
	}

	public String getEmergencyContactRelationship1() {
		return emergencyContactRelationship1;
	}

	public void setEmergencyContactRelationship1(String emergencyContactRelationship1) {
		this.emergencyContactRelationship1 = emergencyContactRelationship1;
	}

	public String getEmergencyContactRelationship2() {
		return emergencyContactRelationship2;
	}

	public void setEmergencyContactRelationship2(String emergencyContactRelationship2) {
		this.emergencyContactRelationship2 = emergencyContactRelationship2;
	}

	public String getEmergencyContactPhone1() {
		return emergencyContactPhone1;
	}

	public void setEmergencyContactPhone1(String emergencyContactPhone1) {
		this.emergencyContactPhone1 = emergencyContactPhone1;
	}

	public String getEmergencyContactPhone2() {
		return emergencyContactPhone2;
	}

	public void setEmergencyContactPhone2(String emergencyContactPhone2) {
		this.emergencyContactPhone2 = emergencyContactPhone2;
	}
   
   }
   
   

