/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name = "DIETA", schema = "nutrivago")
@XmlRootElement
public class Dieta implements Serializable{
    @Id
    private String idDieta;
    private String nombre;
    private Integer tiempo;
    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;
    
    /**
     * @associates <{uml.Dietista}>
     */
    @ManyToOne
    private Dietista dietista;
    
    /**
     * @associates <{uml.Receta}>
     */
    @ManyToMany
    @JoinTable(name = "dieta_receta", schema = "nutrivago")
    private Set <Receta> listaReceta;
    @Enumerated(EnumType.STRING)
    private TipoDieta tipo;

    /**
     * @associates <{uml.ClienteDieta}>
     */
    @OneToMany(mappedBy = "dieta")
    private Set <ClienteDieta> listaCliente;

    public Dieta() {
        super();
    }

    public String getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    @XmlTransient
    public Set <Receta> getListaReceta() {
        return listaReceta;
    }

    public void setListaReceta(Set <Receta> listaReceta) {
        this.listaReceta = listaReceta;
    }

    public TipoDieta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDieta tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Set <ClienteDieta> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(Set <ClienteDieta> listaCliente) {
        this.listaCliente = listaCliente;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDieta != null ? idDieta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dieta)) {
            return false;
        }
        Dieta other = (Dieta) object;
        if ((this.idDieta == null && other.idDieta != null) || (this.idDieta != null && !this.idDieta.equals(other.idDieta))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Entities.NewEntity[ id=" + idDieta + " ]";
    }
}
