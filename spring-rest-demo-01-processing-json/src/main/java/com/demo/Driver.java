package com.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON  file and map/convert to Java POJO: 
			// data/sample-lite.json
			
			Student theStudent = mapper.readValue(
						new File("data/sample-lite.json"), Student.class);
			
			// print first name and last name
			System.out.println("Sample Lite JSON");
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());

			Student theStudent2 = mapper.readValue(
					new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("");
			System.out.println("Sample Full JSON");
			System.out.println("First name = " + theStudent2.getFirstName());
			System.out.println("Last name = " + theStudent2.getLastName());
			System.out.println("Street = " + theStudent2.getAddress().getStreet());
			System.out.println("City = " + theStudent2.getAddress().getCity());
			System.out.println("State = " + theStudent2.getAddress().getState());
			System.out.println("Zip = " + theStudent2.getAddress().getZip());
			System.out.println("Country = " + theStudent2.getAddress().getCountry());
			for (String language : theStudent2.getLanguages()) {
				System.out.println("Language = " +language );
			}
			
			

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}




