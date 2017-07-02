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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que albergara la informacion respecto a los cursos que se tendra dentro de un programa.
 *
 * @author Solange 
 * @autor Jhonathan
 * @autor Victoria
 * @version 02/07/2017
 *
 */
@Entity 
@Table(name = "programa_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramaCurso.findAll", query = "SELECT p FROM ProgramaCurso p")
    , @NamedQuery(name = "ProgramaCurso.findByCodPrograma", query = "SELECT p FROM ProgramaCurso p WHERE p.programaCursoPK.codPrograma = :codPrograma")
    , @NamedQuery(name = "ProgramaCurso.findByCodCurso", query = "SELECT p FROM ProgramaCurso p WHERE p.programaCursoPK.codCurso = :codCurso")
    , @NamedQuery(name = "ProgramaCurso.findByOrden", query = "SELECT p FROM ProgramaCurso p WHERE p.orden = :orden")
    , @NamedQuery(name = "ProgramaCurso.findByEstado", query = "SELECT p FROM ProgramaCurso p WHERE p.estado = :estado")})
public class ProgramaCurso implements Serializable 
{

    /**
     * propiedades de la entidad ProgramaCurso.
     */
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramaCursoPK programaCursoPK;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que hace referencia al atributo corresponde
     * a la orden del programa.
     */
    @Column(name = "ORDEN")
    private short orden;
    @Basic(optional = false)
    @NotNull
    
    /**
     * Propiedad de la entidad que hace referencia al atributo corresponde
     * al estado del curso deltro del programa.
     */
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo unico de cada curso que se dara.
     */
    @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo del programa.
     */
    @JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Programa programa;

    /**
     * Constructor por defecto
     *
     */
    public ProgramaCurso() {
    }

    /**
     * Constructor para la clase ProgramaCurso
     * @param programaCursoPK El parametor programaCursoPK es para definir la clave primaria.
     *
     */
    public ProgramaCurso(ProgramaCursoPK programaCursoPK) {
        this.programaCursoPK = programaCursoPK;
    }

    /**
     * Constructor para la clase ProgramaCurso
     * @param programaCursoPK El parametor programaCursoPK es para definir la clave primaria.
     * @param estado El parametro estado dara el estado del curso dentro del programa.
     * @param orden El parametro orden nos dara como estare el curso dentro del programa.
     */
    public ProgramaCurso(ProgramaCursoPK programaCursoPK, short orden, String estado) {
        this.programaCursoPK = programaCursoPK;
        this.orden = orden;
        this.estado = estado;
    }

    public ProgramaCurso(String codPrograma, String codCurso) {
        this.programaCursoPK = new ProgramaCursoPK(codPrograma, codCurso);
    }

    /**
     * Getters y Setters de cada atributo dentro de las clases
     *
     */
    public ProgramaCursoPK getProgramaCursoPK() {
        return programaCursoPK;
    }

    public void setProgramaCursoPK(ProgramaCursoPK programaCursoPK) {
        this.programaCursoPK = programaCursoPK;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    /**
     * Metodos @Override para comparaciones
     * 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaCursoPK != null ? programaCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaCurso)) {
            return false;
        }
        ProgramaCurso other = (ProgramaCurso) object;
        if ((this.programaCursoPK == null && other.programaCursoPK != null) || (this.programaCursoPK != null && !this.programaCursoPK.equals(other.programaCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.ProgramaCurso[ programaCursoPK=" + programaCursoPK + " ]";
    }

}
