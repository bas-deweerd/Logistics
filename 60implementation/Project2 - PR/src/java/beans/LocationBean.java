/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.LocationMapper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pcherm
 */
@ManagedBean
@SessionScoped
public class LocationBean implements Serializable{

    int id;
    String companyName;
    String adress;
    String city;
    String country;
    LocationMapper lm;
    boolean selected;
    
    public LocationBean(){
    }
    
    public LocationMapper getLm() {
        return lm;
    }

    public void setLm(LocationMapper lm) {
        this.lm = lm;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public LocationBean(int id, String companyName, String adress, String city, String country) {
        this.id = id;
        this.companyName = companyName;
        this.adress = adress;
        this.city = city;
        this.country = country;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String addLocation() {
        
        lm.addNewLocation(this.getCompanyName(), this.getAdress(), this.getCity(), this.getCountry());
        return "storage.xhtml";
    }
}
