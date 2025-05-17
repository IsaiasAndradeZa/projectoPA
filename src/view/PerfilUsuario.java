/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Comentarios;
import controller.Sesion;
import controller.UsuarioController;
import controller.descripcionMostrar;
import controller.fotoMostrar;
import controller.Megusta;
import controller.usuarioMostrar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Usuario;

/**
 *
 * @author claudia
 */
public class PerfilUsuario extends javax.swing.JFrame {
    
    private final UsuarioController USUARIO = new UsuarioController();
    private final descripcionMostrar MOSTRARD = new descripcionMostrar();
    private final fotoMostrar MOSTRARFT = new fotoMostrar();
    private final usuarioMostrar MOSTRARUSER = new usuarioMostrar();
    private final Comentarios C = new Comentarios();
    String ingreso = USUARIO.usuarioSesion();    
    String descripcion = MOSTRARD.obtenerDescripcionsinparametro();    
    String ft = MOSTRARFT.obtenerFotoPerfil();
    String user = MOSTRARUSER.obtenerUsuario();
    
    
    FondoPanel7 fondo = new FondoPanel7();
    boolean editar = false;
    private JLabel mostrarL;
    private JLabel mostrarFav;
    private JLabel mostrarFP;
    private JLabel mostrarUser;
    private JLabel jTDescripcion;
    private JTextArea textAreaUser;
    private JTextArea textAreaDes;
    private String usuarioOriginal = ingreso; // Almacena el nombre de usuario original
    private File imagenPerfilSeleccionada; 
    private String nuevoUsuario;
    
