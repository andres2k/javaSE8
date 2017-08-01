package com.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {

	private List<String> lista;
	private List<String> numeros;
	
	// Con el api Stream podemos realizar operaciones como filtros, contar, ordenamiento, etc de una
	// forma declarativa
	public StreamsApp(){
		lista = new ArrayList<>();
		lista.add("Mito");
		lista.add("Code");
		lista.add("Jaime");
		lista.add("Mitocode");
		
		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
		numeros.add("3");

	}
	private void filtrar() {
		// ejemplo filtrar todos los elementos de la lista que empiezen con M
		 lista.stream().filter(x->x.startsWith("m"));
		 lista.forEach(System.out::println);
		 System.out.println(".........");
		 // si lo hago como antes no me muestra lo filtrado, tendria que guardarlo en otra lista..para esto podemos hacer.
		 lista.stream().filter(x->x.startsWith("m")).forEach(System.out::println);
	}
	private void ordenar() {
		// ordena de forma ascendente por defecto
//		lista.stream().sorted().forEach(System.out::println);
		// si quiero otra forma de ordenar le mando el Comparator
		lista.stream().sorted((x,y)->y.compareTo(x)).forEach(System.out::println);
	}
	private void limitar() {
		// mediante limit, permite acortar la lista.
		lista.stream().limit(2).forEach(System.out::println);

	}
	private void transformar() {
		//mediante map puedo convertir una lista en otra luego de aplicar la funcion especificada
		lista.stream().map(String::toUpperCase).forEach(System.out::println);
		// supongamos que quiero agarrar la lista de numeros, transformarla a enteros y sumarle un valor
		//forma tradicional
//		for (String elementos : numeros) {
//			int num = Integer.parseInt(elementos) + 1;
//			System.out.println(num);
//		}
		// con api stream
		numeros.stream().map(x-> Integer.parseInt(x)+1).forEach(System.out::println);
	}
	private void contar() {
		// mediante el metodo count del stream me devuelve el tamaño de la coleccion
		System.out.println(lista.stream().count());

	}
	
	public static void main(String[] args) {
		StreamsApp app = new StreamsApp();
//		app.filtrar();
//		app.ordenar();
//		app.transformar();
//		app.limitar();
		app.contar();
	}

}
