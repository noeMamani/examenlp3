/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.util;

import java.sql.*;
/**
 *
 * @author AngelDX
 */
public class ConectarDB {
      public Connection cn=null;
  public Statement st=null;
  public ResultSet rs=null;  
  
  public Connection conectar() throws Exception{
      
      String servidor="localhost";
      String puerto="3306";
      String usuario="root";
      String password="123456";
      String basedatos="dbingresos";
      String driver="com.mysql.jdbc.Driver";
      String cadenaconexion="jdbc:mysql://"+servidor+":"+puerto+"/"+basedatos;
      
      Class.forName(driver);      
      cn=DriverManager.getConnection(cadenaconexion,usuario,password); 
      return cn;
  }
  
  public ResultSet ejecutarConsulta(String sql) throws Exception{
      st=cn.createStatement();
      rs=st.executeQuery(sql);
      return rs;
  }
  
  public void ejecutarActualizacion(String sql) throws Exception{
      st=cn.createStatement();
      st.executeUpdate(sql);
  }
  
  public void desconectar() throws Exception{
      cn.close();
  }
}
