/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import controller.UsuarioController;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author claudia
 */
public class Registro extends javax.swing.JFrame {

        FondoPanel2 fondo = new FondoPanel2();
        private final UsuarioController USUARIO = new UsuarioController();
        private String rutaPerfil = "";

        
    public Registro() {
       setMinimumSize(new Dimension(1000, 600)); // Ajusta el tamaño según tu imagen de fondo

        this.setContentPane(fondo);
        initComponents();
        jPContraseña.setEchoChar('\u2022');
        jPConfirmar.setEchoChar('\u2022');
        this.setLocationRelativeTo(null);
    }

    public void vaciarAdvertencias(){
        jLCorreo.setText("");
        jLUsuario.setText("");
        jLContraseña.setText("");
        jLConfirmar.setText("");
    }
    
    public void completarRegistro(){
    int foto = JOptionPane.showConfirmDialog
        (null, "Selecciona una foto de perfil", "¡Ya falta poco!",
                JOptionPane.YES_NO_OPTION);
         
    if (foto == JOptionPane.YES_OPTION){
        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Seleccione una foto de perfil",
                "Seleccione",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Seleccionar"},
                "Seleccionar");
            if(seleccion == JOptionPane.OK_OPTION){
                JFileChooser FileChooser = new JFileChooser();
                //FILTRAR TIPO
                FileNameExtensionFilter filtar = new FileNameExtensionFilter("PNG", "png");
                FileChooser.setMultiSelectionEnabled(false); //No permite selecionar varias imagenes
                FileChooser.setFileFilter(filtar);
        
                int respuesta = FileChooser.showOpenDialog(this);
        
                if (respuesta == JFileChooser.APPROVE_OPTION){
                    File rutaPerfil = FileChooser.getSelectedFile();
                    System.out.print(rutaPerfil);         
            
                
                    String ftoPerfil = jTUsuario.getText();  // Obtener el usuario
                    File destino = new File("resourcer/perfiles/" + ftoPerfil + ".png");
                    
                    try {
                        BufferedImage imagen = ImageIO.read(rutaPerfil);
                        ImageIO.write(imagen, "png", destino);  // Guarda la imagen en el proyecto
                        System.out.println("Imagen guardada en: " + destino.getPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
            } 
        } else {
            
        }
        
    int descripcion = JOptionPane.showConfirmDialog
        (null, "¿Deseas contar algo sobre ti?", "¡Ya casi!",
                JOptionPane.YES_NO_OPTION);
        if(descripcion == JOptionPane.YES_OPTION){
            String ingreso = JOptionPane.showInputDialog(
                    this,
                    "Cuenta algo sobre ti...");
            if (ingreso != null && !ingreso.trim().isEmpty()) {
                this.USUARIO.getUsuario().setDescripcion(ingreso);
                System.out.print("\nDescripcion de metodo: " + descripcion);
            } else {
                this.USUARIO.getUsuario().setDescripcion("SIN DESCRIPCION");
            }
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTCorreo = new javax.swing.JTextField();
        jTUsuario = new javax.swing.JTextField();
        jPContraseña = new javax.swing.JPasswordField();
        jPConfirmar = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBCrear = new javax.swing.JButton();
        jBRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLInicio = new javax.swing.JLabel();
        jPCorreo = new javax.swing.JPanel();
        jLCorreo = new javax.swing.JLabel();
        jPUsuario = new javax.swing.JPanel();
        jLUsuario = new javax.swing.JLabel();
        jPcontraseña = new javax.swing.JPanel();
        jLContraseña = new javax.swing.JLabel();
        jPconfirmar = new javax.swing.JPanel();
        jLConfirmar = new javax.swing.JLabel();

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Inicio de sesión");

        jButton1.setBackground(new java.awt.Color(103, 22, 199));
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Iniciar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 1, true)));
        jPanel1.setForeground(new java.awt.Color(102, 0, 204));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 525));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Nuevo usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, -1, -1));

        jTCorreo.setBackground(new java.awt.Color(51, 51, 51));
        jTCorreo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jTCorreo.setForeground(java.awt.Color.white);
        jTCorreo.setToolTipText("");
        jTCorreo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTCorreo.setCaretColor(new java.awt.Color(255, 255, 255));
        jTCorreo.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTCorreo.setMargin(new java.awt.Insets(2, 15, 2, 15));
        jTCorreo.setSelectionColor(new java.awt.Color(153, 0, 255));
        jTCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCorreoFocusLost(evt);
            }
        });
        jTCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(jTCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 620, 40));

        jTUsuario.setBackground(new java.awt.Color(51, 51, 51));
        jTUsuario.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jTUsuario.setForeground(java.awt.Color.white);
        jTUsuario.setToolTipText("");
        jTUsuario.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        jTUsuario.setSelectionColor(new java.awt.Color(153, 0, 255));
        jTUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTUsuarioFocusLost(evt);
            }
        });
        jPanel1.add(jTUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 620, 40));

        jPContraseña.setBackground(new java.awt.Color(51, 51, 51));
        jPContraseña.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jPContraseña.setForeground(java.awt.Color.white);
        jPContraseña.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPContraseña.setCaretColor(new java.awt.Color(255, 255, 255));
        jPContraseña.setSelectionColor(new java.awt.Color(153, 0, 255));
        jPContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPContraseñaFocusLost(evt);
            }
        });
        jPanel1.add(jPContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 620, 40));

        jPConfirmar.setBackground(new java.awt.Color(51, 51, 51));
        jPConfirmar.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jPConfirmar.setForeground(java.awt.Color.white);
        jPConfirmar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPConfirmar.setCaretColor(new java.awt.Color(255, 255, 255));
        jPConfirmar.setSelectionColor(new java.awt.Color(153, 0, 255));
        jPConfirmar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPConfirmarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPConfirmarFocusLost(evt);
            }
        });
        jPConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(jPConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 620, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Correo electronico");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Usuario");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 63, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Contraseña");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 90, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Confirme la contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, 30));

        jBCrear.setBackground(new java.awt.Color(103, 22, 199));
        jBCrear.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        jBCrear.setForeground(java.awt.Color.white);
        jBCrear.setText("Crear cuenta");
        jBCrear.setAlignmentY(0.1F);
        jBCrear.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jBCrear.setFocusable(false);
        jBCrear.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBCrear.setMargin(new java.awt.Insets(141, 1, 3, 14));
        jBCrear.setMaximumSize(new java.awt.Dimension(133, 59));
        jBCrear.setMinimumSize(new java.awt.Dimension(133, 59));
        jBCrear.setPreferredSize(new java.awt.Dimension(133, 59));
        jBCrear.setVerifyInputWhenFocusTarget(false);
        jBCrear.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jBCrear.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jBCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearActionPerformed(evt);
            }
        });
        jPanel1.add(jBCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 560, 40));

        jBRegresar.setBackground(java.awt.Color.darkGray);
        jBRegresar.setForeground(new java.awt.Color(60, 63, 65));
        jBRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Repositorio/BotonRegresar.png"))); // NOI18N
        jBRegresar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(3, 4, 3, 4), javax.swing.BorderFactory.createEmptyBorder(3, 4, 3, 4)));
        jBRegresar.setBorderPainted(false);
        jBRegresar.setContentAreaFilled(false);
        jBRegresar.setDefaultCapable(false);
        jBRegresar.setFocusPainted(false);
        jBRegresar.setFocusable(false);
        jBRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jBRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 40, 50));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLInicio.setBackground(java.awt.Color.white);
        jLInicio.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLInicio.setForeground(java.awt.Color.white);
        jLInicio.setText("¿Ya tienes una cuenta?");
        jLInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLInicioMouseClicked(evt);
            }
        });
        jPanel1.add(jLInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jPCorreo.setBackground(java.awt.Color.darkGray);
        jPCorreo.setForeground(java.awt.Color.darkGray);
        jPCorreo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLCorreo.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLCorreo.setForeground(java.awt.Color.white);
        jLCorreo.setToolTipText("");
        jLCorreo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPCorreo.add(jLCorreo);

        jPanel1.add(jPCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 460, 30));

        jPUsuario.setBackground(java.awt.Color.darkGray);
        jPUsuario.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLUsuario.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLUsuario.setForeground(java.awt.Color.white);
        jPUsuario.add(jLUsuario);

        jPanel1.add(jPUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 500, 30));

        jPcontraseña.setBackground(java.awt.Color.darkGray);
        jPcontraseña.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLContraseña.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLContraseña.setForeground(java.awt.Color.white);
        jPcontraseña.add(jLContraseña);

        jPanel1.add(jPcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 530, 30));

        jPconfirmar.setBackground(java.awt.Color.darkGray);
        jPconfirmar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLConfirmar.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLConfirmar.setForeground(java.awt.Color.white);
        jPconfirmar.add(jLConfirmar);

        jPanel1.add(jPconfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 440, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCorreoActionPerformed
        
    }//GEN-LAST:event_jTCorreoActionPerformed

    private void jPConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPConfirmarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearActionPerformed
        String correo = jTCorreo.getText();
        String usuario = jTUsuario.getText();
        String contraseña = jPContraseña.getText();
        String confirmar = jPConfirmar.getText();
        
        vaciarAdvertencias();
        
        boolean error = false;
        //Expresion regular para validar correo
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        
        if(correo.isEmpty() || usuario.isEmpty() || contraseña.isEmpty()) {
            jLCorreo.setForeground(Color.red);
            jLCorreo.setText("Todos los campos son obligatorios");
            error = true;
            
        } if (!contraseña.equals(confirmar)) {
            jLContraseña.setForeground(Color.red);
            jLConfirmar.setForeground(Color.red);
            jLContraseña.setText("Las contraseñas no coinciden*");
            jLConfirmar.setText("Las contraseñas no coinciden*");
            error = true;
            
        } if (!matcher.matches()) {
            jLCorreo.setForeground(Color.red);
            jLCorreo.setText("Ingrese un correo valido*");
            error = true;
            
        } if (USUARIO.validarExistencia(correo)){
            jLCorreo.setForeground(Color.red);
            jLCorreo.setText("Correo ya registrado*");
            error = true;
            
        } if (USUARIO.validarExistencia(usuario)){
            jLUsuario.setForeground(Color.red);
            jLUsuario.setText("Nombre de usuario en uso*");
            error = true;
            
        } if (contraseña.trim().isEmpty() 
                || contraseña.length() < 8 || contraseña.length() > 10){
            jLContraseña.setForeground(Color.red);
            jLContraseña.setText("La contraseña debe tener entre 8 y 10 caracteres*");
            error = true;
            
        } if (usuario == null || usuario.trim().isEmpty() 
                || usuario.length() < 3 || usuario.length() > 12){
            jLUsuario.setForeground(Color.red);
            jLUsuario.setText("El nombre debe tener entre 3 y 12 caracteres*");
            error = true;
            
        } if (!error) {
            
            completarRegistro();
            
            USUARIO.crearArchivo(usuario, correo, contraseña, this.USUARIO.getUsuario().getDescripcion(), rutaPerfil);
            System.out.print("\n" + this.USUARIO.getUsuario().getDescripcion());
            
            BibliotecaGeneral abrir = new BibliotecaGeneral();
            if(this.getExtendedState() == BibliotecaGeneral.MAXIMIZED_BOTH){
            abrir.setExtendedState(BibliotecaGeneral.MAXIMIZED_BOTH);
        }
        abrir.setVisible(true);
        this.setVisible(false); 
        }
          
    }//GEN-LAST:event_jBCrearActionPerformed
