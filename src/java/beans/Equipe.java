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
@Table(name = "equipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e"),
    @NamedQuery(name = "Equipe.findByIdEquipe", query = "SELECT e FROM Equipe e WHERE e.idEquipe = :idEquipe"),
    @NamedQuery(name = "Equipe.findByNom", query = "SELECT e FROM Equipe e WHERE e.nom = :nom"),
    @NamedQuery(name = "Equipe.findByDescription", query = "SELECT e FROM Equipe e WHERE e.description = :description"),
    @NamedQuery(name = "Equipe.findByUrl", query = "SELECT e FROM Equipe e WHERE e.url = :url"),
    @NamedQuery(name = "Equipe.findByAcronyme", query = "SELECT e FROM Equipe e WHERE e.acronyme = :acronyme"),
    @NamedQuery(name = "Equipe.findByDatecreation", query = "SELECT e FROM Equipe e WHERE e.datecreation = :datecreation")})
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipe")
    private Integer idEquipe;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipe")
    private Collection<Appartenance> appartenanceCollection;
    @JoinColumn(name = "id_laboratoire", referencedColumnName = "idLaboratoire")
    @ManyToOne(optional = false)
    private Laboratoire idLaboratoire;

    public Equipe() {
    }

    public Equipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Equipe(Laboratoire idLaboratoire) {
        this.idLaboratoire = idLaboratoire;
    }

    
    
    

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
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

    @XmlTransient
    public Collection<Appartenance> getAppartenanceCollection() {
        return appartenanceCollection;
    }

    public void setAppartenanceCollection(Collection<Appartenance> appartenanceCollection) {
        this.appartenanceCollection = appartenanceCollection;
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
        hash += (idEquipe != null ? idEquipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.idEquipe == null && other.idEquipe != null) || (this.idEquipe != null && !this.idEquipe.equals(other.idEquipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return acronyme;
    }
    
}
