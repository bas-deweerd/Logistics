/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.DBConnect;
import DBCon.UserMapper;
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
public class TruckerTableBean implements Serializable {

    private boolean checkempty = false;
    private static final DBConnect connection = DBConnect.con;
    List<TruckerBean> trucker = new ArrayList<TruckerBean>();

    public TruckerTableBean() {
        
    }

    public void fillList() {
        emptylist();
        ResultSet result = connection.selectResultSetQuery("username, id", "users");

        try {
            while (result.next()) {
                trucker.add(new TruckerBean(result.getString(1),result.getInt(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(TruckTableBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkempty=false;
    }

    public void fillList(List<TruckerBean> t) {
        emptylist();
        for (TruckerBean t1 : t) {
            trucker.add(t1);
        }

    }

    public void searchListForSearchterm(String searchTerm) {
        if (checkempty) {
            fillList();
        }
        if (searchTerm.isEmpty()) {
            fillList();
        }
        List<TruckerBean> truckerList = new ArrayList<>();
        for (TruckerBean trucer1 : trucker) {
            String name = trucer1.getName();
            String id = trucer1.getId() + "";

            if (name.contains(searchTerm) || id.contains(searchTerm)) {
                truckerList.add(trucer1);
            }
            if (truckerList.isEmpty()) {
                checkempty = true;
            }
        }
        fillList(truckerList);

    }

    public void emptylist() {
        trucker.clear();
    }

    public DBConnect getConnection() {
        return connection;
    }

    public List<TruckerBean> getTrucker() {
        return trucker;
    }
public void deleteTruck(){
        UserMapper tm = new UserMapper();
        for (TruckerBean trucker1 : trucker) {
            if(trucker1.isSelected()){
                tm.deleteAccount(trucker1.getId());
                
            }
    
        }
        fillList();
    }

}
