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
@Table(name = "appartenance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appartenance.findAll", query = "SELECT a FROM Appartenance a"),
    @NamedQuery(name = "Appartenance.findByIdAppartenance", query = "SELECT a FROM Appartenance a WHERE a.idAppartenance = :idAppartenance"),
    @NamedQuery(name = "Appartenance.findByRole", query = "SELECT a FROM Appartenance a WHERE a.role = :role"),
    @NamedQuery(name = "Appartenance.findByDatedebut", query = "SELECT a FROM Appartenance a WHERE a.datedebut = :datedebut"),
    @NamedQuery(name = "Appartenance.findByDatefin", query = "SELECT a FROM Appartenance a WHERE a.datefin = :datefin")})
public class Appartenance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAppartenance")
    private Integer idAppartenance;
    @Size(max = 45)
    @Column(name = "Role")
    private String role;
    @Column(name = "Date_debut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "Date_fin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @JoinColumn(name = "id_professeur", referencedColumnName = "idProfesseur")
    @ManyToOne(optional = false)
    private Professeur idProfesseur;
    @JoinColumn(name = "id_equipe", referencedColumnName = "idEquipe")
    @ManyToOne(optional = false)
    private Equipe idEquipe;

    public Appartenance() {
    }

    public Appartenance(Integer idAppartenance) {
        this.idAppartenance = idAppartenance;
    }

    public Integer getIdAppartenance() {
        return idAppartenance;
    }

    public void setIdAppartenance(Integer idAppartenance) {
        this.idAppartenance = idAppartenance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Professeur getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Professeur idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Equipe getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Equipe idEquipe) {
        this.idEquipe = idEquipe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAppartenance != null ? idAppartenance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appartenance)) {
            return false;
        }
        Appartenance other = (Appartenance) object;
        if ((this.idAppartenance == null && other.idAppartenance != null) || (this.idAppartenance != null && !this.idAppartenance.equals(other.idAppartenance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Appartenance[ idAppartenance=" + idAppartenance + " ]";
    }
    
}
