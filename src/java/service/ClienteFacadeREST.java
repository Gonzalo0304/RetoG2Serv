/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import cifrado.Cifrado;
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
 * @author jon
 */

@Path("entities.cliente")
public class ClienteFacadeREST  {
    
    
     @EJB
     private ClienteInterface ejb;

   

    public ClienteFacadeREST() {
       
    }
    /**
     * Este método devuelve una colección con todos los clientes existentes.
     * @return coleccion de clientes
     */
        @GET
     // @Path("nombreDietistae")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Cliente> getDietistasTodos() {

        Collection <Cliente> clientes = null;
        try {
            clientes = ejb.getClienteTodos();
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    /**
 * Este método devuelve el cliente que tenga un ID específico.
     * @param id
     * @return cliente con ese id
     */
   @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente getClientePorId(@PathParam("id") String id) {
        Cliente cliente = null;

        try {
            cliente = ejb.getClientePorId(id);
        } catch (ReadException ex) {
            Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    /**
    * Este metodo crea un cliente
     * @param cliente 
     */
    
    @POST
   @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public void crearCliente(Cliente cliente){
       try{
                       Cifrado cifrado = new Cifrado();
            String contrasenia;
            //contrasenia= cifrado.descifrarTexto(usuario.getContrasenia());
            contrasenia = cifrado.hashearMensaje(cliente.getContrasenia());
            cliente.setContrasenia(contrasenia);
            cliente.setContrasenia(contrasenia);
           ejb.crearCliente(cliente);
       } catch (CreateException ex) {
             Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
    
   /**
    * Este metodo actualiza un cliente
    * @param cliente 
    */
     @PUT
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public void modificarCliente(Cliente cliente){
       try{
           ejb.modificarCliente(cliente);
       } catch (UpdateException ex) {
             Logger.getLogger(RecetaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     /**
      * Este metodo borra un cliente 
      * @param id del cliente ha eliminar
      */
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
    

}
