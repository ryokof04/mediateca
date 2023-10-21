/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.edu.todopc.forms;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import sv.com.edu.todopc.dto.DVD;
import static sv.com.edu.todopc.forms.FormCds.log;
import sv.com.edu.todopc.utils.DvdCRUD;

/**
 *
 * @author patym
 */
public class FormDVD extends javax.swing.JFrame {

    static final Logger log = Logger.getLogger(FormDVD.class);
    
    /**
     * Creates new form FormDVD
     */
    public FormDVD() {
        initComponents();
        DvdCRUD dvdCRUD = new DvdCRUD();
        tblDatos.setModel(dvdCRUD.selectAllDVD());
        log.info("Primera lectura de datos al grid");
        
        //Metodo de seteo de botones 
        defaultBtn();
        
        //Metodo que controla la habilitacion de los campos
        editionTxt(false);
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDirector = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDutracion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUnidDisponibles = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCorrelativo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 56, 66));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 197, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MEDIATECA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel5.setText("Titulo:");

        jLabel6.setText("Director:");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        jLabel7.setText("Duración:");

        jLabel8.setText("Género:");

        jLabel9.setText("Unidades disponibles:");

        jLabel10.setText("Correlativo:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Mantenimiento de DVD's");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addContainerGap(499, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnActualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCorrelativo, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                            .addComponent(jLabel7)
                                            .addComponent(txtDutracion)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5)
                                            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(jLabel8)
                                            .addComponent(txtGenero))
                                        .addGap(67, 67, 67)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(txtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUnidDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))))
                                .addGap(33, 33, 33))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel13)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDutracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       DefaultTableModel model = (DefaultTableModel) tblDatos.getModel();
       int selectedRowIndex = tblDatos.getSelectedRow();
       
       DVD d = new DVD(null, txtTitulo.getText(), txtDirector.getText(), txtDutracion.getText(), txtGenero.getText(), txtUnidDisponibles.getText(), txtCorrelativo.getText());
       DvdCRUD dvds = new DvdCRUD();
       int rowsUpdate = dvds.update(d);
       
       if (txtTitulo.getText().contentEquals("") || txtDirector.getText().contentEquals("") || txtDutracion.getText().contentEquals("") || txtGenero.getText().contentEquals("") || txtUnidDisponibles.getText().contentEquals(""))
       {
            log.error("Error. Algun campo esta vacío");
            JOptionPane.showConfirmDialog(null, "Uno o varios campos se encuentran vacíos. Favor completar el formulario", "Validación de Formulario", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,null);
       }
       else
       {   
            if(rowsUpdate>0){
                log.info("Registro actualizado correctamente");
                JOptionPane.showConfirmDialog(null, "Registro actualizado correctamente", "Actualización de Registro", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE,null);
                tblDatos.setModel(dvds.selectAllDVD());
                cleanTxt();
                defaultBtn();
            }else{
                log.error("No se ha encotrado ningun registro con el Correlativo " + model.getValueAt(selectedRowIndex, 0));
                JOptionPane.showConfirmDialog(null, "No se ha encotrado ningun registro con el Correlativo " + model.getValueAt(selectedRowIndex, 0) + ", por favor contactarse con el administrador ", "Eliminación de Registro", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,null);
            }
       }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblDatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMousePressed
        DefaultTableModel model = (DefaultTableModel) tblDatos.getModel();
       int selectedRowIndex = tblDatos.getSelectedRow();
       
       txtCorrelativo.setText(model.getValueAt(selectedRowIndex, 0).toString());
       txtTitulo.setText(model.getValueAt(selectedRowIndex, 1).toString());
       txtDirector.setText(model.getValueAt(selectedRowIndex, 2).toString());
       txtDutracion.setText(model.getValueAt(selectedRowIndex, 3).toString());
       txtGenero.setText(model.getValueAt(selectedRowIndex, 4).toString());
       txtUnidDisponibles.setText(model.getValueAt(selectedRowIndex, 5).toString());
       
       log.info("Datos seleccionado: " + model.getValueAt(selectedRowIndex, 0).toString());
       
       //botones
       defaultBtn();
       
       //Metodo que controla la edicion de los txt(True=edita, false=no edita
       editionTxt(false);
    }//GEN-LAST:event_tblDatosMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(!txtCorrelativo.getText().equals("")){
            btnGuardar.setEnabled(false);
            btnActualizar.setEnabled(true);
            editionTxt(true);
        }else{
            log.error("Se ha presionado el boton Editar sin haber seleccionado un registro!");
            JOptionPane.showConfirmDialog(null, "Por favor seleccione un registro", "Edición de Registro", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE,null);
            defaultBtn();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblDatos.getModel();
       int selectedRowIndex = tblDatos.getSelectedRow();
       
       if(selectedRowIndex < 0){
           log.error("Se ha presionado el boton Eliminar sin haber seleccionado un registro!");
           JOptionPane.showConfirmDialog(null, "Por favor seleccione un registro.", "Eliminación de Registro", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE,null);
       }else{
           int input = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro "+ model.getValueAt(selectedRowIndex, 0) + "? ", "Eliminación de Registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null);
        
            if(input == 0){
                log.info("Registro a eliminar: "+ model.getValueAt(selectedRowIndex, 0));
                DvdCRUD dvd = new DvdCRUD();
                int countDelete = dvd.delete(model.getValueAt(selectedRowIndex, 0).toString());     
                if(countDelete>0){
                    log.info("Eliminacion correcta del registro: "+ model.getValueAt(selectedRowIndex, 0));
                    JOptionPane.showConfirmDialog(null, "Registro eliminado correctamente", "Eliminación de Registro", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE,null);
                     tblDatos.setModel(dvd.selectAllDVD());
                     cleanTxt();
                     defaultBtn();
                }else{
                    log.info("No se ha encotrado ningun registro con el Correlativo " + model.getValueAt(selectedRowIndex, 0));
                    JOptionPane.showConfirmDialog(null, "No se ha encontrado ningún registro con el Correlativo " + model.getValueAt(selectedRowIndex, 9) + ", por favor contactarse con el administrador ", "Eliminación de Registro", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,null);
                }
             }
       }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
       btnGuardar.setEnabled(true);
       btnActualizar.setEnabled(false);
       cleanTxt();
       editionTxt(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       DefaultTableModel model = (DefaultTableModel) tblDatos.getModel();
       int selectedRowIndex = tblDatos.getSelectedRow();
       
       DVD d = new DVD(txtTitulo.getText(), txtDirector.getText(), txtDutracion.getText(), txtGenero.getText(), txtUnidDisponibles.getText());
        DvdCRUD dvd = new DvdCRUD();
       int rowsSave = dvd.insert(d);
       
       if (txtTitulo.getText().contentEquals("") || txtDirector.getText().contentEquals("") || txtDutracion.getText().contentEquals("") || txtGenero.getText().contentEquals("") || txtUnidDisponibles.getText().contentEquals(""))
       {
            log.error("Error. Algun campo esta vacío");
            JOptionPane.showConfirmDialog(null, "Uno o varios campos se encuentran vacíos. Favor completar el formulario", "Validación de Formulario", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,null);
       }
       else
       { 
            if(rowsSave>0){
                log.info("Datos guardados correctamente!");
                JOptionPane.showConfirmDialog(null, "Registro guardado correctamente", "Almacenamiento de Registro", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE,null);
                tblDatos.setModel(dvd.selectAllDVD());
                cleanTxt();
                defaultBtn();

            }else{
                log.error("No se ha podido guardar el registro, por favor contactarse con el administrador ");
                JOptionPane.showConfirmDialog(null, "No se ha encontrado ningún registro con el Correlativo " + model.getValueAt(selectedRowIndex, 1) + ", por favor contactarse con el administrador ", "Eliminación de Registro", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,null);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void editionTxt(Boolean editable){
        if(editable){
            txtTitulo.setEditable(true);
            txtDirector.setEditable(true);
            txtDutracion.setEditable(true);
            txtGenero.setEditable(true);
            txtUnidDisponibles.setEditable(true);
            txtCorrelativo.setEditable(false);
            
        }else{
            txtTitulo.setEditable(false);
            txtDirector.setEditable(false);
            txtDutracion.setEditable(false);
            txtGenero.setEditable(false);
            txtUnidDisponibles.setEditable(false);
            txtCorrelativo.setEditable(false);
            
        }
        
    }
    
    public void cleanTxt(){
        txtTitulo.setText("");
        txtDirector.setText("");
        txtDutracion.setText("");
        txtGenero.setText("");
        txtUnidDisponibles.setText("");
        txtCorrelativo.setText("");
    }
    
    public void defaultBtn(){
       btnNuevo.setEnabled(true);
       btnEditar.setEnabled(true);
       btnEliminar.setEnabled(true);
       
       btnGuardar.setEnabled(false);
       btnActualizar.setEnabled(false);
    }
    
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
            java.util.logging.Logger.getLogger(FormDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDVD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCorrelativo;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtDutracion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUnidDisponibles;
    // End of variables declaration//GEN-END:variables
}
