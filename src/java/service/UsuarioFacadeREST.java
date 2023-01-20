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
@Path("entities.usuario")
public class UsuarioFacadeREST {

    /**
     * EJB que Hace Referencia a DiestistaInterface
     */
    @EJB
    private UsuarioInterface ejb;

    /**
     *
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Usuario> getUsuarioTodos() {

        Collection<Usuario> usuarios = null;
        try {
            usuarios = ejb.getUsuarioTodos();
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    /**
     *
     * @param dni
     * @return
     */
    /**
    @GET
    @Path("{dni}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario getUsuarioPorDni(@PathParam("dni") String dni) {
        Usuario usuario = null;

        try {
            usuario = ejb.getUsuarioPorDni(dni);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
*/
    /**
     *
     * @param dietista
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void crearUsuario(Usuario usuario) {
        try {
            Hash hash = new Hash();
            //Cifrado cifrado = new Cifrado();
            String contraseña;
            //contraseña= cifrado.descifrarTexto(usuario.getContraseña());
            contraseña = hash.cifrarTexto(usuario.getContraseña());
            usuario.setContraseña(contraseña);
            ejb.crearUsuario(usuario);
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
    public void actualizarUsuario(Usuario usuario) {
        try {
            ejb.modificarUsuario(usuario);
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
    public void eliminarUsuario(@PathParam("dni") String dni) {
        try {
            ejb.eliminarUsuario(ejb.getUsuarioPorDni(dni));
        } catch (DeleteException | ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @GET
    @Path("{email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Usuario> getUsuarioPorEmail(@PathParam("email") String email) {
        Collection<Usuario> usuario = null;

        try {
            usuario = ejb.getUsuarioPorEmail(email);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}
