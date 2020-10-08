package controladores.Grafico.codigo;

public class Producto {
    // Metodos

    // Creacion y Declara los variables
    private int id;
    private String producto;
    private int precio;
    private int cantidad;
    static int sigIdProducto=2000;

    public Producto() { // Esto agrega un constructor sin parametros
        this.id = this.getIdProducto();
        this.producto= "";
        this.precio = 0;
        this.cantidad = 0;
    }
    // Esto agrega un constructor con los parametros necesarios
    public Producto(String producto, int precio, int cantidad) {
        this.id = this.getIdProducto();
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;

    }

    // Declara los parametros en cada atributo
    public int getIdProducto(){
        return sigIdProducto++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCentral() // esto cambie
    { // Enlaza este metodo y atributo a todas las clases posible del modelo
        return this.getClass().getName();
    }

    @Override
    //creacion del metodo toString
    public String toString() {
        return "[" + this.getCentral() + "]" + // enlazamos getcentral aqui
                "id=" + id +
                ", producto="  + producto +
                ", precio=" + precio +
                ", cantidad" + cantidad +
                '}';
    }

}
