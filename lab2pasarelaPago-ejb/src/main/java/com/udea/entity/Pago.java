/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arcangelmarinp
 */
@Entity
@Table(name = "PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago")
    , @NamedQuery(name = "Pago.findByIdCliente", query = "SELECT p FROM Pago p WHERE p.idCliente = :idCliente")
    , @NamedQuery(name = "Pago.findByNomCliente", query = "SELECT p FROM Pago p WHERE p.nomCliente = :nomCliente")
    , @NamedQuery(name = "Pago.findByEmailCliente", query = "SELECT p FROM Pago p WHERE p.emailCliente = :emailCliente")
    , @NamedQuery(name = "Pago.findByNumTarjeta", query = "SELECT p FROM Pago p WHERE p.numTarjeta = :numTarjeta")
    , @NamedQuery(name = "Pago.findByCsvTarjeta", query = "SELECT p FROM Pago p WHERE p.csvTarjeta = :csvTarjeta")
    , @NamedQuery(name = "Pago.findByTipoTarjeta", query = "SELECT p FROM Pago p WHERE p.tipoTarjeta = :tipoTarjeta")
    , @NamedQuery(name = "Pago.findByExpiracionTarj", query = "SELECT p FROM Pago p WHERE p.expiracionTarj = :expiracionTarj")
    , @NamedQuery(name = "Pago.findByValorPago", query = "SELECT p FROM Pago p WHERE p.valorPago = :valorPago")
    , @NamedQuery(name = "Pago.findByFechaPago", query = "SELECT p FROM Pago p WHERE p.fechaPago = :fechaPago")
    , @NamedQuery(name = "Pago.findByRefPago", query = "SELECT p FROM Pago p WHERE p.refPago = :refPago")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PAGO")
    private Integer idPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ID_CLIENTE")
    private String idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOM_CLIENTE")
    private String nomCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "EMAIL_CLIENTE")
    private String emailCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "NUM_TARJETA")
    private String numTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CSV_TARJETA")
    private String csvTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPO_TARJETA")
    private String tipoTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EXPIRACION_TARJ")
    private String expiracionTarj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_PAGO")
    private double valorPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FECHA_PAGO")
    private String fechaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "REF_PAGO")
    private String refPago;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Pago(Integer idPago, String idCliente, String nomCliente, String emailCliente, String numTarjeta, String csvTarjeta, String tipoTarjeta, String expiracionTarj, double valorPago, String fechaPago, String refPago) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.nomCliente = nomCliente;
        this.emailCliente = emailCliente;
        this.numTarjeta = numTarjeta;
        this.csvTarjeta = csvTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.expiracionTarj = expiracionTarj;
        this.valorPago = valorPago;
        this.fechaPago = fechaPago;
        this.refPago = refPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getCsvTarjeta() {
        return csvTarjeta;
    }

    public void setCsvTarjeta(String csvTarjeta) {
        this.csvTarjeta = csvTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getExpiracionTarj() {
        return expiracionTarj;
    }

    public void setExpiracionTarj(String expiracionTarj) {
        this.expiracionTarj = expiracionTarj;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getRefPago() {
        return refPago;
    }

    public void setRefPago(String refPago) {
        this.refPago = refPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Pago[ idPago=" + idPago + " ]";
    }
    
}
