package app.curso.main;
import java.util.ArrayList;
import app.curso.entidad.Transferencia;
import app.curso.util.DatabaseTransferencia;

public class MainTransferenciaBuscarTodo {
    public static void main(String[] args) {
        DatabaseTransferencia databaseTransferencia = new DatabaseTransferencia();
        ArrayList<Transferencia> transferencias = null;
        transferencias = databaseTransferencia.getTransferencias();

        if(transferencias.size() > 0 ){
            System.out.println("-------------------------------------");
            System.out.println("TODOS LOS TRANSFERENCIA");
            System.out.println("-------------------------------------");
            transferencias.forEach(transferencia -> {
                System.out.println("Id del Transferencia: " + transferencia.getId());
                System.out.println("Id Ordenante: " + transferencia.getId_ordenante());
                System.out.println("Id Beneficiario: " + transferencia.getId_beneficiario());
                System.out.println("Importe: " + transferencia.getImporte());
                System.out.println("Concepto: " + transferencia.getConcepto());
                System.out.println("Fecha: " + transferencia.getFecha());
                System.out.println("-------------------------------------");
            });
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se consiguio ninguna Transferencia");
            System.out.println("-------------------------------------");
        }
    }
}
