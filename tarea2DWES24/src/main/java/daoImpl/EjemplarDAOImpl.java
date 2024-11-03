package daoImpl;

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
			ps = con.prepareStatement("insert into ejemplares (id, nombre, fk_planta) values (?,?)");
			ps.setInt(1,ej.getId());
			ps.setString(2, ej.getNombre());
			ps.setString(3, ej.getFk_planta());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar en ejemplares " + e.getMessage());
		}
		return 0;
	}

	public List<Ejemplar> findByTipo(String tipos) {
		try {
			ps = con.prepareStatement("select * from ejemplares INNER JOIN plantas ON ejemplares.fk_planta = plantas.codigo WHERE plantas.nombreComun IN (?)");
			ps.setString(1, tipos);
			rs = ps.executeQuery();
			List<Ejemplar> lEjemplar = new ArrayList<Ejemplar>();
			if (rs.next()) {
				lEjemplar.add(new Ejemplar(rs.getInt(1), rs.getString(2), rs.getString(3)));
				return lEjemplar;
			}

		} catch (SQLException e) {
			System.out.println("error al consultar por tipo " + e.getMessage());

		}
		return null;
	}
	
}
