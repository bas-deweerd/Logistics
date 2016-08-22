package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Herm Lecluse
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class userTypeBean implements Serializable{

    private int userType = 0;
    private String username;
    private String password;

    

    public String pageChanger(int userType) {

        switch (userType) {
            case 1:
                return "./pages/businesssupport.xhtml";
            case 2:
                return "./pages/ceo.xhtml";
            case 3:
                return "./pages/truckdriver.xhtml";
            case 4:
                return "./pages/orderinvoice.xhtml";
            case 5:
                return "./pages/planning.xhtml";
            case 6:
                return "./pages/customer.xhtml";
            default :
                return "./pages/fail";
        }
    }

}
