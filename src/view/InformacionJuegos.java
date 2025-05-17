/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Comentarios;
import controller.UsuarioController;
import controller.Megusta;
import controllerJuegos.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorListener;
import model.GameDates;

/**
 *
 * @author USER
 */
public class InformacionJuegos extends javax.swing.JFrame {

    private final UsuarioController USUARIO = new UsuarioController();
    private final InfoVideoJuegos JUEGO = new InfoVideoJuegos();
    private final MostrarInformacionJuego MOSTRAR = new MostrarInformacionJuego();
    private final Megusta MG = new Megusta();
    private final Comentarios C = new Comentarios();
    private FondoPanel9 fondo = new FondoPanel9();
    
    String juego = JUEGO.juegos();
    String user = USUARIO.usuarioSesion();
    
    JPanel jPComentarios;
    JTextArea jTComentarios;
    
    public InformacionJuegos() {
        initComponents();
        mostrarPortada();
        mostrarJuegoDescripcion();
        mostrarPlataforma();
        mostrarDesarrollador();
        mostrarGeneros();
        mostrarFecha();
        mostrarNominaciones();
        mostrarPremios();
        mostrarDiseñadores();
        mostrarTitulo();
        mostrarComentarios();
        cambiarBt(jbMegusta, jBComentar);
        cambiarBtPanel(jBMicuenta, jBGeneral);
    }

    private void mostrarTitulo(){
        JPanel jPTitulos = new JPanel();
        jPTitulos.setLayout(new BoxLayout(jPTitulos, BoxLayout.Y_AXIS));
        jPTitulos.setPreferredSize(new Dimension(750, 40));
        jPTitulos.setMaximumSize(new Dimension (750, 40));
        jPTitulos.setMinimumSize(new Dimension(750, 40));
        jPTitulos.setBackground(Color.DARK_GRAY);
        jPTitulos.setVisible(true);

        //Colocar JLabel para Plataformas
        JLabel jLTitulo = new JLabel("");
        jLTitulo.setPreferredSize(new Dimension(750, 40));
        jLTitulo.setMaximumSize(new Dimension(750, 40));
        jLTitulo.setMinimumSize(new Dimension(750, 40));        
        Font fuente = new Font("Yu Gothic Light", Font.PLAIN, 25);
        jLTitulo.setBackground(null);
        jLTitulo.setFont(fuente);
        jLTitulo.setForeground(Color.WHITE);
        jLTitulo.setVerticalAlignment(SwingConstants.CENTER);
        jLTitulo.setVisible(true);
        jLTitulo.setOpaque(true);
        jLTitulo.setText("   " + MOSTRAR.obtenerTitulo());
        
        jPTitulos.add(jLTitulo);
        jPTitulos.revalidate();
        jPTitulos.repaint();
        jPTitulo.add(jPTitulos);
    }
    
    private void mostrarPortada(){
        
        JPanel jPPortada = new JPanel();
        jPPortada.setLayout(new BoxLayout(jPPortada, BoxLayout.Y_AXIS));
        jPPortada.setPreferredSize(new Dimension(170, 245));
        jPPortada.setMaximumSize(new Dimension (170, 245));
        jPPortada.setMinimumSize(new Dimension(170, 245));
        jPPortada.setBackground(Color.GRAY);
        jPPortada.setVisible(true);
        
        //Colocar JLabel para imagen
        JLabel jLPortada = new JLabel();
        jLPortada.setPreferredSize(new Dimension(170, 245));
        jLPortada.setMaximumSize(new Dimension(170, 245));
        jLPortada.setMinimumSize(new Dimension(170, 245));
        jLPortada.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el texto horizontalmente        
        
        jLPortada.setVisible(true);
        jLPortada.setOpaque(true);
        File portada = new File("resourcer/portadas/" + juego + ".png");
        jLPortada.setIcon(new ImageIcon(portada.getAbsolutePath()));
        ImageIcon ftoOriginal = new ImageIcon(portada.getAbsolutePath());
        Image ftoEscalada = ftoOriginal.getImage().getScaledInstance(170, 245, Image.SCALE_SMOOTH);
        ImageIcon ftoFinal = new ImageIcon(ftoEscalada);
        jLPortada.setIcon(ftoFinal);
        System.out.print("\nIMAGEN AGREGADA");
        
        jPPortada.add(jLPortada);
        jPPortada.revalidate();
        jPPortada.repaint();
        jPMostrarPo.add(jPPortada);
    }
        
