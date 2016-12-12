/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdVentas", query = "SELECT v FROM Venta v WHERE v.idVentas = :idVentas"),
    @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Venta.findByIvaVenta", query = "SELECT v FROM Venta v WHERE v.ivaVenta = :ivaVenta")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentas")
    private Integer idVentas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVenta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivaVenta")
    private int ivaVenta;
    @JoinColumn(name = "sucursales_idsucursales", referencedColumnName = "idsucursales")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursalesIdsucursales;
    @JoinColumn(name = "meseros_idMeseros", referencedColumnName = "idMeseros")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mesero meserosidMeseros;
    @OneToMany(mappedBy = "idVentas", fetch = FetchType.LAZY)
    private Collection<Detalle> detalleCollection;

    public Venta() {
    }

    public Venta(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Venta(Integer idVentas, Date fechaVenta, int ivaVenta) {
        this.idVentas = idVentas;
        this.fechaVenta = fechaVenta;
        this.ivaVenta = ivaVenta;
    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(int ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public Sucursal getSucursalesIdsucursales() {
        return sucursalesIdsucursales;
    }

    public void setSucursalesIdsucursales(Sucursal sucursalesIdsucursales) {
        this.sucursalesIdsucursales = sucursalesIdsucursales;
    }

    public Mesero getMeserosidMeseros() {
        return meserosidMeseros;
    }

    public void setMeserosidMeseros(Mesero meserosidMeseros) {
        this.meserosidMeseros = meserosidMeseros;
    }

    @XmlTransient
    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentas != null ? idVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVentas == null && other.idVentas != null) || (this.idVentas != null && !this.idVentas.equals(other.idVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Venta[ idVentas=" + idVentas + " ]";
    }
    
}
