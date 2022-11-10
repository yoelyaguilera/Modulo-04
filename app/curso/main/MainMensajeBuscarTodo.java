package app.curso.main;
import java.util.ArrayList;
import app.curso.entidad.Mensaje;
import app.curso.util.DatabaseMensaje;

public class MainMensajeBuscarTodo {
    public static void main(String[] args) {
        DatabaseMensaje databaseMensaje = new DatabaseMensaje();
        ArrayList<Mensaje> mensajes = null;
        mensajes = databaseMensaje.getMensajes();

        if(mensajes.size() > 0 ){
            System.out.println("-------------------------------------");
            System.out.println("TODOS LOS MENSAJE");
            System.out.println("-------------------------------------");
            mensajes.forEach(mensaje -> {
                System.out.println("Id del Mensaje: " + mensaje.getId());
                System.out.println("Id Origen: " + mensaje.getId_origen());
                System.out.println("Id Destino: " + mensaje.getId_destino());
                System.out.println("Texto: " + mensaje.getTexto());
                System.out.println("Fecha: " + mensaje.getFecha());
                System.out.println("-------------------------------------");
            });
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se consiguio ningun Mensaje");
            System.out.println("-------------------------------------");
        }

    }
}