    private void mostrarJuegoDescripcion(){
        JPanel jPDescripcion = new JPanel();
        jPDescripcion.setLayout(new BoxLayout(jPDescripcion, BoxLayout.Y_AXIS));
        jPDescripcion.setPreferredSize(new Dimension(700, 100));
        jPDescripcion.setMaximumSize(new Dimension (700, 100));
        jPDescripcion.setMinimumSize(new Dimension(700, 100));
        jPDescripcion.setBackground(Color.DARK_GRAY);
        jPDescripcion.setVisible(true);
        
        JTextArea jTDescripcion = new JTextArea("");
        jTDescripcion.setPreferredSize(new Dimension(700, 100));
        jTDescripcion.setMaximumSize(new Dimension(700, 100));
        jTDescripcion.setMinimumSize(new Dimension(700, 100));        
        Font fente = new Font("Yu Gothic Light", Font.PLAIN, 14);
        jTDescripcion.setBackground(null);
        jTDescripcion.setFont(fente);
        jTDescripcion.setForeground(Color.WHITE);
        jTDescripcion.setEditable(false);
        jTDescripcion.setLineWrap(true); //Activar salto de linea
        jTDescripcion.setWrapStyleWord(true); //Salto de linea por palabra
        jTDescripcion.setSelectionColor(new Color(153,0,255));
        jTDescripcion.setSelectedTextColor(Color.WHITE);
        jTDescripcion.setBorder(null);
        jTDescripcion.setWrapStyleWord(false);
        jTDescripcion.setVisible(true);
        jTDescripcion.setOpaque(true);
        
        jTDescripcion.setText(MOSTRAR.obtenerDescripcion());
        jPDescripcion.add(jTDescripcion);
        jPDescripcion.revalidate();
        jPDescripcion.repaint();
        jPMostrarDes.add(jPDescripcion);
    }
    
    private void mostrarPlataforma(){
        JPanel jPPlataformas = new JPanel();
        jPPlataformas.setLayout(new BoxLayout(jPPlataformas, BoxLayout.Y_AXIS));
        jPPlataformas.setPreferredSize(new Dimension(500, 38));
        jPPlataformas.setMaximumSize(new Dimension (500, 38));
        jPPlataformas.setMinimumSize(new Dimension(500, 38));
        jPPlataformas.setBackground(Color.DARK_GRAY);
        jPPlataformas.setVisible(true);
        
        //Colocar JLabel para Plataformas
        JLabel jLPlataforma = new JLabel("");
        jLPlataforma.setPreferredSize(new Dimension(500, 38));
        jLPlataforma.setMaximumSize(new Dimension(500, 38));
        jLPlataforma.setMinimumSize(new Dimension(500, 38));        
        Font fuente = new Font("Yu Gothic Light", Font.PLAIN, 18);
        jLPlataforma.setBackground(null);
        jLPlataforma.setFont(fuente);
        jLPlataforma.setForeground(Color.WHITE);
        jLPlataforma.setVerticalAlignment(SwingConstants.CENTER);
        jLPlataforma.setVisible(true);
        jLPlataforma.setOpaque(true);
        jLPlataforma.setText(MOSTRAR.obtenerPlataforma());
        
        jPPlataformas.add(jLPlataforma);
        jPPlataformas.revalidate();
        jPPlataformas.repaint();
        jPMostrarP.add(jPPlataformas);
        
    }
    
    private void mostrarDesarrollador(){
        JPanel jPDesarollador = new JPanel();
        jPDesarollador.setLayout(new BoxLayout(jPDesarollador, BoxLayout.Y_AXIS));
        jPDesarollador.setPreferredSize(new Dimension(500, 38));
        jPDesarollador.setMaximumSize(new Dimension (500, 38));
        jPDesarollador.setMinimumSize(new Dimension(500, 38));
        jPDesarollador.setBackground(Color.DARK_GRAY);
        jPDesarollador.setVisible(true);
        
        //Colocar JLabel para Plataformas
        JLabel jLDesarollador = new JLabel("");
        jLDesarollador.setPreferredSize(new Dimension(500, 38));
        jLDesarollador.setMaximumSize(new Dimension(500, 38));
        jLDesarollador.setMinimumSize(new Dimension(500, 38));        
        Font fuente = new Font("Yu Gothic Light", Font.PLAIN, 18);
        jLDesarollador.setBackground(null);
        jLDesarollador.setFont(fuente);
        jLDesarollador.setForeground(Color.WHITE);
        jLDesarollador.setVerticalAlignment(SwingConstants.CENTER);
        jLDesarollador.setVisible(true);
        jLDesarollador.setOpaque(true);
        jLDesarollador.setText(MOSTRAR.obtenerDesarrollador());
        
        jPDesarollador.add(jLDesarollador);
        jPDesarollador.revalidate();
        jPDesarollador.repaint();
        jPMostrarDev.add(jPDesarollador);
    }
    
