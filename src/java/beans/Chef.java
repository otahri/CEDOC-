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
@Table(name = "Chef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chef.findAll", query = "SELECT c FROM Chef c"),
    @NamedQuery(name = "Chef.findByIdChef", query = "SELECT c FROM Chef c WHERE c.idChef = :idChef"),
    @NamedQuery(name = "Chef.findByDateDebut", query = "SELECT c FROM Chef c WHERE c.dateDebut = :dateDebut"),
    @NamedQuery(name = "Chef.findByDateFin", query = "SELECT c FROM Chef c WHERE c.dateFin = :dateFin")})
public class Chef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Chef")
    private Integer idChef;
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "id_professeur", referencedColumnName = "idProfesseur")
    @ManyToOne(optional = false)
    private Professeur idProfesseur;
    @JoinColumn(name = "id_laboratoire", referencedColumnName = "idLaboratoire")
    @ManyToOne(optional = false)
    private Laboratoire idLaboratoire;

    public Chef() {
    }

    public Chef(Integer idChef) {
        this.idChef = idChef;
    }

    public Integer getIdChef() {
        return idChef;
    }

    public void setIdChef(Integer idChef) {
        this.idChef = idChef;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Professeur getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Professeur idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Laboratoire getIdLaboratoire() {
        return idLaboratoire;
    }

    public void setIdLaboratoire(Laboratoire idLaboratoire) {
        this.idLaboratoire = idLaboratoire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChef != null ? idChef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chef)) {
            return false;
        }
        Chef other = (Chef) object;
        if ((this.idChef == null && other.idChef != null) || (this.idChef != null && !this.idChef.equals(other.idChef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Chef[ idChef=" + idChef + " ]";
    }
    
}
