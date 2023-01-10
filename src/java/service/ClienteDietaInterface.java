/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.ClienteDieta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 *
 * @author somor
 */
public interface ClienteDietaInterface {
    
    public void crearClienteDieta(ClienteDieta clienteDieta) throws CreateException;
    
    public void eliminarClienteDieta(ClienteDieta clienteDieta) throws DeleteException;
    
     public void modificarClienteDieta(ClienteDieta clienteDieta) throws UpdateException;

    public ClienteDieta getClienteDietaPorIdClienteIdDieta(String idCliente,String idDieta) throws ReadException;

    public Collection<ClienteDieta> getClienteDietaTodos() throws  ReadException;
    
    

}
