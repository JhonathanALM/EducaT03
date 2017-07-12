/*
 * The MIT License
 *
 * Copyright 2017 Solange, Victoria, Jhonathan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
 * Entidad que define un programa en el isntituto. Un programa esta dado por un conjunto de cursos.
 * @author Solange
 * @author Victoria
 * @author jhona
 * @version 02/07/2017
 */
@Entity 
@Table(name = "programa")
public class Programa implements Serializable 
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    

    @Column(name = "COD_PROGRAMA")
    private String codPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    

    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 4000)
    

    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    

    @Column(name = "DURACION")
    private short duracion;
    

    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    

    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    private Collection<ProgramaCurso> programaCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    private Collection<ProgramaAlumno> programaAlumnoCollection;

    public Programa() {
    }


    public Programa(String codPrograma) {
        this.codPrograma = codPrograma;
    }

    public Programa(String codPrograma, String nombre, short duracion) {
        this.codPrograma = codPrograma;
        this.nombre = nombre;
        this.duracion = duracion;
    }


    public String getCodPrograma() {
        return codPrograma;
    }


    public void setCodPrograma(String codPrograma) {
        this.codPrograma = codPrograma;
    }

 
    public String getNombre() {
        return nombre;
    }

 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public short getDuracion() {
        return duracion;
    }


    public void setDuracion(short duracion) {
        this.duracion = duracion;
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

    @XmlTransient
    public Collection<ProgramaCurso> getProgramaCursoCollection() {
        return programaCursoCollection;
    }

    public void setProgramaCursoCollection(Collection<ProgramaCurso> programaCursoCollection) {
        this.programaCursoCollection = programaCursoCollection;
    }

    @XmlTransient
    public Collection<ProgramaAlumno> getProgramaAlumnoCollection() {
        return programaAlumnoCollection;
    }

    public void setProgramaAlumnoCollection(Collection<ProgramaAlumno> programaAlumnoCollection) {
        this.programaAlumnoCollection = programaAlumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrograma != null ? codPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.codPrograma == null && other.codPrograma != null) || (this.codPrograma != null && !this.codPrograma.equals(other.codPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.Programa[ codPrograma=" + codPrograma + " ]";
    }

}
