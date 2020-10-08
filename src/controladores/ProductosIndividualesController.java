package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import controladores.Grafico.codigo.DataSistema;
import controladores.Grafico.codigo.Producto;

public class ProductosIndividualesController implements Initializable {

    @FXML
    private TextField txtProducto;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidad;
    @FXML
    private Button btnAgregarProducto;
    @FXML
    private Button btnModificarProducto;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private TableView <Producto> tableProducto;

    private ObservableList<Producto> productos;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colProducto;
    @FXML
    private TableColumn<?, ?> colPrecio;
    @FXML
    private TableColumn<?, ?> colCantidad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        productos = FXCollections.observableArrayList();


        this.colProducto.setCellValueFactory(new PropertyValueFactory("producto"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colId.setCellValueFactory(new PropertyValueFactory("id"));


        Producto producto1 = new Producto("sensor de sigüeñal",350,15);
        this.productos.add(producto1);
        this.tableProducto.setItems(productos);

        Producto producto2 = new Producto("escape",580,5);
        this.productos.add(producto2);
        this.tableProducto.setItems(productos);

        Producto producto3 = new Producto("Selenoide",488,9);
        this.productos.add(producto3);
        this.tableProducto.setItems(productos);

        Producto producto4 = new Producto("Bujia",260,11);
        this.productos.add(producto4);
        this.tableProducto.setItems(productos);

        Producto producto5 = new Producto("filtro de aire",59,25);
        this.productos.add(producto5);
        this.tableProducto.setItems(productos);

        Producto producto6 = new Producto("Barilla Direccional",1800,7);
        this.productos.add(producto6);
        this.tableProducto.setItems(productos);

        Producto producto7 = new Producto("Flechas",350,8);
        this.productos.add(producto7);
        this.tableProducto.setItems(productos);

        Producto producto8 = new Producto("Bateria",891,19);
        this.productos.add(producto8);
        this.tableProducto.setItems(productos);

        DataSistema Data = new DataSistema();
        Data.productos.add(producto1);
        Data.productos.add(producto2);
        Data.productos.add(producto3);
        Data.productos.add(producto4);
        Data.productos.add(producto5);
        Data.productos.add(producto6);
        Data.productos.add(producto7);
        Data.productos.add(producto8);
    }

    @FXML
    private void AgregarProducto(ActionEvent event) {
        try{

            String producto = this.txtProducto.getText();
            int precio = Integer.parseInt(this.txtPrecio.getText());
            int cantidad = Integer.parseInt(this.txtCantidad.getText());

            Producto pro = new Producto(producto, precio, cantidad);

            if(!this.productos.contains(pro)){
                this.productos.add(pro);
                this.tableProducto.setItems(productos);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Detalles");
                alert.setContentText("Añadido exitosamente: "+pro.toString());
                alert.showAndWait();

                DataSistema Data = new DataSistema();
                Data.productos.add(pro);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Alerta");
                alert.setContentText("Producto ya Existente");
                alert.showAndWait();
            }

        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText("");
            alert.showAndWait();
        }
    }

    @FXML
    private void ModificarProducto(ActionEvent event) {
        Producto i = this.tableProducto.getSelectionModel().getSelectedItem();

        if(i == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText("NO a seleccionado ningun producto");
            alert.showAndWait();
        }else{
            try{

                String producto = this.txtProducto.getText();
                int precio = Integer.parseInt(this.txtPrecio.getText());
                int unidades = Integer.parseInt(this.txtCantidad.getText());

                Producto aux = new Producto(producto, precio, unidades);

                if(!this.productos.contains(aux)){

                    i.setProducto(aux.getProducto());
                    i.setPrecio(aux.getPrecio());
                    i.setCantidad(aux.getCantidad());

                    this.tableProducto.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Informacion");
                    alert.setContentText("Modificado Exitosamente");
                    alert.showAndWait();

                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Alerta");
                    alert.setContentText("producto ya existente");
                    alert.showAndWait();
                }

            }catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Alerta");
                alert.setContentText("a ingresado mal un parametro");
                alert.showAndWait();
            }
        }

    }

    @FXML
    private void EliminarProducto(ActionEvent event) {
        Producto i = this.tableProducto.getSelectionModel().getSelectedItem();

        if(i == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText("Seleccione una fila");
            alert.showAndWait();
        }else{

            this.productos.remove(i);
            this.tableProducto.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Eliminacion Exitosa");
            alert.showAndWait();
        }

    }

    @FXML
    private void seleccionar(MouseEvent event) {
        Producto i = this.tableProducto.getSelectionModel().getSelectedItem();

        if(i!= null){
            this.txtProducto.setText(i.getProducto());
            this.txtPrecio.setText(i.getPrecio()+"");
            this.txtCantidad.setText(i.getCantidad()+ "");
        }
    }

}
