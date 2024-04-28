package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611,53219), SALTA(1441351,155488), TUCUMAN(1731820,22525), CATAMARCA(429562,102602), 
	LA_RIOJA(383865,89680),SANTIAGO_DEL_ESTERO(1060906,136351);

	private int cantidad;
	private int superficie;
	
	private Provincia(int cantidad, int superficie) {
		this.cantidad = cantidad;
		this.superficie = superficie;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int densidadpoblacional() {
		return cantidad/superficie;
	}
	
}

