package com.optional;

import java.util.Optional;

public class OptionalApp {
	// Es para evitar los errores del tipo NullPointerException
	 //el cual nos permite mostrar de manera explicita (mediante el sistema de tipos) la posibilidad de que un método pueda no devolver el valor deseado.
	// https://www.adictosaltrabajo.com/tutoriales/optional-java-8/
	// Tener en cuenta que si es critico en rendimiento, por ahi no es la mejor opcion
	
	private void probar(String valor) {
		//System.out.println(valor.contains("code"));
		//Optional es un wrapper, es un envoltorio,  y si queremos obtener el valor usamos "get()",
		try {
			// Aca lo inicializamos sin ningun valor, es vacio
			Optional op = Optional.empty();
			op.get();
		} catch (Exception e) {
			System.out.println("sin valor");
		}
		
	}
	private void orElse(String valor) {
		// En este metodo lo vamos a inicializar con un valor
		// se puede usar of(valor) -> en este caso si le mando null pincha, entonces, usar ofNullable(valor)
		Optional<String> op = Optional.ofNullable(valor);
		// Aca le digo, que si el valor de la variable es null, entonces asuma el valor "predeterminado" por default.
		String x = op.orElse("predeterminado");
		System.out.println(x);
		

	}
	private void orElseThrow(String valor) {
		// Es similar a orElse() salvo que permite tirar una excepcion si el valor es nulo
		Optional<String> op = Optional.ofNullable(valor);
		op.orElseThrow(NumberFormatException::new );
	}
	private void isPresent(String valor) {
		// Verificar si el valor a sido inicializado o noç, devolviendo false si es null o true si tiene un valor. 
		Optional<String> op = Optional.ofNullable(valor);
		System.out.println(op.isPresent());

	}
	
	public static void main(String[] args) {
		OptionalApp app = new OptionalApp();
//		app.probar("code");
//		app.orElseThrow(null);
		app.isPresent("code");

	}

}
