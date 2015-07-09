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
@Table(name = "laboratoire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboratoire.findAll", query = "SELECT l FROM Laboratoire l"),
    @NamedQuery(name = "Laboratoire.findByIdLaboratoire", query = "SELECT l FROM Laboratoire l WHERE l.idLaboratoire = :idLaboratoire"),
    @NamedQuery(name = "Laboratoire.findByNom", query = "SELECT l FROM Laboratoire l WHERE l.nom = :nom"),
    @NamedQuery(name = "Laboratoire.findByDescription", query = "SELECT l FROM Laboratoire l WHERE l.description = :description"),
    @NamedQuery(name = "Laboratoire.findByUrl", query = "SELECT l FROM Laboratoire l WHERE l.url = :url"),
    @NamedQuery(name = "Laboratoire.findByAcronyme", query = "SELECT l FROM Laboratoire l WHERE l.acronyme = :acronyme"),
    @NamedQuery(name = "Laboratoire.findByDatecreation", query = "SELECT l FROM Laboratoire l WHERE l.datecreation = :datecreation"),
    @NamedQuery(name = "Laboratoire.findByLogo", query = "SELECT l FROM Laboratoire l WHERE l.logo = :logo")})
public class Laboratoire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLaboratoire")
    private Integer idLaboratoire;
    @Size(max = 100)
    @Column(name = "Nom")
    private String nom;
    @Size(max = 500)
    @Column(name = "Description")
    private String description;
    @Size(max = 45)
    @Column(name = "Url")
    private String url;
    @Size(max = 45)
    @Column(name = "Acronyme")
    private String acronyme;
    @Column(name = "Date_creation")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Size(max = 255)
    @Column(name = "Logo")
    private String logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLaboratoire")
    private Collection<Chef> chefCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLaboratoire")
    private Collection<Equipe> equipeCollection;

    public Laboratoire() {
    }

    public Laboratoire(Integer idLaboratoire) {
        this.idLaboratoire = idLaboratoire;
    }

    public Integer getIdLaboratoire() {
        return idLaboratoire;
    }

    public void setIdLaboratoire(Integer idLaboratoire) {
        this.idLaboratoire = idLaboratoire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @XmlTransient
    public Collection<Chef> getChefCollection() {
        return chefCollection;
    }

    public void setChefCollection(Collection<Chef> chefCollection) {
        this.chefCollection = chefCollection;
    }

    @XmlTransient
    public Collection<Equipe> getEquipeCollection() {
        return equipeCollection;
    }
   

    public void setEquipeCollection(Collection<Equipe> equipeCollection) {
        this.equipeCollection = equipeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLaboratoire != null ? idLaboratoire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratoire)) {
            return false;
        }
        Laboratoire other = (Laboratoire) object;
        if ((this.idLaboratoire == null && other.idLaboratoire != null) || (this.idLaboratoire != null && !this.idLaboratoire.equals(other.idLaboratoire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return acronyme ;
    }
    
}
