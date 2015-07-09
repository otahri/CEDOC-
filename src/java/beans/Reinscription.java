/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author machd
 */
@Entity
@Table(name = "reinscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reinscription.findAll", query = "SELECT r FROM Reinscription r"),
    @NamedQuery(name = "Reinscription.findByIdReinscription", query = "SELECT r FROM Reinscription r WHERE r.idReinscription = :idReinscription"),
    @NamedQuery(name = "Reinscription.findByDate", query = "SELECT r FROM Reinscription r WHERE r.date = :date")})
public class Reinscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReinscription")
    private Integer idReinscription;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "id_inscription", referencedColumnName = "idInscription")
    @ManyToOne(optional = false)
    private Inscription idInscription;

    public Reinscription() {
    }

    public Reinscription(Integer idReinscription) {
        this.idReinscription = idReinscription;
    }

    public Integer getIdReinscription() {
        return idReinscription;
    }

    public void setIdReinscription(Integer idReinscription) {
        this.idReinscription = idReinscription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Inscription getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(Inscription idInscription) {
        this.idInscription = idInscription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReinscription != null ? idReinscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reinscription)) {
            return false;
        }
        Reinscription other = (Reinscription) object;
        if ((this.idReinscription == null && other.idReinscription != null) || (this.idReinscription != null && !this.idReinscription.equals(other.idReinscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idInscription.toString();
    }
    
}
