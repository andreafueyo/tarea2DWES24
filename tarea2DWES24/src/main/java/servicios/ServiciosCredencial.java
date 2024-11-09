package servicios;

import java.util.List;

import control.Controlador;
import dao.CredencialDAOImpl;
import modelo.Credencial;
import utils.ConexionBD;

public class ServiciosCredencial {
	
	private ConexionBD con;
	private CredencialDAOImpl credencialDAOImpl;

	public ServiciosCredencial() {
		con = ConexionBD.getCon();
		credencialDAOImpl = con.getCredencialDAOImpl();
	}
	
	public boolean validarNuevaCredencial(Credencial c) { //Si ya existe, devuelve false
		
		if(this.findByUsuario(c.getUsuario()) == null) {
			return true;
		}
		else {
			return false;
		}
		
	}	
	
	public boolean validarCredencialContraseña(Credencial c) { //Si coincide, devuelve true
		if(this.findByUsuario(c.getUsuario()) == null) {
			return false;
		}
		else if(this.findByUsuario(c.getUsuario()).getPassword().equals(c.getPassword())){
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public String validarTipoUsuario(Credencial c) { //Devuelve el tipo de usuario
		if(c.getUsuario().equals("invitado") && c.getPassword().equals("invitado")) {
			return "invitado";
		}
		else if(c.getUsuario().equals("admin") && c.getPassword().equals("admin")) {
			return "admin";
		} else {
				return "personal";
		}
	}
	
	public int insertar(Credencial c) {
		return credencialDAOImpl.insertar(c);
	}

	public Credencial findByUsuario(String usuario) {
		return credencialDAOImpl.findByUsuario(usuario);
	}

	public List<Credencial> findAll(){
		return credencialDAOImpl.findAll();
	}

	public void registrarCredencial(String usuario, String password, String email) {
				
		int id_persona = Controlador.getServicios().getServPersona().findByEmail(email).getId();
		Credencial c = new Credencial(usuario, password, id_persona);
		
		this.insertar(c);
	}	
	
}
