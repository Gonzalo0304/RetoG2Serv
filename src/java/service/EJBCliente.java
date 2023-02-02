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
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jon
 */
@Stateless
public class EJBCliente implements ClienteInterface{
    
    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;
    /**
     * Este método devuelve una colección con todos los clientes existentes.
     * @return Coleccion de clientes
     * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
     */

    @Override
    public Collection<Cliente> getClienteTodos() throws ReadException {
        Collection <Cliente> clientes = null;
       
       try {
            clientes = em.createNamedQuery("getClienteTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
       
    }
/**
 * Este método devuelve el cliente que tenga un ID específico.
     * @return Coleccion de clientes
     * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
     */
    @Override
    public Cliente getClientePorId(String idCliente) throws ReadException {
        Cliente cliente;
        
        try{
        cliente = em.find(Cliente.class, idCliente);
        }catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        
        return cliente;
    }
/**
 * Este método crea un nuevo cliente.

 * @param cliente
 * @throws CreateException Lanza una excepción de tipo CreateException si hay un problema en la creación del cliente.

 */
    @Override
    public void crearCliente(Cliente cliente) throws CreateException {
       try {
            em.persist(cliente);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }
     /**
    * Este método modifica cliente existente.

    * @param cliente
    * @throws UpdateException Lanza una excepción de tipo UpdateException si hay un problema en la actualización del cliente.

    */
    
      @Override
     public void modificarCliente(Cliente cliente) throws UpdateException{
         try{
            if(!em.contains(cliente))
                em.merge(cliente);
            em.flush();
        }catch(Exception e){
            throw new UpdateException(e.getMessage());
        }
     }
 /**
     * Este método borra un cliente
     * @param cliente
     * @throws DeleteException Lanza una excepción de tipo DeleteException si hay un problema en el borrado del cliente.

     */
    @Override
    public void borrarCliente(Cliente cliente) throws DeleteException {
       try{
            em.remove(em.merge(cliente));
        }catch(Exception e){
            throw new DeleteException(e.getMessage());
        }
     }
    
  
    
}
