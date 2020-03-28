/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Pago;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author arcangelmarinp
 */
@Stateless
public class PagoManager implements PagoManagerLocal {

    @PersistenceContext(unitName = "com.udea_lab2pasarelaPago-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
//Metodo que devolvera todos los pagos
    @Override
    public List<Pago> getAllPagos() {
        Query query= em.createNamedQuery("Pago.findAll");
        return query.getResultList();
    }

   
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void create(Pago pago) {
      em.createNativeQuery("INSERT INTO pago (id_cliente, nom_cliente, email_cliente, num_tarjeta,"+
          "csv_tarjeta, tipo_tarjeta, expiracion_tarj, valor_pago, fecha_pago, ref_pago) VALUES (?,?,?,?,?,?,?,?,?,?)")
      .setParameter(1,pago.getIdCliente())
      .setParameter(2,pago.getNomCliente())
      .setParameter(3,pago.getEmailCliente())
      .setParameter(4,pago.getNumTarjeta())
      .setParameter(5,pago.getCsvTarjeta())
      .setParameter(6,pago.getTipoTarjeta())
      .setParameter(7,pago.getExpiracionTarj())
      .setParameter(8,pago.getValorPago())
      .setParameter(9,pago.getFechaPago())
      .setParameter(10,pago.getRefPago())
      .executeUpdate();;
        
        
    }

    
}
