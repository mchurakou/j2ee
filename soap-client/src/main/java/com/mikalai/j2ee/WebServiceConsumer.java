package com.mikalai.j2ee;

import javax.xml.ws.WebServiceRef;

import com.mikalai.j2ee.Validator;
import com.mikalai.j2ee.CardValidatorService;
import com.mikalai.j2ee.CreditCard;

public class WebServiceConsumer {

    @WebServiceRef
    private static CardValidatorService cardValidatorService;

    public static void main(String[] args) {

        System.out.println("Invoking web service with injection");

        CreditCard creditCard = new CreditCard();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/12");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

        Validator cardValidator = cardValidatorService.getCardValidatorPort();
        System.out.println(cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        System.out.println(cardValidator.validate(creditCard));
    }
}
