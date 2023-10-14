/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexiones;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author MINEDUCYT
 */
public class GestionEquipos extends javax.swing.JFrame {

    String user;
    public static int ID = 0;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form GestionUsuarios
     */
    public GestionEquipos() {
        initComponents();

        user = Login.user;

        setSize(630, 350);
        setResizable(false);
        setTitle("Gestion de CLientes - User: " + user);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon Wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(Wallpaper.getImage().getScaledInstance(LabelWallpaper.getWidth(),
                LabelWallpaper.getHeight(), Image.SCALE_DEFAULT));

        LabelWallpaper.setIcon(icono);
        this.repaint();

        try {

            Connection cn = Conexiones.conexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select ID, Tipo, Marca, Estatus from equipo");

            ResultSet rs = pst.executeQuery();

            TableUsuarios = new JTable(model);
            jScrollPane1.setViewportView(TableUsuarios);

            model.addColumn("ID");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[5];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);

                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error en la geston de usuarios, contacte a un administrador");
        }
        TableUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Filap = TableUsuarios.rowAtPoint(e.getPoint());
                int Columna = 0;

                if (Filap > -1) {
                    ID = (int) model.getValueAt(Filap, Columna);
                    new InformacionDelEquipo().setVisible(true);
                }
            }
        });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuarios = new javax.swing.JTable();
        CmbEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Ingresar = new javax.swing.JButton();
        LabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableUsuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 630, 180));

        CmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo Ingreso", "No Reparado", "En Revision", "Reparado", "Entregado" }));
        getContentPane().add(CmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 150, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clientes Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        Ingresar.setBackground(new java.awt.Color(153, 153, 240));
        Ingresar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        Ingresar.setText("Actualizar");
        Ingresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });
        getContentPane().add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 210, 35));
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed
        String sstado = "";
        int stado = 0;
        
        stado = CmbEstado.getSelectedIndex();

        if (stado == 0) {
            sstado = "Todos";
        } else if (stado == 1) {
            sstado = "Nuevo Ingreso";
        } else if (stado == 2) {
            sstado = "No Reparado";
        } else if (stado == 3) {
            sstado = "En Revision";
        } else if (stado == 4) {
            sstado = "Reparado";
        } else if (stado == 5) {
            sstado = "Entregado";
        }
        if (stado == 0) {
            try {
                for (int i = 0; i < TableUsuarios.getRowCount(); i++) {
                    model.removeRow(i);
                    i--;
                }
                Connection cn = Conexiones.conexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select ID, Tipo, Marca, Estatus from equipo");

                ResultSet rs = pst.executeQuery();

                TableUsuarios = new JTable(model);
                jScrollPane1.setViewportView(TableUsuarios);

                while (rs.next()) {
                    Object[] fila = new Object[5];

                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);

                    }
                    model.addRow(fila);
                }
                cn.close();

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error en la geston de Equipos, contacte a un administrador");
            }
            TableUsuarios.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int Filap = TableUsuarios.rowAtPoint(e.getPoint());
                    int Columna = 0;

                    if (Filap > -1) {
                        ID = (int) model.getValueAt(Filap, Columna);
                        new InformacionDelEquipo().setVisible(true);
                    }
                }
            });
        } else {
            try {
                for (int i = 0; i < TableUsuarios.getRowCount(); i++) {
                    model.removeRow(i);
                    i--;
                }
                Connection cn = Conexiones.conexion();
                PreparedStatement pst = cn.prepareStatement(
                        "select ID, Tipo, Marca, Estatus from equipo where Estatus = '" + sstado + "'");

                ResultSet rs = pst.executeQuery();

                TableUsuarios = new JTable(model);
                jScrollPane1.setViewportView(TableUsuarios);

                while (rs.next()) {
                    Object[] fila = new Object[5];

                    for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);

                    }
                    model.addRow(fila);
                }
                cn.close();

            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error en la geston de Equipos, contacte a un administrador");
            }
            TableUsuarios.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int Filap = TableUsuarios.rowAtPoint(e.getPoint());
                    int Columna = 0;

                    if (Filap > -1) {
                        ID = (int) model.getValueAt(Filap, Columna);
                        new InformacionDelEquipo().setVisible(true);
                    }
                }
            });
        }
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
            java.util.logging.Logger.getLogger(GestionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbEstado;
    private javax.swing.JButton Ingresar;
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JTable TableUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
