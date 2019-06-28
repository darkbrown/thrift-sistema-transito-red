package cliente_transitoController;

import Thrift.Conductor;
import Thrift.Conexiones;
import Thrift.ErrorBD;
import Thrift.Reporte;
import Thrift.Vehiculo;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.thrift.TException;

public class ReporteConducController implements Initializable {

    @FXML
    private CheckBox cbVehiculoPropio;
    @FXML
    private CheckBox cbNoVehiculoPropio;
    @FXML
    private MenuButton mbVehiculoPropio;
    @FXML
    private TextField tfMarcaPropio;
    @FXML
    private TextField tfModeloPropio;
    @FXML
    private TextField tfAnoPropio;
    @FXML
    private TextField tfColorPropio;
    @FXML
    private TextField tfNPlacaPropio;
    @FXML
    private TextField tfMarcaOtro;
    @FXML
    private TextField tfModeloOtro;
    @FXML
    private TextField tfNombreOtro;
    @FXML
    private TextField tfColorOtro;
    @FXML
    private TextField tfNPlacaOtro;
    @FXML
    private TextField tfNAseguradoraOtro;
    @FXML
    private TextField tfNPolizaOtro;
    @FXML
    private TextField tfLongitud;
    @FXML
    private TextField tfLatitud;
    @FXML
    private Button btnFotografia1;
    @FXML
    private Button btnFotografia2;
    @FXML
    private Button btnFotografia3;
    @FXML
    private Button btnFotografia4;
    @FXML
    private Button btnFotografia5;
    @FXML
    private Button btnFotografia6;
    @FXML
    private Button btnFotografia7;
    @FXML
    private Button btnFotografia8;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;

