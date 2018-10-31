/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;

import java.awt.*;
import java.awt.event.*;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.Serializable;
import java.text.MessageFormat;
import java.text.ParseException;


public class AssignToCabin extends JPanel implements Serializable {
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6688228883706196608L;
	static Map<Cabin, Set<Camper>> cabinMap= new HashMap<Cabin, Set<Camper>>();
	static Map<Cabin, Set<Counselor>> cabinCounselorMap= new HashMap<Cabin, Set<Counselor>>();

	
	private static DefaultListModel campersModel= new DefaultListModel<Camper>();
	private static DefaultListModel counselorsModel= new DefaultListModel<Counselor>();
	public final JComboBox comboBox= new JComboBox();
	
  
    private JList camperJList;
    private JList camperAddedJList;
    private JList counselorJList;
    private JList counselorAddedJList;
    
    JButton selectCabinButton;
    JButton buttonClose;
    JButton buttonAddCamper;
    JButton buttonRemoveCamper;
    JButton buttonAddCounselor;
    JButton buttonRemoveCounselor;
    JButton buttonPrintCabinList;
    JButton buttonPrintMedicalReport;
    
    JScrollPane scrollPaneCampers;
    JScrollPane scrollPaneCounselors;
    JScrollPane counselorsAssignedScrollPane;
    JScrollPane campersAssignedScrollPane;
    
    JPanel listPanels;
    JPanel assignedListPanels;
    
    JTextPane medicalReport;
    
    static JFrame frame;
    
    Cabin currentCabin= new Cabin(); 
    private JButton btnAutoAssign;
    private JButton btnClear;
    
      boolean added;
  
    
  
