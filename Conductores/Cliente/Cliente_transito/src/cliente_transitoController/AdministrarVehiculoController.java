package cliente_transitoController;

import Thrift.Conexiones;
import Thrift.ErrorBD;
import Thrift.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.thrift.TException;

public class AdministrarVehiculoController implements Initializable {

    @FXML
    private Label lblMarca;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblAno;
    @FXML
    private Label lblColor;
    @FXML
    private Label lblNplacas;
    @FXML
    private Label lblNPSeguro;
    @FXML
    private Label lblNAseguradora;
    @FXML
    private Label lblConfDeshabilitar;
    @FXML
    private Label lblSelecVehiculo;
    @FXML
    private TextField tfMarca;
    @FXML
    private TextField tfModelo;
    @FXML
    private TextField tfAno;
    @FXML
    private TextField tfColor;
    @FXML
    private TextField tfNplacas;
    @FXML
    private TextField tfNPSeguro;
    @FXML
    private TextField tfNAseguradora;
    @FXML
    private TitledPane tpEncabezadoOpcion;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnDeshabilitar;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnRegresar;
    @FXML
    private AnchorPane apSelecVehiculo;
    @FXML
    private Rectangle rDeshabilitarVehiculo;
    @FXML
    private CheckBox cbNoVehiculo;
    @FXML
    private MenuButton mbSelecVehiculo;

