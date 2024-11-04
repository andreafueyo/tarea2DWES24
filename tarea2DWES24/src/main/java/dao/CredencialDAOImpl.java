package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
			ps = con.prepareStatement("insert into credenciales (id,usuario,password,fk_persona) values (?,?,?,?)");
			ps.setInt(1, c.getId());
			ps.setString(2, c.getUsuario());
			ps.setString(3, c.getPassword());
			ps.setInt(4, c.getFk_persona());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en credenciales " + e.getMessage());
		}
		return 0;
	}

	public Credencial findByUsuario(String usuario) {
		try {
			ps = con.prepareStatement("select * from credenciales where usuario=?");
			ps.setString(1, usuario);
			rs = ps.executeQuery();
			if (rs.next())
				return new Credencial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

		} catch (SQLException e) {
			System.out.println("error al consultar por usuario " + e.getMessage());

		}
		return null;
	}

}
