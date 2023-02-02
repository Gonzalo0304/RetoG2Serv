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
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jon
 */
@Stateless
public class EJBClienteDieta implements ClienteDietaInterface{
    
     @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;
/**
 * Este método crea un cliente con su dieta
 * @param clienteDieta ha crear
 * @throws CreateException Lanza una excepción de tipo CreateException si hay un problema en la creación del cliente dieta.
 */
    @Override
    public void crearClienteDieta(ClienteDieta clienteDieta) throws CreateException {
        try {
            em.persist(clienteDieta);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }
    /**
 * Este método elimina un cliente con su dieta
     * @param clienteDieta ha eliminar
     * @throws DeleteException Lanza una excepción de tipo DeleteException si hay un problema en el borrado clienteDieta.
     */

    @Override
    public void eliminarClienteDieta(ClienteDieta clienteDieta) throws DeleteException {
      try {
            em.remove(em.merge(clienteDieta));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }
/**
 * Este método modifica un cliente con su dieta
 * @param clienteDieta ha modificar
    * @throws UpdateException Lanza una excepción de tipo UpdateException si hay un problema en la actualización de clienteDieta.
 */
    @Override
    public void modificarClienteDieta(ClienteDieta clienteDieta) throws UpdateException {
       try {
            em.merge(clienteDieta);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }
/**
 * Metodo que devuelve un clienteDieta por el id de ambos
 * @param idCliente del cliente
 * @param idDieta de la dieta
 * @return el cliente y la dieta que tien
       * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
 */
    @Override
    public ClienteDieta getClienteDietaPorIdClienteIdDieta(String idCliente, String idDieta) throws ReadException {
        ClienteDieta clienteDieta = null;
        List<ClienteDieta>listaClienteDieta = null;
        try{
        listaClienteDieta= em.createNamedQuery("getClienteDietaTodos").getResultList();
   
        for(int i =0;i<listaClienteDieta.size();i++){
             if (listaClienteDieta.get(i).getCliente().getDni().equalsIgnoreCase(idCliente) && listaClienteDieta.get(i).getDieta().getIdDieta().equalsIgnoreCase(idDieta)) {
                    clienteDieta = listaClienteDieta.get(i);

                }
           
        }
         } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
         return clienteDieta;
    
    }
/**
 * Este metodo devuelve todos los clientes y sus dietas
 * @return colecion de clientes y dietas
       * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
 */
    @Override
    public Collection<ClienteDieta> getClienteDietaTodos() throws ReadException {
        List<ClienteDieta> listaClienteDieta = null;
        
        try {
            listaClienteDieta= em.createNamedQuery("getClienteDietaTodos").getResultList();
            
          } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
         return listaClienteDieta;
    
    }
   
    
}