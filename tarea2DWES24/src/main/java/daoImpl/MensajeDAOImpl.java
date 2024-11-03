package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
			ps = con.prepareStatement("insert into mensajes (id,fechahora,mensaje,fk_personasMensajes,fk_ejemplaresMensajes) values (?,?,?,?,?)");
			ps.setInt(1,m.getId());
			ps.setDate(2, Date.valueOf(m.getFechahora()));
			ps.setString(3, m.getMensaje());
			ps.setInt(4, m.getFk_personasMensajes());
			ps.setInt(5,m.getFk_ejemplaresMensajes());			
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
		try {
			ps = con.prepareStatement("select * from mensajes INNER JOIN plantas ON mensajes.fk_ejemplaresMensajes = plantas.codigo WHERE plantas.nombreComun =?"); 
			ps.setString(1, tipo);
			rs = ps.executeQuery();
			List<Mensaje> lMensajes = new ArrayList<Mensaje>();
			if (rs.next()) {
				lMensajes.add(new Mensaje(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getString(3), rs.getInt(4), rs.getInt(5)));
				return lMensajes;
			}
		} catch (SQLException e) {
			System.out.println("error al consultar por tipo " + e.getMessage());
	
		}
		return null;
	}

	public List<Mensaje> findByEjemplar(int idEjemplar) { 
		try {
			ps = con.prepareStatement("select * from mensajes INNER JOIN plantas ON mensajes.fk_ejemplaresMensajes = plantas.codigo WHERE plantas.codigo=?"); 
			ps.setInt(1, idEjemplar);
			rs = ps.executeQuery();
			List<Mensaje> lMensajes = new ArrayList<Mensaje>();
			if (rs.next()) {
				lMensajes.add(new Mensaje(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getString(3), rs.getInt(4), rs.getInt(5)));
				return lMensajes;
			}
		} catch (SQLException e) {
			System.out.println("error al consultar por ejemplar " + e.getMessage());
	
		}
		return null;
	}
	
}
