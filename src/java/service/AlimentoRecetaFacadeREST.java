/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.AlimRecID;
import entities.AlimentoReceta;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author josue
 */
@Path("entities.alimentoreceta")
public class AlimentoRecetaFacadeREST {

    /**
     * EJB que Hace Referencia a AlimentoRecetaInterface
     */
    @EJB
    private AlimentoRecetaInterface ejb;

    private AlimRecID getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idAlim=idAlimValue;idRec=idRecValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */

        entities.AlimRecID key = new entities.AlimRecID();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idAlim = map.get("idAlim");
        if (idAlim != null && !idAlim.isEmpty()) {
            key.setIdAlim(idAlim.get(0));
        }
        java.util.List<String> idRec = map.get("idRec");
        if (idRec != null && !idRec.isEmpty()) {
            key.setIdRec(idRec.get(0));
        }
        return key;
    }

    @GET
    @Produces({"application/xml"})
    public Collection<AlimentoReceta> getAlimentoRecetaTodos() {

        Collection<AlimentoReceta> listaAlimentoReceta = null;
        try {
            listaAlimentoReceta = ejb.getAlimentoRecetaTodos();
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAlimentoReceta;
    }

    
     @GET @Path("{idReceta}")
     @Produces({"application/xml"}) public AlimentoReceta
     getAlimentoRecetaPorIdReceta(@PathParam("idReceta") String idReceta) {
     AlimentoReceta alimentoReceta = null;
    
     try { alimentoReceta = ejb.getAlimentoRecetaPorIdReceta(idReceta); 
     }
     catch (ReadException ex) {
     Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex); 
     } return alimentoReceta; }
     
   
    
    @GET
    @Path("AlimentoReceta/{cantidad}")
    @Produces({"application/xml"})
    
    
    public Collection<AlimentoReceta> getAlimentoRecetaPorCantidad(@PathParam("cantidad") Integer cantidad) {
        Collection<AlimentoReceta> listaAlimentoReceta = null;

        try {
            listaAlimentoReceta = ejb.getAlimentoRecetaPorCantidad(cantidad);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAlimentoReceta;
    }

    @POST
    @Consumes({"application/xml"})
    public void crearAlimentoReceta(AlimentoReceta alimentoReceta) {
        try {
            ejb.crearAlimentoReceta(alimentoReceta);
        } catch (CreateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml"})
    public void actualizarDietista(AlimentoReceta alimentoReceta) {
        try {
            ejb.modificarAlimentoReceta(alimentoReceta);
        } catch (UpdateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /** @DELETE
    @Path("EliminarAlimentoReceta/{idReceta}")
    @Consumes({"application/xml"})
    public void eliminarDietista(@PathParam("idReceta") String idReceta) {
        try {
            ejb.eliminarAlimentoReceta(ejb.getAlimentoRecetaPorIdReceta(idReceta));
        } catch (DeleteException | ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
}
