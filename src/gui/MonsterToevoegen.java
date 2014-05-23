package gui;

import domein.Monster;
import domein.Schat;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import persistentie.MonsterMapper;
import persistentie.SchatMapper;

/**
 *
 * @author Anke
 */
public class MonsterToevoegen extends BorderPane
{
   
    public ListView<Monster> lijst;
    public VBox vbox;
    
    public TextField idmonster;
    public TextField kracht;
    public TextField verdediging;
    public TextField snelheid;
    public TextField alertheid;
    public TextField naam;
    public TextField idschat;
    
    
    
    
    
    
    
    public MonsterToevoegen()
    {
        HBox hbox = addHBox();
        HBox hbox2 = schatten();
        vbox = addVbox();
        GridPane gridpane = addGrid();
        this.setBottom(hbox);
        this.setCenter(vbox);
        this.setLeft(gridpane);
        this.setRight(hbox2);
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
        hbox.setSpacing(10);   
       

        Button buttonAnnuleren = new Button("Annuleren");
        buttonAnnuleren.setPrefSize(100, 20);
        buttonAnnuleren.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            BeginScherm beginscherm = new BeginScherm();
            MonsterToevoegen.this.getScene().setRoot(beginscherm);
            
    }   });

        Button buttonOpslaan = new Button("Opslaan");
        buttonOpslaan.setPrefSize(100, 20);
        buttonOpslaan.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                    Monster monster = new Monster();
                    monster.setKracht(Integer.parseInt(kracht.getText()));
                    monster.setNaam(naam.getText());
                    monster.setSnelheid(Integer.parseInt(snelheid.getText()));
                    monster.setVerdediging(Integer.parseInt(verdediging.getText()));
                    monster.setAlertheid(Integer.parseInt("0"));
                    monster.setIdschat(Integer.parseInt(idschat.getText()));
                    
                    
                    
                    MonsterMapper monstermapper = new MonsterMapper();
                    int i = monstermapper.zoekAlleMonsters().size() - 1;
                    monster.setIdmonster(monstermapper.zoekAlleMonsters().get(i).getIdmonster() + 1);
                    monstermapper.voegMonsterToe(monster);
                    lijst.getItems().add(monster);
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
        
        
        MonsterMapper monstermapper = new MonsterMapper();
        lijst.setItems(FXCollections.observableList(monstermapper.zoekAlleMonsters()));
        
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
        
        gridpane.add(new Label("Monster id:"), 0, 1);
        gridpane.add(new Label("kracht:"), 0, 2);
        gridpane.add(new Label("verdediging:"), 0, 3);
        gridpane.add(new Label("snelheid:"), 0, 4);
        gridpane.add(new Label("naam:"), 0, 5);
        gridpane.add(new Label("schatid:"), 0, 6);
        
        idmonster = new TextField();
        idmonster.setDisable(true);
        kracht = new TextField();
        verdediging = new TextField();
        snelheid = new TextField();
        naam = new TextField();
        idschat = new TextField();
        
        gridpane.add(idmonster, 1, 1);
        gridpane.add(kracht, 1, 2);
        gridpane.add(verdediging, 1, 3);
        gridpane.add(snelheid, 1, 4);
        gridpane.add(naam, 1, 5);
        gridpane.add(idschat, 1, 6);
        
        return gridpane;
        
        
    }
    
    public HBox schatten()
    {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   
        
        TextArea textarea = new TextArea();
        SchatMapper schatmapper = new SchatMapper();
        List<Schat> schatten = schatmapper.zoekAlleSchatten();
        for(Schat schat : schatten)
        {
            if(textarea.getText() == null)
            {
                textarea.setText(schat.getIdSchat() + " " + schat.getOmschrijving() + " " + schat.getWaarde());
            }
            else
            {
                textarea.setText(textarea.getText() + "\n" + schat.getIdSchat() + " " + schat.getOmschrijving() + " " + schat.getWaarde());
            }
        }
        hbox.getChildren().add(textarea);
        return hbox;
    }
}
