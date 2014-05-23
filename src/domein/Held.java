
package domein;

/**
 *
 * @author Anke
 */
public class Held 
{
    private int idheld;
    private int kracht;
    private int verdediging;
    private int snelheid;
    private int alertheid;
    private String naam;
    private int iditems;

    public Held (int idheld, int kracht, int verdediging, 
            int snelheid, int alertheid, String naam, 
            int iditems) 
    {
        this.idheld = idheld;
        this.kracht = kracht;
        this.verdediging = verdediging;
        this.snelheid = snelheid;
        this.alertheid = alertheid;
        this.naam = naam;
        this.iditems = iditems;
    }
    
    public int getIdheld() {
        return idheld;
    }

    public void setIdheld(int idmonster) {
        this.idheld = idmonster;
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

    public int getIditems() {
        return iditems;
    }

    public void setIditems(int iditems) {
        this.iditems = iditems;
    }
    
}
