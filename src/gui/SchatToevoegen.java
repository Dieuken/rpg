package gui;

import domein.Schat;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import persistentie.SchatMapper;

public class SchatToevoegen extends BorderPane
{
    public ListView<Schat> lijst;
    public VBox vbox;
    public TextField nummer;
    public TextField omschrijving;
    public TextField waarde;
    
    public SchatToevoegen()
    {
        
       
        HBox hbox = addHBox();
        vbox = addVbox();
        GridPane gridpane = addGrid();
        this.setBottom(hbox);
        this.setRight(vbox);
        this.setLeft(gridpane);
        this.setStyle("-fx-background-image: url('resources/download.jpg'); -fx-background-size: cover;");
        //this.show();
    }
    
    
    
    private HBox addHBox() {
//        MonsterMapper mMapper = new MonsterMapper();
//        List<Monster> monsters = mMapper.zoekAlleMonsters();
//        System.out.println(monsters.size() + "");
//        for(Monster m : monsters)
//        {
//            System.out.println("naam " + m.getNaam());
//        }
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
       

        Button buttonAnnuleren = new Button("Annuleren");
        buttonAnnuleren.setPrefSize(100, 20);
        buttonAnnuleren.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            BeginScherm beginscherm = new BeginScherm();
            SchatToevoegen.this.getScene().setRoot(beginscherm);
            
    }   });

        Button buttonOpslaan = new Button("Opslaan");
        buttonOpslaan.setPrefSize(100, 20);
        buttonOpslaan.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    Schat schat = new Schat();
                    schat.setOmschrijving(omschrijving.getText());
                    schat.setWaarde(Integer.parseInt(waarde.getText()));
                    
                    SchatMapper schatmapper = new SchatMapper();
                    int i = schatmapper.zoekAlleSchatten().size() - 1;
                    schat.setIdSchat(schatmapper.zoekAlleSchatten().get(i).getIdSchat() + 1);
                    schatmapper.voegSchatToe(schat);
                    lijst.getItems().add(schat);
                }});
        hbox.getChildren().addAll(buttonAnnuleren, buttonOpslaan);
        
        return hbox;
    }
    
    public VBox addVbox(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        
        vbox.getChildren().add(new Label("Overzicht:"));
        
        lijst = new ListView<>();
        VBox.setVgrow(lijst, Priority.ALWAYS);
        vbox.getChildren().add(lijst);
        
        
        SchatMapper schatmapper = new SchatMapper();
        lijst.setItems(FXCollections.observableList(schatmapper.zoekAlleSchatten()));
        
        return vbox;
    }
    
    public GridPane addGrid()
    {
        
        
        GridPane gridpane = new GridPane();
        
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS); // De tweede kolom krijgt alle extra ruimte.
        gridpane.getColumnConstraints().addAll(col1, col2);
        
        gridpane.add(new Label("Details:"), 0, 0, 2, 1);
        
        gridpane.add(new Label("Nummer:"), 0, 1);
        gridpane.add(new Label("Omschrijving:"), 0, 2);
        gridpane.add(new Label("Waarde:"), 0, 3);
        
        nummer = new TextField();
        nummer.setDisable(true); // Dit veld is enkel lezen.
        omschrijving = new TextField();
        waarde = new TextField();
        
        gridpane.add(nummer, 1, 1);
        gridpane.add(omschrijving, 1, 2);
        gridpane.add(waarde, 1, 3);
        
        return gridpane;
        
        
    }
} 



