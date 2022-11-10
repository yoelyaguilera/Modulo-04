package app.curso.main;
import java.util.Scanner;
import app.curso.entidad.Gestor;
import app.curso.util.DatabaseGestor;

public class MainGestorActualizar {
    public static void main(String[] args) {
            Gestor gestor = null;
            DatabaseGestor databaseGestor = new DatabaseGestor();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("-------------------------------------");
			System.out.println("ACTUALIZAR GESTOR");
            System.out.println("-------------------------------------");

            System.out.print("Ingrese ID GESTOR a actualizar: ");
            int idGestor = keyboard.nextInt();
            gestor = databaseGestor.getGestor(idGestor);
            System.out.println("SINO QUIERE ACTUALIZAR INGRESE '0'");
    
            System.out.print("Ingrese nuevo usuario: ");
            String username = keyboard.next();
            
            System.out.print("Ingrese nueva contraseña: ");
            String password = keyboard.next();
            
            System.out.print("Ingrese nuevo correo: ");
            String correo = keyboard.next();
            
            if(!username.equals("0")) {
                gestor.setUsuario(username);
            }
            
            if(!password.equals("0")) {
                gestor.setPassword(password);
            }
            
            if(!correo.equals("0")) {
                gestor.setCorreo(correo);
            }
            
            boolean gestorActualizado = databaseGestor.actualizarGestor(gestor);
    
            if(gestorActualizado) {
                System.out.println("-------------------------------------");
                System.out.println("Se actualizo el GESTOR con los datos");
                System.out.println("-------------------------------------");
                System.out.println("Gestor id: " + gestor.getId());
                System.out.println("Usuario: " + gestor.getUsuario());
                System.out.println("Contraseña: " + gestor.getPassword());
                System.out.println("Correo: " + gestor.getCorreo());
            }else {
                System.out.println("-------------------------------------");
                System.out.println("No se ha podido actualizar el GESTOR");
                System.out.println("-------------------------------------");
            }
            
            keyboard.close();

    }
}