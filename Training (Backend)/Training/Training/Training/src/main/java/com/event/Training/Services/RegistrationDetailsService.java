package com.event.Training.Services;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.Training.Model.RegistrationDetails;
import com.event.Training.Repository.RegistrationDetailsRepository;

@Service
public class RegistrationDetailsService {
	@Autowired
	RegistrationDetailsRepository registrationdetailsrepository;	
	@Transactional
	public List<RegistrationDetails> fetchRegistrationDetails() {
		List<RegistrationDetails> RegistrationDetailsList= registrationdetailsrepository.findAll();
		return RegistrationDetailsList;		
	}
	@Transactional
	public RegistrationDetails saveRegistrationDetails(RegistrationDetails  registrationdetails) {		
		return registrationdetailsrepository.save(registrationdetails);		
	}
	@Transactional
	public void updateRegistrationDetails(RegistrationDetails regdetails) {
		registrationdetailsrepository.save(regdetails);		
	}	
	@Transactional
	public void deleteRegistrationDetails(int Id) {	
		System.out.println("registration deleted");
		registrationdetailsrepository.deleteById(Id);	
	}
	@Transactional 
	  public RegistrationDetails getRegistrationDetails(int Id) { 
	  Optional<RegistrationDetails> optional= registrationdetailsrepository.findById(Id);
	  RegistrationDetails regdetail=optional.get();
	  return regdetail;
}
}
