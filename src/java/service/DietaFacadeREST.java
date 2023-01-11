/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Dieta;
import entities.Objetivo;
import entities.TipoDieta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Gonzalo
 */

@Path("entities.dieta")
public class DietaFacadeREST{


    @EJB
    private DietaInterface ejb;


    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Dieta entity) {
        try {
            ejb.crearDieta(entity);
            //super.create(entity);
        } catch (CreateException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*@PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Dieta entity) {
        super.edit(entity);
    }*/

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Dieta dieta) {
        try {
            ejb.modificarDieta(dieta);
            //super.edit(dieta);
        } catch (UpdateException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String dni) {
        try {
            ejb.eliminarDieta(ejb.getDietaoPorId(dni));
            //super.remove(super.find(id));
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DeleteException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Dieta find(@PathParam("id") String id) {
        try {
            return ejb.getDietaoPorId(id);
            //return super.find(id);
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("FindNombre/{nombre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Dieta findNombre(@PathParam("nombre") String nombre) {
        try {
            return ejb.getDietaoPorNombre(nombre);
            //return super.find(nombre);
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("FindTipo/{tipo}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Dieta findTipo(@PathParam("tipo") TipoDieta tipo) {
        try {
            return (Dieta) ejb.getDietaPorTipo(tipo);
            //return super.find(nombre);
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("FindObjetivo/{objetivo}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Dieta findObjetivo(@PathParam("objetivo") Objetivo objetivo) {
        try {
            return (Dieta) ejb.getDietaPorObjetivo(objetivo);
            //return super.find(nombre);
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Dieta> findAll() {
        try {
            return (List<Dieta>) ejb.getDietaAll();
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("FindRange/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Dieta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        try {
            return (List<Dieta>) ejb.getDietaPorTiempoEntre(from, to);
            //return super.findRange(new int[]{from, to});
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    @GET
    @Path("FindMin/{from}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Dieta> findmin(@PathParam("from") Integer from) {
        try {
            return (List<Dieta>) ejb.getDietaPorTiempoMinimo(from);
            //return super.findRange(new int[]{from});
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Path("FindMax/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Dieta> findMax(@PathParam("to") Integer to) {
        try {
            return (List<Dieta>) ejb.getDietaPorTiempoMaximo(to);
            //return super.findRange(new int[]{to});
        } catch (ReadException ex) {
            Logger.getLogger(DietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   /* @Override
    protected EntityManager getEntityManager() {
        return em;
    }*/

}
