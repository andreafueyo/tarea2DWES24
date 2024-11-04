package servicios;

import java.util.List;

import dao.MensajeDAOImpl;
import modelo.Mensaje;
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

}
