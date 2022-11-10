package app.curso.main;
import java.util.Scanner;
import app.curso.entidad.Mensaje;
import app.curso.util.DatabaseMensaje;

public class MainMensajeActualizar {
    
    public static void main(String[] args) {
            Mensaje mensaje = null;
            DatabaseMensaje databaseMensaje = new DatabaseMensaje();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("-------------------------------------");
            System.out.println("ACTUALIZAR MENSAJE");
            System.out.println("-------------------------------------");
    
            System.out.print("Ingrese ID MENSAJE a actualizar: ");
            int idMensaje = keyboard.nextInt();
            mensaje = databaseMensaje.getMensaje(idMensaje);
            System.out.println("SINO QUIERE ACTUALIZAR INGRESE '0'");
    
            System.out.print("Ingrese nuevo Mensaje: ");
            keyboard.nextLine();
            String texto = keyboard.nextLine();
            
            if(!texto.equals("0")) {
                mensaje.setTexto(texto);
            }
            
            boolean mensajeActualizado = databaseMensaje.actualizarMensaje(mensaje);
    
            if(mensajeActualizado) {
                System.out.println("-------------------------------------");
                System.out.println("Se actualizo el MENSAJE con el texto");
                System.out.println("-------------------------------------");
                System.out.println("Mensaje: " + mensaje.getTexto());
                System.out.println("-------------------------------------");
            }else {
                System.out.println("-------------------------------------");
                System.out.println("No se ha podido actualizar el MENSAJE");
                System.out.println("-------------------------------------");
            }
            
            keyboard.close();
    }
}
