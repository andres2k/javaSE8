package com.defaultMethod;

public interface PersonaB {
	default public void caminar(){
		System.out.println("Estoy caminando");
	};
	default public void saludar() {
		System.out.println("Saludos a todos - PB");
	}
}
