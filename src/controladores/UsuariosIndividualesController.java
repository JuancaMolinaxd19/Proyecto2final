package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import controladores.Grafico.codigo.DataSistema;
import controladores.Grafico.codigo.Individual;

public class UsuariosIndividualesController implements Initializable {

    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDPI;
    @FXML
    private TableView<Individual> tableInformacion;
    @FXML
    private TableColumn colNombres;
    @FXML
    private TableColumn colApellidos;
    @FXML
    private TableColumn colTelefono;
    @FXML
    private TableColumn colDPI;
    @FXML
    private ObservableList<Individual> individuales;
    @FXML
    private TableColumn<?, ?> colID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        individuales = FXCollections.observableArrayList();


        this.colNombres.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        this.colDPI.setCellValueFactory(new PropertyValueFactory("dpi"));
        this.colID.setCellValueFactory(new PropertyValueFactory("id"));


        Individual persona1 = new Individual("Jose", "Jimenez", 35234221, "3030676670108");
        this.individuales.add(persona1);
        this.tableInformacion.setItems(individuales);

        Individual persona2 = new Individual("Juan", "Molina", 55742585, "3030676670108");
        this.individuales.add(persona2);
        this.tableInformacion.setItems(individuales);

        Individual persona3 = new Individual("Wilmer", "Hernandez", 33254725, "3030676670108");
        this.individuales.add(persona3);
        this.tableInformacion.setItems(individuales);

        Individual persona4 = new Individual("Estefani", "Ramirez", 57837099, "3030676670108");
        this.individuales.add(persona4);
        this.tableInformacion.setItems(individuales);

        DataSistema Data = new DataSistema();
        Data.Individual.add(persona1);
        Data.Individual.add(persona2);
        Data.Individual.add(persona3);
        Data.Individual.add(persona4);

    }

    @FXML
    private void AgregarRegistro(ActionEvent event) {
        try{

            String nombres = this.txtNombres.getText();
            String apellidos = this.txtApellidos.getText();
            int telefono = Integer.parseInt(this.txtTelefono.getText());
            String dpi = this.txtDPI.getText();

            Individual indivi = new Individual(nombres, apellidos, telefono, dpi);

            if(!this.individuales.contains(indivi)){

                this.individuales.add(indivi);
                this.tableInformacion.setItems(individuales);

                DataSistema Data = new DataSistema();
                Data.Individual.add(indivi);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText(indivi.toString());
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La persona ya existe");
                alert.showAndWait();
            }

        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }

    }

    @FXML
    private void eliminarRegistro(ActionEvent event) {
        Individual indivi = this.tableInformacion.getSelectionModel().getSelectedItem();

        if(indivi == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Seleccione un registro y vuelva a intentar");
            alert.showAndWait();
        }else{

            this.individuales.remove(indivi);
            this.tableInformacion.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Registro Eliminado");
            alert.showAndWait();

            DataSistema Data = new DataSistema();
            Data.Individual.remove(Data);
        }

    }

    @FXML
    private void modificarCliente(ActionEvent event) {
        Individual i = this.tableInformacion.getSelectionModel().getSelectedItem();

        if(i == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Seleccione un registro y vuelva a intentar");
            alert.showAndWait();
        }else{
            try{

                String nombres = this.txtNombres.getText();
                String apellidos = this.txtApellidos.getText();
                int telefono = Integer.parseInt(this.txtTelefono.getText());
                String dpi = this.txtDPI.getText();

                Individual aux = new Individual(nombres, apellidos, telefono, dpi);

                if(!this.individuales.contains(aux)){

                    i.setNombre(aux.getNombre());
                    i.setApellido(aux.getApellido());
                    i.setTelefono(aux.getTelefono());
                    i.setDpi(aux.getDpi());

                    this.tableInformacion.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Registro Modificado con exito");
                    alert.showAndWait();

                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Registro ya existente");
                    alert.showAndWait();
                }

            }catch(NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void seleccionar(MouseEvent event) {
        Individual indivi = this.tableInformacion.getSelectionModel().getSelectedItem();

        if(indivi!= null){
            this.txtNombres.setText(indivi.getNombre());
            this.txtApellidos.setText(indivi.getApellido());
            this.txtTelefono.setText(indivi.getTelefono()+ "");
            this.txtDPI.setText(indivi.getDpi());
        }

    }
}
