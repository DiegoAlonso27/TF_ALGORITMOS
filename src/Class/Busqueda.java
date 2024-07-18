package Class;


public class Busqueda {

    private String nombreBus;
    private String tipo;

    public Busqueda() {
    }

    public Busqueda(String nombreBus, String tipo) {
        this.nombreBus = nombreBus;
        this.tipo = tipo;
    }

    public String getNombreBus() {
        return nombreBus;
    }

    public void setNombreBus(String nombreBus) {
        this.nombreBus = nombreBus;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
