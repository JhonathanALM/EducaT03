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
 * Clase que albergara la informacion respecto a  la capacitacion que tiene una alumno.
 *
 * @author Solange 
 * @author Jhonathan
 * @author Victoria
 * @version 26/06/2017
 *
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
