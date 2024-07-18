
package Class;

import java.time.Duration;
import java.util.Date;

public class Peliculas {
    private String nombre;
    private Duration duracion;
    private String genero;
    private double totalRecaudado;
    private Date fecheEstreno;

    public Peliculas() {
    }

    public Peliculas(String nombre, Duration duracion, String genero, double totalRecaudado, Date fecheEstreno) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.totalRecaudado = totalRecaudado;
        this.fecheEstreno = fecheEstreno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public Date getFecheEstreno() {
        return fecheEstreno;
    }

    public void setFecheEstreno(Date fecheEstreno) {
        this.fecheEstreno = fecheEstreno;
    }
}
