package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Persona;
public class PersonaDAOImpl {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public PersonaDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(Persona p) {
		try {
			ps = con.prepareStatement("INSERT INTO personas (nombre,email) VALUES (?,?)");
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getEmail());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en personas " + e.getMessage());
		}
		return 0;
	}

	
	public Persona findByEmail(String email) {
		try {
			ps = con.prepareStatement("SELECT * FROM personas WHERE email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next())
				return new Persona(rs.getInt(1), rs.getString(2), rs.getString(3));

		} catch (SQLException e) {
			System.out.println("Error al consultar por email " + e.getMessage());

		}
		return null;
	}
	
	public Persona findById(int id) {
		try {
			ps = con.prepareStatement("SELECT * FROM personas WHERE id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return new Persona(rs.getInt(1), rs.getString(2), rs.getString(3));

		} catch (SQLException e) {
			System.out.println("Error al consultar por email " + e.getMessage());

		}
		return null;
	}
	
	public List<Persona> findAll() {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		try {
			ps = con.prepareStatement("SELECT * FROM personas");
			rs = ps.executeQuery();

			while (rs.next()) {
				listaPersonas.add(new Persona(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return listaPersonas;
		} catch (SQLException e) {
			System.out.println("Error al consultar" + e.getMessage());

		}
		return null;
	}


}