package com.event.Training.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.Training.Model.LoginDetail;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetail, Integer> {
	LoginDetail findByEmailIdAndPassword(String emailId, String password);
}
