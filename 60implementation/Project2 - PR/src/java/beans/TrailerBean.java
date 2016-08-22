/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.TrailerMapper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pcherm
 */
@ManagedBean
@SessionScoped

public class TrailerBean implements Serializable {

    int trailer_nr;
    String licenseplate;
    int loading_cap;
    boolean selected = false;
    TrailerMapper tm;
    public TrailerBean() {
         tm = new TrailerMapper();
    }

    public TrailerBean(int trailer_nr, String licenseplate, int loading_cap) {
        this();
        this.trailer_nr = trailer_nr;
        this.licenseplate = licenseplate;
        this.loading_cap = loading_cap;
    }

    public TrailerBean(String licenseplate, int loading_cap) {
        this.licenseplate = licenseplate;
        this.loading_cap = loading_cap;
    }

    public int getTrailer_nr() {
        return trailer_nr;
    }

    public void setTrailer_nr(int trailer_nr) {
        this.trailer_nr = trailer_nr;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public int getLoading_cap() {
        return loading_cap;
    }

    public void setLoading_cap(int loading_cap) {
        this.loading_cap = loading_cap;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String addTrailer() {
        
        tm.addNewTrailer(this.getLicenseplate(), this.getLoading_cap());       
        return "administration.xhtml";
    }
    
    
}