	public AssignToCabin() {
		
		
		ArrayList<JButton> buttonsList= new ArrayList<JButton>();
		ArrayList<JButton> addRemoveButtonsList= new ArrayList<JButton>();
		
		
		setBorder( new EmptyBorder(20, 40, 20, 40) );
		 
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel selectCabin= new JLabel("Select Cabin");
        selectCabin.setForeground(Color.BLUE);
        selectCabin.setFont(new Font("Tahoma", Font.BOLD, 16));
        selectCabin.setAlignmentX(0.5f);
        add(selectCabin);
    
        comboBox.setFont(new Font("Tahoma",Font.BOLD, 13));
        
       
        add(comboBox);
        add(Box.createVerticalStrut(10));
      
        
        selectCabinButton = new JButton("SELECT");
       
        selectCabinButton.setFont(new Font("Tahoma", Font.BOLD, 13));
       
        selectCabinButton.setAlignmentX(0.5f);
        add(selectCabinButton);
        buttonsList.add(selectCabinButton);
       
        add(Box.createVerticalGlue());
        
        JPanel sidewaysPanel= new JPanel();
      
        sidewaysPanel.setLayout(new BoxLayout(sidewaysPanel, BoxLayout.X_AXIS));
        
        add(sidewaysPanel);
        
        
        listPanels = new JPanel();
       
       
        
        
        
       
        
        sidewaysPanel.add(listPanels);
      
        
        GridBagLayout gblPanel= new GridBagLayout();
        listPanels.setLayout(gblPanel);
    
        
       
        camperJList= new JList(campersModel);
        counselorJList= new JList(counselorsModel);
        
        counselorJList.setFont(  new Font("Tahoma", Font.BOLD, 13));
        camperJList.setFont(  new Font("Tahoma", Font.BOLD, 13));
       
        scrollPaneCounselors= new JScrollPane();
        scrollPaneCampers= new JScrollPane();
        GridBagConstraints constraints= new GridBagConstraints();
        GridBagConstraints c= new GridBagConstraints();
        GridBagConstraints c1= new GridBagConstraints();
        GridBagConstraints c2= new GridBagConstraints();
        
       
        
       
        camperAddedJList= new JList(getModelForCabin((Cabin)comboBox.getSelectedItem()));
       
        c.insets= new Insets(0, -130, 5, 0);
        c.ipadx= 100;
        c.gridx= 0;
        c.gridy= 0;
        
        
        JLabel labelCounselorsUnassigned= new JLabel("Counselors");
        labelCounselorsUnassigned.setForeground(Color.BLUE);
        labelCounselorsUnassigned.setFont(new Font("Tahoma", Font.BOLD, 13));
        listPanels.add(labelCounselorsUnassigned, c);
        
        c1.insets= new Insets(5, 0, 5, 0);
        c1.gridx= 0;
        c1.gridy= 1;
        c1.ipadx= 200;
        c1.ipady= 120;
        
       
        listPanels.add(scrollPaneCounselors, c1);
        scrollPaneCounselors.setViewportView(counselorJList);
        
        scrollPaneCounselors.setPreferredSize(new Dimension(0, 0));
        
        
        JLabel labelCampersUnassigned= new JLabel("Campers");
        labelCampersUnassigned.setForeground(Color.BLUE);
        labelCampersUnassigned.setFont(new Font("Tahoma", Font.BOLD, 13));
        c2.insets= new Insets(40, -140, 5, 0);
        c2.gridx= 0;
        c2.gridy= 2;
        
        listPanels.add(labelCampersUnassigned, c2);
        
        constraints.insets= new Insets(5, 0, 5, 0);
      
        constraints.gridx= 0;
        constraints.gridy= 3;
        constraints.ipadx= 200;
        constraints.ipady= 175;
    
        

        scrollPaneCampers.setViewportView(camperJList);
        scrollPaneCampers.setPreferredSize(new Dimension(0,0));
        
        listPanels.add(scrollPaneCampers, constraints);
       
        
       
        sidewaysPanel.add(Box.createHorizontalStrut(20));
      
       
       JPanel addRemoveButtonsPanel= new JPanel(new GridLayout(12,0));
     
      
      
        
        sidewaysPanel.add(addRemoveButtonsPanel);
        JLabel label2= new JLabel();
        JLabel label3= new JLabel();
        JLabel label4= new JLabel();
        JLabel label5= new JLabel();
        JLabel label6= new JLabel();
        JLabel label7= new JLabel();
        JLabel label8= new JLabel();
        addRemoveButtonsPanel.add(label2);
        
        buttonAddCounselor= new JButton("->");
        
        
        buttonAddCounselor.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        addRemoveButtonsList.add(buttonAddCounselor);
        
        addRemoveButtonsPanel.add(buttonAddCounselor);
        
      
        
        
        JLabel label1=  new JLabel();
        //  JLabel label9= new JLabel();
          
          
          
          addRemoveButtonsPanel.add(label1);
        buttonRemoveCounselor= new JButton("<-");
        
        buttonRemoveCounselor.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        addRemoveButtonsList.add(buttonRemoveCounselor);
        
          addRemoveButtonsPanel.add(buttonRemoveCounselor);
        
        addRemoveButtonsPanel.add(label3);
       
       
        addRemoveButtonsPanel.add(label4);
        
        addRemoveButtonsPanel.add(label6);
        
          
          buttonAddCamper= new JButton("->");
          
          buttonAddCamper.setFont(new Font("Tahoma", Font.BOLD, 20));
          addRemoveButtonsPanel.add(buttonAddCamper);
        addRemoveButtonsPanel.add(label5);
        addRemoveButtonsList.add(buttonAddCamper);
          
          
          buttonRemoveCamper= new JButton("<-");
          addRemoveButtonsPanel.add(buttonRemoveCamper);
          
          buttonRemoveCamper.setFont(new Font("Tahoma", Font.BOLD, 20));
          addRemoveButtonsList.add(buttonRemoveCamper);
          
          addRemoveButtonsPanel.add(label7);
          addRemoveButtonsPanel.add(label8);
          //addRemoveButtonsPanel.add(label9);
          //addRemoveButtonsPanel.add(label7);
          
          
        
        sidewaysPanel.add(Box.createHorizontalStrut(20));
        
        assignedListPanels= new JPanel();
        GridBagLayout gbl2= new GridBagLayout();
        
        assignedListPanels.setLayout(gbl2);
        
        
        sidewaysPanel.add(assignedListPanels);
        
        GridBagConstraints c3= new GridBagConstraints();
        GridBagConstraints c4= new GridBagConstraints();
        GridBagConstraints c5= new GridBagConstraints();
        GridBagConstraints c6= new GridBagConstraints();
        
        JLabel labelCounselorsAssigned= new JLabel("Assigned Counselors");
        labelCounselorsAssigned.setForeground(Color.BLUE);
        labelCounselorsAssigned.setFont(new Font("Tahoma", Font.BOLD, 13));
        c3.insets= new Insets(0, -65, 5, 0);
        c3.gridx= 0;
        c3.gridy= 0;
        
        assignedListPanels.add(labelCounselorsAssigned, c3);
        
        counselorsAssignedScrollPane= new JScrollPane();
        
        c4.insets= new Insets(5, 0, 5, 0);
        c4.gridx= 0;
        c4.gridy= 1;
        c4.ipadx= 200;
        c4.ipady= 120;   
       
        counselorAddedJList= new JList(getModelForCabinCounselors((Cabin)comboBox.getSelectedItem()));
        counselorsAssignedScrollPane.setViewportView(counselorAddedJList);
        counselorsAssignedScrollPane.setPreferredSize(new Dimension(0,0));
       
            counselorAddedJList.setFont(  new Font("Tahoma", Font.BOLD, 13));
        camperAddedJList.setFont(  new Font("Tahoma", Font.BOLD, 13));
        
        assignedListPanels.add(counselorsAssignedScrollPane, c4);
        
        JLabel labelCampersAssigned= new JLabel("Assigned Campers");
        labelCampersAssigned.setForeground(Color.BLUE);
        labelCampersAssigned.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        c5.insets= new Insets(40, -80, 5, 0);
        c5.gridx= 0;
        c5.gridy= 2;
        
        assignedListPanels.add(labelCampersAssigned, c5);
        
         campersAssignedScrollPane= new JScrollPane();
        
        c6.insets= new Insets(5, 0, 5, 0);
        c6.gridx= 0;
        c6.gridy= 3;
        c6.ipadx= 200;
        c6.ipady= 175;
        
        campersAssignedScrollPane.setViewportView(camperAddedJList);
        campersAssignedScrollPane.setPreferredSize(new Dimension(0,0));
        assignedListPanels.add(campersAssignedScrollPane, c6);
        
        
        buttonPrintCabinList= new JButton("VIEW/PRINT CABIN LIST");
       
        buttonPrintCabinList.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        buttonPrintCabinList.setAlignmentX(0.5f);
        add(buttonPrintCabinList);
        add(Box.createVerticalStrut(10));
        buttonPrintMedicalReport= new JButton("VIEW/PRINT MEDICAL REPORT");
      
        buttonPrintMedicalReport.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        buttonPrintMedicalReport.setAlignmentX(0.5f);
        add(buttonPrintMedicalReport);
        
        
        
        
        add(Box.createVerticalStrut(10));
        buttonClose= new JButton("CLOSE");
        buttonClose.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        buttonClose.setAlignmentX(0.5f);
        
        add(buttonClose);
        
        buttonsList.add(buttonPrintCabinList);
        buttonsList.add(buttonPrintMedicalReport);
        buttonsList.add(buttonClose);
       
        
        btnAutoAssign = new JButton("AUTO ASSIGN");
        btnAutoAssign.setToolTipText("This will assign all campers to capacity in age order from the starting selected index.  This is not a good feature to use for gender neutral cabins. ");
       
      
        btnAutoAssign.setFont(new Font("Tahoma", Font.BOLD, 13));
       
        GridBagConstraints gbc_btnAutoAssign = new GridBagConstraints();
        gbc_btnAutoAssign.gridx = 0;
        gbc_btnAutoAssign.gridy = 4;
        listPanels.add(btnAutoAssign, gbc_btnAutoAssign);
        
        addRemoveButtonsList.add(btnAutoAssign);
        
        btnClear = new JButton("CLEAR ");
        
        
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
      
        GridBagConstraints gbc_btnClear = new GridBagConstraints();
        gbc_btnClear.gridx = 0;
        gbc_btnClear.gridy = 4;
        assignedListPanels.add(btnClear, gbc_btnClear);
       addRemoveButtonsList.add(btnClear);
        
        if(Home.colorful==true){
        	for(JButton button: addRemoveButtonsList){
        	 button.setForeground(Color.BLUE);
        	button.setBackground(Color.ORANGE);}
        	setBackground(new Color(144, 238, 144));
        	 comboBox.setBackground(Color.CYAN);
        	 listPanels.setBackground(new Color(144, 238, 144));
        	 camperJList.setBackground(Color.CYAN);
             camperAddedJList.setBackground(Color.CYAN);
             counselorJList.setBackground(Color.CYAN);
             counselorAddedJList.setBackground(Color.CYAN);
             assignedListPanels.setBackground(new Color(144, 238, 144));
             addRemoveButtonsPanel.setBackground(new Color(144, 238, 144));
             sidewaysPanel.setBackground(new Color(144, 238, 144));
             for(JButton button: buttonsList){
            	 button.setBackground(new Color(0, 0, 255));
                 button.setForeground(new Color(255, 255, 255));
             }
        }
        
        
        
       
        //Remove below methods to be able to run window by itself with no functions. 
        
        openWindow();
        addListeners();
        selectAndUnselect();
        initCabinsBox();
       
       
       
      
       
       
        
      
        		
       
      
        
		
		}
	
