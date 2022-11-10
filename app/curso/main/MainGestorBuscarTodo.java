package app.curso.main;
import java.util.ArrayList;
import app.curso.entidad.Gestor;
import app.curso.util.DatabaseGestor;

public class MainGestorBuscarTodo {
    public static void main(String[] args) {
        DatabaseGestor databaseGestor = new DatabaseGestor();
        ArrayList<Gestor> gestors = null;
        gestors = databaseGestor.getGestores();

        if(gestors.size() > 0 ){
            System.out.println("-------------------------------------");
            System.out.println("TODOS LOS GESTORES");
            System.out.println("-------------------------------------");
            gestors.forEach(gestor -> {
                System.out.println("Id del Gestor: " + gestor.getId());
                System.out.println("Usuario: " + gestor.getUsuario());
                System.out.println("Contraseña: " + gestor.getPassword());
                System.out.println("Correo: " + gestor.getCorreo());
                System.out.println("-------------------------------------");
            });
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se consiguio ningun Gestor");
            System.out.println("-------------------------------------");
        }
    }
}