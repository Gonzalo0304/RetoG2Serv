 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name = "ALIMENTORECETA", schema = "nutrivago")
@XmlRootElement
public class AlimentoReceta implements Serializable{
    @EmbeddedId
    private AlimRecID idAlimentoReceta;
    @MapsId("idRec")
    @ManyToOne
    private Receta receta;
    @MapsId("idAlim")
    @ManyToOne
    private Alimento alimento;
    private Integer cantidad;    

    public AlimentoReceta() {
        super();
    }

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
