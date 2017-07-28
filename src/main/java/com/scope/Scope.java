package com.scope;

import com.lambda.Operacion;

public class Scope {
	private static double a1;
	private double a2;
	
	public double probarLocalVariable(){
		double n = 3.0;
		Operacion op = new Operacion(){

			@Override
			public double calcularPromedio(double num1, double num2) {
				return num1 + num2 + n;
			}
			
		};
		return op.calcularPromedio(1, 2);
	}	
	
	public double probarAtributosStaticVariables(){
		Operacion op = (x, y) -> {
			a1 = 2;
			a2 = 5; 
			return x+y +a1 + a2;
		};
		return op.calcularPromedio(1, 2);
	}
	public static void main(String[] args) {
		Scope sc = new Scope();
		System.out.println(sc.probarLocalVariable());
		System.out.println(sc.probarAtributosStaticVariables());
	}
}
