package persistentie;

import domein.Monster;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MonsterMapper
{
   private static final String JDBC_URL =
           "jdbc:mysql://localhost:3306/rpg?user=rpg&password=rpg";

public boolean voegMonsterToe(Monster monster)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryNieuweMonster = conn.prepareStatement("INSERT INTO MONSTER VALUES (?, ?, ?, ?, ?, ?, ?)");
            queryNieuweMonster.setInt(1, monster.getIdmonster());
            queryNieuweMonster.setInt(2, monster.getKracht());
            queryNieuweMonster.setInt(3, monster.getVerdediging());
            queryNieuweMonster.setInt(4, monster.getSnelheid());
            queryNieuweMonster.setInt(5, monster.getAlertheid());
            queryNieuweMonster.setString(6, monster.getNaam());
            queryNieuweMonster.setInt(7, monster.getIdschat());
            
            queryNieuweMonster.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }

    
     // Zoekt  specifiek monster
    
    public Monster zoekMonster(int teZoekenIdmonster)
    {
        Monster monster = null;

        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryZoekMonster = conn.prepareStatement("SELECT FROM MONSTER WHERE IDMONSTER = ?");
            queryZoekMonster.setInt(1, teZoekenIdmonster);
            try (ResultSet rs = queryZoekMonster.executeQuery()) {
                if (rs.next()) { // Als er een resultaat gevonden is.
                    int idmonster = rs.getInt("IDMONSTER");
                    int kracht = rs.getInt("KRACHT");
                    int verdediging = rs.getInt("VERDEDIGING");
                    int snelheid = rs.getInt("SNELHEID");
                    int alertheid = rs.getInt("ALERTHEID");
                    String naam = rs.getString("NAAM");
                    int idschat = rs.getInt("IDSCHAT");
                    
                    monster = new Monster(idmonster, kracht, verdediging , snelheid , alertheid, naam, idschat);
                }
            }
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }

        return monster;
    }

    //Zoekt alle monsters op in de databank.
     
    public List<Monster> zoekAlleMonsters()
    {
        List<Monster> monsters = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryAlleMonsters = conn.prepareStatement("SELECT * FROM MONSTER");
            try (ResultSet rs = queryAlleMonsters.executeQuery()) {
                while (rs.next()) {
                   int idmonster = rs.getInt("IDMONSTER");
                    int kracht = rs.getInt("KRACHT");
                    int verdediging = rs.getInt("VERDEDIGING");
                    int snelheid = rs.getInt("SNELHEID");
                    int alertheid = rs.getInt("ALERTHEID");
                    String naam = rs.getString("NAAM");
                    int idschat = rs.getInt("IDSCHAT");
                    monsters.add(new Monster (idmonster, kracht, verdediging , snelheid , alertheid, naam, idschat));
                }
            }
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }

        return monsters;
    }

   // Aanpassen van monster
    public boolean pasMonsterAan(Monster monster)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryUpdateMonster = conn.prepareStatement("UPDATE MONSTER SET , WHERE IDMONSTER = ? KRACHT = ? VERDEDIGING = ? SNELHEID = ? ALERTHEID = ? NAAM = ? IDSCHAT = ?");
            queryUpdateMonster.setInt(1, monster.getIdmonster());
            queryUpdateMonster.setInt(2, monster.getKracht());
            queryUpdateMonster.setInt(3, monster.getVerdediging());
            queryUpdateMonster.setInt(4, monster.getSnelheid());
            queryUpdateMonster.setInt(5, monster.getAlertheid());
            queryUpdateMonster.setString(6, monster.getNaam());
            queryUpdateMonster.setInt(7, monster.getIdschat());
            queryUpdateMonster.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }

    // verwijdert monster
    public boolean verwijderMonster(Monster monster)
    {
        return verwijderMonster(monster.getIdmonster());
    }

    // verwijderd monsters en geeft aan als het verwijderd is
    public boolean verwijderMonster(int idmonster)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryVerwijderMonster = conn.prepareStatement("DELETE FROM MONSTER WHERE IDMONSTER = ?");
            queryVerwijderMonster.setInt(1, idmonster);
            queryVerwijderMonster.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }
}



