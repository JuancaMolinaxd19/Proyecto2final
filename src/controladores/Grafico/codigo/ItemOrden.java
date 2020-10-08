package controladores.Grafico.codigo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

class ItemOrden {

    // Creacion y Declara los variables
    private int noLinea;
    private int cantidad;
    private Producto producto;

    public ItemOrden(int noLinea, int cantidad, Producto producto) { // Esto agrega un constructor con los parametros necesarios
        this.noLinea = noLinea;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public String getCentral() // esto cambie
    { // Enlaza este metodo y atributo a todas las clases posible del modelo
        return this.getClass().getName();
    }

    @Override
    //creacion del metodo toString
    public String toString() {
        return "[" + this.getCentral()+ "]" // enlazamos getcentral aqui
                + "noLinea=" + noLinea +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }


}
