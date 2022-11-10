package app.curso.main;
import java.util.ArrayList;
import app.curso.entidad.Cliente;
import app.curso.util.DatabaseCliente;

public class MainClienteBuscarTodo {
    public static void main(String[] args) {
        DatabaseCliente databaseCliente = new DatabaseCliente();
        ArrayList<Cliente> clientes = null;
        clientes = databaseCliente.getClientes();

        if(clientes.size() > 0 ){
            System.out.println("-------------------------------------");
            System.out.println("TODOS LOS CLIENTES");
            System.out.println("-------------------------------------");
            clientes.forEach(cliente -> {
                System.out.println("Id del Cliente: " + cliente.getId());
                System.out.println("Id Gestor: " + cliente.getId_gestor());
                System.out.println("Usuario: " + cliente.getUsuario());
                System.out.println("Contraseña: " + cliente.getPassword());
                System.out.println("Correo: " + cliente.getCorreo());
                System.out.println("Saldo: " + cliente.getSaldo());
                System.out.println("-------------------------------------");
            });
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se consiguio ningun Cliente");
            System.out.println("-------------------------------------");
        }

    }
}