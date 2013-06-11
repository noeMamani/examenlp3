/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.actions;

import com.opensymphony.xwork2.ActionSupport;
import examen.util.ConectarDB;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AngelDX
 */
public class ReportesAction extends ActionSupport {
    private String mes;
    private String año;    
    ConectarDB con=new ConectarDB();
    Connection cnn=null;
    private Map<String,Object> params;
       
    @Override
    public String execute() throws Exception {
        cnn=con.conectar();
                     
        return SUCCESS;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public ConectarDB getCon() {
        return con;
    }

    public void setCon(ConectarDB con) {
        this.con = con;
    }
        
    
}
