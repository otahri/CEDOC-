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
@Table(name = "doctorant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctorant.findAll", query = "SELECT d FROM Doctorant d"),
    @NamedQuery(name = "Doctorant.findByIdDoctorant", query = "SELECT d FROM Doctorant d WHERE d.idDoctorant = :idDoctorant"),
    @NamedQuery(name = "Doctorant.findByCne", query = "SELECT d FROM Doctorant d WHERE d.cne = :cne"),
    @NamedQuery(name = "Doctorant.findByCin", query = "SELECT d FROM Doctorant d WHERE d.cin = :cin"),
    @NamedQuery(name = "Doctorant.findByNom", query = "SELECT d FROM Doctorant d WHERE d.nom = :nom"),
    @NamedQuery(name = "Doctorant.findByPrenom", query = "SELECT d FROM Doctorant d WHERE d.prenom = :prenom"),
    @NamedQuery(name = "Doctorant.findBySexe", query = "SELECT d FROM Doctorant d WHERE d.sexe = :sexe"),
    @NamedQuery(name = "Doctorant.findByDatenassance", query = "SELECT d FROM Doctorant d WHERE d.datenassance = :datenassance"),
    @NamedQuery(name = "Doctorant.findBySalarie", query = "SELECT d FROM Doctorant d WHERE d.salarie = :salarie"),
    @NamedQuery(name = "Doctorant.findByEmail1", query = "SELECT d FROM Doctorant d WHERE d.email1 = :email1"),
    @NamedQuery(name = "Doctorant.findByEmail2", query = "SELECT d FROM Doctorant d WHERE d.email2 = :email2"),
    @NamedQuery(name = "Doctorant.findByTel1", query = "SELECT d FROM Doctorant d WHERE d.tel1 = :tel1"),
    @NamedQuery(name = "Doctorant.findByTel2", query = "SELECT d FROM Doctorant d WHERE d.tel2 = :tel2"),
    @NamedQuery(name = "Doctorant.findByAdresse", query = "SELECT d FROM Doctorant d WHERE d.adresse = :adresse"),
    @NamedQuery(name = "Doctorant.findByAutorisation", query = "SELECT d FROM Doctorant d WHERE d.autorisation = :autorisation"),
    @NamedQuery(name = "Doctorant.findByEmployeur", query = "SELECT d FROM Doctorant d WHERE d.employeur = :employeur"),
    @NamedQuery(name = "Doctorant.findByLieuemploi", query = "SELECT d FROM Doctorant d WHERE d.lieuemploi = :lieuemploi"),
    @NamedQuery(name = "Doctorant.findByPhoto", query = "SELECT d FROM Doctorant d WHERE d.photo = :photo"),
    @NamedQuery(name = "Doctorant.findByCode", query = "SELECT d FROM Doctorant d WHERE d.code = :code")})
public class Doctorant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDoctorant")
    private Integer idDoctorant;
    @Size(max = 45)
    @Column(name = "CNE")
    private String cne;
    @Size(max = 45)
    @Column(name = "CIN")
    private String cin;
    @Size(max = 45)
    @Column(name = "Nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "Prenom")
    private String prenom;
    @Size(max = 45)
    @Column(name = "Sexe")
    private String sexe;
    @Column(name = "Date_nassance")
    @Temporal(TemporalType.DATE)
    private Date datenassance;
    @Column(name = "Salarie")
    private Boolean salarie;
    @Size(max = 45)
    @Column(name = "email1")
    private String email1;
    @Size(max = 45)
    @Column(name = "email2")
    private String email2;
    @Size(max = 45)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 45)
    @Column(name = "tel2")
    private String tel2;
    @Size(max = 45)
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Autorisation")
    private Boolean autorisation;
    @Size(max = 45)
    @Column(name = "Employeur")
    private String employeur;
    @Size(max = 45)
    @Column(name = "Lieu_emploi")
    private String lieuemploi;
    @Size(max = 255)
    @Column(name = "Photo")
    private String photo;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @JoinColumn(name = "id_nationalite", referencedColumnName = "id_nationalite")
    @ManyToOne
    private Nationalite idNationalite;
    @JoinColumn(name = "ville_emploi", referencedColumnName = "idVille")
    @ManyToOne
    private Ville villeEmploi;
    @JoinColumn(name = "Ville_adresse", referencedColumnName = "idVille")
    @ManyToOne
    private Ville villeadresse;
    @JoinColumn(name = "Ville_naissance", referencedColumnName = "idVille")
    @ManyToOne
    private Ville villenaissance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoctorant")
    private Collection<Inscription> inscriptionCollection ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoctorant")
    private Collection<ObtenirDiplome> obtenirDiplomeCollection;

    public Doctorant() {
    }

    public Doctorant(Integer idDoctorant) {
        this.idDoctorant = idDoctorant;
    }

    public Integer getIdDoctorant() {
        return idDoctorant;
    }

    public void setIdDoctorant(Integer idDoctorant) {
        this.idDoctorant = idDoctorant;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDatenassance() {
        return datenassance;
    }

    public void setDatenassance(Date datenassance) {
        this.datenassance = datenassance;
    }

    public Boolean getSalarie() {
        return salarie;
    }

    public void setSalarie(Boolean salarie) {
        this.salarie = salarie;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Boolean getAutorisation() {
        return autorisation;
    }

    public void setAutorisation(Boolean autorisation) {
        this.autorisation = autorisation;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public String getLieuemploi() {
        return lieuemploi;
    }

    public void setLieuemploi(String lieuemploi) {
        this.lieuemploi = lieuemploi;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Nationalite getIdNationalite() {
        return idNationalite;
    }

    public void setIdNationalite(Nationalite idNationalite) {
        this.idNationalite = idNationalite;
    }

    public Ville getVilleEmploi() {
        return villeEmploi;
    }

    public void setVilleEmploi(Ville villeEmploi) {
        this.villeEmploi = villeEmploi;
    }

    public Ville getVilleadresse() {
        return villeadresse;
    }

    public void setVilleadresse(Ville villeadresse) {
        this.villeadresse = villeadresse;
    }

    public Ville getVillenaissance() {
        return villenaissance;
    }

    public void setVillenaissance(Ville villenaissance) {
        this.villenaissance = villenaissance;
    }

    @XmlTransient
    public Collection<Inscription> getInscriptionCollection() {
        return inscriptionCollection;
    }

    public void setInscriptionCollection(Collection<Inscription> inscriptionCollection) {
        this.inscriptionCollection = inscriptionCollection;
    }

    @XmlTransient
    public Collection<ObtenirDiplome> getObtenirDiplomeCollection() {
        return obtenirDiplomeCollection;
    }

    public void setObtenirDiplomeCollection(Collection<ObtenirDiplome> obtenirDiplomeCollection) {
        this.obtenirDiplomeCollection = obtenirDiplomeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoctorant != null ? idDoctorant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctorant)) {
            return false;
        }
        Doctorant other = (Doctorant) object;
        if ((this.idDoctorant == null && other.idDoctorant != null) || (this.idDoctorant != null && !this.idDoctorant.equals(other.idDoctorant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s \t %s", nom, prenom);
    }
    
    
    
    
   
    
    
}
