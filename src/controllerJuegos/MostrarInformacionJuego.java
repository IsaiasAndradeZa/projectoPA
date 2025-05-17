package controllerJuegos;

import model.GameDates;

public class MostrarInformacionJuego extends abstractMostrarJuego {

    public MostrarInformacionJuego() {
    }
    
    GameDates obtener = Juego.getJuego();
    
    public String obtenerTitulo(){
        if (obtener != null){
             System.out.print("\nFOTO DE PERFIL: " + obtener.getTitulo());
             return obtener.getTitulo();
             
        } else {
            System.out.print("\nNULO DESDE obtenerTitulo");
        }

        return "\nNULO DESDE obtenerTitulo";
    }
    
    public String obtenerPortada(){
        if (obtener != null){
             System.out.print("\nobtenerPortada: " + obtener.getRutaImagen());
             return obtener.getRutaImagen();
             
        } else {
            System.out.print("\n NULO DESDE obtenerPortada");
        }
        return "\nNULO DESDE obtenerPortada";
    }
    
    public String obtenerDescripcion(){
        GameDates obtener = Juego.getJuego(); 
        if (obtener != null){
             System.out.print("\nOBTENER DE obtenerDescripcion: " + obtener.getDescripcion());
             return obtener.getDescripcion();
             
        } else {
            System.out.print("\n NULO DESDE obtenerDescripcion");
        }
        return "\nNULO DESDE obtenerDescripcion";
    }
    
    public String obtenerPlataforma(){
        
        if (obtener != null){
             System.out.print("\nOBTENER DE obtenerPlataforma: " + obtener.getPlataformas());
             return obtener.getPlataformas();
             
        } else {
            System.out.print("\nNULO DESDE obtenerPlataforma");
        }
        return "\nNULO DESDE obtenerPlataforma";
        
    }
    
    public String obtenerDesarrollador(){
        if (obtener != null){
             System.out.print("\nOBTENER DE obtenerDesarrollador: " + obtener.getDesarrolladores());
             return obtener.getDesarrolladores();
             
        } else {
            System.out.print("\n NULO DESDE obtenerDesarrollador");
        }

        return "\nNULO DESDE obtenerDesarrollador";
    }
    
    public String obtenerGeneros(){

        if (obtener != null){
             System.out.print("\nOBTENER DE obtenerGeneros: " + obtener.getGenero());
             return obtener.getGenero();
             
        } else {
            System.out.print("\n NULO obtenerGeneros");
        }

        return "\nNULO DESDE obtenerGeneros";
    }
    
    public String obtenerFecha(){

        if (obtener != null){
             System.out.print("\nOBTENER DE obtenerFecha: " + obtener.getFecha());
             return obtener.getFecha();
             
        } else {
            System.out.print("\n NULO DESDE obtenerFecha");
        }
        return "\nNULO DESDE obtenerFecha";
    }
    
    public String obtenerNominaciones(){
       
        if (obtener != null){
             System.out.print("\nOBTENER DE obtenerNominaciones: " + obtener.getNominaciones());
             return obtener.getNominaciones();
             
        } else {
            System.out.print("\n NULO DESDE obtenerNominaciones");
        }

        return "\nNULO DESDE obtenerNominaciones";
    }

    public String obtenerPremios(){
 if (obtener != null){
             System.out.print("\nOBTENER DE obtenerPremios: " + obtener.getPremios());
             return obtener.getPremios();
             
        } else {
            System.out.print("\nNULO DESDE obtenerPremios");
        }
        return "\nNULO DESDE obtenerPremios";
    }
    
    public String obtenerDiseñadores(){
        if (obtener != null){
             System.out.print("\nOBTENER DE obtenerDiseñadores: " + obtener.getPremios());
             return obtener.getDiseñadores();
             
        } else {
            System.out.print("\nNULO DESDE obtenerDiseñadores");
        }

        return "\nNULO DESDE obtenerDiseñadores";
    }
    
    
    
    @Override
    protected String obtenerInformacionJuego() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
