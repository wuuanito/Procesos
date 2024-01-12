import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    public void run(){
        super.run();

ServerSocket socketServidor;
       try {
            socketServidor = new ServerSocket(8080);
            System.out.println("Servidor Iniciado");
            VentanaServidor.areaTexto.setText("Servidor Iniciando..");




        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    
}
