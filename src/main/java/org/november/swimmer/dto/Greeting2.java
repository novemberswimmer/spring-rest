package org.november.swimmer.dto;

public class Greeting2 {
	private final Long id;
	private final String firstName;
	private final String lastName;
	
	public Greeting2(Long id, String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Greeting2 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
