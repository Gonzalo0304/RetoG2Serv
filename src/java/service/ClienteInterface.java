/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Cliente;
import entities.Dietista;
import entities.Receta;
import entities.Usuario;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 *
 * @author jon
 */
public interface ClienteInterface {
    /**
     * 
     * @return coleccion con todos los clientes
      * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
    public Collection<Cliente> getClienteTodos()throws ReadException;
    /**
     * 
     * @param idCliente
     * @return cliente con el id que se ha introducido
       * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
   public Cliente getClientePorId(String idCliente) throws ReadException;
   /**
    * 
    * @param cliente ha crear
     *   @throws CreateException Lanza una excepción de tipo CreateException si hay un problema en la creación del cliente.
    */
   public void crearCliente(Cliente cliente)throws CreateException;
   /**
    * 
    * @param cliente ha modificar
    * @throws UpdateException Lanza una excepción de tipo UpdateException si hay un problema en la actualización  del cliente.
    */
   public void modificarCliente(Cliente cliente) throws UpdateException;
   /**
    * 
    * @param cliente ha borrar
     * @throws DeleteException Lanza una excepción de tipo DeleteException si hay un problema en el borrado de la receta.
    */
   public void borrarCliente (Cliente cliente) throws DeleteException;
    
}
