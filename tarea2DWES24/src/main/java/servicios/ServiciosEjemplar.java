package servicios;

import java.util.List;

import dao.EjemplarDAOImpl;
import modelo.Ejemplar;
import utils.ConexionBD;

public class ServiciosEjemplar {
	
	private ConexionBD con;
	private EjemplarDAOImpl ejemplarDAOImpl;

	public ServiciosEjemplar() {
		con = ConexionBD.getCon();
		ejemplarDAOImpl = con.getEjemplarDAOImpl();
	}

	public int insertar(Ejemplar ej) {
		return ejemplarDAOImpl.insertar(ej);
	}

	public List<Ejemplar> findByTipo(String tipos) {
		return ejemplarDAOImpl.findByTipo(tipos);
	}

}
