/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.CustomerMapper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pcherm
 */

@ManagedBean
@SessionScoped
public class CustomerBean implements Serializable {
    String name;
    String phone_nr;
    String email;
    int location_nr;
    boolean selected = false;
    CustomerMapper cm;
public CustomerBean(){
}
    public CustomerBean(String name, String phone_nr, String email, int location_nr) {
        this.name = name;
        this.phone_nr = phone_nr;
        this.email = email;
        this.location_nr = location_nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_nr() {
        return phone_nr;
    }

    public void setPhone_nr(String phone_nr) {
        this.phone_nr = phone_nr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLocation_nr() {
        return location_nr;
    }

    public void setLocation_nr(int location_nr) {
        this.location_nr = location_nr;
    }
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        System.out.println(this.selected);
    }
    
    public String addCustomer() {
        
        cm.addNewCustomer(this.getName(), this.getPhone_nr(), this.getEmail(), this.getLocation_nr());
        return "administration";
    }
    
    
}
