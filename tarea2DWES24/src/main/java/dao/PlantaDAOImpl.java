package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Planta;

public class PlantaDAOImpl {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public PlantaDAOImpl(Connection con) {
		this.con = con;
	}

	public int insertar(Planta p) {
		try {
			ps = con.prepareStatement("INSERT INTO plantas (codigo, nombreComun, nombreCientifico) VALUES (?,?,?)");
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getNombre_comun());
			ps.setString(3, p.getNombre_cientifico());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en plantas " + e.getMessage());
		}
		return 0;
	}

	public int modificar(Planta p) {
		try {
			ps = con.prepareStatement("UPDATE plantas SET nombreComun=?,nombreCientifico=? WHERE codigo=?");

			ps.setString(1, p.getNombre_comun());
			ps.setString(2, p.getNombre_cientifico());
			ps.setString(3, p.getCodigo());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar en plantas " + e.getMessage());
		}
		return 0;
	}

	public Planta findByCod(String cod) {
		try {
			ps = con.prepareStatement("SELECT * FROM plantas WHERE codigo=?");
			ps.setString(1, cod);
			rs = ps.executeQuery();
			if (rs.next())
				return new Planta(rs.getString(1), rs.getString(2), rs.getString(3));

		} catch (SQLException e) {
			System.out.println("Error al consultar por código " + e.getMessage());

		}
		return null;
	}
	
	public List<Planta> findAll() {
		List<Planta> listaPlantas = new ArrayList<Planta>();
		try {
			ps = con.prepareStatement("SELECT * FROM plantas ORDER BY codigo");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				listaPlantas.add(new Planta(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			return listaPlantas;

		} catch (SQLException e) {
			System.out.println("Error al obtener todas las plantas " + e.getMessage());

		}
		return null;
	}

}
