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
import excepciones.UpdateException;

/**
 *
 * @author Gonzalo
 */
public interface AdministradorInterface {
    /**
     * Metodo para crear un Administrador
     * @param admin
     * @throws excepciones.CreateException se lanza cuando ocurre un error en la creación del objeto alimento
     * en la base de datos
     */
    public void crearAdministrador(Administrador admin)throws CreateException;
    /**
     * Metodo para crear un Cliente
     * @param cliente
     * @throws excepciones.CreateException se lanza cuando ocurre un error en la creación del objeto alimento
     * en la base de datos
     */

    public void crearCliente(Cliente cliente) throws CreateException;
    /**
     * Metodo para crear un Dietista
     * @param dietista
     * @throws excepciones.CreateException se lanza cuando ocurre un error en la creación del objeto alimento
     * en la base de datos
     */
    public void crearDietista(Dietista dietista) throws CreateException;
    /**
     * Metodo para modificar un Administrador
     * @param admin
     * @throws excepciones.UpdateException se lanza cuando ocurre un error en la actualización del objeto Alimento
     * en la base de datos
     */
    public void modificarAdministrador(Administrador admin)throws UpdateException;
    /**
     * Metodo para modificar un Cliente
     * @param cliente
     * @throws excepciones.UpdateException se lanza cuando ocurre un error en la actualización del objeto Alimento
     * en la base de datos
     */
    public void modificarCliente(Cliente cliente) throws UpdateException;
    /**
     * Metodo para modificar un Dietista
     * @param dietista
     * @throws excepciones.UpdateException se lanza cuando ocurre un error en la actualización del objeto Alimento
     * en la base de datos
     */
    public void modificarDietista(Dietista dietista) throws UpdateException;
    /**
     * Metodo para eliminar un Cliente
     * @param cliente
     * @throws excepciones.DeleteException se lanza cuando ocurre un error en la eliminación del objeto Alimento
     * de la base de datos
     */
    public void eliminarCliente(Cliente cliente) throws DeleteException;
    /**
     * Metodo para eliminar un Dietista
     * @param dietista
     * @throws excepciones.DeleteException se lanza cuando ocurre un error en la eliminación del objeto Alimento
     * de la base de datos
     */
    public void eliminarDietista(Dietista dietista) throws DeleteException;
}