    private String telConductor;
    private String seleccionVehiculo;
    private Conexiones conexiones;
    private List<Vehiculo> misVehiculos;
    private String numPlacaPropia;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
            stage.setScene(scene);
            stage.show();

            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (IOException ex) {

            Logger.getLogger(RegistrarConducController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registrarReporte(ActionEvent event) {
        
        try {

            if (registrarVehiculoReporte()) {

                boolean registro = conexiones.registrarReporte(reportelleno(),
                        Long.parseLong(telConductor));
                System.out.println("registro " + registro);
                //registro = conexiones.registrarFotografia(guardarImagen(), Long.parseLong(telConductor));
                registro = asociarVehiculos(numPlacaPropia);
                if (registro == false) {

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
                    alert.setContentText("Se ha hecho el registro con exito");
                    alert.showAndWait();
                    btnCancelar.setText("Regresar");
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

            Logger.getLogger(ReporteConducController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void agregarFotografia(ActionEvent event) throws IOException {

        if (((Button) event.getSource()).equals(btnFotografia4)) {

            activarTodosBotones();
        }
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);
        fileChooser.setTitle("Selecciona una imagen");
        Stage stage = new Stage();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {

            Image image = new Image(file.toURI().toString());

            //String pathImage = file.toPath().toString();
            //((Button) event.getSource()).setAccessibleText(pathImage);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(76);
            imageView.setFitHeight(17);
            ((Button) event.getSource()).setText("");
            ((Button) event.getSource()).setGraphic(imageView);
        }
    }

    @FXML
    private void seleccionarVehiculoPropio(ActionEvent event) {

        if (cbVehiculoPropio.equals((CheckBox) event.getSource())) {

            cbNoVehiculoPropio.setSelected(false);
            mbVehiculoPropio.setDisable(false);
            tfMarcaPropio.setDisable(true);
            tfModeloPropio.setDisable(true);
            tfAnoPropio.setDisable(true);
            tfColorPropio.setDisable(true);
            tfNPlacaPropio.setDisable(true);
        } else {

            cbVehiculoPropio.setSelected(false);
            mbVehiculoPropio.setDisable(true);
            tfMarcaPropio.setDisable(false);
            tfModeloPropio.setDisable(false);
            tfAnoPropio.setDisable(false);
            tfColorPropio.setDisable(false);
            tfNPlacaPropio.setDisable(false);
        }
    }

    void recibirParametros(String telConductor, Conexiones conexiones) {

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
                mbVehiculoPropio.getItems().add(
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
        } catch (TException ex) {
            Logger.getLogger(AdministrarVehiculoController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    private void click_listaVehiculo(ActionEvent event) {

        CustomMenuItem cmFuente = (CustomMenuItem) event.getSource();
        CheckBox vehiculo = (CheckBox) cmFuente.getContent();
        seleccionVehiculo = vehiculo.getText();
    }

    private CustomMenuItem llenarListaVehiculo(String nombreVehiculo,
            EventHandler<ActionEvent> manejadorEvento) {

        CustomMenuItem nuevoMenuItem
                = new CustomMenuItem(new CheckBox(nombreVehiculo), false);
        nuevoMenuItem.setOnAction(manejadorEvento);
        return nuevoMenuItem;
    }

    private Reporte reportelleno() {

        Reporte nuevoReporte = new Reporte();
        nuevoReporte.setLongitud(tfLongitud.getText());
        nuevoReporte.setLatitud(tfLatitud.getText());
        nuevoReporte.setNombreOtroConduc(tfNombreOtro.getText());
        return nuevoReporte;
    }

    private boolean asociarVehiculos(String numPlacaPropia) {
        
        boolean exito = false;
        try {
            List<String> numPLacas = Arrays.asList(
                    tfNPlacaOtro.getText(), numPlacaPropia);
            exito = conexiones.asociarVehiculoReporte(numPLacas,
                    Long.parseLong(telConductor));
            if (exito == false) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Perdida conexion");
                alert.setHeaderText(null);
                alert.setContentText("No hay conexión con la base de datos, "
                        + "vuelve a intentarlo");
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
            Logger.getLogger(ReporteConducController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }

    private boolean registrarVehiculoReporte() {

        boolean exito = false;
        try {

            if (cbNoVehiculoPropio.isSelected()) {

                Vehiculo miVehiculoReporte = crearVehiculo();
                numPlacaPropia = conexiones.registrarVehiculoReporte(miVehiculoReporte);
                if (numPlacaPropia == null) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Perdida conexion");
                    alert.setHeaderText(null);
                    alert.setContentText("No hay conexión con la base de datos, "
                            + "vuelve a intentarlo");
                    alert.showAndWait();
                }
            } else {

                String[] parteVehiculo = seleccionVehiculo.split("  ");
                numPlacaPropia = parteVehiculo[1];
            }

            if (numPlacaPropia != null) {

                exito = true;
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

    private Vehiculo crearVehiculo() {

        Vehiculo vehiculoReporte = new Vehiculo();

        vehiculoReporte.setColor(tfColorPropio.getText());
        vehiculoReporte.setMarca(tfMarcaPropio.getText());
        vehiculoReporte.setModelo(tfModeloPropio.getText());
        vehiculoReporte.setNumPlaca(tfNPlacaPropio.getText());
        vehiculoReporte.setAno(Integer.parseInt(tfAnoPropio.getText()));

        return vehiculoReporte;
    }

    public List<String> guardarImagen() {///
        
        List<Button> botonesFotografia = llenarListaFotografia();
        List<String> listaPaths = crearListaPaths();
        /*
        for (int i = 0; i < botonesFotografia.size(); i++) {

            File outputFile = new File(listaPaths.get(i));
            ImageView imageViewAdjusted = (ImageView) botonesFotografia.get(i).getGraphic();
            imageViewAdjusted.setFitWidth(150);
            imageViewAdjusted.setFitHeight(150);
            outputFile.getParentFile().mkdirs();
            BufferedImage bImage = SwingFXUtils.
                    fromFXImage(imageViewAdjusted.snapshot(null, null), null);
            try {

                ImageIO.write(bImage, "png", outputFile);
                imageViewAdjusted.setFitWidth(85);
                imageViewAdjusted.setFitHeight(85);
            } catch (IOException | NullPointerException ex) {

                Logger.getLogger(ReporteConducController.class.
                        getName()).log(Level.SEVERE, null, ex);
            } finally {

                imageViewAdjusted.setFitWidth(85);
                imageViewAdjusted.setFitHeight(85);
            }
            ///try {
                File imagen = new File(botonesFotografia.get(i).getAccessibleText());
                BufferedImage bufferedImage = ImageIO.read(imagen);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", baos);
                baos.flush();
                byte[] imageInByte = baos.toByteArray();
                baos.close();
                ByteBuffer foto = ByteBuffer.wrap(imageInByte);
                fotografias.add(foto);
            } catch (IOException ex) {
                Logger.getLogger(ReporteConducController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        return listaPaths;
    }

    private void activarTodosBotones() {

        btnFotografia5.setDisable(false);
        btnFotografia5.setVisible(true);
        btnFotografia6.setDisable(false);
        btnFotografia6.setVisible(true);
        btnFotografia7.setDisable(false);
        btnFotografia7.setVisible(true);
        btnFotografia8.setDisable(false);
        btnFotografia8.setVisible(true);
    }

    private List<Button> llenarListaFotografia() {

        List<Button> botonesFoto = new ArrayList();
        if (btnFotografia1.getText().equals("")) {

            botonesFoto.add(btnFotografia1);
        }
        if (btnFotografia2.getText().equals("")) {

            botonesFoto.add(btnFotografia2);
        }
        if (btnFotografia3.getText().equals("")) {

            botonesFoto.add(btnFotografia3);
        }
        if (btnFotografia4.getText().equals("")) {

            botonesFoto.add(btnFotografia4);
        }
        if (btnFotografia5.getText().equals("")) {

            botonesFoto.add(btnFotografia5);
        }
        if (btnFotografia6.getText().equals("")) {

            botonesFoto.add(btnFotografia6);
        }
        if (btnFotografia7.getText().equals("")) {

            botonesFoto.add(btnFotografia7);
        }
        if (btnFotografia8.getText().equals("")) {

            botonesFoto.add(btnFotografia8);
        }
        return botonesFoto;
    }

    private List<String> crearListaPaths() {

        List<String> paths = new ArrayList();
        int nCarpeta = (int) Math.random();
        for (int i = 0; i < 8; i++) {

            paths.add(".\\fotografia\\" + nCarpeta + "\\imagenReporte" + i + ".png");
        }
        return paths;
    }

}
