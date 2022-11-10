package app.curso.main;
import java.util.Scanner;
import app.curso.entidad.Gestor;
import app.curso.util.DatabaseGestor;

public class MainGestorBuscarId {
    public static void main(String[] args) {
        DatabaseGestor database = new DatabaseGestor();
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("-------------------------------------");
        System.out.println("BUSCAR UN GESTOR POR ID");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese ID GESTOR a buscar: ");
		int idGestor = keyboard.nextInt();
        Gestor gestor = null;
        gestor = database.getGestor(idGestor);
        
        if (gestor != null) {
            System.out.println("-------------------------------------");
            System.out.println("Resultado de la busqueda por Id");
            System.out.println("-------------------------------------");
            System.out.println("Id del Gestor: "+ gestor.getId());
            System.out.println("Usuario: " + gestor.getUsuario());
            System.out.println("Contraseña: " + gestor.getPassword());
            System.out.println("Correo: " + gestor.getCorreo());
            System.out.println("-------------------------------------");
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se consiguio Gestor");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    }
}