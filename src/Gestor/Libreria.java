/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gestor;

import java.sql.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Jhon Cardenas
 */
public class Libreria extends javax.swing.JFrame {
    //CREAMOS CONEXIÓN A BASE DE DATOS
    public static final String url = "jdbc:mysql://localhost:3306/libreria";
    public static final String usuario = "root";
    public static final String contrasena = "admin";

    //EL MODELO PERMITIRA VISUALIZAR NUESTRA TABLA CON LOS DATOS
    DefaultTableModel modelo;
    
    /**
     * Creates new form Libreria
     */
    public Libreria() {
        initComponents();
        //CENTRA EL JFRAME
        this.setLocationRelativeTo(null);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Titulo");
        modelo.addColumn("Autor");
        modelo.addColumn("Género");
        
        mostrarDatos();
    }
    //CREAMOS EVENTO QUE PERMITE RECUPERAR LOS DATOS DE LA BASE DE DATOS Y MOSTRARLOS EN LA TABLA
    public void mostrarDatos(){
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {            
            conexion = (Connection) DriverManager.getConnection(url, usuario, contrasena);
            String sql = "SELECT id, titulo, autor, genero from libro";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                    int id = rs.getInt("id");                    
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    String genero = rs.getString("genero");
                    
                    modelo.addRow(new Object[]{id, titulo, autor, genero});
            }
            
            jtDatos.setModel(modelo);
            rs.close();
            ps.close();
            conexion.close();
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, "Error al conectar la base de Datos: " + e.getMessage());
      }
    }
    
    //CREAMOS UN MÉTODO PARA CONECTARNOS A NUESTRA BASE DE DATOS
    public Connection getConnection(){
        Connection conexion = null;
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, usuario, contrasena);
             JOptionPane.showMessageDialog(null, "Conexión Exitosa");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error");
        }
        
        return conexion;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        fondo = new javax.swing.JLabel();
        vistaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        vistaIngreso = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLid = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jLAutor = new javax.swing.JLabel();
        jLGenero = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jTTitulo = new javax.swing.JTextField();
        jTGenero = new javax.swing.JTextField();
        jTAutor = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));
        Contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos.Imagenes/libreriaLuz.jpg"))); // NOI18N
        Contenedor.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 420, 180));

        vistaDatos.setBackground(new java.awt.Color(255, 76, 41));

        jtDatos.setBackground(new java.awt.Color(44, 225, 218));
        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Autor", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE DATOS");

        javax.swing.GroupLayout vistaDatosLayout = new javax.swing.GroupLayout(vistaDatos);
        vistaDatos.setLayout(vistaDatosLayout);
        vistaDatosLayout.setHorizontalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        vistaDatosLayout.setVerticalGroup(
            vistaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaDatosLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        Contenedor.add(vistaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        vistaIngreso.setBackground((new Color(255, 255, 255, 1)));

        titulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Libreria Unibagué");

        jLid.setText("Id:");

        jLTitulo.setText("Autor");

        jLAutor.setText("Titulo:");

        jLGenero.setText("Género:");

        jTId.setEnabled(false);
        jTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdActionPerformed(evt);
            }
        });

        jTTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTituloActionPerformed(evt);
            }
        });

        jTAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAutorActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 76, 41));
        btnAgregar.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistaIngresoLayout = new javax.swing.GroupLayout(vistaIngreso);
        vistaIngreso.setLayout(vistaIngresoLayout);
        vistaIngresoLayout.setHorizontalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTAutor, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jTId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        vistaIngresoLayout.setVerticalGroup(
            vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vistaIngresoLayout.createSequentialGroup()
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vistaIngresoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vistaIngresoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(35, 35, 35)))
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vistaIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        Contenedor.add(vistaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 420, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIdActionPerformed

    private void jTTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTituloActionPerformed

    private void jTAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAutorActionPerformed

    //CREAMOS UN EVENTO VOID, PARA ENVIAR UNA PETICION QUE VA A GUARDAT UN DATO EN LA BASE DE DATOS
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Connection conexion = getConnection();
        PreparedStatement ps = null;
        
        String sql = "insert into libro(titulo, autor, genero) value(?,?,?);";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1,jTTitulo.getText());
            ps.setString(2,jTAutor.getText());
            ps.setString(3,jTGenero.getText());
            ps.executeUpdate();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Libro Guardado");
            //LLAMAMOS METODO mostrarDatos PARA QUE ACTUALICE LA TABLA
            mostrarDatos();
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
                
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLAutor;
    private javax.swing.JLabel jLGenero;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTAutor;
    private javax.swing.JTextField jTGenero;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTTitulo;
    private javax.swing.JTable jtDatos;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel vistaDatos;
    private javax.swing.JPanel vistaIngreso;
    // End of variables declaration//GEN-END:variables
}
