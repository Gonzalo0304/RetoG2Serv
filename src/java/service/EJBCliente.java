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
 * @author somor
 */
@Stateless
public class EJBCliente implements ClienteInterface{
    
    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;
    

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

    @Override
    public void crearCliente(Cliente cliente) throws CreateException {
       try {
            em.persist(cliente);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }
    
    
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

    @Override
    public void borrarCliente(Cliente cliente) throws DeleteException {
       try{
            em.remove(em.merge(cliente));
        }catch(Exception e){
            throw new DeleteException(e.getMessage());
        }
     }
    
  
    
}
