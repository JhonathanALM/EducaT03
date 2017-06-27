package ec.edu.espe.isi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author jhona
 */
@Embeddable 
public class CapacitacionAlumnoPK implements Serializable 
{

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAPACITACION")
    private int codCapacitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_ALUMNO")
    private String codAlumno;

    public CapacitacionAlumnoPK() {
    }

    public CapacitacionAlumnoPK(int codCapacitacion, String codAlumno) {
        this.codCapacitacion = codCapacitacion;
        this.codAlumno = codAlumno;
    }

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
