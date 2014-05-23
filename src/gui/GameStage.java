package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class GameStage extends BorderPane
{
    public GameStage()
    {
    
        HBox hbox = addHBox();
        this.setBottom(hbox);
        
//        HBox hbox2 = addHBox2();
//        this.setTop(hbox2);
        
    }
    
    
    
    private HBox addHBox() {
                HBox hbox = new HBox();
        this.setPadding(new Insets(100, 50, 100, 50));
        hbox.setSpacing(10);   
        this.setStyle("-fx-background-image: url('resources/download.jpg'); -fx-background-size: cover;");

        Button buttonAanval = new Button("Aanval");
        buttonAanval.setPrefSize(100, 20);
        buttonAanval.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            
    }});

        Button buttonVerdedig = new Button("Verdedig");
        buttonVerdedig.setPrefSize(100, 20);
        buttonVerdedig.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            
    }});
        
        Button buttonVlucht = new Button("Vlucht");
        buttonVlucht.setPrefSize(100, 20);
        buttonVlucht.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            
    }});
        
        Button buttonAnnuleren = new Button("Annuleren");
        buttonAnnuleren.setPrefSize(100, 20);
        buttonAnnuleren.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            BeginScherm beginscherm = new BeginScherm();
            GameStage.this.getScene().setRoot(beginscherm);
            
    }   });
        
        hbox.getChildren().addAll(buttonAanval, buttonVerdedig, buttonVlucht, buttonAnnuleren);
        
        return hbox;
    }

//    private HBox addHBox2() 
//    {
//        // spel zien
//        return hbox2;
//    }
    
    
}
