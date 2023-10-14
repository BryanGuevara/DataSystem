/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//𝑷𝒓𝒐𝒈𝒓𝒂𝒎𝒂 𝒉𝒆𝒄𝒉𝒐 𝒑𝒐𝒓 𝑩.𝑨.𝑮.𝑮 ©
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexiones;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author MINEDUCYT
 */
public class Login extends javax.swing.JFrame {

    public static String user = "";
    String pass = "";

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setTitle("Ventana de acceso");
        this.setLocationRelativeTo(null);

        ImageIcon Wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(Wallpaper.getImage().getScaledInstance(LabelWallpaper.getWidth(),
                LabelWallpaper.getHeight(), Image.SCALE_DEFAULT));

        LabelWallpaper.setIcon(icono);
        this.repaint();

        ImageIcon foto = new ImageIcon("src/images/DS.png");
        Icon icon = new ImageIcon(foto.getImage().getScaledInstance(LabelIcono.getWidth(),
                LabelIcono.getHeight(), Image.SCALE_DEFAULT));

        LabelIcono.setIcon(icon);
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(
                "images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Creador = new javax.swing.JLabel();
        TxtUser = new javax.swing.JTextField();
        TxtPassword = new javax.swing.JPasswordField();
        Ingresar = new javax.swing.JButton();
        LabelIcono = new javax.swing.JLabel();
        LabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Creador.setText("𝑷𝒓𝒐𝒈𝒓𝒂𝒎𝒂 𝒉𝒆𝒄𝒉𝒐 𝒑𝒐𝒓 𝑩.𝑨.𝑮.𝑮 ©");
        getContentPane().add(Creador, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, -1, -1));

        TxtUser.setBackground(new java.awt.Color(155, 155, 255));
        TxtUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TxtUser.setForeground(new java.awt.Color(255, 255, 255));
        TxtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUserActionPerformed(evt);
            }
        });
        getContentPane().add(TxtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        TxtPassword.setBackground(new java.awt.Color(153, 153, 255));
        TxtPassword.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        TxtPassword.setForeground(new java.awt.Color(255, 255, 255));
        TxtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 390, 210, 30));

        Ingresar.setBackground(new java.awt.Color(153, 153, 240));
        Ingresar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        Ingresar.setText("Ingresar");
        Ingresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });
        getContentPane().add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 440, 210, 35));
        getContentPane().add(LabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 270, 270));
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed

        user = TxtUser.getText().trim();
        pass = TxtPassword.getText().trim();

        if (!user.equals("") && !pass.equals("")) {

            try {

                Connection cn = Conexiones.conexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select Nivel, Estatus from usuarios where Username = '" + user
                        + "' and Password = '" + pass + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    String nivel = rs.getString("Nivel");
                    String estatus = rs.getString("Estatus");

                    if (nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Administrador().setVisible(true);
                    } else if (nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Capturista().setVisible(true);
                    } else if (nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Tecnico().setVisible(true);
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos ¯_(ツ)_/¯");
                    TxtUser.setText("");
                    TxtPassword.setText("");

                }

            } catch (HeadlessException | SQLException e) {
                System.err.println("Error!! " + e);
                JOptionPane.showMessageDialog(null,
                        "Error al iniciar secion, porfavor contacte al Administrador");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Porfavor llene todos los campos");

        }

    }//GEN-LAST:event_IngresarActionPerformed

    private void TxtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUserActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Creador;
    private javax.swing.JButton Ingresar;
    private javax.swing.JLabel LabelIcono;
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtUser;
    // End of variables declaration//GEN-END:variables
}
