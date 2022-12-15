/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name="dietista",schema="nutrivago")
@DiscriminatorValue("Dietista")
@XmlRootElement
public class Dietista extends Usuario{
    
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    /**
     * @associates <{g2.Cliente}>
     */
    @OneToMany(mappedBy = "dietista")
    private Set<Cliente> listaClientes;

    /**
     * @associates <{g2.Dieta}>
     */
    @OneToMany(mappedBy = "dietista")    
    private Set<Dieta>listaDietas;

    /**
     * @associates <{g2.Receta}>
     */
    @OneToMany(mappedBy = "dietista")  
    private Set<Receta> listaRecetas;

    /**
     * @associates <{g2.Alimento}>
     */
    @OneToMany(mappedBy = "dietista")  
    private Set<Alimento> listaAlimentos;
    
    @ManyToOne
    private Administrador administrador;

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @XmlTransient
    public Set<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Set<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @XmlTransient
    public Set<Dieta> getListaDietas() {
        return listaDietas;
    }

    public void setListaDietas(Set<Dieta> listaDietas) {
        this.listaDietas = listaDietas;
    }

    @XmlTransient
    public Set<Receta> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(Set<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    @XmlTransient
    public Set<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaAlimentos(Set<Alimento> listaAlimentos) {
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
