 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="cliente",schema="nutrivago")
@DiscriminatorValue("Cliente")
@XmlRootElement
public class Cliente extends Usuario {
    
    private Float altura;
    private String genero;
    private Float imc;
    private String tieneDietista;
    @Enumerated(EnumType.STRING)
    private EstadoFisico estadoFisico;
    private Float peso;

    /**
     * @associates <{uml.ClienteDieta}>
     */
    @OneToMany(mappedBy = "cliente")
    private Set <ClienteDieta> listaDieta;
    @ManyToOne
    private Dietista dietista;
    @ManyToOne
    private Administrador administrador;

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public String getTieneDietista() {
        return tieneDietista;
    }

    public void setTieneDietista(String tieneDietista) {
        this.tieneDietista = tieneDietista;
    }

    public EstadoFisico getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(EstadoFisico estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    @XmlTransient
    public Set<ClienteDieta> getListaDieta() {
        return listaDieta;
    }

    public void setListaDieta(Set<ClienteDieta> listaDieta) {
        this.listaDieta = listaDieta;
    }

    public Dietista getDietista() {
        return dietista;
    }

    public void setDietista(Dietista dietista) {
        this.dietista = dietista;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }   

    public Cliente() {
        super();
    }
}
