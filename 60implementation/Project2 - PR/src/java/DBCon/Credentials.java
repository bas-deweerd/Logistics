/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Jurian Janssen
 */
@ManagedBean
@Named
@RequestScoped
public class Credentials implements Serializable {

    /**
     * Creates a new instance of Credentials
     */
    public Credentials() {
    }
    
    private String username;
    private String password;

    
    //Username functions
    public String getUsername() { 
        return username; 
    }

    public void setUsername(String username) { 
        this.username = username; 
    }

    
    //Password functions
    public String getPassword() { 
        return password; 
    }

    public void setPassword(String password) { 
        this.password = password; 
    }
    
}
