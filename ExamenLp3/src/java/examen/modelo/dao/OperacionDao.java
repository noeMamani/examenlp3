/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.modelo.dao;

import examen.modelo.to.OperacionTO;
import examen.util.ConectarDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class OperacionDao {
    ConectarDB cnn = new ConectarDB();
    
    public List<OperacionTO> listarOperacion() throws Exception{
    ArrayList data=new ArrayList();
    String sql="SELECT * FROM operacion o,concepto c where  o.id_concepto=c.id_concepto and DATE_FORMAT(fecha,'%Y-%m-%d')=curdate()";
        try {
            cnn.conectar();
            ResultSet rs=cnn.ejecutarConsulta(sql);
            while (rs.next()) {                
                OperacionTO to= new OperacionTO();
                to.setId(rs.getInt("id"));
                to.setId_persona(rs.getInt("id_persona"));
                to.setId_sucursal(rs.getInt("id_sucursal"));
                to.setId_concepto(rs.getInt("id_concepto"));
                to.setComprobante(rs.getString("comprobante"));
                to.setNumero(rs.getString("numero"));
                to.setCantidad(rs.getInt("cantidad"));
                to.setDescripcion(rs.getString("descripcion"));
                to.setIngreso(rs.getDouble("ingreso"));
                to.setEgreso(rs.getDouble("egreso"));
                to.setFecha(rs.getString("fecha"));
                to.setDesc_con(rs.getString("desc_con"));
                data.add(to);
                
            }
            rs.close();
            cnn.desconectar();
        } catch (Exception e) {
        }
    return data;
    }

    public OperacionTO blanco()throws Exception {
         OperacionTO d = null;             
        try{                                                      
                d = new OperacionTO();
                d.setId(0);
                d.setId_persona(0);
                d.setId_sucursal(0);
                d.setId_concepto(0);
                d.setComprobante("");
                d.setNumero("");
                d.setCantidad(0);
                d.setDescripcion("");
                d.setIngreso(0.0);
                d.setEgreso(0.0);
                d.setFecha("");                             
        }catch(Exception e) {
            System.out.println(e.getMessage());           
        }
        return d;
  }

    public void eliminar(String id) throws Exception {
       System.out.println("esta llegando a este punto de eliminar   " + id);
        try {
            Connection c= cnn.conectar();
            String sql = "DELETE FROM operacion WHERE id= ?";
            PreparedStatement ps= c.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
            
        } catch (Exception e) {
            System.out.println("el error" +e.getMessage() );
            
           }finally{cnn.desconectar();}
            }
      public void agregar(OperacionTO data) throws Exception {
     String sql="INSERT INTO operacion (id_persona,id_sucursal,id_concepto,comprobante,numero,cantidad,descripcion,ingreso,egreso,fecha) VALUES (?,?,?,?,?,?,?,?,?,now())";      
      
     System.out.println("AQUI LLEGA O NAAAA " +data.getDescripcion() +" "+ data.getId());
     int i=0;
      Connection c=null;
      try{
        c=cnn.conectar();
        c.setAutoCommit(false);
        PreparedStatement ps = c.prepareStatement(sql);                    
        ps.setInt(++i, data.getId_persona());
        ps.setInt(++i, data.getId_sucursal());
        ps.setInt(++i, data.getId_concepto());
        ps.setString(++i, data.getComprobante());
        ps.setString(++i, data.getNumero());
        ps.setInt(++i, data.getCantidad()); 
        ps.setString(++i, data.getDescripcion());
        ps.setDouble(++i, data.getIngreso());
        ps.setDouble(++i, data.getEgreso());
        ps.executeUpdate();
        c.commit();
        ps.close();
       
     }catch(Exception e) {
        System.out.println( "este es mi problema"+e.getMessage());
        c.rollback();
     } finally{cnn.desconectar();}
  }

    public void modificar(OperacionTO p)  throws Exception  {
        try{
           Connection c = cnn.conectar();			
           String sql="UPDATE operacion SET id_persona=?,id_sucursal=?,id_consepto=?,comprobante=?,numero=?,cantidad=?,descripcion=?,ingreso=?,egreso=?,fecha=? WHERE id=?";
	   int i=0;
           PreparedStatement ps=c.prepareStatement(sql);
           ps.setInt(++i, p.getId_persona());
           ps.setInt(++i, p.getId_sucursal());
           ps.setInt(++i, p.getId_concepto());
           ps.setString(++i, p.getComprobante());
           ps.setString(++i, p.getNumero());
           ps.setInt(++i, p.getCantidad());                      
           ps.setString(++i, p.getDescripcion());
           ps.setDouble(++i, p.getIngreso());
           ps.setDouble(++i, p.getEgreso());                      
           ps.setString(++i, p.getFecha());
           String rpta = ps.executeUpdate()+ " *** Reg. Update *** ";
           System.out.println( rpta );
                
           ps.close();
           c.close();
                
        }catch(Exception e){
           System.out.println(e.getMessage());
        }finally{cnn.desconectar();}           
        throw new UnsupportedOperationException("Not yet implemented");
    }
      
    
    public OperacionTO buscarPorId(String id) throws Exception {
        OperacionTO d = null;
        
        String sql="SELECT * FROM operacion WHERE id=?";       
        try{   
            Connection c=cnn.conectar();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
                                        
            while (rs.next()) {
                d = new OperacionTO();
                //d.setId(rs.getInt("id"));
                d.setId_persona(rs.getInt("id_persona"));
                d.setId_sucursal(rs.getInt("id_sucursal"));
                d.setId_concepto(rs.getInt("id_concepto"));
                d.setComprobante(rs.getString("comprobante"));
                d.setNumero(rs.getString("numero"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setDescripcion(rs.getString("descripcion"));               
                d.setIngreso(rs.getDouble("ingreso")); 
                d.setEgreso(rs.getDouble("egreso"));
                d.setFecha(rs.getString("fecha"));               
                
            }                      
            rs.close();
            c.close();               
        }catch(Exception e) {
            System.out.println(e.getMessage());           
        }finally{cnn.desconectar();}
        return d;
    }
    
}
