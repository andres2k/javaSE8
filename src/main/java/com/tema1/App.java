package com.tema1;

public class App {

	private void calcular() {
		// Si quiero usar un metodo de Operacion, primero tengo que crear una instancia
		// pero como es una interfaz, entonces deberia crear una clase anonima que
		// implemente el metodo que tiene definido.
//		Operacion op = new Operacion(){
//
//			@Override
//			public double calcularPromedio(double num1, double num2) {
//				return (num1+num2)/2;
//			}
//
//			
//		};
		// Con JDK 1.8 y las funciones lambdas:
		// Esto se puede solo cuando la interfaz es funcional, es decir tiene un
		// solo metodo abstracto a implementar.
		Operacion op = (double n1, double n2) -> (n1+n2)/2;
		System.out.println(op.calcularPromedio(2, 3));
	}
	
	public static void main(String[] args) {
		App ap = new App();
		ap.calcular();
	}

}
