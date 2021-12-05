package cl.doppler.trabajo2_franciscomora.Modelo;

public class Genero {

    private String idGenero;
    private String nombre;
    private String estado;

    public Genero() {
        this.idGenero= "";
        this.nombre= "";
        this.estado = "";
    }

    public Genero (String idGenero, String nombre, String estado)
    {
        this.idGenero=idGenero;
        this.nombre=nombre;
        this.estado=estado;
    }

    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero='" + idGenero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
