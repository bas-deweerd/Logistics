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
@FacesValidator(value = "adressvalidator")
public class AdressValidation implements Validator{

    public static boolean validateAddress(String address) {
        return address.matches(
                "[\\d]*\\s[A-Z]{1}[a-z]*");
    } // end method validateAddress

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String adress = String.valueOf(value);
        String regex  = "[\\d]*\\s[A-Z]{1}[a-z]*";
        if(!adress.matches(regex)){
           FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Invalid email address",
                    "The email address you entered is not valid.");
            throw new ValidatorException(message);
        }
        
    }
}
