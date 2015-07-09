package managedbeans;

import beans.Doctorant;
import beans.Inscription;
import beans.ObtenirDiplome;
import java.io.Serializable;
import java.util.Random;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import managedbeans.util.JsfUtil;
import managedbeans.util.PaginationHelper;
import org.primefaces.event.FlowEvent;
import sessionbeans.DoctorantFacade;
import sessionbeans.InscriptionFacade;
import sessionbeans.ObtenirDiplomeFacade;

@Named("doctorantController")
@SessionScoped
public class DoctorantController implements Serializable {

    private Inscription inscription;
    private ObtenirDiplome obtenirDiplome;
    private ObtenirDiplome obtenirDiplome2=null;

    private Doctorant current;
    private DataModel items = null;
    @EJB
    private sessionbeans.DoctorantFacade ejbFacade;

    @EJB
    private sessionbeans.InscriptionFacade ejbFacadeInscription;
    @EJB
    private sessionbeans.ObtenirDiplomeFacade ejbFacadeObtenirDiplome;
    @EJB
    private sessionbeans.ObtenirDiplomeFacade ejbFacadeObtenirDiplome2=null;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    
    public Doctorant getDoctorant(int i) {
        current = getFacade().find(i);
        return current;
    }
    
    
    public DoctorantController() {
    }

    public Doctorant getSelected() {
        if (current == null) {
            current = new Doctorant();
            selectedItemIndex = -1;
        }
        return current;
    }

    private DoctorantFacade getFacade() {
        return ejbFacade;
    }


    public Inscription getSelectedInscription() {
        if (inscription == null) {
            inscription = new Inscription();
            selectedItemIndex = -1;
        }
        return inscription;
    }

    public ObtenirDiplome getSelectedObtenirDiplome() {
        if (obtenirDiplome == null) {
            obtenirDiplome = new ObtenirDiplome();
            selectedItemIndex = -1;
        }
        return obtenirDiplome;
    }

    public ObtenirDiplome getSelectedObtenirDiplome2() {
        if (obtenirDiplome2 == null) {
            obtenirDiplome2 = new ObtenirDiplome();
            selectedItemIndex = -1;
        }
        return obtenirDiplome2;
    }



    private InscriptionFacade getFacadeInscription() {
        return ejbFacadeInscription;
    }

    private ObtenirDiplomeFacade getFacadeObtenirDiplome() {
        return ejbFacadeObtenirDiplome;
    }

    private ObtenirDiplomeFacade getFacadeObtenirDiplome2() {
        return ejbFacadeObtenirDiplome2;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Doctorant) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Doctorant();
        inscription = new Inscription();
        obtenirDiplome = new ObtenirDiplome();
        obtenirDiplome2 = new ObtenirDiplome();
        selectedItemIndex = -1;
        return "/index";
    }

    public String create() {
        try {
            //creation du doctorant
            
            
           
            
            getFacade().create(current);
                      
           // Creation de l'inscription 
            inscription.setEtat("En attente");
            inscription.setIdDoctorant(current);
            getFacadeInscription().create(inscription);
            
             //Creation Obtenir Diplome:
            obtenirDiplome.setIdDoctorant(current);
            getFacadeObtenirDiplome().create(obtenirDiplome);
            if (obtenirDiplome2.getIdDiplome() != null) {
                obtenirDiplome2.setIdDoctorant(current);
                getFacadeObtenirDiplome2().create(obtenirDiplome2);
            }
            
            
            JsfUtil.addSuccessMessage("Bienvenue sur CEDOC",  "Mr: \t" + current.getNom());
            //
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Doctorant) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DoctorantUpdated"), current.getNom());
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
     public String update(int iddoc) {
        try {
            getFacade().edit(getDoctorant(iddoc));
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DoctorantUpdated"), current.getNom());
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Doctorant) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("DoctorantDeleted"), current.getNom());
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Doctorant getDoctorant(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Doctorant.class)
    public static class DoctorantControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DoctorantController controller = (DoctorantController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "doctorantController");
            return controller.getDoctorant(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Doctorant) {
                Doctorant o = (Doctorant) object;
                return getStringKey(o.getIdDoctorant());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Doctorant.class.getName());
            }
        }

    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    
    public Doctorant findBycode (String code){
    
        return ejbFacade.findByCode(code);
    
    }
    
    public Doctorant fbc (String code){
        
        String codee = code ;
        return findBycode(codee);
    }
    
    
    
    //  String code generator
    
    
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static Random rnd = new Random();

    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }


}
