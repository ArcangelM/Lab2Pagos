/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Pago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author arcangelmarinp
 */
@Local
public interface PagoManagerLocal {

    List<Pago> getAllPagos();

    void create(Pago pago);
    
}
