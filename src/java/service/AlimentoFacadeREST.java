/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Alimento;
import entities.TipoAlimento;
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

/**
 * RESTful Servicio Web para enseñar las opreaciones CRUD de la Clase Alimento
 * mendiante la entidad
 *
 * @author josue
 */
@Path("entities.alimento")
public class AlimentoFacadeREST {

    /**
     * EJB que Hace Referencia a AlimentoInterface
     */
    @EJB
    private AlimentoInterface ejb;

    public AlimentoFacadeREST() {

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento y lo representa en
     * un XML
     *
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
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
     * Metodo GET RESTful lee un objeto alimento por su Id y lo representa en un
     * XML
     *
     * @param id es un Objeto a leer
     * @return Devuelve un objeto alimento con Datos
     */
    @GET
    @Path("{id}")
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
     * Metodo GET RESTful lee todos los objetos de Alimento por su nombre y lo
     * representa en un XML
     *
     * @param nombre es un objeto a leer
     * @return Devuelve una lista de tipo alimento que contiene datos
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
     * Metodo GET RESTful lee todos los objetos de Alimento por su tipo y lo
     * representa en un XML
     *
     * @param tipo es Objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoTIPO/{tipo}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorTipo(@PathParam("tipo") String tipo) {
        Collection<Alimento> alimentos = null;
        TipoAlimento tipoAlimento = null;
        tipoAlimento = tipoAlimento.valueOf(tipo.toUpperCase());
        try {
            alimentos = ejb.getAlimentoPorTipo(tipoAlimento);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si es superior a
     * calorias dada y lo representa en un XML
     *
     * @param calorias es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoCaloriasSuperior/{calorias}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(@PathParam("calorias") Float calorias) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCaloriasSuperior(calorias);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si es inferior a
     * calorias dada y lo representa en un XML
     *
     * @param calorias es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoCaloriasMinimo/{calorias}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(@PathParam("calorias") Float calorias) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCaloriasMinimo(calorias);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si esta entre las
     * calorias dadas y lo representa en un XML
     *
     * @param caloriasMax es un objeto a leer
     * @param caloriasMin es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoCaloriasEntre/{caloriasMax}/{caloriasMin}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCaloriasEntre(@PathParam("caloriasMax") Float caloriasMax, @PathParam("caloriasMin") Float caloriasMin) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCaloriasEntre(caloriasMax, caloriasMin);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si es superior a
     * grasas dada y lo representa en un XML
     *
     * @param grasas es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoGrasasSuperior/{grasas}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorGrasasSuperior(@PathParam("grasas") Float grasas) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorGrasasSuperior(grasas);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si es inferior a
     * grasas dada y lo representa en un XML
     *
     * @param grasas es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoGrasasMinimo/{grasas}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorGrasasMinimo(@PathParam("grasas") Float grasas) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorGrasasMinimo(grasas);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si esta entre las
     * grasas dadas y lo representa en un XML
     *
     * @param grasasMax es un objeto a leer
     * @param grasasMin es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoGrasasEntre/{grasasMax}/{grasasMin}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorGrasasEntre(@PathParam("grasasMax") Float grasasMax, @PathParam("grasasMin") Float grasasMin) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorGrasasEntre(grasasMax, grasasMin);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si es superior a
     * proteinas dada y lo representa en un XML
     *
     * @param proteinas es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoProteinasSuperior/{proteinas}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorProteinasSuperior(@PathParam("proteinas") Float proteinas) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorProteinasSuperior(proteinas);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si es inferior a
     * proteinas dada y lo representa en un XML
     *
     * @param proteinas es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoProteinasMinimo/{proteinas}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorProteinasMinimo(@PathParam("proteinas") Float proteinas) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorProteinasMinimo(proteinas);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si esta entre las
     * proteinas dadas y lo representa en un XML
     *
     * @param proteinasMax es un objeto a leer
     * @param proteinasMin es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoProteinasEntre/{proteinasMax}/{proteinasMin}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorProteinasEntre(@PathParam("proteinasMax") Float proteinasMax, @PathParam("proteinasMin") Float proteinasMin) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorProteinasEntre(proteinasMax, proteinasMin);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si es superior a
     * carbohidratos dado y lo representa en un XML
     *
     * @param carbohidratos es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoCarbohidratosSuperior/{carbohidratos}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(@PathParam("carbohidratos") Float carbohidratos) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCarbohidratosSuperior(carbohidratos);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si es inferior a
     * carbohidratos dado y lo representa en un XML
     *
     * @param carbohidratos es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoCarbohidratosMinimo/{carbohidratos}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(@PathParam("carbohidratos") Float carbohidratos) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCarbohidratosMinimo(carbohidratos);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento si esta entre las
     * carbohidratos dados y lo representa en un XML
     *
     * @param carbohidratosMax es un objeto a leer
     * @param carbohidratosMin es un objeto a leer
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Path("AlimentoCarbohidratosEntre/{carbohidratosMax}/{carbohidratosMin}")
    @Produces({"application/xml"})
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(@PathParam("carbohidratosMax") Float carbohidratosMax, @PathParam("carbohidratosMin") Float carbohidratosMin) {
        Collection<Alimento> alimentos = null;
        try {
            alimentos = ejb.getAlimentoPorCarbohidratosEntre(carbohidratosMax, carbohidratosMin);
        } catch (ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alimentos;

    }

    /**
     *
     * @param alimento
     */
        @POST
        @Consumes({"application/xml"})
        public void crearAlimento(Alimento alimento) {
            try {
                ejb.crearAlimento(alimento);
            } catch (CreateException ex) {
                Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         *
         * @param alimento
         */
        @PUT
        @Consumes({"application/xml"})
        public void actualizarAlimento(Alimento alimento) {
            try {
                ejb.modificarAlimento(alimento);
            } catch (UpdateException ex) {
                Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         *
         * @param id
         */
        @DELETE
        @Path("{id}")
        //@Consumes({"application/xml"})
        public void eliminarAlimento(@PathParam("id") String id) {
            try {
                ejb.eliminarAlimento(ejb.getAlimentoPorId(id));
            } catch (DeleteException | ReadException ex) {
                Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

}
