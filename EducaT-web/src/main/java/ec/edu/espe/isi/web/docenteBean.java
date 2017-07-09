/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.isi.web;
import ec.edu.espe.isi.model.Docente;
import ec.edu.espe.isi.service.DocenteServices;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author vicky
 */
@ManagedBean
@ViewScoped
public class docenteBean {
    @EJB
    private DocenteServices docenteservice;
    private List<Docente> docentes;
    @PostConstruct
    public void inicio() {
        this.docentes=this.docenteservice.obtenerDocentes();
    }
       public List<Docente> getDocentes() {
        return docentes;
    }
}
