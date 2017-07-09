/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.isi.service;

import ec.edu.espe.isi.dao.AlumnoFacade;
import ec.edu.espe.isi.model.Alumno;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author jhonathan ALM
 */
@Stateless
@LocalBean
public class AlumnoServices {

    @EJB
    private AlumnoFacade alumnoFacade;

    public List<Alumno> obtenerAlumnos() {
        return this.alumnoFacade.findAll();
    }
}
