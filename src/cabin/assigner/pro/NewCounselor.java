/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;

public class NewCounselor extends JFrame {
	
	static List<Counselor> counselorList= new ArrayList<Counselor>();
	static List<Counselor> counselorList2= new ArrayList<Counselor>();

	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
    //ButtonGroup buttonGroup;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnOther;
	private JTextField textFieldRequest;
	private JButton btnCancel;
	private JButton btnSaveCounselor;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public NewCounselor() {
		super("New Counselor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(300, 300, 631, 525);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		//gbl_contentPane.columnWidths = new int[]{48, 204, 43, 127, 177, 138, 0};
		//gbl_contentPane.rowHeights = new int[]{57, 31, 35, 43, 35, 43, 32, 25, 28, 38, 0};
		//gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		//gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCounselorInformation = new JLabel("Counselor Information");
		
		lblCounselorInformation.setFont(new Font("Tahoma", Font.BOLD, 27));
		GridBagConstraints gbc_lblCounselorInformation = new GridBagConstraints();
		gbc_lblCounselorInformation.anchor = GridBagConstraints.WEST;
		gbc_lblCounselorInformation.fill = GridBagConstraints.VERTICAL;
		gbc_lblCounselorInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblCounselorInformation.gridwidth = 4;
		gbc_lblCounselorInformation.gridx = 1;
		gbc_lblCounselorInformation.gridy = 0;
		contentPane.add(lblCounselorInformation, gbc_lblCounselorInformation);
		
		JLabel lblFirstName = new JLabel("First Name");
		
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.fill = GridBagConstraints.BOTH;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridwidth = 3;
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 2;
		contentPane.add(lblFirstName, gbc_lblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GridBagConstraints gbc_firstNameField = new GridBagConstraints();
		gbc_firstNameField.fill = GridBagConstraints.BOTH;
		gbc_firstNameField.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameField.gridwidth = 3;
		gbc_firstNameField.gridx = 1;
		gbc_firstNameField.gridy = 3;
		contentPane.add(firstNameField, gbc_firstNameField);
		firstNameField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.BOTH;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridwidth = 3;
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 4;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GridBagConstraints gbc_lastNameField = new GridBagConstraints();
		gbc_lastNameField.fill = GridBagConstraints.BOTH;
		gbc_lastNameField.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameField.gridwidth = 3;
		gbc_lastNameField.gridx = 1;
		gbc_lastNameField.gridy = 5;
		contentPane.add(lastNameField, gbc_lastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.fill = GridBagConstraints.BOTH;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridwidth = 2;
		gbc_lblGender.gridx = 1;
		gbc_lblGender.gridy = 6;
		contentPane.add(lblGender, gbc_lblGender);
		
		rdbtnMale = new JRadioButton("Male", true);
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setBackground(Color.GRAY);
		GridBagConstraints gbc_rdbtnMale = new GridBagConstraints();
		gbc_rdbtnMale.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnMale.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnMale.insets = new Insets(0, 0, 5, 5);
		
		gbc_rdbtnMale.gridx = 1;
		gbc_rdbtnMale.gridy = 7;
		contentPane.add(rdbtnMale, gbc_rdbtnMale);
		//buttonGroup.add(rdbtnMale);
		
		 rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setBackground(Color.GRAY);
		GridBagConstraints gbc_rdbtnFemale = new GridBagConstraints();
		gbc_rdbtnFemale.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnFemale.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnFemale.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnFemale.gridwidth=2;
		gbc_rdbtnFemale.gridx = 2;
		gbc_rdbtnFemale.gridy = 7;
		contentPane.add(rdbtnFemale, gbc_rdbtnFemale);
		//buttonGroup.add(rdbtnFemale);
		
		 rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setForeground(Color.WHITE);
		rdbtnOther.setBackground(Color.GRAY);
		GridBagConstraints gbc_rdbtnOther = new GridBagConstraints();
		gbc_rdbtnOther.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnOther.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnOther.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOther.gridx = 4;
		gbc_rdbtnOther.gridy = 7;
		contentPane.add(rdbtnOther, gbc_rdbtnOther);
		//buttonGroup.add(rdbtnOther);
		
		btnSaveCounselor = new JButton("SAVE COUNSELOR");
		
		
		JCheckBox chckbxCabinAssignmentRequest = new JCheckBox("Cabin Assignment Request");
		chckbxCabinAssignmentRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxCabinAssignmentRequest.isSelected()==true){
					textFieldRequest.setEditable(true);
				}
				else{
					textFieldRequest.setEditable(false);
				}
			}
		});
		chckbxCabinAssignmentRequest.setForeground(new Color(128, 0, 128));
		chckbxCabinAssignmentRequest.setBackground(Color.GRAY);
		 chckbxCabinAssignmentRequest.setForeground(Color.WHITE);
		GridBagConstraints gbc_chckbxCabinAssignmentRequest = new GridBagConstraints();
		gbc_chckbxCabinAssignmentRequest.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxCabinAssignmentRequest.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCabinAssignmentRequest.gridx = 1;
		gbc_chckbxCabinAssignmentRequest.gridy = 8;
		contentPane.add(chckbxCabinAssignmentRequest, gbc_chckbxCabinAssignmentRequest);
		
