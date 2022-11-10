package app.curso.main;
import java.util.Scanner;

import app.curso.entidad.Gestor;
import app.curso.util.DatabaseGestor;

public class MainGestorIngresar {
    public static void main(String[] args) {
        DatabaseGestor database = new DatabaseGestor();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("INGRESAR UN NUEVO GESTOR");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese el usuario: ");
		String username = keyboard.next();

		System.out.print("Ingrese el contraseña: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese el correo: ");
		String correo = keyboard.next();

        Gestor gestor = new Gestor (0, username, password, correo);
        boolean gestorIngresado = database.insertarGestor(gestor);

        if(gestorIngresado){
            System.out.println("-------------------------------------");
            System.out.println("Gestor ingresado Correctamente");
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se ha podido ingresar el gestor");
            System.out.println("-------------------------------------");
        }

        keyboard.close();
    }
}