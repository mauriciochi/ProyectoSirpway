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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tiposolicitudes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposolicitud.findAll", query = "SELECT t FROM Tiposolicitud t"),
    @NamedQuery(name = "Tiposolicitud.findByIdTipoSolicitud", query = "SELECT t FROM Tiposolicitud t WHERE t.idTipoSolicitud = :idTipoSolicitud"),
    @NamedQuery(name = "Tiposolicitud.findByNombreSolicitud", query = "SELECT t FROM Tiposolicitud t WHERE t.nombreSolicitud = :nombreSolicitud")})
public class Tiposolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoSolicitud")
    private Integer idTipoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombreSolicitud")
    private String nombreSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoSolicitudesidTipoSolicitud", fetch = FetchType.LAZY)
    private Collection<Solicitud> solicitudCollection;

    public Tiposolicitud() {
    }

    public Tiposolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public Tiposolicitud(Integer idTipoSolicitud, String nombreSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
        this.nombreSolicitud = nombreSolicitud;
    }

    public Integer getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public String getNombreSolicitud() {
        return nombreSolicitud;
    }

    public void setNombreSolicitud(String nombreSolicitud) {
        this.nombreSolicitud = nombreSolicitud;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSolicitud != null ? idTipoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposolicitud)) {
            return false;
        }
        Tiposolicitud other = (Tiposolicitud) object;
        if ((this.idTipoSolicitud == null && other.idTipoSolicitud != null) || (this.idTipoSolicitud != null && !this.idTipoSolicitud.equals(other.idTipoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tiposolicitud[ idTipoSolicitud=" + idTipoSolicitud + " ]";
    }
    
}
