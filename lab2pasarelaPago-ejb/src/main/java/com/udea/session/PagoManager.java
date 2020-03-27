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

    
}
