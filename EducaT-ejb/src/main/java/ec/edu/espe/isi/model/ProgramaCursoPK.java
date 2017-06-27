package ec.edu.espe.isi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que albergara la informacion respecto a los cursos que se tendra dentro de un programa.
 *
 * @author Solange 
 * @autor Jhonathan
 * @autor Victoria
 * @version 26/06/2017
 *
 */
@Embeddable 
public class ProgramaCursoPK implements Serializable 
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
    @Size(min = 1, max = 8)
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo unico de cada curso que se dara.
     */
    @Column(name = "COD_CURSO")
    private String codCurso;

    /**
     * Constructor por defecto
     *
     */
    public ProgramaCursoPK() {
    }

     /**
     * Constructor para la clase ProgramaCurso
     * @param codPrograma El parametor codPrograma dara el codigo unico del programa.
     * @param codCurso El parametor codCurso dara el codigo unico del curso dentro del programa.
     */
    public ProgramaCursoPK(String codPrograma, String codCurso) {
        this.codPrograma = codPrograma;
        this.codCurso = codCurso;
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

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    /**
     * Metodos @Override para comparaciones
     * 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrograma != null ? codPrograma.hashCode() : 0);
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaCursoPK)) {
            return false;
        }
        ProgramaCursoPK other = (ProgramaCursoPK) object;
        if ((this.codPrograma == null && other.codPrograma != null) || (this.codPrograma != null && !this.codPrograma.equals(other.codPrograma))) {
            return false;
        }
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.ProgramaCursoPK[ codPrograma=" + codPrograma + ", codCurso=" + codCurso + " ]";
    }

}
