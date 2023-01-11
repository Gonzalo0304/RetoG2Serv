/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name="getDietaTodos", query= "SELECT d FROM Dieta d"),
    @NamedQuery(name="getDietaPorId", query= "SELECT d FROM Dieta d WHERE idDieta = :idDieta"),
    @NamedQuery(name="getDietaPorNombre", query= "SELECT d FROM Dieta d WHERE nombre = :nombreDieta"),
    @NamedQuery(name="getDietaPorTipo", query= "SELECT d FROM Dieta d WHERE tipo = :tipoDieta"),
    @NamedQuery(name="getDietaPorObjetivo", query= "SELECT d FROM Dieta d WHERE Objetivo = :objetivoDieta"),
    
    @NamedQuery(name="getDietaPorTiempoSuperior", query= "SELECT d FROM Dieta d WHERE Tiempo>tiempoDieta"),
    @NamedQuery(name="getDietaPorTiempoMinimo", query= "SELECT d FROM Dieta d WHERE Tiempo<tiempoDieta"),
    @NamedQuery(name="getDietaPorTiempoEntre", query= "SELECT d FROM Dieta d WHERE Tiempo<= :tiempoDietaMax and Tiempo>= :tiempoDietaMin"),
})
@XmlRootElement
public class Dieta implements Serializable{
    
    @Id
    private String idDieta;
    private String nombre;
    private Integer tiempo;
    @Enumerated(EnumType.STRING)
    private Objetivo OBJETIVO;
    
    /**
     * @associates <{uml.Dietista}>
     */
        @JsonIgnore
    @ManyToOne
    private Dietista dietista;
    
    /**
     * @associates <{uml.Receta}>
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dietareceta", schema = "nutrivago")
    private Collection<Receta> listaReceta;
    @Enumerated(EnumType.STRING)
    private TipoDieta tipo;

    /**
     * @associates <{uml.ClienteDieta}>
     */
    @OneToMany(fetch = FetchType.EAGER, cascade=ALL,mappedBy = "dieta")
    private Collection <ClienteDieta> listaCliente;

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
        return OBJETIVO;
    }

    public void setOBJETIVO(Objetivo OBJETIVO) {
        this.OBJETIVO = OBJETIVO;
    }

    @XmlTransient
    public Collection <Receta> getListaReceta() {
        return listaReceta;
    }

    public void setListaReceta(Collection <Receta> listaReceta) {
        this.listaReceta = listaReceta;
    }

    public TipoDieta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDieta tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection <ClienteDieta> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(Collection <ClienteDieta> listaCliente) {
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
