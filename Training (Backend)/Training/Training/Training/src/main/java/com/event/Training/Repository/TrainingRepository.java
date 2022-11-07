package com.event.Training.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.Training.Model.TrainingDetails;


@Repository
public interface TrainingRepository extends JpaRepository<TrainingDetails ,Integer>  {

	
}
