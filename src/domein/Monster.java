

package domein;

/**
 *
 * @author GJ
 */
public class Monster {
    
    private int idmonster;
    private int kracht;
    private int verdediging;
    private int snelheid;
    private int alertheid;
    private String naam;
    private int idschat;
   

    
    public Monster()
    {
        
    }
    
    public Monster(int idmonster, int kracht, int verdediging, int snelheid, int alertheid, String naam, int idschat) {
        this.idmonster = idmonster;
        this.kracht = kracht;
        this.verdediging = verdediging;
        this.snelheid = snelheid;
        this.alertheid = alertheid;
        this.naam = naam;
        this.idschat = idschat;
       
    }

    public int getIdmonster() {
        return idmonster;
    }

    public void setIdmonster(int idmonster) {
        this.idmonster = idmonster;
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

    public int getIdschat() {
        return idschat;
    }

    public void setIdschat(int idschat) {
        this.idschat = idschat;
    }
    
     @Override
    public String toString()
    {
        return naam;
    }
    
}
