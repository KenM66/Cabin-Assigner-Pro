/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.Collections;
import java.util.Comparator;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditDeleteCounselor extends JPanel{
	
	private JScrollPane counselorPane;
	private JList counselorJList;
	private DefaultListModel counselorsModel;
	private JButton editFirstNameButton;
	private JButton deleteButton;
	private boolean start;
	private JButton editLastNameButton;
	
	private JButton editGenderButton;
	private JButton editRequestsButton;
	
	
	EditDeleteCounselor(){
		
		
		setBorder(new EmptyBorder(20,60,20,60));
		
		  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		  
		  JLabel selectCounselor= new JLabel("Select Counselor");
		  
		  selectCounselor.setFont(new Font("Tahoma", Font.BOLD, 30));
		  selectCounselor.setAlignmentX(0.5f);
		  add(selectCounselor);
		  
		  add(Box.createVerticalStrut(30));
		  
		  counselorsModel= new DefaultListModel();
		  counselorJList= new JList(counselorsModel);
                                        counselorJList.setFont(new Font("Tahoma", Font.BOLD, 14));
		 
		  
		  counselorPane= new JScrollPane();
		  counselorPane.setAlignmentX(0.5f);
		  
		  counselorPane.setViewportView(counselorJList);
		  add(counselorPane);
		  
		  add(Box.createVerticalStrut(20));
		  
		  deleteButton= new JButton("DELETE");
		  
		
		  deleteButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		  deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		  add(deleteButton);
		  
		  add(Box.createVerticalStrut(10));
		  
		  editFirstNameButton= new JButton("EDIT FIRST NAME");
		 
		  
		  editFirstNameButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		  editFirstNameButton.setAlignmentX(0.5f);
		  add(editFirstNameButton);
		  add(Box.createVerticalStrut(10));
		  
		
		  
		  editLastNameButton= new JButton("EDIT LAST NAME");
		 
		  editLastNameButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		  editLastNameButton.setAlignmentX(0.5f);
		  add(editLastNameButton);
		  add(Box.createVerticalStrut(10));
		  
		
		  
		  editGenderButton= new JButton("EDIT GENDER");
		 
		 
		 
		  editGenderButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		  editGenderButton.setAlignmentX(0.5f);
		  add(editGenderButton);
		
		  add(Box.createVerticalStrut(10));
		  
		  editRequestsButton= new JButton("ADD/EDIT CABIN REQUESTS");
		 
		  editRequestsButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		  editRequestsButton.setAlignmentX(0.5f);
		  add(editRequestsButton);
		  
		  if(Home.colorful==true){
			  setBackground(new Color(255, 0, 0));
			  selectCounselor.setBackground(new Color(192, 192, 192));
			  selectCounselor.setForeground(new Color(75, 0, 130));
			  deleteButton.setBackground(Color.YELLOW);
			  editLastNameButton.setBackground(Color.YELLOW);
			  editGenderButton.setBackground(Color.YELLOW);
			  editRequestsButton.setBackground(Color.YELLOW);
			  editFirstNameButton.setBackground(Color.YELLOW);
			  counselorJList.setForeground(new Color(255, 255, 255));
			  counselorJList.setBackground(new Color(128, 0, 128));
		  }
		  
		  
		  
		  start=true;
		  
		  initCounselorsModel();
		 
		 addListeners();
		  
		  
		  
		  
		  
	}
	
	public static void showEditCampers(){
		 JFrame frame = new JFrame("MODIFY COUNSELORS");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.getContentPane().add(new EditDeleteCounselor());
	        frame.pack();
	        frame.setLocationByPlatform( true );
	        frame.setLocationRelativeTo(null);
	     
	        frame.setVisible( true );
	}
	
	//public static void main(String []args){
		//showEditCampers();
		
//	}
	
	private void initCounselorsModel(){
Collections.sort(NewCounselor.counselorList, new Comparator<Counselor>(){
			
			public int compare(Counselor c1, Counselor c2){
				String lastName1= c1.getLastName();
				String lastName2= c2.getLastName();
				
				int result=lastName1.compareToIgnoreCase(lastName2);
				if(result!=0){
					return result;
				}
				String firstName1= c1.getFirstName();
				String firstName2=c2.getFirstName();
				
				return firstName1.compareToIgnoreCase(firstName2);
			}
			});
		for (Counselor s: NewCounselor.counselorList){
			
			
			
			counselorsModel.addElement(s);
			if(start==true){
				setIndex(0);
			}
			
			
		}
	}
	private void setIndex(int index){
		counselorJList.setSelectedIndex(index);
	}
	
	private void editFirstName(Counselor counselor){
        int index= counselorJList.getSelectedIndex();
		String message= "Enter new first name";
		if(counselorJList.getSelectedValue()!=null){
			String name= JOptionPane.showInputDialog(null, message, counselor.getFirstName());
			if(name!=null){
			counselor.setFirstName(name);
			JOptionPane.showMessageDialog(null,"The counselor's first name is now "+name);
			start=false;
			counselorsModel.removeAllElements();
			initCounselorsModel();
			setIndex(index);}
			else{
				return;
			}
		
		
		}
		else{
			return;
		}
	
		
	}
	private void editLastName(Counselor counselor){
        int index= counselorJList.getSelectedIndex();
		String message= "Enter new last name";
		if(counselorJList.getSelectedValue()!=null){
			String name= JOptionPane.showInputDialog(null,message,counselor.getLastName());
			if(name!=null){
			counselor.setLastName(name);
			JOptionPane.showMessageDialog(null,"The counselor's last name is now "+name);
			start=false;
			counselorsModel.removeAllElements();
			initCounselorsModel();
			setIndex(index);}
			else{
				return;
			}
		
		
		}
		else{
			return;
		}
	
		
	}
	private void editGender(Counselor counselor	){
		 int index= counselorJList.getSelectedIndex();
       
		if(NewCounselor.counselorList2.contains(counselor)){
			try{
			String response= JOptionPane.showInputDialog(null, "Enter M,F,O", counselor.getGender());
			
		if((response.equalsIgnoreCase("M")||response.equalsIgnoreCase("F")||response.equalsIgnoreCase("O"))){
			
		counselor.setGender(response.toUpperCase().charAt(0));
		
		start=false;
		counselorsModel.removeAllElements();
		initCounselorsModel();
		setIndex(index);}
		
		
		else{
			counselor.setGender(counselor.getGender());
			JOptionPane.showMessageDialog(null, "Please enter M,F,or O");
			
			editGender(counselor);
		}
			}
			catch(Exception e){
				return;
			}
		}
	
		else{
			JOptionPane.showMessageDialog(null, "You cannot edit the gender of a counselor currently assigned to a cabin.");
			return;
		}
		
		
	}
	private void deleteCounselor(Counselor counselor){
		int index= counselorJList.getSelectedIndex();
		
		if(counselorJList.getSelectedValue()!=null){
		
		if(NewCounselor.counselorList2.contains(counselor)){
			
			String message= "Are you sure you want to delete "+counselor+" ?";
		
			int response= JOptionPane.showConfirmDialog(null, message);
		    
			
			if(response==JOptionPane.YES_OPTION){
		
				NewCounselor.counselorList.remove(counselor);
				NewCounselor.counselorList2.remove(counselor);
		start=false;
		counselorsModel.removeAllElements();
		initCounselorsModel();
		setIndex(index);}
		
		else{
			return;
		}}
		
		else{
			JOptionPane.showMessageDialog(null, "You may not delete a counselor currently assigned to a cabin!");
			return;
		}}
		
	}
	
	private void addRequests(Counselor counselor){
		if(counselorJList.getSelectedValue()!=null){
		int index= counselorJList.getSelectedIndex();
		String message= "Enter the cabin requests for this counselor.";
		String response=JOptionPane.showInputDialog(message, counselor.getRequest());
		if(response==null){
			counselor.setRequest(counselor.getRequest());
			return;
		}
		counselor.setRequest(response);
		setIndex(index);
		
		}
		else{
			return;
		}
	}
	
	private void addListeners(){
		deleteButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		deleteCounselor((Counselor)counselorJList.getSelectedValue());
		  	}
		  });
		editFirstNameButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			  	editFirstName((Counselor)counselorJList.getSelectedValue());
			  	}
			  });
		editLastNameButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
			  	editLastName((Counselor)counselorJList.getSelectedValue());
			  	}
			  });
		 editGenderButton.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		editGender((Counselor)counselorJList.getSelectedValue());
			  	}
			  });
		 editRequestsButton.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent arg0) {
			  		addRequests((Counselor)counselorJList.getSelectedValue());
			  	}
			  });
	}
}
