package servicios;

import java.time.LocalDateTime;
import java.util.List;

import control.Controlador;
import dao.EjemplarDAOImpl;
import dao.MensajeDAOImpl;
import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Persona;
import utils.ConexionBD;

public class ServiciosMensaje {
	
	private ConexionBD con;
	private MensajeDAOImpl mensajeDAOImpl;

	public ServiciosMensaje() {
		con = ConexionBD.getCon();
		mensajeDAOImpl = con.getMensajeDAOImpl();
	}

	public int insertar(Mensaje m) {
		return mensajeDAOImpl.insertar(m);
	}
	
//	public Mensaje findByFecha(String email) {
//	}
	
	public List<Mensaje> findByTipo(String tipo) { 
		return mensajeDAOImpl.findByTipo(tipo);
	}

	public List<Mensaje> findByEjemplar(int idEjemplar) { 
		return mensajeDAOImpl.findByEjemplar(idEjemplar);
	}

	public List<Mensaje> findAll() { 
		return mensajeDAOImpl.findAll();
	}
		
	public void registrarMensaje(int id_ej, int id_persona) {
		
		Ejemplar ej = Controlador.getServicios().getServEjemplar().findById(id_ej);
		
		Controlador.getServicios().getServEjemplar().insertar(ej);
		
		List<Mensaje> lMensajes = this.findAll();
		
		int size;
		if(lMensajes == null) {
			size = 1;
		}
		else {
			size = lMensajes.size()+1;
		}
		Persona p = Controlador.getServicios().getServPersona().findById(id_persona);
		
		Mensaje m = new Mensaje(size, LocalDateTime.now(), "mensaje de prueba", p.getId(), ej.getId());
		this.insertar(m);
	}
}
