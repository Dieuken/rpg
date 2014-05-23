

package gui;


import domein.Held;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HeroCreation extends BorderPane 
{
    public TextField txtVerdediging = new TextField();
    public TextField txtKracht = new TextField();
    public TextField txtSnelheid = new TextField();
    public TextField txtAlertheid = new TextField();
    public TextField txtNaam = new TextField();
    
    public Label lblVerdediging = new Label("Verdediging");
    public Label lblKracht = new Label("Kracht");
    public Label lblSnelheid  = new Label("Snelheid");
    public Label lblAlertheid  = new Label("Alertheid");
    public Label lblNaam  = new Label("Naam");
    public Label lblPunten = new Label("Te verdelen punten:");
    public Label lblTeverdelen = new Label();
    
    public int punten = 5; 
    public int verdediging = 10;
    public int kracht = 1;
    public int snelheid = 1;
    public int alertheid = 1;
    
    public Held held = new Held();
    
    
    
    
    
    public HeroCreation()
    {
        txtVerdediging.setText(Integer.toString(verdediging));
        txtVerdediging.setEditable(false);
        txtKracht.setText(Integer.toString(kracht));
        txtKracht.setEditable(false);
        txtSnelheid.setText(Integer.toString(snelheid));
        txtSnelheid.setEditable(false);
        txtAlertheid.setText(Integer.toString(alertheid));
        txtAlertheid.setEditable(false);
        lblTeverdelen.setText(Integer.toString(punten));
        
        this.setStyle("-fx-background-image: url('resources/download.jpg'); -fx-background-size: cover;");
        HBox hTop = new HBox();
        hTop.setPadding(new Insets(100,50,100,50));
        hTop.setStyle("-fx-background-image: url('resources/banner.png'); -fx-background-size: cover;");
        setTop(hTop);
        ImageView heroselector = new ImageView();
        heroselector.setImage(new Image("resources/hero.png"));
        
        VBox vLabels = new VBox();
        VBox vTextFields = new VBox();
        VBox vMinButtons = new VBox();
        VBox vPlusButtons = new VBox();
        
        vLabels.setSpacing(15);
        vTextFields.setSpacing(10);
        vMinButtons.setSpacing(10); 
        vPlusButtons.setSpacing(10); 
        
        HBox hImage = new HBox();
        HBox hNaam = new HBox();
        HBox hNumbers = new HBox();
        HBox hStats = new HBox();
        
        hImage.setSpacing(10);
        hNaam.setSpacing(10);
        hStats.setSpacing(10);
        
        Button nextImage = new Button(">");
        Button previousImage = new Button("<");
        Button verdedigingPlus = new Button("+");
        verdedigingPlus.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(punten >0)
                {
                    punten--;
                    verdediging++;
                    lblTeverdelen.setText(Integer.toString(punten));
                    txtVerdediging.setText(Integer.toString(verdediging));
                }
            }
        });
        Button verdedigingMin = new Button("-");
        verdedigingMin.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(verdediging >10)
                {
                    punten++;
                    verdediging--;
                    lblTeverdelen.setText(Integer.toString(punten));
                    txtVerdediging.setText(Integer.toString(verdediging));
                }
            }
        });
        Button krachtPlus = new Button("+");
        krachtPlus.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(punten >0)
                {
                    punten--;
                    kracht++;
                    lblTeverdelen.setText(Integer.toString(punten));
                    txtKracht.setText(Integer.toString(kracht));
                }
            }
        });
        Button krachtMin = new Button("-");
        krachtMin.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(kracht >1)
                {
                    punten++;
                    kracht--;
                    lblTeverdelen.setText(Integer.toString(punten));
                    txtKracht.setText(Integer.toString(kracht));
                }
            }
        });
        Button snelheidPlus = new Button("+");
        snelheidPlus.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(punten > 0)
                {
                    punten--;
                    snelheid++;
                    lblTeverdelen.setText(Integer.toString(punten));
                    txtSnelheid.setText(Integer.toString(snelheid));
                }
            }
        });
        Button snelheidMin = new Button("-");
        snelheidMin.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(snelheid >1)
                {
                    punten++;
                    snelheid--;
                    lblTeverdelen.setText(Integer.toString(punten));
                    txtSnelheid.setText(Integer.toString(snelheid));
                }
            }
        });
        Button alertheidPlus = new Button("+");
        alertheidPlus.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(punten >0)
                {
                    punten--;
                    alertheid++;
                    lblTeverdelen.setText(Integer.toString(punten));
                    txtAlertheid.setText(Integer.toString(alertheid));
                }
            }
        });
        Button alertheidMin = new Button("-");
        alertheidMin.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(alertheid >1)
                {
                    punten++;
                    alertheid--;
                    lblTeverdelen.setText(Integer.toString(punten));
                    txtAlertheid.setText(Integer.toString(alertheid));
                }
            }
        });
        Button createHero = new Button("create Hero");
        createHero.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               if(txtNaam == null || punten > 0)
               {
                   
               }
               else
               {
                   held.setKracht(kracht);
                   held.setNaam(txtNaam.getText());
                   held.setSnelheid(snelheid);
                   held.setVerdediging(verdediging);
                   held.setAlertheid(alertheid);
               }
            }
        });
        
        vLabels.getChildren().addAll(lblVerdediging, lblKracht, lblSnelheid, lblAlertheid);
        vTextFields.getChildren().addAll(txtVerdediging, txtKracht, txtSnelheid, txtAlertheid);
        vMinButtons.getChildren().addAll(verdedigingMin, krachtMin, snelheidMin, alertheidMin);
        vPlusButtons.getChildren().addAll(verdedigingPlus, krachtPlus, snelheidPlus, alertheidPlus);
        
        hImage.getChildren().addAll(previousImage, heroselector, nextImage);
        hNaam.getChildren().addAll(lblNaam, txtNaam);
        hNumbers.getChildren().addAll(lblPunten, lblTeverdelen);
        hStats.getChildren().addAll(vMinButtons, vLabels, vTextFields, vPlusButtons);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.add(hImage, 0, 0);
        grid.add(hNaam, 0, 1);
        grid.add(hNumbers, 0, 2);        
        grid.add(hStats, 0, 3);
        grid.add(createHero, 0, 4);

        grid.setAlignment(Pos.CENTER);
        
        setCenter(grid);
        
        
    }
}
