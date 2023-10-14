/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexiones;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.Login.user;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import static ventanas.GestionUsuarios.userU;

/**
 *
 * @author MINEDUCYT
 */
public class InformacionCliente extends javax.swing.JFrame {

    public static String n, user;
    public static int id, ID, idu;

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Informacionusuarios
     */
    public InformacionCliente() {
        initComponents();
        setLocationRelativeTo(null);
        user = Login.user;
        id = GestionClientes.ID;
        setResizable(false);
        setTitle("Gestion de Clientes - User: " + user);
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
                    "select * from clientes where ID = '" + id + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ID = rs.getInt("ID");
                TxtNombre.setText(rs.getString("Nombre"));
                TxtMail.setText(rs.getString("Email"));
                TxtTelefono.setText(rs.getString("Telefono"));
                TxtDireccion.setText(rs.getString("Direccion"));
                TxtModificado.setText(rs.getString("Modificado"));

                n = TxtNombre.getText().trim();

                LabelNombre.setText("Información del usuario " + n);

                try {

                    Connection cn2 = Conexiones.conexion();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select ID, Tipo, Marca, Estatus from equipo where IDCliente = '" + ID + "'");

                    ResultSet rs2 = pst2.executeQuery();

                    Table_equipo = new JTable(model);
                    jScrollPane1.setViewportView(Table_equipo);

                    model.addColumn("ID");
                    model.addColumn("Tipo");
                    model.addColumn("Marca");
                    model.addColumn("Estatus");

                    while (rs2.next()) {
                        Object[] fila = new Object[4];

                        for (int i = 0; i < 4; i++) {
                            fila[i] = rs2.getObject(i + 1);

                        }
                        model.addRow(fila);
                    }
                    Table_equipo.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int Filap = Table_equipo.rowAtPoint(e.getPoint());
                            int Columna = 0;

                            if (Filap >= -1) {
                                idu = (int) model.getValueAt(Filap, Columna);
                                InformacionEquipos informacion = new InformacionEquipos();
                                informacion.setVisible(true);
                            }
                        }
                    });
                    cn2.close();
                    cn.close();
                } catch (SQLException e) {
                    System.err.println(e);
                    JOptionPane.showMessageDialog(null, "Error! al llenar la tabla, contacte a un administrador");
                }
            }
            cn.close();
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error porfavor contacte al administrador");
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

        Ingresar = new javax.swing.JButton();
        Imprimir = new javax.swing.JButton();
        Ingresar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_equipo = new javax.swing.JTable();
        LabelNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtMail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtModificado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        LabelWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ingresar.setBackground(new java.awt.Color(153, 153, 240));
        Ingresar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        Ingresar.setText("Actualizar cliente");
        Ingresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });
        getContentPane().add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 210, 35));

        Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 120, 100));

        Ingresar1.setBackground(new java.awt.Color(153, 153, 240));
        Ingresar1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Ingresar1.setForeground(new java.awt.Color(255, 255, 255));
        Ingresar1.setText("Ingresar Equipo");
        Ingresar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ingresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingresar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Ingresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 210, 35));

        Table_equipo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Table_equipo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        LabelNombre.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        LabelNombre.setText("Informacion del cliente");
        LabelNombre.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        TxtMail.setBackground(new java.awt.Color(153, 153, 255));
        TxtMail.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtMail.setForeground(new java.awt.Color(255, 255, 255));
        TxtMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtMail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Em@il:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        TxtDireccion.setBackground(new java.awt.Color(153, 153, 255));
        TxtDireccion.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        TxtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtDireccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 320, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ultima Modificación");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        TxtModificado.setBackground(new java.awt.Color(153, 153, 255));
        TxtModificado.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtModificado.setForeground(new java.awt.Color(255, 255, 255));
        TxtModificado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtModificado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TxtModificado.setEnabled(false);
        getContentPane().add(TxtModificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Direccion");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        TxtTelefono.setBackground(new java.awt.Color(153, 153, 255));
        TxtTelefono.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        TxtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        TxtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(TxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));
        getContentPane().add(LabelWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed

        Document pdf = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(pdf, new FileOutputStream(ruta + "/Desktop/" + n + ".pdf"));

            com.itextpdf.text.Image head = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            head.scaleToFit(650, 1000);
            head.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial Black", 8, Font.BOLD, BaseColor.LIGHT_GRAY));
            parrafo.add("Programa hecho por B.A.G.G © \n\n");

            parrafo.setFont(FontFactory.getFont("Arial Black", 14, Font.BOLD, BaseColor.BLACK));
            parrafo.add("Datos de " + n + " \n\n");

            pdf.open();

            pdf.add(head);
            pdf.add(parrafo);

            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("ID");
            tabla.addCell("Nombre del Cliente");
            tabla.addCell("Email");
            tabla.addCell("Telefono");
            tabla.addCell("Direccio");
            tabla.addCell("Ultima Modificado");
            try {
                Connection cn = Conexiones.conexion();
                PreparedStatement pst = cn.prepareStatement("select * from clientes where ID = '" + ID + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {

                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));

                    } while (rs.next());

                    pdf.add(tabla);

                } else {
                }
                cn.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            parrafo1.setFont(FontFactory.getFont("Arial Black", 14, Font.BOLD, BaseColor.BLACK));
            parrafo1.add("\n\n\n\n Articulos del Usuarios \n\n");

            pdf.add(parrafo1);

            PdfPTable tabla1 = new PdfPTable(4);
            tabla1.addCell("ID");
            tabla1.addCell("Tipo");
            tabla1.addCell("Marca");
            tabla1.addCell("Estatus");;
            try {
                Connection cn1 = Conexiones.conexion();
                PreparedStatement pst1 = cn1.prepareStatement("select ID, Tipo, Marca, Estatus from equipo where IDCliente = '" + ID + "'");

                ResultSet rs1 = pst1.executeQuery();

                if (rs1.next()) {

                    do {

                        tabla1.addCell(rs1.getString(1));
                        tabla1.addCell(rs1.getString(2));
                        tabla1.addCell(rs1.getString(3));
                        tabla1.addCell(rs1.getString(4));

                    } while (rs1.next());

                    pdf.add(tabla1);
                }

            } catch (Exception e) {
            }
            pdf.close();
            JOptionPane.showMessageDialog(null, "PDF creado");
        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_ImprimirActionPerformed

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed
//actualizar
        String Nombre, Mail, Direccion, Telefono, Modificado = user;
        Nombre = TxtNombre.getText().trim();
        Mail = TxtMail.getText().trim();
        Direccion = TxtDireccion.getText().trim();
        Telefono = TxtTelefono.getText().trim();

        try {
            Connection cn1 = Conexiones.conexion();
            PreparedStatement pst1 = cn1.prepareStatement(
                    "Update clientes set Nombre=?, Email=?, Telefono=?, Direccion=?, Modificado=?"
                    + "where ID = '" + ID + "'");

            pst1.setString(1, Nombre);
            pst1.setString(2, Mail);
            pst1.setString(3, Telefono);
            pst1.setString(4, Direccion);
            pst1.setString(5, Modificado);

            pst1.executeUpdate();
            cn1.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error, contacte a un administrador");
        }
        JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
        this.dispose();
    }//GEN-LAST:event_IngresarActionPerformed

    private void Ingresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingresar1ActionPerformed
        InsertarEquipos Insertar = new InsertarEquipos();
        Insertar.setVisible(true);
    }//GEN-LAST:event_Ingresar1ActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimir;
    private javax.swing.JButton Ingresar;
    private javax.swing.JButton Ingresar1;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelWallpaper;
    private javax.swing.JTable Table_equipo;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtMail;
    private javax.swing.JTextField TxtModificado;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
