/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Alimento;
import entities.Dietista;
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
 * @author josue
 */
@Path("entities.dietista")
public class DietistaFacadeREST{

      /**
     * EJB que Hace Referencia a DiestistaInterface
     */
    @EJB
    private DietistaInterface ejb;

    /**
     *
     * @return
     */
    @GET
    @Produces({"application/xml"})
    public Collection<Dietista> getDietistaTodos() {

        Collection<Dietista> dietistas = null;
        try {
            dietistas = ejb.getDietistaTodos();
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dietistas;
    }
    
    /**
     *
     * @param dni
     * @return
     */
    @GET
    @Path("DietistaDni/{dni}")
    @Produces({"application/xml"})
    public Dietista getDietistaPorDni(@PathParam("dni") String dni) {
        Dietista dietista = null;

        try {
            dietista = ejb.getDietistaPorDni(dni);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dietista;
    }

    /**
     *
     * @param dietista
     */
    @POST
    @Consumes({"application/xml"})
    public void crearDietista(Dietista dietista) {
        try {
            ejb.crearDietista(dietista);
        } catch (CreateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param dietista
     */
    @PUT
    @Consumes({"application/xml"})
    public void actualizarDietista(Dietista dietista) {
        try {
            ejb.modificarDietista(dietista);
        } catch (UpdateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param dni
     */
    @DELETE
    @Path("EliminarDietista/{dni}")
    @Consumes({"application/xml"})
    public void eliminarDietista(@PathParam("dni") String dni) {
        try {
            ejb.eliminarDietista(ejb.getDietistaPorDni(dni));
        } catch (DeleteException | ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
  
   
