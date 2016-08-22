/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author pcherm
 */
import DBCon.TrailerMapper;
import DBCon.TruckMapper;
import java.io.Serializable;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class TruckBean implements Serializable{

    int truck_id;
    String brand;
    String model;
    int buildyear;
    String licenseplate;
    int towing_cap;
    boolean selected;
    TruckMapper tm = new TruckMapper();

    public TruckBean() {
    }

    public TruckBean(int truck_id, String brand, String model, int buildyear, String licenseplate, int towing_cap) {
        this.truck_id = truck_id;
        this.brand = brand;
        this.model = model;
        this.buildyear = buildyear;
        this.licenseplate = licenseplate;
        this.towing_cap = towing_cap;
    }

    public int getTruck_id() {
        return truck_id;
    }

    public void setTruck_id(int truck_id) {
        this.truck_id = truck_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBuildyear() {
        return buildyear;
    }

    public void setBuildyear(int buildyear) {
        this.buildyear = buildyear;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public int getTowing_cap() {
        return towing_cap;
    }

    public void setTowing_cap(int towing_cap) {
        this.towing_cap = towing_cap;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        System.out.println("selected -> true" + selected);
        this.selected = selected;
    }

    public String addTruck() {
        
        tm.addNewTruck(this.getBrand(), this.getModel(), this.getBuildyear(), this.getLicenseplate(), this.getTowing_cap());
        return "administration";
    }

}
