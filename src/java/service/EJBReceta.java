package service;

import entities.Alimento;
import entities.Receta;
import entities.TipoAlimento;
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
    
        @Override
    public Collection<Receta> getRecetaTipo(String tipoReceta) throws ReadException {
       Collection <Receta> recetas = null;
       
       try {
            recetas = em.createNamedQuery("getRecetaTipo").setParameter("tipoReceta", tipoReceta).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;
       
    }
    
      public Collection<Receta> getRecetasAlfabeticamente() throws ReadException {

        List<Receta> recetas = null;
        try {
            recetas = em.createNamedQuery("getRecetasAlfabeticamente").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;

    }
      
       public Collection<Receta> getRecetaFechaCreacion() throws ReadException {

        List<Receta> recetas = null;
        try {
            recetas = em.createNamedQuery("getRecetaFechaCreacion").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetas;

    }

    @Override
    public void crearReceta(Receta receta) throws CreateException {
        try {
            em.persist(receta);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }
   
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
    
      @Override
     public void borrarReceta(Receta receta) throws DeleteException{
         try{
            em.remove(em.merge(receta));
        }catch(Exception e){
            throw new DeleteException(e.getMessage());
        }
     }

}

