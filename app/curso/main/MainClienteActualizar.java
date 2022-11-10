package app.curso.main;
import java.util.Scanner;
import app.curso.entidad.Cliente;
import app.curso.util.DatabaseCliente;

public class MainClienteActualizar {
    public static void main(String[] args) {
        Cliente cliente = null;
		DatabaseCliente databaseCliente = new DatabaseCliente();
        Scanner keyboard = new Scanner(System.in);
		System.out.println("-------------------------------------");
		System.out.println("ACTUALIZAR CLIENTE");
		System.out.println("-------------------------------------");

		System.out.print("Ingrese ID CLIENTE a actualizar: ");
		int idCliente = keyboard.nextInt();
		cliente = databaseCliente.getCliente(idCliente);
		System.out.println("SINO QUIERE ACTUALIZAR INGRESE '0'");

		System.out.print("Ingrese nuevo id gestor: ");
		int id_gestor = keyboard.nextInt();

		System.out.print("Ingrese nuevo usuario: ");
		String username = keyboard.next();
		
		System.out.print("Ingrese nueva contraseña: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese nuevo correo: ");
		String correo = keyboard.next();

        System.out.print("Ingrese nuevo saldo: ");
		Double saldo = keyboard.nextDouble();
		
		if(id_gestor != 0) {
			cliente.setId_gestor(id_gestor);
		}

		if(!username.equals("0")) {
			cliente.setUsuario(username);
		}
		
		if(!password.equals("0")) {
			cliente.setPassword(password);
		}
		
		if(!correo.equals("0")) {
			cliente.setCorreo(correo);
		}

        if(saldo != 0d) {
			cliente.setSaldo(saldo);
		}
		
		boolean clienteActualizado = databaseCliente.actualizarCliente(cliente);

		if(clienteActualizado) {
			System.out.println("-------------------------------------");
			System.out.println("Se actualizo el CLIENTE con los datos");
            System.out.println("-------------------------------------");
			System.out.println("Cliente id: " + cliente.getId());
			System.out.println("Id Gestor: " + cliente.getId_gestor());
			System.out.println("Usuario: " + cliente.getUsuario());
			System.out.println("Contraseña: " + cliente.getPassword());
			System.out.println("Correo: " + cliente.getCorreo());
			System.out.println("Saldo: " + cliente.getSaldo());
            System.out.println("-------------------------------------");

		}else {
            System.out.println("-------------------------------------");
			System.out.println("No se ha podido actualizar el CLIENTE");
            System.out.println("-------------------------------------");
		}
		
		keyboard.close();
    }
}