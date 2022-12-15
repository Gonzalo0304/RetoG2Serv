/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
 
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name="administrador",schema="nutrivago")
@DiscriminatorValue("Administrador")
@XmlRootElement
public class Administrador extends Usuario {
        public Administrador() {
        super();
    }
    /**
     * @associates <{g2.Dietista}>
     */
    @OneToMany(mappedBy = "administrador")
    private Set<Dietista> listaDietistas;

    /**
     * @associates <{g2.Cliente}>
     */
    @OneToMany(mappedBy = "administrador")
    private Set<Cliente> listaClientes;

    @XmlTransient
    public Set<Dietista> getListaDietistas() {
        return listaDietistas;
    }

    public void setListaDietistas(Set<Dietista> listaDietistas) {
        this.listaDietistas = listaDietistas;
    }

    @XmlTransient
    public Set<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Set<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
}
