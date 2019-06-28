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
import Vistas.Administrador.ModificarPerito;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.thrift.TException;


/**
 *
 * @author cris_
 */
public class ConsultarPeritos extends javax.swing.JFrame {

    /**
     * Creates new form InicioPerito
     */
    //Datos sesión
    String nombre, usuario, contrasena = null;
    //Datos perito seleccionado
    String nombrePerito, usuarioPerito, estatusPerito = null;
    Conexiones conexiones;
    
    DefaultTableModel dm;
    

    private void actualizarMenu() {
        String primerNombre = this.nombre.split(" ")[0].trim();
        menuBienvenido.setText("BIENVENIDO: " + primerNombre);
    }

    private void cerrarSesion() {
        IniciarSesion inicio = new IniciarSesion();
        inicio.setVisible(true);
        this.dispose();

    }

    private void llenarTabla() {
        try {
            //Declaramos unas variables
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            modelo.addColumn("Nombre Completo");
            modelo.addColumn("Usuario");
            modelo.addColumn("Estatus");
            String estatus;
            List<Funcionario> listaPeritos;
            listaPeritos = conexiones.getPeritos();
            tblPeritos.setModel(modelo);
            for (int i = 0; i < listaPeritos.size(); i++) {
                if (listaPeritos.get(i).estatus == 1) {
                    estatus = "ACTIVO";
                } else {
                    estatus = "SUSPENDIDO";
                }

                modelo.addRow(new Object[]{
                    listaPeritos.get(i).nombre,
                    listaPeritos.get(i).usuario,
                    estatus

                });
            }
        } catch (ErrorBD error) {
            System.out.println("ERROR: " + error.codigoError + " " + error.problema);
            JOptionPane.showConfirmDialog(null, "Datos no diponibles, intente más tarde", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } catch (TException ex) {
            //conexiones.abrirConexion();
            //conexiones.cerrarConexion();
            JOptionPane.showConfirmDialog(null, "No se descargo la lista de peritos, intente más tarde", "Datos no disponibles", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
 
    
    public ConsultarPeritos(String nombre, String usuario, String contrasena) {
        initComponents();
        conexiones = new Conexiones();
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        actualizarMenu();
        llenarTabla();

    }
    
    private void filtrarTabla(String consulta, JTable jtableBuscar){
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
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
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeritos = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnEstatus = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCambiarContrasena = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBienvenido = new javax.swing.JMenu();
        menuCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar Peritos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        lblBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBuscar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBuscar.setText("Buscar:");
        jPanel2.add(lblBuscar);
        lblBuscar.setBounds(50, 10, 90, 40);

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscar.setToolTipText("");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel2.add(txtBuscar);
        txtBuscar.setBounds(150, 10, 380, 40);

        tblPeritos.setAutoCreateRowSorter(true);
        tblPeritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPeritos.setRowHeight(28);
        tblPeritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPeritosMousePressed(evt);
            }
        });
        tblPeritos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblPeritosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPeritosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeritos);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 580, 210);

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
        lblTitulo.setText("CONSULTAR PERITOS");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnEstatus.setEnabled(false);
        btnEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstatusActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCambiarContrasena.setText("CAMBIAR CONTRASEÑA");
        btnCambiarContrasena.setEnabled(false);
        btnCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContrasenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarContrasena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAtras)
                        .addGap(229, 229, 229)
                        .addComponent(lblTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
         InicioAdministrador inicioAdmin = new InicioAdministrador(nombre, usuario, contrasena);
        inicioAdmin.setVisible(true);
        conexiones.cerrarConexion();
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnAtrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAtrasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
              btnAtrasActionPerformed(null);
          }
    }//GEN-LAST:event_btnAtrasKeyPressed

    private void tblPeritosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeritosMousePressed

        if (evt.getClickCount() == 1) {
            nombrePerito = tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 0).toString();
            usuarioPerito = tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 1).toString();
            estatusPerito = tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 2).toString();
            if("ACTIVO".equals(estatusPerito)){
               btnEstatus.setEnabled(true);
               btnModificar.setEnabled(true);
               btnCambiarContrasena.setEnabled(true);
               btnEstatus.setText("SUSPENDER");
            }else{
                btnEstatus.setText("ACTIVAR");
                btnModificar.setEnabled(true);
                btnCambiarContrasena.setEnabled(true);
                btnEstatus.setEnabled(true);
            }
            
        }
    }//GEN-LAST:event_tblPeritosMousePressed

    private void tblPeritosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPeritosKeyPressed
        
    }//GEN-LAST:event_tblPeritosKeyPressed

    private void tblPeritosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPeritosKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            nombrePerito = tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 0).toString();
            usuarioPerito = tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 1).toString();
            estatusPerito = tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 2).toString();
            if ("ACTIVO".equals(estatusPerito)) {
                btnEstatus.setEnabled(true);
                btnModificar.setEnabled(true);
                btnCambiarContrasena.setEnabled(true);
                btnEstatus.setText("SUSPENDER");
            } else {
                btnEstatus.setText("ACTIVAR");
                btnModificar.setEnabled(true);
                btnCambiarContrasena.setEnabled(true);
                btnEstatus.setEnabled(true);
            }

        }
    }//GEN-LAST:event_tblPeritosKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        filtrarTabla(txtBuscar.getText().toUpperCase(), tblPeritos);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatusActionPerformed

        String estatus = btnEstatus.getText(); //En su lugar validar con la base de datos

        if ("SUSPENDER".equals(estatus)) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea SUSPENDER la cuenta del perito?", "Suspender Cuenta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirmacion == 0) {
                try {
                    //ACCION QUE SUSPENDE LA CUENTA
                    if (conexiones.cambiarEstatusFuncionario(usuarioPerito)) {
                        JOptionPane.showConfirmDialog(null, "Se ha suspendido la cuenta del perito exitosamente!!", "Cuenta suspendida exitosa", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        llenarTabla();
                    } else {
                        JOptionPane.showConfirmDialog(null, "No se suspendio la cuenta, probablemente alguien más la suspendio. Actualice la tabla e intente de nuevo", "Sin cambios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (ErrorBD error) {
                    System.out.println("ERROR: " + error.codigoError + " " + error.problema);
                    JOptionPane.showConfirmDialog(null, "Sistema no diponible, intente más tarde", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                } catch (TException ex) {
                    conexiones.abrirConexion();
                    conexiones.cerrarConexion();
                    JOptionPane.showConfirmDialog(null, "Error de conexión con el servidor", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                }

            }
        } else if ("ACTIVAR".equals(estatus)) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea REACTIVAR la cuenta del perito?", "Reactivar Cuenta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirmacion == 0) {
                try {
                    //ACCION QUE SUSPENDE LA CUENTA
                    if (conexiones.cambiarEstatusFuncionario(usuarioPerito)) {
                        JOptionPane.showConfirmDialog(null, "Se ha reactivado la cuenta del perito exitosamente!!", "Cuenta reactivada exitosa", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        llenarTabla();
                    } else {
                        JOptionPane.showConfirmDialog(null, "No se reactivo la cuenta, probablemente alguien más la activo. Actualice la tabla e intente de nuevo", "Sin cambios", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (ErrorBD error) {
                    System.out.println("ERROR: " + error.codigoError + " " + error.problema);
                    JOptionPane.showConfirmDialog(null, "Sistema no diponible, intente más tarde", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                } catch (TException ex) {
                    conexiones.abrirConexion();
                    conexiones.cerrarConexion();
                    JOptionPane.showConfirmDialog(null, "Error de conexión con el servidor", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEstatusActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Funcionario perito = new Funcionario();
        perito.setNombre(nombrePerito);
        perito.setUsuario(usuarioPerito);
        
        ModificarPerito modificarPerito = new ModificarPerito(nombre, usuario, contrasena, perito);
        modificarPerito.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContrasenaActionPerformed
        
        CambiarContrasenaPerito cambiarContrasena = new CambiarContrasenaPerito(nombre, usuario, contrasena, usuarioPerito, nombrePerito);
        cambiarContrasena.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCambiarContrasenaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarPeritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPeritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPeritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPeritos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnCambiarContrasena;
    private javax.swing.JButton btnEstatus;
    private javax.swing.JButton btnModificar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu menuBienvenido;
    private javax.swing.JMenuItem menuCerrarSesion;
    private javax.swing.JTable tblPeritos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
