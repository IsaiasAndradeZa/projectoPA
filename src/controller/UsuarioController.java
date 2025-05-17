package controller;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.Usuario;
import view.BibliotecaGeneral;

public class UsuarioController {
    
    private Usuario usuario;
    private ArrayList <String[]> filas;
    private String mensaje;

    
    private final String separador = File.separator;
    private final String ruta = System.getProperty("user.dir") + separador + "usuarios" + separador;
    private final String extension = ".txt"; 
    
    public UsuarioController(){
        usuario = new Usuario();
        mensaje = "";
        File directorio = new File(ruta);
        directorio.mkdir();
    } 

    public String usuarioSesion() {
        Usuario user = Sesion.getUsuarioActual();
        return (user != null) ? user.getNombreUsuario() : "Usuario no encontrado";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    private void recorrerUsuario(){
        
        usuario = new Usuario();
    }
    
    private void instanciaUsuario(String nombreUsuario, String correo, String contraseña, String descripcion, String rutaPerfil){
        
        usuario = new Usuario(nombreUsuario, correo, contraseña, descripcion, rutaPerfil);
    }

    
    public String crearArchivo(String nombreUsuario, String correo, String contraseña, String descripcion, String rutaPerfil){
        
        instanciaUsuario(nombreUsuario, correo, contraseña, descripcion, rutaPerfil);
        File directorio = new File(ruta);
        File archivo = new File(ruta + nombreUsuario +  extension);
       
        if(!archivo.exists()){
            try (Formatter formatter = new Formatter(archivo)){
                formatter.format("%s\r\n%s\r\n%s\r\n%s\r\n%s\r\n",
                                "USUARIO:" + usuario.getNombreUsuario(),
                                "CORREO:" + usuario.getCorreo(),
                                "CONTRASENA:" + usuario.getContraseña(),
                                "DESCRIPCION:" + usuario.getDescripcion(),
                                "RUTA FOTO:" + usuario.getRutaPerfil());
                mensaje = "REGISTRO " + usuario.getNombreUsuario() + "ACTUALIZADO";
                Sesion.setUsuarioActual(usuario);
            } catch (IOException e) {
                mensaje = "ERROR, VUELVA A INTENTARLO";
                System.out.print(e.getMessage());
            }
        } else {
            mensaje = "ARCHIVO " + nombreUsuario + "NO EXISTE";
        }
        return mensaje;
    }
    
    public boolean validarInicioSesion(String ingreso, String contraseña) {
        boolean acceso = false;
        Usuario userActual = recorrerArchivo(ingreso);
        File carpetaUsuarios = new File("usuarios");
        
        
            if(userActual!= null && ingreso.equals(usuario.getNombreUsuario())  || ingreso.equals(usuario.getCorreo()) 
                    || contraseña.equals(usuario.getContraseña())){
                System.out.print("USUARIO LEIDO DESDE VALIDACION: " + usuario.getNombreUsuario());
                System.out.print("USUARIO INGRESADO DESDE VALIDACION: " + ingreso);
            } else {
                File[] archivos = carpetaUsuarios.listFiles();
                if(archivos != null){
                    for (File archivo : archivos){
                        if (archivo.isFile() && archivo.getName().endsWith(extension)){
                            try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
                                String nombreUsuario = null;
                                String correo = null;
                                String contrasena = null;
                                String linea;
                                
                                while ((linea = bf.readLine()) != null){
                                    if(linea.startsWith("USUARIO:")){
                                        nombreUsuario = linea.split(":")[1].trim();
                                    } else if (linea.startsWith("CORREO:")) {
                                        correo = linea.split(":")[1].trim();
                                    } else if (linea.startsWith("CONTRASENA:")) {
                                        contrasena = linea.split(":")[1].trim();
                                    }
                                }
                                
                                if(nombreUsuario != null && correo != null && contrasena != null){
                                    if ((ingreso.equals(nombreUsuario) || ingreso.equals(correo) && contraseña.equals(contrasena))){
                                        acceso = true;
                                        usuario = recorrerArchivo(ingreso);
                                        System.out.print("USUARIO ENCONTRADO DESDE VALIDACION INICIO SESION" + 
                                                (usuario != null ? usuario.getNombreUsuario() : "NULL"));
                                        Sesion.setUsuarioActual(usuario);
                                        
                                        return true;
                                    }
                                }
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    System.out.print("CARPETA NO EXITE");
                }
            }
            
        
    return acceso;
    }
  
    public boolean existeUsuario(String ingreso){
        boolean acceso = false;
        File carpetaUsuarios = new File("usuarios");
        
        if(carpetaUsuarios.exists() && carpetaUsuarios.isDirectory()){
            File[] archivos = carpetaUsuarios.listFiles();
            if(archivos != null){
                for (File archivo : archivos){
                    if (archivo.isFile() && archivo.getName().endsWith(extension)){
                        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
                            String nombreUsuario = null;
                            String correo = null;
                            String linea;
                            
                            while ((linea = bf.readLine()) != null){
                                if(linea.startsWith("USUARIO:")){
                                    nombreUsuario = linea.split(":")[1].trim();
                                } else if (linea.startsWith("CORREO:")) {
                                    correo = linea.split(":")[1].trim();
                                }
                            }
                            
                            if(nombreUsuario != null && correo != null){
                                if ((ingreso.equals(nombreUsuario) || ingreso.equals(correo))){
                                    acceso = true;
                                    return true;
                                }
                            }
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.print("CARPETA NO EXITE");
            }
            
        }
        return acceso;
    }
    
    public boolean contraseñaCorrecta(String contraseña){
       boolean acceso = false;
        File carpetaUsuarios = new File("usuarios");
        
        if(carpetaUsuarios.exists() && carpetaUsuarios.isDirectory()){
            File[] archivos = carpetaUsuarios.listFiles();
            if(archivos != null){
                for (File archivo : archivos){
                    if (archivo.isFile() && archivo.getName().endsWith(extension)){
                        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
                            String contrasena = null;
                            String linea;
                            
                            while ((linea = bf.readLine()) != null){
                                if(linea.startsWith("CONTRASENA:")) {
                                    contrasena = linea.split(":")[1].trim();
                                }
                            }
                            
                            if(contrasena != null){
                                if (contraseña.equals(contrasena)){
                                    acceso = true;
                                    return true;
                                }
                            }
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.print("CARPETA NO EXITE");
            }
            
        }
        return acceso;
    }
    

public String[] leerDatosPerfil(String rutaArchivo) {
    File archivoUsuario = new File(rutaArchivo);
    String[] datos = new String[]{"", "", "", ""};

    if (!archivoUsuario.exists()) {
        System.out.println("Error: El archivo de perfil no existe en " + archivoUsuario.getAbsolutePath());
        return datos;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuario))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            if (!linea.contains(":")) continue;

            String[] partes = linea.split(":", 2);
            if (partes.length > 1) {
                String clave = partes[0].trim();
                String valor = partes[1].trim();

                switch (clave.toUpperCase()) {
                    case "USUARIO" -> datos[0] = valor;
                    case "CORREO" -> datos[1] = valor;
                    case "CONTRASEÑA" -> datos[2] = valor;
                    case "DESCRIPCION" -> datos[3] = valor;
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el perfil: " + e.getMessage());
    }

    return datos;
}

public String actualizarPerfilUser(String rutaArchivo, String nombreUsuario, String correo, String contraseña, String descripcion) {
    File archivoActual = new File(rutaArchivo);
    
    if (!archivoActual.exists()) {
        return "Error: El archivo de perfil no existe en " + archivoActual.getAbsolutePath();
    }
    
    // Obtener el nombre de usuario actual de archivo
    String nombreUsuarioActual = obtenerNombreUsuarioActual(archivoActual);
    
    // Ruta para el archivo con el nuevo nombre de usuario
    String directorioUsuarios = archivoActual.getParent();
    File archivoNuevo = new File(directorioUsuarios + File.separator + nombreUsuario + ".txt");
    
    List<String> lineas = new ArrayList<>();
    boolean cambios = false;

    // Leer contenido archivo
    try (BufferedReader br = new BufferedReader(new FileReader(archivoActual))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
    } catch (IOException e) {
        return "Error al leer el archivo: " + e.getMessage();
    }

    // Modificar lienas necesarias
    for (int i = 0; i < lineas.size(); i++) {
        String linea = lineas.get(i);
        if (!linea.contains(":")) continue;
        
        String[] partes = linea.split(":", 2);
        if (partes.length > 1) {
            String clave = partes[0].trim();
            if (clave.equalsIgnoreCase("USUARIO")) {
                lineas.set(i, "USUARIO: " + nombreUsuario);
                cambios = true;
            } else if (clave.equalsIgnoreCase("CORREO")) {
                lineas.set(i, "CORREO: " + correo);
                cambios = true;
            } else if (clave.equalsIgnoreCase("CONTRASEÑA")) {
                lineas.set(i, "CONTRASEÑA: " + contraseña);
                cambios = true;
            } else if (clave.equalsIgnoreCase("DESCRIPCION")) {
                lineas.set(i, "DESCRIPCION: " + descripcion);
                cambios = true;
            }
        }
    }

    // Escribir el archivo con los cambios
    if (cambios) {
        try {
            // Si nombre de usuario cambia crear nuevo archivo
            if (!nombreUsuario.equals(nombreUsuarioActual)) {
                // Escribir al nuevo archivo
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoNuevo))) {
                    for (String linea : lineas) {
                        bw.write(linea);
                        bw.newLine();
                    }
                }
                // Eliminar el archivo antiguo
                if (!archivoActual.delete()) {
                    System.out.println("Advertencia: No se pudo eliminar el archivo antiguo: " + archivoActual.getAbsolutePath());
                }
                return "Perfil actualizado correctamente. Nuevo archivo: " + archivoNuevo.getAbsolutePath();
            } else {
                // Actualizar el mismo archivo
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoActual))) {
                    for (String linea : lineas) {
                        bw.write(linea);
                        bw.newLine();
                    }
                }
                return "Perfil actualizado correctamente.";
            }
        } catch (IOException e) {
            return "Error al actualizar el perfil: " + e.getMessage();
        }
    } else {
        return "No se realizaron cambios en el perfil.";
    }
}


private String obtenerNombreUsuarioActual(File archivoUsuario) {
    try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuario))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.toUpperCase().startsWith("USUARIO:")) {
                String[] partes = linea.split(":", 2);
                if (partes.length > 1) {
                    return partes[1].trim();
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el nombre de usuario: " + e.getMessage());
    }
    
    // Si no se encuentra en el archivo usar el nombre del archivo sin extension
    String nombreArchivo = archivoUsuario.getName();
    if (nombreArchivo.endsWith(".txt")) {
        return nombreArchivo.substring(0, nombreArchivo.length() - 4);
    }
    return "";
}

    
    
    private Usuario recorrerArchivo(String ingreso){
        
        File carpetaUsuarios = new File("usuarios");
        File[] archivos = carpetaUsuarios.listFiles();
        
        if(carpetaUsuarios.exists() && carpetaUsuarios.isDirectory()){
            
            if(archivos != null){
                for (File archivo : archivos){
                    if (archivo.isFile() && archivo.getName().endsWith(extension)){
                        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
                            String nombreUsuario = null,
                            correo = null,
                            contraseña = null,
                            descripcion = null,
                            rutaPerfil = null;
                            
                            String linea;
                            
                            while ((linea = bf.readLine()) != null){

                                
                                if(linea.startsWith("USUARIO:")){
                                    nombreUsuario = linea.split(":")[1].trim();
                                } else if (linea.startsWith("CORREO:")) {
                                    correo = linea.split(":")[1].trim();
                                } else if (linea.startsWith("CONTRASENA:")) {
                                    contraseña = linea.split(":")[1].trim();
                                } else if (linea.startsWith("DESCRIPCION:")) {
                                    descripcion = linea.split(":")[1].trim();
                                } else if (linea.startsWith("RUTA FOTO:")) {
                                    rutaPerfil = linea.substring(linea.indexOf(":") + 1).trim();
                                    
                                }
                            }
                             
                            if(nombreUsuario != null && nombreUsuario.trim().equalsIgnoreCase(ingreso.trim())){
                                System.out.print("\nDESCRIPCION DESDE METODO RECORRER: " + descripcion);
                                System.out.print("\nUSUARIO DESDE METODO RECORRER: " + nombreUsuario);
                                System.out.print("\nFOTO DE PERFIL DESDE METODO RECORRER: " + rutaPerfil);
                                

                                return new Usuario(nombreUsuario, correo, contraseña, descripcion, rutaPerfil);
                                }
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.print("CARPETA NO EXITE");
            }
            
        } 
        return null;
      
    } 
     
    public boolean validarExistencia(String ingreso){
        File carpetaUsuarios = new File("usuarios");
        
        if(carpetaUsuarios.exists() && carpetaUsuarios.isDirectory()){
            File[] archivos = carpetaUsuarios.listFiles();
            if(archivos != null){
                for (File archivo : archivos){
                    if (archivo.isFile() && archivo.getName().endsWith(extension)){
                        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
                            String nombreUsuario = null;
                            String correo = null;
                            String linea;
                            
                            while ((linea = bf.readLine()) != null){
                                if(linea.startsWith("USUARIO:")){
                                    nombreUsuario = linea.split(":")[1].trim();
                                } else if (linea.startsWith("CORREO:")) {
                                    correo = linea.split(":")[1].trim();
                                }
                            }
                            
                            if(nombreUsuario != null && (nombreUsuario.equalsIgnoreCase(ingreso))){
                                return true;
                            }
                            if(correo != null && (correo.equalsIgnoreCase(ingreso))){
                                return true;
                            }
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.print("CARPETA NO EXITE");
            }
            
        }
        return false;
    }
    
    public ArrayList<String[]> mostrarUsuarioTabla() {
        filas = new ArrayList<>();
        File archivo = new File(ruta);
        File [] listarArchivos = archivo.listFiles();
        
        try {
            for (File file : listarArchivos){
                try (FileInputStream fileInputStream = new FileInputStream(file)){
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    filas.add(new String[]{
                        properties.getProperty("USUARIO"),
                        properties.getProperty("CORREO"),
                    });
                }
            }    
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return filas;
    }
    
    public String eliminarUsuario(String nombreUsuario){
        File archivo = new File(ruta + nombreUsuario + extension);
        
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
    
}
