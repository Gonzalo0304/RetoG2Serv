/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Collection;
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
    private Collection<Cliente> listaClientes;

    /**
     * @associates <{g2.Dieta}>
     */
    @OneToMany(mappedBy = "dietista")    
    private Collection<Dieta>listaDietas;

    /**
     * @associates <{g2.Receta}>
     */
    @OneToMany(mappedBy = "dietista")  
    private Collection<Receta> listaRecetas;

    /**
     * @associates <{g2.Alimento}>
     */
    @OneToMany(mappedBy = "dietista")  
    private Collection<Alimento> listaAlimentos;
    
    @ManyToOne
    private Administrador administrador;

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
