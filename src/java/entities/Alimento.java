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
@Table(name = "ALIMENTO", schema = "nutrivago")
@XmlRootElement
public class Alimento implements Serializable{
    @Id
    private String idAlimento;
    @Enumerated(EnumType.STRING)
    private TipoAlimento TIPO;
    private String nombre;
    private Float calorias;
    private Float grasasTotales;
    private Float proteinas;
    private Float carbohidratos;
    @Temporal(TemporalType.DATE)
    private Date fechaInsert;
    
    /**
     * @associates <{uml.Dietista}>
     */
    @ManyToOne
    private Dietista dietista;

    /**
     * @associates <{g2.AlimentoReceta}>
     */
    @OneToMany(mappedBy = "alimento") 
    private Collection<AlimentoReceta> listaReceta;
    public Alimento() {
        super();
    }

    public String getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(String idAlimento) {
        this.idAlimento = idAlimento;
    }

    public TipoAlimento getTIPO() {
        return TIPO;
    }

    public void setTIPO(TipoAlimento TIPO) {
        this.TIPO = TIPO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getCalorias() {
        return calorias;
    }

    public void setCalorias(Float calorias) {
        this.calorias = calorias;
    }

    public Float getGrasasTotales() {
        return grasasTotales;
    }

    public void setGrasasTotales(Float grasasTotales) {
        this.grasasTotales = grasasTotales;
    }

    public Float getProteinas() {
        return proteinas;
    }

    public void setProteinas(Float proteinas) {
        this.proteinas = proteinas;
    }

    public Float getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    public Dietista getDietista() {
        return dietista;
    }

    public void setDietista(Dietista dietista) {
        this.dietista = dietista;
    }

    @XmlTransient
    public Collection<AlimentoReceta> getListaReceta() {
        return listaReceta;
    }

    public void setListaReceta(Collection<AlimentoReceta> listaReceta) {
        this.listaReceta = listaReceta;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimento != null ? idAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idAlimento == null && other.idAlimento != null) || (this.idAlimento != null && !this.idAlimento.equals(other.idAlimento))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Entities.NewEntity[ id=" + idAlimento + " ]";
    }
}
