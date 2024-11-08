package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Credencial;
public class CredencialDAOImpl {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CredencialDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(Credencial c) {
		try {
			ps = con.prepareStatement("INSERT INTO credenciales (usuario,password,fk_persona) VALUES (?,?,?)");
			ps.setString(1, c.getUsuario());
			ps.setString(2, c.getPassword());
			ps.setInt(3, c.getFk_persona());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en credenciales " + e.getMessage());
		}
		return 0;
	}

	public Credencial findByUsuario(String usuario) {
		try {
			ps = con.prepareStatement("SELECT * FROM credenciales where usuario=?");
			ps.setString(1, usuario);
			rs = ps.executeQuery();
			if (rs.next())
				return new Credencial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

		} catch (SQLException e) {
			System.out.println("error al consultar por usuario " + e.getMessage());

		}
		return null;
	}
	
	public List<Credencial> findAll() {
		List<Credencial> listaCredenciales = new ArrayList<Credencial>();
		try {
			ps = con.prepareStatement("SELECT * FROM credenciales");
			rs = ps.executeQuery();

			while (rs.next()) {
				listaCredenciales.add(new Credencial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			return listaCredenciales;
		} catch (SQLException e) {
			System.out.println("Error al consultar " + e.getMessage());

		}
		return null;
	}

}
