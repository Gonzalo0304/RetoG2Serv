/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cifrado.Cifrado;
import entities.Administrador;
import entities.Cliente;
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
 * RESTful Servicio Web para enseñar las opreaciones CRUD de la Clase Administrador
 * mendiante la entidad
 * @author Gonzalo
 */
@Path("entities.administrador")
public class AdministradorFacadeREST{
   
    /**
     * EJB que Hace Referencia a AdministradorInterface
     */
    @EJB
    private AdministradorInterface ejb;


    /**
     * Metodo POST RESTful crea un objeto de Administrador y lo representa en 
     * un XML
     * @param entity 
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Administrador entity) {
        try {
            ejb.crearAdministrador(entity);
        } catch (CreateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo POST RESTful crea un objeto de Cliente y lo representa en un XML
     * @param entity 
     */
    @POST
    @Path("CrearCliente")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createCliente(Cliente entity){
        try {
                        Cifrado cifrado = new Cifrado();
            String contrasenia;
            //contrasenia= cifrado.descifrarTexto(usuario.getContraseña());
            contrasenia = cifrado.hashearMensaje(entity.getContrasenia());
            entity.setContrasenia(contrasenia);
            entity.setContrasenia(contrasenia);
            ejb.crearCliente(entity);
        } catch (CreateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo POST RESTful crea un objeto de Dietista y lo representa en un XML
     * @param entity 
     */
    @POST
    @Path("CrearDietista")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void crearDietista(Dietista entity){
        try {
            ejb.crearDietista(entity);
        } catch (CreateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo PUT RESTful modifica un objeto de Administraodr de la base de Datos y
     * lo representa en un XML
     * @param entity 
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Administrador entity) {
        try {
            ejb.modificarAdministrador(entity);
        } catch (UpdateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo PUT RESTful modifica un objeto de Cliente de la base de Datos en
     * funcion a su id y lo representa en un XML
     * @param id
     * @param entity 
     */
    @PUT
    @Path("CrearCliente/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editCliente(@PathParam("id") String id, Cliente entity) {
        try {
            ejb.modificarCliente(entity);
        } catch (UpdateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo PUT RESTful modifica un objeto de Dietista de la base de Datos en
     * funcion a su id y lo representa en un XML
     * @param id
     * @param entity 
     */
    @PUT
    @Path("CrearDietista/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editDieista(@PathParam("id") String id, Dietista entity) {
        try {
            ejb.modificarDietista(entity);
        } catch (UpdateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo DELETE RESTful elimina un objeto de la entidad CLiente de la base
     * de Datos y lo representa en un XML
     * @param entity 
     */
    @DELETE
    @Path("DeleteCliente")
    public void remove(Cliente entity) {
        try {
            ejb.eliminarCliente(entity);
        } catch (DeleteException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo DELETE RESTful elimina un objeto de la entidad Dietista de la base
     * de Datos y lo representa en un XML
     * @param entity 
     */
    @DELETE
    @Path("DeleteDietista")
    public void removeDietista( Dietista entity) {
        try {
            ejb.eliminarDietista(entity);
        } catch (DeleteException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo GET RESTful lee todos los objetos de Dieta y lo representa en
     * un XML
     * @return 
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Administrador> getAdministradorTodos() {

        Collection<Administrador> administradores = null;
        try {
            administradores = ejb.getAdministradorTodos();
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return administradores;
    }



}