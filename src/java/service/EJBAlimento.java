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

    @Override
    public Alimento getAlimentoPorId(String idAlimento) throws ReadException {
        Alimento alimento;
        try {
            alimento = em.find(Alimento.class, idAlimento);

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return alimento;
    }

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

    @Override
    public Collection<Alimento> getAlimentoPorTipo(TipoAlimento tipoAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorTipo").setParameter("tipoAlimento", tipoAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(Float caloriasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorCaloriasSuperior").setParameter("caloriasAlimento", caloriasAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return listaAlimento;
    }

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

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasEntre(Float caloriasAlimentoMax, Float caloriasAlimentoMin) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = (Collection<Alimento>) em.createNamedQuery("getAlimentoPorCaloriasEntre").setParameter("caloriasAlimentoMax", caloriasAlimentoMax).setParameter("caloriasAlimentoMin", caloriasAlimentoMin).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasSuperior(Float grasasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("alimentoPorGrasas").setParameter("alimentos", grasasAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;

    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasMinimo(Float grasasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorGrasasMinimo").setParameter("grasasAlimento", grasasAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasEntre(Float grasasAlimentoMax, Float grasasAlimentoMin) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = (Collection<Alimento>) em.createNamedQuery("getAlimentoPorGrasasEntre").setParameter("grasasAlimentoMax", grasasAlimentoMax).setParameter("grasasAlimentoMin", grasasAlimentoMin).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasSuperior(Float proteinasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorProteinasSuperior").setParameter("proteinasAlimento", proteinasAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasMinimo(Float proteinasAlimento) throws ReadException {

        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorProteinasMinimo").setParameter("proteinasAlimento", proteinasAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasEntre(Float proteinasAlimentoMax, Float proteinasAlimentoMin) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = (Collection<Alimento>) em.createNamedQuery("getAlimentoPorProteinasEntre").setParameter("proteinasAlimentoMax", proteinasAlimentoMax).setParameter("proteinasAlimentoMin", proteinasAlimentoMin).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(Float carbohidratosAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorCarbohidratosSuperior").setParameter("carbohidratosAlimento", carbohidratosAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(Float carbohidratosAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {
            listaAlimento = em.createNamedQuery("getAlimentoPorCarbohidratosMinimo").setParameter("carbohidratosAlimento", carbohidratosAlimento).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(Float carbohidratosAlimentoMax, Float carbohidratosAlimentoMin) throws ReadException {
        Collection<Alimento> listaAlimento;
        try {

            listaAlimento = (Collection<Alimento>) em.createNamedQuery("getAlimentoPorCarbohidratosEntre").setParameter("carbohidratosAlimentoMax", carbohidratosAlimentoMax).setParameter("carbohidratosAlimentoMin", carbohidratosAlimentoMin).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimento;
    }

}
