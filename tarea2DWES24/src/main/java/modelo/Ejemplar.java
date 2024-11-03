package modelo;

public class Ejemplar {
	
	private int id;
	private String nombre;
	private String fk_planta;
	
	public Ejemplar(int id, String nombre, String fk_planta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fk_planta = fk_planta;
	}
	@Override
	public String toString() {
		return "Ejemplar [id=" + id + ", nombre=" + nombre + ", fk_planta=" + fk_planta + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFk_planta() {
		return fk_planta;
	}
	public void setFk_planta(String fk_planta) {
		this.fk_planta = fk_planta;
	}

}
