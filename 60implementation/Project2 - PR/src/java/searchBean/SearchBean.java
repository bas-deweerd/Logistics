/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pcherm
 */
@ManagedBean
@SessionScoped
public class SearchBean implements Serializable{
    private String trailerSearchString;
    private String truckSearchString;
    private String truckerSearchString;
    private String customerSearchString;

    /*
     *  @return trailerSearchString
     */
    public String getTrailerSearchString() {
        return trailerSearchString;
    }
    /*
     *@param trailerSearchString String to set a parameter to search for
     */
    public void setTrailerSearchString(String trailerSearchString) {
        this.trailerSearchString = trailerSearchString;
    }
    /*
     *@return truckSearchString
     */
    public String getTruckSearchString() {
        return truckSearchString;
    }
    /*
     *@param truckSearchString String to set a parameter to search for
     */
    public void setTruckSearchString(String truckSearchString) {
        this.truckSearchString = truckSearchString;
    }
    /*
     *@return truckerSearchString
     */
    public String getTruckerSearchString() {
        return truckerSearchString;
    }
    /*
     *@param truckerSearchString String to set a parameter to search for
     */
    public void setTruckerSearchString(String truckerSearchString) {
        this.truckerSearchString = truckerSearchString;
    }
    /*
     *@return customerSearchString
     */
    public String getCustomerSearchString() {
        return customerSearchString;
    }
    /*
     *@param customerSearchString String to set a parameter to search for
     */
    public void setCustomerSearchString(String customerSearchString) {
        this.customerSearchString = customerSearchString;
    }

}
