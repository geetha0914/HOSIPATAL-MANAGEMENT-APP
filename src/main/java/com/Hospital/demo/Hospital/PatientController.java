package com.Hospital.demo.Hospital;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PatientController {


    @Autowired
	PatientRepo PatientRepository;
	
    //1.sayHello
    
    
	@RequestMapping(value="/sayHello",method=RequestMethod.GET)
	public String sayHello() {
		return "Patient Information";
		
	}
	
	//2.regPatient
	
	@RequestMapping(value="/regPatient",method=RequestMethod.GET)
	public Patient registerPatient() {

		Patient pat = new Patient(101,"Geetha",10000,35);
		Patient savedPat = PatientRepository.save(pat);
		//return " Patient " + savedPatient.getPatientName() + " stored in the database ";
		return savedPat;
		
	}
	
	//3.getPatient
	
	
	@RequestMapping(value="/getPatient",method=RequestMethod.GET)
	public String getPatient() {
		 Patient pat = PatientRepository.findById(101).get();
		return pat.getPatientName() +  "|" + pat.getAdvance()+  "|" + pat.getAge();
		
		
	}
	
	
	
	//4.createPatient
	
	
	@RequestMapping(value="/createPatient",method=RequestMethod.POST)
	public Patient createPatient(@RequestBody Patient pat) {
	return PatientRepository.save(pat);
	
	}
	
	//5.getPatient details by id/{PatientId
	
	
	@RequestMapping(value="/getPatient/{patientId}",method=RequestMethod.GET)
	public Patient getPatientDetails(@PathVariable(value="patientId")int patientId) {
	return PatientRepository.findById(patientId).get();
	
	
	
	}
	
//6.getAllPatientList
	
@RequestMapping(value= {"/getAllPatientList","/"},method=RequestMethod.GET)
public Iterable<Patient> getAllPatientList(){
	return PatientRepository.findAll();
}
	

    
	//7.updatePatient/{patientId

	@RequestMapping(value="/updatePatient/{patientId}",method=RequestMethod.PUT)
	public ResponseEntity<Object> UpdatePatient(@RequestBody Patient patient,@PathVariable int patientId){
		Optional<Patient> patientOptional = PatientRepository.findById(patientId);
		if (patientOptional.isEmpty())
			return ResponseEntity.notFound().build();
		patient.setPatientId(patientId);
		PatientRepository.save(patient);
		return ResponseEntity.noContent().build();
	}			
    
    
	
	//8. "DeletePatient/{patientID
    @RequestMapping(value="DeletePatient/{patientId}",method=RequestMethod.DELETE)
    public void DeletePatient(@PathVariable int patientId) {
    	PatientRepository.deleteById(patientId);
    
   
	
	}
	
	
}





