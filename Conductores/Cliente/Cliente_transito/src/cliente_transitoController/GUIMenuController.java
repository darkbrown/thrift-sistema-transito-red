package cliente_transitoController;

import Thrift.Conexiones;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GUIMenuController implements Initializable {

    @FXML
    private Button btnAdminVeh;
    @FXML
    private Button btnReporteSin;
    @FXML
    private Button btnConsultaRep;
    @FXML
    private Button btnConsultaPerf;
    @FXML
    private Button btnCerrarSesion;
    
    private String telConductor;
    private Conexiones conexiones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void ingresarAdminVehiculos(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIAdministrarVehiculo.fxml"));
        Parent menu = loader.load();

        AdministrarVehiculoController controller = loader.getController();
        controller.recibirParametros(telConductor, conexiones);

        Scene scene = new Scene(menu);
        Stage stage = new Stage();
        stage.setTitle("Administracion de mis vehiculos");
        stage.setScene(scene);
        stage.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void ingresarConsultaReportes(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIConsultaReportes.fxml"));
        Parent menu = loader.load();

        ConsultaReportesController controller = loader.getController();
        controller.recibirParametros(telConductor, conexiones);

        Scene scene = new Scene(menu);
        Stage stage = new Stage();
        stage.setTitle("Mis reportes");
        stage.setScene(scene);
        stage.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void ingresarPerfilConduc(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIPerfil.fxml"));
        Parent menu = loader.load();

        PerfilController controller = loader.getController();
        controller.recibirParametros(telConductor, conexiones);

        Scene scene = new Scene(menu);
        Stage stage = new Stage();
        stage.setTitle("Mi perfil");
        stage.setScene(scene);
        stage.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void ingresarRegistrarReporte(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIReporteConduc.fxml"));
        Parent menu = loader.load();

        ReporteConducController controller = loader.getController();
        controller.recibirParametros(telConductor, conexiones);

        Scene scene = new Scene(menu);
        Stage stage = new Stage();
        stage.setTitle("Reporte de siniestro");
        stage.setScene(scene);
        stage.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void regresarInicioSesion(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIInicioSesion.fxml"));
        try {

            Parent logIn = loader.load();
            InicioSesionController controller = loader.getController();
            Scene scene = new Scene(logIn);
            Stage stage = new Stage();
            stage.setTitle("Reporte de siniestro");
            stage.setScene(scene);
            stage.show();

            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (IOException ex) {

            Logger.getLogger(RegistrarConducController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    void recibirParametros(String telConductor, Conexiones conexiones) {
        
        this.telConductor = telConductor;
        this.conexiones = conexiones;
    }
    
}
