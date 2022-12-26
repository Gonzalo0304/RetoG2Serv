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
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josue
 */
@Stateless
public class EJBAlimento implements AlimentoInterface {

    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;

    @Override
    public void crearAlimento(Alimento alimento) throws CreateException {
        try {
            em.persist(alimento);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }

    }

    @Override
    public void eliminarAlimento(Alimento alimento) throws DeleteException {
        try {
            em.remove(em.merge(alimento));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void modificarAlimento(Alimento alimento) throws UpdateException {
        try {
            em.merge(alimento);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    /**
     * Busca un Objeto Alimento por su idAlimento en la base de Datos
     * @param idAlimento es un String
     * @return Devuelve un Objeto alimento con Datos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */


  @Override
    public Alimento getAlimentoPorId(String idAlimento) throws ReadException {
        Alimento alimento;
        try {
            alimento = em.find(Alimento.class, idAlimento);

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return alimento;    }
    
    @Override
    public Collection<Alimento> getAlimentoTodos() throws ReadException {

        List<Alimento> alimentos=null;
        try {
            alimentos = em.createNamedQuery("getAlimentoTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return alimentos;

    }
        @Override
    public Alimento getAlimentoPorNombre(String nombreAlimento) throws ReadException {
        Alimento alimento;
        try {
            alimento = em.find(Alimento.class, nombreAlimento);

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return alimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento en la base de Datos
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoTodos() throws ReadException {

        List<Alimento> alimentos = null;
        try {
            alimentos = em.createNamedQuery("getAlimentoTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return alimentos;

    }

    /**
     * Busca una lista de todos los objetos de Alimento que tenga como atributo un nombre de alimento predeterminado
     * @param nombreAlimento es un String
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */

    @Override
    public Collection getAlimentoPorNombre(String nombreAlimento) throws ReadException {
        Collection<Alimento> alimento;
        try {
            alimento = em.createNamedQuery("getAlimentoPorNombre").setParameter("nombreAlimento", nombreAlimento).getResultList();

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return alimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que tenga como atributo un tipo de Alimento predeterminado
     * @param tipoAlimento es una Enumeracion de TipoAlimento
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */

    @Override
    public Collection<Alimento> getAlimentoPorTipo(TipoAlimento tipoAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorTipo").setParameter("tipoAlimento", em.find(Alimento.class, tipoAlimento)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que sea superior al numero dado
     * @param caloriasAlimento es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(Float caloriasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorCaloriasSuperior").setParameter("caloriasAlimento", em.find(Alimento.class, caloriasAlimento)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que sea inferior al numero dado
     * @param caloriasAlimento es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(Float caloriasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorCaloriasMinimo").setParameter("caloriasAlimento", caloriasAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que este dentro de un rango de Numeros dados
     * @param caloriasAlimentoMax es un Float
     * @param caloriasAlimentoMin es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasEntre(Float caloriasAlimentoMax, Float caloriasAlimentoMin) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = (Collection<Alimento>) em.createNamedQuery("getAlimentoPorCaloriasEntre").setParameter("caloriasAlimentoMax", em.find(Alimento.class, caloriasAlimentoMax)).setParameter("caloriasAlimentoMin", em.find(Alimento.class, caloriasAlimentoMax)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que sea superior al numero dado
     * @param grasasAlimento es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorGrasasSuperior(Float grasasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("alimentoPorGrasas").setParameter("alimentos", em.find(Alimento.class, grasasAlimento)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;

    }

    /**
     * Busca una lista de todos los objetos de Alimento que sea inferior al numero dado
     * @param grasasAlimento es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */

    @Override
    public Collection<Alimento> getAlimentoPorGrasasMinimo(Float grasasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorGrasasMinimo").setParameter("grasasAlimento", em.find(Alimento.class, grasasAlimento)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que este dentro de un rango de Numeros dados
     * @param grasasAlimentoMax es un Float
     * @param grasasAlimentoMin es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorGrasasEntre(Float grasasAlimentoMax, Float grasasAlimentoMin) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = (Collection<Alimento>) em.createNamedQuery("getAlimentoPorGrasasEntre").setParameter("grasasAlimentoMax", em.find(Alimento.class, grasasAlimentoMax)).setParameter("grasasAlimentoMin", em.find(Alimento.class, grasasAlimentoMin)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que sea superior al numero dado
     * @param proteinasAlimento es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorProteinasSuperior(Float proteinasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorProteinasSuperior").setParameter("proteinasAlimento", em.find(Alimento.class, proteinasAlimento)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que sea inferior al numero dado
     * @param proteinasAlimento es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorProteinasMinimo(Float proteinasAlimento) throws ReadException {

        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorProteinasMinimo").setParameter("proteinasAlimento", em.find(Alimento.class, proteinasAlimento)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que este dentro de un rango de Numeros dados
     * @param proteinasAlimentoMax es un Float
     * @param proteinasAlimentoMin es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorProteinasEntre(Float proteinasAlimentoMax, Float proteinasAlimentoMin) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = (Collection<Alimento>) em.createNamedQuery("getAlimentoPorProteinasEntre").setParameter("proteinasAlimentoMax", em.find(Alimento.class, proteinasAlimentoMax)).setParameter("proteinasAlimentoMin", em.find(Alimento.class, proteinasAlimentoMin)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que sea superior al numero dado
     * @param carbohidratosAlimento es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(Float carbohidratosAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorCarbohidratosSuperior").setParameter("carbohidratosAlimento", em.find(Alimento.class, carbohidratosAlimento)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que sea inferior al numero dado
     * @param carbohidratosAlimento es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(Float carbohidratosAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorCarbohidratosMinimo").setParameter("carbohidratosAlimento", em.find(Alimento.class, carbohidratosAlimento)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    /**
     * Busca una lista de todos los objetos de Alimento que este dentro de un rango de Numeros dados
     * @param carbohidratosAlimentoMax es un Float
     * @param carbohidratosAlimentoMin es un Float
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(Float carbohidratosAlimentoMax, Float carbohidratosAlimentoMin) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {

            listaAlimento = (Collection<Alimento>) em.createNamedQuery("getAlimentoPorCarbohidratosEntre").setParameter("carbohidratosAlimentoMax", em.find(Alimento.class, carbohidratosAlimentoMax)).setParameter("carbohidratosAlimentoMin", em.find(Alimento.class, carbohidratosAlimentoMin)).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }
    


  

}
