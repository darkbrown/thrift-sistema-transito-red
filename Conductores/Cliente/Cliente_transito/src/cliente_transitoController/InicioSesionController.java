package cliente_transitoController;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.thrift.TException;

public class InicioSesionController implements Initializable {

    @FXML
    private TextField tfTelefono;
    @FXML
    private PasswordField pfContrasena;
    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnRegistrar;

    private Conexiones conexiones;
    private boolean ventanaMostrada;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        excluirEspacios();
        excluirAlfabeticos();
        conexiones = new Conexiones();
    }
    
    @FXML
    private void ingresarMenuPral(ActionEvent event) throws IOException{
        
        if (validarCampos() && validarAcceso()) {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIMenu.fxml"));
            Parent menu = loader.load();

            GUIMenuController controller = loader.getController();
            controller.recibirParametros(tfTelefono.getText(), conexiones);
            
            Scene scene = new Scene(menu);
            Stage stage = new Stage();
            stage.setTitle("Menu principal");
            stage.setScene(scene);
            stage.show();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            
            if (!ventanaMostrada) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Incorrecto");
                alert.setHeaderText(null);
                alert.setContentText("Datos incorrectos o no existe el usuario, "
                        + "revisa lo introducido");
                alert.showAndWait();
            }
            ventanaMostrada = false;
        }
    }
    
    @FXML
    private void ingresarRegistrar(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIRegistrarConduc.fxml"));
        Parent menu = loader.load();

        RegistrarConducController controller = loader.getController();

        Scene scene = new Scene(menu);
        Stage stage = new Stage();
        stage.setTitle("Registrar");
        stage.setScene(scene);
        stage.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    /**
     * Este metodo valida que los textfield no estén vacíos
     * @return true si hay caracteres introducidos
     */
    private boolean validarCampos() {
        
        boolean validador = true;
        if(Objects.equals(tfTelefono.getText().trim(), "")) {
            
            validador = false;
            
        }
        if(Objects.equals(pfContrasena.getText().trim(), "")){
            
            validador = false;
        }
        if(!validador){
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrecto");
            alert.setHeaderText(null);
            alert.setContentText("Para ingresar tienes que introducir tu "
                    + "telefono y contraseña");
            alert.showAndWait();
            ventanaMostrada = true;
        }
        return validador;
    }

    private boolean validarAcceso() {
        
        boolean exito = false;        
        try {
            
            int acceso = conexiones.confirmarUsuario(Long.parseLong(tfTelefono.getText()),
                    contrasenaConHash());
            
            if (acceso > 1) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Perdida conexion");
                alert.setHeaderText(null);
                alert.setContentText("No hay conexión con el servidor, "
                        + "vuelve a intentarlo");
                ventanaMostrada = true;
                alert.showAndWait();
            } else {
                
                exito = (acceso == 1);
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
    }

    private String contrasenaConHash() {
        
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
}
