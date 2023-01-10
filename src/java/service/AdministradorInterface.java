/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Administrador;
import entities.Cliente;
import entities.Dietista;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import java.util.Collection;

/**
 * Interfaz de EJBAdministrador
 * @author Gonzalo
 */
public interface AdministradorInterface {
    
    /**
     * Este metodo crea un administrador y lo introduce en la base de datos
     * @param administrador 
     * @throws CreateException se lanza cuando ocurre un error en la creación de la Dieta
     * en la base de datos
     */
    public void crearAdministrador(Administrador administrador) throws CreateException;
    
    /**
     * Este metodo crea un cliente y lo introduce en la base de datos
     * @param cliente
     * @throws CreateException se lanza cuando ocurre un error en la creación de la Dieta
     * en la base de datos
     */
    public void crearCliente(Cliente cliente) throws CreateException;
    
    /**
     * Este metodo crea un dietista y lo introduce en la base de datos
     * @param dietista
     * @throws CreateException se lanza cuando ocurre un error en la creación de la Dieta
     * en la base de datos
     */
    public void crearDietista(Dietista dietista) throws CreateException;
    
    /**
     * Este metodo elimina un administrador y lo introduce en la base de datos 
     * @param administrador
     * @throws DeleteException se lanza cuando ocurre un error en la eliminación del objeto Dieta
     * de la base de datos
     */
    public void eliminarAdministrador(Administrador administrador) throws DeleteException;
    
    /**
     * Este metodo elimina un cliente y lo introduce en la base de datos
     * @param cliente
     * @throws DeleteException se lanza cuando ocurre un error en la eliminación del objeto Dieta
     * de la base de datos
     */
    public void eliminarCliente(Cliente cliente) throws DeleteException;
    
    /**
     * Este metodo elimina un dietista y lo introduce en la base de datos
     * @param dietista
     * @throws DeleteException se lanza cuando ocurre un error en la eliminación del objeto Dieta
     * de la base de datos
     */
    public void eliminarDietista(Dietista dietista) throws DeleteException;
    
    /**
     * Este mtodo busca y muestra un admin por su dni
     * @param dni
     * @return 
     * @throws ReadException se lanza cuando ocurre un error en la busqueda de las Dietas
     * en la base de datos
     */
    public Administrador getAdministradorPorDNI(String dni) throws ReadException;
    
    /**
     * Este metodo muestra todos los admin existentes
     * @return
     * @throws ReadException se lanza cuando ocurre un error en la busqueda de las Dietas
     * en la base de datos
     */
    public Collection<Administrador> getAdministradorAll() throws ReadException;
}
