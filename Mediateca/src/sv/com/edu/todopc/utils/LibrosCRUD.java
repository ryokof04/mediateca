/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.edu.todopc.utils;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import sv.com.edu.todopc.dto.Libros;

/**
 *
 * @author patym
 */
public class LibrosCRUD {

    private final String SQL_INSERT = "INSERT INTO ctg_libros(ctg_libros_titulo,ctg_libros_autor,ctg_libros_num_pag,ctg_libros_editorial,ctg_libros_isbn,ctg_libros_anio_pub,ctg_libros_unid_disp) VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE ctg_libros SET ctg_libros_titulo=?, ctg_libros_autor=?, ctg_libros_num_pag=?, ctg_libros_editorial=?, ctg_libros_isbn=?, ctg_libros_anio_pub=?, ctg_libros_unid_disp=?  WHERE ctg_libros_correlativo=?";
    private final String SQL_DELETE = "DELETE FROM ctg_libros WHERE ctg_libros_correlativo = ?";
    private final String SQL_SELECT = "SELECT ctg_libros_correlativo,ctg_libros_titulo,ctg_libros_autor,ctg_libros_num_pag,ctg_libros_editorial,ctg_libros_isbn,ctg_libros_anio_pub,ctg_libros_unid_disp FROM ctg_libros where ctg_libros_unid_disp > 0 ORDER BY ctg_libros_correlativo  asc";
    private final String SQL_SELECT_ALL = "SELECT ctg_libros_correlativo,ctg_libros_titulo,ctg_libros_autor,ctg_libros_num_pag,ctg_libros_editorial,ctg_libros_isbn,ctg_libros_anio_pub,ctg_libros_unid_disp FROM ctg_libros ORDER BY ctg_libros_correlativo  asc";
    private final String SQL_SELECT_CUSTOMER = "SELECT ctg_libros_correlativo,ctg_libros_titulo,ctg_libros_autor,ctg_libros_num_pag,ctg_libros_editorial,ctg_libros_isbn,ctg_libros_anio_pub,ctg_libros_unid_disp FROM ctg_libros where (ctg_libros_titulo like ? or ctg_libros_autor like ? or ctg_libros_editorial like ?) and ctg_libros_unid_disp > 0 ORDER BY ctg_libros_correlativo asc";

    ;
/**
 * 
 * @param libro
 * @return 
 */
    public int insert(Libros libro) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//no se utiliza en este ejercicio
        int rows = 0; //registrosafectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;//contador de columnas
            stmt.setString(index++, libro.getTitulo());//param 1 => ?
            stmt.setString(index++, libro.getAutor());//param 2 => ?
            stmt.setString(index++, libro.getNumeroPaginas());//param 3 => ?
            stmt.setString(index++, libro.getEditorial());//param 4 => ?
            stmt.setString(index++, libro.getIsbn());//param 5 => ?
            stmt.setString(index++, libro.getAnioPub());//param 6 => ?
            stmt.setString(index++, libro.getUnidadesDisponibles());//param 2 => ?
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
    public int update(Libros libros) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, libros.getTitulo());//param 1 => ?
            stmt.setString(index++, libros.getAutor());//param 2 => ?
            stmt.setString(index++, libros.getNumeroPaginas());//param 3 => ?
            stmt.setString(index++, libros.getEditorial());//param 4 => ?
            stmt.setString(index++, libros.getIsbn());//param 5 => ?
            stmt.setString(index++, libros.getAnioPub());//param 6 => ?
            stmt.setString(index++, libros.getUnidadesDisponibles());//param 7 => ?
            stmt.setString(index++, libros.getCorrelativo());//param 8 => ?
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
     * @param carnet
     * @return 
     */
    public int delete(String correlativo) {
        
        Connection  conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, correlativo);
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
    public DefaultTableModel selectLibros() {
        
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
            dtm.addColumn("AUTOR");
            dtm.addColumn("# DE PÁGINAS");
            dtm.addColumn("EDITORIAL");
            dtm.addColumn("ISBN");
            dtm.addColumn("AÑO DE PUBLICACIÓN");
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
    
    /**
     * 
     * @param find
     * @return 
     */
    public DefaultTableModel selectCustomLibros(String find) {
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
           //     dtm.addColumn(meta.getColumnLabel(i));
           // }
            dtm.addColumn("CORRELATIVO");
            dtm.addColumn("TITULO");
            dtm.addColumn("AUTOR");
            dtm.addColumn("# DE PÁGINAS");
            dtm.addColumn("EDITORIAL");
            dtm.addColumn("ISBN");
            dtm.addColumn("AÑO DE PUBLICACIÓN");
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
    

    public DefaultTableModel selectAllLibros() {
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
            /*for (int i = 1; i <= numberOfColumns; i++) {
                dtm.addColumn(meta.getColumnLabel(i));
            }*/
            
            dtm.addColumn("CORRELATIVO");
            dtm.addColumn("TITULO");
            dtm.addColumn("AUTOR");
            dtm.addColumn("# DE PÁGINAS");
            dtm.addColumn("EDITORIAL");
            dtm.addColumn("ISBN");
            dtm.addColumn("AÑO DE PUBLICACIÓN");
            dtm.addColumn("UNIDADES DISPONIBLES");
           // dtm.addColumn("h");
           // dtm.addColumn("i");
            
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
