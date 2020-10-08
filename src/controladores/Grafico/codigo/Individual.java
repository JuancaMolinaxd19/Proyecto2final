package controladores.Grafico.codigo;
import java.util.Objects;


public class Individual extends Cliente { // La Clase Individual se enlaza con la clase Clientes
    private String DPI;
    //constructor Individual con nombre, apellido, telefono y DPI
    public Individual(String nombre, String apellido, int telefono, String DPI) {
        super(nombre, apellido, telefono);
        this.DPI = DPI;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Individual other = (Individual) obj;
        if (!Objects.equals(this.DPI, other.DPI)) {
            return false;
        }
        return true;
    }
    // Declara los parametros en cada atributo
    public String getDpi() {
        return DPI;
    }

    public void setDpi(String DPI) {
        this.DPI = DPI;
    }
}