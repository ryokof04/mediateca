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
import sv.com.edu.todopc.dto.DVD;

/**
 *
 * @author patym
 */
public class DvdCRUD {
    
   
    private final String SQL_INSERT = "INSERT INTO ctg_dvds(ctg_dvd_titulo,ctg_dvd_director,ctg_dvd_duracion,ctg_dvd_genero,ctg_dvd_unid_disp) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ctg_dvds SET ctg_dvd_titulo=?, ctg_dvd_director=?, ctg_dvd_duracion=?, ctg_dvd_genero=?, ctg_dvd_unid_disp=? WHERE ctg_dvd_correlativo=?";
    private final String SQL_DELETE = "DELETE FROM ctg_dvds WHERE ctg_dvd_correlativo = ?";
    private final String SQL_SELECT = "SELECT ctg_dvd_correlativo,ctg_dvd_titulo,ctg_dvd_director,ctg_dvd_duracion,ctg_dvd_genero,ctg_dvd_unid_disp FROM ctg_dvds WHERE ctg_dvd_unid_disp > 0 ORDER BY ctg_dvd_correlativo asc";
    private final String SQL_SELECT_ALL = "SELECT ctg_dvd_correlativo,ctg_dvd_titulo,ctg_dvd_director,ctg_dvd_duracion,ctg_dvd_genero,ctg_dvd_unid_disp FROM ctg_dvds ORDER BY ctg_dvd_correlativo asc";
    private final String SQL_SELECT_CUSTOMER = "SELECT ctg_dvd_correlativo,ctg_dvd_titulo,ctg_dvd_director,ctg_dvd_duracion,ctg_dvd_genero,ctg_dvd_unid_disp FROM ctg_dvds WHERE (ctg_dvd_titulo like ? or ctg_dvd_director like ? or ctg_dvd_genero like ?) and ctg_dvd_unid_disp > 0 ORDER BY ctg_dvd_correlativo asc";
    ;
/**
 * 
 * @param dvd
 * @return 
 */
    public int insert(DVD dvd) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio
        int rows = 0; //registrosafectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setString(index++, dvd.getTitulo());//param 1 => ?
            stmt.setString(index++, dvd.getDirector());//param 2 => ?
            stmt.setString(index++, dvd.getDuracion());//param 3 => ?
            stmt.setString(index++, dvd.getGenero());//param 4 => ?
            stmt.setString(index++, dvd.getUnidadesDisponibles());//m 5 => ?
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
    public int update(DVD dvd) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, dvd.getTitulo());//param 1 => ?
            stmt.setString(index++, dvd.getDirector());//param 2 => ?
            stmt.setString(index++, dvd.getDuracion());//param 3 => ?
            stmt.setString(index++, dvd.getGenero());//param 4 => ?
            stmt.setString(index++, dvd.getUnidadesDisponibles());//m 5 => ?
            stmt.setString(index++, dvd.getCorrelativo());//param 8 => ?
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
    public DefaultTableModel selectDVD() {
        
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
        //    for (int i = 1; i <= numberOfColumns; i++) {
        //        dtm.addColumn(meta.getColumnLabel(i));
        //    }
        dtm.addColumn("CORRELATIVO");
        dtm.addColumn("TITULO");
        dtm.addColumn("DIRECTOR");
        dtm.addColumn("DURACIÓN");
        dtm.addColumn("GÉNERO");            
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
    
    public DefaultTableModel selectAllDVD() {
        
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
            //for (int i = 1; i <= numberOfColumns; i++) {
            //    dtm.addColumn(meta.getColumnLabel(i));
            //}
        dtm.addColumn("CORRELATIVO");
        dtm.addColumn("TITULO");
        dtm.addColumn("DIRECTOR");
        dtm.addColumn("DURACIÓN");
        dtm.addColumn("GÉNERO");            
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
    
    public DefaultTableModel selectCustomerDVD(String find) {
        
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
            //for (int i = 1; i <= numberOfColumns; i++) {
            //    dtm.addColumn(meta.getColumnLabel(i));
            //}
        dtm.addColumn("CORRELATIVO");
        dtm.addColumn("TITULO");
        dtm.addColumn("DIRECTOR");
        dtm.addColumn("DURACIÓN");
        dtm.addColumn("GÉNERO");            
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
