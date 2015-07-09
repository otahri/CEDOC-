/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package authenti;

import dao.UserDAO;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginBean")
@SessionScoped
/**
 *
 * @author User
 */
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String password;
    private String uname;
    private String role;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String loginProject() throws SQLException {
        String role = UserDAO.login(uname, password);
        if (role != null) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
            this.role = role;

            return "index?faces-redirect=true";
        } else {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            null,
                            "Combinaison invalide, Réessayer!"));

            // invalidate session, and redirect to other pages
            //message = "Invalid Login. Please Try Again!";
            return "login";
        }
    }

    public Boolean exist() {
        String nom = UserDAO.exist(password);
        if (nom != null) {
            this.nom=nom;
            return true;
        }
        else {
            return false;
        
        }

    }
    
    
    public String etat(){
        int id =UserDAO.iddoc(password);
        String etat= UserDAO.etat(id);
        if (etat!=null) {
            return etat;
        }
        else {
        return "En attente";
        }
    
    }
    
    
    public int iddoc(){
    
        return UserDAO.iddoc(password);

    
    
    }
    

    public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "login";
    }
}
