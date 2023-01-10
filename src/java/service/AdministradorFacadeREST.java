/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Administrador;
import entities.Cliente;
import entities.Dietista;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
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
@Stateless
@Path("entities.administrador")
public class AdministradorFacadeREST {

    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;

    @EJB
    private AdministradorInterface ejb;
    
    /*public AdministradorFacadeREST() {
        super(Administrador.class);
    }*/

    /*@POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Administrador entity) {
        super.create(entity);
    }*/
    
    @POST
    @Path("CrearCliente/{cliente}")
    public void createCliente(Cliente entity){
        try {
            ejb.crearCliente(entity);
        } catch (CreateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @POST
    @Path("CrearDietista/{dietista}")
    public void createDietista(Dietista entity){
        try {
            ejb.crearDietista(entity);
        } catch (CreateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*@PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Administrador entity) {
        super.edit(entity);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit (Administrador administrador){
        super.edit(administrador);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }*/
    
    @DELETE
    @Path("BorrarCliente/{cliente}")
    public void deleteCliente(Cliente entity){
        try {
            ejb.eliminarCliente(entity);
        } catch (DeleteException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @DELETE
    @Path("BorrarDietista/{dietista}")
    public void deleteDietista(Dietista entity){
        try {
            ejb.eliminarDietista(entity);
        } catch (DeleteException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{dni}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Administrador find(@PathParam("dni") String dni) {
        try {
            return ejb.getAdministradorPorDNI(dni);
        } catch (ReadException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Administrador> findAll() {
        try {
            return (List<Administrador>) ejb.getAdministradorAll();
        } catch (ReadException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*@GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Administrador> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }*/
    
}
