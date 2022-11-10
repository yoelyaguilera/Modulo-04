package app.curso.main;
import java.util.Scanner;
import app.curso.entidad.Transferencia;
import app.curso.util.DatabaseTransferencia;

public class MainTransferenciaBuscarId {
    public static void main(String[] args) {
        Transferencia transferencia = null;
        DatabaseTransferencia database = new DatabaseTransferencia();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("BUSCAR UNA TRANSFERENCIA POR ID");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese ID TRNASFERENCIA a buscar: ");
		int idTransferencia = keyboard.nextInt();
        transferencia = database.getTransferencia(idTransferencia);
        
        if(transferencia != null){
            System.out.println("-------------------------------------");
            System.out.println("Resultado de la busqueda por Id");
            System.out.println("-------------------------------------");
            System.out.println("Id del Transferencia: "+ transferencia.getId());
            System.out.println("Id Ordenante: " + transferencia.getId_ordenante());
            System.out.println("Id Beneficiario: " + transferencia.getId_beneficiario());
            System.out.println("Importe: " + transferencia.getImporte());
            System.out.println("Concepto: " + transferencia.getConcepto());
            System.out.println("Fecha: " + transferencia.getFecha());
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se consiguio la transferencia");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    }
}