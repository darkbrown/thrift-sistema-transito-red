package cliente_transitoController;

import Thrift.Conductor;
import Thrift.Conexiones;
import Thrift.Dictamen;
import Thrift.ErrorBD;
import Thrift.Reporte;
import Thrift.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.thrift.TException;

public class ReporteDictController implements Initializable {

    @FXML
    private Label lblFecha;
    @FXML
    private Label lblNPerito;
    @FXML
    private Label lblFUnico;
    @FXML
    private Label lblDescripcion;
    @FXML
    private Label lblNombre1;
    @FXML
    private Label lblNombre2;
    @FXML
    private Label blbLatitud;
    @FXML
    private ImageView ivFtotografia2;
    @FXML
    private ImageView ivFtotografia3;
    @FXML
    private ImageView ivFtotografia4;
    @FXML
    private ImageView ivFtotografia5;
    @FXML
    private ImageView ivFtotografia6;
    @FXML
    private ImageView ivFtotografia7;
    @FXML
    private ImageView ivFtotografia8;
    @FXML
    private ImageView ivFtotografia1;
    @FXML
    private Label lblMarca1;
    @FXML
    private Label lblMarca2;
    @FXML
    private Label lblModelo1;
    @FXML
    private Label lblModelo2;
    @FXML
    private Label lblAno1;
    @FXML
    private Label lblAno2;
    @FXML
    private Label lblColor1;
    @FXML
    private Label lblColor2;
    @FXML
    private Label lblNPlaca1;
    @FXML
    private Label lblNPlaca2;
    @FXML
    private Label lblLongitud;
    @FXML
    private Button btnRegresar;
    
    List<Object> recursosPReporteDict;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void regresarConsultaReportes(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIConsultaReportes.fxml"));
        try {

            Parent logIn = loader.load();
            ConsultaReportesController controller = loader.getController();
            controller.recibirParametros((String)recursosPReporteDict.get(2), 
                    (Conexiones)recursosPReporteDict.get(3));
            Scene scene = new Scene(logIn);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (IOException ex) {

            Logger.getLogger(RegistrarConducController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    void recibirParametros(List<Object> recursosPReporteDict) {

        this.recursosPReporteDict = recursosPReporteDict;
        Reporte reporteElegido = (Reporte)recursosPReporteDict.get(0);
        Dictamen dictamenElegido = (Dictamen)recursosPReporteDict.get(1);
        String telConductor = (String)recursosPReporteDict.get(2);
        Conexiones conexiones = (Conexiones)recursosPReporteDict.get(3);
        mostrarReporte(reporteElegido, telConductor, conexiones);
        mostrarDictamen(dictamenElegido, conexiones);
    }

    private void mostrarReporte(Reporte reporteElegido, String telConductor, Conexiones conexiones) {
        
        try {
            Conductor datoPersonal = conexiones.consultarConductorPropio(
                    Long.parseLong(telConductor));
            List<Vehiculo> vehiculos = 
                    conexiones.recuperarVehiculoReporte(reporteElegido.getFolioUnico_dictamen());
            
            lblNombre1.setText(datoPersonal.getNombreComp());//recuperar los nombres de conductor
            lblMarca1.setText(vehiculos.get(0).getMarca());//recuperar los vehiculos
            lblModelo1.setText(vehiculos.get(0).getModelo());
            lblAno1.setText(String.valueOf(vehiculos.get(0).getAno()));
            lblColor1.setText(vehiculos.get(0).getColor());
            lblNPlaca1.setText(vehiculos.get(0).getNumPlaca());
            blbLatitud.setText(reporteElegido.getLatitud());//info de reporte elegido anteriormente
            lblLongitud.setText(reporteElegido.getLongitud());
            
            lblNombre2.setText(reporteElegido.getNombreOtroConduc());//recuperar los nombres de conductor
            lblMarca2.setText(vehiculos.get(1).getMarca());//recuperar los vehiculos
            lblModelo2.setText(vehiculos.get(1).getModelo());
            lblAno2.setText(String.valueOf(vehiculos.get(1).getAno()));
            lblColor2.setText(vehiculos.get(1).getColor());
            lblNPlaca2.setText(vehiculos.get(1).getNumPlaca());
            //ivFtotografia1.setImage("");//fotografias
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
            Logger.getLogger(ReporteDictController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarDictamen(Dictamen dictamenElegido, Conexiones conexiones) {
        
        try {
            String nombPerito = conexiones.recuperarNFuncionario(dictamenElegido.getFolioUnico());
            lblFecha.setText(dictamenElegido.getFechaHora());//info de dictamen elegido anteriormente
            lblNPerito.setText(nombPerito);
            lblFUnico.setText(String.valueOf(dictamenElegido.getFolioUnico()));
            lblDescripcion.setText(dictamenElegido.getDictamen());
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
            Logger.getLogger(ReporteDictController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
