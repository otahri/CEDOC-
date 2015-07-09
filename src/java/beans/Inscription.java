/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author machd
 */
@Entity
@Table(name = "inscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i"),
    @NamedQuery(name = "Inscription.findByIdInscription", query = "SELECT i FROM Inscription i WHERE i.idInscription = :idInscription"),
    @NamedQuery(name = "Inscription.findBySession", query = "SELECT i FROM Inscription i WHERE i.session = :session"),
    @NamedQuery(name = "Inscription.findBySujet", query = "SELECT i FROM Inscription i WHERE i.sujet = :sujet"),
    @NamedQuery(name = "Inscription.findBySoutenance", query = "SELECT i FROM Inscription i WHERE i.soutenance = :soutenance"),
    @NamedQuery(name = "Inscription.findByEtat", query = "SELECT i FROM Inscription i WHERE i.etat = :etat"),
    @NamedQuery(name = "Inscription.findByBoursier", query = "SELECT i FROM Inscription i WHERE i.boursier = :boursier"),
    @NamedQuery(name = "Inscription.findCountByYear", query = "SELECT COUNT(i.idDoctorant),i.session FROM Inscription i GROUP BY i.session"),
    @NamedQuery(name = "Inscription.findCountByYearEtat", query = "SELECT COUNT(i.idDoctorant),i.session FROM Inscription i WHERE i.etat = :etat GROUP BY i.session"),
     @NamedQuery(name = "Inscription.findByDoctorant", query = "SELECT i FROM Inscription i WHERE i.idDoctorant = :idDoctorant"),
    @NamedQuery(name = "Inscription.findByDatesoutenance", query = "SELECT i FROM Inscription i WHERE i.datesoutenance = :datesoutenance")})

public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInscription")
    private Integer idInscription;
    @Size(max = 45)
    @Column(name = "Session")
    private String session;
    @Size(max = 45)
    @Column(name = "Sujet")
    private String sujet;
    @Size(max = 45)
    @Column(name = "Soutenance")
    private String soutenance;
    @Size(max = 45)
    @Column(name = "Etat")
    private String etat;
    @Column(name = "Boursier")
    private Boolean boursier;
    @Temporal(TemporalType.DATE)
    @Column(name = "Date_soutenance")
    private Date datesoutenance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInscription")
    private Collection<Reinscription> reinscriptionCollection;
    @JoinColumn(name = "id_doctorant", referencedColumnName = "idDoctorant")
    @ManyToOne(optional = false)
    private Doctorant idDoctorant;
    @JoinColumn(name = "Encadrant", referencedColumnName = "idProfesseur")
    @ManyToOne(optional = false)
    private Professeur encadrant;
    @JoinColumn(name = "Co_encadrant", referencedColumnName = "idProfesseur")
    @ManyToOne
    private Professeur coencadrant;

    public Inscription() {
    }

    public Inscription(Integer idInscription) {
        this.idInscription = idInscription;
    }

    public Integer getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(Integer idInscription) {
        this.idInscription = idInscription;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getSoutenance() {
        return soutenance;
    }

    public void setSoutenance(String soutenance) {
        this.soutenance = soutenance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Boolean getBoursier() {
        return boursier;
    }

    public void setBoursier(Boolean boursier) {
        this.boursier = boursier;
    }

    public Date getDatesoutenance() {
        return datesoutenance;
    }

    public void setDatesoutenance(Date datesoutenance) {
        this.datesoutenance = datesoutenance;
    }

    @XmlTransient
    public Collection<Reinscription> getReinscriptionCollection() {
        return reinscriptionCollection;
    }

    public void setReinscriptionCollection(Collection<Reinscription> reinscriptionCollection) {
        this.reinscriptionCollection = reinscriptionCollection;
    }

    public Doctorant getIdDoctorant() {
        return idDoctorant;
    }

    public void setIdDoctorant(Doctorant idDoctorant) {
        this.idDoctorant = idDoctorant;
    }

    public Professeur getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(Professeur encadrant) {
        this.encadrant = encadrant;
    }

    public Professeur getCoencadrant() {
        return coencadrant;
    }

    public void setCoencadrant(Professeur coencadrant) {
        this.coencadrant = coencadrant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscription != null ? idInscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.idInscription == null && other.idInscription != null) || (this.idInscription != null && !this.idInscription.equals(other.idInscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idInscription;
    }

}
