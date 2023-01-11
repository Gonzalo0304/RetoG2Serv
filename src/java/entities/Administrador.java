/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
 
import java.util.Collection;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
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
    @OneToMany(fetch = FetchType.EAGER, cascade=ALL, mappedBy = "administrador")
    private Collection<Dietista> listaDietistas;

    /**
     * @associates <{g2.Cliente}>
     */
    @OneToMany(fetch = FetchType.EAGER, cascade=ALL, mappedBy = "administrador")
    private Collection<Cliente> listaClientes;

    @XmlTransient
    public Collection<Dietista> getListaDietistas() {
        return listaDietistas;
    }

    public void setListaDietistas(Collection<Dietista> listaDietistas) {
        this.listaDietistas = listaDietistas;
    }

    @XmlTransient
    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
}
