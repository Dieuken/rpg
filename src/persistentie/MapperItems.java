package persistentie;

import domein.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper voor de klasse Schat. Deze klasse ondersteunt de volgende CRUD-bewerkingen:
 * - Schatten toevoegen.
 * - Schatten opvragen.
 * - Schatten wijzigen.
 * - Schatten verwijderen.
 */
public class MapperItems
{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/rpg?user=rpg&password=rpg";

    /*
     * Voegt een nieuwe items toe aan de databank.
     * De returnwaarde geeft aan of de bewerking geslaagd is.
     */
    public boolean voegItemsToe(Item item)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryNieuweItem = conn.prepareStatement("INSERT INTO ITEM VALUES (?,?,?,?)");
            queryNieuweItem.setInt(1, item.getIditems());
            queryNieuweItem.setString(2, item.getNaam());
            queryNieuweItem.setInt(3, item.getWaarde());
            queryNieuweItem.setString(4, item.getOmschrijving());
            queryNieuweItem.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }

    /*
     * Zoekt de items met het opgegeven nummer op in de databank.
     * Geeft null terug indien er geen item met dit nummer werd gevonden.
     */
    public Item zoekItems(int teZoekenNummer)
    {
        Item item = null;

        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryZoekItem = conn.prepareStatement("SELECT FROM ITEM WHERE ITEMID = ?");
            queryZoekItem.setInt(1, teZoekenNummer);
            try (ResultSet rs = queryZoekItem.executeQuery()) {
                if (rs.next()) { // Als er een resultaat gevonden is.
                    int iditems = rs.getInt("ID");
                    String naam = rs.getString("NAAM");
                    int waarde = rs.getInt("WAARDE");
                    String omschrijving = rs.getString("OMSCHRIJVING");
                    item = new Item(iditems, naam, waarde , omschrijving);
                }
            }
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }

        return item;
    }

    /*
     * Zoekt alle items op in de databank.
     */
    public List<Item> zoekAlleItems()
    {
        List<Item> items = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryAlleItems = conn.prepareStatement("SELECT * FROM ITEM");
            try (ResultSet rs = queryAlleItems.executeQuery()) {
                while (rs.next()) {
                    int iditems = rs.getInt("IDITEMS");
                    String naam = rs.getString("NAAM");
                    int waarde = rs.getInt("WAARDE");
                    String omschrijving = rs.getString("OMSCHRIJVING");
                    items.add(new Item(iditems, naam, waarde , omschrijving));
                }
            }
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
        }

        return items;
    }

    /*
     * Past een bestaand item aan in de databank.
     * De returnwaarde geeft aan of de bewerking geslaagd is.
     */
    public boolean pasItemAan(Item item)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryUpdateItem = conn.prepareStatement("UPDATE ITEM SET , WHERE IDITEMS = ? NAAM = ? WAARDE = ? OMSCHRIJVING = ?");
            queryUpdateItem.setInt(1, item.getIditems());
            queryUpdateItem.setString(2, item.getNaam());
            queryUpdateItem.setInt(3, item.getWaarde());
            queryUpdateItem.setString(4, item.getOmschrijving());           
            queryUpdateItem.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }

    /*
     * Verwijdert de opgegeven item uit de databank.
     * De returnwaarde geeft aan of de bewerking geslaagd is.
     */
    public boolean verwijderItem(Item item)
    {
        return verwijderItem(item.getIditems());
    }

    /*
     * Verwijdert het item met het opgegeven nummer uit de databank.
     * De returnwaarde geeft aan of de bewerking geslaagd is.
     */
    public boolean verwijderItem(int iditems)
    {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            PreparedStatement queryVerwijderItem = conn.prepareStatement("DELETE FROM ITEM WHERE IDITEMS = ?");
            queryVerwijderItem.setInt(1, iditems);
            queryVerwijderItem.executeUpdate();
            return true;
        } catch (SQLException ex) {
            for (Throwable t : ex) {
                t.printStackTrace();
            }
            return false;
        }
    }
}
