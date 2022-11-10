package app.curso.main;
import java.util.Scanner;
import app.curso.entidad.Cliente;
import app.curso.util.DatabaseCliente;

public class MainClienteBuscarId {
    public static void main(String[] args) {
        Cliente cliente = null;
        DatabaseCliente database = new DatabaseCliente();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("BUSCAR UN CLIENTE POR ID");
        System.out.println("-------------------------------------");

		System.out.print("Ingrese ID CLIENTE a buscar: ");
		int idCliente = keyboard.nextInt();
        cliente = database.getCliente(idCliente);

        if(cliente != null){
            System.out.println("-------------------------------------");
            System.out.println("Resultado de la busqueda por Id");
            System.out.println("-------------------------------------");
            System.out.println("Id del Cliente: "+ cliente.getId());
            System.out.println("Id Gestor: " + cliente.getId_gestor());
            System.out.println("Usuario: " + cliente.getUsuario());
            System.out.println("Contraseña: " + cliente.getPassword());
            System.out.println("Correo: " + cliente.getCorreo());
            System.out.println("Saldo: " + cliente.getSaldo());
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se consiguio Cliente");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    } 
}