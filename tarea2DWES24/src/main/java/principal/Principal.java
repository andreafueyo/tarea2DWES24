package principal;

import java.util.Scanner;

import fachada.ViveroFachadaPrincipal;
import modelo.Planta;
import utils.ConexionBD;

public class Principal {

	public static void main(String[] args) {
		
		ViveroFachadaPrincipal portal = ViveroFachadaPrincipal.getPortal();
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("INICIO");
	
		System.out.println("Programa de gestión de un invernadero");
		
		portal.mostrarMenuPrincipal();

	}

}
