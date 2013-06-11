/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import examen.modelo.dao.OperacionDao;
import examen.modelo.to.OperacionTO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
 
/**
 *
 * @author Alumno
 */
public class OperacionAction extends ActionSupport implements ModelDriven<OperacionTO> {
    OperacionTO operacion = new OperacionTO();
    OperacionDao dao= new OperacionDao();
    List<OperacionTO> lista= new ArrayList<OperacionTO>();
    private String mensaje="";
    
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
  //aca una modificacio
        
    }

    @Override
    public OperacionTO getModel() {
    return  operacion;  
    }
    
  public  String list() throws Exception{
      lista=dao.listarOperacion();
      return SUCCESS;
    
    }
   public String blank()throws Exception {       
        operacion=dao.blanco();      
        return SUCCESS;
    }
   
      public String del() throws Exception{
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        dao.eliminar(request.getParameter("id"));
        return SUCCESS;
    }
    ///jajajaj conforme man yayayay
    public String add() throws Exception {
        System.out.println(operacion.getId());
        if(operacion.getId()==(0)){
            dao.agregar(operacion);
            System.out.println("siiiiiiiiiiii lleeeegaaaaaaa");
        }else{
            dao.modificar(operacion);
        }        
        return SUCCESS;
    }

       public String edit()throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        System.out.println(request.getParameter("id"));
        operacion=dao.buscarPorId(request.getParameter("id"));                               
        return SUCCESS;
    } 
    public OperacionTO getOperacion() {
        return operacion;
    }

    public void setOperacion(OperacionTO operacion) {
        this.operacion = operacion;
    }

    public OperacionDao getDao() {
        return dao;
    }

    public void setDao(OperacionDao dao) {
        this.dao = dao;
    }

    public List<OperacionTO> getLista() {
        return lista;
    }

    public void setLista(List<OperacionTO> lista) {
        this.lista = lista;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
  
    
}
