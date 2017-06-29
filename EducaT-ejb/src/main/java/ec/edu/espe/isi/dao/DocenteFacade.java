package ec.edu.espe.isi.dao;

import ec.edu.espe.isi.model.Docente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author jhona
 */
@Stateless 
public class DocenteFacade extends AbstractFacade<Docente> 
{

    @PersistenceContext(unitName = "ec.edu.espe.isi_EducaT-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteFacade() {
        super(Docente.class);
    }

}
