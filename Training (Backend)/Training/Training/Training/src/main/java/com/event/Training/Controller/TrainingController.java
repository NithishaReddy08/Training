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
import com.event.Training.Model.TrainingDetails;
import com.event.Training.Services.TrainingDetailsService;
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
@RestController
@Validated
public class TrainingController {
	@Autowired
	private TrainingDetailsService trainingdetailsService;
	@GetMapping("/Trainingdetails")
	public List<TrainingDetails> getTrainingDetails() {
		List<TrainingDetails> trainingList = trainingdetailsService.fetchTrainingDetails();
		return trainingList;
	}
	/* @GetMapping("/employee/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid")@Min(1)  int empid)
            throws ResourceNotFoundException
    {
        Employee employee = employeeService.getEmployee(empid);
        return   ResponseEntity.ok().body(employee);
    }*/

	// retrieving the TrainingDetails  by training name//
	@GetMapping("/Trainingdetails/{Id}")
	public ResponseEntity<TrainingDetails> getTrainingDetailsById(@PathVariable("id") @Min(1) int id)
			throws ResourceNotFoundException
	{
		TrainingDetails trainingdetails = trainingdetailsService.getTrainingDetails(id);
		return   ResponseEntity.ok().body(trainingdetails);
	}
	// adding the TrainingDetails//
	@PostMapping("/Trainingdetails")
	public TrainingDetails addTrainingDetails(@RequestBody @Valid TrainingDetails trningdetails) {
		TrainingDetails trainingdetails = trainingdetailsService.saveTrainingDetails(trningdetails);
		return trainingdetails;
	}
	//update the TrainingDetails using the trainingname//
	@PutMapping("/Trainingdetails/{Id}")
	public ResponseEntity<TrainingDetails> updateTrainingDetails(@Valid @PathVariable("id") int Id,
			@RequestBody TrainingDetails TrainingDetails) throws ResourceNotFoundException {
		
		TrainingDetails trainingdetails = trainingdetailsService.getTrainingDetails(Id);
		trainingdetails.setId(trainingdetails.getId());
		trainingdetails.setTraining_Name(trainingdetails.getTraining_Name());
		trainingdetails.setDescription(trainingdetails.getDescription());
		trainingdetails.setDuration(trainingdetails.getDuration());
		trainingdetails.setMode(trainingdetails.getMode());
		final TrainingDetails updatedTrainingDetails = trainingdetailsService.saveTrainingDetails(trainingdetails);
		return ResponseEntity.ok(updatedTrainingDetails);
	}
	

            //deleting TrainingDetails by Training_Name//
	@DeleteMapping(value = "/Trainingdetails/{Id}")
	public ResponseEntity<Object> deleteTrainingDetails(@PathVariable("Id")@Min(1) int Id) {
		trainingdetailsService.deleteTrainingdetails(Id);
		return new ResponseEntity<>("TrainingDetails deleted successsfully", HttpStatus.OK);
	}
}