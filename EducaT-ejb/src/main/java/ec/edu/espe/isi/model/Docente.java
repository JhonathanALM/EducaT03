package ec.edu.espe.isi.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entidad que almacena la informaciácion de los docentes 
 * que dictan capacitaciones en el instituto.
 * @author Solange
 * @author Victoria
 * @author jhona
 */
@Entity 
@Table(name = "docente")
public class Docente implements Serializable 
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
    @Column(name = "COD_DOCENTE")
    private String codDocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    
    /**
     * Propiedad de la entidad docente que corresponde a los nombres y apellidos del docente.
     */
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    
    /**
     * Propiedad de la entidad que corresponde a la dirección del docente.
     */
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    
    /**
     * Propiedad de la entidad que corresponde al número de teléfono del docente.
     */
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    
    /**
     * Propiedad de la entidad que corresponde al correo electrónico del docente.
     */
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @OneToMany(mappedBy = "codDocente")
    private Collection<Capacitacion> capacitacionCollection;

    public Docente() {
    }

    /**
     * Constructor para la clase Docente.
     * @param codDocente El parámetro codDocente define el código del docente.
     */
    public Docente(String codDocente) {
        this.codDocente = codDocente;
    }

    /**
     * Constructor para la clase Docente.
     * @param codDocente define el código del docente.
     * @param nombre define el nombre del docente.
     * @param direccion define la dirección del docente.
     * @param telefono define el número de telefono del docente.
     * @param correoElectronico define la dirección de correo electrónico del docente.
     */
    public Docente(String codDocente, String nombre, String direccion, String telefono, String correoElectronico) {
        this.codDocente = codDocente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Método que devuelve el código del docente (codDocente)
     * @return 
     */
    public String getCodDocente() {
        return codDocente;
    }

    /**
     * modifica el codigo del docente.
     * @param codDocente 
     */
    public void setCodDocente(String codDocente) {
        this.codDocente = codDocente;
    }

    /**
     * Método que devuelve el nombre del docente (nombre)
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * modifica el nombre del docente.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve la dirección de domicilio del docente (direccion)
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * modifica la dirección del docente.
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que devuelve el número de teléfono del docente (telefono)
     * @return 
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * modifica el numero de telefono  del docente.
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que devuelve el correo electrónico del docente (correoElectronico)
     * @return 
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * modifica el correo electrónico del docente.
     * @param correoElectronico 
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @XmlTransient
    public Collection<Capacitacion> getCapacitacionCollection() {
        return capacitacionCollection;
    }

    public void setCapacitacionCollection(Collection<Capacitacion> capacitacionCollection) {
        this.capacitacionCollection = capacitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDocente != null ? codDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.codDocente == null && other.codDocente != null) || (this.codDocente != null && !this.codDocente.equals(other.codDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.Docente[ codDocente=" + codDocente + " ]";
    }

}
