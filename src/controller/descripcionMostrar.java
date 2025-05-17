package controller;

import model.Usuario;

public class descripcionMostrar extends abstractMostrar{

    public descripcionMostrar() {
    }
  
    
    public String obtenerDescripcionsinparametro(){
        Usuario user = Sesion.getUsuarioActual(); 
        if (user != null){
             System.out.print("\nDESCRIPCION DESDE METODO DESCRIPCION SIN PARAMETROS: " + user.getDescripcion());
             return user.getDescripcion();
             
        } else {
            System.out.print("\nUSUARIO NULO DESDE METODO DESCRIPCION SIN PARAMETROS");
        }

        return "\nNULO DESDE DESCRIPCION SIN PARAMETROS";
    }

    @Override
    protected String obtenerInformacion() {
        
        return obtenerDescripcionsinparametro();
        
    }
}


