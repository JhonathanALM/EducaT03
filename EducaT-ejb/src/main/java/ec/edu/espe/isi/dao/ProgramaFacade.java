/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.isi.dao;

import ec.edu.espe.isi.model.Programa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author solan
 */
@Stateless
public class ProgramaFacade extends AbstractFacade<Programa> {

    @PersistenceContext(unitName = "ec.edu.espe.isi_EducaT-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaFacade() {
        super(Programa.class);
    }
    
}
