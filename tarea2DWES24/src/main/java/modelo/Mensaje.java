package modelo;

import java.time.LocalDateTime;

public class Mensaje {
	
	private int id;
	private LocalDateTime fechahora;
	private String mensaje;
	private int fk_personasMensajes;
	private int fk_ejemplaresMensajes;

	public Mensaje(LocalDateTime fechahora, String mensaje, int fk_personasMensajes, int fk_ejemplaresMensajes) {
		super();
		this.fechahora = fechahora;
		this.mensaje = mensaje;
		this.fk_personasMensajes = fk_personasMensajes;
		this.fk_ejemplaresMensajes = fk_ejemplaresMensajes;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDateTime getFechahora() {
		return fechahora;
	}
	
	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public int getFk_personasMensajes() {
		return fk_personasMensajes;
	}
	
	public void setFk_personasMensajes(int fk_personasMensajes) {
		this.fk_personasMensajes = fk_personasMensajes;
	}
	
	public int getFk_ejemplaresMensajes() {
		return fk_ejemplaresMensajes;
	}
	
	public void setFk_ejemplaresMensajes(int fk_ejemplaresMensajes) {
		this.fk_ejemplaresMensajes = fk_ejemplaresMensajes;
	}
	
	
	@Override
	public String toString() {
		String ret ="";
		ret ="MENSAJE";
		ret += "\tID: " + this.id;
		ret += "\tFecha y hora: " + this.fechahora;
		ret += "\tMensaje: " + this.mensaje;
		ret += "\tfk_personasMensajes: " + this.fk_personasMensajes;
		ret += "\tfk_ejemplaresMensajes: " + this.fk_ejemplaresMensajes;
		return ret;
	}

	
}
