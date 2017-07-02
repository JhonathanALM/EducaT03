package ec.edu.espe.isi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que albergara la informacion respecto a  la capacitacion que tiene una alumno.
 *
 * @author Solange 
 * @author Jhonathan
 * @author Victoria
 * @version 26/06/2017
 *
 */
@Embeddable 
public class CapacitacionAlumnoPK implements Serializable 
{

    /**
     * propiedades de la entidad Capacitacion
     */
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo de identificacion de la capacitacion.
     */
    @Column(name = "COD_CAPACITACION")
    private int codCapacitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo del alumno que tomara el programa.
     */
    @Column(name = "COD_ALUMNO")
    private String codAlumno;

    /**
     * Constructor por defecto
     *
     */
    public CapacitacionAlumnoPK() {
    }

    /**
     * Constructor para la clase CapacitacionAlumnoPK
     * @param codCapacitacion El parametor codCapacitacion define el codigo de la capacitacion.
     * @param codAlumno El parametro codAlumno define el codigo del alumno dentro del programa.
     */
    public CapacitacionAlumnoPK(int codCapacitacion, String codAlumno) {
        this.codCapacitacion = codCapacitacion;
        this.codAlumno = codAlumno;
    }

    /**
     * Getters y Setters de cada atributo dentro de las clases
     *
     */
    public int getCodCapacitacion() {
        return codCapacitacion;
    }

    public void setCodCapacitacion(int codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    /**
     * Metodos @Override para comparaciones
     * 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCapacitacion;
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionAlumnoPK)) {
            return false;
        }
        CapacitacionAlumnoPK other = (CapacitacionAlumnoPK) object;
        if (this.codCapacitacion != other.codCapacitacion) {
            return false;
        }
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.CapacitacionAlumnoPK[ codCapacitacion=" + codCapacitacion + ", codAlumno=" + codAlumno + " ]";
    }

}
