/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.edu.todopc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import sv.com.edu.todopc.dto.CDs;

/**
 *
 * @author patym
 */
public class CdsCRUD {
    
private final String SQL_INSERT = "INSERT INTO ctg_cds(ctg_cds_audio_titulo,ctg_cds_audio_autor,ctg_cds_audio_idioma,ctg_cds_audio_detalles,ctg_cds_audio_edicion,ctg_cds_audio_temas,ctg_cds_audio_CDD,ctg_cds_audio_unid_disp) VALUES(?,?,?,?,?,?,?,?,?)";
private final String SQL_UPDATE = "UPDATE ctg_cds SET ctg_cds_audio_titulo=?, ctg_cds_audio_autor=?, ctg_cds_audio_idioma=?, ctg_cds_audio_detalles=?, ctg_cds_audio_edicion=?, ctg_cds_audio_temas=?, ctg_cds_audio_CDD=?, ctg_cds_audio_unid_disp=? WHERE ctg_cds_correlativo=?";
private final String SQL_DELETE = "DELETE FROM ctg_cds WHERE ctg_cds_correlativo = ?";
private final String SQL_SELECT = "SELECT ctg_cds_correlativo,ctg_cds_audio_titulo,ctg_cds_audio_idioma,ctg_cds_audio_detalles,ctg_cds_audio_edicion,ctg_cds_audio_temas,ctg_cds_audio_CDD,ctg_cds_audio_unid_disp FROM ctg_cds WHERE ctg_cds_audio_unid_disp > 0 ORDER BY ctg_cds_correlativo asc";
private final String SQL_SELECT_ALL = "SELECT ctg_cds_correlativo,ctg_cds_audio_titulo,ctg_cds_audio_autor,ctg_cds_audio_idioma,ctg_cds_audio_detalles,ctg_cds_audio_edicion,ctg_cds_audio_temas,ctg_cds_audio_CDD,ctg_cds_audio_unid_disp FROM ctg_cds ORDER BY ctg_cds_correlativo asc";
private final String SQL_SELECT_CUSTOMER = "SELECT ctg_cds_correlativo,ctg_cds_audio_titulo,ctg_cds_audio_autor,ctg_cds_audio_idioma,ctg_cds_audio_detalles,ctg_cds_audio_edicion,ctg_cds_audio_temas,ctg_cds_audio_CDD,ctg_cds_audio_unid_disp FROM ctg_cds WHERE (ctg_cds_audio_titulo like ? or ctg_cds_audio_autor like ? or ctg_cds_audio_detalles like ?) and ctg_cds_audio_unid_disp ORDER BY ctg_cds_correlativo asc";


    ;
/**
 * 
 * @param libro
 * @return 
 */
    public int insert(CDs cd) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio
        int rows = 0; //registrosafectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setString(index++, cd.getTitulo());//param 1 => ?
            stmt.setString(index++, cd.getAutor());//param 2 => ?
            stmt.setString(index++, cd.getIdioma());//param 3 => ?
            stmt.setString(index++, cd.getDetalles());//param 4 => ?
            stmt.setString(index++, cd.getEdicion());//m 5 => ?
            stmt.setString(index++, cd.getTemas());
            stmt.setString(index++, cd.getCDD());
            stmt.setString(index++, cd.getUniDisponibles());//m 5 => ?
            System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();//no. registrosafectados
            System.out.println("Registros afectados:" + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * 
     * @param libros
     * @return 
     */
    public int update(CDs cd) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, cd.getTitulo());//param 1 => ?
            stmt.setString(index++, cd.getAutor());//param 2 => ?
            stmt.setString(index++, cd.getIdioma());//param 3 => ?
            stmt.setString(index++, cd.getDetalles());//param 4 => ?
            stmt.setString(index++, cd.getEdicion());//m 5 => ?
            stmt.setString(index++, cd.getTemas());//m 5 => ?
            stmt.setString(index++, cd.getCDD());
            stmt.setString(index++, cd.getUniDisponibles());
            stmt.setString(index++, cd.getCorrelativo());//m 5 => ?
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * 
     * @param Id
     * @return 
     */
    public int delete(String id) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, id);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    /**
     * Metodo que regresa el contenido de la tabla de libros
     */
    public DefaultTableModel selectCds() {
        
        DefaultTableModel  dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
    //Formando encabezado
            //for (int i = 1; i <= numberOfColumns; i++) {
            //    dtm.addColumn(meta.getColumnLabel(i));
            //}
        dtm.addColumn("CORRELATIVO");
        dtm.addColumn("TITULO");
        dtm.addColumn("AUTOR");
        dtm.addColumn("IDIOMA");  
        dtm.addColumn("DETALLES"); 
        dtm.addColumn("EDICION");
        dtm.addColumn("TEMAS");
        dtm.addColumn("CDD");
        dtm.addColumn("UNIDADES DISPONIBLES");
    //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }
    
    public DefaultTableModel selectAllCds() {
        
        DefaultTableModel  dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
    //Formando encabezado
          //  for (int i = 1; i <= numberOfColumns; i++) {
           //     dtm.addColumn(meta.getColumnLabel(i));
           // }
        dtm.addColumn("CORRELATIVO");
        dtm.addColumn("TITULO");
        dtm.addColumn("AUTOR");
        dtm.addColumn("IDIOMA");  
        dtm.addColumn("DETALLES"); 
        dtm.addColumn("EDICION");
        dtm.addColumn("TEMAS");
        dtm.addColumn("CDD");
        dtm.addColumn("UNIDADES DISPONIBLES");
    //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }
    
    public DefaultTableModel selectCustomerCds(String find) {
        
        DefaultTableModel  dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CUSTOMER);
            int index = 1;
            stmt.setString(index++, "%" + find + "%");//param 1 => ?
            stmt.setString(index++, "%" + find + "%");//param 2 => ?
            stmt.setString(index++, "%" + find + "%");//param 3 => ?
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
    //Formando encabezado
           // for (int i = 1; i <= numberOfColumns; i++) {
            //    dtm.addColumn(meta.getColumnLabel(i));
            //}
        dtm.addColumn("CORRELATIVO");
        dtm.addColumn("TITULO");
        dtm.addColumn("AUTOR");
        dtm.addColumn("IDIOMA");  
        dtm.addColumn("DETALLES"); 
        dtm.addColumn("EDICION");
        dtm.addColumn("TEMAS");
        dtm.addColumn("CDD");
        dtm.addColumn("UNIDADES DISPONIBLES");
    //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return dtm;
    }
}
