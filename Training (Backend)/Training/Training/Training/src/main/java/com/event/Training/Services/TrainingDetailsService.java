package com.event.Training.Services;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.Training.Model.TrainingDetails;
import com.event.Training.Repository.TrainingRepository;
@Service
public class TrainingDetailsService {
	@Autowired
	 TrainingRepository trainingRepository;	
	@Transactional
	public List<TrainingDetails> fetchTrainingDetails() {
		List<TrainingDetails> trainingList=trainingRepository.findAll();
		return trainingList;		
	}
	@Transactional
	public TrainingDetails saveTrainingDetails(TrainingDetails trainingdetails) {		
		return trainingRepository.save(trainingdetails);		
	}
	@Transactional
	public void updateTrainingDetails(TrainingDetails trainingdetails) {
		trainingRepository.save(trainingdetails);		
	}	
	@Transactional
	public void deleteTrainingdetails(int Id) {	
		System.out.println("Trainingdetails  deleted");
		trainingRepository.deleteById(Id);	
	}
	@Transactional 
	  public TrainingDetails getTrainingDetails(int id) { 
	  Optional<TrainingDetails> optional= trainingRepository.findById(id);
	  TrainingDetails Traingdetail=optional.get();
	  return Traingdetail;
}
}
