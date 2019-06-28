package cliente_transitoController;

import Thrift.Conductor;
import Thrift.Conexiones;
import Thrift.ErrorBD;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static jdk.nashorn.tools.ShellFunctions.input;
import org.apache.thrift.TException;

public class RegistrarConducController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfCurp;
    @FXML
    private PasswordField pfContrasena;
    @FXML
    private PasswordField pfContrasenaConf;
    @FXML
    private TextField tfNLicencia;
    @FXML
    private TextField tfTelefono;
    @FXML
    private DatePicker dtFechaNac;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;

    private Conexiones conexiones;
    private boolean ventanaMostrada;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        excluirEspacios();
        excluirAlfabeticos();
        excluirMinusculas();
        limiteCurp();
        conexiones = new Conexiones();
    }

    @FXML
    private void regresarInicioSesion(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIInicioSesion.fxml"));
        try {

            Parent logIn = loader.load();
            InicioSesionController controller = loader.getController();
            Scene scene = new Scene(logIn);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (IOException ex) {

            Logger.getLogger(RegistrarConducController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registrarConductor(ActionEvent event) {

        if (validarCampos()) {

            if (registroExitoso()) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exito");
                alert.setHeaderText(null);
                alert.setContentText("Se ha registrado el conductor con exito");
                alert.showAndWait();
                btnCancelar.setText("Regresar");
                limpiarCampos();
            }

        }
    }

    private boolean validarCampos() {

        boolean validador = true;
        if (verificarCamposLLenos() != true || verificarContrasena() != true
                || verificarTamMinim() != true) {

            validador = false;
            if (!ventanaMostrada) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incorrecto");
                alert.setHeaderText(null);
                alert.setContentText("Para registrar el conductor tienes que llenar "
                        + "todos los campos");
                alert.showAndWait();
                ventanaMostrada = true;
            }
        } else if (telefonoUnico() != true) {
            
            validador = false;
            if (!ventanaMostrada) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incorrecto");
                alert.setHeaderText(null);
                alert.setContentText("Ya hay un conductor con ese telefono");
                alert.showAndWait();
                ventanaMostrada = true;
            }
        }
        return validador;
    }

    private boolean registroExitoso() {

        boolean exito = false;
        Conductor conductorNuevo = crearConductor();
        try {

            boolean registro = conexiones.registrarConductor(conductorNuevo);

            if (registro == false) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Perdida conexion");
                alert.setHeaderText(null);
                alert.setContentText("No hay conexión con la base de datos, "
                        + "vuelve a intentarlo");
                ventanaMostrada = true;
                alert.showAndWait();
            } else {

                exito = registro;
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

            Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return exito;
        }
    }

    /**
     * Este metodo sirve para que los textField nieguen la entrada a espacios.
     */
    private void excluirEspacios() {

        tfTelefono.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue.contains(" ")) {

                        tfTelefono.setText(oldValue);
                    }
                });
        pfContrasenaConf.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue.contains(" ")) {

                        pfContrasenaConf.setText(oldValue);
                    }
                });
        tfNLicencia.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue.contains(" ")) {

                        tfNLicencia.setText(oldValue);
                    }
                });
        tfCurp.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue.contains(" ")) {

                        tfCurp.setText(oldValue);
                    }
                });
        pfContrasena.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue.contains(" ")) {

                        pfContrasena.setText(oldValue);
                    }
                });
    }

    private void excluirAlfabeticos() {

        tfTelefono.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (!newValue.matches("\\d*")) {
                        tfTelefono.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                });
        tfNLicencia.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (!newValue.matches("\\d*")) {
                        tfNLicencia.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                });
    }

    private Conductor crearConductor() {

        Conductor conductorNuevo = new Conductor();
        conductorNuevo.setCurp(tfCurp.getText());
        conductorNuevo.setNombreComp(tfNombre.getText());
        conductorNuevo.setFechaNac(dtFechaNac.getValue().toString());
        conductorNuevo.setNumLicencia(Long.parseLong(tfNLicencia.getText()));
        conductorNuevo.setTelefono(Long.parseLong(tfTelefono.getText()));
        conductorNuevo.setContrasena(generarContrasena());
        return conductorNuevo;
    }

    private boolean verificarCamposLLenos() {

        if (Objects.equals(tfTelefono.getText().trim(), "")) {

            return false;

        }
        if (Objects.equals(pfContrasena.getText().trim(), "")) {

            return false;
        }
        if (Objects.equals(tfNombre.getText().trim(), "")) {

            return false;
        }
        if (Objects.equals(tfCurp.getText().trim(), "")) {

            return false;
        }
        if (Objects.equals(pfContrasenaConf.getText().trim(), "")) {

            return false;
        }
        if (Objects.equals(tfNLicencia.getText().trim(), "")) {

            return false;
        }
        if (dtFechaNac.getValue() == null) {

            return false;
        }
        return true;
    }

    private boolean verificarContrasena() {

        if (pfContrasenaConf.getText().equals(pfContrasena.getText())
                && pfContrasena.getText().length() > 7) {

            return true;
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrecto");
            alert.setHeaderText(null);
            alert.setContentText("Tienes que escribir dos veces las misma "
                    + "contraseña y minim. 8 caracteres");
            alert.showAndWait();
            ventanaMostrada = true;
        }
        return false;
    }

    private boolean verificarTamMinim() {

        if (tfTelefono.getText().length() > 9 && tfCurp.getText().length() > 17) {

            return true;
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrecto");
            alert.setHeaderText(null);
            alert.setContentText("Verifica que los campos cumplen con el mínimo "
                    + "de caracteres o número, según sea el caso");
            alert.showAndWait();
            ventanaMostrada = true;
        }
        return false;
    }

    private String generarContrasena() {

        String contrasena = null;
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(pfContrasena.getText().getBytes("utf8"));
            contrasena = String.format("%0128x", new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException ex) {

            Logger.getLogger(RegistrarConducController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {

            Logger.getLogger(RegistrarConducController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrasena;
    }

    private void limpiarCampos() {

        tfNombre.clear();
        tfCurp.clear();
        pfContrasena.clear();
        pfContrasenaConf.clear();
        tfNLicencia.clear();
        tfTelefono.clear();
        dtFechaNac.getEditor().clear();
    }

    private boolean telefonoUnico() {

        boolean exito = false;
        try {

            int unico = conexiones.confirmarUsuario(Long.parseLong(tfTelefono.getText()),
                    generarContrasena());

            if (unico > 1) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Perdida conexion");
                alert.setHeaderText(null);
                alert.setContentText("No hay conexión con el servidor, "
                        + "vuelve a intentarlo");
                ventanaMostrada = true;
                alert.showAndWait();
            } else {
                
                exito = (unico == 0);
            }
        } catch (ErrorBD error) {

            conexiones.abrirConexion();
            conexiones.cerrarConexion();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Perdida conexion");
            alert.setHeaderText(null);
            alert.setContentText("No hay conexión con la base de datos, "
                    + "vuelve a intentarlo");
            ventanaMostrada = true;
            alert.showAndWait();
        } catch (TException ex) {

            conexiones.abrirConexion();
            conexiones.cerrarConexion();
            Logger.getLogger(RegistrarConducController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return exito;
        }
    }

    private void excluirMinusculas() {

        tfCurp.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    tfCurp.setText(newValue.toUpperCase());

                });
    }

    private void limiteCurp() {
        
        tfCurp.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (tfCurp.getText().length() == 19) {
                        
                        tfCurp.setText(oldValue);
                    }
                });
    }
}
