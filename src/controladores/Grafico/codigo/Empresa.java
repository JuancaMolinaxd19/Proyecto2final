package controladores.Grafico.codigo;


public class Empresa extends Cliente{ // La Clase Empresa se enlaza con la clase Clientes

    // Creacion y Declara los variables
    private String contacto;
    private int descuento;


    public Empresa(String contacto, int descuento, String nombre, String apellido, int telefono) { // Esto agrega un constructor con los parametros necesarios
        super(nombre, apellido, telefono);
        this.contacto = contacto;
        this.descuento = descuento;
    }


    // Declara los parametros en cada atributo
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

}
