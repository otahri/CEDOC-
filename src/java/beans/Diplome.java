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
@Table(name = "diplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diplome.findAll", query = "SELECT d FROM Diplome d"),
    @NamedQuery(name = "Diplome.findByIdDiplome", query = "SELECT d FROM Diplome d WHERE d.idDiplome = :idDiplome"),
    @NamedQuery(name = "Diplome.findByIntitule", query = "SELECT d FROM Diplome d WHERE d.intitule = :intitule")})
public class Diplome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiplome")
    private Integer idDiplome;
    @Size(max = 45)
    @Column(name = "intitule")
    private String intitule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiplome")
    private Collection<ObtenirDiplome> obtenirDiplomeCollection;

    public Diplome() {
    }

    public Diplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
    }

    public Integer getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
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
        hash += (idDiplome != null ? idDiplome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diplome)) {
            return false;
        }
        Diplome other = (Diplome) object;
        if ((this.idDiplome == null && other.idDiplome != null) || (this.idDiplome != null && !this.idDiplome.equals(other.idDiplome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return intitule;
    }
    
}