    private void mostrarGeneros(){
        JPanel jPGeneros = new JPanel();
        jPGeneros.setLayout(new BoxLayout(jPGeneros, BoxLayout.Y_AXIS));
        jPGeneros.setPreferredSize(new Dimension(500, 38));
        jPGeneros.setMaximumSize(new Dimension (500, 38));
        jPGeneros.setMinimumSize(new Dimension(500, 38));
        jPGeneros.setBackground(Color.DARK_GRAY);
        jPGeneros.setVisible(true);
        
        //Colocar JLabel para Plataformas
        JLabel jLGeneros = new JLabel("");
        jLGeneros.setPreferredSize(new Dimension(500, 38));
        jLGeneros.setMaximumSize(new Dimension(500, 38));
        jLGeneros.setMinimumSize(new Dimension(500, 38));        
        Font fuente = new Font("Yu Gothic Light", Font.PLAIN, 18);
        jLGeneros.setBackground(null);
        jLGeneros.setFont(fuente);
        jLGeneros.setForeground(Color.WHITE);
        jLGeneros.setVerticalAlignment(SwingConstants.CENTER);
        jLGeneros.setVisible(true);
        jLGeneros.setOpaque(true);
        jLGeneros.setText(MOSTRAR.obtenerGeneros());
        
        jPGeneros.add(jLGeneros);
        jPGeneros.revalidate();
        jPGeneros.repaint();
        jPMostrarG.add(jPGeneros);
    }
    
    private void mostrarFecha(){
        JPanel jPFecha = new JPanel();
        jPFecha.setLayout(new BoxLayout(jPFecha, BoxLayout.Y_AXIS));
        jPFecha.setPreferredSize(new Dimension(400, 38));
        jPFecha.setMaximumSize(new Dimension (400, 38));
        jPFecha.setMinimumSize(new Dimension(400, 38));
        jPFecha.setBackground(Color.DARK_GRAY);
        jPFecha.setVisible(true);
        
        //Colocar JLabel para Plataformas
        JLabel jLFecha = new JLabel("");
        jLFecha.setPreferredSize(new Dimension(400, 38));
        jLFecha.setMaximumSize(new Dimension(400, 38));
        jLFecha.setMinimumSize(new Dimension(400, 38));        
        Font fuente = new Font("Yu Gothic Light", Font.PLAIN, 18);
        jLFecha.setBackground(null);
        jLFecha.setFont(fuente);
        jLFecha.setForeground(Color.WHITE);
        jLFecha.setVerticalAlignment(SwingConstants.CENTER);
        jLFecha.setVisible(true);
        jLFecha.setOpaque(true);
        jLFecha.setText(MOSTRAR.obtenerFecha());
        
        jPFecha.add(jLFecha);
        jPFecha.revalidate();
        jPFecha.repaint();
        jPMostrarF.add(jPFecha);
    }
    
    private void mostrarNominaciones(){
        JPanel jPNominaciones = new JPanel();
        jPNominaciones.setLayout(new BoxLayout(jPNominaciones, BoxLayout.Y_AXIS));
        jPNominaciones.setPreferredSize(new Dimension(500, 38));
        jPNominaciones.setMaximumSize(new Dimension (500, 38));
        jPNominaciones.setMinimumSize(new Dimension(500, 38));
        jPNominaciones.setBackground(Color.DARK_GRAY);
        jPNominaciones.setVisible(true);
        
        //Colocar JLabel para Plataformas
        JLabel jLNominaciones = new JLabel("");
        jLNominaciones.setPreferredSize(new Dimension(500, 38));
        jLNominaciones.setMaximumSize(new Dimension(500, 38));
        jLNominaciones.setMinimumSize(new Dimension(500, 38));        
        Font fuente = new Font("Yu Gothic UI Light", Font.PLAIN, 18);
        jLNominaciones.setBackground(null);
        jLNominaciones.setFont(fuente);
        jLNominaciones.setForeground(Color.WHITE);
        jLNominaciones.setVerticalAlignment(SwingConstants.CENTER);
        jLNominaciones.setVisible(true);
        jLNominaciones.setOpaque(true);
        jLNominaciones.setText(MOSTRAR.obtenerNominaciones());
        
        jPNominaciones.add(jLNominaciones);
        jPNominaciones.revalidate();
        jPNominaciones.repaint();
        jPMostrarN.add(jPNominaciones);
    }
    
