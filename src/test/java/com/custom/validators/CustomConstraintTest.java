package com.custom.validators;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CustomConstraintTest {

	@Inject
	RegisterBean register;
	
	/*
	 * ExpectedException with @Rule -is used to verify the 
	 * expected exception. IF the exception raises then the test 
	 * passes and if @Test method throws any other exception
	 * then the test fails - ExceptedException doesn't have any
	 * effects
	 */
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); 
	
	@Deployment
	public static Archive<?> deployment(){
		WebArchive war = ShrinkWrap.create(WebArchive.class)
							.addClasses(RegisterBean.class,ZipCode.class, ZipCodeValidator.class)
							.addAsResource("ValidationMessages.properties");
		
		System.out.println(war.toString(true));
		return war;
	}
	
	@Test
	public void saveZipForUS(){
		register.saveZip("90003");
	}
	
	@Test
	public void saveZipForCanada(){
		//thrown.expect(ConstraintViolationException.class);
		//thrown.expectMessage("saveZipCanada.arg0");
		thrown.expectMessage("Invalid zipcode");		
		register.saveZipCanda("60001");
	}
	
}
