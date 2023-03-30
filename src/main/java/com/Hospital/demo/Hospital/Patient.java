package com.Hospital.demo.Hospital;




import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient{



	@Id
	private int patientId;
	private String patientName;
	private double advance;
	private int age;
	
	
	
	public Patient() {
	}
	
	
	
		public Patient(int patientId,String patientName,double advance,int age) {
	      this.patientId=patientId;
	      this.patientName=patientName;
	      this.advance=advance;
	      this.age=age;
		}



		public int getPatientId() {
			return patientId;
		}



		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}



		public String getPatientName() {
			return patientName;
		}



		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}



		public double getAdvance() {
			return advance;
		}



		public void setAdvance(double advance) {
			this.advance = advance;
		}



		public int getAge() {
			return age;
		}



		public void setAge(int age) {
			this.age = age;
		}



}