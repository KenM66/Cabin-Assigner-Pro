/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class CamperCabinList extends JPanel{
	
	JScrollPane cellListPane;
	static JTable camperCabinListTable;
	JScrollPane cellListPaneCounselors;
	static JTable counselorCabinListTable;
	private JButton printCampers;
	private JButton printCounselors;
	
	
	CamperCabinList(){
	setBorder( new EmptyBorder(20, 200, 20, 200) );

	//add(scrollBar);
	 
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    JLabel camperListHeader= new JLabel("Cabin Lists");
    camperListHeader.setForeground(Color.BLUE);
    camperListHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
    camperListHeader.setAlignmentX(0.5f);
    add(camperListHeader);
    add(Box.createVerticalStrut(20));
    
    cellListPane= new JScrollPane();
   
    
   
    
 
    camperCabinListTable= new JTable(tm(AssignToCabin.cabinMap));
    camperCabinListTable.setForeground(Color.BLUE);
    camperCabinListTable.setBackground(Color.WHITE);
    RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tm(AssignToCabin.cabinMap));
    RowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(tm2(AssignToCabin.cabinCounselorMap));
    camperCabinListTable.setRowSorter(sorter);
    camperCabinListTable.setAutoCreateRowSorter(true);
    
    cellListPane.setViewportView(camperCabinListTable);
    
    add(cellListPane);
    cellListPane.setPreferredSize(new Dimension(400,250));
    
    cellListPane.setBorder(BorderFactory.createTitledBorder (CampInformation.nameOfCamp +"-Campers   "+CampInformation.sloganOfCamp));
    
    add(Box.createVerticalStrut(10));
    
    cellListPaneCounselors= new JScrollPane();
    counselorCabinListTable= new JTable(tm2(AssignToCabin.cabinCounselorMap));
    counselorCabinListTable.setForeground(Color.BLUE);
    counselorCabinListTable.setRowSorter(sorter2);
    
    cellListPaneCounselors.setBorder(BorderFactory.createTitledBorder (CampInformation.nameOfCamp +"-Counselors   "+CampInformation.sloganOfCamp));
    
    cellListPaneCounselors.setViewportView(counselorCabinListTable);
    
    add(cellListPaneCounselors);
    cellListPaneCounselors.setPreferredSize(new Dimension(400,250));
    
    counselorCabinListTable.setAutoCreateRowSorter(true);
    
    //System.out.println(AssignToCabin.cabinMap);
    
    add(Box.createVerticalStrut(10));
    
    printCampers= new JButton("PRINT CAMPER LIST");
    printCampers.setFont(new Font("Tahoma", Font.BOLD, 13));
  
    printCampers.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		printTable(camperCabinListTable);
    	}
    });
    
    add(Box.createVerticalStrut(10));
    printCampers.setAlignmentX(0.5f);
    add(printCampers);
    
    printCounselors= new JButton("PRINT COUNSELOR LIST");
   
    printCounselors.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		printTable(counselorCabinListTable);
    	}
    });
    add(Box.createVerticalStrut(10));
    add(printCounselors);
    
    	 
		
		
				
		
   
   
    printCounselors.setAlignmentX(0.5f);
    
  
    
    
   
    
	
	}
	
	 public static void createAndShowList() throws PrinterException
	    {
	        JFrame frame = new JFrame("Cabin List: Campers");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.getContentPane().add(new CamperCabinList());
	        frame.pack();
	        frame.setLocationByPlatform( true );
	        frame.setLocationRelativeTo(null);
	     // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        frame.setVisible( true );
	    }
	

	//public static void main(String[] args) {
		
	//	createAndShowList();
		

	//}
	
	public static TableModel tm(Map<?,?> map){
		DefaultTableModel model= new DefaultTableModel(
				new Object[]{"CAMPER", "CABIN"}, 0);
		        for(Map.Entry<?,?> entry: map.entrySet()) {
			    
		        Object cabin = entry.getKey();
		        Set campers = (Set) entry.getValue();
		 
		        for (Object camper: campers) {
		        	
		         model.addRow(new Object[] {camper, cabin});
		        }
		       
		    }
	    	 return model;
	}
	
	public static TableModel tm2(Map<?,?> map){
		DefaultTableModel model= new DefaultTableModel(
				new Object[]{"COUNSELOR", "CABIN"}, 0);
		        for(Map.Entry<?,?> entry: map.entrySet()) {
			    
		        Object cabin = entry.getKey();
		        Set counselors = (Set) entry.getValue();
		 
		        for (Object counselor: counselors) {
		        	
		         model.addRow(new Object[] {counselor, cabin});
		        }
		       
		    }
	    	 return model;
		
	}
	private static void printTable(JTable table){

	            try {
	             
				MessageFormat headerFormat = new MessageFormat(CampInformation.nameOfCamp+" Cabin Assignment List");
	              MessageFormat footerFormat = new MessageFormat("- {0} -");
	              table.print(JTable.PrintMode.NORMAL, headerFormat, footerFormat);
	            } catch (PrinterException pe) {
	              System.err.println("Error printing: " + pe.getMessage());
	            }
	          }
	}
