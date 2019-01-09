/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cabin.assigner.pro.Home;
import java.sql.SQLException;
import javax.swing.UnsupportedLookAndFeelException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kenneth
 */
public class DatabaseUnitTests {
    
  @Test
  public void checkCampIDAndPin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
      Home home= new Home();
      home.databaseLink(1, "6329");
      assertEquals(1, home.getMySQLcampID());
  }
  
  @Test
  public void checkCampIDandFalsePinVerifyZero()throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
     Home home= new Home();
      home.databaseLink(1, "4444");
      assertEquals(0, home.getMySQLcampID());
}
  @Test
  public void checkSessionLinkCorrespondsToCamp()throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
      Home home= new Home();
      home.databaseLink(1, "6329");
      home.campSessionLink(1);
      assertEquals(1, home.getMySQLcampID() );
      assertEquals(1, home.getMySQLsessionID());
  }
@Test
  public void checkSessionNotFoundWithCamp()throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, SQLException{
      Home home= new Home();
      home.databaseLink(1, "6329");
      home.campSessionLink(3);
      //assertEquals(1, home.getMySQLcampID());
      assertEquals(0, home.getMySQLsessionID());
  }
   
}