    private void mostrarPremios(){
        JPanel jPPremios = new JPanel();
        jPPremios.setLayout(new BoxLayout(jPPremios, BoxLayout.Y_AXIS));
        jPPremios.setPreferredSize(new Dimension(500, 38));
        jPPremios.setMaximumSize(new Dimension (500, 38));
        jPPremios.setMinimumSize(new Dimension(500, 38));
        jPPremios.setBackground(Color.DARK_GRAY);
        jPPremios.setVisible(true);
        
        //Colocar JLabel para Plataformas
        JLabel jLPremios = new JLabel("");
        jLPremios.setPreferredSize(new Dimension(500, 38));
        jLPremios.setMaximumSize(new Dimension(500, 38));
        jLPremios.setMinimumSize(new Dimension(500, 38));        
        Font fuente = new Font("Yu Gothic UI Light", Font.PLAIN, 18);
        jLPremios.setBackground(null);
        jLPremios.setFont(fuente);
        jLPremios.setForeground(Color.WHITE);
        jLPremios.setVerticalAlignment(SwingConstants.CENTER);
        jLPremios.setVisible(true);
        jLPremios.setOpaque(true);
        jLPremios.setText(MOSTRAR.obtenerPremios());
        
        jPPremios.add(jLPremios);
        jPPremios.revalidate();
        jPPremios.repaint();
        jPMostrarPr.add(jPPremios);
    }
    
    private void mostrarDiseñadores(){
        JPanel jPDiseñadores = new JPanel();
        jPDiseñadores.setLayout(new BoxLayout(jPDiseñadores, BoxLayout.Y_AXIS));
        jPDiseñadores.setPreferredSize(new Dimension(500, 38));
        jPDiseñadores.setMaximumSize(new Dimension (500, 38));
        jPDiseñadores.setMinimumSize(new Dimension(500, 38));
        jPDiseñadores.setBackground(Color.DARK_GRAY);
        jPDiseñadores.setVisible(true);
        
        //Colocar JLabel para Plataformas
        JLabel jLDiseñadores = new JLabel("");
        jLDiseñadores.setPreferredSize(new Dimension(500, 38));
        jLDiseñadores.setMaximumSize(new Dimension(500, 38));
        jLDiseñadores.setMinimumSize(new Dimension(500, 38));        
        Font fuente = new Font("Yu Gothic Light", Font.PLAIN, 18);
        jLDiseñadores.setBackground(null);
        jLDiseñadores.setFont(fuente);
        jLDiseñadores.setForeground(Color.WHITE);
        jLDiseñadores.setVerticalAlignment(SwingConstants.CENTER);
        jLDiseñadores.setVisible(true);
        jLDiseñadores.setOpaque(true);
        jLDiseñadores.setText(MOSTRAR.obtenerDiseñadores());
        
        jPDiseñadores.add(jLDiseñadores);
        jPDiseñadores.revalidate();
        jPDiseñadores.repaint();
        jPMostrarD.add(jPDiseñadores);
    }
    
