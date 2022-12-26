/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Alimento;
import excepciones.ReadException;
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

/**
 *
 * @author josue
 */
@Path("entities.alimento")
public class AlimentoFacadeREST{
    @EJB
    private AlimentoInterface ejb;

    
       public AlimentoFacadeREST() {
      
    }
    
    @GET
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoTodos() {
 
       Collection<Alimento> alimentos = null;
        try {
            alimentos= ejb.getAlimentoTodos();
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;
    }
    @GET
    @Path("{id}")
    @Produces({"application/xml"})
    public Alimento getAlimentoPorId(@PathParam("id") String id) {
                Alimento alimento = null;
                
        try {
            alimento= ejb.getAlimentoPorId(id);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimento;
    }



    
}