    public PerfilUsuario()  {
        System.out.print("\nABRIENDO PERFIL");
        if(ft != null){
            System.out.print("\nFTO DESDE VIEW: " + ft);
        } else {
            System.out.print("\nNO FOTO PERFIL");
        }
        
        setMinimumSize(new Dimension(1000, 600)); // Ajusta el tamaño según tu imagen de fondo
        this.setContentPane(fondo);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jSplitPane1, BorderLayout.CENTER);  
        mostrarDescripcion();
        mostrarfotoPerfil();
        mostrarUsuario();
        mostrarComentariosUser();
        cambiarBtPanel(jBMicuenta, jBGeneral);
    }
    
     
    private void mostrarfotoPerfil(){
        System.out.print("\nMOSTRAR FOTO PERFIL ");
        mostrarFP = new JLabel();
        mostrarFP.setPreferredSize(new Dimension(200, 175));
        mostrarFP.setMaximumSize(new Dimension(200, 175));
        mostrarFP.setMinimumSize(new Dimension(200, 175));
        mostrarFP.setBackground(null);
        mostrarFP.setOpaque(true);
        mostrarFP.setVisible(true);
        
        mostrarFP.setVerticalAlignment(SwingConstants.CENTER);
        System.out.print("\nFTO DESDE VIEW: " + ft);
        System.out.print("\nUSUARIO DESDE VIEW: " + ingreso);
        if (ingreso != null){
            
            File perfiles = new File("resourcer/perfiles/" + USUARIO.usuarioSesion() + ".png");
            mostrarFP.setIcon(new ImageIcon(perfiles.getAbsolutePath()));
            ImageIcon ftoOriginal = new ImageIcon(perfiles.getAbsolutePath());
            Image ftoEscalada = ftoOriginal.getImage().getScaledInstance(200, 175, Image.SCALE_SMOOTH);
            ImageIcon ftoFinal = new ImageIcon(ftoEscalada);
            mostrarFP.setIcon(ftoFinal);
            System.out.print("\nFOTO DESDE VIEW: " + ft);
            jPFotoPerfil.add(mostrarFP);
            jPFotoPerfil.revalidate();
            jPFotoPerfil.repaint();
        } else {
            System.out.print("\nNO HAY FOTO" );
        }
        
    }
    
    private void mostrarUsuario(){

        mostrarUser = new JLabel("");
        mostrarUser.setPreferredSize(new Dimension(170, 50));
        mostrarUser.setMaximumSize(new Dimension(170, 50));
        mostrarUser.setMinimumSize(new Dimension(170, 50));        
        Font fuente = new Font("Yu Gothic UI Light", Font.PLAIN, 20);
        mostrarUser.setBackground(null);
        mostrarUser.setFont(fuente);
        mostrarUser.setForeground(Color.WHITE);
        mostrarUser.setBorder(null);
        mostrarUser.setVisible(true);
        mostrarUser.setOpaque(true);
        if (ingreso != null){
            mostrarUser.setText(user);
            System.out.print("\nDESCRIPCION DESDE VIEW: " + user);
            jPNombre.add(mostrarUser);
            jPNombre.revalidate();
            jPNombre.repaint();
        } else {
            JOptionPane.showConfirmDialog(null, "USUARIO NULO");
        }
    }
    
    private void mostrarDescripcion(){
        jTDescripcion = new JLabel("");
        jTDescripcion.setPreferredSize(new Dimension(700, 100));
        jTDescripcion.setMaximumSize(new Dimension(700, 100));
        jTDescripcion.setMinimumSize(new Dimension(700, 100));        
        Font fuente = new Font("Yu Gothic UI Light", Font.PLAIN, 18);
        jTDescripcion.setBackground(null);
        jTDescripcion.setFont(fuente);
        jTDescripcion.setForeground(Color.WHITE);
        jTDescripcion.setBorder(null);
        jTDescripcion.setVisible(true);
        jTDescripcion.setOpaque(true);
                    System.out.print("\nUSUARIO DESDE VIEW: " + ingreso);
        if (ingreso != null){
            jTDescripcion.setText(descripcion);
            System.out.print("\nDESCRIPCION DESDE VIEW: " + descripcion);
            jPDescripcion.add(jTDescripcion);
            jPDescripcion.revalidate();
            jPDescripcion.repaint();
        } else {
            JOptionPane.showConfirmDialog(null, "USUARIO NULO");
        }
    }
    
  
    
    private void mostrarComentariosUser(){
        System.out.print("EJECUTANDO...");
   
    JPanel jPComentarios = new JPanel();
    jPComentarios.setLayout(new BoxLayout(jPComentarios, BoxLayout.Y_AXIS));
    jPComentarios.setPreferredSize(new Dimension(650, 300));
    jPComentarios.setMaximumSize(new Dimension(650, 300));
    jPComentarios.setMinimumSize(new Dimension(650, 300));
    jPComentarios.setBackground(new Color(51, 51, 51));
    jPComentarios.setVisible(true);
    
    
    // Crear JTextArea para los comentarios
    JTextArea jTComentarios = new JTextArea("");
    jTComentarios.setPreferredSize(new Dimension(650, 300));
    jTComentarios.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
    jTComentarios.setBackground(null);
    jTComentarios.setForeground(Color.WHITE);
    jTComentarios.setEditable(false);
    jTComentarios.setLineWrap(true);
    jTComentarios.setWrapStyleWord(true);
    jTComentarios.setSelectionColor(new Color(153, 0, 255));
    jTComentarios.setSelectedTextColor(Color.WHITE);
    jTComentarios.setBorder(null);
    jTComentarios.setOpaque(true);

    // Obtener los comentarios del usuario
    List<String> comentarios = C.obtenerComentariosUsuarioSesion();
    System.out.print("\nCOMENTARIO DESDE VIEW: " + comentarios);

    StringBuilder textoC = new StringBuilder();
    for (String comentario : comentarios) {
        textoC.append(comentario).append("\n");
    }
    jTComentarios.setText(textoC.toString());

    
   
    jPComentarios.add(jTComentarios);
    jPComentarios.revalidate();
    jPComentarios.repaint();
    jPMostrarC.add(jPComentarios);
    }
    
    
