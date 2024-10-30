package principal;

import java.util.Scanner;

import modelo.Planta;
import utils.ConexionBD;

public class Principal {

	public static void main(String[] args) {
		

		System.out.println("INI");
		
		Scanner in = new Scanner (System.in);
		
		ConexionBD con = ConexionBD.getCon();

		System.out.println("Programa de gestion de un invernadero");

		int opcion = 0;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println("Dame el código de la nueva planta.");
//		String codigo = in.nextLine().trim().toUpperCase();
//		System.out.println("Dame el nombre común de la nueva planta.");
//		String nombre_comun = in.nextLine();
//		System.out.println("Dame el nombre científico de la nueva planta.");
//		String nombre_cientifico = in.nextLine();
//		
//		Planta nueva= new Planta(codigo, nombre_comun, nombre_cientifico);
		
//		Connection con;
//		MysqlDataSource m = new MysqlDataSource();
//		Properties prop = null;
//		FileInputStream fis;
////		
//		String url;
//		String usuario;
//		String password;
//		
//		try {
//			
//			fis = new FileInputStream("src/main/resources/db.properties");
//			prop.load(fis);
//			url = prop.getProperty("url");
//			usuario = prop.getProperty("usuario");
//			password = prop.getProperty("password");
//			m.setUrl(url);
//			m.setUser(usuario);
//			m.setPassword(password);
//			
//			con = DriverManager.getConnection(url, usuario, password);
//			
//			
//			String sql = "INSERT INTO plantas(codigo, nombrecomun, nombrecientifico) VALUES (?,?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, nueva.getCodigo());
//			ps.setString(2, nueva.getNombre_comun());
//			ps.setString(3, nueva.getNombre_cientifico());
//			
//			ps.executeUpdate();
//			ps.close();
//			con.close();
//			
//		}
//		
//		catch (SQLException e) {
//			System.out.println("Se ha producido uns SQLException: " + e.getLocalizedMessage()); 
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			System.out.println("Se ha producido un FileNotFoundException: " + e.getLocalizedMessage());
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("Se ha producido una IOException: " + e.getLocalizedMessage());
//			e.printStackTrace();
//		}
//	
		
//		menú de opciones
		
		
		
		
		System.out.println("FIN");

	}

}
