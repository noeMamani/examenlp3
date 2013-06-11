/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.actions;

import com.opensymphony.xwork2.ActionSupport;
import examen.modelo.dao.PersonaDao;
import examen.modelo.to.PersonaTO;

/**
 *
 * @author Alumno
 */
public class VerificarLogin extends ActionSupport {
    
    private String usuario;
    private String password;
    private String nombre;
    PersonaDao us= new PersonaDao();
    PersonaTO to= new PersonaTO();
    
    public VerificarLogin() {
    }
    
    @Override
    public String execute() throws Exception {
        to=us.buscarAlumnoId(usuario, password);
        nombre=to.getNom_pe();
        if(!nombre.equals("")){
        return  SUCCESS;
        }
        return ERROR;
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PersonaDao getUs() {
        return us;
    }

    public void setUs(PersonaDao us) {
        this.us = us;
    }

    public PersonaTO getTo() {
        return to;
    }

    public void setTo(PersonaTO to) {
        this.to = to;
    }


    
}