//Boton para regresar
    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        Inicio abrir = new Inicio();
        
        if(this.getExtendedState() == Inicio.MAXIMIZED_BOTH){
            abrir.setExtendedState(Inicio.MAXIMIZED_BOTH);
        }
        
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBRegresarActionPerformed
//Poner "información" en los cuadros de texto
    private void jPConfirmarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPConfirmarFocusGained
       if (String.valueOf(jPConfirmar.getPassword()).equals("Ingrese nuevamente su contraseña")) {
    jPConfirmar.setText("");
    jPConfirmar.setForeground(Color.WHITE);
    jPConfirmar.setEchoChar('\u2022'); // Activa el ocultamiento
}
    }//GEN-LAST:event_jPConfirmarFocusGained

    private void jPConfirmarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPConfirmarFocusLost
        if (String.valueOf(jPConfirmar.getPassword()).isEmpty()) {
    jPConfirmar.setText("Ingrese nuevamente su contraseña");
    jPConfirmar.setForeground(Color.GRAY);
    jPConfirmar.setEchoChar((char) 0); // Desactiva el ocultamiento
}
    }//GEN-LAST:event_jPConfirmarFocusLost

    private void jTCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCorreoFocusGained
        if (jTCorreo.getText().equals("Ingrese su correo electronico")) {
        jTCorreo.setText("");
        jTCorreo.setForeground(Color.WHITE); // cambia al color normal
}
    }//GEN-LAST:event_jTCorreoFocusGained

    private void jTCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCorreoFocusLost
        if (jTCorreo.getText().isEmpty()) {
        jTCorreo.setText("Ingrese su correo electronico");
        jTCorreo.setForeground(Color.GRAY); // vuelve a gris si está vacío
        }
    }//GEN-LAST:event_jTCorreoFocusLost

    private void jTUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTUsuarioFocusGained
        if (jTUsuario.getText().equals("Ingrese su nombre de usuario")) {
        jTUsuario.setText("");
        jTUsuario.setForeground(Color.WHITE); // cambia al color normal
}
    }//GEN-LAST:event_jTUsuarioFocusGained

    private void jTUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTUsuarioFocusLost
        if (jTUsuario.getText().isEmpty()) {
        jTUsuario.setText("Ingrese su nombre de usuario");
        jTUsuario.setForeground(Color.GRAY); // vuelve a gris si está vacío
        }
    }//GEN-LAST:event_jTUsuarioFocusLost

    private void jPContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPContraseñaFocusGained
        if (String.valueOf(jPContraseña.getPassword()).equals("Ingrese una contraseña")) {
    jPContraseña.setText("");
    jPContraseña.setForeground(Color.WHITE);
    jPContraseña.setEchoChar('\u2022'); // Activa el ocultamiento
}
    }//GEN-LAST:event_jPContraseñaFocusGained

    private void jPContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPContraseñaFocusLost
        if (String.valueOf(jPContraseña.getPassword()).isEmpty()) {
    jPContraseña.setText("Ingrese una contraseña");
    jPContraseña.setForeground(Color.GRAY);
    jPContraseña.setEchoChar('\u2022');
    jPContraseña.setEchoChar((char) 0); // Desactiva el ocultamiento
}
    }//GEN-LAST:event_jPContraseñaFocusLost

    private void jLInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInicioMouseClicked
        InicioSesion abrir = new InicioSesion();
        if(this.getExtendedState() == Inicio.MAXIMIZED_BOTH){
            abrir.setExtendedState(Inicio.MAXIMIZED_BOTH);
        }
        
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLInicioMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCrear;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLConfirmar;
    private javax.swing.JLabel jLContraseña;
    private javax.swing.JLabel jLCorreo;
    private javax.swing.JLabel jLInicio;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    javax.swing.JPasswordField jPConfirmar;
    private javax.swing.JPasswordField jPContraseña;
    private javax.swing.JPanel jPCorreo;
    private javax.swing.JPanel jPUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPconfirmar;
    private javax.swing.JPanel jPcontraseña;
    private javax.swing.JTextField jTCorreo;
    private javax.swing.JTextField jTUsuario;
    // End of variables declaration//GEN-END:variables
}
    class FondoPanel2 extends JPanel
    {
        private Image imagen;
        
            @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Repositorio/FondoRegistro.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    

