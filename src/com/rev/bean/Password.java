package com.rev.bean;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Password implements Validator{
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		//Login login = (Login)target;		
	
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
//				"required.username", "Required");
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
//			"required.password", "Required.");
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
//				"required.confirmPassword", "Required.");

//		if(!(login.getPassword().equals(login.getPassword()))){
//			errors.rejectValue("password", "required.password","Required");
//			}
//		if(!(login.getUsername().equals(login.getUsername()))){
//			errors.rejectValue("password", "required.username","Required");
//			}

		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			errors.rejectValue("password", "notmatch.password");
			
			}
		if(!(user.getConfirmPassword().equals(user.getPassword()))){
		errors.rejectValue("confirmPassword", "notmatch.confirmPassword");
		}
		
//		if(!(user.getUsername().equals(null))){
//			errors.rejectValue("username", "nouserName.password");
//		}
}


	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}
	
}
