/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controllerJuegos.InfoVideoJuegos;
import controller.Sesion;
import controller.UsuarioController;
import controllerJuegos.Juego;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import model.GameDates;

public final class BibliotecaGeneral extends javax.swing.JFrame {
    
    private final UsuarioController USUARIO = new UsuarioController();
    private final InfoVideoJuegos JUEGO = new InfoVideoJuegos();
    FondoPanel3 fondo = new FondoPanel3();
    String juego = JUEGO.juegos();
    String user = USUARIO.usuarioSesion();


        

    public BibliotecaGeneral() {
        setMinimumSize(new Dimension(1000, 600)); // Ajusta el tamaño según tu imagen de fondo
        this.setContentPane(fondo);
        
       
        initComponents();
        this.setLocationRelativeTo(null);
        //Para expandir componentes de manera automatica
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jSplitPane2, BorderLayout.CENTER);  
        mostrarJuego();
        cambiarBtPanel(jBMicuenta, jBGeneral);
    }
    
    public void mostrarJuego(){
        List<GameDates>  biblioteca;
        biblioteca = JUEGO.cargarBiblioteca("juegos/");
    var resultado = JUEGO.cargarBiblioteca("juegos/");
    System.out.println("Tipo de retorno: " + (resultado != null ? resultado.getClass().getName() : "NULL"));
    if (!biblioteca.isEmpty()) {
   
    for (GameDates game : biblioteca) {
        System.out.println("Juego encontrado: " + game.getTitulo());

        //Crear JPanel para mostrar videojuegos
        JPanel minipanel = new JPanel();
        minipanel.setLayout(new BoxLayout(minipanel, BoxLayout.Y_AXIS));
        minipanel.setPreferredSize(new Dimension(180, 250));
        minipanel.setMaximumSize(new Dimension (180, 250));
        minipanel.setMinimumSize(new Dimension(180, 250));
        minipanel.setBackground(Color.GRAY);
        minipanel.setVisible(true);
        
        //Colocar JLabel para imagen 
        JLabel imagen = new JLabel();   
        if (!biblioteca.isEmpty()){
        imagen.setPreferredSize(new Dimension(200, 210));
        imagen.setMaximumSize(new Dimension(200, 210));
        imagen.setMinimumSize(new Dimension(200, 210));
        
        imagen.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el texto horizontalmente        
        imagen.setOpaque(true);
        imagen.setVisible(true);
        File portada = new File("resourcer/portadas/" + game.getTitulo() + ".png");
        imagen.setIcon(new ImageIcon(portada.getAbsolutePath()));
        ImageIcon ftoOriginal = new ImageIcon(portada.getAbsolutePath());
        Image ftoEscalada = ftoOriginal.getImage().getScaledInstance(200, 210, Image.SCALE_SMOOTH);
        ImageIcon ftoFinal = new ImageIcon(ftoEscalada);
        imagen.setIcon(ftoFinal);
        System.out.print("\nINFORMACION DESDE VIEW: " + portada.getAbsolutePath());
        imagen.addMouseListener(new MouseAdapter() {
        @Override
        //mouseClicked para abrir la info. de los juegos 
        public void mouseClicked(MouseEvent e) {
            JFrame BibliotecaGeneral = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
            Juego.setJuego(game);
            InformacionJuegos abrir = new InformacionJuegos();
            abrir.setVisible(true); 
            BibliotecaGeneral.setVisible(false);
            }
        });

        }
        
        //Colocar JLabel para el nombre
        JLabel nombre = new JLabel("", SwingConstants.CENTER);
        if (!biblioteca.isEmpty()){
            nombre.setPreferredSize(new Dimension(200, 38));
        nombre.setMaximumSize(new Dimension(200, 38));
        nombre.setMinimumSize(new Dimension(200, 38));
        Font fuente = new Font("Yu Gothic Light", Font.PLAIN, 20);
        nombre.setText(game.getTitulo());
        nombre.setFont(fuente);
        nombre.setBackground(Color.GRAY);
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el texto horizontalmente  
        nombre.setOpaque(true);
        nombre.setVisible(true);
        }
        
        minipanel.add(imagen);
        minipanel.add(nombre);  
        jPContenedor1.add(minipanel);
        JPanel jPContenedor1 = (JPanel) jScrollPane2.getViewport().getView();
        // Actualizar la interfaz para que se muestre el cambio
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jPContenedor1.setPreferredSize(new Dimension(600, biblioteca.size() * 250));
        jPContenedor1.revalidate();
        jPContenedor1.repaint();
    }
    }
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
     * This method is called from within the construcor to initialize the form.
     * WARNING: Do NOT modify this code. The content f this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jBMicuenta = new javax.swing.JButton();
        jBGeneral = new javax.swing.JButton();
        jBMegustaB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPContenedor1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(450, 269));

        jSplitPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jSplitPane2.setDividerLocation(200);
        jSplitPane2.setResizeWeight(1.0);
        jSplitPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSplitPane2.setEnabled(false);
        jSplitPane2.setMaximumSize(new java.awt.Dimension(1580, 580));
        jSplitPane2.setMinimumSize(new java.awt.Dimension(1580, 580));
        jSplitPane2.setPreferredSize(new java.awt.Dimension(1580, 580));

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setMaximumSize(new java.awt.Dimension(250, 114));
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
        jBMicuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMicuentaActionPerformed(evt);
            }
        });
        jPanel1.add(jBMicuenta);

        jBGeneral.setBackground(new java.awt.Color(103, 22, 199));
        jBGeneral.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBGeneral.setForeground(java.awt.Color.white);
        jBGeneral.setText("GENERAL");
        jBGeneral.setAlignmentX(0.5F);
        jBGeneral.setBorder(null);
        jBGeneral.setFocusPainted(false);
        jBGeneral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBGeneral.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jBGeneral.setMargin(new java.awt.Insets(10, 0, 10, 70));
        jBGeneral.setMaximumSize(new java.awt.Dimension(230, 50));
        jBGeneral.setMinimumSize(new java.awt.Dimension(230, 50));
        jBGeneral.setPreferredSize(new java.awt.Dimension(230, 50));
        jPanel1.add(jBGeneral);

        jBMegustaB.setBackground(new java.awt.Color(103, 22, 199));
        jBMegustaB.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBMegustaB.setForeground(java.awt.Color.white);
        jBMegustaB.setText("MIS JUEGOS");
        jBMegustaB.setAlignmentX(0.5F);
        jBMegustaB.setBorder(null);
        jBMegustaB.setFocusPainted(false);
        jBMegustaB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBMegustaB.setMargin(new java.awt.Insets(10, 0, 10, 70));
        jBMegustaB.setMaximumSize(new java.awt.Dimension(230, 50));
        jBMegustaB.setMinimumSize(new java.awt.Dimension(230, 50));
        jBMegustaB.setPreferredSize(new java.awt.Dimension(230, 50));
        jBMegustaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMegustaBActionPerformed(evt);
            }
        });
        jPanel1.add(jBMegustaB);

        jSplitPane2.setLeftComponent(jPanel1);

        jPanel2.setMaximumSize(new java.awt.Dimension(980, 980));
        jPanel2.setMinimumSize(new java.awt.Dimension(980, 980));
        jPanel2.setPreferredSize(new java.awt.Dimension(980, 980));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(java.awt.Color.darkGray);
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("BIBLIOTECA GENERAL");
        jPanel4.add(jLabel1);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBackground(java.awt.Color.darkGray);
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(java.awt.Color.darkGray);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(580, 580));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(580, 580));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(580, 580));

        jPContenedor1.setBackground(java.awt.Color.darkGray);
        jPContenedor1.setMaximumSize(new java.awt.Dimension(580, 580));
        jPContenedor1.setMinimumSize(new java.awt.Dimension(580, 580));
        jPContenedor1.setPreferredSize(new java.awt.Dimension(980, 580));
        jPContenedor1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 30));
        jScrollPane2.setViewportView(jPContenedor1);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBMicuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMicuentaActionPerformed
        
        System.out.print("\nUSUARIO DESDE BIBLIOTECA ACTION PERFORMANCE " + (user != null ? USUARIO.usuarioSesion() : "NULL"));
        
        
        
        if (user != null){
            System.out.print("\nUSUARIO DESDE BIBLIOTECA DESDE IF " + USUARIO.usuarioSesion());
            
            PerfilUsuario abrir = new PerfilUsuario();
            if(this.getExtendedState() == PerfilUsuario.MAXIMIZED_BOTH){
            abrir.setExtendedState(PerfilUsuario.MAXIMIZED_BOTH);
            }
            abrir.setVisible(true);
            this.setVisible(false);
        } 
        
    }//GEN-LAST:event_jBMicuentaActionPerformed

    private void jBMegustaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMegustaBActionPerformed
        mostrarMegustas abrir = new mostrarMegustas();
            if(this.getExtendedState() == mostrarMegustas.MAXIMIZED_BOTH){
            abrir.setExtendedState(mostrarMegustas.MAXIMIZED_BOTH);
            }
            abrir.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jBMegustaBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGeneral;
    private javax.swing.JButton jBMegustaB;
    private javax.swing.JButton jBMicuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPContenedor1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    // End of variables declaration//GEN-END:variables

    
class FondoPanel3 extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Repositorio/FondoGeneral.png")).getImage();
            System.out.println(imagen + "Imagen no encontrada");
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
