package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
 
	private LocalDate Fechadepago;
	private double montopagado;

	public PagoEfectivo(LocalDate fechadepago, double montopagado) {
		Fechadepago = fechadepago;
		this.montopagado = montopagado;
	}

	@Override
	public void realizarPago(double monto) {
		double descuento = (monto*10) /100;
		montopagado=montopagado+(monto-descuento);
	}

	@Override
	public void imprimirRecibo() {
	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
	   System.out.println("\nFecha de pago: "+ Fechadepago.format(formatter));
	   System.out.println("Monto pagado: "+ montopagado +"$");
	}
}
