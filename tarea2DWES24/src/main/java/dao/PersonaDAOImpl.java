package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
			ps = con.prepareStatement("insert into personas (id,nombre,email) values (?,?,?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getEmail());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en personas " + e.getMessage());
		}
		return 0;
	}

	public Persona findByEmail(String email) {
		try {
			ps = con.prepareStatement("select * from personas where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next())
				return new Persona(rs.getInt(1), rs.getString(2), rs.getString(3));

		} catch (SQLException e) {
			System.out.println("error al consultar por email " + e.getMessage());

		}
		return null;
	}


}