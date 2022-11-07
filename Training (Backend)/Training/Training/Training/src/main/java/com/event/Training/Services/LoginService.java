package com.event.Training.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.Training.Model.LoginDetail;
import com.event.Training.Repository.LoginDetailsRepository;

@Service
public class LoginService {

	@Autowired
    private LoginDetailsRepository loginDetailRepo;


	public LoginDetail fetchUserByEmailAndPassword(String emailId, String password) {
		return loginDetailRepo.findByEmailIdAndPassword(emailId, password);
	}
}
