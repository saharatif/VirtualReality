package ippo.assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/" + "assignment2.fxml"));
            StackPane stackPane = (StackPane) fxmlLoader.load();
            Group root = new Group();
            Scene scene = new Scene(stackPane, 500, 500);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Real Estate Tour");
            VirtualController controller = (VirtualController) fxmlLoader.getController();
            controller.initializeController(root);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
       //JsonToJavaObjects.main(args);
        launch(args);
    }

}

