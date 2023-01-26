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
 *
 * @author Gonzalo
 */
@Path("entities.administrador")
public class AdministradorFacadeREST{
   
    @EJB
    private AdministradorInterface ejb;


    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Administrador entity) {
        try {
            ejb.crearAdministrador(entity);
        } catch (CreateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @POST
    @Path("CrearCliente")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createCliente(Cliente entity){
        try {
                        Cifrado cifrado = new Cifrado();
            String contraseña;
            //contraseña= cifrado.descifrarTexto(usuario.getContraseña());
            contraseña = cifrado.hashearMensaje(entity.getContraseña());
            entity.setContraseña(contraseña);
            entity.setContraseña(contraseña);
            ejb.crearCliente(entity);
        } catch (CreateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Administrador entity) {
        try {
            ejb.modificarAdministrador(entity);
        } catch (UpdateException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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

    @DELETE
    @Path("DeleteCliente")
    public void remove(Cliente entity) {
        try {
            ejb.eliminarCliente(entity);
        } catch (DeleteException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("DeleteDietista")
    public void removeDietista( Dietista entity) {
        try {
            ejb.eliminarDietista(entity);
        } catch (DeleteException ex) {
            Logger.getLogger(AdministradorFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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