		textFieldRequest = new JTextField();
		textFieldRequest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldRequest.setColumns(10);
		
		GridBagConstraints gbc_textFieldRequest = new GridBagConstraints();
		gbc_textFieldRequest.gridwidth = 3;
		gbc_textFieldRequest.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRequest.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRequest.gridx = 1;
		gbc_textFieldRequest.gridy = 9;
		contentPane.add(textFieldRequest, gbc_textFieldRequest);
		btnSaveCounselor.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		GridBagConstraints gbc_btnSaveCounselor = new GridBagConstraints();
		gbc_btnSaveCounselor.fill = GridBagConstraints.BOTH;
		gbc_btnSaveCounselor.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveCounselor.gridx = 1;
		gbc_btnSaveCounselor.gridy = 12;
		textFieldRequest.setEditable(false);
		contentPane.add(btnSaveCounselor, gbc_btnSaveCounselor);
		
		ButtonGroup buttonGroup= new ButtonGroup();
		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);
		buttonGroup.add(rdbtnOther);
		
		
		
		 btnCancel = new JButton("CANCEL");
		 btnCancel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 	}
		 });
		
		 btnCancel.setFont(new Font("Tahoma", Font.BOLD, 17));
		 GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		 gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		 gbc_btnCancel.fill = GridBagConstraints.BOTH;
		 gbc_btnCancel.gridx = 3;
		 gbc_btnCancel.gridy = 12;
		 contentPane.add(btnCancel, gbc_btnCancel);
		 
		 if(Home.colorful==true){
			 contentPane.setBackground(new Color(255, 255, 0));
			 lblCounselorInformation.setForeground(new Color(148, 0, 211));
			 lblFirstName.setForeground(new Color(128, 0, 128));
		        firstNameField.setForeground(new Color(0, 0, 0));
			firstNameField.setBackground(new Color(135, 206, 250));
		    lblLastName.setForeground(new Color(128, 0, 128));
		    lastNameField.setBackground(new Color(135, 206, 250));
		    lblGender.setForeground(new Color(128, 0, 128));
		    rdbtnMale.setForeground(new Color(255, 255, 255));
			rdbtnMale.setBackground(new Color(0, 128, 0));
			rdbtnFemale.setForeground(new Color(255, 255, 255));
			rdbtnFemale.setBackground(new Color(0, 128, 0));
		    rdbtnOther.setForeground(new Color(255, 255, 255));
			rdbtnOther.setBackground(new Color(0, 128, 0));
			 btnCancel.setBackground(new Color(0, 255, 0));
			 textFieldRequest.setBackground(new Color(135, 206, 250));
			 chckbxCabinAssignmentRequest.setBackground(Color.GREEN);
			 btnSaveCounselor.setBackground(new Color(0, 255, 0));
		 }
		
		pack();
		setLocationRelativeTo(null);
		
		addActionListeners();
	}
	
	private void saveCounselor(){
		if((lastNameField.getText().isEmpty())||(firstNameField.getText().isEmpty())){
			JOptionPane.showMessageDialog(null, "A first and last name must be entered!");
			return;
		}
		boolean addCounselor=true;
		for(Counselor c: counselorList){
			if(((c.getFirstName().equals(firstNameField.getText())))&&(c.getLastName().equals(lastNameField.getText()))){
				int option=JOptionPane.showConfirmDialog(null, "A counselor with the name "+c.getFirstName()+" "+c.getLastName()
				+" already exists.  Are you sure you wish to add another counselor with the same name?");
				
				if(((option==JOptionPane.NO_OPTION)||(option==JOptionPane.CANCEL_OPTION))){
					addCounselor=false;
				}
			}
			
		}
		
		if(addCounselor==false){
			
			return;
		}
		
		Counselor counselor1= new Counselor(lastNameField.getText(), firstNameField.getText(), rdbtnMale.isSelected() ? 'M' : rdbtnFemale.isSelected() ? 'F' : rdbtnOther.isSelected() ? 'O' : null);
		
		
		counselor1.setRequest(textFieldRequest.getText());
		int option=JOptionPane.showConfirmDialog(null, "COUNSELOR ADDED SUCCESSFULLY!  Would you like to add a new counselor?");
		counselorList.add(counselor1);
		counselorList2.add(counselor1);
		
		if(option==JOptionPane.YES_OPTION){
			NewCounselor counselor= new NewCounselor();
			counselor.setVisible(true);
		}
		
		dispose();
		
	}
	private void addActionListeners(){
		
		btnSaveCounselor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCounselor();
			}
		});
		
	}
}
