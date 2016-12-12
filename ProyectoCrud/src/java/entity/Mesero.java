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
@Table(name = "meseros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesero.findAll", query = "SELECT m FROM Mesero m"),
    @NamedQuery(name = "Mesero.findByIdMeseros", query = "SELECT m FROM Mesero m WHERE m.idMeseros = :idMeseros"),
    @NamedQuery(name = "Mesero.findByEps", query = "SELECT m FROM Mesero m WHERE m.eps = :eps"),
    @NamedQuery(name = "Mesero.findBySueldo", query = "SELECT m FROM Mesero m WHERE m.sueldo = :sueldo")})
public class Mesero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMeseros")
    private Integer idMeseros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "eps")
    private String eps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo")
    private double sueldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meserosidMeseros", fetch = FetchType.LAZY)
    private Collection<Venta> ventaCollection;
    @JoinColumn(name = "personas_idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personasidPersona;

    public Mesero() {
    }

    public Mesero(Integer idMeseros) {
        this.idMeseros = idMeseros;
    }

    public Mesero(Integer idMeseros, String eps, double sueldo) {
        this.idMeseros = idMeseros;
        this.eps = eps;
        this.sueldo = sueldo;
    }

    public Integer getIdMeseros() {
        return idMeseros;
    }

    public void setIdMeseros(Integer idMeseros) {
        this.idMeseros = idMeseros;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    public Persona getPersonasidPersona() {
        return personasidPersona;
    }

    public void setPersonasidPersona(Persona personasidPersona) {
        this.personasidPersona = personasidPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMeseros != null ? idMeseros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesero)) {
            return false;
        }
        Mesero other = (Mesero) object;
        if ((this.idMeseros == null && other.idMeseros != null) || (this.idMeseros != null && !this.idMeseros.equals(other.idMeseros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mesero[ idMeseros=" + idMeseros + " ]";
    }
    
}
