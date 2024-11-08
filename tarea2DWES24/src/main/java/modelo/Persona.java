package modelo;

public class Persona {

	private int id;
	private String nombre;
	private String email;
	
	public Persona(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}
	
	public Persona(int id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		String ret ="";
		ret ="PERSONA";
		ret += "\tID: " + this.id;
		ret += "\tNombre: " + this.nombre;
		ret += "\tCorreo electrónico " + this.email;
		return ret;
	}
	
}
