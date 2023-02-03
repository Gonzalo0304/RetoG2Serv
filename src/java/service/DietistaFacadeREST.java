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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
  * RESTful Servicio Web para enseñar las opreaciones CRUD de la Clase Dietista
 * mendiante la entidad
 * @author josue
 */
@Path("entities.dietista")
public class DietistaFacadeREST {

    /**
     * EJB que Hace Referencia a DiestistaInterface
     */
    @EJB
    private DietistaInterface ejb;

    /**
     * Metodo GET RESTful lee todos los objetos de Dietista y lo representa en
     * un XML
     * @return Devuelve una lista de Dietistas que contiene Datos
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
     * Metodo GET RESTful lee un objeto Dietista por su dni y lo representa en un
     * XML
     * @param dni es un String
     * @return Devuelve un objeto Dietista con Datos
     */
    @GET
    @Path("{dni}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
     * Metodo POST RESTful crea un objeto de Dietista y lo representa en un XML
     * @param dietista Es un Objeto de la entidad Dietista
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void crearDietista(Dietista dietista) {
        try {
            ejb.crearDietista(dietista);
        } catch (CreateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo PUT RESTful modifica un objeto de Dietista de la base de Datos y
     * lo representa en un XML
     * @param dietista Es un objeto de la entidad Dietista
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void actualizarDietista(Dietista dietista) {
        try {
            ejb.modificarDietista(dietista);
        } catch (UpdateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo DELETE RESTful elimina un objeto de la entidad Dietista de la base
     * de Datos y lo representa en un XML
     * @param dni Es un String
     */
    @DELETE
    @Path("{dni}")
    //@Consumes({"application/xml"})
    public void eliminarDietista(@PathParam("dni") String dni) {
        try {
            ejb.eliminarDietista(ejb.getDietistaPorDni(dni));
        } catch (DeleteException | ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
