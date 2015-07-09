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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author machd
 */
@Entity
@Table(name = "obtenir_diplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObtenirDiplome.findAll", query = "SELECT o FROM ObtenirDiplome o"),
    @NamedQuery(name = "ObtenirDiplome.findByIdOptention", query = "SELECT o FROM ObtenirDiplome o WHERE o.idOptention = :idOptention"),
    @NamedQuery(name = "ObtenirDiplome.findByAnnee", query = "SELECT o FROM ObtenirDiplome o WHERE o.annee = :annee"),
     @NamedQuery(name = "ObtenirDiplome.findByidDoctorant", query = "SELECT o FROM ObtenirDiplome o WHERE o.idDoctorant = :idDoctorant"),
    @NamedQuery(name = "ObtenirDiplome.findBySpecialiste", query = "SELECT o FROM ObtenirDiplome o WHERE o.specialiste = :specialiste")})
public class ObtenirDiplome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_optention")
    private Integer idOptention;
    @Column(name = "Annee")
    @Temporal(TemporalType.DATE)
    private Date annee;
    @Size(max = 45)
    @Column(name = "specialiste")
    private String specialiste;
    @JoinColumn(name = "id_doctorant", referencedColumnName = "idDoctorant")
    @ManyToOne(optional = false)
    private Doctorant idDoctorant;
    @JoinColumn(name = "id_etablissement", referencedColumnName = "idEtablissement")
    @ManyToOne(optional = false)
    private Etablissement idEtablissement;
    @JoinColumn(name = "id_diplome", referencedColumnName = "idDiplome")
    @ManyToOne(optional = false)
    private Diplome idDiplome;

    public ObtenirDiplome() {
    }

    public ObtenirDiplome(Integer idOptention) {
        this.idOptention = idOptention;
    }

    public Integer getIdOptention() {
        return idOptention;
    }

    public void setIdOptention(Integer idOptention) {
        this.idOptention = idOptention;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public String getSpecialiste() {
        return specialiste;
    }

    public void setSpecialiste(String specialiste) {
        this.specialiste = specialiste;
    }

    public Doctorant getIdDoctorant() {
        return idDoctorant;
    }

    public void setIdDoctorant(Doctorant idDoctorant) {
        this.idDoctorant = idDoctorant;
    }

    public Etablissement getIdEtablissement() {
        return idEtablissement;
    }

    public void setIdEtablissement(Etablissement idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    public Diplome getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Diplome idDiplome) {
        this.idDiplome = idDiplome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOptention != null ? idOptention.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObtenirDiplome)) {
            return false;
        }
        ObtenirDiplome other = (ObtenirDiplome) object;
        if ((this.idOptention == null && other.idOptention != null) || (this.idOptention != null && !this.idOptention.equals(other.idOptention))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.ObtenirDiplome[ idOptention=" + idOptention + " ]";
    }
    
}
