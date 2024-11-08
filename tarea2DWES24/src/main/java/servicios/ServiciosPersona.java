package servicios;

import java.util.List;

import dao.PersonaDAOImpl;
import modelo.Persona;
import utils.ConexionBD;

public class ServiciosPersona {
	
	private ConexionBD con;
	private PersonaDAOImpl personaDAOImpl;

	public ServiciosPersona() {
		con = ConexionBD.getCon();
		personaDAOImpl = con.getPersonaDAOImpl();
	}
	
	public boolean validarPersona(Persona p) { 
		//si ya existe persona con ese email devuelve false
		
		if(this.findByEmail(p.getEmail()) == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int insertar(Persona p) {
		return personaDAOImpl.insertar(p);
	}

	public Persona findByEmail(String email) {
		return personaDAOImpl.findByEmail(email);
	}
	
	public Persona findById(int id) {
		return personaDAOImpl.findById(id);
	}

	public List<Persona> findAll() {
		return personaDAOImpl.findAll();
	}

	public void registrarPersona(String nombre, String email) {
				
		List<Persona> listaPersonas = this.findAll();
		Persona p = new Persona(nombre,email);
		
		this.insertar(p);
	}

}
