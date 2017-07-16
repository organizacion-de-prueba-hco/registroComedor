package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhon
 */
public class Conexion {
    public static Conexion instance;
  private Connection con;
  private Conexion(){    
      try {
          Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pbu", "root", "");    
      } catch (ClassNotFoundException | SQLException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
      }   
  }
  public synchronized static Conexion saberEstado(){
      if (instance==null) {
          instance=new Conexion();
      }
      return instance;
  }

    public Connection getCon() {
        return con;
    }
    public void cerrarConexion(){
        instance=null;
    }
}
