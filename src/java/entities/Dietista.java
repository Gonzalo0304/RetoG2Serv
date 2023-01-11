/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Collection;
import java.util.Date;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name = "dietista", schema = "nutrivago")
@DiscriminatorValue("Dietista")
//Querys de la tabla Dietista
@NamedQueries({
    @NamedQuery(name = "getDietistaPorDni", query = "SELECT d FROM Dietista AS d WHERE d.dni = :dni")
    ,
   @NamedQuery(name = "getDietistaTodos", query = "SELECT d FROM Dietista AS d")
})
@XmlRootElement
public class Dietista extends Usuario {

    // atributos
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(as=Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date fechaAlta;

    /**
     * @associates <{g2.Cliente}>
     */
    @OneToMany(fetch = FetchType.EAGER, cascade=ALL, mappedBy = "dietista")
    private Collection<Cliente> listaClientes;

    /**
     * @associates <{g2.Dieta}>
     */
    @OneToMany(fetch = FetchType.EAGER, cascade=ALL, mappedBy = "dietista")
    private Collection<Dieta> listaDietas;

    /**
     * @associates <{g2.Receta}>
     */
    @OneToMany(fetch = FetchType.EAGER, cascade=ALL, mappedBy = "dietista")
    private Collection<Receta> listaRecetas;

    /**
     * @associates <{g2.Alimento}>
     */
    @OneToMany(fetch = FetchType.EAGER, cascade=ALL, mappedBy = "dietista")
    private Collection<Alimento> listaAlimentos;
    @JsonIgnore
    @ManyToOne
    private Administrador administrador;
//Getters and Setters 

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @XmlTransient
    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @XmlTransient
    public Collection<Dieta> getListaDietas() {
        return listaDietas;
    }

    public void setListaDietas(Collection<Dieta> listaDietas) {
        this.listaDietas = listaDietas;
    }

    @XmlTransient
    public Collection<Receta> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(Collection<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    @XmlTransient
    public Collection<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaAlimentos(Collection<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Dietista() {
        super();
    }
}
