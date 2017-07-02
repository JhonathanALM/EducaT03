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
package ec.edu.espe.isi.dao;

import ec.edu.espe.isi.model.Programa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Entidad que define un programa en el isntituto, un programa esta dado por un conjunto de cursos
 * dentro del patron de diseño Facade.
 * @author Solange
 * @author Victoria
 * @author jhona
 * @version 02/07/2017
 */
@Stateless
public class ProgramaFacade extends AbstractFacade<Programa> {

    @PersistenceContext(unitName = "ec.edu.espe.isi_EducaT-ejb_ejb_1PU")
    private EntityManager em;

    /**
     * Metodos Override para comparaciones.
     * 
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Metodo ProgramaFacade.
     */
    public ProgramaFacade() {
        super(Programa.class);
    }
    
}
