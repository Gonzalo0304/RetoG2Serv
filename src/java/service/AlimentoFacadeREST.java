/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Alimento;
import entities.TipoAlimento;
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
public class AlimentoFacadeREST {

    @EJB
    private AlimentoInterface ejb;

    public AlimentoFacadeREST() {

    }

    @GET
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoTodos() {

        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoTodos();
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("AlimentoId/{id}")
    @Produces({"application/xml"})
    public Alimento getAlimentoPorId(@PathParam("id") String id) {
        Alimento alimento = null;

        try {
            alimento = ejb.getAlimentoPorId(id);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimento;
    }

    /**
     *
     * @param nombre
     * @return
     */
    @GET
    @Path("AlimentoNombre/{nombre}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorNombre(@PathParam("nombre") String nombre) {
        Collection<Alimento> alimento = null;
        try {
            alimento = ejb.getAlimentoPorNombre(nombre);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimento;

    }

    /**
     *
     * @param tipo
     * @return
     */
    @GET
    @Path("AlimentoTIPO/{tipo}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorTipo(@PathParam("tipo") String tipo) {
        Collection<Alimento> alimentos = null;
        TipoAlimento tipoAlimento = null;
        tipoAlimento = tipoAlimento.valueOf(tipo.toUpperCase());
        try{
        alimentos = ejb.getAlimentoPorTipo(tipoAlimento);
            } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     *
     * @param calorias
     * @return
     */
    @GET
    @Path("AlimentoCaloriasSuperior/{calorias}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(@PathParam("calorias") Float calorias){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCaloriasSuperior(calorias);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }
    
       @GET
    @Path("AlimentoCaloriasMinimo/{calorias}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(@PathParam("calorias") Float calorias){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCaloriasMinimo(calorias);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }


    /**
     *
     * @param caloriasMax
     * @param caloriasMin
     * @return
     */
    @GET
    @Path("AlimentoCaloriasEntre/{caloriasMax}/{caloriasMin}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCaloriasEntre(@PathParam("caloriasMax") Float caloriasMax,@PathParam("caloriasMin") Float caloriasMin ){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCaloriasEntre(caloriasMax, caloriasMin);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }
    
        /**
     *
     * @param grasas
     * @return
     */
    @GET
    @Path("AlimentoGrasasSuperior/{grasas}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorGrasasSuperior(@PathParam("grasas") Float grasas){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorGrasasSuperior(grasas);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }
    
       @GET
    @Path("AlimentoGrasasMinimo/{grasas}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorGrasasMinimo(@PathParam("grasas") Float grasas){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorGrasasMinimo(grasas);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }


    /**
     *
     * @param grasasMax
     * @param grasasMin
     * @return
     */
    @GET
    @Path("AlimentoGrasasEntre/{grasasMax}/{grasasMin}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorGrasasEntre(@PathParam("grasasMax") Float grasasMax,@PathParam("grasasMin") Float grasasMin ){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorGrasasEntre(grasasMax, grasasMin);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }
    
        @GET
    @Path("AlimentoProteinasSuperior/{proteinas}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorProteinasSuperior(@PathParam("proteinas") Float proteinas){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorProteinasSuperior(proteinas);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }
    
       @GET
    @Path("AlimentoProteinasMinimo/{proteinas}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorProteinasMinimo(@PathParam("proteinas") Float proteinas){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorProteinasMinimo(proteinas);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }


    /**
     *
     * @param proteinasMax
     * @param proteinasMin
     * @return
     */
    @GET
    @Path("AlimentoProteinasEntre/{proteinasMax}/{proteinasMin}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorProteinasEntre(@PathParam("proteinasMax") Float proteinasMax,@PathParam("proteinasMin") Float proteinasMin ){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorProteinasEntre(proteinasMax, proteinasMin);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }
    
            @GET
    @Path("AlimentoCarbohidratosSuperior/{carbohidratos}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(@PathParam("carbohidratos") Float carbohidratos){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCarbohidratosSuperior(carbohidratos);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }
    
       @GET
    @Path("AlimentoCarbohidratosMinimo/{carbohidratos}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(@PathParam("carbohidratos") Float carbohidratos){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCarbohidratosMinimo(carbohidratos);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }


    /**
     *
     * @param proteinasMax
     * @param proteinasMin
     * @return
     */
    @GET
    @Path("AlimentoCarbohidratosEntre/{carbohidratosMax}/{carbohidratosMin}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(@PathParam("carbohidratosMax") Float carbohidratosMax,@PathParam("carbohidratosMin") Float carbohidratosMin ){
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCarbohidratosEntre(carbohidratosMax, carbohidratosMin);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }
    

}
