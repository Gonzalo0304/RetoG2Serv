/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jon
 */
@Entity
@Table(name = "RECETA", schema = "nutrivago")

@NamedQueries({
 @NamedQuery(name="getRecetaTodos", query= "SELECT r FROM Receta AS r"),
    
    @NamedQuery(name="getRecetasAlfabeticamente", query= "SELECT r FROM Receta AS r WHERE r.dietista.dni in (SELECT u FROM Usuario u WHERE r.dietista.dni = u.dni ) ORDER BY r.nombre "),
    
    @NamedQuery(name="getRecetaFechaCreacion", query= "SELECT r FROM Receta AS r WHERE r.dietista.dni in (SELECT u FROM Usuario u WHERE r.dietista.dni = u.dni ) ORDER BY r.fechaCreacion DESC"),
    
    
    
    @NamedQuery(name="getRecetaPorId", query= "SELECT r FROM Receta AS r WHERE r.idReceta = :idReceta"),
    
   
    @NamedQuery(name="getRecetaNombreDietista", query= "SELECT r FROM Receta AS r WHERE r.dietista.dni in (SELECT u FROM Usuario u WHERE r.dietista.dni = u.dni AND u.nombre =:nombreDietista)"),
       
 @NamedQuery(name="getNombreReceta", query= "SELECT r FROM Receta AS r WHERE r.dietista.dni in (SELECT u FROM Usuario u WHERE r.dietista.dni = u.dni )AND r.nombre=:nombreReceta"),
 
 @NamedQuery(name="getRecetaTipo", query= "SELECT r FROM Receta AS r WHERE r.dietista.dni in (SELECT u FROM Usuario u WHERE r.dietista.dni = u.dni )AND r.TIPO=:tipoReceta")
       
 //FALLO
})

@XmlRootElement
public class Receta implements Serializable {

    @Id
    private String idReceta;
    private String nombre;
    private String preparacion;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Enumerated(EnumType.STRING)
    private TipoDieta TIPO;

    /**
     * @associates <{g2.AlimentoReceta}>
     */
    @OneToMany(mappedBy = "receta")
    private Collection<AlimentoReceta> listaAlimento;

    /**
     * @associates <{g2.Dieta}>
     */
    @ManyToMany(mappedBy = "listaReceta")
    private Collection<Dieta> listaDieta;

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
    public Collection<AlimentoReceta> getListaAlimento() {
        return listaAlimento;
    }

    public void setListaAlimento(Collection<AlimentoReceta> listaAlimento) {
        this.listaAlimento = listaAlimento;
    }

    public TipoDieta getTIPO() {
        return TIPO;
    }

    public void setTIPO(TipoDieta TIPO) {
        this.TIPO = TIPO;
    }

    @XmlTransient
    public Collection<Dieta> getListaDieta() {
        return listaDieta;
    }

    public void setListaDieta(Collection<Dieta> listaDieta) {
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
