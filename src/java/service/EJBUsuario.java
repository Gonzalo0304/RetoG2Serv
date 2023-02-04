/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cifrado.Cifrado;
import cifrado.Mail;
import entities.Usuario;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josue
 */
@Stateless
public class EJBUsuario implements UsuarioInterface {

    @PersistenceContext(unitName = "RetoG2Serv")
    private EntityManager em;
    /**
     * Crea un Objeto Usuario en la base de Datos
     * @param usuario es un Objeto de la Entidad Usuario
     * @throws CreateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void crearUsuario(Usuario usuario) throws CreateException {
        try {
            Cifrado cifrado = new Cifrado();
            String contrasenia;
            contrasenia = cifrado.descifrarTexto1(usuario.getContrasenia());
            contrasenia = cifrado.hashearMensaje(contrasenia);
            usuario.setContrasenia(contrasenia);
            em.persist(usuario);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }
    /**
     * Elimina un Objeto Usuario de la base de Datos
     * @param usuario es un Objeto de la Entidad Usuario
     * @throws DeleteException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void eliminarUsuario(Usuario usuario) throws DeleteException {
        try {
            em.remove(em.merge(usuario));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }
   /**
     * Modifica la contraseña del Objeto Usuario de la base de Datos 
     * @param usuario es un Objeto de la Entidad Usuario
     * @throws UpdateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void modificarUsuario(Usuario usuario) throws UpdateException {
        try {
            Cifrado cifrado= new Cifrado();
            Mail mail = new Mail();
            String contra1= cifrado.descifrarTexto1(usuario.getContrasenia());
            String contra=cifrado.hashearMensaje(contra1);
            usuario.setContrasenia(contra);
            mail.mandarMail(usuario.getEmail(),contra1 );
            em.merge(usuario);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }
    /**
     * Busca un Objeto Usuario por su dni en la base de Datos
     * @param dni es un String
     * @return Devuelve un Objeto usuario con Datos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Usuario getUsuarioPorDni(String dni) throws ReadException {
        Usuario usuario;
        try {
            usuario = em.find(Usuario.class, dni);

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return usuario;
    }
 /**
     * Busca un Objeto Usuario por su email en la base de Datos para poder modificar
     * la contraseña por otra aleatoria y lo manda al correo del usuario
     * @param email es un String
     * @return Devuelve un Objeto usuario con Datos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection getUsuarioPorEmail(String email)throws ReadException {
        List<Usuario> usuario;
        usuario = em.createNamedQuery("getUsuarioPorEmail").setParameter("email", email).getResultList();
        for (int i = 0; i < usuario.size(); i++) {
            try {
                Cifrado cifrado = new Cifrado();
                Mail mail = new Mail();
                String pass1 = cifrado.generarContra();
                String pass = cifrado.hashearMensaje(pass1);
                usuario.get(i).setContrasenia(pass);
                modificarUsuario(usuario.get(i));
                mail.mandarMail(usuario.get(i).getEmail(), pass1);
            } catch (UpdateException ex) {
                Logger.getLogger(EJBUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return usuario;

    }
    /**
     * Busca una lista de todos los objetos de Usuario en la base de Datos
     * @return Devuelve una Lista de Usuarios
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Usuario> getUsuarioTodos() throws ReadException {
        List<Usuario> usuarios = null;
        try {
            usuarios = em.createNamedQuery("getUsuarioTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return usuarios;
    }
    /**
     * Busca una lista con el Usuario que tenga como atributo
     * un nombre de acceso y contrasenia dada
     * @param nombreAcceso es un String
     * @param contrasenia es un String
     * @return Devuelve una Lista de Usuarios
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Usuario> getInicioSesion(String nombreAcceso, String contrasenia) throws ReadException {
        List<Usuario> usuario;
        Cifrado cifrado = new Cifrado();
        contrasenia = cifrado.descifrarTexto1(contrasenia);
        contrasenia = cifrado.hashearMensaje(contrasenia);
        usuario = em.createNamedQuery("getInicioSesion").setParameter("nombreAcceso", nombreAcceso).setParameter("contrasenia", contrasenia).getResultList();
        return usuario;

    }


}
