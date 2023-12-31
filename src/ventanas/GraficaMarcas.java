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
public class GraficaMarcas extends javax.swing.JFrame {

    String user;
    int Acer, Alienware, Apple, Asus, Brother, Dell, Hp, Lenovoo;
    String[] Estatus = new String[5];
    int[] Count = new int[5];

    /**
     * Creates new form GrafiaEstatus
     */
    public GraficaMarcas() {
        initComponents();

        user = Login.user;

        setSize(459, 399);
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
                    "select Marca, count(marca) as Cantidad from equipo group by Marca");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    Estatus[posicion] = rs.getString(1);
                    Count[posicion] = rs.getInt(2);

                    if (Estatus[posicion].equals("Acer")) {
                        Acer = Count[posicion];
                    } else if (Estatus[posicion].equals("Alienware")) {
                        Alienware = Count[posicion];
                    } else if (Estatus[posicion].equals("Apple")) {
                        Apple = Count[posicion];
                    } else if (Estatus[posicion].equals("Asus")) {
                        Asus = Count[posicion];
                    } else if (Estatus[posicion].equals("Brother")) {
                        Brother = Count[posicion];
                    } else if (Estatus[posicion].equals("Dell")) {
                        Dell = Count[posicion];
                    } else if (Estatus[posicion].equals("Hp")) {
                        Hp = Count[posicion];
                    } else if (Estatus[posicion].equals("Lenovoo")) {
                        Lenovoo = Count[posicion];
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
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 400));

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
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        {
            int total = 1;
            total = Acer + Alienware + Apple + Asus + Brother + Dell + Hp + Lenovoo;
            if (total >= 1) {
                int acer = Acer * 360 / total;
                int alienware = Alienware * 360 / total;
                int apple = Apple * 360 / total;
                int asus = Asus * 360 / total;
                int brother = Brother * 360 / total;
                int dell = Dell * 360 / total;
                int hp = Hp * 360 / total;
                int lenovoo = Lenovoo * 360 / total;

                g.setColor(Color.red);
                g.fillArc(25, 80, 200, 200, 0, acer);
                g.fillRect(250, 120, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString("Acer", 275, 135);

                g.setColor(Color.YELLOW);
                g.fillArc(25, 80, 200, 200, acer, alienware);
                g.fillRect(250, 150, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString("Alienware", 275, 165);

                g.setColor(Color.BLUE);
                g.fillArc(25, 80, 200, 200, acer + alienware, apple);
                g.fillRect(250, 180, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString("Apple", 275, 195);

                g.setColor(Color.BLACK);
                g.fillArc(25, 80, 200, 200, acer + alienware + apple, asus);
                g.fillRect(250, 210, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString("Asus", 275, 225);

                g.setColor(Color.WHITE);
                g.fillArc(25, 80, 200, 200, acer + alienware + apple + asus, brother);
                g.fillRect(250, 240, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString("Brother", 275, 255);

                g.setColor(Color.GREEN);
                g.fillArc(25, 80, 200, 200, acer + alienware + apple + asus + brother, dell);
                g.fillRect(250, 270, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString("Dell", 275, 285);

                g.setColor(Color.MAGENTA);
                g.fillArc(25, 80, 200, 200, acer + alienware + apple + asus + brother + dell, hp);
                g.fillRect(250, 300, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString("HP", 275, 315);

                g.setColor(Color.ORANGE);
                g.fillArc(25, 80, 200, 200, acer + alienware + apple + asus + brother + dell + hp, lenovoo);
                g.fillRect(250, 330, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString("Lenovoo", 275, 345);

            }
        }
    }
}
