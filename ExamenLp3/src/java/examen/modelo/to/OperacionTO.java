/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.modelo.to;

import java.util.Date;


/**
 *
 * @author Alumno
 */
public class OperacionTO {

 
 private int id;
  int id_persona;
  int id_sucursal;
  int id_concepto;
  String comprobante;
  String numero;
  int cantidad;
  String descripcion;
  Double ingreso;
  Double egreso;
  String fecha;
  String  desc_con;//campo de mas para abrir el campo dec_con
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDesc_con() {
        return desc_con;
    }

    public void setDesc_con(String desc_con) {
        this.desc_con = desc_con;
    }
  

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

   

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

   
    public int getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(int id_concepto) {
        this.id_concepto = id_concepto;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getIngreso() {
        return ingreso;
    }

    public void setIngreso(Double ingreso) {
        this.ingreso = ingreso;
    }

    public Double getEgreso() {
        return egreso;
    }

    public void setEgreso(Double egreso) {
        this.egreso = egreso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   
    
  
}
