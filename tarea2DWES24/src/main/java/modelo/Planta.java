package modelo;

public class Planta {
	
	private String codigo;
	private String nombre_comun;
	private String nombre_cientifico;
		
	public Planta(String codigo, String nombre_comun, String nombre_cientifico) {
		super();
		this.codigo = codigo;
		this.nombre_comun = nombre_comun;
		this.nombre_cientifico = nombre_cientifico;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre_comun() {
		return nombre_comun;
	}
	public void setNombre_comun(String nombre_comun) {
		this.nombre_comun = nombre_comun;
	}
	public String getNombre_cientifico() {
		return nombre_cientifico;
	}
	public void setNombre_cientifico(String nombre_cientifico) {
		this.nombre_cientifico = nombre_cientifico;
	}
	
	@Override
	public String toString() {
		return "Planta [codigo=" + codigo + ", nombre_comun=" + nombre_comun + ", nombre_cientifico="
				+ nombre_cientifico + "]";
	}
	
	

}
