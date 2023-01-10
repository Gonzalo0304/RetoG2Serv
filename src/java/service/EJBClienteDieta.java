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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author somor
 */
public class EJBClienteDieta implements ClienteDietaInterface{
    
     @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;

    @Override
    public void crearClienteDieta(ClienteDieta clienteDieta) throws CreateException {
        try {
            em.persist(clienteDieta);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void eliminarClienteDieta(ClienteDieta clienteDieta) throws DeleteException {
      try {
            em.remove(em.merge(clienteDieta));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void modificarClienteDieta(ClienteDieta clienteDieta) throws UpdateException {
       try {
            em.merge(clienteDieta);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public ClienteDieta getClienteDietaPorIdClienteIdDieta(String idCliente, String idDieta) throws ReadException {
        ClienteDieta clienteDieta = null;
        List<ClienteDieta>listaClienteDieta = null;
        try{
        listaClienteDieta= em.createNamedQuery("getClienteDietaTodos").getResultList();
   
        for(int i =0;i<listaClienteDieta.size();i++){
           if(listaClienteDieta.get(i).getCliente().equals(idCliente)&&
                   listaClienteDieta.get(i).getDieta().getIdDieta().equalsIgnoreCase(idDieta)){
               clienteDieta = listaClienteDieta.get(i);
           } 
        }
         } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
         return clienteDieta;
    
    }

    @Override
    public Collection<ClienteDieta> getClienteDietaTodos() throws ReadException {
        List<ClienteDieta> listaClienteDieta = null;
        
        try {
            listaClienteDieta= em.createNamedQuery("getClienteDietaTodos").getResultList();
            
          } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
         return null;
    
    }
   
    
}
