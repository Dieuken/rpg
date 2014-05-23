
package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BeginScherm extends BorderPane {
    

    public BeginScherm() {    
        
        HBox hbox = addHBox();
        this.setCenter(hbox);
        
        HBox hbox2 = addHBox2();
        this.setTop(hbox2);

        this.setStyle("-fx-background-image: url('resources/download.jpg'); -fx-background-size: cover;");
    }

    
    private HBox addHBox() {
        // opmaak kader buttons
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(200,150,200,150));
        hbox.setSpacing(20);  // ruimte tss buttons 
        //hbox.setStyle("-fx-background-color: #99CCFF;");
//        hbox.setStyle(
//        "-fx-background-image: url('resources/download.jpg');"
//        +"-fx-background-size: 500,500;"
//        +"-fx-background-repeat: stretch;"
//        +"-fx-webkit-background-size: cover;"
//        +"-fx-moz-background-size: cover;"
//       +"-fx-o-background-size: cover;"
//        );
      
        
        
        // Button 1
        Button buttonStart = new Button("Start spel");
        buttonStart.setPrefSize(100, 20);
        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            //Start s = new Start();
            HeroCreation hc = new HeroCreation();
            BeginScherm.this.getScene().setRoot(hc);
            
        }
        });
        //Button 2
        Button buttonSchatToevoegen = new Button("Schat Toevoegen");
        buttonSchatToevoegen.setPrefSize(100, 20);
        buttonSchatToevoegen.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            //Start s = new Start();
            SchatToevoegen schattoevoegen = new SchatToevoegen();
            BeginScherm.this.getScene().setRoot(schattoevoegen);
            
            
    }
        });
        
        Button buttonMonsterToevoegen = new Button("Monster Toevoegen");
        buttonMonsterToevoegen.setPrefSize(100, 20);
        buttonMonsterToevoegen.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
            //Start s = new Start();
            MonsterToevoegen monstertoevoegen = new MonsterToevoegen();
            BeginScherm.this.getScene().setRoot(monstertoevoegen);
            monstertoevoegen.getScene().getWindow().sizeToScene();
            monstertoevoegen.getScene().getWindow().centerOnScreen();
            
        }
        });
        
        hbox.getChildren().addAll(buttonStart, buttonSchatToevoegen, buttonMonsterToevoegen);
        
        return hbox;
    }
    
    private HBox addHBox2()
    {
        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(100,50,100,50));
        
        hbox2.setStyle("-fx-background-image: url('resources/banner.png'); -fx-background-size: cover;");
        
        return hbox2;
    }
}

      