package app.curso.main;
import java.util.Scanner;

import app.curso.entidad.Mensaje;
import app.curso.util.DatabaseMensaje;

public class MainMensajeBuscarId {
    public static void main(String[] args) {
        DatabaseMensaje database = new DatabaseMensaje();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("BUSCAR UN MENSAJE POR ID");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese ID CLIENTE a buscar: ");
		int idTransferencia = keyboard.nextInt();
        Mensaje mensaje = database.getMensaje(idTransferencia);
        
        if(mensaje != null){
            System.out.println("-------------------------------------");
            System.out.println("Resultado de la busqueda por Id");
            System.out.println("-------------------------------------");
            System.out.println("Id del Mensaje: "+ mensaje.getId());
            System.out.println("Id Origen: " + mensaje.getId_origen());
            System.out.println("Id Destino: " + mensaje.getId_destino());
            System.out.println("Texto: " + mensaje.getTexto());
            System.out.println("Fecha: " + mensaje.getFecha());
            System.out.println("-------------------------------------");
        
        }else{
            System.out.println("-------------------------------------");
            System.out.println("No se consiguio Mensaje");
            System.out.println("-------------------------------------");
        }
        keyboard.close();
    }
}