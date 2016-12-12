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
@Table(name = "zonas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z"),
    @NamedQuery(name = "Zona.findByIdZona", query = "SELECT z FROM Zona z WHERE z.idZona = :idZona"),
    @NamedQuery(name = "Zona.findByNombreZona", query = "SELECT z FROM Zona z WHERE z.nombreZona = :nombreZona")})
public class Zona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idZona")
    private Integer idZona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreZona")
    private String nombreZona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonasidZona", fetch = FetchType.LAZY)
    private Collection<Mesa> mesaCollection;

    public Zona() {
    }

    public Zona(Integer idZona) {
        this.idZona = idZona;
    }

    public Zona(Integer idZona, String nombreZona) {
        this.idZona = idZona;
        this.nombreZona = nombreZona;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    @XmlTransient
    public Collection<Mesa> getMesaCollection() {
        return mesaCollection;
    }

    public void setMesaCollection(Collection<Mesa> mesaCollection) {
        this.mesaCollection = mesaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZona != null ? idZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.idZona == null && other.idZona != null) || (this.idZona != null && !this.idZona.equals(other.idZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Zona[ idZona=" + idZona + " ]";
    }
    
}
