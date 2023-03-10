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
import javax.ws.rs.core.MediaType;

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

    /**
     * Metodo GET RESTful lee todos los objetos de Alimento y lo representa en
     * un XML
     *
     * @return Devuelve una lista de Alimentos que contiene Datos
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
     * @param id es un String
     * @return Devuelve un objeto alimento con Datos
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
     * @param nombre es un String a leer
     * @return Devuelve una lista de tipo alimento que contiene datos
     */
    @GET
    @Path("AlimentoNombre/{nombre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
     * Metodo POST RESTful crea un objeto de Alimento y lo representa en un XML
     * @param alimento Es un Objeto de la entidad Alimento
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void crearAlimento(Alimento alimento) {
        try {
            ejb.crearAlimento(alimento);
        } catch (CreateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo PUT RESTful modifica un objeto de Alimento de la base de Datos y
     * lo representa en un XML
     * @param alimento Es un objeto de la entidad Alimento
     */
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void actualizarAlimento(Alimento alimento) {
        try {
            ejb.modificarAlimento(alimento);
        } catch (UpdateException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo DELETE RESTful elimina un objeto de la entidad Alimento de la base
     * de Datos y lo representa en un XML
     * @param id Es un String
     */
    @DELETE
    @Path("{id}")
    public void eliminarAlimento(@PathParam("id") String id) {
        try {
            ejb.eliminarAlimento(ejb.getAlimentoPorId(id));
        } catch (DeleteException | ReadException ex) {
            Logger.getLogger(AlimentoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
