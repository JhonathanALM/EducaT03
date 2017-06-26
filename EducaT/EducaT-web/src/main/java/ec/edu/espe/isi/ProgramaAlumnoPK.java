package ec.edu.espe.isi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que albergara la informacion respecto a los programas que puede tomar cada alumno.
 *
 * @author Solange 
 * @autor Jhonathan
 * @autor Victoria
 * @version 26/06/2017
 *
 */
@Embeddable 
public class ProgramaAlumnoPK implements Serializable 
{
    /**
     * propiedades de la entidad Capacitacion
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo del programa.
     */
    @Column(name = "COD_PROGRAMA")
    private String codPrograma;
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
    public ProgramaAlumnoPK() {
    }

    /**
     * Constructor para la clase ProgramaAlumnoPK
     * @param codPrograma El parametro codPrograma define el codigo del programa.
     * @param codAlumno El parametro codAlumno define el codigo del alumno dentro del programa.
     *
     */
    public ProgramaAlumnoPK(String codPrograma, String codAlumno) {
        this.codPrograma = codPrograma;
        this.codAlumno = codAlumno;
    }

    /**
     * Getters y Setters de cada atributo dentro de las clases
     *
     */
    public String getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(String codPrograma) {
        this.codPrograma = codPrograma;
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
        hash += (codPrograma != null ? codPrograma.hashCode() : 0);
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaAlumnoPK)) {
            return false;
        }
        ProgramaAlumnoPK other = (ProgramaAlumnoPK) object;
        if ((this.codPrograma == null && other.codPrograma != null) || (this.codPrograma != null && !this.codPrograma.equals(other.codPrograma))) {
            return false;
        }
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.ProgramaAlumnoPK[ codPrograma=" + codPrograma + ", codAlumno=" + codAlumno + " ]";
    }

}
