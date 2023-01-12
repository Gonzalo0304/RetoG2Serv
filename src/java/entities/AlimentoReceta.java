 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name = "ALIMENTORECETA", schema = "nutrivago")
//query de la tabla AlimentoReceta
@NamedQueries({
   @NamedQuery(name="getAlimentoRecetaPorCantidad", query= "SELECT ar FROM AlimentoReceta AS ar WHERE ar.cantidad = :cantidad"),
   @NamedQuery(name="getAlimentoRecetaTodos", query= "SELECT ar FROM AlimentoReceta AS ar")


})
@XmlRootElement
public class AlimentoReceta implements Serializable{
    //Atributos
    @EmbeddedId
    private AlimRecID idAlimentoReceta;
    @MapsId("idRec")
        @JsonIgnore
    @ManyToOne
    private Receta receta;
    @MapsId("idAlim")
        @JsonIgnore
    @ManyToOne
    private Alimento alimento;
    private Integer cantidad;    
//Constructor
    public AlimentoReceta() {
        super();
    }
//Getters y Setters
    public AlimRecID getIdAlimentoReceta() {
        return idAlimentoReceta;
    }

    public void setIdAlimentoReceta(AlimRecID idAlimentoReceta) {
        this.idAlimentoReceta = idAlimentoReceta;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimentoReceta != null ? idAlimentoReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlimentoReceta)) {
            return false;
        }
        AlimentoReceta other = (AlimentoReceta) object;
        if ((this.idAlimentoReceta == null && other.idAlimentoReceta != null) || (this.idAlimentoReceta != null && !this.idAlimentoReceta.equals(other.idAlimentoReceta))) {
            return false;
        }
        return true;
    }
}
