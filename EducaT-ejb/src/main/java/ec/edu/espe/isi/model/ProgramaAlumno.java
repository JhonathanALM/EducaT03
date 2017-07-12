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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que albergara la informacion respecto a los programas que puede tomar cada alumno.
 *
 * @author Solange 
 * @author Jhonathan
 * @author Victoria
 * @version 02/07/2017
 *
 */
@Entity 
@Table(name = "programa_alumno")
public class ProgramaAlumno implements Serializable 
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramaAlumnoPK programaAlumnoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    

    @Column(name = "ESTADO")
    private String estado;
    

    @JoinColumn(name = "COD_ALUMNO", referencedColumnName = "COD_ALUMNO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    

    @JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "COD_PROGRAMA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Programa programa;


    public ProgramaAlumno() {
    }


    public ProgramaAlumno(ProgramaAlumnoPK programaAlumnoPK) {
        this.programaAlumnoPK = programaAlumnoPK;
    }

    public ProgramaAlumno(ProgramaAlumnoPK programaAlumnoPK, String estado) {
        this.programaAlumnoPK = programaAlumnoPK;
        this.estado = estado;
    }

    public ProgramaAlumno(String codPrograma, String codAlumno) {
        this.programaAlumnoPK = new ProgramaAlumnoPK(codPrograma, codAlumno);
    }


    public ProgramaAlumnoPK getProgramaAlumnoPK() {
        return programaAlumnoPK;
    }

    public void setProgramaAlumnoPK(ProgramaAlumnoPK programaAlumnoPK) {
        this.programaAlumnoPK = programaAlumnoPK;
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

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaAlumnoPK != null ? programaAlumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaAlumno)) {
            return false;
        }
        ProgramaAlumno other = (ProgramaAlumno) object;
        if ((this.programaAlumnoPK == null && other.programaAlumnoPK != null) || (this.programaAlumnoPK != null && !this.programaAlumnoPK.equals(other.programaAlumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.ProgramaAlumno[ programaAlumnoPK=" + programaAlumnoPK + " ]";
    }

}
