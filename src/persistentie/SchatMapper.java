package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import domein.Schat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anke
 */
public class SchatMapper 
{
     private static final String JDBC_URL =
           "jdbc:mysql://localhost:3306/rpg?user=rpg&password=rpg";
     public boolean pasSchatAan(Schat schat)
     {
    try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryUpdateMonster = conn.prepareStatement("UPDATE SCHAT SET , WHERE IDSCHAT = ? OMSCHRIJVING = ? WAARDE = ?");
            queryUpdateMonster.setInt(1, schat.getIdSchat());
            queryUpdateMonster.setString(2, schat.getOmschrijving());
            queryUpdateMonster.setInt(3, schat.getWaarde());
            queryUpdateMonster.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
     }
     //voeg schat toe
     public boolean voegSchatToe(Schat schat)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryNieuweSchat = conn.prepareStatement("INSERT INTO SCHAT VALUES (?, ?, ?)");
            queryNieuweSchat.setInt(1, schat.getIdSchat());
            queryNieuweSchat.setString(2, schat.getOmschrijving());
            queryNieuweSchat.setInt(3, schat.getWaarde());
            queryNieuweSchat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }
     //zoek schat
     public Schat zoekSchat(int teZoekenIdSchat)
    {
        Schat schat = null;

        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryZoekSchat = conn.prepareStatement("SELECT FROM SCHAT WHERE IDSCHAT = ?");
            queryZoekSchat.setInt(1, teZoekenIdSchat);
            try (ResultSet rs = queryZoekSchat.executeQuery()) {
                if (rs.next()) { // Als er een resultaat gevonden is.
                    int idschat = rs.getInt("IDSCHAT");
                    String omschrijving = rs.getString("OMSCHRIJVING");
                    int waarde = rs.getInt("WAARDE");
                    schat = new Schat(idschat, omschrijving, waarde);
                }
            }
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }

        return schat;
    }
     // zoek alle schatten
     public List<Schat> zoekAlleSchatten()
    {
        List<Schat> schatten = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryAlleSchatten = conn.prepareStatement("SELECT * FROM SCHAT");
            try (ResultSet rs = queryAlleSchatten.executeQuery()) {
                while (rs.next()) {
                   int idschat = rs.getInt("IDSCHAT");
                    int waarde = rs.getInt("WAARDE");
                    String omschrijving = rs.getString("OMSCHRIJVING");
                    schatten.add(new Schat (idschat, omschrijving, waarde));
                    
                }
            }
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }

        return schatten;
    }
     // verwijder schat
     public boolean verwijderSchat(Schat schat)
    {
        return verwijderSchat(schat.getIdSchat());
    }
     
     public boolean verwijderSchat(int idschat)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryVerwijderSchat = conn.prepareStatement("DELETE FROM SCHAT WHERE IDSCHAT = ?");
            queryVerwijderSchat.setInt(1, idschat);
            queryVerwijderSchat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }
    
}
