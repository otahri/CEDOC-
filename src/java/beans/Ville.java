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
@Table(name = "Ville")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ville.findAll", query = "SELECT v FROM Ville v"),
    @NamedQuery(name = "Ville.findByIdVille", query = "SELECT v FROM Ville v WHERE v.idVille = :idVille"),
    @NamedQuery(name = "Ville.findByNom", query = "SELECT v FROM Ville v WHERE v.nom = :nom")})
public class Ville implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVille")
    private Integer idVille;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villeEmploi")
    private Collection<Doctorant> doctorantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villeadresse")
    private Collection<Doctorant> doctorantCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villenaissance")
    private Collection<Doctorant> doctorantCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ville")
    private Collection<Etablissement> etablissementCollection;

    public Ville() {
    }

    public Ville(Integer idVille) {
        this.idVille = idVille;
    }

    public Integer getIdVille() {
        return idVille;
    }

    public void setIdVille(Integer idVille) {
        this.idVille = idVille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Doctorant> getDoctorantCollection() {
        return doctorantCollection;
    }

    public void setDoctorantCollection(Collection<Doctorant> doctorantCollection) {
        this.doctorantCollection = doctorantCollection;
    }

    @XmlTransient
    public Collection<Doctorant> getDoctorantCollection1() {
        return doctorantCollection1;
    }

    public void setDoctorantCollection1(Collection<Doctorant> doctorantCollection1) {
        this.doctorantCollection1 = doctorantCollection1;
    }

    @XmlTransient
    public Collection<Doctorant> getDoctorantCollection2() {
        return doctorantCollection2;
    }

    public void setDoctorantCollection2(Collection<Doctorant> doctorantCollection2) {
        this.doctorantCollection2 = doctorantCollection2;
    }

    @XmlTransient
    public Collection<Etablissement> getEtablissementCollection() {
        return etablissementCollection;
    }

    public void setEtablissementCollection(Collection<Etablissement> etablissementCollection) {
        this.etablissementCollection = etablissementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVille != null ? idVille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ville)) {
            return false;
        }
        Ville other = (Ville) object;
        if ((this.idVille == null && other.idVille != null) || (this.idVille != null && !this.idVille.equals(other.idVille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
