/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "RECETA", schema = "nutrivago")
@XmlRootElement
public class Receta implements Serializable{
    @Id
    private String idReceta;
    private String nombre;
    private String preparacion;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Enumerated(EnumType.STRING)
    private TipoDieta tipo;
   
    /**
     * @associates <{g2.AlimentoReceta}>
     */
    @OneToMany(mappedBy = "receta")
    private List<Alimento> listaAlimento;   

    /**
     * @associates <{g2.Dieta}>
     */
    @ManyToMany(mappedBy = "listaReceta")    
    private List<Dieta> listaDieta;
    
    /**
     * @associates <{uml.Dietista}>
     */
    @ManyToOne
    private Dietista dietista;


    public Receta() {
        super();
    }

    public String getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Alimento> getListaAlimento() {
        return listaAlimento;
    }

    public void setListaAlimento(List<Alimento> listaAlimento) {
        this.listaAlimento = listaAlimento;
    }

    public TipoDieta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDieta tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Dieta> getListaDieta() {
        return listaDieta;
    }

    public void setListaDieta(List<Dieta> listaDieta) {
        this.listaDieta = listaDieta;
    }

    public Dietista getDietista() {
        return dietista;
    }

    public void setDietista(Dietista dietista) {
        this.dietista = dietista;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Entities.NewEntity[ id=" + idReceta + " ]";
    }
}
