package com.dateapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class App {

	private void verificar(int version) {
		if (version==7) {
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();
			fecha1.set(1991, 0, 21);	// En calendar el mes enero es el 0. y termina en 11
			System.out.println(fecha1.after(fecha2));
		}else if(version==8){
			LocalDate fecha1 = LocalDate.of(1991, 01, 21);	//aca enero es el 01, siendo mas legible.
			LocalDate fecha2 = LocalDate.now();
			System.out.println(fecha1.isAfter(fecha2));
			System.out.println(fecha1.isBefore(fecha2));
			
			//Tambien podemos operar con el tiempo
			LocalTime time1 = LocalTime.of(22, 30, 50);	//aca enero es el 01, siendo mas legible.
			LocalTime time2 = LocalTime.now();
			System.out.println(time1.isAfter(time2));
			System.out.println(time1.isBefore(time2));
			
			//Tambien podemos manejar fecha y tiempo
			LocalDateTime fechaTiempo1 = LocalDateTime.of(1991, 01, 21, 22, 30, 50);	//aca enero es el 01, siendo mas legible.
			LocalDateTime fechaTiempo2 = LocalDateTime.now();
			System.out.println(fechaTiempo1.isAfter(fechaTiempo2));
			System.out.println(fechaTiempo1.isBefore(fechaTiempo2));
		}

	}
	
	private void medirTiempo(int version) throws InterruptedException {
		// En la 1.7 usamos System.currentTimeMillis
		if (version==7) {
			long ini = System.currentTimeMillis();
			Thread.sleep(1000);
			long fin = System.currentTimeMillis();
			System.out.println(fin-ini);
		}else if(version==8){
			Instant ini = Instant.now();
			Thread.sleep(1000);
			Instant fin = Instant.now();
			System.out.println(Duration.between(ini, fin).toMillis()); // Esto devuelve con la convencion de Duration..pero se puede convertir a lo que queramos
		}

	}
	
	private void periodoEntreFechas(int version) {
		if (version==7) {
			Calendar nacimiento = Calendar.getInstance();
			Calendar actual = Calendar.getInstance();
			
			nacimiento.set(1978, 4, 11);
			actual.set(2017, 7, 15);
			int anios = 0;
			
			while (nacimiento.before(actual)) {
				nacimiento.add(Calendar.YEAR, 1);
				if(nacimiento.before(actual)){
					anios++;
				}
			}
			System.out.println(anios);
		}else if(version==8){
			LocalDate nacimiento = LocalDate.of(1978, 5, 11);
			LocalDate actual = LocalDate.of(2017, 8, 15);
			Period periodo = Period.between(nacimiento, actual);
			System.out.println("han transcurrido " + periodo.getYears() + " años, " + periodo.getMonths()+ 
					" meses y " + periodo.getDays() + " dias desde el nacimiento a hoy.");
		}
	}
	// Convertir
	private void conversion(int version) throws ParseException {
		if(version==7){
			String fecha = "11/05/1978";
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaConvertida = formateador.parse(fecha);
			System.out.println(fechaConvertida);
			
			Date fechaActual = Calendar.getInstance().getTime();
			formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaCadena = formateador.format(fechaActual);
			System.out.println(fechaCadena);
		}else if(version==8){
			String fecha = "11/05/1978";
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
			System.out.println(fechaLocal);
			System.out.println(formateador.format(fechaLocal));
		}

	}
	
	public static void main(String[] args) {
		App app = new App();
		try {
//			app.verificar(8);
//			app.medirTiempo(8);
//			app.periodoEntreFechas(8);
			app.conversion(8);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
