package com.custom.validators;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RegisterBean {

	public void saveZip(@ZipCode String zip){
		System.out.println("saving zipcode for default country US");
	}
	
	public void saveZipCanda(@ZipCode(country=ZipCode.Country.CANADA) String zip){
		System.out.println("saving zipcode for Canada");
	}
	
}
