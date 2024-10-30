package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexionBD {

	private Connection con;
	
	private static ConexionBD f;
	
	private ConexionBD() {
	
	Properties properties=new Properties();
	MysqlDataSource m=new MysqlDataSource();
	FileInputStream fis;
	

	try {
	
		fis=new FileInputStream("src/main/resources/db.properties");
		properties.load(fis);
		m.setUrl(properties.getProperty("url"));
		m.setPassword(properties.getProperty("password"));
		m.setUser(properties.getProperty("usuario"));
		
		con=m.getConnection();
	
	} catch(SQLException e) {
	
		System.out.println("Error al conectar a la base de datos: usuario, password...");
	
	
	} catch(FileNotFoundException e) {
	
		System.out.println("Error al acceder al fichero Properties" +e.getMessage());
	
	
	} catch(IOException e){
	
		System.out.println("Error al leer las propiedades del fichero Properties"+ e.getMessage());
	
	
		}
	
	}
	
	public static ConexionBD getCon() {
	
		if(f==null)
		f=new ConexionBD();
		
		return f;
	
	}

}
