/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewCabin extends JPanel {


	
	public JTextField textFieldCabinName;
	Cabin cabin1;
	
	private JLabel lblCreateNewCabin;
	private JLabel lblCabinName;
	JRadioButton rdbtnMCabin;
	JRadioButton rdbtnFCabin;
	JRadioButton rdbtnGNCabin;
	private JLabel lblCabinGender;
	private JLabel lblAgeRange;
	private JLabel lblTo;
	private JLabel lblCapacity;
	private JLabel lblCampers;
	private JLabel lblCounselors;
	JButton btnSaveCabin;
	
	 JButton btnCancel;
	
	static List<Cabin> cabinList= new ArrayList<Cabin>();
	static List<Cabin> cabinList2= new ArrayList<Cabin>();
	
/*
 * Two lists are created that are static as they need to be accessible to all classes. 
 * A cabin with anyone assigned to it is removed from the 2nd list, and certain changes cannot be made to it and it
 * cannot be deleted.  The cabin is added back to the 2nd list if everyone is removed from it and can be deleted. 
 */
	
	 JComboBox comboBoxAgeMin;

	 JComboBox comboBoxAgeMax;
	 JComboBox comboBoxCampers;
	 JComboBox comboBoxCounselors;
	
	static JFrame frame;
	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public NewCabin() {
		
		ArrayList<JComboBox> boxList= new ArrayList<JComboBox>();
		
		
		
		
		
		
		
	
		
		
		
		
		
		
	
		
		
		
		setBorder(new EmptyBorder(20,30,20,50));
		setLayout(new GridBagLayout());
		
		 GridBagConstraints c= new GridBagConstraints();
		 c.gridx= 0;
	     c.gridy= 0;
	     c.insets= new Insets(10,0,0,0);
	    
	     lblCreateNewCabin= new JLabel("Cabin Information");
	     lblCreateNewCabin.setForeground(Color.BLUE);
	     lblCreateNewCabin.setFont(new Font("Tahoma", Font.BOLD, 30));
	     add(lblCreateNewCabin,c);
	     
	     GridBagConstraints c1= new GridBagConstraints();
	     c1.gridx= 0;
	     c1.gridy= 1;
	    
	     c1.insets= new Insets(40,-150,0,0);
	    
	     lblCabinName= new JLabel("Cabin Name");
	     lblCabinName.setForeground(Color.BLUE);
	     lblCabinName.setFont(new Font("Tahoma", Font.BOLD, 20));
	     add(lblCabinName, c1);
	     
	     GridBagConstraints c2= new GridBagConstraints();
	     c2.gridx= 0;
	     c2.gridy=2;
	     c2.ipadx= 200;
	     c2.ipady= 10;
	     c2.insets= new Insets(10,-60,0,0);
	    
	     textFieldCabinName= new JTextField();
	     
	     textFieldCabinName.setFont(new Font("Tahoma", Font.PLAIN, 15));
	     add(textFieldCabinName, c2);
	     
	     GridBagConstraints c3= new GridBagConstraints();
	     c3.gridx= 0;
	     c3.gridy= 3;
	     c3.insets= new Insets(20,-135,0,0);
	    
	     lblCabinGender= new JLabel("Cabin Gender");
	     lblCabinGender.setForeground(Color.BLUE);
	     lblCabinGender.setFont(new Font("Tahoma", Font.BOLD, 20));
	     add(lblCabinGender, c3);
	     
	     GridBagConstraints c4= new GridBagConstraints();
	     c4.gridx= 0;
	     c4.gridy= 4;
	     c4.insets= new Insets(10,-205,0,0);
	    
	     rdbtnMCabin= new JRadioButton("MALE",true);
	    
	     add(rdbtnMCabin, c4);
	     
	     GridBagConstraints c5= new GridBagConstraints();
	     c5.gridx=1;
	     c5.gridy=4;
	     c5.insets= new Insets(10,-405,0,0);
	     
	     rdbtnFCabin= new JRadioButton("FEMALE");
	     
	     add(rdbtnFCabin, c5);
	     
	     GridBagConstraints c6= new GridBagConstraints();
	     c6.gridx=2;
	     c6.gridy=4;
	     c6.insets= new Insets(10,-260,0,0);
	    
	     rdbtnGNCabin= new JRadioButton("GENDER NEUTRAL");
	    
	     add(rdbtnGNCabin,c6);
	     
	     ButtonGroup bGroup= new ButtonGroup();
	     bGroup.add(rdbtnFCabin);
	     bGroup.add(rdbtnMCabin);
	     bGroup.add(rdbtnGNCabin);
	     
	     ArrayList<JRadioButton>rdbtnList=new ArrayList<JRadioButton>();
	     rdbtnList.addAll(Arrays.asList(rdbtnMCabin, rdbtnFCabin,rdbtnGNCabin));
	     
	     for(JRadioButton rb: rdbtnList){
	    	 rb.setBackground(Color.GRAY);
	    	 rb.setForeground(Color.WHITE);
	     }
	     
	     GridBagConstraints c7= new GridBagConstraints();
	     c7.gridx=0;
	     c7.gridy=5;
	     c7.insets= new Insets(20,-155,0,0);
	     
	     lblAgeRange= new JLabel("Age Range");
	     lblAgeRange.setForeground(Color.BLUE);
	     lblAgeRange.setFont(new Font("Tahoma", Font.BOLD, 20));
	     add(lblAgeRange, c7);
	     
	     GridBagConstraints c8= new GridBagConstraints();
	     c8.gridx=0;
	     c8.gridy=6;
	     c8.insets= new Insets(5,-210,0,0);
	    
	     comboBoxAgeMin = new JComboBox();
	    
		 comboBoxAgeMin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 comboBoxAgeMin.setModel(new DefaultComboBoxModel(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}));
		
	     add(comboBoxAgeMin,c8);
	     
	     GridBagConstraints c9= new GridBagConstraints();
	     c9.gridx= 1;
	     c9.gridy= 6;
	     c9.insets= new Insets(5,-485,0,0);
	     lblTo= new JLabel("-");
	     lblTo.setForeground(Color.BLUE);
	     lblTo.setFont(new Font("Tahoma", Font.PLAIN, 40));
	     add(lblTo, c9);
	     
	     GridBagConstraints c10= new GridBagConstraints();
	     c10.gridx=2;
	     c10.gridy=6;
	     c10.insets=new Insets(5,-470,0,0);
	     
	     comboBoxAgeMax = new JComboBox();
	    
		 comboBoxAgeMax.setFont(new Font("Tahoma", Font.PLAIN, 20));
	     comboBoxAgeMax.setModel(new DefaultComboBoxModel(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}));
		 
		 add(comboBoxAgeMax, c10);
		 
		 GridBagConstraints c11= new GridBagConstraints();
		 c11.gridx=0;
		 c11.gridy=7;
		 c11.insets= new Insets(5,-175,0,0);
		 lblCapacity= new JLabel("Capacity");
		
		 lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 20));
		 add(lblCapacity, c11);
		 lblCapacity.setForeground(Color.BLUE);
		 GridBagConstraints c12= new GridBagConstraints();
		 c12.gridx=0;
		 c12.gridy=8;
		 c12.insets= new Insets(10,-205,0,0);
		 
		 comboBoxCampers = new JComboBox();
		 
		 comboBoxCampers.setModel(new DefaultComboBoxModel(new Integer[] {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}));
		 comboBoxCampers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 
		 add(comboBoxCampers,c12);
		 
		 GridBagConstraints c13= new GridBagConstraints();
		 c13.gridx=1;
		 c13.gridy=8;
		 c13.insets= new Insets(25,-425,0,0);
		 
		 lblCampers= new JLabel("Campers");
		 lblCampers.setFont(new Font("Tahoma", Font.BOLD, 14));
		 lblCampers.setForeground(Color.BLUE);
		 add(lblCampers,c13);
		 
		 GridBagConstraints c14= new GridBagConstraints();
		 c14.gridx=2;
		 c14.gridy=8;
		 c14.insets= new Insets(10,-375,0,0);

		comboBoxCounselors = new JComboBox();
		
		comboBoxCounselors.setModel(new DefaultComboBoxModel(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}));
		comboBoxCounselors.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
		add(comboBoxCounselors, c14);
		 
		GridBagConstraints c15= new GridBagConstraints();
		c15.gridx=3;
		c15.gridy=8;
		c15.insets= new Insets(30,-230,0,0);
		
		lblCounselors= new JLabel("Counselors");
		lblCounselors.setFont(new Font("Tahoma", Font.BOLD, 14));
		 lblCounselors.setForeground(Color.BLUE);
	    add(lblCounselors,c15);
	    
	    GridBagConstraints c16= new GridBagConstraints();
	    c16.gridx=0;
	    c16.gridy=9;
	    c16.insets= new Insets(30,0,0,0);
	    btnSaveCabin= new JButton("SAVE");
	  
	   
	    add(btnSaveCabin,c16);
	    
	    GridBagConstraints c17= new GridBagConstraints();
	    c17.gridx=1;
	    c17.gridy=9;
	    c17.insets=new Insets(30, 0,0,0);
	    
	    btnCancel= new JButton("CANCEL");
	 
	    add(btnCancel,c17);
	    
	    boxList.addAll(Arrays.asList(comboBoxAgeMin, comboBoxAgeMax, comboBoxCampers, comboBoxCounselors));
	    
	    if(Home.colorful==true){
	    	setBackground(new Color(0, 0, 0));
	    	   btnCancel.setBackground(new Color(153, 50, 204));
	   	    btnCancel.setForeground(new Color(255, 255, 0));
	   	 btnSaveCabin.setBackground(new Color(153, 50, 204));
		    btnSaveCabin.setForeground(new Color(255, 255, 0));
		    lblCounselors.setForeground(new Color(153, 50, 204));
		    lblCampers.setForeground(new Color(153, 50, 204));
		    lblCapacity.setForeground(new Color(127, 255, 0));
		    lblTo.setForeground(new Color(127, 255, 0));
		    lblAgeRange.setForeground(new Color(127, 255, 0));
		    rdbtnGNCabin.setForeground(new Color(153, 50, 204));
		     rdbtnGNCabin.setBackground(Color.YELLOW);
		     rdbtnFCabin.setForeground(new Color(153, 50, 204));
		     rdbtnFCabin.setBackground(Color.YELLOW);
		     rdbtnMCabin.setForeground(new Color(153, 50, 204));
		     rdbtnMCabin.setBackground(Color.YELLOW);
		     lblCabinName.setForeground(new Color(127, 255, 0));
		     lblCabinGender.setForeground(new Color(127, 255, 0));
		     textFieldCabinName.setForeground(new Color(153, 50, 204));
		     textFieldCabinName.setBackground(new Color(255, 255, 0));
		     lblCreateNewCabin.setForeground(new Color(153, 50, 204));
		     
		     for(JComboBox cb: boxList){
		    	 cb.setForeground(new Color(153, 50, 204));
		    	 cb.setBackground(Color.YELLOW);
		    	 
		     }
	    }
	    
		
		//Delete below this line to show just the frame with no functions
	    
	    //cabinExists=false;
	    addListeners();
		 
		 
		 
		 
		 
	    
	     
	     
	     
	   
	     
	    		 
		
	
}
	
	//public static void main(String[] args){
		//createNewCabinDisplay();
		
