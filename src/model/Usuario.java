package model;
public class Usuario {
    private String nombreUsuario;
    private String correo;
    private String contraseña;
    private String descripcion;
    private String rutaPerfil;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String correo, String contraseña, String descripcion, String rutaPerfil) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.descripcion = descripcion;
        this.rutaPerfil = rutaPerfil;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaPerfil() {
        return rutaPerfil;
    }

    public void setRutaPerfil(String rutaPerfil) {
        this.rutaPerfil = rutaPerfil;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", descripcion=" + descripcion + ", rutaPerfil=" + rutaPerfil + '}';
    }

    
}

