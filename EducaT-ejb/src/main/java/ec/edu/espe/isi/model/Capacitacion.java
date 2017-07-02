package ec.edu.espe.isi.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase que albergara la informacion respecto a la capacitaciones que tendremos dentro de nuestro instituto educativo.
 *
 * @author Solange 
 * @author Jhonathan
 * @author Victoria
 * @version 26/06/2017
 *
 */
@Entity 
@Table(name = "capacitacion")
public class Capacitacion implements Serializable 
{
    /**
     * propiedades de la entidad Capacitacion
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo de identificacion de la capacitacion.
     */
    @Column(name = "COD_CAPACITACION")
    private Integer codCapacitacion;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que hace referencia al atributo que corresponde
     * a la fecha de inicio de la capacitacion.
     */
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que hace referencia al atributo que corresponde
     * a la fecha de fin de la capacitacion.
     */
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que hace referencia al atributo que corresponde
     * al estado de la capacitacion.
     */
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que hace referencia al atributo que corresponde
     * a la capacidad de inicio de la capacitacion.
     */
    @Column(name = "CAPACIDAD")
    private short capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private Collection<CapacitacionAlumno> capacitacionAlumnoCollection;
    @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO")
    @ManyToOne(optional = false)
    private Curso codCurso;
    @JoinColumn(name = "COD_DOCENTE", referencedColumnName = "COD_DOCENTE")
    @ManyToOne
    private Docente codDocente;

    /**
     * Constructor por defecto
     *
     */
    public Capacitacion() {
    }
    
    /**
     * Constructor para la clase Capacitacion
     * @param codCapacitacion El parametor codCapacitacion define el codigo de la capacitacion.
     *
     */
    public Capacitacion(Integer codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    /**
     * Constructor para la clase Capacitacion
     * @param codCapacitacion El parametro codCapacitacion define el codigo de la capacitacion.
     * @param fechaInicio define la fecha de inicio de la capacitacion.
     * @param fechaFin define la fecha de fin de la capacitacion.
     * @param estado define el estado en el que se encuentra la capacitacion.
     * @param capacidad define la capacidad que tiene la capacitacion.
     */
    public Capacitacion(Integer codCapacitacion, Date fechaInicio, Date fechaFin, String estado, short capacidad) {
        this.codCapacitacion = codCapacitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    /**
     * Getters y Setters de cada atributo dentro de las clases
     *
     */
    public Integer getCodCapacitacion() {
        return codCapacitacion;
    }

    public void setCodCapacitacion(Integer codCapacitacion) {
        this.codCapacitacion = codCapacitacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public Collection<CapacitacionAlumno> getCapacitacionAlumnoCollection() {
        return capacitacionAlumnoCollection;
    }

    public void setCapacitacionAlumnoCollection(Collection<CapacitacionAlumno> capacitacionAlumnoCollection) {
        this.capacitacionAlumnoCollection = capacitacionAlumnoCollection;
    }

    public Curso getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Curso codCurso) {
        this.codCurso = codCurso;
    }

    public Docente getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Docente codDocente) {
        this.codDocente = codDocente;
    }

    /**
     * Metodos Override para comparaciones
     * 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCapacitacion != null ? codCapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.codCapacitacion == null && other.codCapacitacion != null) || (this.codCapacitacion != null && !this.codCapacitacion.equals(other.codCapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.Capacitacion[ codCapacitacion=" + codCapacitacion + " ]";
    }

}
