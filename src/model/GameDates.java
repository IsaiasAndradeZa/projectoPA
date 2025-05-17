package model;

public class GameDates {

    private String titulo;
    private String genero;
    private String plataformas;
    private String desarrolladores;
    private String nominaciones;
    private String premios;
    private String diseñadores;
    private String fecha;  
    private String descripcion;
    private String rutaImagen;
    
    public GameDates() {
    }

    public GameDates(String titulo, String genero, String plataformas, String desarrolladores,
            String nominaciones, String premios, String diseñadores, String fecha, String descripcion, String rutaImagen) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataformas = plataformas;
        this.desarrolladores = desarrolladores;
        this.nominaciones = nominaciones;
        this.premios = premios;
        this.diseñadores = diseñadores;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }

    public String getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(String desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    public String getNominaciones() {
        return nominaciones;
    }

    public void setNominaciones(String nominaciones) {
        this.nominaciones = nominaciones;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getDiseñadores() {
        return diseñadores;
    }

    public void setDiseñadores(String diseñadores) {
        this.diseñadores = diseñadores;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "GameDates{" + "titulo=" + titulo + ", genero=" + genero + ", plataformas=" + plataformas + ", desarrolladores=" + desarrolladores + ", nominaciones=" + nominaciones + ", premios=" + premios + ", dise\u00f1adores=" + diseñadores + ", fecha=" + fecha + ", descripcion=" + descripcion + ", ruta=" + rutaImagen + '}';
    }

        

}
