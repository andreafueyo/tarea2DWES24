package modelo;

public class Credencial {
	
	private int id;
	private String usuario;
	private String password;
	private int fk_persona;
	
	public Credencial(int id, String usuario, String password, int fk_persona) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.fk_persona = fk_persona;
	}
	
	
	public Credencial(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFk_persona() {
		return fk_persona;
	}

	public void setFk_persona(int fk_persona) {
		this.fk_persona = fk_persona;
	}

	
	@Override
	public String toString() {
		String ret ="";
		ret ="CREDENCIAL";
		ret += "\tID: " + this.id;
		ret += "\tUsuario: " + this.usuario;
		ret += "\tPassword: " + this.password;
		ret += "\tfk_persona: " + this.fk_persona;
		return ret;
	}
	
	
	
}
