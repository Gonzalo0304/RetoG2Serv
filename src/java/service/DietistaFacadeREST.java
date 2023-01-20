/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cifrado.Cifrado;
import cifrado.Hash;
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
public class DietistaFacadeREST {

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
     *
     * @param dni
     * @return
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
     *
     * @param dietista
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void crearDietista(Dietista dietista) {
        try {
            Hash hash = new Hash();
            //Cifrado cifrado = new Cifrado();
            String contraseña;
            //contraseña= cifrado.descifrarTexto(usuario.getContraseña());
            contraseña = hash.cifrarTexto(dietista.getContraseña());
            dietista.setContraseña(contraseña);
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
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
