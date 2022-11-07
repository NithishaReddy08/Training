package com.event.Training.Controller;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.Training.Exception.ResourceNotFoundException;
import com.event.Training.Model.RegistrationDetails;
import com.event.Training.Services.RegistrationDetailsService;

@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
@RestController
@Validated
public class RegistrationController {
	@Autowired
	private RegistrationDetailsService registrationdetailsService;
	// retrieving  all the registration details from the database//
	@GetMapping("/registrationdetails")
	public List<RegistrationDetails> getRegistrationDetails() {
		List<RegistrationDetails> regList = registrationdetailsService.fetchRegistrationDetails();
		return regList;
	}
	// retrieving the registration details by using id from the database //
	@GetMapping("/registrationdetails/{id}")
	public ResponseEntity<RegistrationDetails> getRegistrationDetailsById(@PathVariable("id")  int id)
			throws ResourceNotFoundException
	{
		RegistrationDetails registrationdetails = registrationdetailsService.getRegistrationDetails(id);
		return   ResponseEntity.ok().body(registrationdetails);
	}
	// adding the RegistrationDetails to the database//
	@PostMapping("/registrationdetails")
	public RegistrationDetails addRegistrationDetails(@RequestBody @Valid RegistrationDetails regdetail) {
		RegistrationDetails registrationdetails = registrationdetailsService.saveRegistrationDetails(regdetail);
		return registrationdetails;
	}
	//update the RegistrationDetails details using the id//
	@PutMapping("/registrationdetails/{id}")
    public ResponseEntity<RegistrationDetails> updateRegistrationDetails(@Valid @PathVariable("id") int Id,
            @RequestBody RegistrationDetails registrationdetails) throws ResourceNotFoundException {
        RegistrationDetails registrations = registrationdetailsService.getRegistrationDetails(Id);
        registrations.setId(registrationdetails.getId());
        registrations.setFirstName(registrationdetails.getFirstName());
        registrations.setLastName(registrationdetails.getLastName());
        registrations.setMobile(registrationdetails.getMobile());
        registrations.setTraining_Name(registrationdetails.getTraining_Name());
        registrations.setMode(registrationdetails.getMode());
        registrations.setDescription(registrationdetails.getDescription());
        registrations.setDate(registrationdetails.getDate());        
        final RegistrationDetails updatedRegistrationDetails = registrationdetailsService.saveRegistrationDetails(registrations);
        return ResponseEntity.ok(updatedRegistrationDetails);
    }
	/*@PutMapping("/registrationdetails/{Id}")
	public ResponseEntity<RegistrationDetails> updateRegistrationDetails(@Valid @PathVariable("id") int id,
			@RequestBody RegistrationDetails RegistrationDetails) throws ResourceNotFoundException {
		RegistrationDetails registrationdetails = registrationdetailsService.getRegistrationDetails(id);
		registrationdetails.setId(RegistrationDetails.getId());
		registrationdetails.setFirstName(RegistrationDetails.getFirstName());
		registrationdetails.setLastName(RegistrationDetails.getLastName());
		registrationdetails.setMobile(RegistrationDetails.getMobile());
		registrationdetails.setTraining_Name(RegistrationDetails.getTraining_Name());
		registrationdetails.setMode(RegistrationDetails.getMode());
		registrationdetails.setDescription(RegistrationDetails.getDescription());
		registrationdetails.setDate(RegistrationDetails.getDate());
		
		final RegistrationDetails updatedRegistrationDetails = registrationdetailsService.saveRegistrationDetails(registrationdetails);
		return ResponseEntity.ok(updatedRegistrationDetails);
	}*/
            //deleting RegistrationDetails by id//
	@DeleteMapping(value = "/registrationdetails/{id}")
	public ResponseEntity<Object> deleteRegistrationDetails(@PathVariable("id")@Min(1)  int id) {
		registrationdetailsService.deleteRegistrationDetails(id);
		return new ResponseEntity<>("Registrationdetails deleted successsfully ", HttpStatus.OK);
	}
}
