package pack1;

import java.util.HashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private HashMap<String, String> countryOptions;
	 
	
	public Student () {
		this.countryOptions = new HashMap<String, String>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("NR", "Norway");
		countryOptions.put("RO", "Romania");
	}

	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public HashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
//not needed for setting because i do it in the constructor
	public void setCountryOptions(HashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	
}
