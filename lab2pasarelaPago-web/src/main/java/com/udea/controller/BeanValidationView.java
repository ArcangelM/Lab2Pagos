/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.entity.Pago;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author arcangelmarinp
 */
@Named
public class BeanValidationView implements Serializable{
@EJB
    private com.udea.session.PagoManagerLocal pagoManager;
    
    /**
     * Creates a new instance of PagoMBean
     */
    
    private Pago pago; //para mostrar, actualizar o insertar en el formulario

    private String imagen;
    
    private int tipoTarjeta;
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    private List<Pago> pagos; //para visualizar en la tabla
    private String saludo= "hola esto es un saludo";
    
    
    @Size(min=2,max=10)
    private String id_cliente;
     
    @Size(min=2,max=80)
    private String nom_cliente;
    
   

    @Size(min=7,max=60)
    private String email_cliente;
    
     @Size(min=5,max=16)
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
      
   
   public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
   
   
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
    
     public String crearPago(){
      /*validando el captcha*/
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        FacesContext.getCurrentInstance().addMessage(null, msg); 
     /*se crea fecha actual*/
     
     LocalDateTime locaDate = LocalDateTime.now();
        int day= locaDate.getDayOfMonth();
        int month = locaDate.getMonthValue();
        int year=locaDate.getYear();
        int hours  = locaDate.getHour();
        int minutes = locaDate.getMinute();
        int seconds = locaDate.getSecond();
        /*Se crea Referencia de pago a partir de la fecha y tiempo actual mas id del cliente*/
     ref_pago=day+""+month+""+year+""+hours+""+minutes+""+seconds+id_cliente;
     fecha_pago=day+"-"+month+"-"+year;
     Pago pagoAcrear = new Pago();
     
     pagoAcrear.setIdCliente(id_cliente);
     pagoAcrear.setNomCliente(nom_cliente);
     pagoAcrear.setEmailCliente(email_cliente);
     pagoAcrear.setNumTarjeta(num_tarjeta);
     pagoAcrear.setCsvTarjeta(csv_tarjeta);
     pagoAcrear.setExpiracionTarj(expiracion_tarj);
     pagoAcrear.setTipoTarjeta(tipo_tarjeta);
     pagoAcrear.setValorPago(valor_pago);
     pagoAcrear.setRefPago(ref_pago);
     pagoAcrear.setFechaPago(fecha_pago);
     
     pagoManager.create(pagoAcrear);
     
     this.pago=pagoAcrear;
        return "CONFIRMADO";
     }
    
     public String cancelar(){
     
     return "VOLVER";
     }
     public String alInicio(){
     
     return "INICIO";
     }
     
     public void handleKeyEvent() {
         
         if (num_tarjeta.length()>=5){
             /*obtengo los primeros 5 digtos de la subcadena*/
             String subcadena = num_tarjeta.substring(0,5);
             int valor;
             valor = Integer.parseInt(subcadena);
             if (valor >= 11111 && valor<=22222){
                   tipo_tarjeta="AMERICAN EXPRESS";
                   this.imagen="img/american.png";
                   subcadena="";
             }else if(valor >= 33333 && valor<=44444){
                   tipo_tarjeta="DINERS";
                   this.imagen="img/diners.png";
                   subcadena="";
             }else if(valor >= 55555 && valor<=66666){
                   tipo_tarjeta="VISA";
                   this.imagen="img/visa.png";
                   subcadena="";
             }else if(valor >= 77777 && valor<=88888){
                   tipo_tarjeta="MASTERCARD";
                   this.imagen="img/mastercard.png";
                   subcadena="";
             }else{
                    tipo_tarjeta="OTRA";
                   this.imagen="img/otra.png";
                   subcadena="";
             }
             
         }
        
        
     }
    
    public BeanValidationView() {
    }
    
}
