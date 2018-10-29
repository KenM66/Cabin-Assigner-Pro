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
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CampInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCampName;
	private JTextField textFieldCampDate;
	private JLabel lblCampSlogan;
	private JTextField textFieldCampSlogan;
	private JLabel lblTitle;
	
	static LocalDate dateOfCamp;  //The age of the camper depends on their birth date subtracted from this number in years.
	static String nameOfCamp;
	static String sloganOfCamp;
	static String campDateString;
	
    //The camp name and slogan serve no functional purpose, but only print out with the reports. 
	
	public CampInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		//gbl_contentPane.columnWidths = new int[]{13, 471, 0};
		//gbl_contentPane.rowHeights = new int[]{36, 106, 31, 37, 36, 37, 36, 44, 36, 46, 25, 0};
	//	gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		//gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblTitle = new JLabel("Camp Information");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 35));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.fill = GridBagConstraints.BOTH;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		contentPane.add(lblTitle, gbc_lblTitle);
		
		JLabel lblCampName = new JLabel("Camp Name");
		
		lblCampName.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblCampName = new GridBagConstraints();
		gbc_lblCampName.anchor = GridBagConstraints.WEST;
		gbc_lblCampName.fill = GridBagConstraints.VERTICAL;
		gbc_lblCampName.insets = new Insets(0, 0, 5, 0);
		gbc_lblCampName.gridx = 1;
		gbc_lblCampName.gridy = 3;
		contentPane.add(lblCampName, gbc_lblCampName);
		
		textFieldCampName = new JTextField(nameOfCamp);
		
		textFieldCampName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldCampName.setColumns(10);
		GridBagConstraints gbc_textFieldCampName = new GridBagConstraints();
		gbc_textFieldCampName.fill = GridBagConstraints.BOTH;
		gbc_textFieldCampName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCampName.gridx = 1;
		gbc_textFieldCampName.gridy = 4;
		contentPane.add(textFieldCampName, gbc_textFieldCampName);
		
		JLabel lblDateCampBegins = new JLabel("Date Camp Begins (MM/DD/YYYY)");
		
		lblDateCampBegins.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblDateCampBegins = new GridBagConstraints();
		gbc_lblDateCampBegins.anchor = GridBagConstraints.WEST;
		gbc_lblDateCampBegins.fill = GridBagConstraints.VERTICAL;
		gbc_lblDateCampBegins.insets = new Insets(0, 0, 5, 0);
		gbc_lblDateCampBegins.gridx = 1;
		gbc_lblDateCampBegins.gridy = 5;
		contentPane.add(lblDateCampBegins, gbc_lblDateCampBegins);
		
		textFieldCampDate = new JTextField(campDateString);
		
			
			textFieldCampDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			textFieldCampDate.setColumns(10);
			GridBagConstraints gbc_textFieldCampDate = new GridBagConstraints();
			gbc_textFieldCampDate.fill = GridBagConstraints.BOTH;
			gbc_textFieldCampDate.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCampDate.gridx = 1;
			gbc_textFieldCampDate.gridy = 6;
			contentPane.add(textFieldCampDate, gbc_textFieldCampDate);
		
		lblCampSlogan = new JLabel("Camp Slogan");
		
		lblCampSlogan.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblCampSlogan = new GridBagConstraints();
		gbc_lblCampSlogan.anchor = GridBagConstraints.WEST;
		gbc_lblCampSlogan.fill = GridBagConstraints.VERTICAL;
		gbc_lblCampSlogan.insets = new Insets(0, 0, 5, 0);
		gbc_lblCampSlogan.gridx = 1;
		gbc_lblCampSlogan.gridy = 7;
		contentPane.add(lblCampSlogan, gbc_lblCampSlogan);
		
		textFieldCampSlogan = new JTextField(sloganOfCamp);
		textFieldCampSlogan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldCampSlogan.setColumns(10);
		GridBagConstraints gbc_textFieldCampSlogan = new GridBagConstraints();
		gbc_textFieldCampSlogan.fill = GridBagConstraints.BOTH;
		gbc_textFieldCampSlogan.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCampSlogan.gridx = 1;
		gbc_textFieldCampSlogan.gridy = 8;
		contentPane.add(textFieldCampSlogan, gbc_textFieldCampSlogan);
		
			
			JButton btnSave = new JButton("SAVE");
			
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Camp camp1= new Camp();
					camp1.setCampDate(textFieldCampDate.getText());
					
					camp1.setDateString(textFieldCampDate.getText());	
					
                    camp1.setCampName(textFieldCampName.getText());
					
					camp1.setCampSlogan(textFieldCampSlogan.getText());
					
					if(dateOfCamp!=null){
						if(Period.between(LocalDate.now(), dateOfCamp).getDays()>=0){
						dispose();}
						else if((Period.between(LocalDate.now(), dateOfCamp).getDays()<0)){
							JOptionPane.showMessageDialog(null, "The camp date must be on or after the current date.");
							dateOfCamp=null;
							
						}
					}
					
					else{
						dateOfCamp=null;
					}
					
					
				}
			});
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_btnSave = new GridBagConstraints();
			gbc_btnSave.anchor = GridBagConstraints.NORTH;
			gbc_btnSave.gridx = 1;
			gbc_btnSave.gridy = 10;
			contentPane.add(btnSave, gbc_btnSave);
		

		
		JLabel emptyLabel= new JLabel();
		GridBagConstraints gbc1= new GridBagConstraints();
		gbc1.gridwidth=6;
		gbc1.gridx= 2;
		gbc1.gridy=1;
		contentPane.add(emptyLabel,gbc1);
		
		if(Home.colorful==true){
			contentPane.setBackground(new Color(51, 153, 51));
			lblTitle.setForeground(new Color(176, 224, 230));
			lblCampName.setForeground(new Color(255, 215, 0));
			textFieldCampName.setForeground(new Color(255, 255, 255));
			textFieldCampName.setBackground(new Color(128, 0, 0));
			textFieldCampDate.setForeground(new Color(255, 255, 255));
			textFieldCampDate.setBackground(new Color(128, 0, 0));
			textFieldCampSlogan.setForeground(new Color(255, 255, 255));
			textFieldCampSlogan.setBackground(new Color(128, 0, 0));
			btnSave.setForeground(Color.YELLOW);
			btnSave.setBackground(Color.BLACK);
			lblDateCampBegins.setForeground(new Color(255, 215, 0));
			lblCampSlogan.setForeground(new Color(255, 215, 0));
			
		}
		
		
		
		pack();
		setLocationRelativeTo(null);
		
		
	
	}
}
