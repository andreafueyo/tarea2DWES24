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
			ps = con.prepareStatement("insert into plantas (codigo, nombreComun, nombreCientifico) values (?,?)");
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
			ps = con.prepareStatement("update plantas set 'codigo'='?','nombreComun'='?','nombreCientifico'='?' WHERE 1");
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getNombre_comun());
			ps.setString(3, p.getNombre_cientifico());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar en plantas " + e.getMessage());
		}
		return 0;
	}

	public Planta findByCod(String cod) {
		try {
			ps = con.prepareStatement("select * from plantas where codigo=?");
			ps.setString(1, cod);
			rs = ps.executeQuery();
			if (rs.next())
				return new Planta(rs.getString(1), rs.getString(2), rs.getString(3));

		} catch (SQLException e) {
			System.out.println("error al consultar por codigo " + e.getMessage());

		}
		return null;
	}
	public List<Planta> findAll() {
		List<Planta> lPlantas = new ArrayList<Planta>();
		try {
			ps = con.prepareStatement("select * from plantas order by codigo");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				lPlantas.add(new Planta(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			return lPlantas;

		} catch (SQLException e) {
			System.out.println("error al obtener todas las plantas " + e.getMessage());

		}
		return null;
	}

}
