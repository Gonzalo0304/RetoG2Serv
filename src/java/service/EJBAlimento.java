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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josue
 */
public class EJBAlimento implements AlimentoInterface {

    @PersistenceContext(unitName = "alimento")
    private EntityManager em;

    @Override
    public void crearAlimento(Alimento alimento) throws CreateException {
        em.persist(alimento);

    }

    @Override
    public void eliminarAlimento(Alimento alimento) throws DeleteException {
        em.remove(em.merge(alimento));
    }

    @Override
    public void modificarAlimento(Alimento alimento) throws UpdateException {
        em.merge(alimento);
    }

    @Override
    public Alimento getAlimentoPorNombre(String nombreAlimento) throws ReadException {
        Alimento alimento;
        alimento= em.find(Alimento.class, nombreAlimento);

    return alimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorTipo(TipoAlimento tipoAlimento) throws ReadException {
Collection<Alimento> listaAlimento;
    listaAlimento= em.createNamedQuery("alimentoPorTipo").setParameter("alimentos",em.find(Alimento.class, tipoAlimento)).getResultList();
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(Float caloriasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorCalorias").setParameter("alimentos",em.find(Alimento.class, caloriasAlimento)).getResultList();
        return listaAlimento;
    }

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(Float caloriasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorCalorias").setParameter("alimentos",em.find(Alimento.class, caloriasAlimento)).getResultList();
        return listaAlimento;    }

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasEntre(Float caloriasAlimentoMax, Float caloriasAlimentoMin) throws ReadException {
Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorCalorias").setParameter("alimentos",em.find(Alimento.class, caloriasAlimentoMax)).getResultList();
        return listaAlimento;    
    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasSuperior(Float grasasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorGrasas").setParameter("alimentos",em.find(Alimento.class, grasasAlimento)).getResultList();
            return listaAlimento;    

    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasMinimo(Float grasasAlimento) throws ReadException {
Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorGrasas").setParameter("alimentos",em.find(Alimento.class, grasasAlimento)).getResultList();
            return listaAlimento;    
    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasEntre(Float grasasAlimentoMax, Float grasasAlimentoMin) throws ReadException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasSuperior(Float proteinasAlimento) throws ReadException {
Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorProteinas").setParameter("alimentos",em.find(Alimento.class, proteinasAlimento)).getResultList();
            return listaAlimento; 
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasMinimo(Float proteinasAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorProteinas").setParameter("alimentos",em.find(Alimento.class, proteinasAlimento)).getResultList();
        return listaAlimento; 
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasEntre(Float proteinasAlimentoMax, Float proteinasAlimentoMin) throws ReadException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(Float carbohidratosAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorCarbohidratos").setParameter("alimentos",em.find(Alimento.class, carbohidratosAlimento)).getResultList();
            return listaAlimento; 
    }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(Float carbohidratosAlimento) throws ReadException {
        Collection<Alimento> listaAlimento;
        listaAlimento= em.createNamedQuery("alimentoPorCarbohidratos").setParameter("alimentos",em.find(Alimento.class, carbohidratosAlimento)).getResultList();
            return listaAlimento;     }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(Float carbohidratosAlimentoMax, Float carbohidratosAlimentoMin) throws ReadException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