    private void mostrarComentarios(){
        System.out.print("EJECUTANDO...");
   
    jPComentarios = new JPanel();
    jPComentarios.setLayout(new BoxLayout(jPComentarios, BoxLayout.Y_AXIS));
    jPComentarios.setPreferredSize(new Dimension(170, 210));
    jPComentarios.setMaximumSize(new Dimension(170, 210));
    jPComentarios.setMinimumSize(new Dimension(170, 210));
    jPComentarios.setBackground(new Color(51, 51, 51));
    jPComentarios.setVisible(true);
    
    // Crear JTextArea para los comentarios
    jTComentarios = new JTextArea("");
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


    // Obtener los comentarios
    Map<String, List<String>> comentarios = C.obtenerComentariosDeTdos();
    System.out.print("\nCOMENTARIO DESDE VIEW: " + comentarios);

    StringBuilder textoC = new StringBuilder();
    for (Map.Entry<String, List<String>> entry : comentarios.entrySet()) {
        textoC.append("   ").append(entry.getKey()).append("\n   ");
        for (String com : entry.getValue()) {
            textoC.append(com).append("\n");
        }
    }
    jTComentarios.setText(textoC.toString());

    // Agregar el JScrollPane al JPanel
jPComentarios.add(jTComentarios);
    jPComentarios.revalidate();
    jPComentarios.repaint();
    jPMostrarC.add(jPComentarios);
    }
    
    private void actualizarComentarios(){
        Map<String, List<String>> comentarios = C.obtenerComentariosDeTdos();
        System.out.print("\nCOMENTARIO DESD VIEW: " + comentarios);
        StringBuilder textoC = new StringBuilder();
        for(Map.Entry<String, List<String>> entry : comentarios.entrySet()){
            jTComentarios = new JTextArea(entry.getKey());
            for(String com : entry.getValue()){
                jTComentarios = new JTextArea(com + "\n ");
            }
            
    }
        jPComentarios.add(jTComentarios);
        jPComentarios.revalidate();
        jPComentarios.repaint();
        jPMostrarC.add(jPComentarios);
    }
    
