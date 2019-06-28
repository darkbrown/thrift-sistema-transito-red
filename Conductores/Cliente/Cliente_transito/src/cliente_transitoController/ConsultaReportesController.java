package cliente_transitoController;

import Thrift.Conductor;
import Thrift.Conexiones;
import Thrift.Dictamen;
import Thrift.ErrorBD;
import Thrift.Reporte;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import org.apache.thrift.TException;

public class ConsultaReportesController implements Initializable{
    
    @FXML
    private Label lblNoReporte1;
    @FXML
    private Label lblNoReporte2;
    @FXML
    private Label lblNoReporte3;
    @FXML
    private Label lblNoReporte4;
    @FXML
    private Label lblNoReporte5;
    @FXML
    private Label lblNoReporte6;
    @FXML
    private Label lblEstadoDic1;
    @FXML
    private Label lblEstadoDic2;
    @FXML
    private Label lblEstadoDic3;
    @FXML
    private Label lblEstadoDic4;
    @FXML
    private Label lblEstadoDic5;
    @FXML
    private Label lblEstadoDic6;
    @FXML
    private Label lblFechaDic1;
    @FXML
    private Label lblFechaDic2;
    @FXML
    private Label lblFechaDic3;
    @FXML
    private Label lblFechaDic4;
    @FXML
    private Label lblFechaDic5;
    @FXML
    private Label lblFechaDic6;
    @FXML
    private RadioButton rbtnNoReporte1;
    @FXML
    private RadioButton rbtnNoReporte2;
    @FXML
    private RadioButton rbtnNoReporte3;
    @FXML
    private RadioButton rbtnNoReporte4;
    @FXML
    private RadioButton rbtnNoReporte5;
    @FXML
    private RadioButton rbtnNoReporte6;
    @FXML
    private Button btnDetalle;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnSigPagina;
    @FXML
    private Button btnAntPagina;
    
