import java.util.Objects;

public class Contacto {
    String nombre;
  public Contacto (String nombre){
      this.nombre=nombre;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(nombre, contacto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre;
    }
}
