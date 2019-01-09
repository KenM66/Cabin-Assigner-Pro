/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicFileChooserUI;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.sql.*;  
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends JPanel implements Serializable


{
       
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5906362381229037660L;
	public JButton assignCabins;
	private JButton viewCabin;
	private JButton btnSaveCamp;
	private JButton btnLoadSavedCamp;
	private JButton addCounselor;
	private JButton addCabin;
	private JButton editCabin;
	private JButton editCamper;
	private JButton editCounselor;
	private JButton addInfo;
	JButton addCamper;
	private JButton importCampers;
	private JButton importCounselors;
                   private JButton buttonLicense;

	
	 static JFileChooser fileChooser;
	
	 static boolean fileLoaded;
	 static File f;
	 static boolean fileChanged;
         
                    static  final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
                    static final String DB_URL= "jdbc:mysql://localhost:3306/summer_camp";
	 static final String USER="root";
                    static final String PASSWORD= "";
	 /*
	  * If the file loaded equals true, the JFileChooser will not appear when the save button is clicked.  
	  * If the file changed is equal to false, it will not prompt user to save before closing the program.  
	  * Clicking any buttons which can potentially change the saved objects will set the file changed boolean to true. 
	  */
         
         private LicenseKeyGUI licenseKeyGUI;
	 
	 
	 
	 
	 
	 /**
	  * @wbp.nonvisual location=166,384
	  */
	 private JToggleButton colorToggleButton; 
	 private JToggleButton standardToggleButton;
	 
	 private ArrayList<JButton> buttonList;
	 /**
	  * @wbp.nonvisual location=202,414
	  */
	static boolean colorful;
	
	private JPanel panel;
	
	private JPanel addEditPanels;
	private Component horizontalGlue;

    public int getMySQLcampID() {
        return mySQLcampID;
    }

    public void setMySQLcampID(int mySQLcampID) {
        this.mySQLcampID = mySQLcampID;
    }

    public int getMySQLsessionID() {
        return mySQLsessionID;
    }

    public void setMySQLsessionID(int mySQLsessionID) {
        this.mySQLsessionID = mySQLsessionID;
    }

    public int getMySQLorganizationID() {
        return mySQLorganizationID;
    }

    public void setMySQLorganizationID(int mySQLorganizationID) {
        this.mySQLorganizationID = mySQLorganizationID;
    }
	private JPanel bottomGridPanel;
	private Component horizontalGlueBottom;
	
                   private int mySQLcampID;
                   private int mySQLsessionID;
                   private int mySQLorganizationID;
	
	
    public Home() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException
    {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        
         //  licenseKeyGUI = new LicenseKeyGUI(this, true);
    	
    	setTestCampers();
    	setTestCabins();
    	setTestDate();
    	
    	setTestCounselors();
        
                
        
    	
    	 buttonList= new ArrayList<JButton>();
    	
    	
    	//Above methods are used for testing purposes
    	//colorful=true;
    	
    	
    	 
    	setBackground(Color.LIGHT_GRAY);
        
    	setBorder( new EmptyBorder(20, 20, 20, 20) );
 
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
 
        //  Add label/button at top
 
        JLabel cabinAssigner = new JLabel( "Cabin Assigner Pro" );
        cabinAssigner.setFont(new Font("Tahoma", Font.BOLD, 25));
        cabinAssigner.setForeground(Color.BLUE);
        cabinAssigner.setAlignmentX(0.5f);
        add( cabinAssigner );
        add( Box.createVerticalStrut(20) );
 
        assignCabins = new JButton( "Assign Cabins" );
        
        
       
        assignCabins.setFont(new Font("Tahoma", Font.BOLD, 13));
      
        assignCabins.setAlignmentX(0.5f);
        add( assignCabins );
        add( Box.createVerticalStrut(20) );
        addInfo = new JButton( "Add/Edit Camp Information" );
        
        buttonList.add(assignCabins);
        
       
        addInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
        //addInfo.setAlignmentX(0.5f);
        addInfo.setAlignmentX(0.5f);
      //  add(addInfo);
        
        buttonList.add(addInfo);
   
 
        //  Create panel for "Add/Edit/Delete" buttons
 
        addCamper = new JButton( "Add Camper" );
      
       
        addCamper.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        editCamper = new JButton( "Edit/Delete Camper" );
        
        buttonList.add(addCamper);
        buttonList.add(editCamper);
       
        
        editCamper.setFont(new Font("Tahoma", Font.BOLD, 13));
       
 
        addCounselor = new JButton( "Add Counselor" );
       
        addCounselor.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        editCounselor = new JButton( "Edit/Delete Counselor" );
        
        editCounselor.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        
        buttonList.add(addCounselor);
        buttonList.add(editCounselor);
 
        addCabin = new JButton( "Add Cabin" );
       
        addCabin.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        
        buttonList.add(addCabin);
        
        
        editCabin = new JButton( "Edit/Delete Cabin" );
       
        editCabin.setFont(new Font("Tahoma", Font.BOLD, 13));
     
        buttonList.add(editCabin);
        
        
 
        addEditPanels = new JPanel();
        addEditPanels.setLayout( new BoxLayout(addEditPanels, BoxLayout.X_AXIS));
     // addEditPanels.setBackground(Color.BLUE);
       // addEditPanels.setForeground(Color.BLUE);
 
        addEditPanels.add( createButtonPanel(addCamper, editCamper) );
        horizontalGlue = Box.createHorizontalGlue();
        //horizontalGlue.setBackground(Color.BLUE);
        addEditPanels.add( horizontalGlue );
        addEditPanels.add( createButtonPanel(addCounselor, editCounselor) );
       
        addEditPanels.add( Box.createHorizontalGlue() );
        addEditPanels.add( createButtonPanel(addCabin, editCabin) );
        
        
        //addEditPanels.setAlignmentX(0.5f);
 
        add(addEditPanels);
 
        //  Add buttons at bottom
 
        add( Box.createVerticalStrut(20) );
        add( Box.createVerticalGlue() );

     
        add( Box.createVerticalStrut(10) );
       horizontalGlueBottom= Box.createHorizontalGlue();
        bottomGridPanel= new JPanel();
        bottomGridPanel.setLayout(new GridLayout(4,3));
        bottomGridPanel.setAlignmentX(0.5f);
       bottomGridPanel.setBackground(Color.LIGHT_GRAY);
        //horizontalGlueBottom.setBackground(Color.BLUE);
        bottomGridPanel.add(horizontalGlueBottom);
      
       
        
        importCampers= new JButton("Import Camper List");
      
       
        importCampers.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        //importCampers.setAlignmentX(0.5f);
        
        buttonList.add(importCampers);
       
        
        //add( Box.createVerticalStrut(10) );
        
        importCounselors=new JButton("Import Counselor List");
        
        
        importCounselors.setFont(new Font("Tahoma", Font.BOLD, 13));
      
        importCounselors.setAlignmentX(0.5f);
        
        buttonList.add(importCounselors);
        
       // bottomGridPanel.add( importCounselors );
        //add( Box.createVerticalStrut(10) );
        
        
        
        
        
 
        viewCabin = new JButton( "View/Print Cabin List" );
        
        viewCabin.setFont(new Font("Tahoma", Font.BOLD, 13));
       
        viewCabin.setAlignmentX(0.5f);
       // bottomGridPanel.add( viewCabin );
       // add( Box.createVerticalStrut(10) );
        add(viewCabin);
        buttonList.add(viewCabin);
        
        add( Box.createVerticalStrut(10) );
        add(addInfo);
        add( Box.createVerticalStrut(10) );
       
      //  add(Box.createVerticalStrut(10));
        btnSaveCamp= new JButton("Save Camp");
        
        btnSaveCamp.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSaveCamp.setAlignmentX(0.5f);
       // bottomGridPanel.add( btnSaveCamp );
        
        buttonList.add(btnSaveCamp);
        
       // add(Box.createVerticalStrut(10));
        btnLoadSavedCamp= new JButton("Load Saved Camp");
        
      
        btnLoadSavedCamp.setFont(new Font("Tahoma", Font.BOLD, 13));
       // btnLoadSavedCamp.setAlignmentX(0.5f);
        //bottomGridPanel.add( btnLoadSavedCamp );
        
        buttonList.add(btnLoadSavedCamp);
        
        bottomGridPanel.add( importCampers );
        bottomGridPanel.add(horizontalGlueBottom);
        bottomGridPanel.add(btnSaveCamp);
        bottomGridPanel.add(horizontalGlueBottom);
        bottomGridPanel.add(importCounselors);
        bottomGridPanel.add(horizontalGlueBottom);
        bottomGridPanel.add(btnLoadSavedCamp);
       // bottomGridPanel.add(viewCabin);
       // horizontalGlueBottom.setBackground(Color.BLUE);
       // bottomGridPanel.setBackground(new Color(135, 206, 250));
        add(bottomGridPanel);
        
       // bottomGridPanel.add(createButtonPanel(importCampers, importCounselors));
        bottomGridPanel.add(Box.createHorizontalGlue());
        
        bottomGridPanel.add(horizontalGlueBottom);
     //   bottomGridPanel.add(createButtonPanel(btnSaveCamp, btnLoadSavedCamp));
      
       JLabel colorScheme= new JLabel("Color Scheme");
       colorScheme.setAlignmentX(0.5f);
       colorScheme.setForeground(Color.BLUE);
       colorScheme.setFont(new Font("Tahoma", Font.BOLD, 15));
       add(colorScheme);
       
       
       
       standardToggleButton= new JToggleButton("Standard");
      
       standardToggleButton.setAlignmentX(0.5f);
       standardToggleButton.setBackground(Color.WHITE);
       add(standardToggleButton);
       //standardToggleButton.setSelected(true);
       
       colorToggleButton= new JToggleButton("  Colorful  ");
       colorToggleButton.setAlignmentX(0.5f);
       colorToggleButton.setBackground(Color.WHITE);
       add(colorToggleButton);
       
      for(JButton button: buttonList){
    	  button.setBackground(Color.WHITE);
      }
     //setStandardColors();
     
     add(Box.createVerticalStrut(20));
     buttonLicense= new JButton("Product License");
     buttonLicense.setAlignmentX(0.5f);
     add(buttonLicense);
        
        //Delete below this line to show frame with no functions. 
        
        addActionListeners();
        
        fileLoaded=false;
        fileChanged=true;
        colorful=false;
        
      
      
    }
 
    private JPanel createButtonPanel(JButton top, JButton bottom)
    {
        // Use a GridBagLayout for the two buttons.  The buttons will be
        // placed above one another and the width will match.
 
        Insets buttonInsets = new Insets(20,20, 20, 20);
 
        panel = new JPanel( new GridLayout(0,1, 10, 0) );
        
 
        top.setMargin( buttonInsets );
        panel.add(top);
 
        bottom.setMargin( buttonInsets );
        panel.add(bottom);
 
        // Prevent panel from growing when used in BoxLayout
       
        panel.setMaximumSize( panel.getPreferredSize() );
 
        return panel;
        
        
    }
    
 
 
    public static void createAndShowGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException
    {
        JFrame frame = new JFrame("Cabin Assigner Pro");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().add(new Home());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setLocationRelativeTo(null);
       
        
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	if(fileChanged==false){
            		System.exit(0);
            	}
            	int response=  JOptionPane.showConfirmDialog( null, "Would you like to save your changes?");
           		     if(response== JOptionPane.YES_OPTION) 
            	    {
           		    	if(fileLoaded==true){
           		    		saveSelectedCamp();
           		    		System.exit(0);}
           		    	else{
           		    		saveCamp();
           		    		System.exit(0);
           		    }
           		    }
           		      
           		    
           	else if(response==JOptionPane.NO_OPTION){
           		     System.exit(0);
           	 
           	 }
           	 else{
           		 return;
           	 }
           	
           	 
           	 
            }});
        frame.setResizable(false);
        frame.setVisible( true );
      
        
    }
 
   // public static void main(String[] args) throws Exception
 //   {
      

     //  EventQueue.invokeLater(new Runnable()
      //  {
         //   public void run(){
       //  
            //    createAndShowGUI();}
      //    });
