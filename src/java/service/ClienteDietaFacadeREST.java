/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.ClienteDieta;
import entities.CltDietID;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author josue
 */
@Path("entities.clientedieta")
public class ClienteDietaFacadeREST extends AbstractFacade<ClienteDieta> {

    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;
    
    @EJB
    private ClienteDietaInterface ejb;

    private CltDietID getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idClte=idClteValue;idDiet=idDietValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.CltDietID key = new entities.CltDietID();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idClte = map.get("idClte");
        if (idClte != null && !idClte.isEmpty()) {
            key.setIdClte(idClte.get(0));
        }
        java.util.List<String> idDiet = map.get("idDiet");
        if (idDiet != null && !idDiet.isEmpty()) {
            key.setIdDiet(idDiet.get(0));
        }
        return key;
    }

    public ClienteDietaFacadeREST() {
        super(ClienteDieta.class);
        
        
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ClienteDieta entity) {
        try {
            ejb.crearClienteDieta(entity);
        } catch (CreateException ex) {
            Logger.getLogger(ClienteDietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ClienteDieta entity) {
        try {
            ejb.modificarClienteDieta(entity);
        } catch (UpdateException ex) {
            Logger.getLogger(ClienteDietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Override
    public void remove(ClienteDieta entity) {
        try {
            ejb.eliminarClienteDieta(entity);
        } catch (DeleteException ex) {
            Logger.getLogger(ClienteDietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("GetId/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ClienteDieta find(@PathParam("id") PathSegment id) {
        entities.CltDietID key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ClienteDieta> findAll() {
        List<ClienteDieta> listaClienteDieta = null;
        try {
            listaClienteDieta = (List<ClienteDieta>) ejb.getClienteDietaTodos();
        } catch (ReadException ex) {
            Logger.getLogger(ClienteDietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClienteDieta;
                
    }
    
    @GET
    @Path("GetClienIdDietaId/{idCliente}/{idDieta}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ClienteDieta getClieIdDietaId(@PathParam("idCliente")String idCliente, @PathParam("idDieta")String idDieta){
        ClienteDieta clienteDieta = null;
        try {
            clienteDieta = ejb.getClienteDietaPorIdClienteIdDieta(idCliente, idDieta);
        } catch (ReadException ex) {
            Logger.getLogger(ClienteDietaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clienteDieta;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ClienteDieta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    }
    
}
