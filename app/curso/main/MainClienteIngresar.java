package app.curso.main;
import java.util.Scanner;
import app.curso.entidad.Cliente;
import app.curso.util.DatabaseCliente;

public class MainClienteIngresar {
    public static void main(String[] args) {
        DatabaseCliente database = new DatabaseCliente();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("INGRESAR UN NUEVO CLIENTE");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese id del gestor: ");
		int id_gestor = keyboard.nextInt();

		System.out.print("Ingrese el usuario: ");
		String username = keyboard.next();

		System.out.print("Ingrese el contraseña: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese el correo: ");
		String correo = keyboard.next();

        System.out.print("Ingrese el saldo: ");
		Double saldo = keyboard.nextDouble();

        Cliente cliente = new Cliente (0, id_gestor, username, password, correo, saldo);
        boolean clienteIngresado = database.insertarCliente(cliente);
		
        if(clienteIngresado){
            System.out.println("-------------------------------------");
            System.out.println("Cliente ingresado Correctamente");
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se ha podido ingresar el Cliente");
            System.out.println("-------------------------------------");
        }

		keyboard.close();
    }
}