public String mostrarDialogoActualizarPerfil(String rutaArchivo) {
    String[] datos = USUARIO.leerDatosPerfil(rutaArchivo); 
    JTextField campoUsuario = new JTextField(datos[0]);
    JTextField campoCorreo = new JTextField(datos[1]);
    JPasswordField campoContraseña = new JPasswordField(datos[2]);
    JTextField campoDescripcion = new JTextField(datos[3]);
    JPanel panel = new JPanel(new GridLayout(4, 2));
    panel.add(new JLabel("Nombre de usuario:"));
    panel.add(campoUsuario);
    panel.add(new JLabel("Correo:"));
    panel.add(campoCorreo);
    panel.add(new JLabel("Contraseña:"));
    panel.add(campoContraseña);
    panel.add(new JLabel("Descripción:"));
    panel.add(campoDescripcion);
    int resultado = JOptionPane.showConfirmDialog(null, panel, "Actualizar Perfil", JOptionPane.OK_CANCEL_OPTION);
    if (resultado == JOptionPane.OK_OPTION) {
       String mensaje = USUARIO.actualizarPerfilUser(
            rutaArchivo, 
            campoUsuario.getText().trim(), 
            campoCorreo.getText().trim(), 
            new String(campoContraseña.getPassword()), 
            campoDescripcion.getText().trim()
        );
        JOptionPane.showMessageDialog(null, mensaje);
    }
        return null;
}

    private void cambiarBtPanel(JButton... botones){
    for (JButton boton : botones){
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            boton.setBackground(new Color(103,22,199)); 
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
            boton.setBackground(Color.DARK_GRAY); 
            }
        });
        }
    }

        
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jBMicuenta = new javax.swing.JButton();
        jBGeneral = new javax.swing.JButton();
        jBMegusta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPContenedor1 = new javax.swing.JPanel();
        jPFotoPerfil = new javax.swing.JPanel();
        jPNombre = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jBEditar = new javax.swing.JButton();
        jBCambiarFt = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPContenerdor2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPDescripcion = new javax.swing.JPanel();
        jSMegustas = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSComentarios = new javax.swing.JScrollPane();
        jPMostrarC = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setResizeWeight(1.0);
        jSplitPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSplitPane1.setEnabled(false);
        jSplitPane1.setMaximumSize(new java.awt.Dimension(1580, 580));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(1580, 580));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1580, 580));

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 114));
        jPanel1.setMinimumSize(new java.awt.Dimension(230, 150));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 150));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jBMicuenta.setBackground(new java.awt.Color(103, 22, 199));
        jBMicuenta.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBMicuenta.setForeground(java.awt.Color.white);
        jBMicuenta.setText("MI CUENTA");
        jBMicuenta.setAlignmentX(0.5F);
        jBMicuenta.setBorder(null);
        jBMicuenta.setFocusPainted(false);
        jBMicuenta.setHideActionText(true);
        jBMicuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jBMicuenta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBMicuenta.setMargin(new java.awt.Insets(10, 0, 10, 70));
        jBMicuenta.setMaximumSize(new java.awt.Dimension(230, 50));
        jBMicuenta.setMinimumSize(new java.awt.Dimension(230, 50));
        jBMicuenta.setPreferredSize(new java.awt.Dimension(230, 50));
        jPanel1.add(jBMicuenta);

        jBGeneral.setBackground(new java.awt.Color(103, 22, 199));
        jBGeneral.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBGeneral.setForeground(java.awt.Color.white);
        jBGeneral.setText("GENERAL");
        jBGeneral.setAlignmentX(0.5F);
        jBGeneral.setBorder(null);
        jBGeneral.setFocusPainted(false);
        jBGeneral.setHideActionText(true);
        jBGeneral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBGeneral.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jBGeneral.setMargin(new java.awt.Insets(10, 0, 10, 70));
        jBGeneral.setMaximumSize(new java.awt.Dimension(230, 50));
        jBGeneral.setMinimumSize(new java.awt.Dimension(230, 50));
        jBGeneral.setPreferredSize(new java.awt.Dimension(230, 50));
        jBGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(jBGeneral);

        jBMegusta.setBackground(new java.awt.Color(103, 22, 199));
        jBMegusta.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBMegusta.setForeground(java.awt.Color.white);
        jBMegusta.setText("MIS JUEGOS");
        jBMegusta.setAlignmentX(0.5F);
        jBMegusta.setBorder(null);
        jBMegusta.setFocusPainted(false);
        jBMegusta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBMegusta.setMargin(new java.awt.Insets(10, 0, 10, 70));
        jBMegusta.setMaximumSize(new java.awt.Dimension(230, 50));
        jBMegusta.setMinimumSize(new java.awt.Dimension(230, 50));
        jBMegusta.setPreferredSize(new java.awt.Dimension(230, 50));
        jBMegusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMegustaActionPerformed(evt);
            }
        });
        jPanel1.add(jBMegusta);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(java.awt.Color.darkGray);
        jPanel2.setMaximumSize(new java.awt.Dimension(980, 980));
        jPanel2.setMinimumSize(new java.awt.Dimension(980, 980));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPContenedor1.setBackground(java.awt.Color.darkGray);
        jPContenedor1.setMaximumSize(new java.awt.Dimension(200, 700));
        jPContenedor1.setMinimumSize(new java.awt.Dimension(200, 700));
        jPContenedor1.setPreferredSize(new java.awt.Dimension(180, 584));
        jPContenedor1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPFotoPerfil.setBackground(java.awt.Color.darkGray);
        jPFotoPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255), 2));
        jPFotoPerfil.setMaximumSize(new java.awt.Dimension(170, 175));
        jPFotoPerfil.setMinimumSize(new java.awt.Dimension(170, 175));
        jPFotoPerfil.setName(""); // NOI18N
        jPFotoPerfil.setPreferredSize(new java.awt.Dimension(170, 175));
        jPFotoPerfil.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        jPContenedor1.add(jPFotoPerfil);

        jPNombre.setBackground(java.awt.Color.darkGray);
        jPNombre.setMaximumSize(new java.awt.Dimension(225, 50));
        jPNombre.setMinimumSize(new java.awt.Dimension(225, 50));
        jPNombre.setPreferredSize(new java.awt.Dimension(170, 50));
        jPContenedor1.add(jPNombre);

        jPanel7.setBackground(java.awt.Color.darkGray);
        jPanel7.setPreferredSize(new java.awt.Dimension(170, 50));

        jBEditar.setBackground(new java.awt.Color(103, 22, 199));
        jBEditar.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jBEditar.setForeground(java.awt.Color.white);
        jBEditar.setText("Editar perfil");
        jBEditar.setBorder(null);
        jBEditar.setFocusPainted(false);
        jBEditar.setMinimumSize(new java.awt.Dimension(80, 15));
        jBEditar.setPreferredSize(new java.awt.Dimension(168, 20));
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });
        jPanel7.add(jBEditar);

        jBCambiarFt.setBackground(new java.awt.Color(103, 22, 199));
        jBCambiarFt.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jBCambiarFt.setForeground(java.awt.Color.white);
        jBCambiarFt.setText("Cambiar foto");
        jBCambiarFt.setPreferredSize(new java.awt.Dimension(168, 20));
        jBCambiarFt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambiarFtActionPerformed(evt);
            }
        });
        jPanel7.add(jBCambiarFt);

        jPContenedor1.add(jPanel7);

        jPanel5.setBackground(java.awt.Color.darkGray);
        jPanel5.setPreferredSize(new java.awt.Dimension(170, 300));
        jPContenedor1.add(jPanel5);

        jPanel2.add(jPContenedor1, java.awt.BorderLayout.LINE_START);

        jPContenerdor2.setBackground(java.awt.Color.darkGray);

        jPanel3.setBackground(new java.awt.Color(153, 0, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(650, 30));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("DESCRIPCIÓN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(534, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPContenerdor2.add(jPanel3);

        jPDescripcion.setBackground(java.awt.Color.darkGray);
        jPDescripcion.setForeground(java.awt.Color.darkGray);
        jPDescripcion.setPreferredSize(new java.awt.Dimension(650, 100));
        jPDescripcion.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPContenerdor2.add(jPDescripcion);
        jPContenerdor2.add(jSMegustas);

        jPanel9.setBackground(new java.awt.Color(153, 0, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(650, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("COMENTARIOS");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPContenerdor2.add(jPanel9);

        jSComentarios.setBackground(java.awt.Color.darkGray);

        jPMostrarC.setBackground(java.awt.Color.darkGray);
        jPMostrarC.setPreferredSize(new java.awt.Dimension(650, 300));
        jSComentarios.setViewportView(jPMostrarC);

        jPContenerdor2.add(jSComentarios);

        jPanel2.add(jPContenerdor2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
      String usuarioSesion = USUARIO.usuarioSesion(); 

    if (usuarioSesion == null || usuarioSesion.isEmpty()) {
        System.out.println("Error: Usuario en sesión no definido.");
        return;
    }

    // Ruta del archivo actual
    String rutaArchivoActual = System.getProperty("user.dir") + File.separator + "usuarios" + File.separator + usuarioSesion + ".txt";
    System.out.println("Ruta absoluta generada: " + rutaArchivoActual);

    
     nuevoUsuario = mostrarDialogoActualizarPerfil(rutaArchivoActual);

    if (nuevoUsuario != null && !nuevoUsuario.isEmpty() && !nuevoUsuario.equals(usuarioSesion)) {
        // Ruta del nuevo archivo con el nombre actualizado
        String rutaArchivoNuevo = System.getProperty("user.dir") + File.separator + "usuarios" + File.separator + nuevoUsuario + ".txt";
        File archivoActual = new File(rutaArchivoActual);
        File archivoNuevo = new File(rutaArchivoNuevo);

        if (archivoActual.exists()) {
            if (archivoActual.renameTo(archivoNuevo)) {
                System.out.println("Archivo de perfil renombrado correctamente: " + rutaArchivoNuevo);
                Sesion.setUsuarioActual(Sesion.getUsuarioActual()); // Actualizar nombre en sesión
            } else {
                System.out.println("Error al renombrar el archivo de perfil.");
            }
        }
    }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGeneralActionPerformed
        if (user != null){
    System.out.print("\nUSUARIO DESDE BIBLIOTECA DESDE IF " + USUARIO.usuarioSesion());
    
    BibliotecaGeneral abrir = new BibliotecaGeneral();
    if(this.getExtendedState() == BibliotecaGeneral.MAXIMIZED_BOTH){
    abrir.setExtendedState(BibliotecaGeneral.MAXIMIZED_BOTH);
    }
    abrir.setVisible(true);
    this.setVisible(false);


} 
    }//GEN-LAST:event_jBGeneralActionPerformed

    private void jBCambiarFtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambiarFtActionPerformed
        int seleccion = JOptionPane.showOptionDialog(
        this,
        "¿Desea actualizar su foto de perfil?",
        "Foto de perfil",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        null);

    // Si el usuario quiere actualizar la foto
    if (seleccion == JOptionPane.YES_OPTION) {
        JFileChooser fileChooser = new JFileChooser();
        // Filtrar solo imágenes PNG
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes PNG", "png");
        fileChooser.setMultiSelectionEnabled(false); 
        fileChooser.setFileFilter(filtro);

        int respuesta = fileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File rutaPerfil = fileChooser.getSelectedFile();
            imagenPerfilSeleccionada = rutaPerfil;

            try {
                String rutaPerfiles = "resourcer/perfiles/";
                File carpetaPerfiles = new File(rutaPerfiles);
                if (!carpetaPerfiles.exists()) {
                    carpetaPerfiles.mkdirs(); // Crear la carpeta si no existe
                }

               
                String usuarioSesion = USUARIO.usuarioSesion();
                if (usuarioSesion == null || usuarioSesion.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Error: No hay usuario en sesión.", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                
                File imagenAntigua = new File(rutaPerfiles + usuarioOriginal + ".png");
                File imagenNueva = new File(rutaPerfiles + usuarioSesion + ".png");

                
                if (!usuarioOriginal.equals(usuarioSesion) && imagenAntigua.exists()) {
                    if (!imagenAntigua.renameTo(imagenNueva)) {
                        JOptionPane.showMessageDialog(this, "Error al renombrar la imagen de perfil.", 
                                                     "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                
                BufferedImage imagen = ImageIO.read(rutaPerfil);
                if (imagen == null) {
                    JOptionPane.showMessageDialog(this, "Error: No se pudo leer la imagen seleccionada.", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                
                ImageIO.write(imagen, "png", imagenNueva);

                // Actualizar la visualización de la imagen en el panel
                mostrarfotoPerfil();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar la imagen de perfil: " + e.getMessage(), 
                                             "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó ninguna imagen. Se mantendrá la actual.", 
                                         "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }//GEN-LAST:event_jBCambiarFtActionPerformed

    private void jBMegustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMegustaActionPerformed
        mostrarMegustas abrir = new mostrarMegustas();
            if(this.getExtendedState() == mostrarMegustas.MAXIMIZED_BOTH){
            abrir.setExtendedState(mostrarMegustas.MAXIMIZED_BOTH);
            }
            abrir.setVisible(true);
            this.setVisible(false);

    }//GEN-LAST:event_jBMegustaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCambiarFt;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBGeneral;
    private javax.swing.JButton jBMegusta;
    private javax.swing.JButton jBMicuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPContenedor1;
    private javax.swing.JPanel jPContenerdor2;
    private javax.swing.JPanel jPDescripcion;
    private javax.swing.JPanel jPFotoPerfil;
    private javax.swing.JPanel jPMostrarC;
    private javax.swing.JPanel jPNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jSComentarios;
    private javax.swing.JScrollPane jSMegustas;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
class FondoPanel7 extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Repositorio/FondoGeneral.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }

}
