package com.Hospital.demo.Hospital;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient,Integer> {
	
	

}
