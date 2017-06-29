/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.isi.dao;

import ec.edu.espe.isi.model.Capacitacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Victoria
 */
@Stateless
public class CapacitacionFacade extends AbstractFacade<Capacitacion> {

    @PersistenceContext(unitName = "ec.edu.espe.isi_EducaT-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapacitacionFacade() {
        super(Capacitacion.class);
    }
    
}
