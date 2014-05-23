package persistentie;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Schat     
{
   private static final String JDBC_URL =
           "jdbc:mysql://localhost:3306/rpg?user=rpg&password=rpg";
   
   public static void main (String [] args)
   {     //alles hieronder tussen de haken naast try staan hier zodat dit weer afsluit na draaien (noemt try met recources)
      try (Connection conn = DriverManager.getConnection(JDBC_URL)){ 
          
           //toevoegen item
            PreparedStatement queryNieuweSchat =
                    conn.prepareStatement("INSERT INTO SCHAT VALUES (?)");
            
            queryNieuweSchat.setInt(1, 1);
            queryNieuweSchat.executeUpdate();
            
          // iet anders item
            
            PreparedStatement queryZoekAlleSchatten=
                    conn.prepareStatement("SELECT * FROM SCHAT");
             //nogmaals zelfde principe als de 'try' hierboven
            try (ResultSet rs = queryZoekAlleSchatten.executeQuery()){
                     //rij uitlzen
            while (rs.next()) {
                int idschat = rs.getInt(1); // of rs.getInt("NR")
               
                
                System.out.printf("Schat gevonder met nummer %d %n",
                        idschat );
            }
            }
            
           //verwijder item 
         PreparedStatement queryVerwijderSchat =
                 conn.prepareStatement(" DELETE FROM SCHAT WHERE NR = ?");
         queryVerwijderSchat.setInt(1,1);
         queryVerwijderSchat.executeUpdate();
              
         
      } catch (SQLException ex) {
          Logger.getLogger(Schat.class.getName()).log(Level.SEVERE,null ,ex);
      }
   }
}