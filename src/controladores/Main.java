package controladores;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//extencion de programa como aplicacion
public class Main extends Application {

    @Override
    public void start(Stage Stage) {

        try {
            FXMLLoader loader = new FXMLLoader();
            //mandamos a llamar el inicio de Sesion
            loader.setLocation(Main.class.getResource("/controladores/Grafico/InicioDeSesion.fxml"));
            Pane pane = (Pane) loader.load();
            //Nos mostrara nuestra respectiva Scene
            Scene scene = new Scene(pane);
            Stage.setTitle("PROYECTO 2");
            Stage.setScene(scene);
            Stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
