package com.Hospital.demo.Hospital;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class doctor {
	
	

	   
	
	  @Id
		private int doctorId;
		private String doctorName;
		private long  number;
		private double bill;
		
		public  doctor() {
		}

		public doctor(int doctorId,String doctorName,long number,double bill) {
		      this.doctorId=doctorId;
		      this.doctorName=doctorName;
		      this.number=number;
		      this.bill=bill;
			}


		public int getDoctorId() {
			return doctorId;
		}

		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}

		public String getDoctorName() {
			return doctorName;
		}

		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}

		public long getNumber() {
			return number;
		}

		public void setNumber(long number) {
			this.number = number;
		}

		public double getBill() {
			return bill;
		}

		public void setBill(double bill) {
			this.bill = bill;
		}
		

}
