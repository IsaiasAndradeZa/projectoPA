/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.UsuarioController;
import controllerJuegos.InfoVideoJuegos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GameAgregar extends javax.swing.JFrame {
    
    private BibliotecaGeneral biblioteca;
    private final InfoVideoJuegos JUEGO = new InfoVideoJuegos();
    private final UsuarioController USUARIO = new UsuarioController();
    private FondoPanel5 fondo = new FondoPanel5();
    private String rutaImagen = "";
    private JPanel fondoG = new JPanel();
    private JPanel fondoN = new JPanel();
    private JPanel fondoP = new JPanel();
    private JPanel fondoPr = new JPanel();
    private File imagenSeleccionada;
  
    public GameAgregar() {

        setMinimumSize(new Dimension(1000, 600)); // Ajusta el tamaño según tu imagen de fondo
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        

    }
    
    public void setBiblioteca(BibliotecaGeneral biblioteca){
        this.biblioteca = biblioteca;
    }
    
    
    private void limpiarCampos() {
    jTtitulo.setText("");
    jTDesarrolladores.setText("");
    jTDiseñadores.setText("");
    jTFecha.setText("");
    jTDescripcion.setText("");
    jLRuta.setText("Sin seleccioar");
    jBImagen.setText("Seleccionar Imagen");
//    rutaImagen = "";
    }

private final Map<String, Boolean> estadoSeleccion = new HashMap<>();


private void guardarSeleccion(JPanel fondo) {
    for (Component comp : fondo.getComponents()) {
            if (comp instanceof JCheckBox){
                JCheckBox check = (JCheckBox) comp;
                estadoSeleccion.put(check.getText(), check.isSelected());
            }
        }

}

private void restaurarSeleccion(JPanel fondo) {
    for (Component comp : fondo.getComponents()) {
        if (comp instanceof JCheckBox) {
            JCheckBox check = (JCheckBox) comp;
            check.setSelected(estadoSeleccion.getOrDefault(check.getText(), false)); // ✅ Restaura estado
        }
    }
}
    //METODOS PARA LOS MENUS DESPLEGABLES
    
    private void menuGenero(){
        
        //Crear menú desplegable con multiples opciones 
        fondoG = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        
        fondoG.setSize(jPGeneros.getWidth(), 100);
        fondoG.setLayout(new BoxLayout(fondoG, BoxLayout.Y_AXIS));
        
        fondoG.add(new JCheckBox("Acción"));
        fondoG.add(new JCheckBox("Aventura"));
        fondoG.add(new JCheckBox("Casual"));
        fondoG.add(new JCheckBox("Arcade"));
        fondoG.add(new JCheckBox("Simulación"));
        fondoG.add(new JCheckBox("RPG"));
        fondoG.add(new JCheckBox("Ingenio"));
        fondoG.add(new JCheckBox("Estrategia"));
        fondoG.add(new JCheckBox("Carreras"));
        fondoG.add(new JCheckBox("Terror"));
        fondoG.add(new JCheckBox("Pelea"));
        fondoG.add(new JCheckBox("Deportes"));
        fondoG.add(new JCheckBox("Drama"));
        fondoG.add(new JCheckBox("Psicolígico"));
        
        jScrollPane.setViewportView(fondoG);
        jScrollPane.setPreferredSize(new Dimension(jPGeneros.getWidth(), 100));
        
       
        
        java.awt.Point p = SwingUtilities.convertPoint(jPGeneros.getParent(), jPGeneros.getLocation(), getLayeredPane());
        jScrollPane.setBounds(p.x, 100, jPGeneros.getWidth(), 100);
        getLayeredPane().add(jScrollPane, JLayeredPane.POPUP_LAYER);

        //Cerrar el menu cuando se presione fuera de el
        
       getContentPane().addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                if(!jScrollPane.getBounds().contains(e.getPoint())){
                   guardarSeleccion(fondoG);
                   jScrollPane.setVisible(false);    
               }
            }
        });
        restaurarSeleccion(fondoG);
        fondoG.setVisible(true);
    }
    
    private String guardarGeneros(){
        menuGenero(); 
        StringBuilder generosSeleccionados = new StringBuilder();
        for (Component comp : fondoG.getComponents()) {
    if (comp instanceof JCheckBox check) {
        if (check.isSelected()) {
            generosSeleccionados.append(check.getText()).append(", ");
            }
        }
    }

    if (generosSeleccionados.length() > 0) {
        generosSeleccionados.setLength(generosSeleccionados.length() - 2); // Eliminar ultima coma
        } else {
            generosSeleccionados.append("Sin generos");
        }
    
        return generosSeleccionados.toString();
    }
    
    private void menuNominaciones(){
        //Crear menú desplegable con multiples opciones 
        fondoN = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        
        fondoN.setSize(jPNominaciones.getWidth(), 200);
        fondoN.setLayout(new BoxLayout(fondoN, BoxLayout.Y_AXIS));
        
        fondoN.add(new JCheckBox("Juego del año"));
        fondoN.add(new JCheckBox("Mejor dirección"));
        fondoN.add(new JCheckBox("Mejor de arte"));
        fondoN.add(new JCheckBox("Mejor narrativa"));
        fondoN.add(new JCheckBox("Mejor juego de impacto"));
        
        jScrollPane.setViewportView(fondoN);
        jScrollPane.setPreferredSize(new Dimension(jPNominaciones.getWidth(), 80));
        
       
        
        java.awt.Point p = SwingUtilities.convertPoint(jPNominaciones.getParent(), jPNominaciones.getLocation(), getLayeredPane());
        jScrollPane.setBounds(p.x, p.y, jPNominaciones.getWidth(), 80);
        getLayeredPane().add(jScrollPane, JLayeredPane.POPUP_LAYER);

        //Cerrar el menu cuando se presione fuera de el
        
       getContentPane().addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
               if(!jScrollPane.getBounds().contains(e.getPoint())){
                   guardarSeleccion(fondoN);
                jScrollPane.setVisible(false);    
               }
            }
        });
        restaurarSeleccion(fondoN);
        fondoN.setVisible(true);
    
    }
    
    private String guardarNominaciones(){
        menuNominaciones(); 
        StringBuilder NomiSeleccionados = new StringBuilder();
        for (Component comp : fondoN.getComponents()) {
    if (comp instanceof JCheckBox check) {
        if (check.isSelected()) {
            NomiSeleccionados.append(check.getText()).append(", ");
            }
        }
    }

    if (NomiSeleccionados.length() > 0) {
        NomiSeleccionados.setLength(NomiSeleccionados.length() - 2); // Eliminar ultima coma
        } else {
            NomiSeleccionados.append("Ninguna nominación");
        }
    
        return NomiSeleccionados.toString();
    }
    
    private void menuPlataformas(){
        fondoP = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        
        fondoP.setSize(jPPlataformas.getWidth(), 200);
        fondoP.setLayout(new BoxLayout(fondoP, BoxLayout.Y_AXIS));
        
        fondoP.add(new JCheckBox("PlayStation 4"));
        fondoP.add(new JCheckBox("PlayStation 5"));
        fondoP.add(new JCheckBox("XBOX Series X/S"));
        fondoP.add(new JCheckBox("XBOX One"));
        fondoP.add(new JCheckBox("XBOX 360"));
        fondoP.add(new JCheckBox("PC"));
        
       jScrollPane.setViewportView(fondoP);
        jScrollPane.setPreferredSize(new Dimension(jPPlataformas.getWidth(), 80));
        
       
        
        java.awt.Point p = SwingUtilities.convertPoint(jPPlataformas.getParent(), jPPlataformas.getLocation(), getLayeredPane());
        jScrollPane.setBounds(p.x, p.y, jPPlataformas.getWidth(), 80);
        getLayeredPane().add(jScrollPane, JLayeredPane.POPUP_LAYER);

        //Cerrar el menu cuando se presione fuera de el
        
       getContentPane().addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
               if(!jScrollPane.getBounds().contains(e.getPoint())){
                   guardarSeleccion(fondoP);
                jScrollPane.setVisible(false);    
               }
            }
        });
       restaurarSeleccion(fondoP);
        fondoP.setVisible(true);
    }
    
    private String guardarPlataformas(){
        menuPlataformas(); 
        StringBuilder platSeleccionados = new StringBuilder();
        for (Component comp : fondoP.getComponents()) {
    if (comp instanceof JCheckBox check) {
        if (check.isSelected()) {
            platSeleccionados.append(check.getText()).append(", ");
            }
        }
    }

    if (platSeleccionados.length() > 0) {
        platSeleccionados.setLength(platSeleccionados.length() - 2); // Eliminar ultima coma
        } else {
            platSeleccionados.append("Sin plataforma");
        }
    
        return platSeleccionados.toString();
    }
    
    private void menuPremios(){
        fondoPr = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        
        
        fondoPr.setSize(jPPremios.getWidth(), 200);
        fondoPr.setLayout(new BoxLayout(fondoPr, BoxLayout.Y_AXIS));
        
        fondoPr.add(new JCheckBox("Ganador de juego del año"));
        fondoPr.add(new JCheckBox("Ganador de mejor dirección"));
        fondoPr.add(new JCheckBox("Ganador de mejor de arte"));
        fondoPr.add(new JCheckBox("Ganador de mejor narrativa"));
        fondoPr.add(new JCheckBox("Ganador de mejor juego de impacto"));
        
        jScrollPane.setViewportView(fondoPr);
        jScrollPane.setPreferredSize(new Dimension(jPPremios.getWidth(), 80));
        
       
        
        java.awt.Point p = SwingUtilities.convertPoint(jPPremios.getParent(), jPPremios.getLocation(), getLayeredPane());
        jScrollPane.setBounds(p.x, p.y, jPPremios.getWidth(), 80);
        getLayeredPane().add(jScrollPane, JLayeredPane.POPUP_LAYER);

        //Cerrar el menu cuando se presione fuera de el
        
       getContentPane().addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
               if(!jScrollPane.getBounds().contains(e.getPoint())){
                   guardarSeleccion(fondoPr);
                jScrollPane.setVisible(false);    
               }
                
            }
        });
        restaurarSeleccion(fondoPr);
        fondoPr.setVisible(true);
    
    }
    
    private String guardarPremios(){
        menuPremios(); 
        StringBuilder PrSeleccionados = new StringBuilder();
        for (Component comp : fondoPr.getComponents()) {
    if (comp instanceof JCheckBox check) {
        if (check.isSelected()) {
            PrSeleccionados.append(check.getText()).append(", ");
            }
        }
    }

    if (PrSeleccionados.length() > 0) {
        PrSeleccionados.setLength(PrSeleccionados.length() - 2); // Eliminar ultima coma
        } else {
            PrSeleccionados.append("Sin premios");
        }
    
        return PrSeleccionados.toString();
    }
    
    //METODOS PARA LA FECHA Y SU VERIFICACION
    
    public boolean validarForma(String fecha){
        fecha = fecha.trim();
        return fecha.matches("\\d{2}/\\d{2}/\\d{4}");
        
    }
    
    public boolean validarFecha(String fecha){
        if(!validarForma(fecha)){
            System.out.print("ERROR 1");
            return false;
        }
        String[] separador = fecha.split("/");
        if(separador.length != 3){
            System.out.print("ERROR 4 ");
            return false;
        }
        
        try {
            
            int dia = Integer.parseInt(separador[0]);
            int mes = Integer.parseInt(separador[1]);
            int anio = Integer.parseInt(separador[2]);
            
            System.out.print("DIA " + dia + " MES " + mes + " AÑO " + anio);
        
        if (anio < 1993 || anio > 2025){
            System.out.print("ERROR 2 ");
            return false;
        }
        
        if (mes < 1 || mes > 12){
            System.out.print("ERROR 3 ");
            return false;
        }
           
        int[] diaPormes = {31, (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 != 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(dia < 1 || dia > diaPormes[mes - 1]){
            return false;
        }
        
            SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
            forma.setLenient(false); //Desactivar correccion de errores automatics
            forma.parse(fecha); //Confirmar si la fecha existe
            return true;
        } catch (NumberFormatException | ParseException e) {
            return false;
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLRuta = new javax.swing.JLabel();
        jTtitulo = new javax.swing.JTextField();
        jTDesarrolladores = new javax.swing.JTextField();
        jTDiseñadores = new javax.swing.JTextField();
        jTFecha = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jBImagen = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDescripcion = new javax.swing.JTextArea();
        jBRegresar = new javax.swing.JButton();
        jPGeneros = new javax.swing.JPanel();
        jLGeneros = new javax.swing.JLabel();
        jPNominaciones = new javax.swing.JPanel();
        jLNominaciones = new javax.swing.JLabel();
        jPPlataformas = new javax.swing.JPanel();
        jLPlataformas = new javax.swing.JLabel();
        jPPremios = new javax.swing.JPanel();
        jLPremios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setMinimumSize(new java.awt.Dimension(820, 525));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 525));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Titulo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 60, 30));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Plataformas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Desarrollador");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Géneros");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Fecha de estreno inicial");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Nominaciones");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Premios");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 70, 20));

        jLabel9.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Diseñadores");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, -10, -1, 80));

        jLRuta.setFont(new java.awt.Font("Yu Gothic Light", 0, 14)); // NOI18N
        jLRuta.setForeground(java.awt.Color.white);
        jLRuta.setText("Solo imagenes \"png\"");
        jPanel1.add(jLRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, -1, 20));

        jTtitulo.setBackground(new java.awt.Color(51, 51, 51));
        jTtitulo.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        jTtitulo.setForeground(java.awt.Color.white);
        jTtitulo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTtitulo.setCaretColor(new java.awt.Color(255, 255, 255));
        jTtitulo.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTtitulo.setSelectionColor(new java.awt.Color(153, 0, 255));
        jPanel1.add(jTtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 340, 30));

        jTDesarrolladores.setBackground(new java.awt.Color(51, 51, 51));
        jTDesarrolladores.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        jTDesarrolladores.setForeground(java.awt.Color.white);
        jTDesarrolladores.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTDesarrolladores.setCaretColor(new java.awt.Color(255, 255, 255));
        jTDesarrolladores.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTDesarrolladores.setSelectionColor(new java.awt.Color(153, 0, 255));
        jPanel1.add(jTDesarrolladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 340, 30));

        jTDiseñadores.setBackground(new java.awt.Color(51, 51, 51));
        jTDiseñadores.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        jTDiseñadores.setForeground(java.awt.Color.white);
        jTDiseñadores.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTDiseñadores.setCaretColor(new java.awt.Color(255, 255, 255));
        jTDiseñadores.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTDiseñadores.setSelectionColor(new java.awt.Color(153, 0, 255));
        jPanel1.add(jTDiseñadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 340, 30));

        jTFecha.setBackground(new java.awt.Color(51, 51, 51));
        jTFecha.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        jTFecha.setForeground(java.awt.Color.white);
        jTFecha.setText("DD/MM/AA");
        jTFecha.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTFecha.setCaretColor(new java.awt.Color(255, 255, 255));
        jTFecha.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTFecha.setSelectionColor(new java.awt.Color(153, 0, 255));
        jTFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFechaFocusLost(evt);
            }
        });
        jPanel1.add(jTFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 340, 30));

        jBAgregar.setBackground(new java.awt.Color(103, 22, 199));
        jBAgregar.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBAgregar.setForeground(java.awt.Color.white);
        jBAgregar.setText("Agregar");
        jBAgregar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jBAgregar.setFocusable(false);
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jBAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 330, 40));

        jBImagen.setBackground(new java.awt.Color(103, 22, 199));
        jBImagen.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jBImagen.setForeground(java.awt.Color.white);
        jBImagen.setText("Seleccionar imagen");
        jBImagen.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jBImagen.setFocusable(false);
        jBImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImagenActionPerformed(evt);
            }
        });
        jPanel1.add(jBImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 150, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Descripción");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("Portada");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, 40));

        jTDescripcion.setBackground(new java.awt.Color(51, 51, 51));
        jTDescripcion.setColumns(20);
        jTDescripcion.setFont(new java.awt.Font("Yu Gothic Light", 0, 14)); // NOI18N
        jTDescripcion.setForeground(java.awt.Color.white);
        jTDescripcion.setLineWrap(true);
        jTDescripcion.setRows(5);
        jTDescripcion.setWrapStyleWord(true);
        jTDescripcion.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTDescripcion.setSelectionColor(new java.awt.Color(153, 0, 255));
        jScrollPane1.setViewportView(jTDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 340, 120));

        jBRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Repositorio/BotonRegresar.png"))); // NOI18N
        jBRegresar.setBorderPainted(false);
        jBRegresar.setContentAreaFilled(false);
        jBRegresar.setDefaultCapable(false);
        jBRegresar.setFocusPainted(false);
        jBRegresar.setFocusable(false);
        jBRegresar.setRequestFocusEnabled(false);
        jBRegresar.setRolloverEnabled(false);
        jBRegresar.setVerifyInputWhenFocusTarget(false);
        jBRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jBRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 40, 40));

        jPGeneros.setBackground(new java.awt.Color(51, 51, 51));
        jPGeneros.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPGeneros.setLayout(new javax.swing.BoxLayout(jPGeneros, javax.swing.BoxLayout.Y_AXIS));

        jLGeneros.setBackground(java.awt.Color.lightGray);
        jLGeneros.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLGeneros.setForeground(java.awt.Color.lightGray);
        jLGeneros.setText("Seleccione los generos...");
        jLGeneros.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLGeneros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLGeneros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLGeneros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLGenerosMouseClicked(evt);
            }
        });
        jPGeneros.add(jLGeneros);

        jPanel1.add(jPGeneros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 340, 30));

        jPNominaciones.setBackground(new java.awt.Color(51, 51, 51));
        jPNominaciones.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPNominaciones.setLayout(new javax.swing.BoxLayout(jPNominaciones, javax.swing.BoxLayout.Y_AXIS));

        jLNominaciones.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLNominaciones.setForeground(java.awt.Color.lightGray);
        jLNominaciones.setText("Seleccione las nominaciones...");
        jLNominaciones.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLNominaciones.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLNominaciones.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLNominaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLNominacionesMouseClicked(evt);
            }
        });
        jPNominaciones.add(jLNominaciones);

        jPanel1.add(jPNominaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 340, 30));

        jPPlataformas.setBackground(new java.awt.Color(51, 51, 51));
        jPPlataformas.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPPlataformas.setLayout(new javax.swing.BoxLayout(jPPlataformas, javax.swing.BoxLayout.Y_AXIS));

        jLPlataformas.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLPlataformas.setForeground(java.awt.Color.lightGray);
        jLPlataformas.setText("Seleccione las plataformas...");
        jLPlataformas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLPlataformas.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLPlataformas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLPlataformasMouseClicked(evt);
            }
        });
        jPPlataformas.add(jLPlataformas);

        jPanel1.add(jPPlataformas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 340, 30));

        jPPremios.setBackground(new java.awt.Color(51, 51, 51));
        jPPremios.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPPremios.setLayout(new javax.swing.BoxLayout(jPPremios, javax.swing.BoxLayout.Y_AXIS));

        jLPremios.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLPremios.setForeground(java.awt.Color.lightGray);
        jLPremios.setText("Seleccione los premios...");
        jLPremios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLPremiosMouseClicked(evt);
            }
        });
        jPPremios.add(jLPremios);

        jPanel1.add(jPPremios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 340, 30));

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
     String fecha = jTFecha.getText();
     System.out.print("RECIBIDO " + fecha);
       if (!validarFecha(fecha)) {
        JOptionPane.showMessageDialog(this, "INGRESE UNA FECHA VALIDA",
                "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        return; 
    } 
        
    String titulo = jTtitulo.getText();
    String generos = guardarGeneros();
    String plataformas = guardarPlataformas();
    String desarrolladores = jTDesarrolladores.getText();
    String nominaciones = guardarNominaciones();
    String premios = guardarPremios();
    String diseñadores = jTDiseñadores.getText();
   
    String descripcion = jTDescripcion.getText();

    if (titulo.isEmpty() ||  plataformas.isEmpty() || 
        desarrolladores.isEmpty() || nominaciones.isEmpty() || premios.isEmpty() ||
        diseñadores.isEmpty() || fecha.isEmpty() || descripcion.isEmpty() ) {
        
        JOptionPane.showMessageDialog(this, "TODOS LOS CAMPOS SON OBLIGATORIOS",
                "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
    } else {
    

        System.out.print("\nDESDE AGREGAR: " + rutaImagen);
    
        JUEGO.crearArchivojuego(titulo, generos, plataformas, desarrolladores, nominaciones, premios, diseñadores, fecha, descripcion, rutaImagen);

        JOptionPane.showMessageDialog(this, "Videojuego agregado correctamente",
            "Información", JOptionPane.INFORMATION_MESSAGE);

        
    // Limpiar los campos del formulario
    limpiarCampos();
    }
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        PerfilAdmin abrir = new PerfilAdmin();
        if(this.getExtendedState() == GameAgregar.MAXIMIZED_BOTH){
            abrir.setExtendedState(GameAgregar.MAXIMIZED_BOTH);
        }
        
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void jBImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImagenActionPerformed
        
        JFileChooser jFileChooser = new JFileChooser();
        //FILTRAR TIPO
        FileNameExtensionFilter filtar = new FileNameExtensionFilter("PNG", "png");
        jFileChooser.setMultiSelectionEnabled(false); //No permite selecionar varias imagenes
        jFileChooser.setFileFilter(filtar);
        
        int respuesta = jFileChooser.showOpenDialog(this);
        
        if (respuesta == JFileChooser.APPROVE_OPTION){
            File rutaImagen = jFileChooser.getSelectedFile();
            
            System.out.print(rutaImagen);
            
           // Define la carpeta donde se guardarán las imágenes dentro del proyecto
    String tituloJ = jTtitulo.getText();  
    File destino = new File("resourcer/portadas/" + tituloJ + ".png");
this.imagenSeleccionada = rutaImagen;
    try {
        BufferedImage imagen = ImageIO.read(rutaImagen);
        ImageIO.write(imagen, "png", destino);  // Guarda la imagen en el proyecto
        System.out.println("Imagen guardada en: " + destino.getPath());
    } catch (IOException e) {
        e.printStackTrace();
    }
        } 
        
    }//GEN-LAST:event_jBImagenActionPerformed

    private void jLGenerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLGenerosMouseClicked
        menuGenero();
    }//GEN-LAST:event_jLGenerosMouseClicked

    private void jLPlataformasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLPlataformasMouseClicked
        menuPlataformas();
    }//GEN-LAST:event_jLPlataformasMouseClicked

    private void jLNominacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLNominacionesMouseClicked
        menuNominaciones();
    }//GEN-LAST:event_jLNominacionesMouseClicked

    private void jLPremiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLPremiosMouseClicked
        menuPremios();
    }//GEN-LAST:event_jLPremiosMouseClicked

    private void jTFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFechaFocusGained
       if (jTFecha.getText().equals("DD/MM/AA")) {
        jTFecha.setText("DD/MM/AA");
        jTFecha.setForeground(Color.WHITE); // cambia al color normal
}
    }//GEN-LAST:event_jTFechaFocusGained

    private void jTFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFechaFocusLost
        if (jTFecha.getText().isEmpty()) {
        jTFecha.setText("DD/MM/AA");
        jTFecha.setForeground(Color.GRAY); // vuelve a gris si está vacío
        }
    }//GEN-LAST:event_jTFechaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBImagen;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JLabel jLGeneros;
    private javax.swing.JLabel jLNominaciones;
    private javax.swing.JLabel jLPlataformas;
    private javax.swing.JLabel jLPremios;
    private javax.swing.JLabel jLRuta;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPGeneros;
    private javax.swing.JPanel jPNominaciones;
    private javax.swing.JPanel jPPlataformas;
    private javax.swing.JPanel jPPremios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDesarrolladores;
    private javax.swing.JTextArea jTDescripcion;
    private javax.swing.JTextField jTDiseñadores;
    private javax.swing.JTextField jTFecha;
    private javax.swing.JTextField jTtitulo;
    // End of variables declaration//GEN-END:variables
}
class FondoPanel5 extends JPanel
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
