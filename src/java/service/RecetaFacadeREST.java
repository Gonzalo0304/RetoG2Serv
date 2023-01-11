/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import entities.Alimento;
import entities.Receta;
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
 * @author jon
 */

@Path("entities.receta")
public class RecetaFacadeREST {
    
     @EJB
    private RecetaInterface ejb;

     // @PersistenceContext(unitName = "Reto2G2ServPU")
   // private EntityManager em;

    public RecetaFacadeREST() {
       // super(Receta.class);
    }

  @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Receta getRecetaPorId(@PathParam("id") String id) {
        Receta receta = null;

        try {
            receta = ejb.getRecetaPorId(id);
        } catch (ReadException ex) {
            Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
    
      @GET
     // @Path("nombreDietistae")
  // @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
    public Collection<Receta> getRecetaTodos() {

        Collection<Receta> receta = null;
        try {
            receta = ejb.getRecetaTodos();
        } catch (ReadException ex) {
            Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
    
     
        @GET
        @Path("nombreDietista/ordenadoAlfabeticamente")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Receta> getRecetasAlfabeticamente() {

        Collection<Receta> receta = null;
        try {
            receta = ejb.getRecetasAlfabeticamente();
        } catch (ReadException ex) {
            Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
    
    
        
        @GET
        @Path("nombreDietista/ordenadoFecha")
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Receta> getRecetaFechaCreacion() {

        Collection<Receta> receta = null;
        try {
            receta = ejb.getRecetaFechaCreacion();
        } catch (ReadException ex) {
            Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
    
    
    
  
    
    
    
             @GET
          @Path("nombreDietista/{nombre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Receta> getRecetaNombreDietista(@PathParam("nombre") String nombre) {

        Collection<Receta> receta = null;
        try {
            receta = ejb.getRecetaNombreDietista(nombre);
        } catch (ReadException ex) {
            Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
    
               @GET
          @Path("nombreReceta/{nombreReceta}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Receta> getNombreReceta(@PathParam("nombreReceta") String nombreReceta) {

        Collection<Receta> receta = null;
        try {
            receta = ejb.getNombreReceta(nombreReceta);
        } catch (ReadException ex) {
            Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
    
               @GET
          @Path("tipoReceta/{tipoReceta}")
     @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Receta> getRecetaTipo(@PathParam("tipoReceta") String tipoReceta) {

        Collection<Receta> receta = null;
        try {
            receta = ejb.getRecetaTipo(tipoReceta);
        } catch (ReadException ex) {
            Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
    
   @POST
   @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public void crearReceta(Receta receta){
       try{
           ejb.crearReceta(receta);
       } catch (CreateException ex) {
             Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public void modificarReceta(Receta receta){
       try{
           ejb.modificarReceta(receta);
       } catch (UpdateException ex) {
             Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
         @DELETE
        // @Consumes({"application/xml"})
   @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeAccount(@PathParam("id") String id) {
        try {
          
            ejb.borrarReceta(ejb.getRecetaPorId(id));
        } catch (ReadException|DeleteException ex) {
           // LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());        
        }
    }        
   
       
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Receta entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Receta entity) {
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
    public Receta find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Receta> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Receta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