    private void cambiarBt(JButton... botones){
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
    


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jBMicuenta = new javax.swing.JButton();
        jBGeneral = new javax.swing.JButton();
        jBMegusta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPTitulo = new javax.swing.JPanel();
        jPContenedor1 = new javax.swing.JPanel();
        jPMostrarPo = new javax.swing.JPanel();
        jbMegusta = new javax.swing.JButton();
        jPMostrarC = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPContenedor2 = new javax.swing.JPanel();
        jPMostrarT = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSPDescripcion = new javax.swing.JScrollPane();
        jPMostrarDes = new javax.swing.JPanel();
        jPMostrarP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPMostrarDev = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPMostrarG = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPMostrarF = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPMostrarN = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPMostrarPr = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPMostrarD = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jBComentar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 269));

        jSplitPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setResizeWeight(1.0);
        jSplitPane1.setEnabled(false);
        jSplitPane1.setMaximumSize(new java.awt.Dimension(1580, 580));
        jSplitPane1.setMinimumSize(new java.awt.Dimension(1580, 580));
        jSplitPane1.setName(""); // NOI18N
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1580, 580));

        jPanel3.setBackground(java.awt.Color.darkGray);
        jPanel3.setMaximumSize(new java.awt.Dimension(250, 114));
        jPanel3.setMinimumSize(new java.awt.Dimension(230, 150));
        jPanel3.setPreferredSize(new java.awt.Dimension(230, 150));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jBMicuenta.setBackground(new java.awt.Color(103, 22, 199));
        jBMicuenta.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBMicuenta.setForeground(java.awt.Color.white);
        jBMicuenta.setText("MI CUENTA");
        jBMicuenta.setAlignmentX(0.5F);
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
        jPanel3.add(jBMicuenta);

        jBGeneral.setBackground(new java.awt.Color(103, 22, 199));
        jBGeneral.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBGeneral.setForeground(java.awt.Color.white);
        jBGeneral.setText("GENERAL");
        jBGeneral.setAlignmentX(0.5F);
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
        jPanel3.add(jBGeneral);

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
        jPanel3.add(jBMegusta);

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel4.setBackground(java.awt.Color.darkGray);
        jPanel4.setMaximumSize(new java.awt.Dimension(980, 980));
        jPanel4.setMinimumSize(new java.awt.Dimension(980, 980));
        jPanel4.setPreferredSize(new java.awt.Dimension(980, 980));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPTitulo.setBackground(java.awt.Color.darkGray);
        jPTitulo.setMaximumSize(new java.awt.Dimension(980, 980));
        jPTitulo.setMinimumSize(new java.awt.Dimension(980, 980));
        jPTitulo.setPreferredSize(new java.awt.Dimension(750, 40));
        jPTitulo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel4.add(jPTitulo, java.awt.BorderLayout.PAGE_START);

        jPContenedor1.setBackground(java.awt.Color.darkGray);
        jPContenedor1.setPreferredSize(new java.awt.Dimension(180, 584));

        jPMostrarPo.setBackground(java.awt.Color.darkGray);
        jPMostrarPo.setPreferredSize(new java.awt.Dimension(170, 245));
        jPContenedor1.add(jPMostrarPo);

        jbMegusta.setBackground(java.awt.Color.darkGray);
        jbMegusta.setFont(new java.awt.Font("Yu Gothic Light", 0, 16)); // NOI18N
        jbMegusta.setForeground(java.awt.Color.white);
        jbMegusta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Repositorio/BtMegusta.png"))); // NOI18N
        jbMegusta.setText("ME GUSTA");
        jbMegusta.setBorder(null);
        jbMegusta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMegusta.setFocusPainted(false);
        jbMegusta.setPreferredSize(new java.awt.Dimension(125, 30));
        jbMegusta.setVerifyInputWhenFocusTarget(false);
        jbMegusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMegustaActionPerformed(evt);
            }
        });
        jPContenedor1.add(jbMegusta);

        jPMostrarC.setBackground(new java.awt.Color(51, 51, 51));
        jPMostrarC.setPreferredSize(new java.awt.Dimension(170, 210));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("COMENTARIOS");
        jPMostrarC.add(jLabel9);

        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("────────────────");
        jPMostrarC.add(jLabel10);

        jPContenedor1.add(jPMostrarC);

        jPanel4.add(jPContenedor1, java.awt.BorderLayout.LINE_START);

        jPContenedor2.setBackground(java.awt.Color.darkGray);
        jPContenedor2.setMaximumSize(new java.awt.Dimension(4518, 1020));
        jPContenedor2.setPreferredSize(new java.awt.Dimension(700, 548));

        jPMostrarT.setBackground(new java.awt.Color(153, 0, 255));
        jPMostrarT.setMaximumSize(new java.awt.Dimension(1000, 44));
        jPMostrarT.setMinimumSize(new java.awt.Dimension(234, 42));
        jPMostrarT.setPreferredSize(new java.awt.Dimension(700, 30));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("DESCRIPCIÓN");

        javax.swing.GroupLayout jPMostrarTLayout = new javax.swing.GroupLayout(jPMostrarT);
        jPMostrarT.setLayout(jPMostrarTLayout);
        jPMostrarTLayout.setHorizontalGroup(
            jPMostrarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMostrarTLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );
        jPMostrarTLayout.setVerticalGroup(
            jPMostrarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMostrarTLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPContenedor2.add(jPMostrarT);

        jPMostrarDes.setBackground(java.awt.Color.darkGray);
        jPMostrarDes.setForeground(java.awt.Color.darkGray);
        jPMostrarDes.setPreferredSize(new java.awt.Dimension(700, 100));
        jPMostrarDes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jSPDescripcion.setViewportView(jPMostrarDes);

        jPContenedor2.add(jSPDescripcion);

        jPMostrarP.setBackground(java.awt.Color.darkGray);
        jPMostrarP.setMaximumSize(new java.awt.Dimension(1000, 50));
        jPMostrarP.setMinimumSize(new java.awt.Dimension(1000, 50));
        jPMostrarP.setPreferredSize(new java.awt.Dimension(700, 38));
        jPMostrarP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("• Plataformas: ");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPMostrarP.add(jLabel1);

        jPContenedor2.add(jPMostrarP);

        jPMostrarDev.setBackground(java.awt.Color.darkGray);
        jPMostrarDev.setPreferredSize(new java.awt.Dimension(700, 38));
        jPMostrarDev.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("• Desarrollador: ");
        jPMostrarDev.add(jLabel2);

        jPContenedor2.add(jPMostrarDev);

        jPMostrarG.setBackground(java.awt.Color.darkGray);
        jPMostrarG.setPreferredSize(new java.awt.Dimension(700, 38));
        jPMostrarG.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("• Generos: ");
        jPMostrarG.add(jLabel3);

        jPContenedor2.add(jPMostrarG);

        jPMostrarF.setBackground(java.awt.Color.darkGray);
        jPMostrarF.setPreferredSize(new java.awt.Dimension(700, 38));
        jPMostrarF.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("• Fecha de estreno inicial: ");
        jPMostrarF.add(jLabel4);

        jPContenedor2.add(jPMostrarF);

        jPMostrarN.setBackground(java.awt.Color.darkGray);
        jPMostrarN.setPreferredSize(new java.awt.Dimension(700, 38));
        jPMostrarN.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("• Nominaciones: ");
        jLabel5.setToolTipText("");
        jPMostrarN.add(jLabel5);

        jPContenedor2.add(jPMostrarN);

        jPMostrarPr.setBackground(java.awt.Color.darkGray);
        jPMostrarPr.setPreferredSize(new java.awt.Dimension(700, 38));
        jPMostrarPr.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel6.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("• Premios: ");
        jPMostrarPr.add(jLabel6);

        jPContenedor2.add(jPMostrarPr);

        jPMostrarD.setBackground(java.awt.Color.darkGray);
        jPMostrarD.setPreferredSize(new java.awt.Dimension(700, 38));
        jPMostrarD.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("• Diseñadores: ");
        jLabel7.setToolTipText("");
        jPMostrarD.add(jLabel7);

        jPContenedor2.add(jPMostrarD);

        jScrollPane1.setBackground(java.awt.Color.black);
        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 60));

        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jTextArea1.setForeground(java.awt.Color.white);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setMaximumSize(new java.awt.Dimension(160, 125));
        jTextArea1.setMinimumSize(new java.awt.Dimension(160, 125));
        jTextArea1.setPreferredSize(new java.awt.Dimension(600, 60));
        jTextArea1.setSelectionColor(new java.awt.Color(103, 22, 199));
        jScrollPane1.setViewportView(jTextArea1);

        jPContenedor2.add(jScrollPane1);

        jBComentar.setBackground(java.awt.Color.darkGray);
        jBComentar.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jBComentar.setForeground(java.awt.Color.white);
        jBComentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Repositorio/BtComentar.png"))); // NOI18N
        jBComentar.setBorder(null);
        jBComentar.setBorderPainted(false);
        jBComentar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBComentar.setMinimumSize(new java.awt.Dimension(115, 24));
        jBComentar.setPreferredSize(new java.awt.Dimension(35, 35));
        jBComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBComentarActionPerformed(evt);
            }
        });
        jPContenedor2.add(jBComentar);

        jPanel4.add(jPContenedor2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel4);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMegustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMegustaActionPerformed
        if(MG.obtenerMegusta(user) != null){
            MG.agregarMeGusta(Juego.getJuego().getTitulo()); 
            jbMegusta.setEnabled(false);
        } else {
            JOptionPane.showInputDialog("", "JUEGO YA AGREGADO");
        }
        
    }//GEN-LAST:event_jbMegustaActionPerformed

    private void jBComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBComentarActionPerformed
        jBComentar.addActionListener((ActionEvent e) -> {
            C.agregarComentario(Juego.getJuego().getTitulo(), jTextArea1.getText());
            jTextArea1.setText(" ");
            mostrarComentarios();
        });       
    }//GEN-LAST:event_jBComentarActionPerformed

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

    private void jBMegustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMegustaActionPerformed
        mostrarMegustas abrir = new mostrarMegustas();
            if(this.getExtendedState() == mostrarMegustas.MAXIMIZED_BOTH){
            abrir.setExtendedState(mostrarMegustas.MAXIMIZED_BOTH);
            }
            abrir.setVisible(true);
            this.setVisible(false);

    }//GEN-LAST:event_jBMegustaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBComentar;
    private javax.swing.JButton jBGeneral;
    private javax.swing.JButton jBMegusta;
    private javax.swing.JButton jBMicuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPContenedor1;
    private javax.swing.JPanel jPContenedor2;
    private javax.swing.JPanel jPMostrarC;
    private javax.swing.JPanel jPMostrarD;
    private javax.swing.JPanel jPMostrarDes;
    private javax.swing.JPanel jPMostrarDev;
    private javax.swing.JPanel jPMostrarF;
    private javax.swing.JPanel jPMostrarG;
    private javax.swing.JPanel jPMostrarN;
    private javax.swing.JPanel jPMostrarP;
    private javax.swing.JPanel jPMostrarPo;
    private javax.swing.JPanel jPMostrarPr;
    private javax.swing.JPanel jPMostrarT;
    private javax.swing.JPanel jPTitulo;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jSPDescripcion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbMegusta;
    // End of variables declaration//GEN-END:variables
} class FondoPanel9 extends JPanel
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
