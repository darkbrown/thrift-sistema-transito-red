/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Administrador;


import Thrift.Conexiones;
import Thrift.ErrorBD;
import Thrift.Funcionario;
import Vistas.Todos.IniciarSesion;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.thrift.TException;


/**
 *
 * @author cris_
 */
public class ModificarPerito extends javax.swing.JFrame {

    /**
     * Creates new form InicioPerito
     */
    Conexiones conexiones;
    String nombre, usuario, contrasena = null;
    Funcionario peritoAnterior;

    private void actualizarMenu() {
        String primerNombre = this.nombre.split(" ")[0].trim();
        menuBienvenido.setText("BIENVENIDO: " + primerNombre);
        conexiones = new Conexiones();
    }

    private void cerrarSesion() {
        IniciarSesion inicio = new IniciarSesion();
        inicio.setVisible(true);
        this.dispose();

    }

    public ModificarPerito(String nombre, String usuario, String contrasena, Funcionario peritoAnterior) {
        initComponents();
        this.peritoAnterior = peritoAnterior;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        actualizarMenu();
        llenarCampos();

    }
    
    
    private void llenarCampos(){
        txtNombre.setText(peritoAnterior.getNombre());
        txtUsuario.setText(peritoAnterior.getUsuario());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardarCambios = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBienvenido = new javax.swing.JMenu();
        menuCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Perito");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        btnGuardarCambios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardarCambios.setText("GUARDAR CAMBIOS");
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        btnGuardarCambios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarCambiosKeyPressed(evt);
            }
        });
        jPanel2.add(btnGuardarCambios);
        btnGuardarCambios.setBounds(360, 240, 180, 40);

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre Completo");
        jPanel2.add(lblNombre);
        lblNombre.setBounds(0, 30, 150, 40);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setToolTipText("");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre);
        txtNombre.setBounds(160, 30, 380, 40);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("Usuario");
        jPanel2.add(lblUsuario);
        lblUsuario.setBounds(0, 110, 150, 40);

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.setToolTipText("");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel2.add(txtUsuario);
        txtUsuario.setBounds(160, 110, 380, 40);

        btnAtras.setBackground(new java.awt.Color(255, 255, 255));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back-arrow 24.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        btnAtras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAtrasKeyPressed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("MODIFICAR PERITO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnAtras)
                .addGap(217, 217, 217)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        menuBienvenido.setText("BIENVENIDO JUAN");
        menuBienvenido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        menuCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exit.png"))); // NOI18N
        menuCerrarSesion.setText("CERRAR SESIÓN");
        menuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesionActionPerformed(evt);
            }
        });
        menuBienvenido.add(menuCerrarSesion);

        jMenuBar1.add(menuBienvenido);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la sesión actual?", "Cerrar Sesión",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (confirmacion == 0) {
            cerrarSesion();
        }
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        String nombrePerito, usuarioPerito;

        nombrePerito = txtNombre.getText().toUpperCase().trim();
        usuarioPerito = txtUsuario.getText().toUpperCase().trim();

        if ("".equals(nombrePerito) || "".equals(usuarioPerito)) {
            JOptionPane.showConfirmDialog(null, "Es necesario llenar todos los campos", "Llenar Campos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        } else {
            Funcionario peritoNuevo = new Funcionario();
            peritoNuevo.setNombre(nombrePerito);
            peritoNuevo.setUsuario(usuarioPerito);
            try {
                if (conexiones.modificarPerito(peritoAnterior, peritoNuevo)) {
                    JOptionPane.showConfirmDialog(null, "Se han guardado los cambios exitosamente!!", "Modificación exitosa", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    ConsultarPeritos consultarPeritos = new ConsultarPeritos(nombre, usuario, contrasena);
                    consultarPeritos.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showConfirmDialog(null, "Ya existe un perito con ese nombre de usuario o hay un problema con la base de datos", "Error al guardar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
                } catch (ErrorBD error) {
            System.out.println("ERROR: " + error.codigoError + " " + error.problema);
            JOptionPane.showConfirmDialog(null, "Sistema no diponible, intente más tarde", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            } catch (TException ex) {
                conexiones.abrirConexion();
                conexiones.cerrarConexion();
                JOptionPane.showConfirmDialog(null, "Error al intentar modificar datos, intente de nuevo", "Error al guardar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }

        }


    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        ConsultarPeritos consultarPeritos = new ConsultarPeritos(nombre, usuario, contrasena);
        consultarPeritos.setVisible(true);
        conexiones.cerrarConexion();
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnGuardarCambiosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarCambiosKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
              btnGuardarCambiosActionPerformed(null);
          }
    }//GEN-LAST:event_btnGuardarCambiosKeyPressed

    private void btnAtrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAtrasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
              btnAtrasActionPerformed(null);
          }
    }//GEN-LAST:event_btnAtrasKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       int limite = 81;
        if (txtNombre.getText().length()== limite)
        evt.consume();
         char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
             evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        int limite = 20;
        if (txtUsuario.getText().length()== limite)
        evt.consume();
    }//GEN-LAST:event_txtUsuarioKeyTyped

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
            java.util.logging.Logger.getLogger(ModificarPerito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPerito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPerito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPerito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuBienvenido;
    private javax.swing.JMenuItem menuCerrarSesion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