	public static  void showCabinAssignments()
    {
         frame = new JFrame("Assign Cabins");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new AssignToCabin());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setLocationRelativeTo(null);
        
      
       frame.setVisible( true );
       frame.setResizable(false);
    }
		
	
		
		
	
	
	 DefaultListModel getModelForCabin(Cabin cabin) {
/*
 * A new default list model will be needed for each cabin, so this method returns a default list model. 
 */
		 ArrayList<Camper> listAdded= new ArrayList<Camper>(getOrCreateGroup(cabin));
	     DefaultListModel<Camper> dfm= new DefaultListModel<>();
			
		   Collections.sort(listAdded, new Comparator<Camper>(){
		    	public int compare(Camper c1, Camper c2){
		    		
		    		String lastName1= c1.getLastName();
		    		String lastName2= c2.getLastName();
		    		
		    		int result= lastName1.compareToIgnoreCase(lastName2);
		    		if(result!=0){
		    			return result;
		    		}
		    		String firstName1= c1.getFirstName();
		    		String firstName2= c2.getFirstName();
		    		
		    		return firstName1.compareToIgnoreCase(firstName2);
		    	}
		    });
		        for(Camper c: listAdded){
	        	if(!dfm.contains(c)){
	        		dfm.addElement(c);
	        	}
	        	}
	       return dfm;
	    }
	 
	 DefaultListModel getModelForCabinCounselors(Cabin cabin){
//Method functions the same as the above one, but for counselors. 
		ArrayList<Counselor> counselorListAdded= new ArrayList<Counselor>(getOrCreateCounselorGroup(cabin));
		DefaultListModel<Counselor> dfm= new DefaultListModel<>();
		
		Collections.sort(counselorListAdded, new Comparator<Counselor>(){
			
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
			for(Counselor c: counselorListAdded){
				if(!dfm.contains(c)){
					dfm.addElement(c);
				}
				}
		 return dfm;
	 }
	 
	 //

		public  Set<Camper> getOrCreateGroup(Cabin cabin){
			
			return cabinMap.computeIfAbsent(cabin, unused -> new HashSet<>());
	//A map is created for the cabin as the key and the campers in a hash set as the value.  
			}
		public Set<Counselor> getOrCreateCounselorGroup(Cabin cabin){
			return cabinCounselorMap.computeIfAbsent(cabin, unused -> new HashSet<>());
//Same method as above, but with counselors. 
		}
		
		
		public void initCampersModel(Cabin cabin){
			Collections.sort( NewCamper.camperList2 , new Comparator<Camper>(){
			   public int compare(Camper c1, Camper c2){
					LocalDate a= c1.dateOfBirth;
					LocalDate b= c2.dateOfBirth;
//The campers model is organized from age ascending based on birth date.  This allows for assigning in order easily and for an
// auto assign feature to fill a cabin to capacity based on age. 
                    return b.compareTo(a);
			}
			});
					for(Camper camper: NewCamper.camperList2){
						if((!campersModel.contains(camper)) &&(camper.getGender()==cabin.getCabinGender())||(camper.getGender()=='O')){
						campersModel.addElement(camper);
	
							}
						else if((!campersModel.contains(camper))&&(cabin.getCabinGender()=='N')){
							campersModel.addElement(camper);
						}}}	
//A camper must either match the gender of the cabin, or not have had a gender added to the camper object when created, defaulted to 'other'.
// If a cabin is gender neutral, all campers will appear on the JList of unassigned campers. 
// The cabin will be removed from the 2nd ArrayList once there is at least 1 camper or counselor in it, so that it cannot be deleted and cabin gender cannot be changed until occupants are removed. 
			
          public void addCamper(Cabin cabin, Camper camper) throws ParseException{
          int age= camper.calculateAge(camper.dateOfBirth, CampInformation.dateOfCamp);
          int min= cabin.getAgeMin();
          int max= cabin.getAgeMax();
          added=true;   //Only relevant with auto-assign
			
          cabinMap.remove(null); //Removes null key from map
				//NewCabin.cabinList2.remove(cabin);
				//Remove cabin from the 2nd list to not allow user to delete occupied cabins.
			
		      if(getModelForCabin(cabin).getSize()>=cabin.getCapacity()){
				JOptionPane.showMessageDialog(null, "You have reached the maximum number of campers in this cabin.  The "
						+ "occupancy maximum for this cabin is "+cabin.getCapacity()+" campers."
								+ "  Either remove campers from this cabin, or edit the capacity.");
				         return;
				  }
			     else{
				
				
				
				if((age<min)||(age>max)){
					int response= JOptionPane.showConfirmDialog(null, "The selected camper"
							+ " is outside of the age range of "+min+ " to "+max+ " ."
									+ " Are you sure you want to put "+camper.getFirstName()+ " "+camper.getLastName()+
									" in this cabin?");
					
					if(response==JOptionPane.NO_OPTION){
                                                                                                                   added=false;
                      //In this method, the added feature is only relevant when using the auto-assign feature.  If the user opts not to assign a camper that is flagged, the auto-assign automatically terminates. 
						return;
					}}
                                                                                             
                                            
                                                                                                    if((camper.getSpecialRequest()==null)||(camper.getSpecialRequest().length()==0)){
                                                                                                              
                                                                                                                    getModelForCabin(cabin).addElement(camper);
					                    getOrCreateGroup(cabin).add(camper);
						campersModel.removeElement(camper);
						NewCamper.camperList2.remove(camper);
						camperAddedJList.setModel(getModelForCabin((cabin)));
						camperAddedJList.validate();
                                                                                                                   NewCabin.cabinList2.remove(cabin);
								
							}
                                                                                                    else if(camper.getSpecialRequest().length()>=1 ){
					                         int option= JOptionPane.showConfirmDialog(null, "The camper "+camper.getFirstName()+" "+camper.getLastName()+ " "
                                                                                                                         + "has the following cabin assignment requests:\n\n"
						        + camper.getSpecialRequest()+"\n\nDo you still wish to assign the camper to this cabin?");
							if(option==JOptionPane.YES_OPTION){
                                                                                                                                     getModelForCabin(cabin).addElement(camper);
					    getOrCreateGroup(cabin).add(camper);
						campersModel.removeElement(camper);
						NewCamper.camperList2.remove(camper);
						camperAddedJList.setModel(getModelForCabin((cabin)));
						camperAddedJList.validate();
                                                                                                                   NewCabin.cabinList2.remove(cabin);
							                                                            }
                                                                                                                                       else{
                                                                                                                                                added=false;
                                                                                                                                                return;
                                                                                                                                              }
                                                                                                                                           }
					
				                                                                  else{
                                                                                                                                               getModelForCabin(cabin).addElement(camper);
					                                               getOrCreateGroup(cabin).add(camper);
						                           campersModel.removeElement(camper);
						                           NewCamper.camperList2.remove(camper);
						                           camperAddedJList.setModel(getModelForCabin((cabin)));
						                           camperAddedJList.validate();
                                                                                                                                               NewCabin.cabinList2.remove(cabin);
                                    
                                                                                                                                             }
                                                                                                          
                                                                  }
                                                               
                                                                                                                            }
		public void delete(Cabin cabin, Camper camper){
			
		cabinMap.remove(null);  //removes null key from map
			getOrCreateGroup(cabin).remove(camper);
			getModelForCabin(cabin).removeElement(camper);
			camperAddedJList.setModel(getModelForCabin(cabin));
			campersModel.addElement(camper);
			campersModel.removeAllElements();
			
			NewCamper.camperList2.add(camper);
			initCampersModel(cabin);
			camperAddedJList.validate();
			
			
			}
			
			public int getMapSize(Cabin cabin){
			ArrayList<Camper> mapArray= new ArrayList<Camper>(getOrCreateGroup(cabin));
			
			return mapArray.size();
		}
		
		public void selectCabin(){
			if(comboBox.getSelectedIndex()!=0){
			Cabin selectedCabin= (Cabin)comboBox.getSelectedItem();
			
			
				
			campersModel.removeAllElements();
			counselorsModel.removeAllElements();
			counselorAddedJList.setModel(getModelForCabinCounselors(selectedCabin));
			camperAddedJList.setModel(getModelForCabin(selectedCabin));
			  initCampersModel(selectedCabin);
			  initCounselorsModel(selectedCabin);
			  
			  currentCabin= selectedCabin; }
	
	/*
	 * The above variable is created to avoiding referencing the combo box as the argument when assigning or removing campers.
	 * If a user selects a new cabin, but doesn't hit the select button, it will keep the current cabin as the argument to avoid 
	 * errors with assigning campers to the wrong cabin.
	 */
			
			
			else{
				JOptionPane.showMessageDialog(null, "Please Select a Cabin from the drop-down list.");
				if(currentCabin!=null){
					comboBox.setSelectedItem(currentCabin);
				}
			}
			
		}
		private void moveListSelection(JList list){
	//This and the method below make it so that the selection can only be on one list at a time to avoid errors
	
			if(list.isSelectionEmpty()==false){
				list.clearSelection();
			}
		}
		
		
		
		private void selectionButton(){
	//If there are not enough or too many counselors assigned to cabin, 
	// a message confirm dialog will appear. 
			if(currentCabin== null){
              selectCabin();
				  }
				else if(currentCabin.getNumberOfCounselors()>counselorAddedJList.getModel().getSize()){
					int response= JOptionPane.showConfirmDialog(null, 
					"Not enough counselors are presently assigned to this cabin, are you sure you wish to proceed?"
					+ " If yes, you can still make changes later.","WARNING", JOptionPane.YES_NO_OPTION);
					
					if(response== JOptionPane.YES_OPTION){
						selectCabin();
					}
					else{
						comboBox.setSelectedItem(currentCabin);
					
					
					
					return; }
				}
				else{
					selectCabin();
					}
		}
		
		private void openWindow(){
			//These execute as soon as this part of the application launches. 
			currentCabin= null;
			campersModel.removeAllElements();
			counselorsModel.removeAllElements();
		}
		
		private void addListeners(){
			
			//All action and mouse listeners are nested here. 
			 selectCabinButton.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		selectionButton();
		        	}
		        });
			 
			 buttonClose.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
			if(currentCabin!=null){
				 if(counselorAddedJList.getModel().getSize()>=currentCabin.getNumberOfCounselors()){
	        		
	        	 frame.dispose();}
				 else{
					int response= JOptionPane.showConfirmDialog(null, "There are not currently enough counselors"
							+ " assigned to this cabin?  Are you sure you wish to close?  If so, you can still make changes later.");
					if(response==JOptionPane.YES_OPTION){
						frame.dispose();
					}
					else{
						return;
					}
				 }}
			else{
				frame.dispose();
			}
			
			
			 } });
			 
			 buttonAddCamper.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(camperJList.getSelectedValue()!=null){
				
				Cabin	cabinSelected= (Cabin) comboBox.getSelectedItem();
				Camper camperSelected= (Camper)camperJList.getSelectedValue();
				int currentIndex= camperJList.getSelectedIndex();
				int lastIndex= camperJList.getLastVisibleIndex();
					
				if(camperJList.getSelectedValue()!= null){
			        try {
			        	
						addCamper(cabinSelected, camperSelected);}
			        	
			        	
					 catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					indexSelector(camperJList, currentIndex,lastIndex);
			      
					
						
						}
				else{
					return;}}
				
				}} );
			 
			 buttonRemoveCamper.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if (camperAddedJList.getSelectedValue() !=null){
					Cabin	cabinSelected= (Cabin) comboBox.getSelectedItem();
					Camper camperSelected= (Camper)camperAddedJList.getSelectedValue();
					int currentIndex= camperAddedJList.getSelectedIndex();
					int lastIndex= camperAddedJList.getLastVisibleIndex();
					
				
					
			   if(camperSelected !=null){
					delete(cabinSelected, camperSelected);
					}
			        indexSelector(camperAddedJList, currentIndex, lastIndex);
					
					
					
					int campersSize= camperAddedJList.getModel().getSize();
					int counselorsSize= counselorAddedJList.getModel().getSize();
					
					if((campersSize==0)&&(counselorsSize==0)){
						NewCabin.cabinList2.add(cabinSelected);
					}
					
					
					}
			  
			   
					
					
					
					} });
			 
			 buttonAddCounselor.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		if(counselorJList.getSelectedValue()!=null){
		        		Cabin	cabinSelected= (Cabin) comboBox.getSelectedItem();
						Counselor counselorSelected= (Counselor)counselorJList.getSelectedValue();
						int currentIndex= counselorJList.getSelectedIndex();
						int lastIndex= counselorJList.getLastVisibleIndex();
						
						if((counselorSelected.getRequest()==null)||(counselorSelected.getRequest().length()==0)){
							
						}
						else{
							int option= JOptionPane.showConfirmDialog(null, "This counselor has the following cabin assignment requests:\n\n"
									+ counselorSelected.getRequest()+"\n\nDo you still wish to assign counselor to this cabin?");
							if(option==JOptionPane.YES_OPTION){
								
							}
							else{
								return;
							}
						}
						if(counselorAddedJList.getModel().getSize()>=cabinSelected.getNumberOfCounselors()){
							int option= JOptionPane.showConfirmDialog(null, "This cabin was set up to have "+cabinSelected.getNumberOfCounselors()+
									" counselors.  Are you sure you wish to assign another counselor to this cabin?");
							  if(option==JOptionPane.YES_OPTION){
								  
							  }
							  else{
								  return;
							  }
						}
						
						addCounselor(cabinSelected,counselorSelected );
						indexSelector(counselorJList, currentIndex, lastIndex);
						NewCabin.cabinList2.remove(cabinSelected);
						
						
					
						} 
		        	else{
		        		return;
		        	}}
		        	 });
			 
			 buttonRemoveCounselor.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		
		        		if(counselorAddedJList.getSelectedValue()!=null){
		        			int currentIndex= counselorAddedJList.getSelectedIndex();
		        			int lastIndex= counselorAddedJList.getLastVisibleIndex();
		        		Cabin	cabinSelected= (Cabin) comboBox.getSelectedItem();
						Counselor counselorSelected= (Counselor)counselorAddedJList.getSelectedValue();
						
		        		deleteCounselor(cabinSelected, counselorSelected);
		        		indexSelector(counselorAddedJList, currentIndex, lastIndex);
		        		
		        		if((counselorAddedJList.getModel().getSize()==0)&&(camperAddedJList.getModel().getSize()==0)){
		        			NewCabin.cabinList2.add(cabinSelected);
		        		}
		        		//If both added lists are empty, the cabin is added back to 2nd arrayList to allow cabin editing
		        		
		        	}
		        		else{
		        			return;
		        		}
		        		}}) ;
			 
			  buttonPrintMedicalReport.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		Cabin cabin1= currentCabin;
		        		
		        		
		        	
		        		if(cabin1!=null){
		        			try {
								medicalReport(cabin1);
							} catch (BadLocationException | ParseException e) {
								
								e.printStackTrace();
							}
		        		}
		        		else{
		        			JOptionPane.showMessageDialog(null, "No Cabin Selected!");
		        		}
		        		
		        	}
		        });
			  buttonPrintCabinList.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		
		        		if(currentCabin!=null){
		        			try {
								cabinList(currentCabin);
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        		}
		        		else{
		        			JOptionPane.showMessageDialog(null, "No Cabin Selected!");
		        		}
		        	}
		        });
			  btnAutoAssign.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		if(currentCabin==null){
		        			return;
		        		}
		        		try {
							autoAssign(currentCabin);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        });
			  btnClear.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		clearCabin(currentCabin);
		        	}
		        });
                          
                                                         addMouseListener(new MouseAdapter() { 
                                            public void mousePressed(MouseEvent me) { 
                                                               Home.fileChanged=true;
                                             } 
                                                }); 
			 }
			 
		  private void checkEntriesTest(){ //Use method for testing purposes only
			//Map.Entry<Cabin, Set<Camper>> checkKey= cabinMap.entrySet().iterator().next();
			//System.out.println(checkKey.getKey());
			//System.out.println(checkKey.getValue());
			
			//Map.Entry<Cabin, Set<Counselor>> checkKey2= cabinCounselorMap.entrySet().iterator().next();
			//System.out.println(checkKey2.getKey());
			//System.out.println(checkKey2.getValue());
			
			
			//System.out.println(checkKey2.getValue().toArray());
			
			//System.out.println(a);
			
			//System.out.println(cabinMap);
			//System.out.println(cabinCounselorMap);
		}
		
		private void clearListSelection(JList list1, JList list2){
			list1.addListSelectionListener(new ListSelectionListener() {
		//If a value is selected on the list directly to the left or right, the 
		// selection from the other list is cleared to avoid having a selection on both 
	   // assigned and unassigned lists. 

				@Override
				public void valueChanged(ListSelectionEvent event) {
					if(event.getValueIsAdjusting()==false){
						if(list1.getSelectedValue()!=null){
							list2.clearSelection();
						}}}});
			}
			
		
		private void selectAndUnselect(){
			 clearListSelection(camperJList, camperAddedJList);
		     clearListSelection(camperAddedJList, camperJList);
		     clearListSelection(counselorJList, counselorAddedJList);
		     clearListSelection(counselorAddedJList, counselorJList);
		        
			
		}
		
		private void initCabinsBox(){
			//Male cabins are listed first, then females, and the neutral to keep cabins ordered by gender and then by age. 
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
			
			comboBox.setModel(new DefaultComboBoxModel(NewCabin.cabinList.toArray()));
	        comboBox.insertItemAt("SELECT", 0);
	        comboBox.setSelectedIndex(0);
	        }
		
		private void initCounselorsModel(Cabin cabin){
			Collections.sort(NewCounselor.counselorList2, new Comparator<Counselor>(){
	//List 2 is used so that counselors already assigned are not re-added to the model. 	
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
			for(Counselor counselor: NewCounselor.counselorList2){
				if((!counselorsModel.contains(counselor)) &&(counselor.getGender()==cabin.getCabinGender())||(counselor.getGender()=='O')){
				counselorsModel.addElement(counselor);
					}
				else if((!counselorsModel.contains(counselor))&&(cabin.getCabinGender()=='N')){
					counselorsModel.addElement(counselor);
				}}}
	
		//The add and delete models below have similar functioning as the campers methods. 
		
	    public void addCounselor(Cabin cabin, Counselor counselor){
          cabinCounselorMap.remove(null); //Removes null key from map
			
	
			
			getModelForCabinCounselors(cabin).addElement(counselor);
			    getOrCreateCounselorGroup(cabin).add(counselor);
				counselorsModel.removeElement(counselor);
				NewCounselor.counselorList2.remove(counselor);
				counselorAddedJList.setModel(getModelForCabinCounselors((cabin)));
				counselorAddedJList.validate();
				 checkEntriesTest();
			}
	    	
	    
	    
	    public void deleteCounselor(Cabin cabin, Counselor counselor){
	    	cabinCounselorMap.remove(null);  //removes null key from map
			getOrCreateCounselorGroup(cabin).remove(counselor);
			getModelForCabinCounselors(cabin).removeElement(counselor);
			counselorAddedJList.setModel(getModelForCabinCounselors(cabin));
			counselorsModel.addElement(counselor);
			counselorsModel.removeAllElements();
			
			NewCounselor.counselorList2.add(counselor);
			initCounselorsModel(cabin);
			counselorAddedJList.validate();
			}
	    
	    private void indexSelector(JList list, int index1, int index2){
	    //A method that is created to avoid having to click on a JList again after an action is performed.  
	    //Campers and counselors can be added or removed one by with without having to move the cursor from the arrow button each time. 
			      if((index1>=0)&&(index1<index2)){
						list.setSelectedIndex(index1);
						}
					else if(index1<0){
						return;
					}
					else{
						list.setSelectedIndex(index1-1);
					}
					 }
	    
	    private void medicalReport(Cabin cabin) throws BadLocationException, ParseException{
	    	JFrame frame= new JFrame("Cabin Medical Report");
	    	JPanel panel= new JPanel();
	    	 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    	 frame.getContentPane().add(panel);
	    	
	    	StyleContext context= new StyleContext();
	    	StyleContext context2= new StyleContext();
	    	StyleContext context3= new StyleContext();
	    	StyleContext context4= new StyleContext();
	    	StyleContext context5= new StyleContext();
	    	StyleContext context6= new StyleContext();
	    	StyleContext context7= new StyleContext();
	    	StyleContext context8= new StyleContext();
	    	
	    	StyledDocument document = new DefaultStyledDocument(context);
	    	javax.swing.text.Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style2= context2.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style3= context3.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style4= context4.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style5= context5.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style6= context6.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style7= context7.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style8= context8.getStyle(StyleContext.DEFAULT_STYLE);
	    	
	    	
	    	
	    	
	    	
	    	StyleConstants.setBold(style, true);
	    	StyleConstants.setBold(style2, true);
	    	StyleConstants.setBold(style3, false);
	    	StyleConstants.setBold(style4, false);
	    	StyleConstants.setUnderline(style4, true);
	    	StyleConstants.setFontSize(style, 20);
	    	StyleConstants.setFontSize(style2, 15);
	    	StyleConstants.setFontSize(style3, 15);
	    	StyleConstants.setFontSize(style4, 15);
	    	StyleConstants.setBold(style4, true);
	    	StyleConstants.setBold(style5, true);
	    	StyleConstants.setFontSize(style5, 12);
	    	StyleConstants.setFontSize(style6, 12);
	    	StyleConstants.setBold(style7, true);
	    	StyleConstants.setFontSize(style7, 12);
	    	StyleConstants.setBold(style8, true);
	    	StyleConstants.setFontSize(style8, 12);
	    	
	    	 
	    	 
	    	
	    	
	    	 document.insertString(document.getLength(), "Cabin Medical Report\n\n", style);
	    	 document.insertString(document.getLength(), "Cabin: ", style2);
	    	 document.insertString(document.getLength(), cabin.toString()+"\n\n", style3);
	    	 document.insertString(document.getLength(), "Campers\n\n", style4);
	    	 
	    	 
	    	 
	    	 
	    	 JTextPane textPane= new JTextPane(document);
	    	 JScrollPane scrollPane = new JScrollPane(textPane);
	    	 scrollPane.setPreferredSize(new Dimension(1000,750));
	    	 
	    	 for(int i=0; i<camperAddedJList.getModel().getSize(); i++){
	    		 Camper camper=(Camper) camperAddedJList.getModel().getElementAt(i);
	    		int age= camper.calculateAge(camper.dateOfBirth, CampInformation.dateOfCamp);
	    		String ageString= String.valueOf(age);
	    		char gender= camper.getGender();
	    		
	    		
	    	
	    		
	    		 document.insertString(document.getLength(), "Name: ", style5);
	    		 document.insertString(document.getLength(), camper.getLastName()+", "+camper.getFirstName()+"\n\n", style6);
	    		
	    		 document.insertString(document.getLength(), "Age: ", style5);
	    		 document.insertString(document.getLength(), ageString+"\n\n" , style6);
	    		
	    		 document.insertString(document.getLength(), "Gender: ", style5);
	    		 if(gender=='M'){
	    		 document.insertString(document.getLength(), "Male\n\n",style6);
	    		 }
	    		 else if(gender=='F'){
	    		 document.insertString(document.getLength(), "Female\n\n",style6);
	    		 }
	    		 else{
	    		 document.insertString(document.getLength(), "Other\n\n",style6); 
	    		 }
	    		
	    		 document.insertString(document.getLength(), "Disorders/Medical Conditions: ", style5);
	    		 if((camper.getDisorders()!=null)&&(camper.getDisorders().length()!=0)&&(camper.disordersList.size()==0)){
	    		 document.insertString(document.getLength(), camper.getDisorders()+"\n\n" , style6);
	    		 }
	    		 else if(camper.disordersList.size()>0){
	    			 if((camper.getDisorders()!=null)&&(camper.getDisorders().length()!=0)){
	    			 document.insertString(document.getLength(),camper.disordersList.toString().replace("[", "").replace("]","")+", "+camper.getDisorders()+"\n\n", style6);}
	    			 else{
	    				 document.insertString(document.getLength(),camper.disordersList.toString().replace("[", "").replace("]","")+"\n\n",style6);
	    			 }
	    		 }
	    		 else{
	    	     document.insertString(document.getLength(), "None Reported\n\n" , style6);	 
	    		 }
	    		 
	    		 document.insertString(document.getLength(), "Medications: ", style5);
	    		 if((camper.getMedications()!=null)&&(camper.getMedications().length()!=0)){
	    		 document.insertString(document.getLength(), camper.getMedications()+"\n\n" , style6);
	    		 }
	    		 else{
		    	 document.insertString(document.getLength(), "None Reported\n\n" , style6);	 
		    	 }
	    		 
	    		 document.insertString(document.getLength(), "Allergies: ", style5);
	    		 if((camper.getAllergies()!=null)&&(camper.getAllergies().length()!=0)){
	    		 document.insertString(document.getLength(), camper.getAllergies()+"\n\n" , style6);
	    		 }
	    		 else{
	    		 document.insertString(document.getLength(), "None Reported\n\n" , style6); 
	    		 }
	    		
	    		 document.insertString(document.getLength(), "Dietary Preferences/Restrictions: ", style5);
	    		 if((camper.getDietaryPreferences()!=null)&&(camper.getDietaryPreferences().length()!=0)){
	    		 document.insertString(document.getLength(), camper.getDietaryPreferences()+"\n\n" , style6); 
	    		 }
	    		 else{
	    		 document.insertString(document.getLength(), "None Reported\n\n" , style6);
	    		 }
	    		
	    		 document.insertString(document.getLength(), "Special Needs/Accommodations: \n\n", style5);
	    		 if((camper.getSpecialNeeds()!=null)&&(camper.getSpecialNeeds().length()!=0)){
	    		 document.insertString(document.getLength(),camper.getSpecialNeeds()+"\n\n" , style6);	 
	    		 }
	    		 else{
		    	 document.insertString(document.getLength(), "None Reported\n\n" , style6);
		    	 }
	    		 document.insertString(document.getLength(), "Emergency Contact Information: \n\n", style5);
	    		 
	    		 if((camper.getEmergencyContact1()!=null)&&(camper.getEmergencyContact1().length()!=0)){
	    			 document.insertString(document.getLength(), "Name:  ", style5);
	    			 document.insertString(document.getLength(),camper.getEmergencyContact1()+"     " , style6);
	    			 document.insertString(document.getLength(), "Relationship to Camper:  ", style7);
	    			 document.insertString(document.getLength(),camper.getEmergencyContactRelationship1()+"     " , style6);
	    			 document.insertString(document.getLength(), "Phone Number:  ", style8);
	    			 document.insertString(document.getLength(),camper.getEmergencyContactPhone1(), style6);
	    			 
	    			 
	    		 }
	    		 if((camper.getEmergencyContact2()!=null)&&(camper.getEmergencyContact2().length()!=0)){
	    			 document.insertString(document.getLength(), "\nName:  ", style5);
	    			 document.insertString(document.getLength(),camper.getEmergencyContact2()+"     " , style6);
	    			 document.insertString(document.getLength(), "Relationship to Camper:  ", style7);
	    			 document.insertString(document.getLength(),camper.getEmergencyContactRelationship2()+"     " , style6);
	    			 document.insertString(document.getLength(), "Phone Number:  ", style8);
	    			 document.insertString(document.getLength(),camper.getEmergencyContactPhone2(), style6);
	    			 
	    		 }
	    		
	    		 
	    		 document.insertString(document.getLength(), "\n\n_______________________________________________________________________________"
	    		 		+ "________________________________________________________\n\n\n" , style6);
	    		 
	    		 
	    		 
	    		 
	    		 
	    	 }
	    	 
	    	
	    	 
	    	 JLabel label= new JLabel("Printable Medical Report");
	    	 label.setAlignmentX(0.5f);
	    	 panel.add(label);
	    	 
	    	 panel.add(Box.createVerticalStrut(20));
	    	 
	    	panel.add(scrollPane);
	    	
	    	 panel.add(Box.createVerticalStrut(20));
	    	 
	    	 JButton printButton= new JButton("PRINT");
	    	 printButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try {
			             
						
			              textPane.print();
			            } catch (PrinterException pe) {
			              System.err.println("Error printing: " + pe.getMessage());
			            }
			          
				}
	    		 
	    	 });
	    	 
	    	 panel.add(printButton);
	    	 
	    	 panel.add(Box.createVerticalStrut(20));
	    	
	    	 
	    	 frame.setVisible(true);
	    	 
	    	 frame.pack();
	    	 

	    }
	    private void cabinList(Cabin cabin) throws BadLocationException{
	    	JFrame frame= new JFrame("Cabin List");
	    	JPanel panel= new JPanel();
	    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    	frame.getContentPane().add(panel);
	    	
	    	StyleContext context= new StyleContext();
	    	StyleContext context2= new StyleContext();
	    	StyleContext context3= new StyleContext();
	    	StyleContext context4= new StyleContext();
	    	
	    	StyledDocument document = new DefaultStyledDocument(context);
	    	javax.swing.text.Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style2= context2.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style3= context3.getStyle(StyleContext.DEFAULT_STYLE);
	    	javax.swing.text.Style style4= context4.getStyle(StyleContext.DEFAULT_STYLE);
	    	
	    	StyleConstants.setBold(style, true);
	    	StyleConstants.setBold(style2, true);
	    	StyleConstants.setBold(style4, true);
	    	
	    	StyleConstants.setFontSize(style, 25);
	    	StyleConstants.setFontSize(style2, 18);
	    	StyleConstants.setFontSize(style3, 15);
	    	StyleConstants.setFontSize(style4, 18);
	    	
	    	StyleConstants.setUnderline(style2, true);
	    	
	    	document.insertString(document.getLength(), "Cabin List\n", style);
	    	
	    	document.insertString(document.getLength(), CampInformation.nameOfCamp+"\n", style3);
	    	
	    	document.insertString(document.getLength(), CampInformation.sloganOfCamp+"\n\n", style3);
	    
	    	
	    	
	    	document.insertString(document.getLength(), "Cabin: ", style4);
	    	
	    	document.insertString(document.getLength(), cabin.toString()+"\n\n", style3);
	    	
	    	document.insertString(document.getLength(), "Counselors\n", style2);
	    	
	    	for(int i=0;i<counselorAddedJList.getModel().getSize();i++){
	    		Counselor counselor= (Counselor)counselorAddedJList.getModel().getElementAt(i);
	    		document.insertString(document.getLength(),counselor.toString()+"\n", style3);
	    	}
	    	document.insertString(document.getLength(), "\n\nCampers\n", style2);
	    	for(int i=0;i<camperAddedJList.getModel().getSize();i++){
	    		Camper camper= (Camper)camperAddedJList.getModel().getElementAt(i);
	    		document.insertString(document.getLength(),camper.toString()+"\n", style3);
	    	}
	    	
	    	document.insertString(document.getLength(),"\n\n", style3);
	    	
	    	
	    	 JTextPane textPane= new JTextPane(document);
	    	 JScrollPane scrollPane = new JScrollPane(textPane);
	    	 
	    	 JLabel label= new JLabel("Printable Cabin List");
	    	 label.setAlignmentX(0.5f);
	    	 panel.add(label);
	    	 
	    	 panel.add(Box.createVerticalStrut(20));
	    	 
	    	panel.add(scrollPane);
	    	
	    	 panel.add(Box.createVerticalStrut(20));
	    	 
	    	 JButton printButton= new JButton("PRINT");
	    	 printButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					try {
			             
						
			              textPane.print();
			            } catch (PrinterException pe) {
			              System.err.println("Error printing: " + pe.getMessage());
			            }
			          
				}
	    		 
	    	 });
	    	 
	    	 panel.add(printButton);
	    	 
	    	 panel.add(Box.createVerticalStrut(20));
	    	
	    	 
	    	 frame.setVisible(true);
	    	 frame.pack();
	    	 
	    	 
	    	 
	    
	    	
	    }
	    private void autoAssign(Cabin cabin) throws ParseException{
	    	
	   /*
	    * A starting index is selected by the user, and current index and indices below are assigned to current cabin until 
	    * filled to capacity.  If camper is outside of age range or has special requests, they are still flagged for each with the camper name 
	    * on each confirm dialog. 
                    */
	    	int capacityLessAdded= cabin.getCapacity()-camperAddedJList.getModel().getSize();
	    	int currentIndex= camperJList.getSelectedIndex();
                                    
	    	if(currentIndex<0){
	    		JOptionPane.showMessageDialog(null, "Please select a starting index");
	    		return;
	    	}
	    	for(int i=0;i<capacityLessAdded;i++){
	    		
	   //int i is not used for anything other than looping through the list.  It is not referenced in any variables. 
	              if(camperJList.isSelectionEmpty()==true){
	    	    	return;
	    	    	//Once there are no more campers on the model, the method is terminated. 
                                   }
	   
	    		Camper camper= (Camper) campersModel.getElementAt(currentIndex);
	    	            
                                 
                                 
                                                              addCamper(cabin, camper);
                                                            if(added==false){
                                                                JOptionPane.showMessageDialog(null, "Auto-assign has automatically terminated since you opted not to add camper.  Please run again");
                                                         return;}
                                                            
                                                                camperJList.setSelectedIndex(currentIndex);
                                                            
	    		   
                                                             }
                
	    	 }
	    
	    private void clearCabin(Cabin cabin){
	      camperAddedJList.setSelectedIndex(0);
	      
	      for(int i=0; i<cabin.getCapacity();i++){
	    	 if(camperAddedJList.getModel().getSize()>0){
	    	  Camper camper= (Camper)getModelForCabin(cabin).getElementAt(0);
	    	
	    	  delete(cabin, camper);
	    	  if(counselorAddedJList.getModel().getSize()==0){
	    		  NewCabin.cabinList2.add(currentCabin);
	    	  }
	    	 }
	    	 else{
	    	//The method is set to loop through the amount of the capacity until the size of the JList is equal to 0, and then the method terminates. 
	    		 return;
	    	 }
	      }
	    }
	    }

	    
	    
	
		
