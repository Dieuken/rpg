

package domein; 
  
//import static java.time.Clock.system; 
import java.util.Random; 
import javax.swing.JOptionPane; 
import persistentie.MonsterMapper; 
import persistentie.SchatMapper; 
  
/** 
 * 
 * @author Anke 
 */
public class DomeinController { 
  
    Monster monster = null; 
    Held held = null; 
    Schat schat = null; 
    int aantalkamers = 0; 
    int vereistekamers = 5; 
    Random random = new Random(); 
  
    public void startGame(String naamtextbox) { 
  
        aantalkamers = 0; 
        vereistekamers = 5; 
  
        // controlleren 4 atributen + niet meer dan aantal punten 
        int kracht = 8; 
        int verdediging = 8; 
        int snelheid = 8; 
        int alertheid = 8; 
        while ((kracht + verdediging + snelheid + alertheid) > 8) { 
            kracht = random.nextInt(8) + 1; 
            verdediging = random.nextInt(8) + 1; 
            snelheid = random.nextInt(8) + 1; 
            alertheid = random.nextInt(8) + 1; 
        } 
        //geef onze held een naam 
        String naam = naamtextbox; 
        held = new Held(1, kracht, verdediging, snelheid, alertheid, naam, 0); 
        //methode instappen in een kamer oproepen 
// instappen in een kamer 
        this.enterkamer(); 
    } 
  
            //speler verslaat monster 
    private void enterkamer() { 
aantalkamers = aantalkamers+1; 
              //monster en of schat 
        //random 1-3 lager dan 3 enkel monster tussen 3 en 6 monster en schat hoger dan 6 enkel schat 
        int n = random.nextInt(3) + 1; 
        System.out.print(n); 
        monster = null; 
        schat = null; 
          
        if (n < 3) { 
            MonsterMapper monsterMapper = new MonsterMapper(); 
            //id vullen met ne random monster id. haal aantal monsters uit db 
            int id = 1; 
            //haal monster uit db         
            monster = monsterMapper.zoekMonster(id); 
                //variabelen vergelijken 
            // als die atribuut van speler beter is krijgt hij eerste keus 
            if (held.getAlertheid() > monster.getAlertheid()) { 
                    //hey monster gevonden wat wilde doen ?  
                //als return lopen, check up snelheid 
                //als return vechten , kracht hero vergelijken met verdediging 
  
            } 
            //Als atribut slechter is  
            if (held.getAlertheid() < monster.getAlertheid()) { 
                //A monster has creeped  
                if (held.getKracht() > monster.getVerdediging()) { 
                    //Monster is verslagen proficiat ! 
                } 
            } 
  
                // situatie 2 speler is slecht 
            // situatie 3 is zijn gelijk (random) 
            //speler sterf game over  
        } 
        if (n > 1) { 
            //id vullen met ne random schat id. haal aantal schatten uit db 
            SchatMapper schatmapper = new SchatMapper(); 
            int id = 1; 
            schat = schatmapper.zoekSchat(id); 
            //proficiat u heet schat gevonden  
//Wilt u deze schat aanvaarden ? 
            //ja 
//schat aan held koppelen 
            //nee  
            // niets doen 
        } 
  
        if (aantalkamers > vereistekamers) { 
            this.eindespel(); 
        } 
    } 
  
    private void eindespel() { 
  
        // proficiat je hebt alle kamers voltooid opnieuw proberen ?   
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    } 
  
} 
