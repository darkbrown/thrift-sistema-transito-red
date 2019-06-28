package cliente_transitoGUI;

import Thrift.ApiServidor;
import Thrift.Conexiones;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

public class FXMLController implements Initializable {
    
    private Conexiones conexiones;
    
    @FXML
    private TextField tfTelefono;
    @FXML
    private PasswordField pfContrasena;
    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnRegistrar;
    
    private TSocket transport;
    private ApiServidor.Client client;
    
    /**
     * Este metodo lleva a la ventana del menu principal.
     * @param event clic en el boton Ingresar.
     * @throws IOException error al abrir ventana.
     */
    @FXML
    private void ingresar(ActionEvent event) throws IOException {
        if (validarCampos() && validarAcceso()) {
            System.out.println("Usuario correcto");
        } else {
            System.out.println("Primera vez aqui? acostumbrate...");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       conexiones = new Conexiones();
    }    

    private boolean validarCampos() {
        boolean validador = true;
        if(Objects.equals(tfTelefono.getText().trim(), "")) {
            
            validador = false;
            
        }
        if(Objects.equals(pfContrasena.getText().trim(), "")){//limite
            
            validador = false;
        }
        return validador;
    }

    /*private boolean validarAcceso() {
        
        boolean ingresoExitoso = false;
        try {
            
            ingresoExitoso = client.confirmarUsuario(tfTelefono.getText(), pfContrasena.getText());//"228811334", "jane doe"
            transport.close();
            
        } catch (TException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            return ingresoExitoso;
        }
    }*/
    
    private boolean validarAcceso() {
        /*
        try {
            return conexiones.confirmarUsuario(tfTelefono.getText(), pfContrasena.getText());//"228811334", "jane doe"
        } catch (TException ex) {
            JOptionPane.showConfirmDialog(null, "Error de conexión con el servidor", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            //Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        return false;

    }
    
}
