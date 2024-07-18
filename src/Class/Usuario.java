package Class;

public class Usuario {

    private int id;
    private String usuario;
    private String contraseña;
    private String correo;

    // Constructor sin argumentos
    public Usuario() {
    }

    public Usuario(int id, String usuario, String contraseña, String contraseña1) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
    }
    
    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
 

  
}
