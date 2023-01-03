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

/**
 * Interfaz para EJBAlimento
 * @author josue
 */
public interface AlimentoInterface {

    /**
     * Este metodo crea los alimentos que guardara en la base de datos
     *
     * @param alimento Es un Objeto de la entidad de Alimento que contiene datos
     * @throws excepciones.CreateException se lanza cuando ocurre un error en la
     * creación del objeto alimento en la base de datos
     */
    public void crearAlimento(Alimento alimento) throws CreateException;

    /**
     * Este metodo elimina los alimentos que estan creados en la base de datos
     *
     * @param alimento Es un Objecto de la entidad alimento que contiene los
     * datos para eliminar de la base de Datos
     * @throws excepciones.DeleteException se lanza cuando ocurre un error en la
     * eliminación del objeto Alimento de la base de datos
     */
    public void eliminarAlimento(Alimento alimento) throws DeleteException;

    /**
     * Este metodo Actualiza o cambia los datos de alimentos creados en la base
     * de datos
     *
     * @param alimento es un Objeto de la entidad alimento que contiene los
     * datos para actualizarlo de la base de datos
     *
     * @throws excepciones.UpdateException se lanza cuando ocurre un error en la
     * actualización del objeto Alimento en la base de datos
     */
    public void modificarAlimento(Alimento alimento) throws UpdateException;

    /**
     * Este metodo busca el alimento por la id
     *
     * @param idAlimento Es un String
     * @return Devuelve un Objeto entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto alimento en la base de datos
     */
    public Alimento getAlimentoPorId(String idAlimento) throws ReadException;

    /**
     * Este metodo busca todos los alimentos y los guarda en una Collection
     *
     * @return Devuelve una Lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoTodos() throws ReadException;

    /**
     * Este metodo busca el alimento por su nombre y lo guarda en un objeto de
     * la Entidad alimento
     *
     * @param nombreAlimento Un String de Alimento
     * @return Devuelve un Objecto de la Entidad alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorNombre(String nombreAlimento) throws ReadException;

    /**
     * Este metodo busca por su tipo de Alimento y guarda en una lista todos los
     * alimentos encontrados
     *
     * @param tipoAlimento Es una Enumacion
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorTipo(TipoAlimento tipoAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus calorias, tiene que ser superior a la
     * dada
     *
     * @param caloriasAlimento es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(Float caloriasAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus calorias, tiene que ser inferior a la
     * dada
     *
     * @param caloriasAlimento es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(Float caloriasAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus calorias, tiene que ser inferior e
     * igual y superior e igual a las dadas
     *
     * @param caloriasAlimentoMax es un Float
     * @param caloriasAlimentoMin es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorCaloriasEntre(Float caloriasAlimentoMax, Float caloriasAlimentoMin) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus Grasas , tiene que ser superior a la
     * dada
     *
     * @param grasasAlimento es Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorGrasasSuperior(Float grasasAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus grasas, tiene que ser inferior a la
     * dada
     *
     * @param grasasAlimento es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorGrasasMinimo(Float grasasAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus grasas, tiene que ser inferior e
     * igual y superior e igual a las dadas
     *
     * @param grasasAlimentoMax es un Float
     * @param grasasAlimentoMin es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorGrasasEntre(Float grasasAlimentoMax, Float grasasAlimentoMin) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus proteinas, tiene que ser superior a
     * la dada
     *
     * @param proteinasAlimento es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorProteinasSuperior(Float proteinasAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus proteinas, tiene que ser inferior a
     * la dada
     *
     * @param proteinasAlimento
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorProteinasMinimo(Float proteinasAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus proteinas, tiene que ser inferior e
     * igual y superior e igual a las dadas
     *
     * @param proteinasAlimentoMax es un Float
     * @param proteinasAlimentoMin es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorProteinasEntre(Float proteinasAlimentoMax, Float proteinasAlimentoMin) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus carbohidratos, tiene que ser superior
     * a la dada
     *
     * @param carbohidratosAlimento es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(Float carbohidratosAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus carbohidratos, tiene que ser inferior
     * a la dada
     *
     * @param carbohidratosAlimento es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(Float carbohidratosAlimento) throws ReadException;

    /**
     * Este metodo busca Alimentos por sus carbohidratos, tiene que ser inferior
     * e igual y superior e igual a las dadas
     *
     * @param carbohidratosAlimentoMax es un Float
     * @param carbohidratosAlimentoMin es un Float
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda de los objetos alimento en la base de datos
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(Float carbohidratosAlimentoMax, Float carbohidratosAlimentoMin) throws ReadException;

}
