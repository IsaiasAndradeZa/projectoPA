package controller;

import controllerJuegos.Juego;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.GameDates;
import model.Usuario;

public class Megusta {
    
    public Megusta() {
    }
    
  
    public  void agregarMeGusta(String tituloJuego) {
    Usuario usuarioActual = Sesion.getUsuarioActual();
    GameDates juegos = Juego.getJuego();
    if (usuarioActual == null) {
        System.out.println("No hay usuario en sesión.");
        return;
    }

    File archivoUsuario = new File("usuarios/" + usuarioActual.getNombreUsuario() + ".txt");

    if (!archivoUsuario.exists()) {
        System.out.println("El archivo del usuario no existe.");
        return;
    }

    //Escribir el nuevo juego favorito en el archivo
    try (BufferedWriter bf = new BufferedWriter(new FileWriter(archivoUsuario, true))) { // `true` para agregar sin borrar
        bf.write("JUEGO FAVORITO: " + tituloJuego + ";");
        bf.newLine();
        bf.flush();
        System.out.println(tituloJuego + "' agregado a favoritos de " + usuarioActual.getNombreUsuario());
    } catch (IOException e) {
        System.out.println("al escribir en el archivo: " + e.getMessage());
    }
}
        
    public List<String> obtenerMegusta(String nombreUsuario) {
    List<String> juegosFavoritos = new ArrayList<>();
    Usuario usuarioActual = Sesion.getUsuarioActual();
    
    if (usuarioActual == null) {
        System.out.println("No hay usuario en sesión.");
        return juegosFavoritos;
    }

    File archivoUsuario = new File("usuarios/" + usuarioActual.getNombreUsuario() + ".txt");

    if (!archivoUsuario.exists()) {
        System.out.println("El archivo del usuario no existe.");
        return juegosFavoritos;
    }

    try (BufferedReader bf = new BufferedReader(new FileReader(archivoUsuario))) {
        String linea;
        while ((linea = bf.readLine()) != null) {
            if (linea.startsWith("JUEGO FAVORITO: ")) { // Buscar títulos en el archivo
                String tituloJuego = linea.substring(linea.indexOf(":") + 1).trim();
                juegosFavoritos.add(tituloJuego);
            }
        }
    } catch (IOException e) {
        System.out.println("Error  al leer el archivo: " + e.getMessage());
    }

    return juegosFavoritos;
}
}
        
        

       



    

    

