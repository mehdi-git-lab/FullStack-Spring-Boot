package com.sip.ams.entities;

public class Etudiant {

	private int id;
	private String name;
	private String email;

	public Etudiant(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Etudiant() {

	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
