package controladores.Grafico.codigo;

public class Cliente {

    // Creacion y Declara los variables
    protected int id;
    protected String nombre;
    protected String apellido;
    protected int telefono;
    static int sigIdCliente = 1;

    public Cliente() { // Esto agrega un constructor sin parametros
        this.id = this.getIdCliente();
        this.nombre = "";
        this.apellido = "";

    }
    // Esto agrega un constructor con los parametros necesarios
    public Cliente(String nombre, String apellido, int telefono) {
        this.id = this.getIdCliente();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;

    }

    // Declara los parametros en cada atributo

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdCliente(){
        return sigIdCliente++;
    }

    public String getCentral() // esto cambie
    { // Enlaza este metodo y atributo a todas las clases posible del modelo
        return this.getClass().getName();
    }

    @Override
    //Creacion del metodo toString
    public String toString() {
        return "["+ this.getCentral()+ "]" + // enlazamos getcentral aqui
                "id=" + id +
                ", nombre=" + nombre +
                ", apellido=" + apellido +
                '}';
    }

}