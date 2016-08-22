package DBCon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jurian Janssen
 */
@ManagedBean
@SessionScoped
public class SimpleLogin implements Serializable {
    private String usertype;
    private String username;
    private String password;
    UserMapper usermapper = new UserMapper();

    
    public SimpleLogin() {
      
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String CheckValidUser() {
        if (usermapper.login(username, password)) {
            if(username.equals(password)){
                
                return "pages/setpassword.xhtml";
            }
            return "success.xhtml";
        }
        return "wrong password";
    }

    public UserMapper getUsermapper() {
        return usermapper;
    }

    public void setUsermapper(UserMapper usermapper) {
        this.usermapper = usermapper;
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

}
