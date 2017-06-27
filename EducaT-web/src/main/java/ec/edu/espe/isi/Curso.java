package ec.edu.espe.isi;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entidad que registra información referente a cada curso que oferta el instituto.
 * @author Solange
 * @autor Victoria
 * @author jhona
 */
@Entity 
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByCodCurso", query = "SELECT c FROM Curso c WHERE c.codCurso = :codCurso")
    , @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Curso.findByObjetivo", query = "SELECT c FROM Curso c WHERE c.objetivo = :objetivo")
    , @NamedQuery(name = "Curso.findByDescripcion", query = "SELECT c FROM Curso c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Curso.findByDuracion", query = "SELECT c FROM Curso c WHERE c.duracion = :duracion")
    , @NamedQuery(name = "Curso.findByEstado", query = "SELECT c FROM Curso c WHERE c.estado = :estado")})
public class Curso implements Serializable 
{
     /**
     * propiedades de la entidad Docente
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    
    /**
     * Propiedad de la entidad Curso que hace referencia  a la clave
     * primaria que corresponde al codigo del curso.
     */
    @Column(name = "COD_CURSO")
    private String codCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    
    /**
     * Propiedad de la entidad Curso que corresponde al nombre del curso.
     */
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 4000)
    
    /**
     * Propiedad de la entidad Curso que corresponde al objetivo del curso.
     */
    @Column(name = "OBJETIVO")
    private String objetivo;
    @Size(max = 4000)
    
    /**
     * Propiedad de la entidad Curso que corresponde a la descripción del curso.
     */
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad Curso que corresponde a la duración del curso en horas.
     */
    @Column(name = "DURACION")
    private short duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    
    /**
     * Propiedad de la entidad Curso que corresponde al estado activo o inactivo del curso. 
     */
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCurso")
    private Collection<Capacitacion> capacitacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<ProgramaCurso> programaCursoCollection;

    
    public Curso() {
    }

    /**
     * Constructor para la clase Curso.
     * @param codCurso El parámetro codCurso define el código del curso.
     */
    public Curso(String codCurso) {
        this.codCurso = codCurso;
    }
    

    /**
     * Constructor para la clase Curso
     * @param codCurso El parámetro codCurso define el código del curso.
     * @param nombre El parámetro nombre define el nombre del curso.
     * @param duracion El parámetro duación determina la duración en horas del curso.
     * @param estado El parámetro estado define el estado del curso, mismo que puede estar activo o inactivo.
     */
    public Curso(String codCurso, String nombre, short duracion, String estado) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estado = estado;
    }

    /**
     * Método que devuelve el código del curso (codCurso) 
     * @return el código del curso.
     */
    public String getCodCurso() {
        return codCurso;
    }

    /**
     * modifica el código del curso
     * @param codCurso 
     */
    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }
    
    /**
     * Método que devuelve el nombre del curso (nombre) 
     * @return el nombre del curso
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * modifica el nombre del curso.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el objetivo del curso (objetivo) 
     * @return el objetivo del curso
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * modifica el objetivo del curso.
     * @param objetivo 
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Método que devuelve la descripción del curso (descripcion) 
     * @return descripción del curso
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * modifica la descripcion del curso.
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método que devuelve la duración  del curso (duracion) 
     * @return el nombre del curso
     */
    public short getDuracion() {
        return duracion;
    }

    /**
     * modifica la duración del curso.
     * @param duracion 
     */
    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    /**
     * Método que devuelve el estado del curso (estado) 
     * @return el nombre del curso
     */
    public String getEstado() {
        return estado;
    }

    /**
     * modifica el estado del curso.
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Capacitacion> getCapacitacionCollection() {
        return capacitacionCollection;
    }

    public void setCapacitacionCollection(Collection<Capacitacion> capacitacionCollection) {
        this.capacitacionCollection = capacitacionCollection;
    }

    @XmlTransient
    public Collection<ProgramaCurso> getProgramaCursoCollection() {
        return programaCursoCollection;
    }

    public void setProgramaCursoCollection(Collection<ProgramaCurso> programaCursoCollection) {
        this.programaCursoCollection = programaCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.Curso[ codCurso=" + codCurso + " ]";
    }

}
