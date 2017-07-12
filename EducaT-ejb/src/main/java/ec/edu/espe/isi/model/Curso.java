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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entidad que registra información referente a cada curso que oferta el instituto.
 * @author Solange
 * @author Victoria
 * @author jhona
 */
@Entity 
@Table(name = "curso")
public class Curso implements Serializable 
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    

    @Column(name = "COD_CURSO")
    private String codCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    

    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 4000)
    

    @Column(name = "OBJETIVO")
    private String objetivo;
    @Size(max = 4000)
    

    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    

    @Column(name = "DURACION")
    private short duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    

    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCurso")
    private Collection<Capacitacion> capacitacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<ProgramaCurso> programaCursoCollection;

    
    public Curso() {
    }

    public Curso(String codCurso) {
        this.codCurso = codCurso;
    }
    

    public Curso(String codCurso, String nombre, short duracion, String estado) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estado = estado;
    }


    public String getCodCurso() {
        return codCurso;
    }


    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }
    

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getObjetivo() {
        return objetivo;
    }


    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
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


    public String getEstado() {
        return estado;
    }


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
