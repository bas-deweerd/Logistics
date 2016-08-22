    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.CustomerMapper;
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
public class CustomerTableBean implements Serializable {

    private boolean checkempty = false;
    private static final DBConnect connection = DBConnect.con;
    List<CustomerBean> customer = new ArrayList<CustomerBean>();
    private String parseCustomerForOrder;
    private CustomerBean selectedCustomer;

    public CustomerTableBean() {

    }

    public void fillList() {
        emptylist();
        ResultSet result = connection.selectResultSetQuery("*", "customer");

        try {
            while (result.next()) {
                customer.add(new CustomerBean(result.getString("name"), result.getString("phone_nr"), result.getString("email"), result.getInt("location_nr")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TruckTableBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkempty = false;
    }

    public void emptylist() {
        customer.clear();
    }

    public DBConnect getConnection() {
        return connection;
    }

    public List<CustomerBean> getCustomer() {
        return customer;
    }

    public void fillList(List<CustomerBean> c) {
        emptylist();
        for (CustomerBean c1 : c) {
            customer.add(c1);
        }

    }

    public void searchListForSearchterm(String searchTerm) {
        if (checkempty) {
            fillList();
        }
        if (searchTerm.isEmpty()) {
            fillList();
        }
        List<CustomerBean> customerList = new ArrayList<>();
        for (CustomerBean cust : customer) {
            String name = cust.getName();
            String phone = cust.getPhone_nr() + "";
            String mail = cust.getEmail();
            String location = cust.getLocation_nr() + "";

            if (name.contains(searchTerm) || phone.contains(searchTerm) || mail.contains(searchTerm) || location.contains(searchTerm)) {
                customerList.add(cust);
            }
            if (customerList.isEmpty()) {
                checkempty = true;
            }
        }
        fillList(customerList);

    }

    public void deleteCustomer() {
        CustomerMapper cm = new CustomerMapper();
        for (CustomerBean customer1 : customer) {

            if (customer1.isSelected()) {
                cm.deleteCustomer(cm.getId(customer1.getName(), customer1.getPhone_nr(), customer1.getEmail()));

            }

        }
        fillList();
    }

    public CustomerBean getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(CustomerBean selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }
    public void clearSelected(){
        this.selectedCustomer = new CustomerBean("bier", "", "", 1);
    }
    
}
