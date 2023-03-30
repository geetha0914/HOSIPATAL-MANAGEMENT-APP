package com.Hospital.demo.Hospital;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class doctorController {
	

	//1.doctor
	 @Autowired
		doctorRepo doctorRepository;
		
		@GetMapping("/Whats a problem")
		public String sayHello() {
			return "I have fever and body pains";
			

	}
		
		//2.regdoctor
		
		@RequestMapping(value="/regdoctor",method=RequestMethod.GET)
		public doctor registerdoctor() {

			doctor doc = new doctor(101,"Geetha",99999,35000); 
			doctor saveddoc = doctorRepository.save(doc);
			
			return saveddoc;
			
		}

		//1.createDoctor
 
 @RequestMapping(value="/createDoctor",method=RequestMethod.POST)
 
 public doctor createDoctor(@RequestBody doctor doc) {
	  return (doctor) doctorRepository.save(doc);
}
	
	
	//@RequestMapping(value="/createPatient",method=RequestMethod.POST)
	//public Patient createPatient(@RequestBody Patient pat) {
	//return PatientRepository.save(pat);
	
	//}
	
	//2.getDoctor/{DoctorId
	
 @RequestMapping(value="/getDoctor/{doctorId}",method=RequestMethod.GET)
 public doctor getDoctorDetails(@PathVariable(value="doctorId")int doctorId) {
	  return doctorRepository.findById(doctorId).get();
 }
	
	
//3.getAllDoctorList
	
 
 @RequestMapping(value= {"/getDoctorList","/"},method=RequestMethod.GET)
 public Iterable<doctor> getAllDoctorList(){
	  return doctorRepository.findAll();
 }

	//4.updateDoctor/{DoctorId
 @RequestMapping(value="/updateDoctor/{doctorId}",method=RequestMethod.PUT)
public ResponseEntity<Object> UpdateDoctor(@RequestBody doctor doc,@PathVariable int doctorId){
	Optional<doctor> doctorOptional = doctorRepository.findById(doctorId);
	
	if (doctorOptional.isEmpty())
			return ResponseEntity.notFound().build();
	doc.setDoctorId(doctorId);
	doctorRepository.save(doc);
	return ResponseEntity.noContent().build();
	}
 
	//5. "DeleteDoctor/{DoctorID
		
		
		
		@RequestMapping(value="DeleteDoctor/{doctorId}",method=RequestMethod.DELETE)
public void deleteDoctor(@PathVariable int doctorId) {
	doctorRepository.deleteById(doctorId);


 

	
	}

}
