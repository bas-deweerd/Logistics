/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Herm Lecluse
 */
import DBCon.DBConnect;
import DBCon.TrailerMapper;
import DBCon.TruckMapper;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TruckTableBean implements Serializable {
    private boolean checkempty = false;
    private final DBConnect connection;
    List<TruckBean> truck = new ArrayList<TruckBean>();

    public TruckTableBean() {
        this.connection = DBConnect.con;

    }

    public void fillList() {
        emptylist();
        ResultSet result = connection.selectResultSetQuery("*", "truck");

        try {
            while (result.next()) {
                truck.add(new TruckBean(result.getInt("truck_nr"), result.getString("brand"), result.getString("model"), result.getInt("buildyear"), result.getString("licenseplate"), result.getInt("towing_cap")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(TruckTableBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkempty=false;
        
    }

    public void emptylist() {
        truck.clear();
    }
    public void fillList(List<TruckBean> t){
        emptylist();
        for (TruckBean t1 : t) {
            truck.add(t1);
        }
        
        
    }
    
    public void searchListForSearchterm(String searchTerm) {
        if(checkempty){
        fillList();
        }
        if (searchTerm.isEmpty()) {
            fillList();
        }
        List<TruckBean> truckList = new ArrayList<>();
        for (TruckBean truck1 : truck) {
            String id = Integer.toString(truck1.getTruck_id());
            String buildyear = Integer.toString(truck1.getBuildyear());
            String towing = Integer.toString(truck1.getTowing_cap());
            String brand = truck1.getBrand();
            String licenseplate = truck1.getLicenseplate();
            String model = truck1.getModel();
            if (brand.contains(searchTerm) || licenseplate.contains(searchTerm) || model.contains(searchTerm)|| id.contains(searchTerm) || buildyear.contains(searchTerm)|| towing.contains(searchTerm) ) {
                truckList.add(truck1);
            }
            if (truckList.isEmpty()) {
                checkempty=true;
            }
        }
        fillList(truckList);
        
    }
    

    public DBConnect getConnection() {
        return connection;
    }

    public List<TruckBean> getTruck() {
        return truck;
    }
    
    public void deleteTruck(){
        TruckMapper tm = new TruckMapper();
        for (TruckBean truck1 : truck) {
            if(truck1.isSelected()){
                tm.deleteTruck(truck1.getTruck_id());
                
            }
    
        }
        fillList();
    }

}
