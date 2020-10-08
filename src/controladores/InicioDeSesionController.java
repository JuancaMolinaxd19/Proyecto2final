package controladores;


import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class InicioDeSesionController implements Initializable {
    @FXML private TextField txtUser;
    @FXML private PasswordField txtpassword;

    //iniciamos el control de clases
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    //Validamos si se cumple los parametros de nuestro usuario y su contrasena
    @FXML
    private void btmInicio(ActionEvent event) {
        //se loguea un usuario por default al que llamaremos "usuario"
        //con una contrasena "123456"
        if(txtUser.getText().equals("usuario") && txtpassword.getText().equals("123456")){

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/controladores/Grafico/PrimerPantalla.fxml"));
                //cargamos el controlador solicitado
                Parent root = loader.load();
                //3. cerrar la ventana de Login
                Stage stageLogin = (Stage) txtUser.getScene().getWindow();
                stageLogin.close();
                //abre pantalla principal
                PrimerPantallaController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("primer pantalla");
                //stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException e) {
                Logger.getLogger(InicioDeSesionController.class.getName()).log(Level.SEVERE, null, e);
            }
            // si alguno de los dos parametros no coincide nos presenta el siguiente error
        }else{
            JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecto!", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }
}