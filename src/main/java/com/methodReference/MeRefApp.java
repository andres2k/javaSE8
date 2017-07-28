package com.methodReference;

public class MeRefApp {
	private static void referenciarMetodoStatic() {
		System.out.println("Metodo referido static");
	}
		
	public void operar(){
		Operacion op = () -> MeRefApp.referenciarMetodoStatic();
		op.saludar();
		
		Operacion op2 = MeRefApp::referenciarMetodoStatic;
		op2.saludar();
	}
	public static void main(String[] args) {
		MeRefApp app = new MeRefApp();
		app.operar();

	}

}
