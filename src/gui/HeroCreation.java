

package gui;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class HeroCreation extends GridPane 
{
    public TextField txtVerdediging;
    public TextField txtKracht;
    public TextField txtSnelheid;
    public TextField txtAlertheid;
    public TextField txtNaam;
    
    public Label lblVerdediging = new Label("Verdediging");
    public Label lblKracht = new Label("Kracht");
    public Label lblSnelheid  = new Label("Snelheid");
    public Label lblAlertheid  = new Label("Alertheid");
    public Label lblNaam  = new Label("Naam");
    
    public int punten = 5; 
    public int verdediging = 1;
    public int kracht = 1;
    public int snelheid = 1;
    public int alertheid = 1;
    
    
    
    
    
    public HeroCreation()
    {
        Image image = new Image(getClass().getResourceAsStream("resources/Hero.jpg").toString());
        Label lblHeld = new Label("hero", new ImageView(image));
        
        HBox hVerdediging = new HBox();
        HBox hKracht = new HBox();
        HBox hSnelheid = new HBox();
        HBox hAlertheid = new HBox();
        Button nextImage = new Button(">");
        Button previousImage = new Button("<");
        Button verdedigingPlus = new Button("+");
        Button verdedigingMin = new Button("-");
        Button krachtPlus = new Button("+");
        Button krachtMin = new Button("-");
        Button snelheidPlus = new Button("+");
        Button snelheidMin = new Button("-");
        Button alertheidPlus = new Button("+");
        Button alertheidMin = new Button("+");
        Button createHero = new Button("create Hero");
        
        hVerdediging.getChildren().addAll(lblVerdediging, txtVerdediging);
        hKracht.getChildren().addAll(lblKracht, txtKracht);
        hSnelheid.getChildren().addAll(lblSnelheid, txtSnelheid);
        hAlertheid.getChildren().addAll(lblAlertheid, txtAlertheid);
        
        add(previousImage, 0, 0);
        add(lblHeld, 1, 0);
        add(nextImage, 2, 0);
        add(verdedigingMin, 0, 1);
        add(hVerdediging, 1, 1);
        add(verdedigingPlus, 2, 1);
        add(krachtMin, 0, 2);
        add(hKracht, 1, 2 );
        add(krachtPlus, 2, 2);
        add(snelheidMin, 0, 3);
        add(hSnelheid, 1, 3);
        add(snelheidPlus, 2, 3);
        add(alertheidMin, 0, 4);
        add(hAlertheid, 1, 4);
        add(alertheidPlus, 2, 4);
        add(createHero, 1, 5);
        
        
        
    }
}
