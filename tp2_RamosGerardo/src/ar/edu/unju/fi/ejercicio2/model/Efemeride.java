package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private String codigo;
    private Mes mes;
	private int día;
	private String detalle;
	
	public Efemeride() {
		
	}

	public Efemeride(String codigo, Mes mes, int día, String detalle) {
		this.codigo = codigo;
		this.mes = mes;
		this.día = día;
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Mes: " + mes + ", Día: " + día + ", Detalle: " + detalle;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public int getDía() {
		return día;
	}

	public void setDía(int día) {
		this.día = día;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
    
	
	
}

