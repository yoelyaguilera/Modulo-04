package app.curso.main;
import java.util.Scanner;
import app.curso.util.DatabaseMensaje;

public class MainMensajeEliminar {
    
    public static void main(String[] args) {
        DatabaseMensaje databaseMensaje = new DatabaseMensaje();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("ELIMINAR UN MENSAJE");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese id del Mensaje: ");
		int id_mensaje = keyboard.nextInt();

        boolean mensajeBorrado = databaseMensaje.eliminarMensaje(id_mensaje);

		if (mensajeBorrado) {
            System.out.println("-------------------------------------");
            System.out.println("Mensaje Eliminado");
            System.out.println("-------------------------------------");

        }else{
            System.out.println("-------------------------------------");
            System.out.println("No existe el mensaje que intenta eliminar");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    }
}
