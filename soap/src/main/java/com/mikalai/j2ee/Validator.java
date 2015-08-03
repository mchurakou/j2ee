package com.mikalai.j2ee;

import javax.jws.WebService;

@WebService
public interface Validator {

    public boolean validate(CreditCard creditCard);

}
