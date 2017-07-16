package dao;

import entities.Comedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Conexion;

/**
 *
 * @author Jhon
 */
public class daoComedor {
    //id, concesionario, estado, created_at, updated_at
    public String sql_insert="INSERT INTO comedors values(?,?,?,?,?);";
    public String sql_update="update comedors set estado=? where id=?;";
    public String sql_delete="delete from expedientes where dni=?;";
    public String sql_select="SELECT id,created_at FROM comedors WHERE estado='activo' order by id asc;";
    public String sql_filter="select *from expedientes where nombre like ''";
    private static final Conexion cn=Conexion.saberEstado();
    
    public boolean Guardar(Comedor c) {
      PreparedStatement ps;
        try {            
            ps=cn.getCon().prepareStatement(sql_insert);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getConcesionario());
            ps.setString(3, "activo");
            ps.setString(4, c.getFs());
            ps.setString(5, "0000-00-00 00:00:00");
            //ps.setDate(3, new java.sql.Date(c.getCreated().getTime()));
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null,"Dato Guardado","Correcto",JOptionPane.INFORMATION_MESSAGE,null);
                return true;
            }
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE,null); 
        }
        finally{
          cn.cerrarConexion();
        }
        return false;
    }

   public boolean Editar(Comedor c,Object key) {
     PreparedStatement ps;
        try {            
            ps=cn.getCon().prepareStatement(sql_update);
            ps.setString(1, "inactivo");
            ps.setString(2,key.toString());
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null,"Dato Modificado","Correcto",JOptionPane.INFORMATION_MESSAGE,null);
                return true;
            }
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE,null); 
        }
        finally{
          cn.cerrarConexion();
        }
        return false;
    }

    public boolean Eliminar(Object c) {
      try {
            PreparedStatement ps=cn.getCon().prepareStatement(sql_delete);
            ps.setString(1, c.toString());
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null,"Dato Eliminado","Correcto",JOptionPane.INFORMATION_MESSAGE,null);
                return true;
            } 
        } catch (SQLException ex) {     
          JOptionPane.showMessageDialog(null,"El dato esta vinculado a otros registro\nSolo puede Modificar el registro"
                  ,"Mensaje",JOptionPane.WARNING_MESSAGE,null);
        }finally{cn.cerrarConexion();}
        return false;
    }

    public List<Comedor> Mostrar() {
      List<Comedor> listar=new ArrayList<>();
        try {            
            Comedor d;ResultSet r;
            
            PreparedStatement pst=cn.getCon().prepareStatement(sql_select);
            r=pst.executeQuery();
            while(r.next()){  
                //user_id, cod_univ, dni, apellido, nombres, tipo_beca, facultad, escuela, huella_a, estado
                d=new Comedor();
                d.setId(r.getInt(1));
                listar.add(d);
            }       
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE,null);
        }
        finally{cn.cerrarConexion();}
       return listar;
    }

    public List<Comedor> Filtrar(Object c) {
     List<Comedor> listar=new ArrayList<>();
        try {            
            Comedor cli;ResultSet r;//codper, dni, nom, ape, sex, dir, tel, ruc
    String sqlf = "select s.user_id,s.cod_univ,u.dni,concat(u.apellido_paterno,' ',u.apellido_materno) as apellido,u.nombres,x.tipo_beca,f.facultad,e.escuela" +
    " from estudiantes s inner join expedientes x  inner join users u  inner join escuelas e inner join facultads f" +
    " on s.user_id=u.id and x.expediente=u.id and x.expediente=s.user_id and s.escuela_id=e.id and f.id=e.facultad_id "
    + "WHERE concat(u.apellido_paterno,' ',u.apellido_materno) like '"+c+"%' or concat(u.apellido_materno,' ',u.apellido_paterno) like '"+c+"%' or u.dni='"+c+"' or s.cod_univ='"+c+"';";
            PreparedStatement pst=cn.getCon().prepareStatement(sqlf);
            r=pst.executeQuery();
            while(r.next()){
              
                cli=new Comedor();
                cli.setId(r.getInt(1));
                listar.add(cli);
            }       
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje",JOptionPane.INFORMATION_MESSAGE,null);
        }
        finally{cn.cerrarConexion();}
       return listar;
    }
}
