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
 * Interfaz para EJBUsuario
 *
 * @author josue
 */
public interface UsuarioInterface {

    /**
     * Este metodo crea los usuarios que guardara en la base de datos
     *
     * @param usuario Es un Objeto de la entidad de Usuario que contiene datos
     * @throws excepciones.CreateException se lanza cuando ocurre un error en la
     * creación del objeto Usuario en la base de datos
     */
    public void crearUsuario(Usuario usuario) throws CreateException;

    /**
     * Este metodo elimina los usuarios que estan creados en la base de datos
     *
     * @param usuario Es un Objeto de la entidad usuario que contiene los datos
     * para eliminar de la base de Datos
     * @throws excepciones.DeleteException se lanza cuando ocurre un error en la
     * eliminación del objeto Usuario de la base de datos
     */
    public void eliminarUsuario(Usuario usuario) throws DeleteException;

    /**
     * Este metodo Actualiza o cambia los datos de usuarios creados en la base
     * de datos
     *
     * @param usuario es un Objeto de la entidad usuario que contiene los datos
     * para actualizarlo de la base de datos
     * @throws excepciones.UpdateException se lanza cuando ocurre un error en la
     * actualización del objeto usuarios en la base de datos
     */
    public void modificarUsuario(Usuario usuario) throws UpdateException;

    /**
     * Este metodo busca el usuario por la dni
     *
     * @param dni Es un String
     * @return Devuelve un Objeto de la entidad Usuario
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto usuario en la base de datos
     */
    public Usuario getUsuarioPorDni(String dni) throws ReadException;

    /**
     * Este metodo busca el usuario por la email
     *
     * @param email Es un String
     * @return Devuelve un Objeto de la entidad Usuario
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto usuario en la base de datos
     */
    public Collection<Usuario> getUsuarioPorEmail(String email) throws ReadException;

    /**
     * Este metodo busca todos los Usuarios y los guarda en una Collection
     *
     * @return Devuelve una Lista de la entidad Usuario
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto Usuario en la base de datos
     */
    public Collection<Usuario> getUsuarioTodos() throws ReadException;

    /**
     * Este metodo busca Usuario por nombre de Acceso y contraseña
     *
     * @param nombreAcceso es un String
     * @param contraseña es un String
     * @return Devuelve una lista de la entidad Usuario
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos Usuario en la base de datos
     */
    public Collection<Usuario> getInicioSesion(String nombreAcceso, String contraseña) throws ReadException;

}
