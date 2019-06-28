package cliente_transitoController;

import Thrift.Conductor;
import Thrift.Conexiones;
import Thrift.ErrorBD;
import Thrift.Vehiculo;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.thrift.TException;

public class PerfilController implements Initializable {
    
    @FXML
    private Button btnRegresar;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblCurp;
    @FXML
    private Label lblFechaNDia;
    @FXML
    private Label lblFechaNMes;
    @FXML
    private Label lblFechaNAno;
    @FXML
    private Label lblNLicencia;
    @FXML
    private Label lblTelefono;
    
    private String telConductor;
    private Conexiones conexiones;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    private void regresarMenuPral(ActionEvent event){
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIMenu.fxml"));
        try {

            Parent logIn = loader.load();
            GUIMenuController controller = loader.getController();
            controller.recibirParametros(telConductor, conexiones);
            Scene scene = new Scene(logIn);
            Stage stage = new Stage();
            stage.setTitle("Menu principal");
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
        consultarPerfil();
    }

    private void consultarPerfil() {

        try {

            Conductor miPerfil = conexiones.consultarConductorPropio(Long.parseLong(telConductor));
            lblNombre.setText(miPerfil.getNombreComp());
            lblCurp.setText(miPerfil.getCurp());
            String[] partesFechaN = miPerfil.getFechaNac().split(" ");
            lblFechaNDia.setText(partesFechaN[2]);
            lblFechaNMes.setText(partesFechaN[1]);
            lblFechaNAno.setText(partesFechaN[3]);
            lblNLicencia.setText(Long.toString(miPerfil.getNumLicencia()));
            lblTelefono.setText(Long.toString(miPerfil.getTelefono()));
        } catch (ErrorBD error) {
            
            conexiones.abrirConexion();
            conexiones.cerrarConexion();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Perdida conexion");
            alert.setHeaderText(null);
            alert.setContentText("No hay conexión con la base de datos, "
                    + "vuelve a intentarlo");
            alert.showAndWait();
        } catch (TException ex) {
            Logger.getLogger(AdministrarVehiculoController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
