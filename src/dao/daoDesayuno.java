package dao;

import entities.Desayuno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Conexion;

/**
 *
 * @author Jhon
 */
public class daoDesayuno {
    //dni, nom, ape, email, tel, huella  INSERT INTO `pbu`.`desayunos` (`comedor_id`, `expediente_id`, `created_at`) VALUES ('10', '8', '2017-02-02 10:43:23');
    public String sql_insert="INSERT INTO desayunos (`comedor_id`, `expediente_id`, `created_at`) values(?,?,?);";
    public String sql_update="update expedientes set huella_a=? where expediente=?;";
    public String sql_delete="delete from expedientes where dni=?;";
    public String sql_select="select s.user_id,s.cod_univ,u.dni,concat(u.apellido_paterno,' ',u.apellido_materno) as apellido,u.nombres,x.tipo_beca," +
    "f.facultad,e.escuela,x.huella_a,x.estado from estudiantes s inner join expedientes x  inner join users u  inner join escuelas e " +
    "inner join facultads f inner join desayunos d inner join  comedors c on s.user_id=u.id and d.comedor_id=c.id " +
    "and x.expediente=u.id and x.expediente=s.user_id and s.escuela_id=e.id and f.id=e.facultad_id and d.expediente_id=x.expediente where c.estado='activo';";
    public String sql_filter="select *from expedientes where nombre like ''";
    private static final Conexion cn=Conexion.saberEstado();
    
    public boolean Guardar(Desayuno c) {
      PreparedStatement ps;
        try {            
            ps=cn.getCon().prepareStatement(sql_insert);
            ps.setString(1, c.getComid());
            ps.setString(2, c.getExpid());
            ps.setString(3, c.getFs());
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

   public boolean Editar(Desayuno c,Object key) {
     PreparedStatement ps;
        try {            
            ps=cn.getCon().prepareStatement(sql_insert);
            ps.setString(1, c.getId());
            ps.setString(2, c.getComid());
            ps.setString(3, c.getExpid());
            ps.setDate(4, new java.sql.Date(c.getCreated().getTime()));
            ps.setDate(4, new java.sql.Date(c.getUpdated().getTime()));
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

    public List<Desayuno> Mostrar() {
      List<Desayuno> listar=new ArrayList<>();
        try {            
            Desayuno d;ResultSet r;
            
            PreparedStatement pst=cn.getCon().prepareStatement(sql_select);
            r=pst.executeQuery();
            while(r.next()){  
                //user_id, cod_univ, dni, apellido, nombres, tipo_beca, facultad, escuela, huella_a, estado
                d=new Desayuno();
                d.setIdx(r.getString(1));
                d.setCodx(r.getString(2));
                d.setDnix(r.getString(3));
                d.setApex(r.getString(4));
                d.setNomx(r.getString(5));
                d.setBecax(r.getString(6));
                d.setFacx(r.getString(7));  
                d.setEpx(r.getString(8));
                listar.add(d);
            }       
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE,null);
        }
        finally{cn.cerrarConexion();}
       return listar;
    }

    public List<Desayuno> Filtrar(Object c) {
     List<Desayuno> listar=new ArrayList<>();
        try {            
            Desayuno cli;ResultSet r;//codper, dni, nom, ape, sex, dir, tel, ruc
    String sqlf = "select s.user_id,s.cod_univ,u.dni,concat(u.apellido_paterno,' ',u.apellido_materno) as apellido,u.nombres,x.tipo_beca,f.facultad,e.escuela" +
    " from estudiantes s inner join expedientes x  inner join users u  inner join escuelas e inner join facultads f" +
    " on s.user_id=u.id and x.expediente=u.id and x.expediente=s.user_id and s.escuela_id=e.id and f.id=e.facultad_id "
    + "WHERE concat(u.apellido_paterno,' ',u.apellido_materno) like '"+c+"%' or concat(u.apellido_materno,' ',u.apellido_paterno) like '"+c+"%' or u.dni='"+c+"' or s.cod_univ='"+c+"';";
            PreparedStatement pst=cn.getCon().prepareStatement(sqlf);
            r=pst.executeQuery();
            while(r.next()){
              
                cli=new Desayuno();
                cli.setId(r.getString(1));
                listar.add(cli);
            }       
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje",JOptionPane.INFORMATION_MESSAGE,null);
        }
        finally{cn.cerrarConexion();}
       return listar;
    }
}
