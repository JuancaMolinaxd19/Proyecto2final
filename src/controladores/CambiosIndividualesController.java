package controladores;

import java.net.URL;
import java.util.ArrayList.*;
import java.util.ResourceBundle;
import controladores.Grafico.codigo.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class CambiosIndividualesController implements Initializable {


    @FXML
    private TextField txtUnidades;
    @FXML
    private TextField txtIdCliente;
    @FXML
    private TextField txtIdProducto;
    @FXML
    private TableView tableOrdenes;
    @FXML
    private Button btnCrear;
    @FXML
    private TableColumn<?, ?> colCliente;
    @FXML
    private TableColumn<?, ?> colProducto;
    @FXML
    private TableColumn<?, ?> colUnidades;

    private ObservableList<Individual> individuales;

    private ObservableList<Producto> pro;


    //Initializando el controlador correspondiente

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        individuales = FXCollections.observableArrayList();
        pro = FXCollections.observableArrayList();

        this.colCliente.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colProducto.setCellValueFactory(new PropertyValueFactory("producto"));
        this.colUnidades.setCellValueFactory(new PropertyValueFactory("Unidades"));
    }

    @FXML
    private void crearorden(ActionEvent event) {
        DataSistema Data = new DataSistema();
        individuales = FXCollections.observableArrayList();
        pro = FXCollections.observableArrayList();
        //Orden Or = new Orden();
        //Cliente cl = new Cliente();
        int cliente = Integer.parseInt(this.txtIdCliente.getText());
        int Unidades = Integer.parseInt(this.txtUnidades.getText());
        int producto = Integer.parseInt(this.txtIdProducto.getText());


        if((!Data.Individual.contains(cliente))&& (!Data.productos.contains(producto))){
            for(int i = 0;i==Data.Individual.size();i++){
                Data.Individual.contains(i);
                this.tableOrdenes.setItems(individuales);
                for(int j = 0;j==Data.productos.size();j++){
                    Data.productos.contains(i);
                    this.tableOrdenes.setItems(pro);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Producto añadido");
                    alert.showAndWait();
                }
            }
        }
        else{

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Orden NO generada");
            alert.setContentText("Orden no Generada vuelva a intentar");
            alert.showAndWait();
        }
    }
}