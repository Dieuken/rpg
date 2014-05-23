
package domein;

import java.util.List;

/**
 *
 * @author Anke
 */
public class Held 
{
    private int waarde;
    private int kracht;
    private int verdediging;
    private int snelheid;
    private int alertheid;
    private String naam;
    private String image;
    private List<Item> items;

    public Held()
    {
        
    }
    
    public Held (int kracht, int verdediging, 
            int snelheid, int alertheid, String naam, 
            int iditems) 
    {
       
        this.kracht = kracht;
        this.verdediging = verdediging;
        this.snelheid = snelheid;
        this.alertheid = alertheid;
        this.naam = naam;
        
    }

    public int getKracht() {
        return kracht;
    }

    public void setKracht(int kracht) {
        this.kracht = kracht;
    }

    public int getVerdediging() {
        return verdediging;
    }

    public void setVerdediging(int verdediging) {
        this.verdediging = verdediging;
    }

    public int getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int snelheid) {
        this.snelheid = snelheid;
    }

    public int getAlertheid() {
        return alertheid;
    }

    public void setAlertheid(int alertheid) {
        this.alertheid = alertheid;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getImage() {
        return image;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    
    
}
