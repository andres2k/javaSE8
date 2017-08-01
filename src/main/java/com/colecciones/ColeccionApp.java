package com.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColeccionApp {

	private List<String> lista;
	
	public void llenarLista(){
		lista = new ArrayList<>();
		lista.add("mito");
		lista.add("code");
		lista.add("mitocode");
		
	}
	
	private void usarForEach() {
		// jdk 1.7
//		for (String elemento : lista) {
//			System.out.println(elemento);
//		}
		
		// jdk 1.8 -> la coleccion viene con un metodo forEach que necesita un Consumer, que es una interfaz funcional
		// cuyo unico metodo es "accept" .... por eso se usa lambda para implementar su funcionalidad.
//		lista.forEach(x->System.out.println(x));
		// tambien podemos usar la referencia a metodos
		lista.forEach(System.out::println);
	}
	
	// podemos ahora quitar un elemento cuando exista una condicion
	public void usarRemoveIf() {
		// jdk 1.7
//		for (String elemento : lista) {
//			if(elemento.equalsIgnoreCase("code")){
//				lista.remove(elemento);
//			}
//		}
		// si da error de concurrencia al borrar un elemento dentro de un for, hay que usar Iterator
//		Iterator<String> it = lista.iterator();
//		while(it.hasNext()){
//			if(it.next().equalsIgnoreCase("code")){
//				it.remove();
//			}
//		}
		//en jdk 1.8 podemos usar el removeIf que necesita un Predicate es una interfaz funcional
		// con un unico metodo "test" (para eliminacion, agregacion, condicional, etc)....
		lista.removeIf(x -> x.equalsIgnoreCase("code"));
	}
	
	private void usarSort() {
		//en jdk 1.7 usabamos el metodo Collection.sort(lista, Comparator);
		// en jdk 1.8 podemos usar sort que necesita un Comparator, que es una interfaz funcional con
		// el metodo "compare".
		
		
		lista.sort((x,y)-> x.compareTo(y));

	}
	
	public static void main(String[] args) {
		ColeccionApp app = new ColeccionApp();
		app.llenarLista();
		app.usarSort();
		app.usarForEach();
	}

}
