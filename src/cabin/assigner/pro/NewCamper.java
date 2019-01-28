/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.Serializable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class NewCamper extends JPanel implements Serializable{

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField dobField;
	private JTextField medicationsField;
	

	
	JRadioButton rdbtnMale;
	JRadioButton rdbtnFemale;
	JRadioButton rdbtnOther;
	JButton btnSaveCamperComplete;
	JButton btnCancelReturn;
	 
	 
	public static List<Camper> camperList= new ArrayList<Camper>();
	public static List<Camper> camperList2= new ArrayList<Camper>();
	private JTextField textFieldAllergies;
	private JLabel lblDietaryPreferences;
	private JTextField textFieldDietaryPreferences;
	private JLabel lblSpecialNeeds;
	private JTextField textFieldSpecialNeeds;
	private JCheckBox chckbxSpecialRequest;
	private JTextField textFieldSpecialRequest;
	private JLabel emptyLabel1;
	private JLabel lblEmergecyContacts;
	private JLabel lblName;
	private JLabel lblRelationship;
	private JLabel lblPhoneNumber;
	private JTextField textFieldContactName1;
	private JTextField textFieldContactName2;
	private JTextField textFieldContactRelationship1;
	private JTextField textFieldContactRelationship2;
	private JTextField textFieldPhone1;
	private JTextField textFieldPhone2;
	private JCheckBox chckbxAddnd;
	private JPanel mainPanel;
	private JFrame frame;
	private JButton btnAddEdit;
	
	private ArrayList<String> temporaryDisorderList;
	private String temporaryOtherDisorder;
	
	//Both lists are the same at the start.  camperList1 is for viewing all campers registered. 
	//camperList2 is for assigning cabins.  If a child is assigned to cabin, they will be deleted from camperList2. 

	/**
	 * Launch the application.
	 */

	public NewCamper() {
		ArrayList<JTextField> txList= new ArrayList<JTextField>();
		
		temporaryDisorderList= new ArrayList<String>();
	    temporaryOtherDisorder= null;
		
		frame= new JFrame("NEW CAMPER");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	    mainPanel= new JPanel(new BorderLayout());
	    frame.getContentPane().add(mainPanel);
		
		
		
		
		
		
		
		
		ButtonGroup group= new ButtonGroup();
		GridBagLayout gbl_contentPane = new GridBagLayout();
	
		
		contentPane = new JPanel(gbl_contentPane);
		
		

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		mainPanel.add(contentPane);
		
		
		JLabel lblCamperInformation = new JLabel("New Camper Information");
		lblCamperInformation.setForeground(Color.BLUE);
		lblCamperInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblCamperInformation = new GridBagConstraints();
		gbc_lblCamperInformation.anchor = GridBagConstraints.WEST;
		
		gbc_lblCamperInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblCamperInformation.gridwidth = 4;
		gbc_lblCamperInformation.gridx = 1;
		gbc_lblCamperInformation.gridy = 0;
		contentPane.add(lblCamperInformation, gbc_lblCamperInformation);
		
		
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.fill = GridBagConstraints.BOTH;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridwidth = 3;
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 1;
		contentPane.add(lblFirstName, gbc_lblFirstName);
		
		firstNameField = new JTextField();
		
			
		
		
		firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstNameField.setColumns(10);
		GridBagConstraints gbc_firstNameField = new GridBagConstraints();
		gbc_firstNameField.fill = GridBagConstraints.BOTH;
		gbc_firstNameField.insets = new Insets(0, 0, 5, 5);
		
		gbc_firstNameField.gridx = 1;
		gbc_firstNameField.gridy = 2;
		contentPane.add(firstNameField, gbc_firstNameField);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.BOTH;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridwidth = 3;
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 3;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		lastNameField = new JTextField();
		
		
		lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastNameField.setColumns(10);
		GridBagConstraints gbc_lastNameField = new GridBagConstraints();
		gbc_lastNameField.fill = GridBagConstraints.BOTH;
		gbc_lastNameField.insets = new Insets(0, 0, 5, 5);
		
		gbc_lastNameField.gridx = 1;
		gbc_lastNameField.gridy = 4;
		contentPane.add(lastNameField, gbc_lastNameField);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth (MM/DD/YYYY)");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
		gbc_lblDateOfBirth.fill = GridBagConstraints.BOTH;
		gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth.gridwidth = 3;
		gbc_lblDateOfBirth.gridx = 1;
		gbc_lblDateOfBirth.gridy = 5;
		contentPane.add(lblDateOfBirth, gbc_lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
	
		gbc_lblGender.gridx = 1;
		gbc_lblGender.gridy = 7;
		contentPane.add(lblGender, gbc_lblGender);
		
		dobField = new JTextField();
		
		
		dobField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dobField.setColumns(10);
		GridBagConstraints gbc_dobField = new GridBagConstraints();
		gbc_dobField.fill = GridBagConstraints.BOTH;
		gbc_dobField.insets = new Insets(0, 0, 5, 5);
		
		gbc_dobField.gridx = 1;
		gbc_dobField.gridy = 6;
		contentPane.add(dobField, gbc_dobField);
		
		rdbtnMale = new JRadioButton("Male", true);
		
		
		
		group.add(rdbtnMale);
		GridBagConstraints gbc_rdbtnMale = new GridBagConstraints();
		gbc_rdbtnMale.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnMale.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnMale.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMale.gridx = 1;
		gbc_rdbtnMale.gridy = 8;
		
		contentPane.add(rdbtnMale, gbc_rdbtnMale);
		
		
		btnSaveCamperComplete = new JButton("Save Camper");
		
		
		rdbtnFemale = new JRadioButton("Female");
		
		
		group.add(rdbtnFemale);
		GridBagConstraints gbc_rdbtnFemale = new GridBagConstraints();
		gbc_rdbtnFemale.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnFemale.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnFemale.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFemale.gridx = 1;
		gbc_rdbtnFemale.gridy = 9;
		contentPane.add(rdbtnFemale, gbc_rdbtnFemale);
		
        rdbtnOther = new JRadioButton("Other");
        
       
        group.add(rdbtnOther);
        
        rdbtnMale.setBackground(Color.GRAY);
        rdbtnFemale.setBackground(Color.GRAY);
        rdbtnOther.setBackground(Color.GRAY);
        rdbtnMale.setForeground(Color.WHITE);
        rdbtnFemale.setForeground(Color.WHITE);
        rdbtnOther.setForeground(Color.WHITE);
        
        GridBagConstraints gbc_rdbtnOther = new GridBagConstraints();
        gbc_rdbtnOther.anchor = GridBagConstraints.NORTH;
        gbc_rdbtnOther.fill = GridBagConstraints.HORIZONTAL;
        gbc_rdbtnOther.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnOther.gridx = 1;
        gbc_rdbtnOther.gridy = 10;
        contentPane.add(rdbtnOther, gbc_rdbtnOther);
		
		JLabel lblDisorders= new JLabel("Disorders/Medical Conditions");
		lblDisorders.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc1= new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.gridwidth=1;
		gbc1.gridx=1;
		gbc1.gridy=11;
		gbc1.insets= new Insets(0,0,5,5);
		contentPane.add(lblDisorders, gbc1);
		
		btnAddEdit = new JButton("Add/Edit");
		btnAddEdit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddEdit.setForeground(Color.YELLOW);
		btnAddEdit.setBackground(Color.BLUE);
		
			GridBagConstraints gbc_btnAddEdit = new GridBagConstraints();
			gbc_btnAddEdit.anchor = GridBagConstraints.WEST;
			gbc_btnAddEdit.insets = new Insets(0, 0, 5, 5);
			gbc_btnAddEdit.gridx = 1;
			gbc_btnAddEdit.gridy = 12;
			
			contentPane.add(btnAddEdit, gbc_btnAddEdit);
		
		JLabel lblMedications= new JLabel("Medications");
		lblMedications.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc3= new GridBagConstraints();
		gbc3.fill = GridBagConstraints.BOTH;
		gbc3.insets = new Insets(0, 0, 5, 5);
		gbc3.gridx=1;
		gbc3.gridy=13;
		contentPane.add(lblMedications,gbc3);
		
		medicationsField= new JTextField();
		
		medicationsField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medicationsField.setColumns(10);
		GridBagConstraints gbc4= new GridBagConstraints();
		gbc4.fill=GridBagConstraints.BOTH;
		gbc4.insets = new Insets(0, 0, 5, 5);
		gbc4.gridwidth = 2;
		gbc4.gridx=1;
		gbc4.gridy=14;
		contentPane.add(medicationsField,gbc4);
		
		JLabel lblAllergies= new JLabel("Allergies");
		lblAllergies.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc5= new GridBagConstraints();
		gbc5.fill = GridBagConstraints.BOTH;
		gbc5.insets = new Insets(0, 0, 5, 5);
		gbc5.gridx=1;
		gbc5.gridy=15;
		contentPane.add(lblAllergies,gbc5);
		
		textFieldAllergies = new JTextField();
		textFieldAllergies.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldAllergies.setColumns(10);
	
		GridBagConstraints gbc_textFieldAllergies = new GridBagConstraints();
		gbc_textFieldAllergies.gridwidth = 2;
		gbc_textFieldAllergies.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAllergies.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAllergies.gridx = 1;
		gbc_textFieldAllergies.gridy = 16;
		contentPane.add(textFieldAllergies, gbc_textFieldAllergies);
		
		lblDietaryPreferences = new JLabel("Dietary Preferences/Restrictions");
		lblDietaryPreferences.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDietaryPreferences = new GridBagConstraints();
		gbc_lblDietaryPreferences.anchor = GridBagConstraints.WEST;
		gbc_lblDietaryPreferences.insets = new Insets(0, 0, 5, 5);
		gbc_lblDietaryPreferences.gridx = 1;
		gbc_lblDietaryPreferences.gridy = 17;
		gbc_lblDietaryPreferences.fill= GridBagConstraints.HORIZONTAL;
		contentPane.add(lblDietaryPreferences, gbc_lblDietaryPreferences);
		
		textFieldDietaryPreferences = new JTextField();
		textFieldDietaryPreferences.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDietaryPreferences.setColumns(10);
		
		GridBagConstraints gbc_textFieldDietaryPreferences = new GridBagConstraints();
		gbc_textFieldDietaryPreferences.gridwidth = 2;
		gbc_textFieldDietaryPreferences.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDietaryPreferences.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDietaryPreferences.gridx = 1;
		gbc_textFieldDietaryPreferences.gridy = 18;
		
		contentPane.add(textFieldDietaryPreferences, gbc_textFieldDietaryPreferences);
		
		lblSpecialNeeds = new JLabel("Special Needs/Accommodations");
		lblSpecialNeeds.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblSpecialNeeds = new GridBagConstraints();
		gbc_lblSpecialNeeds.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpecialNeeds.gridx = 1;
		gbc_lblSpecialNeeds.gridy = 19;
		gbc_lblSpecialNeeds.fill= GridBagConstraints.HORIZONTAL;
		contentPane.add(lblSpecialNeeds, gbc_lblSpecialNeeds);
		
		textFieldSpecialNeeds = new JTextField();
		textFieldSpecialNeeds.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSpecialNeeds.setColumns(10);
		
		GridBagConstraints gbc_textFieldSpecialNeeds = new GridBagConstraints();
		gbc_textFieldSpecialNeeds.gridwidth = 3;
		gbc_textFieldSpecialNeeds.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSpecialNeeds.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSpecialNeeds.gridx = 1;
		gbc_textFieldSpecialNeeds.gridy = 20;
		contentPane.add(textFieldSpecialNeeds, gbc_textFieldSpecialNeeds);
		
		chckbxSpecialRequest = new JCheckBox("Special Cabin Assignment Request");
		chckbxSpecialRequest.setForeground(Color.WHITE);
		chckbxSpecialRequest.setBackground(Color.GRAY);
		chckbxSpecialRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxSpecialRequest.isSelected()==true){
				textFieldSpecialRequest.setEditable(true);}
				else{
					textFieldSpecialRequest.setEditable(false);
				}
				
			}
		});
		GridBagConstraints gbc_chckbxSpecialRequest = new GridBagConstraints();
		gbc_chckbxSpecialRequest.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSpecialRequest.gridx = 1;
		gbc_chckbxSpecialRequest.gridy = 21;
		gbc_chckbxSpecialRequest.fill= GridBagConstraints.HORIZONTAL;
		contentPane.add(chckbxSpecialRequest, gbc_chckbxSpecialRequest);
		
		textFieldSpecialRequest = new JTextField();
		textFieldSpecialRequest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSpecialRequest.setColumns(10);
		
		GridBagConstraints gbc_textFieldSpecialRequest = new GridBagConstraints();
		gbc_textFieldSpecialRequest.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSpecialRequest.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSpecialRequest.gridx = 1;
		gbc_textFieldSpecialRequest.gridy = 22;
		textFieldSpecialRequest.setEditable(false);
		contentPane.add(textFieldSpecialRequest, gbc_textFieldSpecialRequest);
		
		emptyLabel1 = new JLabel("");
		GridBagConstraints gbc_emptyLabel1 = new GridBagConstraints();
		gbc_emptyLabel1.fill = GridBagConstraints.BOTH;
		gbc_emptyLabel1.gridheight = 2;
		gbc_emptyLabel1.insets = new Insets(0, 0, 0, 5);
		gbc_emptyLabel1.gridx = 1;
		gbc_emptyLabel1.gridy = 28;
		contentPane.add(emptyLabel1, gbc_emptyLabel1);
		
		lblEmergecyContacts = new JLabel("Emergecy Contact(s)");
		lblEmergecyContacts.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblEmergecyContacts = new GridBagConstraints();
		gbc_lblEmergecyContacts.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmergecyContacts.gridx = 1;
		gbc_lblEmergecyContacts.gridy = 23;
		gbc_lblEmergecyContacts.fill= GridBagConstraints.HORIZONTAL;
		contentPane.add(lblEmergecyContacts, gbc_lblEmergecyContacts);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 24;
		contentPane.add(lblName, gbc_lblName);
		
		lblRelationship = new JLabel("Relationship");
		lblRelationship.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblRelationship = new GridBagConstraints();
		gbc_lblRelationship.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRelationship.insets = new Insets(0, 0, 5, 5);
		gbc_lblRelationship.gridwidth=2;
		gbc_lblRelationship.gridx = 2;
		gbc_lblRelationship.gridy = 24;
		contentPane.add(lblRelationship, gbc_lblRelationship);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 4;
		gbc_lblPhoneNumber.gridy = 24;
		contentPane.add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		textFieldContactName1 = new JTextField();
		textFieldContactName1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldContactName1.setColumns(10);
		
		GridBagConstraints gbc_textFieldContactName1 = new GridBagConstraints();
		gbc_textFieldContactName1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContactName1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContactName1.gridx = 1;
		gbc_textFieldContactName1.gridy = 25;
		contentPane.add(textFieldContactName1, gbc_textFieldContactName1);
		
		textFieldContactRelationship1 = new JTextField();
	
		textFieldContactRelationship1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textFieldContactRelationship1 = new GridBagConstraints();
		gbc_textFieldContactRelationship1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContactRelationship1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContactRelationship1.gridwidth=2;
		gbc_textFieldContactRelationship1.gridx = 2;
		gbc_textFieldContactRelationship1.gridy = 25;
		contentPane.add(textFieldContactRelationship1, gbc_textFieldContactRelationship1);
		textFieldContactRelationship1.setColumns(10);
		
		textFieldPhone1 = new JTextField();
		textFieldPhone1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPhone1.setColumns(10);
		
		GridBagConstraints gbc_textFieldPhone1 = new GridBagConstraints();
		gbc_textFieldPhone1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPhone1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone1.gridx = 4;
		gbc_textFieldPhone1.gridy = 25;
		contentPane.add(textFieldPhone1, gbc_textFieldPhone1);
		
		chckbxAddnd = new JCheckBox("Add 2nd Contact");
		chckbxAddnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxAddnd.isSelected()==true){
				textFieldContactName2.setEditable(true);
				textFieldContactRelationship2.setEditable(true);
				textFieldPhone2.setEditable(true);}
				else{
					textFieldContactName2.setEditable(false);
					textFieldContactRelationship2.setEditable(false);
					textFieldPhone2.setEditable(false);
				}
			}
		});
		chckbxAddnd.setForeground(Color.WHITE);
		chckbxAddnd.setBackground(Color.BLUE);
		GridBagConstraints gbc_chckbxAddnd = new GridBagConstraints();
		gbc_chckbxAddnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxAddnd.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAddnd.gridx = 1;
		gbc_chckbxAddnd.gridy = 26;
		contentPane.add(chckbxAddnd, gbc_chckbxAddnd);
		
		textFieldContactName2 = new JTextField();
		textFieldContactName2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldContactName2.setEditable(false);
		textFieldContactName2.setColumns(10);
		
		textFieldContactName2.setEditable(false);
		GridBagConstraints gbc_textFieldContactName2 = new GridBagConstraints();
		gbc_textFieldContactName2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContactName2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContactName2.gridx = 1;
		gbc_textFieldContactName2.gridy = 27;
		contentPane.add(textFieldContactName2, gbc_textFieldContactName2);
		
		textFieldContactRelationship2 = new JTextField();
		textFieldContactRelationship2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldContactRelationship2.setColumns(10);
		
		textFieldContactRelationship2.setEditable(false);
		GridBagConstraints gbc_textFieldContactRelationship2 = new GridBagConstraints();
		gbc_textFieldContactRelationship2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldContactRelationship2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldContactRelationship2.gridwidth=2;
		gbc_textFieldContactRelationship2.gridx = 2;
		gbc_textFieldContactRelationship2.gridy = 27;
		contentPane.add(textFieldContactRelationship2, gbc_textFieldContactRelationship2);
		
		textFieldPhone2 = new JTextField();
		textFieldPhone2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPhone2.setColumns(10);
		
		textFieldPhone2.setEditable(false);
		GridBagConstraints gbc_textFieldPhone2 = new GridBagConstraints();
		gbc_textFieldPhone2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPhone2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPhone2.gridx = 4;
		gbc_textFieldPhone2.gridy = 27;
		contentPane.add(textFieldPhone2, gbc_textFieldPhone2);
		
		
		
		
		
		
		
		
		btnSaveCamperComplete.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		GridBagConstraints gbc_btnSaveCamperComplete = new GridBagConstraints();
		gbc_btnSaveCamperComplete.fill = GridBagConstraints.BOTH;
		gbc_btnSaveCamperComplete.insets = new Insets(0, 0, 0, 5);
	
		gbc_btnSaveCamperComplete.gridx = 1;
		gbc_btnSaveCamperComplete.gridy = 29;
		contentPane.add(btnSaveCamperComplete, gbc_btnSaveCamperComplete);
		
		btnCancelReturn = new JButton("Cancel");
		
		
		btnCancelReturn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		GridBagConstraints gbc_btnCancelReturn = new GridBagConstraints();
		gbc_btnCancelReturn.fill = GridBagConstraints.BOTH;
		gbc_btnCancelReturn.gridx = 3;
		gbc_btnCancelReturn.gridy = 29;
		contentPane.add(btnCancelReturn, gbc_btnCancelReturn);
		
		JScrollPane scrollPane= new JScrollPane(contentPane);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		
		txList.addAll(Arrays.asList(firstNameField, lastNameField, dobField, medicationsField,
				textFieldAllergies, textFieldDietaryPreferences, textFieldSpecialNeeds, 
				textFieldSpecialRequest, textFieldContactName1, textFieldContactName2, 
				textFieldContactRelationship1, textFieldContactRelationship2, textFieldPhone1, textFieldPhone2 ));
		
		if(Home.colorful==true){
			for(JTextField field: txList){
				field.setBackground(Color.CYAN);
				
			}
			contentPane.setBackground(Color.ORANGE);
			rdbtnMale.setBackground(Color.CYAN);
			rdbtnFemale.setBackground(Color.CYAN);
			rdbtnOther.setBackground(Color.CYAN);
			rdbtnMale.setForeground(null);
			rdbtnFemale.setForeground(null);
			rdbtnOther.setForeground(null);
			btnCancelReturn.setBackground(new Color(128, 0, 128));
			btnCancelReturn.setForeground(new Color(255, 215, 0));
			btnSaveCamperComplete.setBackground(new Color(128, 0, 128));
			btnSaveCamperComplete.setForeground(new Color(255, 215, 0));
			
			chckbxSpecialRequest.setBackground(Color.BLUE);
		}
		
		
		
		frame.setVisible(true);
		
		
		frame.setResizable(true);
		frame.setPreferredSize(new Dimension(800,500));
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		addActionListeners();
	}
	
	private void addActionListeners(){
		btnSaveCamperComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveCamper();
				}
		});
		
		btnCancelReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnAddEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEditDisorders();
			}
		});
	}
	
	private void saveCamper(){
		
		boolean addCamper= true;
//This boolean will sets a command to exit the method if false.  It is necessary as the for loop is nested and cannot terminate the entire method. 
		for(Camper c: camperList){
//Check to see if a camper with the same first and last name already appears.  
			if((c.getFirstName().equalsIgnoreCase(firstNameField.getText()))&&(c.getLastName().equalsIgnoreCase(lastNameField.getText()))){
				int option= JOptionPane.showConfirmDialog(null, "A camper with the name "+c.getFirstName()+" "+c.getLastName()+
						" already exists.  Are you sure you wish to add them again?");
				if((option==JOptionPane.NO_OPTION)||(option==JOptionPane.CANCEL_OPTION)){
				   addCamper = false;
				}
			}
		}
		
		if(addCamper==false){
			return;
		}
		
		Camper camper1= new Camper(lastNameField.getText(), firstNameField.getText(), rdbtnMale.isSelected() ? 'M' : rdbtnFemale.isSelected() ? 'F' : rdbtnOther.isSelected() ? 'O' : null);
		
		
		
		camper1.setDob(dobField.getText());
		camper1.setDisorders(temporaryOtherDisorder);
		camper1.setMedications(medicationsField.getText());
		camper1.setAllergies(textFieldAllergies.getText());
		camper1.setDietaryPreferences(textFieldDietaryPreferences.getText());
		camper1.setSpecialNeeds(textFieldSpecialNeeds.getText());
		  if(chckbxSpecialRequest.isSelected()==true) {
                                                                            camper1.setSpecialRequest(textFieldSpecialRequest.getText());}
                                                                            else{
                                                                                camper1.setSpecialRequest(null);
                                                                            }
		camper1.setEmergencyContact1(textFieldContactName1.getText());
		camper1.setEmergencyContact2(textFieldContactName2.getText());
		camper1.setEmergencyContactRelationship1(textFieldContactRelationship1.getText());
		camper1.setEmergencyContactRelationship2(textFieldContactRelationship2.getText());
		camper1.setEmergencyContactPhone1(textFieldPhone1.getText());
		camper1.setEmergencyContactPhone2(textFieldPhone2.getText());
		camper1.disordersList=temporaryDisorderList;
                
                                             if(MainJFrame.validated==false){
                                         if(NewCamper.camperList.size()>=20){
                                             JOptionPane.showMessageDialog(null, "The trial version only allows you to add up to 20 campers");
                                             return;
                                         }
                                     }
		
		
		
		if(camper1.dateOfBirth!=null){
		int option=JOptionPane.showConfirmDialog(null, "Camper added successfully!  Would you like to add another camper?");
		if(option==JOptionPane.YES_OPTION){
			NewCamper camper= new NewCamper();
			camper.setVisible(true);
		}
                
                                
		frame.dispose();
		camperList.add(camper1);
		camperList2.add(camper1);
		System.out.println(camper1.disordersList);
		}
		else{
			
		}
		
		
		
		
}
	
	private void addEditDisorders(){
		
		ArrayList<JCheckBox> checkBoxList= new ArrayList<JCheckBox>();
		JFrame frame= new JFrame("DISORDERS");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		 
	   
	    
	    JPanel panel= new JPanel();
	    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
	    panel.setBackground(Color.BLUE);
	    frame.getContentPane().add(panel);
	   
	    panel.setBorder( new EmptyBorder(20, 20, 20, 20) );
	    
	    JLabel heading= new JLabel("Check All That Apply");
	    heading.setAlignmentX(0.5f);
	    heading.setFont(new Font("Tahoma", Font.BOLD, 30));
	    heading.setForeground(Color.WHITE);
	    panel.add(heading);
	    
	    panel.add(Box.createVerticalStrut(10));
	    
	    JPanel panel2= new JPanel();
	    panel2.setLayout(new GridLayout(3,3));
	    panel2.setBackground(Color.YELLOW);
	    panel.add(panel2);
	    
	    JCheckBox chckbxADHD= new JCheckBox("ADHD");
	    panel2.add(chckbxADHD);
	    checkBoxList.add(chckbxADHD);
	    
	    JCheckBox chckbxAnxiety= new JCheckBox("Anxiety");
	    panel2.add(chckbxAnxiety);
	    checkBoxList.add(chckbxAnxiety);
	    
	    JCheckBox chckbxAsthma= new JCheckBox("Asthma");
	    panel2.add(chckbxAsthma);
	    checkBoxList.add(chckbxAsthma);
	    
	    JCheckBox chckbxAutism= new JCheckBox("Autism");
	    panel2.add(chckbxAutism);
	    checkBoxList.add(chckbxAutism);
	    
	    JCheckBox chckbxBedwetting= new JCheckBox("Bedwetting");
	    panel2.add(chckbxBedwetting);
	    checkBoxList.add(chckbxBedwetting);
	  
	    
	    JCheckBox chckbxDepression= new JCheckBox("Depression");
	    panel2.add(chckbxDepression);
	    checkBoxList.add(chckbxDepression);
	    JCheckBox chckbxOther= new JCheckBox("Other");
	   
	    panel2.add(chckbxOther);
	    checkBoxList.add(chckbxOther);
	    for(JCheckBox jbx: checkBoxList){
	    	jbx.setBackground(Color.YELLOW);
	    }
	    
	    JTextField txtFieldOther= new JTextField();
	    txtFieldOther.setBackground(Color.YELLOW);
	    panel2.add(txtFieldOther);
	    if((temporaryOtherDisorder==null)||(temporaryOtherDisorder.length()==0)){
	    txtFieldOther.setEditable(false);}
	    
 chckbxOther.addActionListener(new ActionListener(){
	 public void actionPerformed(ActionEvent arg0) {
				if(chckbxOther.isSelected()==true){
					txtFieldOther.setEditable(true);
				}
				else{
					txtFieldOther.setEditable(false);
				}} });
 
/*
 * The temporary disorder list is created so that if a user re-opens the frame, it will have the recent boxes checked so it won't risk adding any disorders twice.
 * The disorder list for the camper will be set equal to the disorder list. 
 */
 
 if(temporaryDisorderList.contains("Attention Deficit Hyperactivity Disorder(ADHD)")){
	 chckbxADHD.setSelected(true);
 }
 if(temporaryDisorderList.contains("Anxiety")){
	 chckbxAnxiety.setSelected(true);
 }
 if(temporaryDisorderList.contains("Asthma")){
	 chckbxAsthma.setSelected(true);
 }
 if(temporaryDisorderList.contains("Nocturnal Enuresis(Bedwetting)")){
	 chckbxBedwetting.setSelected(true);
 }
 
 if(temporaryDisorderList.contains("Depression")){
	 chckbxDepression.setSelected(true);
 }
 if(temporaryDisorderList.contains("Autism Spectrum Disorder")){
	 chckbxAutism.setSelected(true);
 }
 if((temporaryOtherDisorder!=null)&&(temporaryOtherDisorder.length()>0)){
	 chckbxOther.setSelected(true);
	 txtFieldOther.setText(temporaryOtherDisorder);
 }

 
 JButton saveButton= new JButton("Save");
 saveButton.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		temporaryDisorderList.clear();
		if(chckbxADHD.isSelected()==true){
			temporaryDisorderList.add("Attention Deficit Hyperactivity Disorder(ADHD)");
			}
		
		if(chckbxAnxiety.isSelected()==true){
			temporaryDisorderList.add("Anxiety");
		}
		if(chckbxAsthma.isSelected()==true){
	    	temporaryDisorderList.add("Asthma");
	    	}
	    if(chckbxAutism.isSelected()==true){
	    	temporaryDisorderList.add("Autism Spectrum Disorder");
	    }
	    if(chckbxBedwetting.isSelected()==true){
	    	temporaryDisorderList.add("Nocturnal Enuresis(Bedwetting)");
	    }
	    
	    if(chckbxDepression.isSelected()==true){
	    	temporaryDisorderList.add("Depression");
	    }
	   temporaryOtherDisorder= txtFieldOther.getText();
	    
	    frame.dispose();
	    System.out.println(temporaryDisorderList);
		
	}
	
	 
 });
 saveButton.setAlignmentX(0.5f);
 panel.add(Box.createVerticalStrut(20));
 panel.add(saveButton);
 
 panel.add(Box.createVerticalStrut(20));
	    
	    		
	    
	    
	    
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
		
		
	}
	
	
	}
		
	
	
	
	

