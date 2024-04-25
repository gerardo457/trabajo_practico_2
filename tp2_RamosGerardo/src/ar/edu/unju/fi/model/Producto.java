package ar.edu.unju.fi.model;

public class Producto {
   private String codigo;
   private String descripcion;
   private float preciounitario;
   private origenFabricacion origen;
   private categoria categoria;
   
   public enum origenFabricacion{
	   ARGENTINA, CHINA, BRASIL, URUGUAY;
   }
   public enum categoria{
	   TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
   }
   
   public Producto() {
	// TODO Auto-generated constructor stub
   }

   public Producto(String codigo, String descripcion, float preciounitario, origenFabricacion origen,
		ar.edu.unju.fi.model.Producto.categoria categoria) {
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.preciounitario = preciounitario;
	this.origen = origen;
	this.categoria = categoria;
   }

   
public String toString() {
	return "Codigo del Producto: " + codigo + ", Descripcion: " + descripcion + ", Precio Unitario: " + preciounitario
			+ "$ , Origen: " + origen + ", Categoria: " + categoria;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public float getPreciounitario() {
	return preciounitario;
}

public void setPreciounitario(float preciounitario) {
	this.preciounitario = preciounitario;
}

public origenFabricacion getOrigen() {
	return origen;
}

public void setOrigen(origenFabricacion origen) {
	this.origen = origen;
}

public categoria getCategoria() {
	return categoria;
}

public void setCategoria(categoria categoria) {
	this.categoria = categoria;
}
   
   
   
   
}
