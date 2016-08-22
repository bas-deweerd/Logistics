package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author pcherm
 */
@FacesValidator(value = "licenseplatevalidator")
public class LicenseplateValidator implements Validator{

    public static boolean validateAddress(String address) {
        return address.matches(
                "^([A-Z-0-9]{2}-[A-Z-0-9]{2}-[A-Z-0-9]{2})|([A-Z-0-9]{2}-[A-Z-0-9]{3}-[A-Z-0-9]{1})|([A-Z-0-9]{1}-[A-Z-0-9]{3}-[A-Z-0-9]{2})||()$");
    } // end method validateAddress

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String adress = String.valueOf(value);
        String regex  = "^([A-Z-0-9]{2}-[A-Z-0-9]{2}-[A-Z-0-9]{2})|([A-Z-0-9]{2}-[A-Z-0-9]{3}-[A-Z-0-9]{1})|([A-Z-0-9]{1}-[A-Z-0-9]{3}-[A-Z-0-9]{2})$";
        if(!adress.matches(regex)){
           FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Invalid Licenseplate",
                    "The License plate you entered is not valid.");
            throw new ValidatorException(message);
        }
        
    }
}
