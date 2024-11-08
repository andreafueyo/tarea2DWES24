package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Ejemplar;

public class EjemplarDAOImpl {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public EjemplarDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(Ejemplar ej) {
		try {
			ps = con.prepareStatement("INSERT INTO ejemplares (nombre, fk_planta) VALUES (?,?)");
			ps.setString(1, ej.getNombre());
			ps.setString(2, ej.getFk_planta());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en ejemplares " + e.getMessage());
		}
		return 0;
	}

	public List<Ejemplar> findByTipo(String tipos) {
		List<Ejemplar> listaEjemplar = new ArrayList<Ejemplar>();
		try {
			ps = con.prepareStatement("SELECT * FROM ejemplares INNER JOIN plantas ON ejemplares.fk_planta = plantas.codigo WHERE plantas.codigo IN (?)");
			ps.setString(1, tipos);
			rs = ps.executeQuery();

			while (rs.next()) {
				listaEjemplar.add(new Ejemplar(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return listaEjemplar;
		} catch (SQLException e) {
			System.out.println("Error al consultar por tipo " + e.getMessage());

		}
		return null;
	}
	
	
	public List<Ejemplar> findAll() {
		List<Ejemplar> listaEjemplar = new ArrayList<Ejemplar>();
		try {
			ps = con.prepareStatement("SELECT * FROM ejemplares");
			rs = ps.executeQuery();

			while (rs.next()) {
				listaEjemplar.add(new Ejemplar(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return listaEjemplar;
		} catch (SQLException e) {
			System.out.println("Error al consultar por tipo " + e.getMessage());

		}
		return null;
	}
	
	
	public Ejemplar findById(int id) {
		try {
			ps = con.prepareStatement("SELECT * FROM ejemplares");
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Ejemplar(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			System.out.println("Error al consultar por tipo " + e.getMessage());

		}
		return null;
	}
	
}
