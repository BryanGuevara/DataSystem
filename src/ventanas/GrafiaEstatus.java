/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexiones;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author MINEDUCYT
 */
public class GrafiaEstatus extends javax.swing.JFrame {

    String user;
    int NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado;
    String[] Estatus = new String[5];
    int[] Count = new int[5];

    /**
     * Creates new form GrafiaEstatus
     */
    public GrafiaEstatus() {
        initComponents();

        user = Login.user;

        setSize(552, 450);
        setResizable(false);
        setTitle("Grafica - User: " + user);
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
                    "select Estatus, count(estatus) as Cantidad from equipo group by Estatus");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    Estatus[posicion] = rs.getString(1);
                    Count[posicion] = rs.getInt(2);

                    if (Estatus[posicion].equals("En Revision")) {
                        EnRevision = Count[posicion];
                    } else if (Estatus[posicion].equals("Entregado")) {
                        Entregado = Count[posicion];
                    } else if (Estatus[posicion].equals("No Reparado")) {
                        NoReparado = Count[posicion];
                    } else if (Estatus[posicion].equals("Nuevo Ingreso")) {
                        NuevoIngreso = Count[posicion];
                    } else if (Estatus[posicion].equals("Reparado")) {
                        Reparado = Count[posicion];
                    }
                    posicion++;
                } while (rs.next());
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        repaint();
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
        LabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de Estatus");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GrafiaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrafiaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrafiaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrafiaEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrafiaEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
public int Mayor() {
        if (NuevoIngreso > NoReparado && NuevoIngreso > EnRevision && NuevoIngreso > Reparado && NuevoIngreso > Entregado) {

            return NuevoIngreso;

        } else if (NoReparado > EnRevision && NoReparado > Reparado && NoReparado > Entregado) {

            return NoReparado;

        } else if (EnRevision > Reparado && EnRevision > Entregado) {

            return EnRevision;

        } else if (Reparado > Entregado) {

            return Reparado;

        } else {

            return Entregado;

        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        int Mayor = Mayor();

        int largo1 = NuevoIngreso * 350 / Mayor;
        int largo2 = NoReparado * 350 / Mayor;
        int largo3 = EnRevision * 350 / Mayor;
        int largo4 = Reparado * 350 / Mayor;
        int largo5 = Entregado * 350 / Mayor;

        g.setColor(Color.RED);
        g.fillRect(100, 100, largo1, 40);
        g.drawString("Nuevo Ingreso", 10, 118);
        g.drawString("Cantidad: " + NuevoIngreso, 10, 133);

        g.setColor(Color.BLUE);
        g.fillRect(100, 150, largo2, 40);
        g.drawString("No Reparado", 10, 168);
        g.drawString("Cantidad: " + NoReparado, 10, 183);

        g.setColor(Color.BLACK);
        g.fillRect(100, 200, largo3, 40);
        g.drawString("En Revision", 10, 218);
        g.drawString("Cantidad: " + EnRevision, 10, 233);

        g.setColor(Color.YELLOW);
        g.fillRect(100, 250, largo4, 40);
        g.drawString("Reparado", 10, 268);
        g.drawString("Cantidad: " + Reparado, 10, 283);

        g.setColor(Color.GREEN);
        g.fillRect(100, 300, largo5, 40);
        g.drawString("Entregado", 10, 318);
        g.drawString("Cantidad: " + Entregado, 10, 333);

    }
}