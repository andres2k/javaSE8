package com.defaultMethod;

public class DefaultMethod implements PersonaA, PersonaB{

//	@Override
//	public void caminar() {
//		System.out.println("Hola");
//		
//	}
	// Ya que implemento dos interfaces que tienen el mismo metodo, debo sobrescribirlo indicando la nueva
	// logica o bien haciendo referencia a cual metodo quiero que se ejecute.
	@Override
	public void saludar() {
		// TODO Auto-generated method stub
		PersonaA.super.saludar();
	}



	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		app.caminar();
		app.saludar();
	}


}
