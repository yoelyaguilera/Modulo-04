package app.curso.main;
import java.sql.Timestamp;
import java.util.Scanner;
import app.curso.entidad.Mensaje;
import app.curso.util.DatabaseMensaje;

public class MainMensajeIngresar {
    public static void main(String[] args) {
        DatabaseMensaje database = new DatabaseMensaje();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("INGRESAR UN NUEVO MENSAJE");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese Td origen: ");
        int id_origen = keyboard.nextInt();

        System.out.print("Ingrese Id destino: ");
        int id_destino = keyboard.nextInt();
        
        
        System.out.print("Ingrese Texto: ");
        keyboard.nextLine();
        String texto = keyboard.nextLine();
        
		Timestamp fecha = new Timestamp(System.currentTimeMillis());

        Mensaje mensaje = new Mensaje (0, id_origen, id_destino, texto, fecha);
        boolean mensajeIngresado = database.insertarMensaje(mensaje);

        if(mensajeIngresado){
            System.out.println("-------------------------------------");
            System.out.println("Mensaje ingresado Correctamente");
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se ha podido ingresar el Mensaje");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    }
}
