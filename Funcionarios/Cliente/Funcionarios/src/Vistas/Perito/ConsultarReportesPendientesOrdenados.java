/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Perito;

import Thrift.Conexiones;
import Thrift.ErrorBD;
import Thrift.Reporte;
import Thrift.VehiculosReporte;
import Vistas.Administrador.*;
import Vistas.Todos.IniciarSesion;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
public class ConsultarReportesPendientesOrdenados extends javax.swing.JFrame {

    /**
     * Creates new form InicioPerito
     */
    //Datos de sesion
    String nombre, usuario, contrasena = null;
    //Datos reporte seleccionado
    Integer idPosicion, numReportes;
    Conexiones conexiones;

    DefaultTableModel dm;
    
    public ConsultarReportesPendientesOrdenados(String nombre, String usuario, String contrasena) {
        initComponents();
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        conexiones = new Conexiones();
        actualizarMenu();
        llenarTabla();

    }

    private void actualizarMenu() {
        String primerNombre = this.nombre.split(" ")[0].trim();
        menuBienvenido.setText("BIENVENIDO: " + primerNombre);
    }

    private void cerrarSesion() {
        IniciarSesion inicio = new IniciarSesion();
        inicio.setVisible(true);
        this.dispose();

    }
    
    private void llenarTabla(){
            //Declaramos unas variables
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            modelo.addColumn("#");
            modelo.addColumn("Número de reportes");
            tblReportes.setModel(modelo);
        try {
            List<VehiculosReporte> listaVehiculos =  conexiones.getPlacasVehiculosReporte();
            List<List<VehiculosReporte>> listaOrdenada = ordenarLista(listaVehiculos);
            for (int i = 0; i < listaOrdenada.size(); i++) {
                modelo.addRow(new Object[]{
                    i,
                    listaOrdenada.get(i).size(),
                });
            }
            
        } catch (ErrorBD error) {
            System.out.println("ERROR: " + error.codigoError + " " + error.problema);
            JOptionPane.showConfirmDialog(null, "Datos no diponibles, intente más tarde", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } catch (TException ex) {
            conexiones.abrirConexion();
            conexiones.cerrarConexion();
            JOptionPane.showConfirmDialog(null, "No se descargo la lista de reportes, intente más tarde", "Datos no disponibles", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
   List<List<VehiculosReporte>> ordenarLista(List<VehiculosReporte> listaVehiculos){
         
      
        List<List<VehiculosReporte>> lista = new ArrayList<>();
        
        //nueva.add(new ArrayList<String>());
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if(lista.isEmpty()){
                lista.add(new ArrayList<VehiculosReporte>());
                lista.get(0).add(listaVehiculos.get(0));
            }else{
                boolean valorInsertado = false;
                for (int j = 0; j < lista.size(); j++) {
                    for (int k = 0; k < lista.get(j).size(); k++) {
                        if(lista.get(j).get(k).placaVehiculo2.equals(listaVehiculos.get(i).placaVehiculo1)){
                            System.out.println("Entra");
                            valorInsertado = true;
                            lista.get(j).add(listaVehiculos.get(i));
                           
                        }
                    }
                    
                }   
                if(valorInsertado == false){
                    lista.add(new ArrayList<VehiculosReporte>());
                    lista.get(lista.size()-1).add(listaVehiculos.get(i));
                }               
            }
        }
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Imprimiendo Lista " + i);
            for (int j = 0; j < lista.get(i).size(); j++) {
                System.out.println("Elemento "+ j + ": " + lista.get(i).get(j).placaVehiculo1);
            }
        }
        
        return lista;
    }
    
    

    private void llenarTabla2() {
        try {
            //Declaramos unas variables
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            modelo.addColumn("Número de reportes");
          //  modelo.addColumn("Placa");
           // modelo.addColumn("Otro Conductor");
            tblReportes.setModel(modelo);
            List<Reporte> listaReportes;
            listaReportes = conexiones.getReportesPendientes();
            for (int i = 0; i < listaReportes.size(); i++) {
                modelo.addRow(new Object[]{
                    listaReportes.get(i).getIdreporte(),
                    listaReportes.get(i).getNombreConductor(),
                    listaReportes.get(i).getNombreOtroConduc()
                });
            }
        } catch (ErrorBD error) {
            System.out.println("ERROR: " + error.codigoError + " " + error.problema);
            JOptionPane.showConfirmDialog(null, "Datos no diponibles, intente más tarde", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } catch (TException ex) {
            conexiones.abrirConexion();
            conexiones.cerrarConexion();
            JOptionPane.showConfirmDialog(null, "No se descargo la lista de reportes, intente más tarde", "Datos no disponibles", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
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
        tblReportes = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAsignar = new javax.swing.JButton();
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

        tblReportes.setAutoCreateRowSorter(true);
        tblReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblReportes.setRowHeight(28);
        tblReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblReportesMousePressed(evt);
            }
        });
        tblReportes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblReportesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblReportesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblReportes);

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
        lblTitulo.setText("REPORTES PENDIENTES");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnAsignar.setText("ASIGNAR");
        btnAsignar.setEnabled(false);
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
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
                .addContainerGap(21, Short.MAX_VALUE))
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
        InicioPerito inicioPerito = new InicioPerito(nombre, usuario, contrasena);
        inicioPerito.setVisible(true);
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

    private void tblReportesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReportesMousePressed
      //  JTable table = (JTable) evt.getSource();
       // int row = table.rowAtPoint(evt.getPoint());
        if (evt.getClickCount() == 1) {
            idPosicion = (Integer) tblReportes.getValueAt(tblReportes.getSelectedRow(), 0);
            numReportes = (Integer) tblReportes.getValueAt(tblReportes.getSelectedRow(), 1);  
            btnAsignar.setEnabled(true);
        }
    }//GEN-LAST:event_tblReportesMousePressed

    private void tblReportesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblReportesKeyPressed
        
    }//GEN-LAST:event_tblReportesKeyPressed

    private void tblReportesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblReportesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {  
           // JTable table = (JTable) evt.getSource();
           // int row = table.getSelectedRow();

           idPosicion = (Integer) tblReportes.getValueAt(tblReportes.getSelectedRow(), 0);
            numReportes = (Integer) tblReportes.getValueAt(tblReportes.getSelectedRow(), 1);  
            btnAsignar.setEnabled(true);
        }
    }//GEN-LAST:event_tblReportesKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        filtrarTabla(txtBuscar.getText().toUpperCase(), tblReportes);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        
        try {
            if (conexiones.asignarReportePerito(this.usuario, idPosicion)) {
                JOptionPane.showConfirmDialog(null, "Reporte asignado exitosamente", "Reporte Asignado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                llenarTabla();
            } else {
                JOptionPane.showConfirmDialog(null, "Error al intentar asignar reporte, actualice la tabla e intente de nuevo", "Error al asignar reporte", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ErrorBD error) {
            System.out.println("ERROR: " + error.codigoError + " " + error.problema);
            JOptionPane.showConfirmDialog(null, "Sistema no diponible, intente más tarde", "Problema de conexión", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } catch (TException ex) {
            conexiones.abrirConexion();
            conexiones.cerrarConexion();
            JOptionPane.showConfirmDialog(null, "Error al intentar asignar reporte, intente de nuevo", "Error al asignar reporte", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }

       
    }//GEN-LAST:event_btnAsignarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarReportesPendientesOrdenados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarReportesPendientesOrdenados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarReportesPendientesOrdenados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarReportesPendientesOrdenados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu menuBienvenido;
    private javax.swing.JMenuItem menuCerrarSesion;
    private javax.swing.JTable tblReportes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
