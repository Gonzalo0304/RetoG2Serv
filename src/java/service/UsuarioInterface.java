/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Usuario;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 *
 * @author josue
 */
public interface UsuarioInterface {

    /**
     *
     * @param usuario
     * @throws CreateException
     */
    public void crearUsuario(Usuario usuario) throws CreateException;

    /**
     *
     * @param usuario
     * @throws DeleteException
     */
    public void eliminarUsuario(Usuario usuario) throws DeleteException;

    /**
     *
     * @param usuario
     * @throws UpdateException
     */
    public void modificarUsuario(Usuario usuario) throws UpdateException;
    public Usuario getUsuarioPorDni(String dni) throws ReadException;

    /**
     *
     * @param dni
     * @return
     * @throws ReadException
     */
    
    public Collection<Usuario> getUsuarioPorEmail(String email) throws ReadException;

    /**
     *
     * @return
     * @throws ReadException
     */
    public Collection<Usuario> getUsuarioTodos() throws ReadException;

}

