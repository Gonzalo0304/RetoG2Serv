/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cifrado.Cifrado;
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
  * RESTful Servicio Web para enseñar las opreaciones CRUD de la Clase Usuario
 * mendiante la entidad
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
     * Metodo GET RESTful lee todos los objetos de Usuario y lo representa en
     * un XML
     * @return Devuelve una lista de Usuarios que contiene Datos
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
     * Metodo GET RESTful lee un objeto usuario por su dni y lo representa en un
     * XML
     * @param dni es un String
     * @return Devuelve un objeto usuario con Datos
     */
    
    @GET
    @Path("{dni}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario getUsuarioPorDni(@PathParam("dni") String dni) {
        Usuario usuario
                = null;

        try {
            usuario = ejb.getUsuarioPorDni(dni);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return usuario;
    }

  /**
     * Metodo POST RESTful crea un objeto de Usuario y lo representa en un XML
     * @param usuario Es un Objeto de la entidad Usuario
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void crearUsuario(Usuario usuario) {
        try {
            ejb.crearUsuario(usuario);
        } catch (CreateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo PUT RESTful modifica un objeto de Usuario de la base de Datos y
     * lo representa en un XML
     * @param usuario Es un objeto de la entidad Usuario
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
     * Metodo DELETE RESTful elimina un objeto de la entidad Usuario de la base
     * de Datos y lo representa en un XML
     * @param dni Es un String
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
    /**
     * Metodo PUT RESTful modifica un objeto de Usuario que busca atravez del correo en la base de Datos y
     * lo representa en un XML
     * @param correo Es un objeto de la entidad Alimento
     */
    @PUT
    @Path("{correo}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void getUsuarioPorEmail(@PathParam("correo") String correo) {
        try {
            ejb.getUsuarioPorEmail(correo);
        } catch (ReadException ex) {
            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  /**
     * Metodo GET RESTful lee todos los objetos de Usuario por su nombre de acceso y contraseña  y lo
     * representa en un XML
     * @param nombreAcceso es un String a leer
     * @param contrasenia es un String a leer
     * @return Devuelve una lista de tipo alimento que contiene datos
     */
    @GET
    @Path("{nombreAcceso}/{contrasenia}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Usuario> getInicioSesion(@PathParam("nombreAcceso") String nombreAcceso, @PathParam("contrasenia") String contrasenia) {
        List<Usuario> usuario = null;

        try {

            usuario = (List<Usuario>) ejb.getInicioSesion(nombreAcceso, contrasenia);

        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }


}
