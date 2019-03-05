/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cabin.assigner.pro.Home;
import cabin.assigner.pro.Camper;
import cabin.assigner.pro.NewCamper;
import cabin.assigner.pro.NewCabin;
import cabin.assigner.pro.Cabin;
import cabin.assigner.pro.EditDeleteCamper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.UnsupportedLookAndFeelException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kenneth
 */
public class DatabaseUnitTests {
    
  @Test
  public void checkCampIDAndPin() 
          throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException, IOException{
      Home home= new Home();
      home.databaseLink(1, "6329");
      assertEquals(1, home.getMySQLcampID());
  }
  
  @Test
  public void checkCampIDandFalsePinVerifyZero()
          throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException, IOException{
     Home home= new Home();
      home.databaseLink(1, "4444");
      assertEquals(0, home.getMySQLcampID());
}
  @Test
  public void checkSessionLinkCorrespondsToCamp()
          throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
      Home home= new Home();
      home.databaseLink(1, "6329");
      home.campSessionLink(1);
      assertEquals(1, home.getMySQLcampID() );
      assertEquals(1, home.getMySQLsessionID());
  }
@Test
  public void checkSessionNotFoundWithCamp()
          throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
      Home home= new Home();
      home.databaseLink(1, "6329");
      home.campSessionLink(3);
      //assertEquals(1, home.getMySQLcampID());
      assertEquals(0, home.getMySQLsessionID());
  }
 
 
 
 @Test
 public void removeCamperFromDatabaseVerifyListSizeZero()
         throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
     Home home= new Home();
      home.databaseLink(1, "6329");
      home.campSessionLink(1);
      
      
      Camper camper;
      camper = new Camper("Fred", "Plucker", 'M');
      NewCamper.camperList.add(camper);
      NewCamper.camperList2.add(camper);
      camper.setDob("04/01/2010");
      
      Camper camper2;
      camper2= new Camper("Joseph", "Smith", 'M');
      camper2.setDob("03/05/2010");
      NewCamper.camperList.add(camper2);
      
      home.insertCampersToDatabase();
      
      EditDeleteCamper.camperDeletedList.add(camper.getCamperNumber());
      EditDeleteCamper.camperDeletedList.add(camper2.getCamperNumber());
      System.out.println(EditDeleteCamper.camperDeletedList);
      
      home.removeDeletedCampers();
      
      System.out.println(EditDeleteCamper.camperDeletedList);
      assertEquals(0, EditDeleteCamper.camperDeletedList.size());
 }
 @Test
 public void verifyImportedCamperFromMySQLisSuccessful() throws ClassNotFoundException, InstantiationException, 
         IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
     
     //Camper 174 must be cleared from camperSessionLink table for this test to work. 
     
     Home home= new Home();
      home.databaseLink(1, "6329");
      home.campSessionLink(1);
    
      home.importCamperFromMySQL(174, "Mann");
 
      System.out.println(NewCamper.camperList);

 }
 


   
}
