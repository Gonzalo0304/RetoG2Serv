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
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josue
 */
@Stateless
public class EJBUsuario implements UsuarioInterface {

    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;

    @Override
    public void crearUsuario(Usuario usuario) throws CreateException {
        try {
            em.persist(usuario);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws DeleteException {
        try {
            em.remove(em.merge(usuario));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws UpdateException {
        try {
            em.merge(usuario);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

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

    @Override
    public Collection getUsuarioPorEmail(String email) {
        List<Usuario> usuario;
        usuario = em.createNamedQuery("getUsuarioPorEmail").setParameter("email", email).getResultList();

        return usuario;

    }

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

    @Override
    public Collection<Usuario> getInicioSesion(String nombreAcceso, String contraseña) throws ReadException {
        List<Usuario> usuario;

        usuario = em.createNamedQuery("getInicioSesion").setParameter("nombreAcceso", nombreAcceso).setParameter("contraseña", contraseña).getResultList();
        return usuario;

    }

}
