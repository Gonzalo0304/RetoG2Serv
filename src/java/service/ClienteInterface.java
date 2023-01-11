/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Cliente;
import entities.Dietista;
import entities.Receta;
import entities.Usuario;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 *
 * @author somor
 */
public interface ClienteInterface{
    
    
    
    public Collection<Cliente> getClienteTodos()throws ReadException;
    
   public Cliente getClientePorId(String idCliente) throws ReadException;
   
   public void crearCliente(Cliente cliente)throws CreateException;
   
   public void modificarCliente(Cliente cliente) throws UpdateException;
   
   public void borrarCliente (Cliente cliente) throws DeleteException;
    
}
