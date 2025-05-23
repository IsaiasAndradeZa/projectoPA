/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author claudia
 */
public class Inicio extends javax.swing.JFrame {
    FondoPanel4 fondo = new FondoPanel4();
    
    public Inicio() {
        setMinimumSize(new Dimension(1000, 600)); // Ajusta el tamaño según tu imagen de fondo
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jBiniciosesion = new javax.swing.JButton();
        jBRegistro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jBiniciosesion.setBackground(new java.awt.Color(103, 22, 199));
        jBiniciosesion.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBiniciosesion.setForeground(java.awt.Color.white);
        jBiniciosesion.setText("Iniciar sesión");
        jBiniciosesion.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jBiniciosesion.setFocusable(false);
        jBiniciosesion.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jBiniciosesion.setPreferredSize(new java.awt.Dimension(145, 20));
        jBiniciosesion.setVerifyInputWhenFocusTarget(false);
        jBiniciosesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBiniciosesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 160;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(27, 30, 159, 0);
        getContentPane().add(jBiniciosesion, gridBagConstraints);

        jBRegistro.setBackground(java.awt.Color.darkGray);
        jBRegistro.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jBRegistro.setForeground(java.awt.Color.white);
        jBRegistro.setText("Registrate");
        jBRegistro.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jBRegistro.setFocusPainted(false);
        jBRegistro.setMaximumSize(new java.awt.Dimension(99, 27));
        jBRegistro.setMinimumSize(new java.awt.Dimension(99, 27));
        jBRegistro.setPreferredSize(new java.awt.Dimension(145, 20));
        jBRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 160;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 60, 159, 49);
        getContentPane().add(jBRegistro, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Repositorio/Logo2.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(70, 260, 20, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBiniciosesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBiniciosesionActionPerformed
        // TODO add your handling code here:
        InicioSesion abrir = new InicioSesion();
        if(this.getExtendedState() == Inicio.MAXIMIZED_BOTH){
            abrir.setExtendedState(Inicio.MAXIMIZED_BOTH);
        }
        
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBiniciosesionActionPerformed

    private void jBRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistroActionPerformed
        Registro abrir = new Registro();
        
        if(this.getExtendedState() == Inicio.MAXIMIZED_BOTH){
            abrir.setExtendedState(Inicio.MAXIMIZED_BOTH);
        }
        
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBRegistroActionPerformed
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRegistro;
    private javax.swing.JButton jBiniciosesion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
// CONSULTAR   
 class FondoPanel4 extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/Repositorio/FondoLogin.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
