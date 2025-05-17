package controllerJuegos;

import java.io.*;
import java.util.*;
import model.GameDates;

public class InfoVideoJuegos {
    
    private GameDates dates;
    private String mensaje;
    
    private final String separador = File.separator;
    private final String ruta = System.getProperty("user.dir") + separador + "juegos" + separador;
    private final String extension = ".txt"; 
    
    public InfoVideoJuegos(){
        dates = new GameDates();
        mensaje = "";
        File directorioJuegos = new File(ruta);
        directorioJuegos.mkdir();
    } 
    
    public String juegos() {
        GameDates game = Juego.getJuego();
        return (game != null) ? game.getTitulo() : "Juego no encontrado";
    }

    public GameDates getDates() {
        return dates;
    }
    
    private void instanciaJuego(String titulo, String genero, String plataformas, String desarrolladores,
            String nominaciones, String premios, String diseñadores, String fecha, String descripcion, String rutaImagen){
        
        dates = new GameDates(titulo, genero, plataformas, desarrolladores,
            nominaciones, premios, diseñadores, fecha, descripcion, rutaImagen);
    }
    

    
    public String crearArchivojuego(String titulo, String genero, String plataformas, String desarrolladores,
            String nominaciones, String premios, String diseñadores, String fecha, String descripcion, String rutaImagen){
        
        instanciaJuego(titulo, genero, plataformas, desarrolladores,
            nominaciones, premios, diseñadores, fecha, descripcion, rutaImagen);

        File directorioJuegos = new File(ruta);
        File archivo = new File(ruta + titulo +  extension);
       
        if(!archivo.exists()){
          
            try (Formatter formatter = new Formatter(archivo)){
                formatter.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                                "TITULO: " + dates.getTitulo(),
                                "GENEROS: " + dates.getGenero(),
                                "PLATAFORMAS: " + dates.getPlataformas(),
                                "DESARROLLADOR: " + dates.getDesarrolladores(),
                                "NOMINACIONES: " + dates.getNominaciones(),
                                "PREMIOS: " + dates.getPremios(),
                                "DISEÑADORES: " + dates.getDiseñadores(),
                                "FECHA: " + dates.getFecha(),
                                "DESCRIPCION: " + dates.getDescripcion(),
                                "RUTA IMAGEN: " + dates.getRutaImagen());
                mensaje = "REGISTRO " + dates.getTitulo() + "ACTUALIZADO";
                Juego.setJuego(dates);
            } catch (IOException e) {
                mensaje = "ERROR, VUELVA A INTENTARLO";
                System.out.print(e.getMessage());
            }
        } else {
            mensaje = "ARCHIVO " + titulo + "NO EXISTE";
        }
        return mensaje;
    }

    public List<GameDates> cargarBiblioteca(String rutaArchivo) {
    List<GameDates> biblioteca = new ArrayList<>(); // Guardar múltiples juegos

    File carpetaJuegos = new File(rutaArchivo);
    File[] archivos = carpetaJuegos.listFiles((dir, name) -> name.endsWith(".txt")); // Filtrar archivos 

    if (archivos != null) {
        for (File archivo : archivos) {
            System.out.println("🔹 Leyendo archivo: " + archivo.getName());
            try (BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
                

                        String titulo = null,
                            genero = null,
                            plataformas = null,
                            desarrolladores = null,
                            nominaciones = null,
                            premios = null,
                            diseñadores = null,
                            fecha = null,
                            descripcion = null,
                            rutaImagen = null;                
                        String linea;

                while ((linea = bf.readLine()) != null) {
                    if(linea.startsWith("TITULO: ")){
                                    titulo = linea.split(":")[1].trim();
                                } else if (linea.startsWith("GENEROS: ")) {
                                    genero = linea.split(":")[1].trim();
                                } else if (linea.startsWith("PLATAFORMAS: ")) {
                                    plataformas = linea.split(":")[1].trim();
                                } else if (linea.startsWith("DESARROLLADOR: ")) {
                                    desarrolladores = linea.split(":")[1].trim();
                                } else if (linea.startsWith("NOMINACIONES: ")) {
                                    nominaciones = linea.split(":")[1].trim();
                                } else if (linea.startsWith("PREMIOS: ")) {
                                    premios = linea.split(":")[1].trim();
                                } else if (linea.startsWith("DISEÑADORES: ")) {
                                    diseñadores = linea.split(":")[1].trim();
                                } else if (linea.startsWith("FECHA: ")) {
                                    fecha = linea.split(":")[1].trim();
                                } else if (linea.startsWith("DESCRIPCION: ")) {
                                    descripcion = linea.split(":")[1].trim();
                                } else if (linea.startsWith("RUTA IMAGEN:")) {
                                    rutaImagen = linea.substring(linea.indexOf(":") + 1).trim();
                                    
                                }
                }

                if (titulo != null && rutaImagen != null) {
                    GameDates juego = new GameDates(titulo, genero, plataformas, desarrolladores,
            nominaciones, premios, diseñadores, fecha, descripcion, rutaImagen);
                    biblioteca.add(juego); // Agregar el juego 
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }

    System.out.println("Biblioteca cargada con " + biblioteca.size() + " juegos");
    return biblioteca;
}

    public Map<String, Object> leerDatosJuego(String tituloOriginal) {
        // Crear ruta completa al archivo
        String rutaArchivo = ruta + File.separator + tituloOriginal.replace(" ", "_") + extension;
        File archivoJuego = new File(rutaArchivo);
        
        System.out.println("Ruta generada en leerDatosJuego: " + archivoJuego.getAbsolutePath());
        System.out.println("Comprobando existencia: " + archivoJuego.exists());
        
        Map<String, Object> datos = new HashMap<>();

        // Inicializar listas para los campos múltiples
        datos.put("GENEROS", new ArrayList<String>());
        datos.put("PLATAFORMAS", new ArrayList<String>());
        datos.put("NOMINACIONES", new ArrayList<String>());
        datos.put("PREMIOS", new ArrayList<String>());

        // Inicializar campos de texto
        datos.put("TITULO", tituloOriginal); // Asignar el título
        datos.put("DESARROLLADOR", "");
        datos.put("DISEÑADORES", "");
        datos.put("FECHA", "");
        datos.put("DESCRIPCION", "");

        if (!archivoJuego.exists()) {
            System.out.println("Error el archivo del juego no existe: " + archivoJuego.getAbsolutePath());
            return datos;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivoJuego))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(":")) continue;

                String[] partes = linea.split(":", 2);
                if (partes.length < 2) continue;

                String clave = partes[0].trim();
                String valor = partes[1].trim();

                if (clave.equals("GENEROS") || clave.equals("PLATAFORMAS") ||
                    clave.equals("NOMINACIONES") || clave.equals("PREMIOS")) {
                    // Convertir el string separado por comas en una lista
                    List<String> listaValores = new ArrayList<>();
                    if (!valor.isEmpty()) {
                        listaValores = Arrays.asList(valor.split("\\s*,\\s*"));
                    }
                    datos.put(clave, listaValores);
                } else {
                    datos.put(clave, valor);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el juego: " + e.getMessage());
        }

        return datos;
    }

    public String actualizarDatosJuego(String tituloOriginal, String nuevoTitulo, List<String> generos, List<String> plataformas, 
                                  String desarrollador, List<String> nominaciones, List<String> premios, 
                                  String diseñadores, String fecha, String descripcion) {
    // Construir ruta de archivo original usando el título original
    File archivoOriginal = new File(ruta + File.separator + tituloOriginal.replace(" ", "_") + extension);
    
    if (!archivoOriginal.exists()) {
        return "Error: El archivo del juego no existe en " + archivoOriginal.getAbsolutePath();
    }
    

    File archivoNuevo = new File(ruta + File.separator + nuevoTitulo.replace(" ", "_") + extension);
    
    // Si el título ha cambiado
    boolean tituloHaCambiado = !tituloOriginal.equals(nuevoTitulo);
    
    // Escribir el nuevo archivo
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoNuevo))) {
        for (String linea : Arrays.asList(
            "TITULO: " + nuevoTitulo,
            "GENEROS: " + String.join(", ", generos),
            "PLATAFORMAS: " + String.join(", ", plataformas),
            "DESARROLLADOR: " + desarrollador,
            "NOMINACIONES: " + String.join(", ", nominaciones),
            "PREMIOS: " + String.join(", ", premios),
            "DISEÑADORES: " + diseñadores,
            "FECHA: " + fecha,
            "DESCRIPCION: " + descripcion
        )) {
            bw.write(linea);
            bw.newLine();
        }
    } catch (IOException e) {
        return "Error al actualizar el juego: " + e.getMessage();
    }
    
    // Si el titulo cambio y archivos son diferentes eliminar original
    if (tituloHaCambiado && !archivoOriginal.equals(archivoNuevo)) {
        if (!archivoOriginal.delete()) {
            // Si no se puede borrar el archivo original borrar nuevo y retornar un error
            archivoNuevo.delete();
            return "Error: No se pudo eliminar el archivo antiguo. La actualización se ha cancelado.";
        }
    }
    
    return "Juego actualizado correctamente. Nuevo archivo: " + archivoNuevo.getAbsolutePath();
}

    
    public List<String> obtenerListaJuegos() {
        List<String> nombresJuegos = new ArrayList<>();
        File dir = new File(ruta);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Error el directorio de juegos no existe: " + ruta);
            return nombresJuegos;
        }

        File[] archivos = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".txt"));

        if (archivos != null) {
            for (File archivo : archivos) {
                String nombre = archivo.getName().replace("_", " ");
                nombresJuegos.add(nombre.substring(0, nombre.length() - 4));
            }
        }

        return nombresJuegos;
    }


     
     private String obtenerTituloActual(File archivoJuego) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoJuego))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("TITULO:")) {
                    String[] partes = linea.split(":", 2);
                    if (partes.length > 1) {
                        return partes[1].trim();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el título del juego: " + e.getMessage());
        }
        
        
        String nombreArchivo = archivoJuego.getName();
        if (nombreArchivo.endsWith(".txt")) {
            return nombreArchivo.substring(0, nombreArchivo.length() - 4).replace("_", " ");
        }
        return "";
    }
    
    public String eliminarJuego(String titulo){
        File archivo = new File(ruta + titulo + extension);
        
        if(archivo.exists()){
            try {
                if(archivo.delete()){
                    mensaje = "EL REGISTRO FUE ELIMINADO CON EXITO";
                } else {
                    mensaje = "EL REGISTRO ESTA ACTUALMENTE EN USO";
                } 
            } catch (Exception e) {
                mensaje = "ERROR, INTENTE NUEVAMENTE";
                System.out.print(e.getMessage());
            }
        } else {
            mensaje = "REGISTRO INEXISTENTE";
        }
        return mensaje;
    }
    
    @Override
    public String toString() {
        return "InfoVideoJuegos{" + '}';
    }
}

    


