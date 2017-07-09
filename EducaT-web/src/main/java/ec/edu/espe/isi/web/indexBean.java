package ec.edu.espe.isi.web;
import ec.edu.espe.isi.model.Alumno;
import ec.edu.espe.isi.service.AlumnoServices;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author jhona
 */
@ManagedBean
@ViewScoped
public class indexBean {
    @EJB
    private AlumnoServices alumnoservice;
    private List<Alumno> alumnos;
    @PostConstruct
    public void inicio() {
        this.alumnos = this.alumnoservice.obtenerAlumnos();
    }

    public List<Alumno> getAlumnos() {
        
        return alumnos;
    }

}
