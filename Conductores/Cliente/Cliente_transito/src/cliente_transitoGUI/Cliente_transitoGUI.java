package cliente_transitoGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cliente_transitoGUI extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = 
                FXMLLoader.load(getClass().getResource("GUIInicioSesion.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Iniciar sesion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