//}
public void viewCamperCabinList() throws PrinterException{
	CamperCabinList cabinList= new CamperCabinList();
	cabinList.setVisible(true);
	cabinList.createAndShowList();
}
 
public void addNewCamper(){
    NewCamper camper1 = new NewCamper();
    camper1.setVisible(true);
    //camper1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}
public void editOrDeleteCamper(){
    EditDeleteCamper camper1 = new EditDeleteCamper();
    camper1.setVisible(true);
    camper1.showEditCampers();
}
public void editOrDeleteCabin(){
    DeleteCabin cabin1 = new DeleteCabin();
    cabin1.setVisible(true);
    cabin1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}
public void createNewCabin(){
    NewCabin cabin1= new NewCabin();
   
    cabin1.createNewCabinDisplay();
    cabin1.setVisible(true);
    
    //cabin1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}
public void editOrDeleteCounselor(){
    EditDeleteCounselor counselor1 = new EditDeleteCounselor();
    counselor1.setVisible(true);
    counselor1.showEditCampers();
}
public void assignCabins(){
     
        AssignToCabin cabin1= new AssignToCabin();
      
        cabin1.setVisible(true);
        AssignToCabin.showCabinAssignments();
      
}
public void addNewCounselor(){
    NewCounselor counselor1= new NewCounselor();
    counselor1.setVisible(true);
    counselor1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}
public void nullCampDateError(){
    JOptionPane.showMessageDialog(null, "You must set camp start date before completing this action. This can be done by"
    		+ " clicking the 'Add/Edit Camp Information' button.  P.S. Did you forget to open your saved camp file?");
    
/*
 * Several buttons being clicked with cause a null pointer exception if a camp date was not set.
 * Therefore, this method being added will avoid having to do any exception handling as those methods will not execute 
 * if the date of camp is null. 
 */
}
public void campInformation(){
    CampInformation camp= new CampInformation();
    camp.setVisible(true);
    camp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}
public void noCabinsError(){
    JOptionPane.showMessageDialog(null, "You have not created any cabins yet!");
}
private void setTestCampers(){
	//Method is only used when testing is being done. 
	
	Camper camper1= new Camper("Mann", "Terrance", 'M');
	camper1.setDob("06/01/2010");
	camper1.setDisorders("Autism Spectrum Disorder");
	
	Camper camper2= new Camper("Gibbler", "Kimmy", 'F');
	camper2.setDob("05/03/2010");
	
	Camper camper3= new Camper("Brady","Mike", 'M');
	camper3.setDob("04/01/2008");
	
	Camper camper4= new Camper("Ricardo", "Lucy", 'F');
	camper4.setDob("03/03/2007");
	
	Camper camper5= new Camper("Coffey", "John", 'M');
	camper5.setDob("02/27/2007");
	
	Camper camper6= new Camper("DeWitt Bukater", "Rose", 'F');
	camper6.setDob("12/15/2006");
	
	Camper camper7= new Camper("Dawson", "Jack", 'M');
	camper7.setDob("09/05/2006");
	
	Camper camper8= new Camper("Brown","Oda Mae", 'F' );
	camper8.setDob("12/01/2005");
	
	Camper camper9= new Camper("Wheat", "Sam", 'M');
	camper9.setDob("06/09/2005");
	
	Camper camper10= new Camper("Bunker", "Edith", 'F');
	camper10.setDob("12/25/2004");
	
	NewCamper.camperList.add(camper1);
	NewCamper.camperList.add(camper2);
	NewCamper.camperList.add(camper3);
	NewCamper.camperList.add(camper4);
	NewCamper.camperList.add(camper5);
	NewCamper.camperList.add(camper6);
	NewCamper.camperList.add(camper7);
	NewCamper.camperList.add(camper8);
	NewCamper.camperList.add(camper9);
	NewCamper.camperList.add(camper10);
	
	NewCamper.camperList2.add(camper1);
	NewCamper.camperList2.add(camper2);
	NewCamper.camperList2.add(camper3);
	NewCamper.camperList2.add(camper4);
	NewCamper.camperList2.add(camper5);
	NewCamper.camperList2.add(camper6);
	NewCamper.camperList2.add(camper7);
	NewCamper.camperList2.add(camper8);
	NewCamper.camperList2.add(camper9);
	NewCamper.camperList2.add(camper10);
        
              databaseLink(1, "6329");
               campSessionLink(1);
        
              insertCampersToDatabase();
	
	}

public void setTestCabins() throws ClassNotFoundException, SQLException{
	
	//Method is only used when testing is being done. 
	Cabin cabin1= new Cabin("Pink", 'F', 8, 10);
	cabin1.setCapacity(4);
	cabin1.setNumCounselors(2);
	
	Cabin cabin2= new Cabin("Mint", 'F', 12, 14);
	cabin2.setCapacity(4);
	cabin2.setNumCounselors(2);
	
	Cabin cabin3= new Cabin("Violet", 'F', 10, 12);
	cabin3.setCapacity(4);
	cabin3.setNumCounselors(2);
	
	Cabin cabin4= new Cabin("Gray", 'M', 12, 14);
	cabin4.setCapacity(4);
	cabin4.setNumCounselors(2);
	
	
	Cabin cabin5= new Cabin("Turqoise", 'M', 10, 12);
	cabin5.setCapacity(4);
	cabin5.setNumCounselors(2);
	
	Cabin cabin6= new Cabin("Red", 'M', 8, 10);
	cabin6.setCapacity(4);
	cabin6.setNumCounselors(2);
	
	Cabin cabin7= new Cabin("Tie Dye", 'N', 15, 18);
	cabin7.setCapacity(4);
	cabin7.setNumCounselors(2);
	
	NewCabin.cabinList.add(cabin1);
	NewCabin.cabinList.add(cabin2);
	NewCabin.cabinList.add(cabin3);
	NewCabin.cabinList.add(cabin4);  
	NewCabin.cabinList.add(cabin5);
	NewCabin.cabinList.add(cabin6);
	NewCabin.cabinList.add(cabin7);
	
	NewCabin.cabinList2.add(cabin1);
	NewCabin.cabinList2.add(cabin2);
	NewCabin.cabinList2.add(cabin3);
	NewCabin.cabinList2.add(cabin4);  
	NewCabin.cabinList2.add(cabin5);
	NewCabin.cabinList2.add(cabin6);
	NewCabin.cabinList2.add(cabin7);
        
        addCabinsToDatabase();
}
private void setTestDate(){
	
	//Method is only used when testing is being done. 
	Camp camp1= new Camp();
	camp1.setCampDate("07/01/2018");
	camp1.setDateString("07/01/2018");
}

private void setTestCounselors() throws ClassNotFoundException, SQLException{
	
	//Method is only used when testing is being done. 
	Counselor counselor1= new Counselor("Miyagi", "Nariyoshi", 'M' );
	Counselor counselor2= new Counselor("Hannigan","Aggatha", 'F');
	Counselor counselor3= new Counselor("Lee", "Kevin", 'M');
	Counselor counselor4= new Counselor("Strict", "Delilah", 'F');
	
	NewCounselor.counselorList.add(counselor1);
	NewCounselor.counselorList.add(counselor2);
	NewCounselor.counselorList.add(counselor3);
	NewCounselor.counselorList.add(counselor4);
	
	NewCounselor.counselorList2.add(counselor1);
	NewCounselor.counselorList2.add(counselor2);
	NewCounselor.counselorList2.add(counselor3);
	NewCounselor.counselorList2.add(counselor4);
        
        insertCounselorsToDatabase();
	
	
}

private void addActionListeners(){
	
	assignCabins.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
                                          MainJFrame.frame.dispose();
                                    
    		if(CampInformation.dateOfCamp!=null){
    		
    		if(NewCabin.cabinList.size()==0){
    			JOptionPane.showMessageDialog(null, "You haven't created any cabins.");
    		}
    		else{
    			assignCabins();
    			fileChanged=true;
    		}
    	
    		
    		}
    		else{
    			nullCampDateError();
    		}
    	    }
    });
	
	viewCabin.addActionListener(new ActionListener(){

		
		public void actionPerformed(ActionEvent arg0) {
                                                           MainJFrame.frame.dispose();
                                                           if(MainJFrame.validated==false){
                                                               if(NewCamper.camperList.size()>20){
                                                                   String message= "You cannot use this function with more than 20 campers on your list until you activate your software.";
                                                                   JOptionPane.showMessageDialog(null, message);
                                                                   return;
                                                               }
                                                           }
                                                           
			if(CampInformation.dateOfCamp!=null){
//If the size of both of referenced lists below, it means that either no objects have been created, or that all campers and counselors are 
// assigned to a cabin.  If either list have any elements, it will alert the user that they haven't given everyone a cabin assignment before printing the final lists. 
			if((NewCamper.camperList2.size()==0)&&(NewCounselor.counselorList2.size()==0)){
				try {
					viewCamperCabinList();
					
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				// TODO Auto-generated catch block
				
			}else if((NewCamper.camperList2.size()>0)&&(NewCounselor.counselorList2.size()>0)) {
                                                                            String message= "Are you sure you wish to print your lists?  There are still campers and counselors not assigned to cabins. ";
				int response=JOptionPane.showConfirmDialog(null, message);
				if(response==JOptionPane.YES_OPTION){
					try {
						viewCamperCabinList();
					} catch (PrinterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else{
					return;
				}
			}
			else if(NewCamper.camperList2.size()>0){
				int response=JOptionPane.showConfirmDialog(null, "Are you sure you wish to print your lists? Not all campers have a cabin assignment.");
			
			if(response==JOptionPane.YES_OPTION){
				try {
					viewCamperCabinList();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else{
				return;
			}
			fileChanged=true;
				}
			else{int response=JOptionPane.showConfirmDialog(null, "Are you sure you wish to print your lists? Not all counselors have a cabin assignment.");
			
			if(response==JOptionPane.YES_OPTION){
				try {
					viewCamperCabinList();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
			}
			}
			else
			{
				nullCampDateError();
			}
		}
		
	});
	
	btnSaveCamp.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
              MainJFrame.frame.dispose();
    		if(fileLoaded==true){
    			saveSelectedCamp();
    		}
    		else{
    		saveCamp();
    		fileChanged=false;
    		}
    	    }
    });
	
	btnLoadSavedCamp.addActionListener(new ActionListener() {
             
    	public void actionPerformed(ActionEvent e) {
              MainJFrame.frame.dispose();
    		try {
    			
				readCamp();}
    			
				 catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                         //   for(Camper c: NewCamper.camperList){
                           //       c.setEmergencyContact1("Sample Parent");
                             //     c.setEmergencyContactPhone1("440-781-1401");
                               //   c.setEmergencyContactRelationship1("Father/Mother");
                        //   }
    	    }
    });
	
	addCounselor.addActionListener(new ActionListener() {
            
    	public void actionPerformed(ActionEvent e) {
              MainJFrame.frame.dispose();
    		if(CampInformation.dateOfCamp!=null){
    		addNewCounselor();}
    		else{
    			nullCampDateError();
    		}
    	    }
    });
	addCabin.addActionListener(new ActionListener() {
              
    	public void actionPerformed(ActionEvent e) {
              MainJFrame.frame.dispose();
    		if(CampInformation.dateOfCamp!=null){
    			 createNewCabin();}
    			 else{
    				 nullCampDateError();
    				 return;
    			 }
    		fileChanged=true;
    		}
    	
    	    
    });
	
	editCabin.addActionListener(new ActionListener() {
          
    	public void actionPerformed(ActionEvent e) {
              MainJFrame.frame.dispose();
    		if(CampInformation.dateOfCamp!=null){
    			editOrDeleteCabin();
    			 }
    			 else{
    				 nullCampDateError();
    				 return;
    			 }
    		fileChanged=true;
    		}
    	    
    });
	 editCamper.addActionListener(new ActionListener() {
          
     	public void actionPerformed(ActionEvent arg0) {
              MainJFrame.frame.dispose();
     		if(CampInformation.dateOfCamp!=null){
     		editOrDeleteCamper();}
     		else{
     			nullCampDateError();
     			return;
     		}
     		fileChanged=true;
     	}
     });
	 editCounselor.addActionListener(new ActionListener() {
    
	    	public void actionPerformed(ActionEvent e) {
                      MainJFrame.frame.dispose();
	    		if(CampInformation.dateOfCamp!=null){
	    		editOrDeleteCounselor();}
	    		else{
	    			nullCampDateError();
	    			return;
	    		}
	    		fileChanged=true;
	    		}
	    	    
	    });
	 addInfo.addActionListener(new ActionListener() {
            
     	public void actionPerformed(ActionEvent e) {
              MainJFrame.frame.dispose();
                   databaseLink(1, "6429");
     		 campInformation();
     		 fileChanged=true;
     }});
	  addCamper.addActionListener(new ActionListener() {
                
      	public void actionPerformed(ActionEvent arg0) {
              MainJFrame.frame.dispose();
      		if(CampInformation.dateOfCamp!=null){
      		NewCamper camper= new NewCamper();
      		camper.setVisible(true);}
      		else{
      			nullCampDateError();
      		}
      	}
      });
	  importCampers.addActionListener(new ActionListener() {
       
      	public void actionPerformed(ActionEvent arg0) {
              MainJFrame.frame.dispose();
      		if(CampInformation.dateOfCamp!=null){
      			importCampers();
      		}
      		else{
      			nullCampDateError();
      			return;
      		}
      		fileChanged=true;
      	}
      });
	  importCounselors.addActionListener(new ActionListener() {
               
      	public void actionPerformed(ActionEvent arg0) {
              MainJFrame.frame.dispose();
      		if(CampInformation.dateOfCamp!=null){
      			importCounselors();
      		}
      		else{
      			nullCampDateError();
      			return;
      		}
      		fileChanged=true;
      	}
      });
	  standardToggleButton.addActionListener(new ActionListener() {
            
	       	public void actionPerformed(ActionEvent arg0) {
                      MainJFrame.frame.dispose();
	       		colorToggleButton.setSelected(false);
	       		colorful=false;
	       	    setStandardColors();
	       	}
	       });
	  colorToggleButton.addActionListener(new ActionListener() {
         
	       	public void actionPerformed(ActionEvent arg0) {
                      MainJFrame.frame.dispose();
	       		standardToggleButton.setSelected(false);
	       		colorful=true;
	       		setBrightColors();
                                                         
	       	}
	       });
          addMouseListener(new MouseAdapter() { 
          public void mousePressed(MouseEvent me) { 
            MainJFrame.frame.dispose();
          } 
        }); 
          
           buttonLicense.addActionListener(new ActionListener() {
               
      	public void actionPerformed(ActionEvent arg0) {
                        MainJFrame.frame.setVisible(true);
        }
           });
}

        

     
	

private static void saveCamp(){
	  fileChooser= new JFileChooser();
	  
	  
	  
	 if(fileChooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION){
			
			return;
			
			
	    }
	
	 try {
		 
		 
		 
         FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile());
         f= fileChooser.getSelectedFile();
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(NewCamper.camperList);
         oos.writeObject(NewCamper.camperList2);
         oos.writeObject(NewCabin.cabinList);
         oos.writeObject(NewCabin.cabinList2);
         oos.writeObject(NewCounselor.counselorList);
         oos.writeObject(NewCounselor.counselorList2);
        
         oos.writeObject(AssignToCabin.cabinMap);
         oos.writeObject(AssignToCabin.cabinCounselorMap);
         
         oos.writeObject(CampInformation.dateOfCamp);
         oos.writeObject(CampInformation.nameOfCamp);
         oos.writeObject(CampInformation.sloganOfCamp);
         oos.writeObject(CampInformation.campDateString);
        
         oos.close();
         fos.close();
       
         fileLoaded=true;
        
         } catch (IOException e) {
        	 JOptionPane.showMessageDialog(null, "Something went wrong!  Try again!");
         e.printStackTrace();
     } 
	 
	 
}

private void readCamp() throws ClassNotFoundException {
	
	 fileChooser= new JFileChooser();
	 
	 
	 
	
    if(fileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION){
		
		return;
		
    }
	try {
		f=fileChooser.getSelectedFile();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		NewCamper.camperList= (ArrayList) ois.readObject();
		NewCamper.camperList2= (ArrayList) ois.readObject();
		NewCabin.cabinList= (ArrayList) ois.readObject();
		NewCabin.cabinList2= (ArrayList) ois.readObject();
        
		NewCounselor.counselorList= (ArrayList) ois.readObject();
		NewCounselor.counselorList2= (ArrayList) ois.readObject();
		
		 AssignToCabin.cabinMap= (HashMap) ois.readObject();
		AssignToCabin.cabinCounselorMap= (HashMap) ois.readObject();
		
		CampInformation.dateOfCamp= (LocalDate) ois.readObject();
		CampInformation.nameOfCamp= (String) ois.readObject();
		CampInformation.sloganOfCamp= (String) ois.readObject();
		CampInformation.campDateString= (String) ois.readObject();
		fileLoaded= true;
		
		} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	
private static void saveSelectedCamp(){
	
 //This method is only executed if the static boolean fileLoaded is equal to true.     
     ObjectOutputStream oos;
	try {
		 FileOutputStream fos = new FileOutputStream(f);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(NewCamper.camperList);
	     oos.writeObject(NewCamper.camperList2);
	     oos.writeObject(NewCabin.cabinList);
	     oos.writeObject(NewCabin.cabinList2);
	     oos.writeObject(NewCounselor.counselorList);
	     oos.writeObject(NewCounselor.counselorList2);
	    
	     oos.writeObject(AssignToCabin.cabinMap);
	     oos.writeObject(AssignToCabin.cabinCounselorMap);
	     
	     oos.writeObject(CampInformation.dateOfCamp);
	     oos.writeObject(CampInformation.nameOfCamp);
	     oos.writeObject(CampInformation.sloganOfCamp);
	     oos.writeObject(CampInformation.campDateString);
	     oos.close();
	     fos.close();
	     fileChanged=false;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	
	
}




private void importCampers(){
	JOptionPane.showMessageDialog(null, "WARNING!  Loading a file different than the template provided with this program "
			+ "can cause the program to crash or your campers to be loaded incorrectly.  Please only use the provided template.");
	JFileChooser camperFile= new JFileChooser();
	int campersAdded=0;
	 if(camperFile.showOpenDialog(null) != JFileChooser.APPROVE_OPTION){
		
			return;
			
	    }
	try{
		File file= camperFile.getSelectedFile();
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet worksheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = worksheet.iterator();
		DataFormatter formatter = new DataFormatter();
		
		
		while(iterator.hasNext()){
			Camper camper= new Camper();
			XSSFRow row= (XSSFRow) iterator.next();
			
			
			if(row.getRowNum()==0){
				continue;
			}
			//if((row.getCell(0)!=null)||(row.getCell(1)!=null)){
			XSSFCell firstName= row.getCell(0);
			XSSFCell lastName=  row.getCell(1);
			XSSFCell dob=  row.getCell(3,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell gender=  row.getCell(2,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell disorders=  row.getCell(17,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell medications=  row.getCell(18,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell allergies=  row.getCell(19,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell diet=  row.getCell(20,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell specialNeeds=  row.getCell(21,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell requests=  row.getCell(4,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell contact1=  row.getCell(5,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell contactRelationship1=  row.getCell(6,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell phone1=  row.getCell(7,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell contact2=  row.getCell(8,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell contactRelationship2=  row.getCell(9,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			XSSFCell phone2=  row.getCell(10,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			
			XSSFCell adhd= row.getCell(11);
			XSSFCell anxiety= row.getCell(12);
			XSSFCell asthma= row.getCell(13);
			XSSFCell autism= row.getCell(14);
			XSSFCell bedwetting= row.getCell(15);
			XSSFCell depression= row.getCell(16);
			
		String firstNameString= firstName.getStringCellValue();
		
		camper.setFirstName(firstNameString);
		
		if(firstNameString.length()==0){
			//If there is no first name, the method terminate and it doesn't add anymore campers. 
			JOptionPane.showMessageDialog(null, "Row "+campersAdded+1+" does not have a first name.  All rows following were not added and the importing process"
					+ " will now terminate.");
			return;
		}
		
		camper.setLastName(lastName.getStringCellValue());
		
		if(lastName.getStringCellValue().length()==0){
			JOptionPane.showMessageDialog(null, "At least one camper has a missing last name and was not added.");
			continue;
			
		}
		
		camper.setDob(formatter.formatCellValue(dob));
		if(camper.dateOfBirth==null){
			JOptionPane.showMessageDialog(null, camper.getFirstName()+" "+camper.getLastName()+" was not added due to an incorrect date of birth format.");
		continue;
		}
		
		String g= gender.getStringCellValue();
	
		if(g.length()!=0){
		camper.setGender(g.toUpperCase().charAt(0));}
		else{
			camper.setGender('O');
		}
		
		camper.setDisorders(disorders.getStringCellValue());
		camper.setMedications(medications.getStringCellValue());
		camper.setAllergies(allergies.getStringCellValue());
		camper.setDietaryPreferences(diet.getStringCellValue());
		camper.setSpecialNeeds(specialNeeds.getStringCellValue());
		camper.setSpecialRequest(requests.getStringCellValue());
		camper.setEmergencyContact1(contact1.getStringCellValue());
		camper.setEmergencyContactRelationship1(contactRelationship1.getStringCellValue());
		camper.setEmergencyContactPhone1(formatter.formatCellValue(phone1));
		camper.setEmergencyContact2(contact2.getStringCellValue());
		camper.setEmergencyContactRelationship2(contactRelationship2.getStringCellValue());
		camper.setEmergencyContactPhone2(formatter.formatCellValue(phone2));
		
		
		if(adhd!=null){
			//String adhdCell= adhd.getStringCellValue();
			camper.disordersList.add("Attention Deficit Hyperactivity Disorder(ADHD)");
		}
		
		if(anxiety!=null){
			camper.disordersList.add("Anxiety");
		}
		
		if(autism!=null){
			camper.disordersList.add("Autism Spectrum Disorder");
			
		
		if(asthma!=null){
			camper.disordersList.add("Asthma");
		}
		}
		
		if(bedwetting!=null){
			camper.disordersList.add("Nocturnal Enuresis(Bedwetting)");
		}

		if(depression!=null){
			camper.disordersList.add("Depression");
		}
		boolean addCamper=true;
		for(Camper c:NewCamper.camperList){
			if((camper.getFirstName().equalsIgnoreCase(c.getFirstName()))&&(camper.getLastName().equalsIgnoreCase(c.getLastName()))){
				int option=JOptionPane.showConfirmDialog(null, "A camper with the name "+camper.getFirstName()+" "+camper.getLastName()
				+" already exists.  Are you sure you wish to add this camper?  Hit cancel to abort importing process");
				if(option==JOptionPane.NO_OPTION){
					addCamper=false;
				}
				else if(option==JOptionPane.CANCEL_OPTION){
					return;
				}
				
			}
		}
		if(addCamper==false){
			continue;
		}
                
                                     if(MainJFrame.validated==false){
                                         if(NewCamper.camperList.size()>=20){
                                             JOptionPane.showMessageDialog(null, "The trial version only allows you to add up to 20 campers");
                                             return;
                                         }
                                     }
		
		NewCamper.camperList.add(camper);
		NewCamper.camperList2.add(camper);
		
		campersAdded= campersAdded+1;
		
		
		
		
		}
		//	else{
				
		//	}
		//}
	
	}
	catch(FileNotFoundException e){
		JOptionPane.showMessageDialog(null, "Something went wrong! Try again!");
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Something went wrong! Try again!");
	}
	
	JOptionPane.showMessageDialog(null, "You have succcesfully imported "+campersAdded+" campers!");
}
private void importCounselors(){
	JOptionPane.showMessageDialog(null, "WARNING!  Loading a file different than the template provided with this program "
			+ "can cause the program to crash or your counselors to be loaded incorrectly.  Please only use the provided template.");
	JFileChooser camperFile= new JFileChooser();
	int counselorsAdded=0;
	 if(camperFile.showOpenDialog(null) != JFileChooser.APPROVE_OPTION){
			JOptionPane.showMessageDialog(null, "The following file type is incompatible.");
			return;
			
			
			
	 }
	 try{
			File file= camperFile.getSelectedFile();
			FileInputStream fis= new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet worksheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = worksheet.iterator();
			
			
			while(iterator.hasNext()){
				
				Counselor counselor= new Counselor();
				XSSFRow currentRow= (XSSFRow) iterator.next();
				//Iterator<Cell>cellIterator= currentRow.iterator();
				if(currentRow.getRowNum()==0){
					continue;
				}
				
				XSSFCell firstName= currentRow.getCell(0);
				XSSFCell lastName=  currentRow.getCell(1);
				XSSFCell gender=  currentRow.getCell(2,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				XSSFCell request= currentRow.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				
				if(firstName==null){
					JOptionPane.showMessageDialog(null, "Your counselor at row "+counselorsAdded+1+" has a blank first name"
							+ ". All rows following were not added and the importing process will terminate.");
					return;
				}
				String g= gender.getStringCellValue();
				counselor.setFirstName(firstName.getStringCellValue());
				counselor.setLastName(lastName.getStringCellValue());
				counselor.setGender(g.toUpperCase().charAt(0));
				counselor.setRequest(request.getStringCellValue());
				
				boolean addCounselor= true;
		for(Counselor c: NewCounselor.counselorList){
			if((c.getFirstName().equalsIgnoreCase(counselor.getFirstName()))&&c.getLastName().equalsIgnoreCase(counselor.getLastName())){
				int option=JOptionPane.showConfirmDialog(null, "A counselor with the name "+counselor.getFirstName()+" "+counselor.getLastName()
				+" already exists.  Are you sure you wish to add this counselor?  Hit cancel to abort importing process");
				if(option==JOptionPane.NO_OPTION){
					addCounselor=false;
				}
				if(option==JOptionPane.CANCEL_OPTION){
					return;
				}
			}
		}
				if(addCounselor==true){
				NewCounselor.counselorList.add(counselor);
				NewCounselor.counselorList2.add(counselor);
				counselorsAdded=counselorsAdded+1;}
				else{
					continue;
				}
				
				}}
	 catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 JOptionPane.showMessageDialog(null, "You have succcesfully imported "+counselorsAdded+" counselors!");
	 
}

private void setStandardColors(){
	 for(JButton button:buttonList){
		   button.setForeground(Color.BLACK);
		  button.setBackground(Color.WHITE);
		 
	   }
	  setBackground(Color.LIGHT_GRAY);
	  // panel.setBackground(null);
	   horizontalGlueBottom.setBackground(null);
       bottomGridPanel.setBackground(null);
       horizontalGlue.setBackground(null);
        addEditPanels.setBackground(null);
        addEditPanels.setForeground(null);
        colorToggleButton.setBackground(Color.WHITE);
        colorToggleButton.setForeground(null);
        standardToggleButton.setBackground(Color.WHITE);
        standardToggleButton.setForeground(null);
	
}

private void setBrightColors(){
                      
    
	 for(JButton button:buttonList){
                                         button.setOpaque(true);
		 button.setForeground(Color.BLUE);
		   
                   
                                       button.setBackground(Color.YELLOW);
                                     
		
		   
	   }
	 setBackground(new Color(135, 206, 250));
	
	  horizontalGlueBottom.setBackground(Color.BLUE);
       bottomGridPanel.setBackground(new Color(135, 206, 250));
    
       colorToggleButton.setBackground(Color.YELLOW);
       colorToggleButton.setForeground(Color.BLUE);
       standardToggleButton.setBackground(Color.YELLOW);
       standardToggleButton.setForeground(Color.BLUE);
       
	

}

public void databaseLink(  int campNumber, String pin){
      try{
        Class.forName("com.mysql.jdbc.Driver" );  
      try (Connection con = DriverManager.getConnection(  
                
                       "jdbc:mysql://localhost:3306/summer_camp","root","")){
               try(Statement stmt=con.createStatement();){
                
                String SQL= "SELECT camp.ID, campPinCode, campName FROM camp WHERE camp.ID= ' " +campNumber+   " '  ";  
                      
                
                boolean results= stmt.execute(SQL);
                int rsCount=0;
                
                    do {
            if (results) {
                ResultSet rs = stmt.getResultSet();
                rsCount++;

                // Show data from the result set.
                System.out.println("RESULT SET #" + rsCount);
                
               
               while(rs.next()){
                   if((rs.getInt("camp.ID")==campNumber)&&(rs.getString("camp.campPinCode").equals(pin))){
                        setMySQLcampID(campNumber);
                        
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"Incorrect camp and pin combination");
                       setMySQLcampID(0);
                       return;
                   }
                   
                System.out.println(rs.getString("campPinCode"));
            }
            }
                results= stmt.getMoreResults();
            
            
               } while(results);
                    
                    }
      
                 catch (SQLException e) {
        e.printStackTrace();
    }
              
         
      }
          
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Camp Not Found!");
          e.printStackTrace();
          
      }
          
    
}

public void campSessionLink(int sessionNumber){
     try{
        Class.forName("com.mysql.jdbc.Driver");  
      try (Connection con = DriverManager.getConnection(  
                
                    "jdbc:mysql://localhost:3306/summer_camp","root","")){
               try(Statement stmt=con.createStatement();){
                 
                String SQL= "SELECT session.ID,campID FROM session where session.ID= ' "  +sessionNumber+     "    '     ";  
                      
                
                boolean results= stmt.execute(SQL);
                int rsCount=0;
                
                    do {
            if (results) {
                ResultSet rs = stmt.getResultSet();
                rsCount++;

                // Show data from the result set.
                System.out.println("RESULT SET #" + rsCount);
                
               
               while(rs.next()){
                   if(((rs.getInt("campID")==getMySQLcampID()))&&(rs.getInt("session.ID")==sessionNumber)){
                        setMySQLsessionID(sessionNumber);
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"Camp session not found with your camp");
                        setMySQLsessionID(0);
                       return;
                   }
                   
                System.out.println(rs.getInt("campID"));
            }
            }
                results= stmt.getMoreResults();
            
            
               } while(results);
                    
                    }
      
                 catch (SQLException e) {
        e.printStackTrace();
    }
              
         
      }
          
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Camp Session Not Found!");
          e.printStackTrace();
          
      }
          
      
}

public void insertCampersToDatabase(){
    
    try{
        System.out.println(getMySQLsessionID());
        Class.forName("com.mysql.jdbc.Driver"); 
        Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        
               
    
            for (Camper c : NewCamper.camperList) {
                if(c.getCamperNumber()==0){
                   String SQL= " INSERT INTO camper "
                           + "( firstName, lastName, middleInitial, gender, dateOfBirth, "
                           + "last4SS, disordersOther, medications, specialNeeds, dietaryPreferencesOther, specialRequests, allergiesOther, notes) VALUES "
                           + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                   
                   
                    PreparedStatement ps= con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                    
                    ps.setString(1, c.getFirstName());
                    ps.setString(2, c.getLastName());
                    ps.setString(3, null);
                    ps.setString(4, String.valueOf(c.getGender()));
                    
                    Date date= Date.valueOf(c.dateOfBirth);
                    
                    ps.setDate(5, date);
                    ps.setString(6, null);
                    ps.setString(7, c.getDisorders());
                    ps.setString(8, c.getMedications());
                    ps.setString(9, c.getSpecialNeeds());
                    ps.setString(10, c.getDietaryPreferences());
                    ps.setString(11, c.getSpecialRequest());
                    ps.setString(12, c.getAllergies());
                    ps.setString(13, null);
                    
                    ps.executeUpdate();
                    
                    ResultSet generatedKeys= ps.getGeneratedKeys();
                    
                    
                    if(generatedKeys.next()){
                    c.setCamperNumber(generatedKeys.getInt(1));
                    
                    String sessionLink=  "INSERT INTO camperSessionLink"
                            + " (camperID, sessionID) VALUES (?,?)";
                    PreparedStatement ps2= con.prepareStatement(sessionLink);
                    ps2.setInt(1, c.getCamperNumber());
                    ps2.setInt(2, getMySQLsessionID());
             
                    ps2.executeUpdate();
                    System.out.println(c.getCamperNumber());}
                    
               
                }

                
                    
                    
                }
            }
     
          catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
     
    
}

}

public void insertCounselorsToDatabase() throws ClassNotFoundException, SQLException{
    
    //Exceptions are thrown because method cannot execute unless database is already linked and found. 
    
    Class.forName("com.mysql.jdbc.Driver"); 
        Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         
        String SQL="INSERT INTO staff (firstName, lastName, gender) VALUES(?,?,?)";
        
        PreparedStatement ps= con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                
       
        
        for(Counselor c: NewCounselor.counselorList){
            if(c.getCounselorNumber()==0){
                  ps.setString(1, c.getFirstName());
                  ps.setString(2, c.getLastName());
                  ps.setString(3, String.valueOf(c.getGender()));
                  
                  ps.executeUpdate();
                  
                   ResultSet generatedKeys= ps.getGeneratedKeys();
                  
                  if(generatedKeys.next()){
                      c.setCounselorNumber(generatedKeys.getInt(1));
                      
                      String sessionLink= "INSERT INTO staffSessionLink(staffID, sessionID) VALUES(?,?)";
                      
                       PreparedStatement ps2= con.prepareStatement(sessionLink);
                       ps2.setInt(1, c.getCounselorNumber());
                       ps2.setInt(2, getMySQLsessionID());
             
                       ps2.executeUpdate();
                      
                      
                      
                  }
                  
                  
               
                
           
            }
            
        }
    
}

public void addCabinsToDatabase()   throws ClassNotFoundException, SQLException{
    
     //Exceptions are thrown because method cannot execute unless database is already linked and found. 
    
     Class.forName("com.mysql.jdbc.Driver"); 
        Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        
        
        
        String SQL= "INSERT INTO cabin (cabinName, campSessionID, cabinAgeMin, cabinAgeMax, cabinGender,"
                + "cabinCamperCapacity, cabinNumOfCounselors) values (?,?,?,?,?,?,?)";
        
          PreparedStatement ps= con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
          
                    
          
        for(Cabin c: NewCabin.cabinList){
             if(c.getCabinNumber()==0){
                 
                 ps.setString(1, c.getCabinName());
                 ps.setInt(2, getMySQLsessionID());
                 ps.setInt(3, c.getAgeMin());
                 ps.setInt(4, c.getAgeMax());
                 ps.setString(5, String.valueOf(c.getCabinGender()));
                 ps.setInt(6, c.getCapacity());
                 ps.setInt(7, c.getNumberOfCounselors());
                 
                  ResultSet generatedKeys= ps.getGeneratedKeys();

                 
                 if(generatedKeys.next()){
                     c.setCabinNumber(generatedKeys.getInt(1));
                 }
                  
                 ps.executeUpdate();
                 
             }
        }
    
}

}






           
      





           




           
      









