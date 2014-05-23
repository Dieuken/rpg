package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Anke
 */
public class Start extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Scene scene = new Scene(new BeginScherm());
        
        primaryStage.setTitle("Munchkin");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("resources/thumbnail.png"));
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
