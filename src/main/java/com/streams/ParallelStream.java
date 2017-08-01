package com.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
	private List<Integer> numeros;
	
	private void llenar() {
		numeros = new ArrayList<>();
		for (int i = 0; i <10; i++) {
			numeros.add(i);
		}

	}
	
	// esto es secuencial
	private void probarStream() {
		numeros.stream().forEach(System.out::println);

	}
	
	// esto es con hilos, lo hace automaticamente...es asincrono.
	// puede mejorar el rendimiento, pero hay casos (sobre todo en javaEE Container) donde no es optimo
	//http://blog.takipi.com/benchmark-how-java-8-lambdas-and-streams-can-make-your-code-5-times-slower/
	private void probarParlelo() {
		numeros.parallelStream().forEach(System.out::println);

	}
	
	public static void main(String[] args) {
		ParallelStream app = new ParallelStream();
		app.llenar();
//		app.probarStream();
		app.probarParlelo();
	}
}
