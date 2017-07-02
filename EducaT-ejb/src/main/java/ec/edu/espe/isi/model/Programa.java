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
     /**
     * propiedades de la entidad Programa.
     */

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    
    /**
     * Propiedad de la entidad Programa que corresponde al código del prógrama.
     */
    @Column(name = "COD_PROGRAMA")
    private String codPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    
    /**
     * Propiedad de la entidad Programa que corresponde al nombre del programa.
     */
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 4000)
    
    /**
     * Propiedad de la entidad Programa que corresponde a la descripción del programa.
     */
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad Programa que corresponde a la duración en horas del programa
     */
    @Column(name = "DURACION")
    private short duracion;
    
    /**
     * Propiedad de la entidad Programa que corresponde a la fecha de inicio del prorama.
     */
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    /**
     * Propiedad de la entidad Programa que corresponde a la fecha de finalización del programa.
     */
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    private Collection<ProgramaCurso> programaCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa")
    private Collection<ProgramaAlumno> programaAlumnoCollection;

    public Programa() {
    }

    /**
     * Constructor para la clase Programa.
     * @param codPrograma define el código del programa.
     */
    public Programa(String codPrograma) {
        this.codPrograma = codPrograma;
    }

    /**
     * Constructor para la clase Programa.
     * @param codPrograma define el código del programa.
     * @param nombre define el nombre del programa
     * @param duracion define la duración del programa.
     */
    public Programa(String codPrograma, String nombre, short duracion) {
        this.codPrograma = codPrograma;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    /**
     * Método que devuelve el código del programa (codPrograma) 
     * @return el código del programa.
     */
    public String getCodPrograma() {
        return codPrograma;
    }

    /**
     * modifica el código del programa.
     * @param codPrograma 
     */
    public void setCodPrograma(String codPrograma) {
        this.codPrograma = codPrograma;
    }

    /**
     * Método que devuelve el nombre del programa (nombre) 
     * @return el nombre del programa.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * modifica el nombre del programa.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve la descripción  del programa (descripcion) 
     * @return la descripción  del programa.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * modifica la descripción del programa.
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método que devuelve la duración  del programa (duracion) 
     * @return la duración  del programa.
     */
    public short getDuracion() {
        return duracion;
    }

    /**
     * modifica la duración del programa.
     * @param duracion 
     */
    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    /**
     * Método que devuelve la fecha de inicio  del programa (fechaInicio) 
     * @return la fecha de inicio del programa.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * modifica la fecha de inicio del programa.
     * @param fechaInicio 
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Método que devuelve la fecha de fin del programa (fechaFin) 
     * @return la fecha de fin del programa.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * modifica la fecha de fin del programa.
     * @param fechaFin 
     */
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
