package servicios;

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

}
