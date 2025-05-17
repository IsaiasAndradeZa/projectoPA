package controller;

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
import model.Usuario;
import controller.UsuarioController;

public class Comentarios {

     private final UsuarioController USUARIO = new UsuarioController();
    
    public Comentarios() {
    }
    
    public  void agregarComentario(String tituloJuego, String comentario) {
    Usuario usuarioActual = Sesion.getUsuarioActual();
    if (usuarioActual == null) {
        System.out.println("No hay usuario en sesión.");
        return;
    }

    File archivoUsuario = new File("usuarios/" + usuarioActual.getNombreUsuario() + ".txt");

    if (!archivoUsuario.exists()) {
        System.out.println("El archivo del usuario no existe.");
        return;
    }

    //Escribir el nuevo juego favorito en el archivo del usuario
    try (BufferedWriter bf = new BufferedWriter(new FileWriter(archivoUsuario, true))) { // `true` para agregar sin borrar
        bf.write("JUEGO COMENTADO: " + tituloJuego);
        bf.newLine();
        bf.flush();
        bf.write("COMENTARIO: " + comentario);
        bf.newLine();
        bf.flush();
        bf.newLine();
        bf.newLine();
        System.out.println(tituloJuego + "' COMENTARIO " + comentario);
    } catch (IOException e) {
        System.out.println("ERROR al escribir en el archivo: " + e.getMessage());
    }
}
        
    public Map<String, List<String>> obtenerComentariosDeTdos (){
        File carpetaUsuarios = new File("usuarios/");
        Map<String, List<String>> comentariosPorUser = new HashMap();
        
        //Comenzamos a recorrer todos los archivos de usuarios
        File[] archivoUser = carpetaUsuarios.listFiles((dir, name) -> name.endsWith(".txt"));
        if(archivoUser != null){
            for (File archivo : archivoUser){
                //Quitamos el ".txt" para mostrar solo el nombre
                String nombreUsuario = archivo.getName().replace(".txt", "");
                
                List<String> comentarios = new ArrayList<>();
                try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
                    String linea;
                    String juego = "";
                    while ((linea = bf.readLine()) != null){
                                if(linea.startsWith("JUEGO COMENTADO: ")){
                                   juego = linea.replace("JUEGO COMENTADO: ", "").trim();
                                   comentarios.add(juego);
                                } else if (linea.startsWith(("COMENTARIO: "))){
                                    String comentario = linea.replace("COMENTARIO: ", "").trim();
                                    comentarios.add("   " + comentario);
                                }
                             }
                } catch (IOException e){
                        System.out.print("\nERROR AL LEER" + archivo.getName() + " : " + e.getMessage());
                }
            if (!comentarios.isEmpty()){
                comentariosPorUser.put(nombreUsuario, comentarios);
            }
        }
    }
        return comentariosPorUser;
    }

    public List<String> obtenerComentariosUsuarioSesion() {
    String usuarioSesion = USUARIO.usuarioSesion(); // Obtener usuario actual

    if (usuarioSesion == null || usuarioSesion.isEmpty()) {
        System.out.println("No hay usuario en sesión.");
        return new ArrayList<>(); // Retorna lista vacía si no hay usuario en sesión
    }

    File archivoUsuario = new File("usuarios/" + usuarioSesion + ".txt");
    
    if (!archivoUsuario.exists()) {
        System.out.println("No se encontró el archivo del usuario.");
        return new ArrayList<>();
    }

    List<String> comentarios = new ArrayList<>();
    
    try (BufferedReader bf = new BufferedReader(new FileReader(archivoUsuario))) {
        String linea;
        String juego = "";
        while ((linea = bf.readLine()) != null) {
            if (linea.startsWith("JUEGO COMENTADO: ")) {
                juego = linea.replace("JUEGO COMENTADO: ", "").trim();
                comentarios.add(juego);
            } else if (linea.startsWith("COMENTARIO: ")) {
                String comentario = linea.replace("COMENTARIO: ", "").trim();
                comentarios.add("   " + comentario);
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo de usuario: " + e.getMessage());
    }

    return comentarios;
}
    
}
