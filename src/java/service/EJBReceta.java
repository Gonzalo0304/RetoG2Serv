package service;

import entities.Alimento;
import entities.Receta;
import entities.TipoAlimento;
import entities.TipoDieta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/*
 *
 * @author jon
 */
@Stateless
public class EJBReceta implements RecetaInterface {
    
    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;

    /**
     * Este método devuelve una colección con todas las recetas existentes.
     * @return Coleccion de recetas
     * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
     */
    
     @Override
    public Collection<Receta> getRecetaTodos() throws ReadException {

        List<Receta> recetas = null;
        try {
            recetas = em.createNamedQuery("getRecetaTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;

    }
/**
 * Este método devuelve la receta que tenga un ID específico.
 * @param idReceta
 * @return Coleccion de recetas
 * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
 */
    @Override
    public Receta getRecetaPorId(String idReceta) throws ReadException {
        Receta receta;
        try {
            receta = em.find(Receta.class, idReceta);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return receta;
    }
/**
 * Este método devuelve una colección de recetas creadas por un dietista con un nombre específico.
 * @param nombreDietista
 * @return Coleccion de recetas
 * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
 */
  
    
      @Override
    public Collection<Receta> getRecetaNombreDietista(String nombreDietista) throws ReadException {
       Collection <Receta> recetas = null;
       
       try {
            recetas = em.createNamedQuery("getRecetaNombreDietista").setParameter("nombreDietista", nombreDietista).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;
       
    }
    /**
     * Este método devuelve una colección de recetas con un nombre específico.

     * @param nombreReceta
     * @return Coleccion de recetas
     * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
     */
      @Override
    public Collection<Receta> getNombreReceta(String nombreReceta) throws ReadException {
       Collection <Receta> recetas = null;
       
       try {
            recetas = em.createNamedQuery("getNombreReceta").setParameter("nombreReceta", nombreReceta).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;
       
    }
    /**
     * Este método devuelve una colección de recetas con un tipo específico.

     * @param tipoReceta1
     * @return Coleccion de recetas
     * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
     */
        @Override
    public Collection<Receta> getRecetaTipo(String tipoReceta1) throws ReadException {
       Collection <Receta> recetas = null;
               TipoDieta tipoReceta = null;
        tipoReceta = tipoReceta.valueOf(tipoReceta1.toUpperCase());
       try {
            recetas = em.createNamedQuery("getRecetaTipo").setParameter("tipoReceta", tipoReceta).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;
       
    }
    /**
     * Este método devuelve una colección de recetas ordenadas alfabéticamente.

     * @return Coleccion de recetas
     * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
     */
      public Collection<Receta> getRecetasAlfabeticamente() throws ReadException {

        List<Receta> recetas = null;
        try {
            recetas = em.createNamedQuery("getRecetasAlfabeticamente").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;

    }
      /**
       * Este método devuelve una colección de recetas ordenadas por fecha de creación.

       * @return Coleccion de recetas
       * @throws ReadException Lanza una excepción de tipo ReadException si hay un problema en la lectura de los datos.
       */
       public Collection<Receta> getRecetaFechaCreacion() throws ReadException {

        List<Receta> recetas = null;
        try {
            recetas = em.createNamedQuery("getRecetaFechaCreacion").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;

    }
/**
 * Este método crea una nueva receta.

 * @param receta
 * @throws CreateException Lanza una excepción de tipo CreateException si hay un problema en la creación de la receta.

 */
    @Override
    public void crearReceta(Receta receta) throws CreateException {
        try {
            em.persist(receta);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }
   /**
    * Este método modifica una receta existente.

    * @param receta
    * @throws UpdateException Lanza una excepción de tipo UpdateException si hay un problema en la actualización de la receta.

    */
     @Override
     public void modificarReceta(Receta receta) throws UpdateException{
         try{
            if(!em.contains(receta))
                em.merge(receta);
            em.flush();
        }catch(Exception e){
            throw new UpdateException(e.getMessage());
        }
     }
     /**
     * Este método borra una receta
     * @param receta
     * @throws DeleteException Lanza una excepción de tipo DeleteException si hay un problema en el borrado de la receta.

     */
      @Override
     public void borrarReceta(Receta receta) throws DeleteException{
         try{
            em.remove(em.merge(receta));
        }catch(Exception e){
            throw new DeleteException(e.getMessage());
        }
     }

}

