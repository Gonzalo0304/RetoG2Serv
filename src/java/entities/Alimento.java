/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "ALIMENTO", schema = "nutrivago")
/**
 * Consultas Querys de la tabla Alimento
 */
@NamedQueries({
    @NamedQuery(name = "getAlimentoPorId", query = "SELECT a FROM Alimento AS a WHERE a.idAlimento = :idAlimento")
    ,
   @NamedQuery(name = "getAlimentoTodos", query = "SELECT a FROM Alimento AS a")
    ,
   @NamedQuery(name = "getAlimentoPorNombre", query = "SELECT a FROM Alimento AS a WHERE a.nombre = :nombreAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorTipo", query = "SELECT a FROM Alimento AS a WHERE a.TIPO = :tipoAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorCaloriasSuperior", query = "SELECT a FROM Alimento AS a WHERE a.calorias > :caloriasAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorCaloriasMinimo", query = "SELECT a FROM Alimento AS a WHERE a.calorias < :caloriasAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorCaloriasEntre", query = "SELECT a FROM Alimento AS a WHERE a.calorias <= :caloriasAlimentoMax AND a.calorias>= :caloriasAlimentoMin")
    ,
    @NamedQuery(name = "getAlimentoPorGrasasSuperior", query = "SELECT a FROM Alimento AS a WHERE a.grasasTotales > :grasasAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorGrasasMinimo", query = "SELECT a FROM Alimento AS a WHERE a.grasasTotales < :grasasAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorGrasasEntre", query = "SELECT a FROM Alimento AS a WHERE a.grasasTotales <= :grasasAlimentoMax AND a.grasasTotales >= :grasasAlimentoMin")
    ,
    @NamedQuery(name = "getAlimentoPorProteinasSuperior", query = "SELECT a FROM Alimento AS a WHERE a.proteinas > :proteinasAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorProteinasMinimo", query = "SELECT a FROM Alimento AS a WHERE a.proteinas < :proteinasAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorProteinasEntre", query = "SELECT a FROM Alimento AS a WHERE a.proteinas <= :proteinasAlimentoMax AND a.proteinas >= :proteinasAlimentoMin")
    ,
   @NamedQuery(name = "getAlimentoPorCarbohidratosSuperior", query = "SELECT a FROM Alimento AS a WHERE a.carbohidratos > :carbohidratosAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorCarbohidratosMinimo", query = "SELECT a FROM Alimento AS a WHERE a.carbohidratos < :carbohidratosAlimento")
    ,
    @NamedQuery(name = "getAlimentoPorCarbohidratosEntre", query = "SELECT a FROM Alimento AS a WHERE a.carbohidratos <= :carbohidratosAlimentoMax AND a.carbohidratos >= :carbohidratosAlimentoMin")
})
@XmlRootElement
public class Alimento implements Serializable {
//Atributos
    @Id
    private String idAlimento;
    @Enumerated(EnumType.STRING)
    private TipoAlimento TIPO;
    private String nombre;
    private Float calorias;
    private Float grasasTotales;
    private Float proteinas;
    private Float carbohidratos;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(as=Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date fechaInsert;

    /**
     * @associates <{uml.Dietista}>
     */
    @JsonIgnore
    @ManyToOne
    private Dietista dietista;

    /**
     * @associates <{g2.AlimentoReceta}>
     */
    @OneToMany(fetch = FetchType.EAGER, cascade=ALL, mappedBy = "alimento")
    private Collection<AlimentoReceta> listaAlimentoReceta;
//Constructor
    public Alimento() {
        super();
    }
//Getters y Setters
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
    public Collection<AlimentoReceta> getListaAlimentoReceta() {
        return listaAlimentoReceta;
    }

    public void setListaReceta(Collection<AlimentoReceta> listaAlimentoReceta) {
        this.listaAlimentoReceta = listaAlimentoReceta;
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

    public void setTIPO(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
