package servicios;

import java.time.LocalDateTime;
import java.util.List;

import control.Controlador;
import dao.EjemplarDAOImpl;
import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Persona;
import modelo.Planta;
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
	
	public List<Ejemplar> findAll() {
		return ejemplarDAOImpl.findAll();
	}
	
	public Ejemplar findById(int id) {
		return ejemplarDAOImpl.findById(id);
	}
	
	public void registrarEjemplar(String cod_planta, int id_persona) {
		Planta planta = Controlador.getServicios().getServPlanta().findByCod(cod_planta);
		
		//para insertar y que el id sea único, obtengo el numero total de ejemplares y le sumo uno
		List<Ejemplar> lEjemplares = this.findAll();
		
		int size;
		if(lEjemplares == null) {
			size = 1;
		}
		else {
			size  = lEjemplares.size()+1;
		}
		
		
		Ejemplar ej = new Ejemplar(size, planta.getCodigo()+"_"+size, planta.getCodigo());
		
		this.insertar(ej);
		
		List<Mensaje> lMensajes = Controlador.getServicios().getServMensaje().findAll();
		
		int size2;
		if(lMensajes == null) {
			size2 = 1;
		}
		else {
			size2 = lMensajes.size()+1;
		}
		
		Persona p = Controlador.getServicios().getServPersona().findById(id_persona);
		Mensaje m = new Mensaje(size2, LocalDateTime.now(), "mensaje de prueba", p.getId(), ej.getId());
		
		Controlador.getServicios().getServMensaje().insertar(m);
	}
	
	public void filtrarEjemplares(String codigos) {
		List<Ejemplar> lEjemplares = Controlador.getServicios().getServEjemplar().findByTipo(codigos);
		
		for(Ejemplar e : lEjemplares) {
			System.out.println();
			List<Mensaje> lMensajes = Controlador.getServicios().getServMensaje().findByEjemplar(e.getId());
			int num_mensajes = lMensajes.size();
			String ult_fecha = lMensajes.get(0).getFechahora().toString();
			System.out.println("Ejemplar "+e.getNombre()+", Num Mensajes: "+num_mensajes+", ult mensaje: "+ult_fecha);
		}
	}
	
	public void mostrarEjemplares() {
		System.out.println();
		System.out.println("Estos son los ejemplares: ");
	 	List<Ejemplar> lEjemplares = Controlador.getServicios().getServEjemplar().findAll();
		
		int contador = 1;
	 	for(Ejemplar e : lEjemplares) {
	 		System.out.println(contador + ": " + e.toString());
	 		contador++;
	 	}
	 	System.out.println();
	}

	public void verMensajes(int id_ej) {
		System.out.println();
		System.out.println("Estos son los mensajes para el ejemplar "+id_ej+": ");
		
		List<Mensaje> listaMensajes = Controlador.getServicios().getServMensaje().findByEjemplar(id_ej);
	 	for(Mensaje m : listaMensajes) {
	 		System.out.println(m.toString());
	 	}
	 	System.out.println();
	}
}
