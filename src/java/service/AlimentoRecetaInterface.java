/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.AlimentoReceta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 *
 * @author josue
 */
public interface AlimentoRecetaInterface {

    /**
     * Este metodo elimina los AlimentoReceta que estan creados en la base de
     * datos
     *
     * @param alimentoReceta Es un Objeto de la entidad de AlimentoReceta que
     * contiene datos propios y datos de las entidades Alimento y Receta
     * @throws excepciones.CreateException se lanza cuando ocurre un error en la
     * creación del objeto alimento en la base de datos
     */
    public void crearAlimentoReceta(AlimentoReceta alimentoReceta) throws CreateException;

    /**
     * Este metodo Elimina los AlimentoReceta que estan creados en la base de
     * datos
     *
     * @param alimentoReceta Es un Objeto de la entidad AlimentoReceta que
     * contiene los datos para eliminar de la base de Datos
     * @throws excepciones.DeleteException se lanza cuando ocurre un error en la
     * eliminación del objeto AlimentoReceta de la base de datos
     */
    public void eliminarAlimentoReceta(AlimentoReceta alimentoReceta) throws DeleteException;

    /**
     * Este metodo Actualiza o cambia los datos de alimentos creados en la base
     * de datos
     *
     * @param alimentoReceta es un Objeto de la entidad alimentoReceta que
     * contiene los datos para actualizarlo de la base de datos
     * @throws excepciones.UpdateException se lanza cuando ocurre un error en la
     * actualización del objeto Alimento en la base de datos
     */
    public void modificarAlimentoReceta(AlimentoReceta alimentoReceta) throws UpdateException;

    /**
     * Este metodo busca el AlimentoReceta por dos Ids
     *
     * @param idReceta es un String
     * @param idAlimento es un String
     * @return Devuelve un Objeto de la entidad AlimentoReceta
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto AlimentoReceta en la base de datos
     */
    public AlimentoReceta getAlimentoRecetaPorIdRecetaIdAlimento(String idReceta, String idAlimento) throws ReadException;

    /**
     * Este metodo busca todos los alimentos y los guarda en una Collection
     *
     * @return Devuelve una Lista de la entidad AlimentoReceta
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto alimento en la base de datos
     */
    public Collection<AlimentoReceta> getAlimentoRecetaTodos() throws ReadException;

    /**
     * Este metodo busca por su cantidad de AlimentoReceta y guarda en una lista
     * todos los alimentos encontrados
     *
     * @param cantidad Es un Entero
     * @return Devuelve una lista de la entidad AlimentoReceta
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimentoReceta en la base de datos
     */
    public Collection<AlimentoReceta> getAlimentoRecetaPorCantidad(Integer cantidad) throws ReadException;
}
