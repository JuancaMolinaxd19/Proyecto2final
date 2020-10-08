package controladores;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PrimerPantallaController implements Initializable {
    @FXML
    private MenuItem UsuariosIndividual;
    @FXML
    private MenuItem ProductosIndividual;
    @FXML
    private MenuItem CambiosIndividual;
    @FXML
    private MenuBar Menu;
    @FXML
    private Menu ClientesIndividuales;
    @FXML
    private Menu ClientesEmpresa;
    @FXML
    private Menu Productos;


    //Inicializamos los controladores.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    @FXML
    private void UsuariosIndividual(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/controladores/Grafico/UsuariosIndividuales.fxml"));

            Parent root = loader.load();

            UsuariosIndividualesController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Logger.getLogger(UsuariosIndividualesController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void ProductosIndividual(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/controladores/Grafico/ProductosIndividuales.fxml"));

            Parent root = loader.load();


            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Logger.getLogger(ProductosIndividualesController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void CambioIndividual(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/controladores/Grafico/CambiosIndividuales.fxml"));

            Parent root = loader.load();

            CambiosIndividualesController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Logger.getLogger(CambiosIndividualesController.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
