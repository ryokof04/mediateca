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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import sv.com.edu.todopc.dto.Revistas;

/**
 *
 * @author patym
 */
public class RevistasCRUD {
    
    private final String SQL_INSERT = "INSERT INTO ctg_revistas(ctg_revista_titulo,ctg_revista_editorial,ctg_revista_periodicidad,ctg_revista_fech_pub,ctg_revista_unid_disp) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ctg_revistas SET ctg_revista_titulo=?, ctg_revista_editorial=?, ctg_revista_periodicidad=?, ctg_revista_fech_pub=?, ctg_revista_unid_disp=?  WHERE ctg_revista_correlativo=?";
    private final String SQL_DELETE = "DELETE FROM ctg_revistas WHERE ctg_revista_correlativo = ?";
    private final String SQL_SELECT = "SELECT ctg_revista_correlativo,ctg_revista_titulo,ctg_revista_editorial,ctg_revista_periodicidad,ctg_revista_fech_pub,ctg_revista_unid_disp FROM ctg_revistas WHERE ctg_revista_unid_disp > 0 ORDER BY ctg_revista_correlativo asc";
    private final String SQL_SELECT_LIST = "SELECT ctg_revista_correlativo,ctg_revista_titulo,ctg_revista_editorial,ctg_revista_periodicidad,ctg_revista_fech_pub,ctg_revista_unid_disp FROM ctg_revistas ORDER BY ctg_revista_correlativo asc";
    private final String SQL_SELECT_CUSTOM = "SELECT ctg_revista_correlativo,ctg_revista_titulo,ctg_revista_editorial,ctg_revista_periodicidad,ctg_revista_fech_pub,ctg_revista_unid_disp FROM ctg_revistas WHERE (ctg_revista_titulo like ? or ctg_revista_editorial like ?) and  ctg_revista_unid_disp > 0 ORDER BY ctg_revista_correlativo asc";

    ;
/**
 * 
 * @param libro
 * @return 
 */
    public int insert(Revistas revista) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio
        int rows = 0; //registrosafectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setString(index++, revista.getTitulo());//param 1 => ?
            stmt.setString(index++, revista.getEditorial());//param 2 => ?
            stmt.setString(index++, revista.getPeriodicidad());//param 3 => ?
            stmt.setDate(index++, revista.getFechaPub());//param 4 => ?
            stmt.setString(index++, revista.getUnidDisponibles());//param 5 => ?
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
    public int update(Revistas revista) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, revista.getTitulo());//param 1 => ?
            stmt.setString(index++, revista.getEditorial());//param 2 => ?
            stmt.setString(index++, revista.getPeriodicidad());//param 3 => ?
            stmt.setDate(index++, revista.getFechaPub());//param 4 => ?
            stmt.setString(index++, revista.getUnidDisponibles());//param 5 => ?
            stmt.setString(index++, revista.getCorrelativo().toString());//param 8 => ?
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
    public DefaultTableModel selectRevistas() throws ParseException {
        
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
         //   for (int i = 1; i <= numberOfColumns; i++) {
         //       dtm.addColumn(meta.getColumnLabel(i));
         //   }
            dtm.addColumn("CORRELATIVO");
            dtm.addColumn("TITULO");
            dtm.addColumn("EDITORIAL");
            dtm.addColumn("PERIODICIDAD");
            dtm.addColumn("FECHA DE PUBLICACIÓN");            
            dtm.addColumn("UNIDADES DISPONIBLES");
            
    //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
         
                for (int i = 0; i < numberOfColumns; i++) {
                    if(i == 4){
                        SimpleDateFormat cast = new SimpleDateFormat("dd/MM/yyyy");
                        java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(rs.getObject(i + 1).toString());
                        fila[i] = cast.format(temp);
                    }else{
                        fila[i] = rs.getObject(i + 1);
                    }
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
    
    public DefaultTableModel selectAllRevistas() throws ParseException {
        
        DefaultTableModel  dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_LIST);
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
    //Formando encabezado
        //    for (int i = 1; i <= numberOfColumns; i++) {
        //        dtm.addColumn(meta.getColumnLabel(i));
        //    }
            dtm.addColumn("CORRELATIVO");
            dtm.addColumn("TITULO");
            dtm.addColumn("EDITORIAL");
            dtm.addColumn("PERIODICIDAD");
            dtm.addColumn("FECHA DE PUBLICACIÓN");            
            dtm.addColumn("UNIDADES DISPONIBLES");
            
    //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {
                    if(i == 4){
                        SimpleDateFormat cast = new SimpleDateFormat("dd/MM/yyyy");
                        java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(rs.getObject(i + 1).toString());
                        fila[i] = cast.format(temp);
                    }else{
                        fila[i] = rs.getObject(i + 1);
                    }
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
    
    public DefaultTableModel selectCustomRevistas(String find) throws ParseException {
        
        DefaultTableModel  dtm = new DefaultTableModel();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CUSTOM);
            int index = 1;
            stmt.setString(index++, "%" + find + "%");//param 1 => ?
            stmt.setString(index++, "%" + find + "%");//param 2 => ?
            rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
    //Formando encabezado
            //for (int i = 1; i <= numberOfColumns; i++) {
            //   dtm.addColumn(meta.getColumnLabel(i));
            //}
            dtm.addColumn("CORRELATIVO");
            dtm.addColumn("TITULO");
            dtm.addColumn("EDITORIAL");
            dtm.addColumn("PERIODICIDAD");
            dtm.addColumn("FECHA DE PUBLICACIÓN");            
            dtm.addColumn("UNIDADES DISPONIBLES");
    //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {
                    if(i == 4){
                        SimpleDateFormat cast = new SimpleDateFormat("dd/MM/yyyy");
                        java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(rs.getObject(i + 1).toString());
                        fila[i] = cast.format(temp);
                    }else{
                        fila[i] = rs.getObject(i + 1);
                    }
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
