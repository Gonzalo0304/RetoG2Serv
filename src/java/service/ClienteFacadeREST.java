/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
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

@Path("entities.cliente")
public class ClienteFacadeREST {
    
    
     @EJB
     private ClienteInterface ejb;

   

    public ClienteFacadeREST() {
       
    }
    
        @GET
     // @Path("nombreDietistae")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Cliente> getDietistasTodos() {

        Collection <Cliente> clientes = null;
        try {
            clientes = ejb.getClienteTodos();
        } catch (ReadException ex) {
            Logger.getLogger(ClienteFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
   @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente getClientePorId(@PathParam("id") String id) {
        Cliente cliente = null;

        try {
            cliente = ejb.getClientePorId(id);
        } catch (ReadException ex) {
            Logger.getLogger(ClienteFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
    
    @POST
   @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public void crearCliente(Cliente cliente){
       try{
           ejb.crearCliente(cliente);
       } catch (CreateException ex) {
             Logger.getLogger(ClienteFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
    
   
     @PUT
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public void modificarCliente(Cliente cliente){
       try{
           ejb.modificarCliente(cliente);
       } catch (UpdateException ex) {
             Logger.getLogger(ClienteFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     @DELETE
    // @Consumes({"application/xml"})
      @Path("{id}")
    public void removeAccount(@PathParam("id") String id) {
        try {
          
            ejb.borrarCliente(ejb.getClientePorId(id));
        } catch (ReadException|DeleteException ex) {
            //LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());        
        }
    }  
    
/**
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Cliente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    **/
}
