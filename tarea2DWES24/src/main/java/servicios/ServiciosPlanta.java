package servicios;

import java.util.List;

import dao.PlantaDAOImpl;
import modelo.Planta;
import utils.ConexionBD;

public class ServiciosPlanta {
	
	private ConexionBD con;
	private PlantaDAOImpl plantaDAOImpl;

	public ServiciosPlanta() {
		con = ConexionBD.getCon();
		plantaDAOImpl = con.getPlantaDAOImpl();
	}
	
	public boolean existePlanta(String cod) { 
		//si ya existe planta con ese codigo devuelve true
		
		if(this.findByCod(cod) == null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public int insertar(Planta p) {
		return plantaDAOImpl.insertar(p);
	}

	public int modificar(Planta p) {
		return plantaDAOImpl.modificar(p);
	}

	public Planta findByCod(String cod) {
		return plantaDAOImpl.findByCod(cod);
	}
	
	public List<Planta> findAll() {
		return plantaDAOImpl.findAll();
	}
	
}
