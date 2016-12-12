/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "mesas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m"),
    @NamedQuery(name = "Mesa.findByIdMesas", query = "SELECT m FROM Mesa m WHERE m.idMesas = :idMesas"),
    @NamedQuery(name = "Mesa.findByEstadoMesa", query = "SELECT m FROM Mesa m WHERE m.estadoMesa = :estadoMesa")})
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMesas")
    private Integer idMesas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estadoMesa")
    private String estadoMesa;
    @JoinColumn(name = "zonas_idZona", referencedColumnName = "idZona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Zona zonasidZona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesasidMesas", fetch = FetchType.LAZY)
    private Collection<Reserva> reservaCollection;

    public Mesa() {
    }

    public Mesa(Integer idMesas) {
        this.idMesas = idMesas;
    }

    public Mesa(Integer idMesas, String estadoMesa) {
        this.idMesas = idMesas;
        this.estadoMesa = estadoMesa;
    }

    public Integer getIdMesas() {
        return idMesas;
    }

    public void setIdMesas(Integer idMesas) {
        this.idMesas = idMesas;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public Zona getZonasidZona() {
        return zonasidZona;
    }

    public void setZonasidZona(Zona zonasidZona) {
        this.zonasidZona = zonasidZona;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesas != null ? idMesas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.idMesas == null && other.idMesas != null) || (this.idMesas != null && !this.idMesas.equals(other.idMesas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mesa[ idMesas=" + idMesas + " ]";
    }
    
}
