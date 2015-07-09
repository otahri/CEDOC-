/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author machd
 */
@Entity
@Table(name = "professeur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professeur.findAll", query = "SELECT p FROM Professeur p"),
    @NamedQuery(name = "Professeur.findByIdProfesseur", query = "SELECT p FROM Professeur p WHERE p.idProfesseur = :idProfesseur"),
    @NamedQuery(name = "Professeur.findByNom", query = "SELECT p FROM Professeur p WHERE p.nom = :nom"),
    @NamedQuery(name = "Professeur.findByPrenom", query = "SELECT p FROM Professeur p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Professeur.findBySpecialite", query = "SELECT p FROM Professeur p WHERE p.specialite = :specialite"),
    @NamedQuery(name = "Professeur.findByEmail", query = "SELECT p FROM Professeur p WHERE p.email = :email"),
    @NamedQuery(name = "Professeur.findByDepartement", query = "SELECT p FROM Professeur p WHERE p.departement = :departement"),
    @NamedQuery(name = "Professeur.findByTel", query = "SELECT p FROM Professeur p WHERE p.tel = :tel")})
public class Professeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfesseur")
    private Integer idProfesseur;
    @Size(max = 45)
    @Column(name = "Nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "Prenom")
    private String prenom;
    @Size(max = 45)
    @Column(name = "Specialite")
    private String specialite;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Email")
    private String email;
    @Size(max = 45)
    @Column(name = "Departement")
    private String departement;
    @Column(name = "Tel")
    private Integer tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesseur")
    private Collection<Appartenance> appartenanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesseur")
    private Collection<Chef> chefCollection;
    @JoinColumn(name = "id_etablissement", referencedColumnName = "idEtablissement")
    @ManyToOne(optional = false)
    private Etablissement idEtablissement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encadrant")
    private Collection<Inscription> inscriptionCollection;
    @OneToMany(mappedBy = "coencadrant")
    private Collection<Inscription> inscriptionCollection1;

    public Professeur() {
    }

    public Professeur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Integer getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    @XmlTransient
    public Collection<Appartenance> getAppartenanceCollection() {
        return appartenanceCollection;
    }

    public void setAppartenanceCollection(Collection<Appartenance> appartenanceCollection) {
        this.appartenanceCollection = appartenanceCollection;
    }

    @XmlTransient
    public Collection<Chef> getChefCollection() {
        return chefCollection;
    }

    public void setChefCollection(Collection<Chef> chefCollection) {
        this.chefCollection = chefCollection;
    }

    public Etablissement getIdEtablissement() {
        return idEtablissement;
    }

    public void setIdEtablissement(Etablissement idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    @XmlTransient
    public Collection<Inscription> getInscriptionCollection() {
        return inscriptionCollection;
    }

    public void setInscriptionCollection(Collection<Inscription> inscriptionCollection) {
        this.inscriptionCollection = inscriptionCollection;
    }

    @XmlTransient
    public Collection<Inscription> getInscriptionCollection1() {
        return inscriptionCollection1;
    }

    public void setInscriptionCollection1(Collection<Inscription> inscriptionCollection1) {
        this.inscriptionCollection1 = inscriptionCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesseur != null ? idProfesseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professeur)) {
            return false;
        }
        Professeur other = (Professeur) object;
        if ((this.idProfesseur == null && other.idProfesseur != null) || (this.idProfesseur != null && !this.idProfesseur.equals(other.idProfesseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s \t %s", nom, prenom);
    }
    
}
