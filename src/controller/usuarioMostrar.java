package controller;

import model.Usuario;

public class usuarioMostrar extends abstractMostrar{

    public usuarioMostrar() {
    }
    
    public String obtenerUsuario(){
        Usuario user = Sesion.getUsuarioActual(); 
        if (user != null){
             System.out.print("\nUSUARIO DESDE METODO OBTENER USUARIO: " + user.getNombreUsuario());
             return user.getNombreUsuario();
             
        } else {
            System.out.print("\nUSUARIO NULO DESDE OBTENER USUARIO");
        }

        return "\nNULO DESDE OBTENER USUARIO";
    }

    @Override
    protected String obtenerInformacion() {
        
        return obtenerUsuario();
        
    }
    
    
    
}
