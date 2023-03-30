package com.Hospital.demo.Hospital;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.isNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class ApplicationTests {

	@Autowired
	private PatientController patientController;
	@Autowired
	private PatientRepo pRepo;
	
	private Patient pat;
	
	@Autowired
	private doctorController doc;
	@Autowired
	private doctorRepo dRepo;
	
	private doctor doct;
	
	
	
	@Test
	void contextLoads() {
	}
	
	//4. testing createPatient
	
	@Test
	public void testcreatePatientmethod() {
		
		Patient pat = pRepo.save(new Patient(101,"geetha",9999,34));
		assertThat(pat.getPatientId()).isGreaterThan(0);
		
		

	}
	
	
	// 5.getPatient details by id/{PatientId
	@Test
	public void testgetpatientDetails() {
		Patient pat = pRepo.save(new Patient(101,"geetha",9999,34));
		Patient PatientlistbyId = pRepo.findById(pat.getPatientId()).get();
		assertThat(PatientlistbyId).isNotNull();
	}
	
	//getAllPatientList
	@Test
	public void testAllPatientList() {
		
		Patient patient = new Patient(101,"geetha",9999,34);
		Patient patient1 = new Patient(102,"kavita",5999,24);
				Iterable <Patient> patientlist = pRepo.findAll();
				assertThat(patientlist).isNotNull();
				assertThat(patientlist.iterator()).isNotEqualTo(2);
	}
	//7.updatePatient/{patientId
	
@Test
	
	public void testUpdatePatientById() {
		
		Patient patient = pRepo.save(new Patient (101,"geetha",9999,34));
		Patient updatePatient = pRepo.findById(patient.getPatientId()).get();
		updatePatient.setPatientName("manasa");
		updatePatient.setAge(50);
		Patient updatepatient = pRepo.save(updatePatient);
		assertThat(updatePatient.getPatientName()).isEqualTo("manasa");
		assertThat(updatePatient.getAge()).isEqualTo(50);
		
	}
	
	//8. "DeletePatient/{patientID
@Test
	public void testdeletePatient() {
		Patient patient = pRepo.save(new Patient(101,"geetha",9999,34));
		pRepo.deleteById(patient.getPatientId());
		Optional <Patient> optionalpatient = pRepo.findById(patient.getPatientId());
		assertThat(optionalpatient).isEmpty();
	
	}
	
	
////1.createDoctor

@Test
public void testcreateDoctor() {


doctor doctor = dRepo.save(new doctor(101,"geetha",999999,9177.2));
		assertThat(doctor.getDoctorId()).isGreaterThan(0);
}
	
//2.getDoctor/{DoctorId
@Test
public void testgetDoctorDetails() {
	doctor  doctor = dRepo.save(new doctor(101,"geetha",9999,34));
	doctor doctorlistbyId = dRepo.findById(doctor.getDoctorId()).get();
	assertThat(doctorlistbyId).isNotNull();
}
//3.getAllDoctorList

@Test
public void testgetAllpatientDetails() {
	
	doctor doct = new doctor(101,"geetha",9999,34);
	doctor doct1 = new doctor(102,"kavita",5999,24);
			Iterable <doctor> Doctorlist = dRepo.findAll();
			assertThat(Doctorlist).isNotNull();
			assertThat(Doctorlist.iterator()).isNotEqualTo(2);
}

//4.updateDoctor/{DoctorId


@Test
public void testupdatePatient() {
	
	doctor doctor =dRepo.save(new doctor (101,"geetha",9999,34));
	doctor updatedoctor =dRepo.findById(doctor.getDoctorId()).get();
	updatedoctor.setDoctorName("manasa");
	updatedoctor.setBill(450000);
	doctor updateDoctor = dRepo.save(updatedoctor);
	assertThat(updateDoctor.getDoctorName()).isEqualTo("manasa");
	assertThat(updateDoctor.getBill()).isEqualTo(450000);
}

//5. "DeleteDoctor/{DoctorID

@Test

public void testdeleteDoctor() {
	doctor doctor =  dRepo.save(new doctor(101,"geetha",9999,34));
	dRepo.deleteById(doctor.getDoctorId());
	Optional <doctor> optionaldoctor = dRepo.findById(doctor.getDoctorId());
	assertThat(optionaldoctor).isEmpty();
}
}

