/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabin.assigner.pro;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Camp extends JPanel implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = -626604067355754848L;
	protected final static DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/dd/yyyy");
                   private int campNumber;
                   private int campSessionNumber;

    public int getCampNumber() {
        return campNumber;
    }

    public void setCampNumber(int campNumber) {
        this.campNumber = campNumber;
    }

    public int getCampSessionNumber() {
        return campSessionNumber;
    }

    public void setCampSessionNumber(int campSessionNumber) {
        this.campSessionNumber = campSessionNumber;
    }
	

	
	
	
	
	
		/*
		 *Camp name and camp slogan are not currently being used.  They will be added to a function where
		 *the user can print a master list and it shows the camp name and slogan at the top of the sheet.  
		 */
		
	

	

	public void setCampDate(String cDate) {
		CampInformation.dateOfCamp= checkFormat(cDate);
		
		
	}
	public void setDateString(String date){
		CampInformation.campDateString= date;
	}


	
	public void setCampName(String campName){
		CampInformation.nameOfCamp= campName;
	}
	

	public void setCampSlogan(String campSlogan){
		CampInformation.sloganOfCamp= campSlogan;
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
	

}