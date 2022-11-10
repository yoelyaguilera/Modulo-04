package app.curso.main;
import java.util.Scanner;
import app.curso.util.DatabaseTransferencia;

public class MainTransferenciaEliminar {
    
    public static void main(String[] args) {
        DatabaseTransferencia databaseTransferencia = new DatabaseTransferencia();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("ELIMINAR UN TRANSFERENCIA");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese id del Transferencia: ");
		int id_transferencia = keyboard.nextInt();

        boolean transferenciaBorrado = databaseTransferencia.eliminarTransferencia(id_transferencia);

		if (transferenciaBorrado) {
            System.out.println("-------------------------------------");
            System.out.println("Transferencia Eliminada");
            System.out.println("-------------------------------------");

        }else{
            System.out.println("-------------------------------------");
            System.out.println("No existe la transferencia que intenta eliminar");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    }
}
