package com.defaultMethod;

public interface PersonaA {

	default public void saludar() {
		System.out.println("Saludos a todos - PA");
	}
}
