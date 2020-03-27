package com.udea.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2020-03-27T01:32:47")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, String> nomCliente;
    public static volatile SingularAttribute<Pago, String> emailCliente;
    public static volatile SingularAttribute<Pago, String> expiracionTarj;
    public static volatile SingularAttribute<Pago, String> idCliente;
    public static volatile SingularAttribute<Pago, String> tipoTarjeta;
    public static volatile SingularAttribute<Pago, Integer> idPago;
    public static volatile SingularAttribute<Pago, String> numTarjeta;
    public static volatile SingularAttribute<Pago, Double> valorPago;
    public static volatile SingularAttribute<Pago, String> csvTarjeta;
    public static volatile SingularAttribute<Pago, String> fechaPago;
    public static volatile SingularAttribute<Pago, String> refPago;

}