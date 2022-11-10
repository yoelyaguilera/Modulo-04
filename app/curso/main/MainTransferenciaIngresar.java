package app.curso.main;
import java.sql.Timestamp;
import java.util.Scanner;
import app.curso.entidad.Transferencia;
import app.curso.util.DatabaseTransferencia;

public class MainTransferenciaIngresar {
    public static void main(String[] args) {
        DatabaseTransferencia database = new DatabaseTransferencia();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("INGRESAR UNA NUEVA TRNASFERENCIA");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese id del ordenante: ");
		int id_ordenante = keyboard.nextInt();

		System.out.print("Ingrese id del beneficiario: ");
		int id_beneficiario = keyboard.nextInt();

		System.out.print("Ingrese el importe: ");
		Double importe = keyboard.nextDouble();
		
		System.out.print("Ingrese el concepto: ");
        keyboard.nextLine();
		String concepto = keyboard.nextLine();

        Timestamp fecha = new Timestamp(System.currentTimeMillis());

        Transferencia transferencia = new Transferencia (0, id_ordenante, id_beneficiario, importe, concepto, fecha);
        boolean transferenciaIngresado = database.insertarTransferencia(transferencia);
        if(transferenciaIngresado){
            System.out.println("-------------------------------------");
            System.out.println("Transferencia ingresada Correctamente");
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se ha podido ingresar el transferencia");
            System.out.println("-------------------------------------");
        }
		keyboard.close();

    }
}

