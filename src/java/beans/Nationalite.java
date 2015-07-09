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
@Table(name = "nationalite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nationalite.findAll", query = "SELECT n FROM Nationalite n"),
    @NamedQuery(name = "Nationalite.findByIdNationalite", query = "SELECT n FROM Nationalite n WHERE n.idNationalite = :idNationalite"),
    @NamedQuery(name = "Nationalite.findByNationalite", query = "SELECT n FROM Nationalite n WHERE n.nationalite = :nationalite")})
public class Nationalite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nationalite")
    private Integer idNationalite;
    @Size(max = 45)
    @Column(name = "nationalite")
    private String nationalite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNationalite")
    private Collection<Doctorant> doctorantCollection;

    public Nationalite() {
    }

    public Nationalite(Integer idNationalite) {
        this.idNationalite = idNationalite;
    }

    public Integer getIdNationalite() {
        return idNationalite;
    }

    public void setIdNationalite(Integer idNationalite) {
        this.idNationalite = idNationalite;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @XmlTransient
    public Collection<Doctorant> getDoctorantCollection() {
        return doctorantCollection;
    }

    public void setDoctorantCollection(Collection<Doctorant> doctorantCollection) {
        this.doctorantCollection = doctorantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNationalite != null ? idNationalite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nationalite)) {
            return false;
        }
        Nationalite other = (Nationalite) object;
        if ((this.idNationalite == null && other.idNationalite != null) || (this.idNationalite != null && !this.idNationalite.equals(other.idNationalite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nationalite  ;
    }
    
}
