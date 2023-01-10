/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Dieta;
import entities.Objetivo;
import entities.TipoDieta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 * Interfaz para EJBDieta
 * @author Gonzalo
 */
public interface DietaInterface {
    /**
     * El metodo creara las dietas que seran guardadas en la base de datos
     * @param dieta Es un Objeto de la entidad de Dieta que contiene datos
     * @throws excepciones.CreateException se lanza cuando ocurre un error en la creación de la Dieta
     * en la base de datos
     */
    public void crearDieta(Dieta dieta) throws CreateException;
    /**
     * Este metodo elimina las dietas que existen la base de datos
     * @param dieta Es un Objecto de la entidad Dieta que contiene los datos
     * para eliminar de la base de Datos
     * @throws excepciones.DeleteException se lanza cuando ocurre un error en la eliminación del objeto Dieta
     * de la base de datos
     */
    public void eliminarDieta(Dieta dieta) throws DeleteException;
    /**
     * Este metodo Actualiza o cambia los datos de alimentos creados en la base de datos
     * @param dieta es un Objeto de la entidad alimento que contiene los datos
     * para actualizarlo  de la base de datos     * 
     * @throws excepciones.UpdateException se lanza cuando ocurre un error en la actualización del objeto Dieta
     * en la base de datos
     */
    public void modificarDieta(Dieta dieta) throws UpdateException;
    
    /**
     * Este metodo busca el alimento por su nombre y lo guarda en un objeto de la Entidad alimento
     * @param nombreDieta Un String de Alimento
     * @return Devuelve un Objecto de la Entidad alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la busqueda del objeto alimento
     * en la base de datos
     */
    public Dieta getDietaoPorNombre(String nombreDieta) throws ReadException;

    /**
     * Este metodo busca el alimento por su nombre y lo guarda en un objeto de la Entidad alimento
     * @param idDieta Un String de Alimento
     * @return Devuelve un Objecto de la Entidad alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la busqueda del objeto alimento
     * en la base de datos
     */
    public Dieta getDietaoPorId(String idDieta) throws ReadException;
    
    /**
     * Este metodo busca por su tipo de Alimento y guarda en una lista todos
     * los alimentos encontrados
     * @param tipoDieta Es una Enumacion
     * @return Devuelve una lista de la entidad Alimento
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la busqueda de los  objetos alimento
     * en la base de datos
     */
    public Collection<Dieta> getDietaPorTipo(TipoDieta tipoDieta) throws ReadException;

    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso en funcion a un minimo
     * @param tiempo es un Integer
     * @return Devuelve una lista de Dietas
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la busqueda de las Dietas
     * en la base de datos
     */
    public Collection<Dieta> getDietaPorTiempoMinimo(Integer tiempo) throws ReadException;
    
    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso en funcion de un maximo
     * @param tiempo es un Integer
     * @return Decuelve una lista de dietas
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la busqueda de las Dietas
     * en la base de datos
     */
    public Collection<Dieta> getDietaPorTiempoMaximo(Integer tiempo) throws ReadException;
    
    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso entre un minimo y un maximo
     * @param tiempoMax es un Integer
     * @param tiempoMin es un Integer
     * @return Decuelve una lista de dietas
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la busqueda de las Dietas
     * en la base de datos
     */
    public Collection<Dieta> getDietaPorTiempoEntre(Integer tiempoMax, Integer tiempoMin) throws ReadException;

    /**
     * Este metodo busca por el Objetivo de la Dieta
     * @param OBJETIVO es una Enumeation
     * @return
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la busqueda de las Dietas
     * en la base de datos
     */
    public Collection<Dieta> getDietaPorObjetivo (Objetivo OBJETIVO) throws ReadException;
    
    /**
     * Este metodo muestra todas las Dietas existentes
     * @return
     * @throws ReadException 
     */
    public Collection<Dieta> getDietaAll() throws ReadException;
}
