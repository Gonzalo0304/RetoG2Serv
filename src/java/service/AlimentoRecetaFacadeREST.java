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
         * pathSemgent representa un segmento de ruta URI y cualquier parámetro de matriz asociado.
         * Se supone que la parte de la ruta URI tiene la forma de 'somePath;idAlim=idAlimValue;idRec=idRecValue'.
         * Aquí 'somePath' es el resultado de la invocación del método getPath() y
         * se ignora en el siguiente código.
         * Los parámetros de matriz se utilizan como nombres de campo para crear una instancia de clave principal.
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

    /**
     * Metodo GET RESTful lee todos los objetos de AlimentoReceta y lo
     * representa en un XML
     *
     * @return Devuelve una lista de AlimentoReceta que contiene Datos
     */
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

    /**
     * Metodo GET RESTful lee un objeto alimento por idReceta y idAlimento; y lo
     * representa en un XML
     *
     * @param idReceta es un String
     * @param idAlimento es un String
     * @return Devuelve un objeto alimentoReceta con Datos
     */
    @GET
    @Path("{idReceta}/{idAlimento}")
    @Produces({"application/xml"})
    public AlimentoReceta
            getAlimentoRecetaPorIdRecetaIdAlimento(@PathParam("idReceta") String idReceta, @PathParam("idAlimento") String idAlimento) {
        AlimentoReceta alimentoReceta = null;

        try {
            alimentoReceta = ejb.getAlimentoRecetaPorIdRecetaIdAlimento(idReceta, idAlimento);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentoReceta;
    }

    /**
     * Metodo GET RESTful lee todos los objetos de AlimentoReceta por su
     * cantidad y lo representa en un XML
     *
     * @param cantidad es un Integer
     * @return Devuelve una lista de tipo alimentoReceta que contiene datos
     */
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

    /**
     * Metodo POST RESTful crea un objeto de AlimentoReceta y lo representa en
     * un XML
     *
     * @param alimentoReceta Es un objeto de la entidad AlimentoReceta
     */
    @POST
    @Consumes({"application/xml"})
    public void crearAlimentoReceta(AlimentoReceta alimentoReceta) {
        try {
            ejb.crearAlimentoReceta(alimentoReceta);
        } catch (CreateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo PUT RESTful modifica un objeto de AlimentoReceta de la base de
     * Datos y lo representa en un XML
     *
     * @param alimentoReceta Es un objeto de la entidad AlimentoReceta
     */
    @PUT
    @Consumes({"application/xml"})
    public void actualizarDietista(AlimentoReceta alimentoReceta) {
        try {
            ejb.modificarAlimentoReceta(alimentoReceta);
        } catch (UpdateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo DELETE RESTful elimina un objeto de la entidad AlimentoReceta de
     * la base de Datos y lo representa en un XML
     *
     * @param idReceta Es un String
     * @param idAlimento Es un String
     */
    @DELETE
    @Path("{idReceta}/{idAlimento}")
    //@Consumes({"application/xml"})
    public void eliminarDietista(@PathParam("idReceta") String idReceta, @PathParam("idAlimento") String idAlimento) {
        try {
            ejb.eliminarAlimentoReceta(ejb.getAlimentoRecetaPorIdRecetaIdAlimento(idReceta, idAlimento));
        } catch (DeleteException | ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
