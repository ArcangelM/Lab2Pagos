/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.entity.Pago;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author arcangelmarinp
 */

public class PagoMBean implements Serializable {

    @EJB
    private com.udea.session.PagoManagerLocal pagoManager;
    
    /**
     * Creates a new instance of PagoMBean
     */
    
    
    private Pago pago; //para mostrar, actualizar o insertar en el formulario
    private List<Pago> pagos; //para visualizar en la tabla
    private String saludo= "hola esto es un saludo";
    
    public String getSaludo(){
        return saludo;
    }
    
    public PagoMBean() {
    }
    //retorna una lista de clientes para mostrar en un datatable de JSF

    public List<Pago> getPagos() {
        if ((pagos == null) || (pagos.isEmpty())) {
            refresh();
        }
        return pagos;
    }
    
    public Pago getDetails() {
        return pago;
    }
    public Pago getPago() {
        return pago;
    }
    
    private void refresh() {
        this.pagos = pagoManager.getAllPagos();
    }
    
    public String showDetails(Pago pago) {
        this.pago = pago;
        
        return "PAGAR"; // Permite enlazar a pago.xhtml
    }
    
    public String pagar() {
        
        return "PAGAR"; // Permite enlazar a pago.xhtml
    }

    
    public String listPagos() {
        
        return "PAGOS"; // Permite enlazar a pago.xhtml
    }
   
    public String volverPagos(){
    return "VOLVERAPAGOS";
    }
}
