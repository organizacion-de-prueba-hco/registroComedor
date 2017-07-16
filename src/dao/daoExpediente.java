package dao;

import entities.Expediente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Conexion;

/**
 *
 * @author Jhon
 */
public class daoExpediente {
    //dni, nom, ape, email, tel, huella
    public String sql_insert="insert into expedientes values(?,?,?,?,?,?);";
    public String sql_update="update expedientes set huella_a=? where expediente=?;";
    public String sql_delete="delete from expedientes where dni=?;";
    public String sql_select="select s.user_id,s.cod_univ,u.dni,concat(u.apellido_paterno,' ',u.apellido_materno) as apellido,u.nombres,x.tipo_beca,f.facultad,e.escuela" +
    " from estudiantes s inner join expedientes x  inner join users u  inner join escuelas e inner join facultads f" +
    " on s.user_id=u.id and x.expediente=u.id and x.expediente=s.user_id and s.escuela_id=e.id and f.id=e.facultad_id;";
    public String sql_filter="select *from expedientes where nombre like ''";
    private static final Conexion cn=Conexion.saberEstado();

  /*  public boolean Guardar(Expediente c) {
      PreparedStatement ps;
        try {            
            ps=cn.getCon().prepareStatement(sql_insert);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getApe());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getTel());
            //ps.setBinaryStream(6, c.getH1());
            ps.setBinaryStream(6, c.getH1());
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
*/
   public boolean Editar(Expediente c,Object key) {
     PreparedStatement ps;
        try {            
            ps=cn.getCon().prepareStatement(sql_update);
            ps.setBinaryStream(1, c.getH1());
            ps.setString(2, key.toString());
            if (ps.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null,"Huella Regsitrado","Correcto",JOptionPane.INFORMATION_MESSAGE,null);
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

    public List<Expediente> Mostrar() {
      List<Expediente> listar=new ArrayList<>();
        try {            
            Expediente cli;ResultSet r;
            
            PreparedStatement pst=cn.getCon().prepareStatement(sql_select);
            r=pst.executeQuery();
            while(r.next()){
                
                cli=new Expediente();
                cli.setId(r.getString(1));
                cli.setCod(r.getString(2));
                cli.setDni(r.getString(3));
                cli.setApe(r.getString(4));                
                cli.setNom(r.getString(5));
                cli.setBeca(r.getString(6));
                cli.setFac(r.getString(7));
                cli.setEp(r.getString(8));
                //cli.setH1((ByteArrayInputStream) r.getBinaryStream(6));
              //  cli.setH1(r.getBinaryStream(6), 1);
                listar.add(cli);
            }       
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje",JOptionPane.WARNING_MESSAGE,null);
        }
        finally{cn.cerrarConexion();}
       return listar;
    }

    public List<Expediente> Filtrar(Object c) {
     List<Expediente> listar=new ArrayList<>();
        try {            
            Expediente cli;ResultSet r;//codper, dni, nom, ape, sex, dir, tel, ruc
    String sqlf = "select s.user_id,s.cod_univ,u.dni,concat(u.apellido_paterno,' ',u.apellido_materno) as apellido,u.nombres,x.tipo_beca,f.facultad,e.escuela" +
    " from estudiantes s inner join expedientes x  inner join users u  inner join escuelas e inner join facultads f" +
    " on s.user_id=u.id and x.expediente=u.id and x.expediente=s.user_id and s.escuela_id=e.id and f.id=e.facultad_id "
    + "WHERE concat(u.apellido_paterno,' ',u.apellido_materno) like '"+c+"%' or concat(u.apellido_materno,' ',u.apellido_paterno) like '"+c+"%' or u.dni='"+c+"' or s.cod_univ='"+c+"';";
            PreparedStatement pst=cn.getCon().prepareStatement(sqlf);
            r=pst.executeQuery();
            while(r.next()){
              
                cli=new Expediente();
                cli.setId(r.getString(1));
                cli.setCod(r.getString(2));
                cli.setDni(r.getString(3));
                cli.setApe(r.getString(4));                
                cli.setNom(r.getString(5));
                cli.setBeca(r.getString(6));
                cli.setFac(r.getString(7));
                cli.setEp(r.getString(8));
                listar.add(cli);
            }       
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje",JOptionPane.INFORMATION_MESSAGE,null);
        }
        finally{cn.cerrarConexion();}
       return listar;
    }
}
