/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.DBConnect;
import DBCon.LocationMapper;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pcherm
 */
@ManagedBean
@SessionScoped
public class LocationTableBean implements Serializable {

    private boolean checkempty = false;
    private final DBConnect connection;
    List<LocationBean> location = new ArrayList<LocationBean>();

    public LocationTableBean() {
        this.connection =DBConnect.con;
    }

    public void fillList() {
        emptylist();
        ResultSet result = connection.selectResultSetQuery("*", "location");
        try {
            while (result.next()) {
                location.add(new LocationBean(result.getInt("id"), result.getString("company_name"), 
                        result.getString("adress"), result.getString("city"), result.getString("country")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TruckTableBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkempty = false;
    }

    public void fillList(List<LocationBean> t) {
        emptylist();
        for (LocationBean t1 : t) {
            location.add(t1);
        }

    }

    public void searchListForSearchterm(String searchTerm) {
        if (searchTerm.isEmpty() || checkempty) {
            fillList();
        }
        List<LocationBean> locationList = new ArrayList<>();
        for (LocationBean l : location) {
            String id = l.getId() + "";
            String companyName = l.getCompanyName();
            String adress = l.getAdress();
            String city = l.getCity();
            String country = l.getCountry();
            if (id.contains(searchTerm) || companyName.contains(searchTerm) || adress.contains(searchTerm) || city.contains(searchTerm) || country.contains(searchTerm)) {
                locationList.add(l);
            }
            if (locationList.isEmpty()) {
                checkempty = true;
            }
        }
        fillList(locationList);

    }

    public void emptylist() {
        location.clear();
    }

    public DBConnect getConnection() {
        return connection;
    }

    public List<LocationBean> getLocation() {
        return location;
    }

    public void deleteLocation() {
        LocationMapper lm = new LocationMapper();
        for (LocationBean l : location) {

            if (l.isSelected()) {
                lm.deleteLocation(l.getId());

            }

        }
        fillList();
    }
}
