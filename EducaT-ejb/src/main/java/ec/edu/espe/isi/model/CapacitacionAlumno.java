package ec.edu.espe.isi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * Clase que albergara la informacion respecto a la capacitaciones que tendra cada alumnol alumno que tendremos dentro de nuestro instituto educativo.
 *
 * @author Solange 
 * @autor Jhonathan
 * @autor Victoria
 * @version 26/06/2017
 *
 */
@Entity 
@Table(name = "capacitacion_alumno")
public class CapacitacionAlumno implements Serializable 
{

    /**
     * propiedades de la entidad CapacitacionAlumno
     */
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionAlumnoPK capacitacionAlumnoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que hace referencia al atributo que corresponde
     * a la nota final de la capacitacion que recibio el alumno.
     */
    @Column(name = "NOTA_FINAL")
    private BigDecimal notaFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    
    /**
     * Propiedad de la entidad que hace referencia al atributo que corresponde
     * al estado de capacitacion que recibio el alumno.
     */
    @Column(name = "ESTADO")
    private String estado;
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo de identificacion del alumno de la capacitacion recibida.
     */
    @JoinColumn(name = "COD_ALUMNO", referencedColumnName = "COD_ALUMNO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo de identificacion de la capacitacion recibida.
     */
    @JoinColumn(name = "COD_CAPACITACION", referencedColumnName = "COD_CAPACITACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Capacitacion capacitacion;

    /**
     * Constructor por defecto
     *
     */
    public CapacitacionAlumno() {
    }

    /**
     * Constructor para la clase CapacitacionAlumno
     * @param capacitacionAlumnoPK El parametor capacitacionAlumnoPK es para definir la clave primaria.
     *
     */
    public CapacitacionAlumno(CapacitacionAlumnoPK capacitacionAlumnoPK) {
        this.capacitacionAlumnoPK = capacitacionAlumnoPK;
    }

    /**
     * Constructor para la clase CapacitacionAlumno
     * @param capacitacionAlumnoPK El parametro capacitacionAlumnoPK es para definir la clave primaria.
     * @param notaFinal El parametro notaFinal dara la nota con la que el alumno termino el curso.
     * @param estado El parametro estado dara el estado de la capacitacion.
     */
    public CapacitacionAlumno(CapacitacionAlumnoPK capacitacionAlumnoPK, BigDecimal notaFinal, String estado) {
        this.capacitacionAlumnoPK = capacitacionAlumnoPK;
        this.notaFinal = notaFinal;
        this.estado = estado;
    }

    /**
     * Getters y Setters de cada atributo dentro de las clases
     *
     */
    public CapacitacionAlumno(int codCapacitacion, String codAlumno) {
        this.capacitacionAlumnoPK = new CapacitacionAlumnoPK(codCapacitacion, codAlumno);
    }

    public CapacitacionAlumnoPK getCapacitacionAlumnoPK() {
        return capacitacionAlumnoPK;
    }

    public void setCapacitacionAlumnoPK(CapacitacionAlumnoPK capacitacionAlumnoPK) {
        this.capacitacionAlumnoPK = capacitacionAlumnoPK;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }
    
    /**
     * Metodos @Override para comparaciones
     * 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitacionAlumnoPK != null ? capacitacionAlumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionAlumno)) {
            return false;
        }
        CapacitacionAlumno other = (CapacitacionAlumno) object;
        if ((this.capacitacionAlumnoPK == null && other.capacitacionAlumnoPK != null) || (this.capacitacionAlumnoPK != null && !this.capacitacionAlumnoPK.equals(other.capacitacionAlumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.CapacitacionAlumno[ capacitacionAlumnoPK=" + capacitacionAlumnoPK + " ]";
    }

}
