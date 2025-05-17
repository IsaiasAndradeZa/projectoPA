package controller;

import model.Usuario;

public class fotoMostrar extends abstractMostrar {

    public fotoMostrar() {
    }

    public String obtenerFotoPerfil(){
        System.out.print("\nEJECUTANDOSE...");
        Usuario user = Sesion.getUsuarioActual(); 
        System.out.print("\nUSUARIO RETORNADO DESDE METODO FOTO: " + (user != null ? user.getNombreUsuario() : "NULL"));
        if (user != null){
             System.out.print("\nFOTO DE PERFIL: " + user.getRutaPerfil());
             return user.getRutaPerfil();
             
        } else {
            System.out.print("\nUSUARIO NULO DESDE FOTO");
        }
        return "\nNULO DESDE FOTO";
    }
    
    @Override
    protected String obtenerInformacion() {
        return obtenerFotoPerfil();
    }
    
}
