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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GameActualizar extends javax.swing.JFrame {
    
    private BibliotecaGeneral biblioteca;
    private final InfoVideoJuegos JUEGO = new InfoVideoJuegos();
    private final UsuarioController USUARIO = new UsuarioController();
    private FondoPanel8 fondo = new FondoPanel8();
    private String rutaImagen = "";
    private JPanel fondoG = new JPanel();
    private JPanel fondoN = new JPanel();
    private JPanel fondoP = new JPanel();
    private JPanel fondoPr = new JPanel();
    private String tituloOriginal; 
    private File imagenSeleccionada;
    private String nuevoTitulo;
    
    public GameActualizar() {
        setMinimumSize(new Dimension(1000, 600)); // Ajusta el tamaño según tu imagen de fondo
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    
    public void setBiblioteca(BibliotecaGeneral biblioteca){
        this.biblioteca = biblioteca;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }
    
    
    private void limpiarCampos() {
    jTActualizarT.setText("");
    jTActualizarDev.setText("");
    jTActualizarDis.setText("");
    jTActualizarFec.setText("");
    jTActualizarDes.setText("");
    jLRuta.setText("Sin seleccioar");
    jBActualizarPor.setText("Seleccionar Imagen");
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

private void restaurarSeleccion(JPanel panel, List<String> valores) {
    for (Component comp : panel.getComponents()) {
        if (comp instanceof JCheckBox check) {
            check.setSelected(valores.contains(check.getText()));
        }
    }
}
    //METODOS PARA LOS MENUS DESPLEGABLES
    
    private void menuGenero(){
        
 
        fondoG = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        
        fondoG.setSize(jPActualizarGen.getWidth(), 100);
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
        jScrollPane.setPreferredSize(new Dimension(jPActualizarGen.getWidth(), 100));
        
       
        

        java.awt.Point p = SwingUtilities.convertPoint(jPActualizarGen.getParent(), jPActualizarGen.getLocation(), getLayeredPane());
        jScrollPane.setBounds(p.x, 100, jPActualizarGen.getWidth(), 100);
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
    
    private List<String> guardarGeneros() {
    List<String> generosSeleccionados = new ArrayList<>();
    
    for (Component comp : fondoG.getComponents()) {
        if (comp instanceof JCheckBox check && check.isSelected()) {
            generosSeleccionados.add(check.getText());
        }
    }

    return generosSeleccionados;
}
    
    private void menuNominaciones(){
        //Crear menú desplegable con multiples opciones 
        fondoN = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        
        fondoN.setSize(jPActualizarNom.getWidth(), 200);
        fondoN.setLayout(new BoxLayout(fondoN, BoxLayout.Y_AXIS));
        
        fondoN.add(new JCheckBox("Juego del año"));
        fondoN.add(new JCheckBox("Mejor dirección"));
        fondoN.add(new JCheckBox("Mejor de arte"));
        fondoN.add(new JCheckBox("Mejor narrativa"));
        fondoN.add(new JCheckBox("Mejor juego de impacto"));
        
        jScrollPane.setViewportView(fondoN);
        jScrollPane.setPreferredSize(new Dimension(jPActualizarNom.getWidth(), 80));
        
       
        

        java.awt.Point p = SwingUtilities.convertPoint(jPActualizarNom.getParent(), jPActualizarNom.getLocation(), getLayeredPane());
        jScrollPane.setBounds(p.x, p.y, jPActualizarNom.getWidth(), 80);
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
    
    private List<String> guardarNominaciones(){
        List<String> generosSeleccionados = new ArrayList<>();
    
    for (Component comp : fondoN.getComponents()) {
        if (comp instanceof JCheckBox check && check.isSelected()) {
            generosSeleccionados.add(check.getText());
        }
    }

    return generosSeleccionados;
    }
    
    private void menuPlataformas(){
        fondoP = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        
        fondoP.setSize(jPActualizarPlat.getWidth(), 200);
        fondoP.setLayout(new BoxLayout(fondoP, BoxLayout.Y_AXIS));
        
        fondoP.add(new JCheckBox("PlayStation 4"));
        fondoP.add(new JCheckBox("PlayStation 5"));
        fondoP.add(new JCheckBox("XBOX Series X/S"));
        fondoP.add(new JCheckBox("XBOX One"));
        fondoP.add(new JCheckBox("XBOX 360"));
        fondoP.add(new JCheckBox("PC"));
        
       jScrollPane.setViewportView(fondoP);
        jScrollPane.setPreferredSize(new Dimension(jPActualizarPlat.getWidth(), 80));
        

        java.awt.Point p = SwingUtilities.convertPoint(jPActualizarPlat.getParent(), jPActualizarPlat.getLocation(), getLayeredPane());
        jScrollPane.setBounds(p.x, p.y, jPActualizarPlat.getWidth(), 80);
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
    
    private List<String> guardarPlataformas(){
        List<String> generosSeleccionados = new ArrayList<>();
    
    for (Component comp : fondoP.getComponents()) {
        if (comp instanceof JCheckBox check && check.isSelected()) {
            generosSeleccionados.add(check.getText());
        }
    }

    return generosSeleccionados;
    
    }
    
    private void menuPremios(){
        fondoPr = new JPanel();
        JScrollPane jScrollPane = new JScrollPane();
        
        
        fondoPr.setSize(jPActualizarPre.getWidth(), 200);
        fondoPr.setLayout(new BoxLayout(fondoPr, BoxLayout.Y_AXIS));
        
        fondoPr.add(new JCheckBox("Ganador de juego del año"));
        fondoPr.add(new JCheckBox("Ganador de mejor dirección"));
        fondoPr.add(new JCheckBox("Ganador de mejor de arte"));
        fondoPr.add(new JCheckBox("Ganador de mejor narrativa"));
        fondoPr.add(new JCheckBox("Ganador de mejor juego de impacto"));
        
        jScrollPane.setViewportView(fondoPr);
        jScrollPane.setPreferredSize(new Dimension(jPActualizarPre.getWidth(), 80));
        
       
        
        java.awt.Point p = SwingUtilities.convertPoint(jPActualizarPre.getParent(), jPActualizarPre.getLocation(), getLayeredPane());
        jScrollPane.setBounds(p.x, p.y, jPActualizarPre.getWidth(), 80);
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
    
    private List<String> guardarPremios(){
        List<String> generosSeleccionados = new ArrayList<>();
    
    for (Component comp : fondoPr.getComponents()) {
        if (comp instanceof JCheckBox check && check.isSelected()) {
            generosSeleccionados.add(check.getText());
        }
    }

    return generosSeleccionados;
    }
    
    //METODOS PARA LA FECHA Y SU VERIFICACION
    
    public boolean validarFecha(String fecha){
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
        System.out.print("ERROR 1 - Formato incorrecto.");
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


    public void pasarDatos(Map<String, Object> datosJuego, String titulo) {
    
        jTActualizarT.setText((String) datosJuego.get("TITULO"));
    jTActualizarDev.setText((String) datosJuego.get("DESARROLLADOR"));
    jTActualizarDis.setText((String) datosJuego.get("DISEÑADORES"));
    jTActualizarDes.setText((String) datosJuego.get("DESCRIPCION"));
    jTActualizarFec.setText((String) datosJuego.get("FECHA"));
    
    menuGenero(); 
    menuNominaciones();
    menuPlataformas();
    menuPremios();
    
    // Recuperar premios, géneros, plataformas y nominaciones

    restaurarSeleccion(fondoPr, (List<String>) datosJuego.get("PREMIOS"));
    restaurarSeleccion(fondoG, (List<String>) datosJuego.get("GENEROS"));
    restaurarSeleccion(fondoP, (List<String>) datosJuego.get("PLATAFORMAS"));
    restaurarSeleccion(fondoN, (List<String>) datosJuego.get("NOMINACIONES"));

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
        jTActualizarT = new javax.swing.JTextField();
        jTActualizarDev = new javax.swing.JTextField();
        jTActualizarDis = new javax.swing.JTextField();
        jTActualizarFec = new javax.swing.JTextField();
        jBActualizar = new javax.swing.JButton();
        jBActualizarPor = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTActualizarDes = new javax.swing.JTextArea();
        jBRegresar = new javax.swing.JButton();
        jPActualizarGen = new javax.swing.JPanel();
        jLGeneros = new javax.swing.JLabel();
        jPActualizarNom = new javax.swing.JPanel();
        jLNominaciones = new javax.swing.JLabel();
        jPActualizarPlat = new javax.swing.JPanel();
        jLPlataformas = new javax.swing.JLabel();
        jPActualizarPre = new javax.swing.JPanel();
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

        jTActualizarT.setBackground(new java.awt.Color(51, 51, 51));
        jTActualizarT.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        jTActualizarT.setForeground(java.awt.Color.white);
        jTActualizarT.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTActualizarT.setCaretColor(new java.awt.Color(255, 255, 255));
        jTActualizarT.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTActualizarT.setSelectionColor(new java.awt.Color(153, 0, 255));
        jPanel1.add(jTActualizarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 340, 30));

        jTActualizarDev.setBackground(new java.awt.Color(51, 51, 51));
        jTActualizarDev.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        jTActualizarDev.setForeground(java.awt.Color.white);
        jTActualizarDev.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTActualizarDev.setCaretColor(new java.awt.Color(255, 255, 255));
        jTActualizarDev.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTActualizarDev.setSelectionColor(new java.awt.Color(153, 0, 255));
        jPanel1.add(jTActualizarDev, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 340, 30));

        jTActualizarDis.setBackground(new java.awt.Color(51, 51, 51));
        jTActualizarDis.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        jTActualizarDis.setForeground(java.awt.Color.white);
        jTActualizarDis.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTActualizarDis.setCaretColor(new java.awt.Color(255, 255, 255));
        jTActualizarDis.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTActualizarDis.setSelectionColor(new java.awt.Color(153, 0, 255));
        jPanel1.add(jTActualizarDis, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 340, 30));

        jTActualizarFec.setBackground(new java.awt.Color(51, 51, 51));
        jTActualizarFec.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        jTActualizarFec.setForeground(java.awt.Color.white);
        jTActualizarFec.setText("DD/MM/AA");
        jTActualizarFec.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTActualizarFec.setCaretColor(new java.awt.Color(255, 255, 255));
        jTActualizarFec.setDisabledTextColor(new java.awt.Color(70, 73, 75));
        jTActualizarFec.setSelectionColor(new java.awt.Color(153, 0, 255));
        jTActualizarFec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTActualizarFecFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTActualizarFecFocusLost(evt);
            }
        });
        jPanel1.add(jTActualizarFec, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 340, 30));

        jBActualizar.setBackground(new java.awt.Color(103, 22, 199));
        jBActualizar.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBActualizar.setForeground(java.awt.Color.white);
        jBActualizar.setText("Actualizar");
        jBActualizar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jBActualizar.setFocusable(false);
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jBActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 330, 40));

        jBActualizarPor.setBackground(new java.awt.Color(103, 22, 199));
        jBActualizarPor.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jBActualizarPor.setForeground(java.awt.Color.white);
        jBActualizarPor.setText("Seleccionar imagen");
        jBActualizarPor.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jBActualizarPor.setFocusable(false);
        jBActualizarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarPorActionPerformed(evt);
            }
        });
        jPanel1.add(jBActualizarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 150, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Descripción");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("Portada");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, 40));

        jTActualizarDes.setBackground(new java.awt.Color(51, 51, 51));
        jTActualizarDes.setColumns(20);
        jTActualizarDes.setFont(new java.awt.Font("Yu Gothic Light", 0, 14)); // NOI18N
        jTActualizarDes.setForeground(java.awt.Color.white);
        jTActualizarDes.setLineWrap(true);
        jTActualizarDes.setRows(5);
        jTActualizarDes.setWrapStyleWord(true);
        jTActualizarDes.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jTActualizarDes.setSelectionColor(new java.awt.Color(153, 0, 255));
        jScrollPane1.setViewportView(jTActualizarDes);

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

        jPActualizarGen.setBackground(new java.awt.Color(51, 51, 51));
        jPActualizarGen.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPActualizarGen.setLayout(new javax.swing.BoxLayout(jPActualizarGen, javax.swing.BoxLayout.Y_AXIS));

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
        jPActualizarGen.add(jLGeneros);

        jPanel1.add(jPActualizarGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 340, 30));

        jPActualizarNom.setBackground(new java.awt.Color(51, 51, 51));
        jPActualizarNom.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPActualizarNom.setLayout(new javax.swing.BoxLayout(jPActualizarNom, javax.swing.BoxLayout.Y_AXIS));

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
        jPActualizarNom.add(jLNominaciones);

        jPanel1.add(jPActualizarNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 340, 30));

        jPActualizarPlat.setBackground(new java.awt.Color(51, 51, 51));
        jPActualizarPlat.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPActualizarPlat.setLayout(new javax.swing.BoxLayout(jPActualizarPlat, javax.swing.BoxLayout.Y_AXIS));

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
        jPActualizarPlat.add(jLPlataformas);

        jPanel1.add(jPActualizarPlat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 340, 30));

        jPActualizarPre.setBackground(new java.awt.Color(51, 51, 51));
        jPActualizarPre.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true), new javax.swing.border.LineBorder(new java.awt.Color(108, 56, 169), 1, true)));
        jPActualizarPre.setLayout(new javax.swing.BoxLayout(jPActualizarPre, javax.swing.BoxLayout.Y_AXIS));

        jLPremios.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLPremios.setForeground(java.awt.Color.lightGray);
        jLPremios.setText("Seleccione los premios...");
        jLPremios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLPremiosMouseClicked(evt);
            }
        });
        jPActualizarPre.add(jLPremios);

        jPanel1.add(jPActualizarPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 340, 30));

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
      String fecha = jTActualizarFec.getText();
    System.out.println("RECIBIDO " + fecha);
    
    if (!validarFecha(fecha)) {
        JOptionPane.showMessageDialog(this, "INGRESE UNA FECHA VALIDA",
                "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        return; 
    } 
        
    String nuevoTitulo = jTActualizarT.getText();
    guardarGeneros();
    guardarPlataformas();
    String desarrolladores = jTActualizarDev.getText();
    guardarNominaciones();
    guardarPremios();
    String diseñadores = jTActualizarDis.getText();
    String descripcion = jTActualizarDes.getText();
    
    // Verificar que todos los campos esten llens
    if (nuevoTitulo.isEmpty() || guardarGeneros().isEmpty() || guardarPlataformas().isEmpty() || 
        desarrolladores.isEmpty() || guardarNominaciones().isEmpty() || guardarPremios().isEmpty() ||
        diseñadores.isEmpty() || fecha.isEmpty() || descripcion.isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "TODOS LOS CAMPOS SON OBLIGATORIOS",
                "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Verificar que tengamos un titulo original vlido
    if (tituloOriginal == null || tituloOriginal.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: No se ha especificado el título original del juego",
                "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Actualizar el juego con los datos modificados
    String resultado = JUEGO.actualizarDatosJuego(
               tituloOriginal,
               nuevoTitulo, 
               guardarGeneros(), 
               guardarPlataformas(), 
               desarrolladores, 
               guardarNominaciones(), 
               guardarPremios(), 
               diseñadores, 
               fecha, 
               descripcion);
    
    JOptionPane.showMessageDialog(this, resultado, "Información", JOptionPane.INFORMATION_MESSAGE);
    
    // Si la actualización fue exitosa, limpiar los campos y volver a la pantalla anterior
    if (resultado.startsWith("Juego actualizado correctamente")) {
        limpiarCampos();
        
        // Volver a la pantalla de administrador
        PerfilAdmin admin = new PerfilAdmin();
        if (this.getExtendedState() == GameActualizar.MAXIMIZED_BOTH) {
            admin.setExtendedState(GameActualizar.MAXIMIZED_BOTH);
        }
        admin.setVisible(true);
        this.dispose();
    }
    
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        PerfilAdmin abrir = new PerfilAdmin();
        if(this.getExtendedState() == GameActualizar.MAXIMIZED_BOTH){
            abrir.setExtendedState(GameActualizar.MAXIMIZED_BOTH);
        }
        
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBRegresarActionPerformed

    private void jBActualizarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarPorActionPerformed
         // Primero mostrar el JFileChooser para seleccionar una imagen
    JFileChooser jFileChooser = new JFileChooser();
    // FILTRAR TIPO
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("PNG", "png");
    jFileChooser.setMultiSelectionEnabled(false); // No permite seleccionar varias imágenes
    jFileChooser.setFileFilter(filtro);
    
    int respuesta = jFileChooser.showOpenDialog(this);
    
    // no hacer nad si se cancela la opcion
    if (respuesta != JFileChooser.APPROVE_OPTION) {
        return;
    }
    
    // Obtener la imagen seleccionada
    File imagenSeleccionada = jFileChooser.getSelectedFile();
    System.out.println("Imagen seleccionada: " + imagenSeleccionada);
    
   
    String tituloOriginal = this.tituloOriginal;  
    String nuevoTitulo = jTActualizarT.getText(); 
    
    if (tituloOriginal == null || tituloOriginal.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: No se ha especificado el título original del juego",
                "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (nuevoTitulo == null || nuevoTitulo.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: El campo de título está vacío",
                "ERROR", JOptionPane.ERROR_MESSAGE);
        return;
    }
    

    try {
        String rutaPortadas = "resourcer/portadas/";
        
        // Crear la carpeta si no existe
        File carpetaPortadas = new File(rutaPortadas);
        if (!carpetaPortadas.exists()) {
            carpetaPortadas.mkdirs();
        }
        
 
        File imagenOriginal = new File(rutaPortadas + tituloOriginal + ".png");
        

        File imagenNueva = new File(rutaPortadas + nuevoTitulo + ".png");
        

        BufferedImage imagen = ImageIO.read(imagenSeleccionada);
        
        // Guardar la imagen con el nuevo nombre
        ImageIO.write(imagen, "png", imagenNueva);
        System.out.println("Imagen guardada en: " + imagenNueva.getPath());
        
 
        if (!tituloOriginal.equals(nuevoTitulo) && imagenOriginal.exists()) {
            boolean borradoExitoso = imagenOriginal.delete();
            if (!borradoExitoso) {
                System.out.println("Advertencia: No se pudo borrar la imagen original en " + imagenOriginal.getPath());
            } else {
                System.out.println("Imagen original borrada: " + imagenOriginal.getPath());
            }
        } else if (tituloOriginal.equals(nuevoTitulo) && !imagenNueva.equals(imagenOriginal)) {
            
            System.out.println("Imagen actualizada con el mismo nombre");
        }
        
        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(this, "La imagen ha sido actualizada correctamente",
                "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al guardar la imagen: " + e.getMessage(), 
                                     "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jBActualizarPorActionPerformed

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

    private void jTActualizarFecFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTActualizarFecFocusGained
       if (jTActualizarFec.getText().equals("DD/MM/AA")) {
        jTActualizarFec.setText("DD/MM/AA");
        jTActualizarFec.setForeground(Color.WHITE); // cambia al color normal
}
    }//GEN-LAST:event_jTActualizarFecFocusGained

    private void jTActualizarFecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTActualizarFecFocusLost
        if (jTActualizarFec.getText().isEmpty()) {
        jTActualizarFec.setText("DD/MM/AA");
        jTActualizarFec.setForeground(Color.GRAY); // vuelve a gris si está vacío
        }
    }//GEN-LAST:event_jTActualizarFecFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBActualizarPor;
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
    private javax.swing.JPanel jPActualizarGen;
    private javax.swing.JPanel jPActualizarNom;
    private javax.swing.JPanel jPActualizarPlat;
    private javax.swing.JPanel jPActualizarPre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTActualizarDes;
    private javax.swing.JTextField jTActualizarDev;
    private javax.swing.JTextField jTActualizarDis;
    private javax.swing.JTextField jTActualizarFec;
    private javax.swing.JTextField jTActualizarT;
    // End of variables declaration//GEN-END:variables


  
}
class FondoPanel8 extends JPanel
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