//	}
	 public static void createNewCabinDisplay()
	    {
	        frame = new JFrame("CREATE CABIN");
	        
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.getContentPane().add(new NewCabin());
	        frame.pack();
	        frame.setLocationByPlatform( true );
	        frame.setLocationRelativeTo(null);
	      //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        frame.setVisible( true );
	    }
	private void saveCabin(){
		
		
		
		
		
		if((Integer)comboBoxAgeMin.getSelectedItem()<=(Integer)comboBoxAgeMax.getSelectedItem()){
		
			
			cabin1= new Cabin(textFieldCabinName.getText(),rdbtnMCabin.isSelected() ? 'M': rdbtnFCabin.isSelected() ? 'F': rdbtnGNCabin.isSelected() ? 'N': null,
					(Integer)comboBoxAgeMin.getSelectedItem(), (Integer)comboBoxAgeMax.getSelectedItem());
					
					
					cabin1.setCapacity((Integer)comboBoxCampers.getSelectedItem());
					cabin1.setNumCounselors((Integer)comboBoxCounselors.getSelectedItem());
		cabinList.add(cabin1);
		cabinList2.add(cabin1);
		int response=JOptionPane.showConfirmDialog(null,"CABIN CREATED SUCCESSFULLY! Would you like to create a new Cabin?","SUCCESS", JOptionPane.YES_NO_OPTION);
		if(response==JOptionPane.YES_OPTION){
			
			frame.dispose();
			
			NewCabin cabin1= new NewCabin();
			cabin1.setVisible(true);
			cabin1.createNewCabinDisplay();
			}
		else{
			frame.dispose();
		}
			
		
		}
		else {
			JOptionPane.showMessageDialog(null, "THE 2ND AGE MUST BE GREATER THAN THE FIRST AGE!");
		}
		
		
		}
	private void addListeners(){
		btnSaveCabin.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		saveCabin();
	    	}
	    });
		btnCancel.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		frame.dispose();
	    	}
	    });
	}
	
	public void editCabin(Cabin cabin){
		cabin.setCapacity((Integer)comboBoxCampers.getSelectedItem());
		cabin.setNumCounselors((Integer)comboBoxCounselors.getSelectedItem());
		cabin.setCabinName(textFieldCabinName.getText());
		cabin.setAgeMin((Integer)(comboBoxAgeMin.getSelectedItem()));
		cabin.setAgeMax((Integer)(comboBoxAgeMax.getSelectedItem()));
		cabin.setGender(rdbtnMCabin.isSelected() ? 'M': rdbtnFCabin.isSelected() ? 'F': rdbtnGNCabin.isSelected() ? 'N': null);
		cabinList.set(cabinList.indexOf(cabin), cabin);
		cabinList2.set(cabinList.indexOf(cabin), cabin);
		
		
		
		JOptionPane.showMessageDialog(null, "Cabin changes saved successfully!");
	}
	
	}
	

	