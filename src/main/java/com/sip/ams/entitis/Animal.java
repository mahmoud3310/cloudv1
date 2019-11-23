package com.sip.ams.entitis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


public class Animal {
	private String nom ;
	private int age ;
	
	
	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Animal(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	} 
	
	
	
	
}
