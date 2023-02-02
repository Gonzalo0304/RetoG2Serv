/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.ClienteDieta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 *
 * @author jon
 */
public interface ClienteDietaInterface {
    /**
 * Este metodo crea un nuevo clienteDieta
     * @param clienteDieta ha crear
     *   @throws CreateException Lanza una excepción de tipo CreateException si hay un problema en la creación del clientedieta.
     */
    public void crearClienteDieta(ClienteDieta clienteDieta) throws CreateException;
    /**
     *  * Este metodo elimina un  clienteDieta
     * @param clienteDieta ha eliminar
     * @throws DeleteException Lanza una excepción de tipo DeleteException si hay un problema en el borrado del clientedieta.
     */
    public void eliminarClienteDieta(ClienteDieta clienteDieta) throws DeleteException;
    /**
 * Este metodo modifica un  clienteDieta
     * @param clienteDieta ha modificar
    * @throws UpdateException Lanza una excepción de tipo UpdateException si hay un problema en la actualización del clientedieta.
     */
     public void modificarClienteDieta(ClienteDieta clienteDieta) throws UpdateException;
/**
   * Este metodo devuelve un cliente con su dieta

 * @param idCliente del cliente ha buscar
 * @param idDieta de la dieta ha buscar
 * @return cliente y dieta que esten asociados a esos ids
* @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto clientedieta en la base de datos 
     */
    public ClienteDieta getClienteDietaPorIdClienteIdDieta(String idCliente,String idDieta) throws ReadException;
/**
 * Este metodo devuelve todas las dietas y los clientes asociados a una
 * @return coleccion con todas las recetas y clientas asociados a una
* @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto clientedieta en la base de datos
     */
    public Collection<ClienteDieta> getClienteDietaTodos() throws  ReadException;
    
    

}