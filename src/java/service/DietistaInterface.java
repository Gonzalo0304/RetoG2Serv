/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Dietista;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 *
 * @author josue
 */
public interface DietistaInterface {

      /**
     * Este metodo crea los dietistas que guardara en la base de datos
     * @param dietista Es un Objeto de la entidad de Dietista que contiene datos
     * @throws excepciones.CreateException se lanza cuando ocurre un error en la
     * creación del objeto alimento en la base de datos
     */
    public void crearDietista(Dietista dietista) throws CreateException;

    /**
     * Este metodo elimina los dietistas que estan creados en la base de datos
     * @param dietista Es un Objeto de la entidad dietista que contiene los
     * datos para eliminar de la base de Datos
     * @throws excepciones.DeleteException se lanza cuando ocurre un error en la
     * eliminación del objeto Dietista de la base de datos
     */
    public void eliminarDietista(Dietista dietista) throws DeleteException;
    /**
     * Este metodo Actualiza o cambia los datos de dietistas creados en la base
     * de datos
     * @param dietista es un Objeto de la entidad dietista que contiene los
     * datos para actualizarlo de la base de datos
     * @throws excepciones.UpdateException se lanza cuando ocurre un error en la
     * actualización del objeto Dietista en la base de datos
     */
    public void modificarDietista(Dietista dietista) throws UpdateException;

    /**
     * Este metodo busca el dietista por la dni
     * @param dni Es un String
     * @return Devuelve un Objeto de la entidad dietista
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto dietista en la base de datos
     */
    public Dietista getDietistaPorDni(String dni) throws ReadException;

    /**
     * Este metodo busca todos los dietistas y los guarda en una Collection
     * @return Devuelve una Lista de la entidad Dietista
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto dietista en la base de datos
     */
    public Collection<Dietista> getDietistaTodos() throws ReadException;

}
