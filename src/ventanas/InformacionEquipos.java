/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexiones;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.Administrador.sesion;
import static ventanas.InformacionCliente.ID;
import static ventanas.InformacionCliente.user;

/**
 *
 * @author MINEDUCYT
 */
public class InformacionEquipos extends javax.swing.JFrame {

    String user, nom, fecha;
    int id;

    /**
     * Creates new form InformacionEquipos
     */
    public InformacionEquipos() {
        initComponents();
        user = Login.user;
        nom = InformacionCliente.n;
        id = InformacionCliente.idu;

        setSize(670, 550);
        setResizable(false);
        setTitle("Información del Articulo - User: " + user);
        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon Wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(Wallpaper.getImage().getScaledInstance(LabelWallpaper.getWidth(),
                LabelWallpaper.getHeight(), Image.SCALE_DEFAULT));

        LabelWallpaper.setIcon(icono);
        this.repaint();

        TxtCliente.setText(nom);
        try {

            Connection cn = Conexiones.conexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select Tipo, Marca, Modelo, NumeroSerie, DiaIngreso, "
                    + "MesIngreso, AñoIngreso, Observaciones, Estatus, modificacion, Comentarios "
                    + "from equipo where ID = '" + id + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                fecha = rs.getString("DiaIngreso") + " de " + rs.getString("MesIngreso") + " del " + rs.getString("AñoIngreso");

                TxtModelo.setText(rs.getString("Modelo"));
                TxtNumSerie.setText(rs.getString("NumeroSerie"));
                TxtModificado.setText(rs.getString("modificacion"));
                AreaObservacion.setText(rs.getString("Observaciones"));
                AreaComentarios.setText(rs.getString("Comentarios"));
                CmbEstado.setSelectedItem(rs.getString("Estatus"));
                CmbMarca.setSelectedItem(rs.getString("Marca"));
                CmbTipo.setSelectedItem(rs.getString("Tipo"));
                TxtFecha.setText(fecha);

            }
        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error en el llenado de datos, contacte a un administrador");
        }
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

        TxtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CmbTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        CmbMarca = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TxtModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtNumSerie = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaObservacion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaComentarios = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        TxtModificado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CmbEstado = new javax.swing.JComboBox<>();
        Ingresar = new javax.swing.JButton();
        TxtFecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        LabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtCliente.setBackground(new java.awt.Color(153, 153, 255));
        TxtCliente.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtCliente.setForeground(new java.awt.Color(255, 255, 255));
        TxtCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtCliente.setEnabled(false);
        getContentPane().add(TxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de Equipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        CmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multi funcional" }));
        getContentPane().add(CmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        CmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alienware", "Apple", "Asus", "Brother", "Dell", "Hp", "Lenovo" }));
        getContentPane().add(CmbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        TxtModelo.setBackground(new java.awt.Color(153, 153, 255));
        TxtModelo.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtModelo.setForeground(new java.awt.Color(255, 255, 255));
        TxtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtModelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Numero de serie:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        TxtNumSerie.setBackground(new java.awt.Color(153, 153, 255));
        TxtNumSerie.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtNumSerie.setForeground(new java.awt.Color(255, 255, 255));
        TxtNumSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNumSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtNumSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 210, -1));

        AreaObservacion.setColumns(20);
        AreaObservacion.setRows(5);
        jScrollPane1.setViewportView(AreaObservacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 330, 150));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Daño reportado y Observaciones");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        LabelNombre.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        LabelNombre.setText("Informacion del Equipo");
        LabelNombre.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        AreaComentarios.setColumns(20);
        AreaComentarios.setRows(5);
        AreaComentarios.setEnabled(false);
        jScrollPane2.setViewportView(AreaComentarios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 330, 150));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Comentarios:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        TxtModificado.setBackground(new java.awt.Color(153, 153, 255));
        TxtModificado.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtModificado.setForeground(new java.awt.Color(255, 255, 255));
        TxtModificado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtModificado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtModificado.setEnabled(false);
        getContentPane().add(TxtModificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 210, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ultima Modificación:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Estado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        CmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo Ingreso", "No Reparado", "En Revision", "Reparado", "Entregado" }));
        getContentPane().add(CmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 210, -1));

        Ingresar.setBackground(new java.awt.Color(153, 153, 240));
        Ingresar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        Ingresar.setText("Actualizar equipo");
        Ingresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });
        getContentPane().add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 210, 35));

        TxtFecha.setBackground(new java.awt.Color(153, 153, 255));
        TxtFecha.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtFecha.setForeground(new java.awt.Color(255, 255, 255));
        TxtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtFecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtFecha.setEnabled(false);
        getContentPane().add(TxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 210, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ultima Modificación:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed
        String Modelo, Numero, Ultimo, Observacion, stipo = "", smarca = "", sstado = "";
        int tipo = 0, marca = 0, stado = 0;

        Modelo = TxtModelo.getText().trim();
        Numero = TxtNumSerie.getText().trim();
        Ultimo = user;
        Observacion = AreaObservacion.getText().trim();
        marca = CmbMarca.getSelectedIndex();
        tipo = CmbTipo.getSelectedIndex();
        stado = CmbEstado.getSelectedIndex();

        if (tipo == 0) {
            stipo = "Laptop";
        } else if (tipo == 1) {
            stipo = "Desktop";
        } else if (tipo == 2) {
            stipo = "Impresora";
        } else if (tipo == 3) {
            stipo = "Multi funcion";
        }

        if (stado == 0) {
            sstado = "Nuevo Ingreso";
        } else if (stado == 1) {
            sstado = "No Reparado";
        } else if (stado == 2) {
            sstado = "En Revision";
        } else if (stado == 3) {
            sstado = "Reparado";
        } else if (stado == 4) {
            sstado = "Entregado";
        }

        if (marca == 0) {
            smarca = "Acer";
        } else if (marca == 1) {
            smarca = "Alienware";
        } else if (marca == 2) {
            smarca = "Apple";
        } else if (marca == 3) {
            smarca = "Asus";
        } else if (marca == 4) {
            smarca = "Brother";
        } else if (marca == 5) {
            smarca = "Dell";
        } else if (marca == 6) {
            smarca = "Hp";
        } else if (marca == 7) {
            smarca = "Lenovo";
        }

        try {
            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "update equipo set Tipo=?, Marca=?, Modelo=?, NumeroSerie=?, Observaciones=?, Estatus=?, modificacion=?"
                    + "where ID = '" + ID + "'");

            pst1.setString(1, stipo);
            pst1.setString(2, smarca);
            pst1.setString(3, Modelo);
            pst1.setString(4, Numero);
            pst1.setString(5, Observacion);
            pst1.setString(6, sstado);
            pst1.setString(7, Ultimo);

            pst1.executeUpdate();
            cn1.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error, contacte a un administrador");
        }
        JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
        this.dispose();
    }//GEN-LAST:event_IngresarActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaComentarios;
    private javax.swing.JTextArea AreaObservacion;
    private javax.swing.JComboBox<String> CmbEstado;
    private javax.swing.JComboBox<String> CmbMarca;
    private javax.swing.JComboBox<String> CmbTipo;
    private javax.swing.JButton Ingresar;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JTextField TxtCliente;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtModelo;
    private javax.swing.JTextField TxtModificado;
    private javax.swing.JTextField TxtNumSerie;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}