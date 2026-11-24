package studentrecords;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override       
    public void start(Stage stage) throws Exception {
        // opens the logi   n screen first
        Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
        stage.setTitle("Animo Student Records Management System");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
        
    public static void main(String[] args) {
        launch(args);
    }
}