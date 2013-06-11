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
                to.setId_operacion(rs.getInt("id"));
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
                d.setId_operacion(0);
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
      
    
}
