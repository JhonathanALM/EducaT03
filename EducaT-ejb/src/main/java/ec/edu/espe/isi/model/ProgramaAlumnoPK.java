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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que albergara la informacion respecto a los programas que puede tomar cada alumno.
 *
 * @author Solange 
 * @autor Jhonathan
 * @autor Victoria
 * @version 02/07/2017
 *
 */
@Embeddable 
public class ProgramaAlumnoPK implements Serializable 
{
    /**
     * propiedades de la entidad ProgramaAlumnoPK.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo del programa.
     */
    @Column(name = "COD_PROGRAMA")
    private String codPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    
    /**
     * Propiedad de la entidad que hace referencia a la clave primaria que corresponde
     * al codigo del alumno que tomara el programa.
     */
    @Column(name = "COD_ALUMNO")
    private String codAlumno;

    /**
     * Constructor por defecto
     *
     */
    public ProgramaAlumnoPK() {
    }

    /**
     * Constructor para la clase ProgramaAlumnoPK
     * @param codPrograma El parametro codPrograma define el codigo del programa.
     * @param codAlumno El parametro codAlumno define el codigo del alumno dentro del programa.
     *
     */
    public ProgramaAlumnoPK(String codPrograma, String codAlumno) {
        this.codPrograma = codPrograma;
        this.codAlumno = codAlumno;
    }

    /**
     * Getters y Setters de cada atributo dentro de las clases
     *
     */
    public String getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(String codPrograma) {
        this.codPrograma = codPrograma;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    /**
     * Metodos @Override para comparaciones
     * 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrograma != null ? codPrograma.hashCode() : 0);
        hash += (codAlumno != null ? codAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaAlumnoPK)) {
            return false;
        }
        ProgramaAlumnoPK other = (ProgramaAlumnoPK) object;
        if ((this.codPrograma == null && other.codPrograma != null) || (this.codPrograma != null && !this.codPrograma.equals(other.codPrograma))) {
            return false;
        }
        if ((this.codAlumno == null && other.codAlumno != null) || (this.codAlumno != null && !this.codAlumno.equals(other.codAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.isi.ProgramaAlumnoPK[ codPrograma=" + codPrograma + ", codAlumno=" + codAlumno + " ]";
    }

}
