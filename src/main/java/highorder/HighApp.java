package highorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {
	private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
	private Function<String, String> convertirMinusculas = x -> x.toLowerCase();
	
	//Recibe una funcion, y con el parametro aplica dicha funcion.
	public void imprimir(Function<String, String> funcion, String valor){
		System.out.println(funcion.apply(valor));
	}
	
	//Devuelve una funcion que es utilizada luego.
	public Function<String, String> mostrar (String mensaje){
		return (String x) -> mensaje + x;
	}
	
	//filter necesita un Predicate -> es una interfaz funcional..predicado es basicamente una funcion lambda
	// Consumer -> es una interface funcional que acepta parametros
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud, String cadena){
//		lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
		lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
	}
	
	private Predicate<? super String> establecerLogicaFiltro(String cadena) {
		return texto -> texto.contains(cadena);
	}

	public Predicate<String> establecerLogicaFiltro(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	public static void main(String[] args) {
		HighApp app = new HighApp();
		app.imprimir(app.convertirMayusculas, "una cadena");

		System.out.println(app.mostrar("Hola").apply(" mundo."));
		
		List<String> lista = new ArrayList<>();
		lista.add("Mauro");
		lista.add("Thiago");
		lista.add("Naiara");
		lista.add("Irupe");
		
		app.filtrar(lista, System.out::println, 5, "a");
		
	}

}
