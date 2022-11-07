package com.event.Training.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.Training.Model.RegistrationDetails;




@Repository
public interface RegistrationDetailsRepository extends JpaRepository<RegistrationDetails ,Integer>  {

	
}
