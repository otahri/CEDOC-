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
@Table(name = "etablissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM Etablissement e"),
    @NamedQuery(name = "Etablissement.findByIdEtablissement", query = "SELECT e FROM Etablissement e WHERE e.idEtablissement = :idEtablissement"),
    @NamedQuery(name = "Etablissement.findByNom", query = "SELECT e FROM Etablissement e WHERE e.nom = :nom")})
public class Etablissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEtablissement")
    private Integer idEtablissement;
    @Size(max = 45)
    @Column(name = "Nom")
    private String nom;
    @JoinColumn(name = "Ville", referencedColumnName = "idVille")
    @ManyToOne(optional = false)
    private Ville ville;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtablissement")
    private Collection<Professeur> professeurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtablissement")
    private Collection<ObtenirDiplome> obtenirDiplomeCollection;

    public Etablissement() {
    }

    public Etablissement(Integer idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    public Integer getIdEtablissement() {
        return idEtablissement;
    }

    public void setIdEtablissement(Integer idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @XmlTransient
    public Collection<Professeur> getProfesseurCollection() {
        return professeurCollection;
    }

    public void setProfesseurCollection(Collection<Professeur> professeurCollection) {
        this.professeurCollection = professeurCollection;
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
        hash += (idEtablissement != null ? idEtablissement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etablissement)) {
            return false;
        }
        Etablissement other = (Etablissement) object;
        if ((this.idEtablissement == null && other.idEtablissement != null) || (this.idEtablissement != null && !this.idEtablissement.equals(other.idEtablissement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
