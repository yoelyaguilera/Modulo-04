package app.curso.main;
import java.util.Scanner;
import app.curso.util.DatabaseGestor;

public class MainGestorEliminar {
    public static void main(String[] args) {
        DatabaseGestor databaseGestor = new DatabaseGestor();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("ELIMINAR UN GESTOR");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese id del Gestor: ");
		int id_gestor = keyboard.nextInt();

        boolean gestorBorrado = databaseGestor.eliminarGestor(id_gestor);

		if (gestorBorrado) {
            System.out.println("-------------------------------------");
            System.out.println("Gestor Eliminado");
            System.out.println("-------------------------------------");

        }else{
            System.out.println("-------------------------------------");
            System.out.println("No existe el gestor que intenta eliminar");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    }
}