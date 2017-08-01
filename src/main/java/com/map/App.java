package com.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {

	private Map<Integer, String> map;
	
	private void poblar() {
		map = new HashMap<>();
		map.put(1, "mito");
		map.put(2, "code");
		map.put(3, "mitoCode");
	}
	
	// Para recorrerlo debemos obtener el EntrySet, esto es la lista de elementos que tiene nuestro Map.
	// es una forma imperativa
	private void imprimir_V7() {
		for (Entry<Integer, String> e : map.entrySet()) {
			System.out.println("Llave: " + e.getKey() + ", Valor: " + e.getValue());
		}
	}

	// con el jdk 1.8 y la forma declarativa, tenemos lo siguiente:
	private void imprimir_V8() {
		// forEach necesita un BiConsumer, que es una interfaz Funcional que recibe dos parametos, asi podemos usar 
		// el key y el value del map en ambos parametros.
		map.forEach((k, v) -> System.out.println("Llave: " + k + ", Valor: " + v));
		
		// tambien se puede usar stream
		map.entrySet().stream().forEach(System.out::println);

	}
	
	private void recolectar() {
		// es si queremos filtrar u obtener un subconjunto de ese mapa segun algun criterio
		Map<Integer, String> map2 = map.entrySet().stream()
				.filter(e->e.getValue().contains("co"))
				.collect(Collectors.toMap(p-> p.getKey(), p-> p.getValue()));
		map2.forEach((k, v) -> System.out.println("Llave: " + k + ", Valor: " + v));

	}
	
	private void insertarSiAusente() {
		// metodo putIfAbsent() -> permite agregar un valor si no se encuentra la clave.
		map.putIfAbsent(4, "mauro");
		map.putIfAbsent(2, "sarasa"); // este no hace nada
		// diferente de put que si lo encuentra lo actualiza;
		map.put(2, "rara"); // este si actualiza
	}
	
	private void operarSiPresente() {
		// computeIfPresent -> permite operar con el elemento si encuentra la clave
		map.computeIfPresent(2, (k, v)-> v + " este es el nuevo valor");	//acutaliza el valor con lo indicado en la funcion.
	}
	
	private void obtenerOrPredeterminado() {
		// getOrDefault -> permite obtener un valor si lo encuentra, o bien un default si no existe la clave.
		System.out.println(map.getOrDefault(5, "predeterminado"));
	}
	
	
	public static void main(String[] args) {
		App app = new App();
		app.poblar();
//		app.imprimir_V7();
//		app.insertarSiAusente();
//		app.operarSiPresente();
//		app.obtenerOrPredeterminado();
//		app.imprimir_V8();
		app.recolectar();
	}

}
