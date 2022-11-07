package com.event.Training.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.event.Training.Model.LoginDetail;
import com.event.Training.Services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService userservice;
	

	
	@PostMapping("/loginuser")
	public ResponseEntity<?> loginUser(@RequestParam String emailId, String password) throws Exception {
		ResponseEntity<?> result = null;
		String tempEmail = emailId;
		String tempPass = password;
		LoginDetail userObj = null;
		if (tempEmail != null && !tempEmail.isEmpty()) {
			if(tempPass != null && !tempPass.isEmpty()) {
			userObj = userservice.fetchUserByEmailAndPassword(tempEmail, tempPass);
			result = ResponseEntity.ok().body(userObj);
			}
		}
		if (userObj == null) {
			result = new ResponseEntity<>("User name or password is incorrect", HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
}
