/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.UserMapper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pcherm
 */
    @ManagedBean
@SessionScoped
public class TruckerBean implements Serializable {

    String name;
    int id;
    UserMapper um = new UserMapper();
    boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
    public TruckerBean(){
    
    }
    public TruckerBean(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String addEmployee() {
        um.createAccount(name, name, id);
        return "administration";
    }
}
