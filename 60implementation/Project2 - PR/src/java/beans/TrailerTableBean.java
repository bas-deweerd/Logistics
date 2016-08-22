/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.DBConnect;
import DBCon.TrailerMapper;
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
public class TrailerTableBean implements Serializable {
    private boolean checkempty=false;
    private final DBConnect connection;
    List<TrailerBean> trailer = new ArrayList<TrailerBean>();

    public TrailerTableBean() {
        this.connection = DBConnect.con;
    }

    public void fillList() {
        emptylist();
        ResultSet result = connection.selectResultSetQuery("*", "trailer");

        try {
            while (result.next()) {
                trailer.add(new TrailerBean(result.getInt("trailer_nr"), result.getString("licenseplate"), result.getInt("loading_cap")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TruckTableBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkempty=false;
    }
    public void fillList(List<TrailerBean> t) {
        emptylist();
        for (TrailerBean t1 : t) {
            trailer.add(t1);
        }

    }

    public void searchListForSearchterm(String searchTerm) {
        if (searchTerm.isEmpty()||checkempty) {
            fillList();
        }
        List<TrailerBean> trailerList = new ArrayList<>();
        for (TrailerBean trail : trailer) {
            String id = trail.getTrailer_nr()+"";
            String licenseplate = trail.getLicenseplate();
            String loading = trail.getLoading_cap()+"";
            if (id.contains(searchTerm) || licenseplate.contains(searchTerm)|| loading.contains(searchTerm)) {
                trailerList.add(trail);
            }
            if (trailerList.isEmpty()) {
                checkempty = true;
            }
        }
        fillList(trailerList);

    }
    public void emptylist() {
        trailer.clear();
    }

    public DBConnect getConnection() {
        return connection;
    }

    public List<TrailerBean> getTrailer() {
        return trailer;
    }
    public void deleteTrailer(){
        TrailerMapper tm = new TrailerMapper();
        for (TrailerBean trailer1 : trailer) {
            
            if(trailer1.isSelected()){
                tm.deleteTrailer(trailer1.getTrailer_nr());
                
            }
        
        }
        fillList();
    }
}
