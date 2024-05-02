package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
    private String numdetarjeta;
	private LocalDate Fechadepago;
	private double montopagado;
	

	public PagoTarjeta(String numdetarjeta, LocalDate fechadepago, double montopagado) {
		this.numdetarjeta = numdetarjeta;
		Fechadepago = fechadepago;
		this.montopagado = montopagado;
	}

	@Override
	public void realizarPago(double monto) {
		double recarga= (montopagado*15) /100;
		montopagado=montopagado+(monto+recarga);
	}

	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		
		System.out.println("\nNúmero de tarjeta: "+ numdetarjeta);
		System.out.println("Fecha de pago: "+ Fechadepago.format(formatter));
		System.out.println("Monto pagado: "+ montopagado+"$");
	}

}
