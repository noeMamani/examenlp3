/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.modelo.dao;

import examen.modelo.to.PersonaTO;
import examen.util.ConectarDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */
public class PersonaDao {

    ConectarDB cnn = new ConectarDB();

    public PersonaTO buscarAlumnoId(String us, String pas) {

        PersonaTO alumno = new PersonaTO();
        String sql = "select * from persona "
                + "where  usu_pe=? and pas_pe=?";
        System.out.println("los datos de entrada son" +us+" y "+pas);
        try {
            Connection c = cnn.conectar();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, us);
            ps.setString(2, pas);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
System.out.println("imprime nombre"+rs.getString("nom_pe"));
                alumno.setUsu_pe(rs.getString("usu_pe"));
                alumno.setPas_pe(rs.getString("pas_pe"));
                alumno.setNom_pe(rs.getString("nom_pe"));

            } else {


                alumno.setNom_pe("");
                alumno.setPas_pe("");
                alumno.setUsu_pe("");

            }

System.out.println("aca datos de la impresion"+alumno.getNom_pe()+" "+alumno.getUsu_pe());
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
     
        return alumno;
    }
    
}
