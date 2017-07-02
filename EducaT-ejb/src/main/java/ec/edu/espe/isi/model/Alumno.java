package ec.edu.espe.isi.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase que albergara la informacion respecto a los alumnos que toman clases en el instituto.
 * @author Solange 
 * @author Jhonathan
 * @author Victoria
 * @version 26/06/2017
 *
 */
@Entity 
@Table(name = "alumno")
public class Alumno implements Serializable 
{

    /**
     * propiedades de la entidad Docente
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * a la cédula de identidad del docente.
     */
    @Column(name = "COD_ALUMNO")
    private String codAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
        
    /**
     * Propiedad de la entidad docente que corresponde a los nombres y apellidos del alumno.
     */
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    
    /**
     * Propiedad de la entidad que corresponde a la dirección del alumno.
     */
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    
    /**
     * Propiedad de la entidad que corresponde al número de teléfono del alumno.
     */
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    
    /**
     * Propiedad de la entidad que corresponde al correo electrónico del alumno.
     */
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que corresponde a la fecha de nacimiento del alumno.
     */
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    
    /**
     * Propiedad de la entidad que corresponde al genero del alumno.
     */
    @Column(name = "GENERO")
    private String genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<CapacitacionAlumno> capacitacionAlumnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<ProgramaAlumno> programaAlumnoCollection;

    /**
     * Constructor por defecto
     *
     */
    public Alumno() {
    }

    /**
     * Constructor para la clase Docente.
     * @param codAlumno El parámetro codAlumno define el código del alumno.
     */
    public Alumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    /**
     * Constructor para la clase Docente.
     * @param codAlumno El parámetro codAlumno define el código del alumno.
     * @param nombre define el nombre del alumno.
     * @param direccion define la dirección del alumno.
     * @param telefono define el número de telefono del alumno.
     * @param correoElectronico define la dirección de correo electrónico del alumno.
     * @param fechaNacimiento define la fecha de nacimiento que tiene cada alumno.
     * @param genero define el genero que tiene cada alumno.
     */
    public Alumno(String codAlumno, String nombre, String direccion, String telefono, String correoElectronico, Date fechaNacimiento, String genero) {
        this.codAlumno = codAlumno;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    /**
     * Getters y Setters de cada atributo dentro de las clases
     *
     */
    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @XmlTransient
    public Collection<CapacitacionAlumno> getCapacitacionAlumnoCollection() {
        return capacitacionAlumnoCollection;
    }

    public void setCapacitacionAlumnoCollection(Collection<CapacitacionAlumno> capacitacionAlumnoCollection) {
        this.capacitacionAlumnoCollection = capacitacionAlumnoCollection;
    }

    @XmlTransient
    public Collection<ProgramaAlumno> getProgramaAlumnoCollection() {
        return programaAlumnoCollection;
    }

    public void setProgramaAlumnoCollection(Collection<ProgramaAlumno> programaAlumnoCollection) {
        this.programaAlumnoCollection = programaAlumnoCollection;
    }

    /**
     * Metodos @Override para comparaciones
     * 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.Alumno[ codAlumno=" + codAlumno + " ]";
    }

}