    private String telConductor;
    private String seleccionReporte;
    private Conexiones conexiones;
    private List<Reporte> misReportes;
    private List<Dictamen> misDictamenes;
    private Reporte reporteElegido;
    private Dictamen dictamenElegido;
    private List<Label> noReportes;
    private List<Label> estDictamenes; 
    private List<Label> fechaDicamenes; 
    private List<RadioButton> selecNoReportes;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        noReportes = Arrays.asList(lblNoReporte1, lblNoReporte2, lblNoReporte3, 
                lblNoReporte4, lblNoReporte5, lblNoReporte6);
        estDictamenes = Arrays.asList(lblEstadoDic1, lblEstadoDic2, 
                lblEstadoDic3, lblEstadoDic4, lblEstadoDic5, lblEstadoDic6);
        fechaDicamenes = Arrays.asList(lblFechaDic1, lblFechaDic2, lblFechaDic3, 
                lblFechaDic4, lblFechaDic5, lblFechaDic6);
        selecNoReportes = Arrays.asList(rbtnNoReporte1, rbtnNoReporte2, 
                rbtnNoReporte3, rbtnNoReporte4, rbtnNoReporte5, rbtnNoReporte6);
        agregarEventHandlerRb();
    }
    
    @FXML
    private void cancelar(ActionEvent event){
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cliente_transitoGUI/GUIMenu.fxml"));
        try {

            Parent logIn = loader.load();
            GUIMenuController controller = loader.getController();
            controller.recibirParametros(telConductor, conexiones);
            Scene scene = new Scene(logIn);
            Stage stage = new Stage();
            stage.setTitle("Menu Principal");
            stage.setScene(scene);
            stage.show();

            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (IOException ex) {

            Logger.getLogger(RegistrarConducController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void verDetalleReporte(ActionEvent event){
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().
                getResource("/cliente_transitoGUI/GUIReporteDict.fxml"));
        determinarReporteElegido();
        determinarDictamenElegido();
        List<Object> recursosPReporteDict = Arrays.asList(reporteElegido, 
                dictamenElegido, telConductor, conexiones);
        try {

            Parent logIn = loader.load();
            ReporteDictController controller = loader.getController();
            controller.recibirParametros(recursosPReporteDict);
            Scene scene = new Scene(logIn);
            Stage stage = new Stage();
            stage.setTitle("Detalle de reporte");
            stage.setScene(scene);
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (IOException ex) {

            Logger.getLogger(RegistrarConducController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void seleccionarReporte(ActionEvent event){
        
        ///((Button) event.getSource()).equals(btnFotografia4)
    }
    
    @FXML
    private void cambiarPagina(ActionEvent event){
        
    }

    void recibirParametros(String telConductor, Conexiones conexiones) {

        this.telConductor = telConductor;
        this.conexiones = conexiones;
        recuperarListaReportes();
        recuperarListaDictamen();
    }

    private void recuperarListaReportes() {
        
        try {

           misReportes = conexiones.consultarReporte(Long.parseLong(telConductor));
           asignarNoReporte(1);
           mostrarBotones(1);
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

    private void asignarNoReporte(int noPagina) {
        
        int numeroRep = 0;
        int limNumeroRep = 0;
        if(noPagina > 1){
            
            numeroRep = Integer.parseInt(lblNoReporte6.getText()) + 1;
            limNumeroRep = misReportes.size() - numeroRep;
        } else {
            
            numeroRep = 1;
            
            if(misReportes.size() > 6){
                
                limNumeroRep = 6;
            } else {
                
                limNumeroRep = misReportes.size();
            }
        }
        for(int i = 0; i < limNumeroRep; i++){
            
            noReportes.get(i).setText(String.valueOf(numeroRep));
            numeroRep++;
        }
    }
    

    private void recuperarListaDictamen() {
        
        try {
            
            List<Integer> foliosUnicos = crearListaFUnicos(misReportes);
            misDictamenes = conexiones.consultarDictamen(foliosUnicos);
            asignarEstadoDictamen(1);
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
            Logger.getLogger(ConsultaReportesController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    private List<Integer> crearListaFUnicos(List<Reporte> misReportes) {
        
        List<Integer> foliosUnicos = new ArrayList();
        for(int i = 0; i < misReportes.size(); i++){
            
            foliosUnicos.add(misReportes.get(i).getFolioUnico_dictamen());
        }
        return foliosUnicos;
    }

    private void asignarEstadoDictamen(int noPagina) {
        
        int limNumeroRep = 0;
        
        if (misReportes.size() > 6) {

            limNumeroRep = 6;
        } else {

            limNumeroRep = misReportes.size();
        }
        for (int i = 0; i < limNumeroRep; i++){
            
            if (misReportes.get(i).getFolioUnico_dictamen() != 0) {

                estDictamenes.get(i).setText("Ya tiene dictamen");
                fechaDicamenes.get(i).setText(misDictamenes.get(i).getFechaHora());
            } else {
                
                estDictamenes.get(i).setText("Todavia no hay dictamen");
                fechaDicamenes.get(i).setText("-");
            }
        }
    }

    private void mostrarBotones(int noPagina) {
        
        int limNumeroRep = 0;
        
        if (misReportes.size() > 6) {

            limNumeroRep = 6;
        } else {

            limNumeroRep = misReportes.size();
        }
        
        for (int i = 0; i < limNumeroRep; i++){
            
            if (misReportes.get(i).getFolioUnico_dictamen() != 0) {
                
                selecNoReportes.get(i).setVisible(true);
                selecNoReportes.get(i).setDisable(false);
            } 
        }
    }

    private void agregarEventHandlerRb() {
        
        EventHandler<ActionEvent> manejadorEventoParticipante = this::click_rbReporte;
        for(int i = 0; i < selecNoReportes.size(); i++){
            
            selecNoReportes.get(i).setOnAction(manejadorEventoParticipante);
        }
    }
    
    private void click_rbReporte(ActionEvent event) {

        RadioButton rbFuente = (RadioButton) event.getSource();
        seleccionReporte = rbFuente.getId();
        for(int i = 0; i < selecNoReportes.size(); i++){
            
            if(!selecNoReportes.get(i).getId().equals(seleccionReporte)){
                
                selecNoReportes.get(i).setSelected(false);
            }
        }
    }

    private void determinarDictamenElegido() {
        
        String[] partesIdRb = seleccionReporte.split("Reporte");
        String[] partesIdLblDict;      
        for(int i = 0; i < selecNoReportes.size(); i++){
            
            partesIdLblDict = fechaDicamenes.get(i).getId().split("FechaDic");
            if(partesIdRb[1].equals(partesIdLblDict[1])){
                
                for(int j = 0; j < misDictamenes.size(); j++){
                    
                    if(fechaDicamenes.get(i).getText().equals(
                            misDictamenes.get(j).getFechaHora())){
                        
                        dictamenElegido = misDictamenes.get(j);
                    }
                }
            }
        }
    }

    private void determinarReporteElegido() {
        
        String[] partesIdRb = seleccionReporte.split("Reporte");
        String[] partesIdLblRep;      
        for(int i = 0; i < selecNoReportes.size(); i++){
            
            partesIdLblRep = noReportes.get(i).getId().split("NoReporte");
            if(partesIdRb[1].equals(partesIdLblRep[1])){
                        
                reporteElegido = misReportes.get(i);
            }
        }
    }


}