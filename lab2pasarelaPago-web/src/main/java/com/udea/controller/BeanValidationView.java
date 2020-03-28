/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.entity.Pago;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author arcangelmarinp
 */
public class BeanValidationView implements Serializable{
@EJB
    private com.udea.session.PagoManagerLocal pagoManager;
    
    /**
     * Creates a new instance of PagoMBean
     */
    
    private Pago pago; //para mostrar, actualizar o insertar en el formulario
    private List<Pago> pagos; //para visualizar en la tabla
    private String saludo= "hola esto es un saludo";
    
    
    @Size(min=2,max=10)
    private String id_cliente;
     
    @Size(min=2,max=80)
    private String nom_cliente;
    
   

    @Size(min=7,max=60)
    private String email_cliente;
    
     @Size(min=16,max=16)
    private String num_tarjeta;
    
     @Size(min=3,max=3)
    private String csv_tarjeta;
        
      @Size(min=4,max=30)
    private String tipo_tarjeta;  
      
     @Size(min=5,max=10)
    private String expiracion_tarj;
     
    @Min(500) @Max(10000) @NotNull
    private Double valor_pago;
     
     
    private String fecha_pago;
     
   private String ref_pago;
      
    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    
    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getCsv_tarjeta() {
        return csv_tarjeta;
    }

    public void setCsv_tarjeta(String csv_tarjeta) {
        this.csv_tarjeta = csv_tarjeta;
    }

    public String getTipo_tarjeta() {
        return tipo_tarjeta;
    }

    public void setTipo_tarjeta(String tipo_tarjeta) {
        this.tipo_tarjeta = tipo_tarjeta;
    }

    public String getExpiracion_tarj() {
        return expiracion_tarj;
    }

    public void setExpiracion_tarj(String expiracion_tarj) {
        this.expiracion_tarj = expiracion_tarj;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }
     
    
 
    public String getNom_cliente() {
        return nom_cliente;
    }
    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }
 
    
    public String getSaludo(){
        return saludo;
    }
    
    
    //retorna una lista de clientes para mostrar en un datatable de JSF

    public List<Pago> getPagos() {
        if ((pagos == null) || (pagos.isEmpty())) {
            refresh();
        }
        return pagos;
    }
    
    
    
    private void refresh() {
        this.pagos = pagoManager.getAllPagos();
    }
    
     
    
    
    public BeanValidationView() {
    }
    
}
