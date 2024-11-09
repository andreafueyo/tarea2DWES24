package servicios;

import java.time.LocalDateTime;
import java.util.List;

import control.Controlador;
import dao.EjemplarDAOImpl;
import modelo.Ejemplar;
import modelo.Mensaje;
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
	
	public int findMaxId() {
		return ejemplarDAOImpl.findMaxId();
	}
	
	public void registrarEjemplar(Planta pl, int id_persona) {
		
		int new_id = this.findMaxId()+1;
		Ejemplar ej = new Ejemplar(new_id,pl.getCodigo()+"_"+new_id, pl.getCodigo());
		this.insertar(ej);	
		
		Mensaje m = new Mensaje(LocalDateTime.now(), "mensaje de prueba", id_persona, ej.getId());
		
		Controlador.getServicios().getServMensaje().insertar(m);
	}
	
	public void filtrarEjemplares(String codigos) {
		List<Ejemplar> listaEjemplares = Controlador.getServicios().getServEjemplar().findByTipo(codigos);
		
		for(Ejemplar e : listaEjemplares) {
			System.out.println();
			List<Mensaje> listaMensajes = Controlador.getServicios().getServMensaje().findByEjemplar(e.getId());
			int num_mensajes = listaMensajes.size();
			String ult_fecha = listaMensajes.get(0).getFechahora().toString();
			System.out.println("Ejemplar "+e.getNombre()+", Num Mensajes: "+num_mensajes+", ult mensaje: "+ult_fecha);
		}
	}
	
	public void mostrarEjemplares() {
		System.out.println();
		System.out.println("Estos son los ejemplares: ");
	 	List<Ejemplar> listaEjemplares = Controlador.getServicios().getServEjemplar().findAll();
		
		int contador = 1;
	 	for(Ejemplar e : listaEjemplares) {
	 		System.out.println(contador + ": " + e.toString());
	 		contador++;
	 	}
	 	System.out.println();
	}

	public void verMensajes(int id_ej) {
		System.out.println();
		System.out.println("Estos son los mensajes para el ejemplar "+id_ej+": ");
		
		List<Mensaje> listaMensajes = Controlador.getServicios().getServMensaje().findByEjemplar(id_ej);
	 	if(listaMensajes == null || listaMensajes.isEmpty()) {
	 		System.out.println("No hay mensajes para este ejemplar");
	 	}else {
			for(Mensaje m : listaMensajes) {
		 		System.out.println(m.toString());
		 	}
		 	System.out.println();
	 	}
	}
}
