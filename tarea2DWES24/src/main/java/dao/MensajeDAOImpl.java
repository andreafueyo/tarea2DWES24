package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import modelo.Mensaje;
public class MensajeDAOImpl {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public MensajeDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(Mensaje m) {
		try {
			ps = con.prepareStatement("INSERT INTO mensajes (fechahora,mensaje,fk_personasMensajes,fk_ejemplaresMensajes) VALUES (?,?,?,?)");
			ps.setTimestamp(1, Timestamp.valueOf(m.getFechahora()));
			ps.setString(2, m.getMensaje());
			ps.setInt(3, m.getFk_personasMensajes());
			ps.setInt(4, m.getFk_ejemplaresMensajes());			
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en mensajes " + e.getMessage());
		}
		return 0;
	}

//	public Mensaje findByFecha(String email) {
//		try {
//
//		} catch (SQLException e) {
//			System.out.println("error al consultar por fecha " + e.getMessage());
//
//		}
//		return null;
//	}
	
	public List<Mensaje> findByTipo(String tipo) { 
		List<Mensaje> listaMensajes = new ArrayList<Mensaje>();
		try {
			ps = con.prepareStatement("SELECT * FROM mensajes INNER JOIN plantas ON mensajes.fk_ejemplaresMensajes = plantas.codigo WHERE plantas.nombreComun =?"); 
			ps.setString(1, tipo);
			rs = ps.executeQuery();

			while (rs.next()) {
				listaMensajes.add(new Mensaje(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
			return listaMensajes;
		} catch (SQLException e) {
			System.out.println("Error al consultar por tipo " + e.getMessage());
	
		}
		return null;
	}

	public List<Mensaje> findByEjemplar(int idEjemplar) { 
		List<Mensaje> listaMensajes = new ArrayList<Mensaje>();
		try {
			ps = con.prepareStatement("SELECT * FROM mensajes INNER JOIN plantas ON mensajes.fk_ejemplaresMensajes = plantas.codigo WHERE plantas.codigo=?"); 
			ps.setInt(1, idEjemplar);
			rs = ps.executeQuery();

			while (rs.next()) {
				listaMensajes.add(new Mensaje(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
			System.out.println(listaMensajes);
			return listaMensajes;
		} catch (SQLException e) {
			System.out.println("Error al consultar por ejemplar " + e.getMessage());
		}
		return null;
	}
	
	public List<Mensaje> findAll() { 
		List<Mensaje> listaMensajes = new ArrayList<Mensaje>();
		try {
			ps = con.prepareStatement("SELECT * FROM mensajes"); 
			rs = ps.executeQuery();

			while (rs.next()) {
				listaMensajes.add(new Mensaje(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
			return listaMensajes;
		} catch (SQLException e) {
			System.out.println("Error al consultar por ejemplar " + e.getMessage());
		}
		return null;
	}
	
}
