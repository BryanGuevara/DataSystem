/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexiones;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.Login.user;

/**
 *
 * @author MINEDUCYT
 */
public class RegistrarUsuario extends javax.swing.JFrame {

    String user;

    /**
     * Creates new form RegistrarUsuario
     */
    public RegistrarUsuario() {
        initComponents();

        user = Login.user;

        setSize(630, 350);
        setResizable(false);
        setTitle("Registrar Nuevo Usuario - User: " + user);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon Wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(Wallpaper.getImage().getScaledInstance(LabelWallpaper.getWidth(),
                LabelWallpaper.getHeight(), Image.SCALE_DEFAULT));

        LabelWallpaper.setIcon(icono);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtMail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtPassword = new javax.swing.JPasswordField();
        CmbNivel = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        LabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        TxtNombre.setBackground(new java.awt.Color(153, 153, 255));
        TxtNombre.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtNombre.setForeground(new java.awt.Color(255, 255, 255));
        TxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        TxtMail.setBackground(new java.awt.Color(153, 153, 255));
        TxtMail.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtMail.setForeground(new java.awt.Color(255, 255, 255));
        TxtMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("em@il: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        TxtTelefono.setBackground(new java.awt.Color(153, 153, 255));
        TxtTelefono.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        TxtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Télefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        TxtUser.setBackground(new java.awt.Color(153, 153, 255));
        TxtUser.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtUser.setForeground(new java.awt.Color(255, 255, 255));
        TxtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Permisos de:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        TxtPassword.setBackground(new java.awt.Color(153, 153, 255));
        TxtPassword.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtPassword.setForeground(new java.awt.Color(255, 255, 255));
        TxtPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 210, -1));

        CmbNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        getContentPane().add(CmbNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 120, 100));
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int IPermisos, Validacion = 0;
        String Nombre, Mail, User, Pass, Telefono, SPermisos = "";

        Nombre = TxtNombre.getText().trim();
        Mail = TxtMail.getText().trim();
        User = TxtUser.getText().trim();
        Pass = TxtPassword.getText().trim();
        Telefono = TxtTelefono.getText().trim();
        IPermisos = CmbNivel.getSelectedIndex() + 1;

        if (Nombre.equals("")) {
            TxtNombre.setBackground(Color.red);
            Validacion++;
        } else {
            TxtNombre.setBackground(Color.BLUE);
        }
        if (Mail.equals("")) {
            TxtMail.setBackground(Color.red);
            Validacion++;
        } else {
            TxtMail.setBackground(Color.BLUE);
        }
        if (User.equals("")) {
            TxtUser.setBackground(Color.red);
            Validacion++;
        } else {
            TxtUser.setBackground(Color.BLUE);
        }
        if (Pass.equals("")) {
            TxtPassword.setBackground(Color.red);
            Validacion++;
        } else {
            TxtPassword.setBackground(Color.BLUE);
        }
        if (Telefono.equals("")) {
            TxtTelefono.setBackground(Color.red);
            Validacion++;
        } else {
            TxtTelefono.setBackground(Color.BLUE);
        }
        if (IPermisos == 1) {
            SPermisos = "Administrador";
        } else if (IPermisos == 2) {
            SPermisos = "Capturista";
        } else if (IPermisos == 3) {
            SPermisos = "Tecnico";
        }

        try {
            Connection cn = Conexiones.conexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select Username from usuarios where Username = '" + User + "'");

            ResultSet rs = pst.executeQuery();

           
            if (rs.next()) {
                TxtUser.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de Usuario no esta disponible");
                cn.close();
            } else {

                cn.close();

                if (Validacion == 0) {

                    try {
                        Connection cn2 = Conexiones.conexion();

                        PreparedStatement pst2 = cn2.prepareStatement(
                                "insert into usuarios values(?,?,?,?,?,?,?,?,?)");

                        pst2.setString(1, "0");
                        pst2.setString(2, Nombre);
                        pst2.setString(3, Mail);
                        pst2.setString(4, Telefono);
                        pst2.setString(5, User);
                        pst2.setString(6, Pass);
                        pst2.setString(7, SPermisos);
                        pst2.setString(8, "Activo");
                        pst2.setString(9, user);

                        pst2.executeUpdate();
                        cn2.close();
                        
                        Limpiar();
                        
                        TxtMail.setBackground(Color.GREEN);
                        TxtNombre.setBackground(Color.GREEN);
                        TxtPassword.setBackground(Color.GREEN);
                        TxtTelefono.setBackground(Color.GREEN);
                        TxtUser.setBackground(Color.GREEN);

                        JOptionPane.showMessageDialog(null, "Registro Exitoso");
                        this.dispose();

                    } catch (Exception e) {
                        System.err.println(e);
                        JOptionPane.showMessageDialog(null, "Error!! Contacte a un Administrador");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Porfavor Llene todos los campos");
                }

            }

        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error!! Contacte a un Administrador");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbNivel;
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JTextField TxtMail;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        TxtMail.setText("");
        TxtNombre.setText("");
        TxtPassword.setText("");
        TxtTelefono.setText("");
        TxtUser.setText("");
        CmbNivel.setSelectedIndex(0);
    }

}