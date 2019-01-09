/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteCabin extends JFrame {
	
	//This can be used to edit or delete a cabin.  It was originally intended to be for deleting purposes only, hence the name of the class. 
	private JList cabinJList;
	private JButton btnEditName;
	private JButton deleteButton;
	private JButton btnEditGender;
	private JButton btnCamperCapacity;
	private JButton btnAgeMin;
	private JButton btnAgeMax;
	private JButton btnCounselors;
	private DefaultListModel<Cabin> cabinsModel= new DefaultListModel<Cabin>();

	

	
	public DeleteCabin() {
		
		super("MODIFY CABIN");
		ArrayList<JButton>buttonList=new ArrayList<JButton>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(300, 300, 850, 600);
	
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		//gridBagLayout.columnWidths = new int[]{78, 136, 109, 43, 4, 166, 178, 0};
		//gridBagLayout.rowHeights = new int[]{32, 82, 162, 40, 40, 41, 64, 0};
		//gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		//gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		//getContentPane()setBorder(new EmptyBorder(20,30,20,50));
		JLabel lblSelectACabin = new JLabel("Select Cabin ");
		lblSelectACabin.setForeground(Color.BLUE);
		lblSelectACabin.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblSelectACabin = new GridBagConstraints();
		gbc_lblSelectACabin.fill = GridBagConstraints.BOTH;
		gbc_lblSelectACabin.insets = new Insets(0, 110, 5, 0);
		gbc_lblSelectACabin.gridwidth = 5;
		gbc_lblSelectACabin.gridx = 2;
		gbc_lblSelectACabin.gridy = 1;
		getContentPane().add(lblSelectACabin, gbc_lblSelectACabin);
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.VERTICAL;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 2;
		gbc_scrollPane.ipadx=200;
		scrollPane.setPreferredSize(new Dimension(75,250));
		getContentPane().add(scrollPane, gbc_scrollPane);
		getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.LIGHT_GRAY));
		
		
		cabinJList= new JList(cabinsModel);
		scrollPane.setViewportView(cabinJList);
		cabinJList.setFont(new Font("Tahoma", Font.BOLD, 16));
		cabinJList.setAlignmentY(50.0f);
		cabinJList.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		cabinJList.setVisibleRowCount(20);
		cabinJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		btnEditName = new JButton("Edit Cabin Name");
		
		btnEditName.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		GridBagConstraints gbc_btnEditName = new GridBagConstraints();
		gbc_btnEditName.fill = GridBagConstraints.BOTH;
		gbc_btnEditName.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditName.gridx = 1;
		gbc_btnEditName.gridy = 3;
		getContentPane().add(btnEditName, gbc_btnEditName);
		
	    btnEditGender = new JButton("Edit Cabin Gender");
		
		btnEditGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnEditGender = new GridBagConstraints();
		gbc_btnEditGender.fill = GridBagConstraints.BOTH;
		gbc_btnEditGender.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditGender.gridwidth = 3;
		gbc_btnEditGender.gridx = 2;
		gbc_btnEditGender.gridy = 3;
		getContentPane().add(btnEditGender, gbc_btnEditGender);
		
		btnAgeMin = new JButton("Edit Minimum Age");
		
		
		btnAgeMin.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnAgeMin = new GridBagConstraints();
		gbc_btnAgeMin.fill = GridBagConstraints.BOTH;
		gbc_btnAgeMin.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgeMin.gridx = 5;
		gbc_btnAgeMin.gridy = 3;
		getContentPane().add(btnAgeMin, gbc_btnAgeMin);
		
		btnAgeMax = new JButton("Edit Maximum Age");
		
		btnAgeMax.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnAgeMax = new GridBagConstraints();
		gbc_btnAgeMax.anchor = GridBagConstraints.WEST;
		gbc_btnAgeMax.fill = GridBagConstraints.VERTICAL;
		gbc_btnAgeMax.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgeMax.gridx = 6;
		gbc_btnAgeMax.gridy = 3;
		getContentPane().add(btnAgeMax, gbc_btnAgeMax);
		
		btnCamperCapacity = new JButton("Edit Camper Capacity");
		
	
		btnCamperCapacity.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnCamperCapacity = new GridBagConstraints();
		gbc_btnCamperCapacity.anchor = GridBagConstraints.EAST;
		gbc_btnCamperCapacity.fill = GridBagConstraints.VERTICAL;
		gbc_btnCamperCapacity.insets = new Insets(0, 130, 5, 5);
		gbc_btnCamperCapacity.gridwidth = 2;
		gbc_btnCamperCapacity.gridx = 1;
		gbc_btnCamperCapacity.gridy = 4;
		getContentPane().add(btnCamperCapacity, gbc_btnCamperCapacity);
		
		btnCounselors = new JButton("Edit # of Counselors");
		
		btnCounselors.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnCounselors = new GridBagConstraints();
		gbc_btnCounselors.fill = GridBagConstraints.BOTH;
		gbc_btnCounselors.insets = new Insets(0, 30, 5, 5);
		gbc_btnCounselors.gridwidth = 1;
		gbc_btnCounselors.gridx = 5;
		gbc_btnCounselors.gridy = 4;
		getContentPane().add(btnCounselors, gbc_btnCounselors);
		
		deleteButton = new JButton("Delete");
	;
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.fill = GridBagConstraints.VERTICAL;
		gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteButton.gridwidth = 4;
		gbc_deleteButton.gridx = 2;
		gbc_deleteButton.gridy = 6;
		getContentPane().add(deleteButton, gbc_deleteButton);
		
		buttonList.addAll(Arrays.asList(btnEditName, deleteButton, btnEditGender, btnAgeMin, btnAgeMax, btnCamperCapacity, btnCounselors ));
		
		if(Home.colorful==true){
			for(JButton button:buttonList){
				button.setForeground(Color.WHITE);
				button.setBackground(Color.BLUE);
			}
			getContentPane().setForeground(Color.CYAN);
			getContentPane().setBackground(Color.ORANGE);
			cabinJList.setForeground(Color.BLUE);
			cabinJList.setBackground(new Color(152, 251, 152));
			getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.GREEN));
		}
		
		initCabinsModel();
		addListeners();
		
		
		pack();
		setLocationRelativeTo(null);
	}
	private void initCabinsModel(){
		
		Collections.sort( NewCabin.cabinList , new Comparator<Cabin>(){
			
			public int compare(Cabin c1, Cabin c2){
				String order= "MFN";
				char gender1= c1.getCabinGender();
				char gender2= c2.getCabinGender();

              int gResult= order.indexOf(gender1)-order.indexOf(gender2);
              
              if(gResult!=0){
            	  return gResult;
              }
                
               int aResult= c1.getAgeMin()- c2.getAgeMin();
               return aResult;
             }});
		
		  
		for (Cabin s: NewCabin.cabinList){
			
			
			
			cabinsModel.addElement(s);
			cabinJList.setSelectedIndex(0);
			
			
		}
		
	}
	
	private void editCabinName(){
		
		Cabin cabin1=(((Cabin) cabinJList.getSelectedValue()));
if(cabin1!=null){
	     String response= JOptionPane.showInputDialog(null, "Enter Name", cabin1.getCabinName());
		if(response!=null){
		cabin1.setCabinName(response);
                                      cabin1.setValuesChanged(true);
		
	        cabinsModel.removeAllElements();
	    	initCabinsModel();}
		else{
			return;
		}}
else{
	return;
}
	}
	private void deleteCabin(){
	
		JFrame frame = new JFrame();
		Cabin deleteCabin= (Cabin) cabinJList.getSelectedValue();
	
	if(deleteCabin!=null){
		if(NewCabin.cabinList2.contains(deleteCabin)){
			/*
			 * Once any campers or counselors are assigned to a cabin, it is removed from the 2nd array list.
			 * It is re-added if all people are removed.  This is for the purpose of avoiding making critical changes to or
			 * deleting a cabin that has people assigned to it.
			 */
			//
		String message= "Are you sure you want to delete " +deleteCabin ;
		
		int answer= JOptionPane.showConfirmDialog(frame, message);
		
		if(answer == JOptionPane.YES_OPTION){
		
		
		
		NewCabin.cabinList.remove(deleteCabin);
		NewCabin.cabinList2.remove(deleteCabin);
		cabinsModel.removeAllElements();
		initCabinsModel();
		}
		else{
			
		}}
		else{
			cabinModifyError();
		}}
	else{
		return;
	}
	}
	private void editGender(){
		
		Cabin cabin1=(((Cabin) cabinJList.getSelectedValue()));
                         if(cabin1!=null){	
		if(NewCabin.cabinList2.contains(cabin1)){

			try{
			
			String response= JOptionPane.showInputDialog(null, "Enter M,F,N", cabin1.getCabinGender());
		
		if(response.equalsIgnoreCase("M")||response.equalsIgnoreCase("F")||response.equalsIgnoreCase("N")){
		cabin1.setGender(response.toUpperCase().charAt(0));
                                      cabin1.setValuesChanged(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "Please enter a valid gender(M,F,N).");
			editGender();
		}
	        cabinsModel.removeAllElements();
	    	initCabinsModel();}
			catch(Exception e){
				return;
			}
	    	}
		else{
			cabinModifyError();
			return;
		}}
else{
	return;
}
		
	}
	private void editCamperCapacity(){
		Cabin cabin1=(((Cabin) cabinJList.getSelectedValue()));
		
		if(cabin1!=null){
			String response= JOptionPane.showInputDialog(null, "Enter a number 0-30.", cabin1.getCapacity());
			
			Integer cap = cabin1.checkNumber(response, cabin1, cabin1.getCapacity());
			
			 if((cap!=null)&&(cap>0)&&(cap<30)&&(cap!=cabin1.getCapacity())){
				cabin1.setCapacity(cap);
				JOptionPane.showMessageDialog(null, "The capcity for "+cabin1+" is now "+cabin1.getCapacity()+ " campers.");
				 cabinsModel.removeAllElements();
			    	initCabinsModel();
                                                                            cabin1.setValuesChanged(true);
				
	          }
			 else if(cap==null){
				 if(cap==JOptionPane.CANCEL_OPTION){
					 return;
				 }
				
				 editCamperCapacity();
			 }
			 else if(cap==cabin1.getCapacity()){
				 return;
			 }
			
			
		     else{
			JOptionPane.showMessageDialog(null, "The maximum capacity for a cabin is 30 campers.  Please enter a valid number");
			editCamperCapacity();
		}}
		else{
			return;
		}
			 
		}
		
		
	
	private void editAgeMin(){
        Cabin cabin1=(((Cabin) cabinJList.getSelectedValue()));
		
        if(cabin1!=null){
		
           String response= JOptionPane.showInputDialog(null, "Enter a number 0-19.",cabin1.getAgeMin());
		   Integer min = cabin1.checkNumber(response, cabin1, cabin1.getAgeMin());
		         try{
		   if((min!=null)&&(min>=0)&&(min<=19)&&(min!=cabin1.getAgeMin())){
			   if(min<=cabin1.getAgeMax()){
			   cabin1.setAgeMin(min);
			   JOptionPane.showMessageDialog(null, "The minimum age for "+cabin1+" is now "+cabin1.getAgeMin()+ " years old.");
			   System.out.println(min);
			   cabinsModel.removeAllElements();
		    	   initCabinsModel();}
                                                            cabin1.setValuesChanged(true);
		         else{
		        	 JOptionPane.showMessageDialog(null, min+ " is higher than the maximum age of "+cabin1.getAgeMax());
		        	 editAgeMin();
		         }
		        }
		  //
		   
		   
		   
		   else if(min==cabin1.getAgeMin()){
			   return;
		   }
		   else if(min==null){
			   if(min==JOptionPane.CANCEL_OPTION){
				   return;
			   }
			   editAgeMin();
		   }
		 
		    else{
		    	JOptionPane.showMessageDialog(null, "The maximum age you can set for a cabin is 19, but you can still add campers outside the age range.");
		    }}
		         catch(Exception e){
		        	 return;
		         }}
        else{
        	return;
        }
			   
		   }
	
	private void editAgeMax(){
        Cabin cabin1=(((Cabin) cabinJList.getSelectedValue()));
		
		if(cabin1!=null){
           String response= JOptionPane.showInputDialog(null, "Enter a number 0-19.", cabin1.getAgeMax());
		   Integer max = cabin1.checkNumber(response, cabin1, cabin1.getAgeMax());
		   try{
		   if((max!=null)&&(max>=0)&&(max<=19)&&(max!=cabin1.getAgeMax())){
			   if(max>=cabin1.getAgeMin()){
			   cabin1.setAgeMax(max);
			   JOptionPane.showMessageDialog(null, "The maximum age for "+cabin1+" is now "+cabin1.getAgeMax()+ " years old.");
			   cabinsModel.removeAllElements();
                                                              cabin1.setValuesChanged(true);
		    	initCabinsModel();}
		         else{
		        	 JOptionPane.showMessageDialog(null, max+ " is lower than the maximum age of "+cabin1.getAgeMin());
		        	 editAgeMax();
		        	 
		         }
		        }
		   else if(max==null){
			   if(max==JOptionPane.CANCEL_OPTION){
				   return;
			   }
			   editAgeMax();
		   }
		   else if(max==cabin1.getAgeMax()){
			   return;
		   }
		       
		    else{
		    	JOptionPane.showMessageDialog(null, "The maximum age you can set for a cabin is 19, but you can still add campers outside the age range.");
		    }}
		   catch(Exception e){
			   return;
		   }}
		else{
			return;
		}
			   
		   }
	
	 private void editNumberOfCounselors(){
		 Cabin cabin1=(((Cabin) cabinJList.getSelectedValue()));
		if(cabin1!=null){ 	
			
         String response= JOptionPane.showInputDialog(null, "Enter a number 0-20.",cabin1.getNumberOfCounselors());
		   Integer cap = cabin1.checkNumber(response, cabin1, cabin1.getNumberOfCounselors());
		   try{
		   if((cap!=null)&&(cap>=0)&&(cap<=20)&&(cap!=cabin1.getNumberOfCounselors())){
			   cabin1.setNumCounselors(cap);
			   JOptionPane.showMessageDialog(null, "The number of counselors for "+cabin1+" is now "+cabin1.getNumberOfCounselors());
			   cabinsModel.removeAllElements();
                                                              cabin1.setValuesChanged(true);
		    	initCabinsModel();
		   }
		   else if(cap==null){
			   if(cap==JOptionPane.CANCEL_OPTION){
				   return;
			   }
			   editNumberOfCounselors();
                                                           
		   }
		   else if(cap==cabin1.getNumberOfCounselors()){
			   return;
		   }
		   else{
			   JOptionPane.showMessageDialog(null, "You can only set the counselors up to 20, but you may still add as many as you want with warning prompt"
			   		+ ".  This feature is only to verify the minimum counselors set to a cabin.");
		   }}
		   //Some camps may wish to add a cabin with only counselors to serve as a volunteer cabin. 
		   catch(Exception e){
			   return;
		   }}
		else{
			return;
		}
		
	 }
		
			
		
	
	
	
	private void cabinModifyError(){
//Certain features cannot be modified to cabins with campers and counselors already assigned.  
//Ex. If a cabin is changed to a female cabin from a male cabin with people assigned, the only people who can 
//possibly be assigned to it are males, which creates a problem. 
		Cabin cabin1=(((Cabin) cabinJList.getSelectedValue()));
		if(cabin1!=null){
		JOptionPane.showMessageDialog(null, "All campers and counselors must be removed from this cabin before performing this task.");}
		else{
			return;
		}
	}
	
	private void addListeners(){
		btnEditName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editCabinName();
				}});
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteCabin();
			
			}
		});
		btnEditGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editGender();
			
			}
		});
		btnCamperCapacity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editCamperCapacity();
			}
		});
		btnAgeMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editAgeMin();
			}
		});
		btnAgeMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editAgeMax();
			}
		});
		btnCounselors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editNumberOfCounselors();
			}
		});
                                      addMouseListener(new MouseAdapter() { 
                                            public void mousePressed(MouseEvent me) { 
                                                               Home.fileChanged=true;
                                             } 
                                                }); 
	}
}
