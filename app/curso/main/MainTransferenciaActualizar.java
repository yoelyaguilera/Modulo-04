package app.curso.main;
import java.util.Scanner;
import app.curso.entidad.Transferencia;
import app.curso.util.DatabaseTransferencia;

public class MainTransferenciaActualizar {
    public static void main(String[] args) {
        Transferencia transferencia = null;
        DatabaseTransferencia databaseTransferencia = new DatabaseTransferencia();
        Scanner keyboard = new Scanner(System.in);
        
		System.out.println("-------------------------------------");
		System.out.println("ACTUALIZAR TRANSFERENCIA");
		System.out.println("-------------------------------------");

        System.out.print("Ingrese ID TRANSFERENCIA a actualizar: ");
        int idTransferencia = keyboard.nextInt();
        transferencia = databaseTransferencia.getTransferencia(idTransferencia);
        System.out.println("SINO QUIERE ACTUALIZAR INGRESE '0'");
        
        System.out.print("Ingrese nuevo concepto: ");
        keyboard.nextLine();
        String concepto = keyboard.nextLine();
 
        if(!concepto.equals("0")) {
            transferencia.setConcepto(concepto);
        }
          
        boolean transferenciaActualizado = databaseTransferencia.actualizarTransferencia(transferencia);

        if(transferenciaActualizado) {
            System.out.println("-------------------------------------");
			System.out.println("Se actualizo la TRANSFERENCIA con el dato");
            System.out.println("-------------------------------------");
            System.out.println("Concepto: " + transferencia.getConcepto());
            System.out.println("-------------------------------------");

        }else {
            System.out.println("-------------------------------------");
            System.out.println("No se ha podido actualizar la Transferencia");
            System.out.println("-------------------------------------");

        }
        
        keyboard.close();
    }
}
