/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.SimpleLogin;
import DBCon.UserMapper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bas
 */
@ManagedBean
@SessionScoped
public class ResetPasswordBean implements Serializable {

    private String firstpass;
    private String secondpass;

    public String getFirstpass() {
        return firstpass;
    }

    public String getSecondpass() {
        return secondpass;
    }

    public void setFirstpass(String firstpass) {
        this.firstpass = firstpass;
    }

    public void setSecondpass(String secondpass) {
        this.secondpass = secondpass;
    }

    public boolean passwordsMatch() {
        
        if (firstpass.equals(secondpass)) {
            return true;
        } else {
            return false;
        }
    }

    public String changePassword(String username) {
        if (passwordsMatch()) {
            UserMapper usermapper = new UserMapper();
            int id = usermapper.getID(username);
            usermapper.setPassword(firstpass, id);
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "/index.xhtml?faces-redirect=true";
        }
        return "Passwords do not match.";
    }

}
