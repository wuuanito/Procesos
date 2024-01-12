import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

        public void run(){
            super.run();

ServerSocket socketServidor;
       try {
            socketServidor = new ServerSocket(Integer.parseInt(VentanaServidor.nPuerto.getText()));
            System.out.println("Servidor Iniciado");
            VentanaServidor.areaTexto.setText("Servidor Iniciando..");

            Socket cliente = null;
            cliente = socketServidor.accept();
            OutputStream pasodedatos=null;
    
            pasodedatos = cliente.getOutputStream();
            DataOutputStream flujosalida = new DataOutputStream(pasodedatos);
            flujosalida.writeUTF("Bienvenido al servidor");

            InputStream recibodatos = null;
            recibodatos = cliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(recibodatos);
            String leido = null;
            leido = flujoEntrada.readUTF();
            VentanaServidor.areaTexto.append("\t Cliente: "+leido+" CONECTADO");

cliente.close();
socketServidor.close();
flujosalida.close();


        } catch (IOException e) {
            throw new RuntimeException(e);


        }



    }
    
}