    private String telConductor;
    private Conexiones conexiones;
    private String seleccionVehiculo;
    private List<Vehiculo> misVehiculos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnRegistrar.setVisible(false);
        btnRegistrar.setDisable(true);
        btnModificar.setVisible(false);
        btnModificar.setDisable(true);
        btnDeshabilitar.setVisible(false);
        btnDeshabilitar.setDisable(true);
        limiteAno();
    }

    @FXML
    private void mostrarRegistrar(ActionEvent event) {

        cambioSeccion();
        tfMarca.setText("");
        tfModelo.setText("");
        tfAno.setText("");
        tfColor.setText("");
        tfNplacas.setText("");
        tfNPSeguro.setText("");
        tfNAseguradora.setText("");
        tpEncabezadoOpcion.setText("Datos a registrar");
    }

    @FXML
    private void mostrarModificar(ActionEvent event) {
        
        if (!lblMarca.getText().equals("")) {
            
            cambioSeccion();
            tfMarca.setText(lblMarca.getText());
            tfModelo.setText(lblModelo.getText());
            tfAno.setText(lblAno.getText());
            tfColor.setText(lblColor.getText());
            tfNplacas.setText(lblNplacas.getText());
            tfNPSeguro.setText(lblNPSeguro.getText());
            tfNAseguradora.setText(lblNAseguradora.getText());
            
            tpEncabezadoOpcion.setText("Datos a modificar");
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("No se puede modificar la primera vez que se va "
                    + "a registrar un vehiculo, si ya lo hizo regrese después y "
                    + "seleccione el vehículo de la lista inicial.");
            alert.showAndWait();
        }

    }

    @FXML
    private void mostrarDeshabilitar(ActionEvent event) {
        
        if (!lblMarca.getText().equals("")) {
            
            rDeshabilitarVehiculo.setVisible(true);
            lblConfDeshabilitar.setVisible(true);
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("No se puede modificar la primera vez que se va "
                    + "a registrar un vehiculo, si ya lo hizo regrese después y "
                    + "seleccione el vehículo de la lista inicial.");
            alert.showAndWait();
        } 
    }

    @FXML
    private void aceptarAccion(ActionEvent event) {

        if (apSelecVehiculo.isVisible()) {

            cambiarAPantallaMod();
        } else if (tpEncabezadoOpcion.getText().equals("Datos a modificar")) {
            
            modificarVehiculo();
        } else if (tpEncabezadoOpcion.getText().equals("Datos a registrar")) {
            
            registrarVehiculo();
        } else if (rDeshabilitarVehiculo.isVisible()){
            
            deshabilitarVehiculo();
        }
        limpiarCampos();
    }

    @FXML
    private void regresarMenuPral(ActionEvent event) {

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

    private void click_listaVehiculo(ActionEvent event) {

        CustomMenuItem cmFuente = (CustomMenuItem) event.getSource();
        CheckBox vehiculo = (CheckBox) cmFuente.getContent();
        cbNoVehiculo.setSelected(false);
        seleccionVehiculo = vehiculo.getText();
    }

    private CustomMenuItem llenarListaVehiculo(String nombreVehiculo,
            EventHandler<ActionEvent> manejadorEvento) {

        CustomMenuItem nuevoMenuItem
                = new CustomMenuItem(new CheckBox(nombreVehiculo), false);
        nuevoMenuItem.setOnAction(manejadorEvento);
        return nuevoMenuItem;
    }

    public void recibirParametros(String telConductor, Conexiones conexiones) {

        this.telConductor = telConductor;
        this.conexiones = conexiones;
        recuperarListaVehiculos();
    }

    private void recuperarListaVehiculos() {

        try {

            EventHandler<ActionEvent> manejadorEventoParticipante = this::click_listaVehiculo;
            misVehiculos
                    = conexiones.consultarVehiculoPropio(Long.parseLong(telConductor));
            for (int i = 0; i < misVehiculos.size(); i++) {

                String vehiculoPropio = misVehiculos.get(i).getModelo() + "-"
                        + misVehiculos.get(i).getAno() + "  " 
                        + misVehiculos.get(i).getNumPlaca();
                mbSelecVehiculo.getItems().add(
                        llenarListaVehiculo(
                                vehiculoPropio, manejadorEventoParticipante));
            }
        } catch (ErrorBD error) {
            
            conexiones.abrirConexion();
            conexiones.cerrarConexion();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Perdida conexion");
            alert.setHeaderText(null);
            alert.setContentText("No hay conexión con la base de datos, "
                    + "vuelve a intentarlo");
            alert.showAndWait();
            Stage stage = (Stage) mbSelecVehiculo.getScene().getWindow();
            stage.hide();
        } catch (TException ex) {
            Logger.getLogger(AdministrarVehiculoController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    private void cambiarAPantallaMod() {

        if (!cbNoVehiculo.isSelected()) {

            String numPLaca = null;
            String[] parteVehiculo = seleccionVehiculo.split("  ");
            for (int i = 0; i < misVehiculos.size(); i++) {

                if (parteVehiculo[1].equals(misVehiculos.get(i).getNumPlaca())) {

                    numPLaca = misVehiculos.get(i).getNumPlaca();
                }
            }
            recuperarVehiculoInfo(numPLaca);
        }
        apSelecVehiculo.setVisible(false);
        apSelecVehiculo.setDisable(true);
        lblSelecVehiculo.setVisible(false);
        lblSelecVehiculo.setDisable(true);
        mbSelecVehiculo.setVisible(false);
        mbSelecVehiculo.setDisable(true);
        btnRegistrar.setVisible(true);
        btnRegistrar.setDisable(false);
        btnModificar.setVisible(true);
        btnModificar.setDisable(false);
        btnDeshabilitar.setVisible(true);
        btnDeshabilitar.setDisable(false);
    }

    private void recuperarVehiculoInfo(String numPLaca) {

        try {

            Vehiculo miVehiculo = conexiones.consultarVehiculoInfo(numPLaca);
            mostrarInfoVehiculo(miVehiculo);
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

    private void mostrarInfoVehiculo(Vehiculo miVehiculo) {

        lblMarca.setText(miVehiculo.getMarca());
        lblModelo.setText(miVehiculo.getModelo());
        lblAno.setText(Integer.toString(miVehiculo.getAno()));
        lblColor.setText(miVehiculo.getColor());
        lblNplacas.setText(miVehiculo.getNumPlaca());
        lblNPSeguro.setText(miVehiculo.getNumPoliza());
        lblNAseguradora.setText(miVehiculo.getNomAseguradora());
    }
    
    private void cambioSeccion() {

        tfMarca.setVisible(true);
        tfMarca.setEditable(true);
        tfModelo.setVisible(true);
        tfModelo.setEditable(true);
        tfAno.setVisible(true);
        tfAno.setEditable(true);
        tfColor.setVisible(true);
        tfColor.setEditable(true);
        tfNplacas.setVisible(true);
        tfNplacas.setEditable(true);
        tfNPSeguro.setVisible(true);
        tfNPSeguro.setEditable(true);
        tfNAseguradora.setVisible(true);
        tfNAseguradora.setEditable(true);

        lblMarca.setVisible(false);
        lblModelo.setVisible(false);
        lblAno.setVisible(false);
        lblColor.setVisible(false);
        lblNplacas.setVisible(false);
        lblNPSeguro.setVisible(false);
        lblNAseguradora.setVisible(false);
        
        rDeshabilitarVehiculo.setVisible(false);
        lblConfDeshabilitar.setVisible(false);
    }

    private void registrarVehiculo() {
        
        Vehiculo nuevoVehiculo = new Vehiculo();
        nuevoVehiculo.setAno(Integer.parseInt(tfAno.getText()));
        nuevoVehiculo.setColor(tfColor.getText());
        nuevoVehiculo.setEstatus(0);
        nuevoVehiculo.setMarca(tfMarca.getText());
        nuevoVehiculo.setModelo(tfModelo.getText());
        nuevoVehiculo.setNomAseguradora(tfNAseguradora.getText());
        nuevoVehiculo.setNumPlaca(tfNplacas.getText());
        nuevoVehiculo.setNumPoliza(tfNPSeguro.getText());
        try {
            
            int registro = conexiones.registrarVehiculo(nuevoVehiculo, Long.parseLong(telConductor));
            
            if (registro > 1) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Perdida conexion");
                alert.setHeaderText(null);
                alert.setContentText("No hay conexión con la base de datos, "
                        + "vuelve a intentarlo");
                alert.showAndWait();
            } else {
                
                if (registro == 1) {
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Exito");
                    alert.setHeaderText(null);
                    alert.setContentText("Se ha registrado el vehiculo con exito");
                    alert.showAndWait();
                } else {
                    
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Un vehiculo con esa placa ya fue registrado");
                    alert.showAndWait();
                }
                
            }
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
            
            Logger.getLogger(InicioSesionController.class.getName()).log(Level.
                    SEVERE, null, ex);
        }
    }

    private void modificarVehiculo() {
        
        Vehiculo nuevoVehiculo = new Vehiculo();
        nuevoVehiculo.setAno(Integer.parseInt(tfAno.getText()));
        nuevoVehiculo.setColor(tfColor.getText());
        nuevoVehiculo.setEstatus(0);
        nuevoVehiculo.setMarca(tfMarca.getText());
        nuevoVehiculo.setModelo(tfModelo.getText());
        nuevoVehiculo.setNomAseguradora(tfNAseguradora.getText());
        nuevoVehiculo.setNumPlaca(tfNplacas.getText());
        nuevoVehiculo.setNumPoliza(tfNPSeguro.getText());
        try {
            
            boolean modificar = conexiones.modificarVehiculo(nuevoVehiculo, 
                    lblNplacas.getText());
            
            if (modificar == false) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Perdida conexion");
                alert.setHeaderText(null);
                alert.setContentText("No hay conexión con la base de datos, "
                        + "vuelve a intentarlo");
                alert.showAndWait();
            } else {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exito");
                alert.setHeaderText(null);
                alert.setContentText("Se ha modificado el vehiculo con exito");
                alert.showAndWait();
            }
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
            
            Logger.getLogger(InicioSesionController.class.getName()).log(Level.
                    SEVERE, null, ex);
        } 
    }

    private void deshabilitarVehiculo() {
        try {
            
            boolean deshabilitar = conexiones.deshabilitarVehiculo(lblNplacas.getText());
            
            if (deshabilitar == false) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Perdida conexion");
                alert.setHeaderText(null);
                alert.setContentText("No hay conexión con la base de datos, "
                        + "vuelve a intentarlo");
                alert.showAndWait();
            } else {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exito");
                alert.setHeaderText(null);
                alert.setContentText("Se ha deshabilitado el vehiculo con exito");
                alert.showAndWait();
            }
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
            
            Logger.getLogger(InicioSesionController.class.getName()).log(Level.
                    SEVERE, null, ex);
        }
    }

    private void limpiarCampos() {
        
        tfMarca.clear();
        tfModelo.clear();
        tfAno.clear();
        tfColor.clear();
        tfNplacas.clear();
        tfNPSeguro.clear();
        tfNAseguradora.clear();
    }

    private void regresoAMenu() {

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

            mbSelecVehiculo.getScene().getWindow().hide();
        } catch (IOException ex) {

            Logger.getLogger(RegistrarConducController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    private void limiteAno() {
        
        tfAno.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (tfAno.getText().length() == 5) {
                        
                        tfAno.setText(oldValue);
                    }
                });
        tfAno.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (!newValue.matches("\\d*")) {
                        tfAno.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                });
        
    }
}

