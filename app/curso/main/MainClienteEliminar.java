package app.curso.main;
import java.util.Scanner;
import app.curso.util.DatabaseCliente;

public class MainClienteEliminar {
    public static void main(String[] args) {
        DatabaseCliente databaseCliente = new DatabaseCliente();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("ELIMINAR UN CLIENTE");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese id del Cliente: ");
		int id_cliente = keyboard.nextInt();

        boolean clienteBorrado = databaseCliente.eliminarCliente(id_cliente);

		if (clienteBorrado) {
            System.out.println("-------------------------------------");
            System.out.println("Cliente Eliminado");
            System.out.println("-------------------------------------");

        }else{
            System.out.println("-------------------------------------");
            System.out.println("No existe el cliente que intenta eliminar");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    }
}