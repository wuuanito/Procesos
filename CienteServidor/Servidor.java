import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import javax.swing.SpinnerNumberModel;

public class Servidor extends Thread {

    Random random = new Random();

    int numeroMaxUsuarios = (int) VentanaServidor.spinnerClientes.getValue();
    String usuarios[] = new String[numeroMaxUsuarios];
    int usuariosConectados = 0;

    public void run() {
        super.run();
        ServerSocket socketServidor;

        try {
            socketServidor = new ServerSocket(Integer.parseInt(VentanaServidor.nPuerto.getText()));
            System.out.println("Servidor Iniciado");
            VentanaServidor.areaTexto.setText("Servidor Inicido");

            while (usuariosConectados < numeroMaxUsuarios && !this.isInterrupted()) {
                Socket cliente = socketServidor.accept();
                int idCliente = random.nextInt(1001);

                OutputStream pasodedatos = cliente.getOutputStream();
                DataOutputStream flujosalida = new DataOutputStream(pasodedatos);
                flujosalida.writeUTF(VentanaServidor.textoIncoming.getText());

                InputStream recibodatos = cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(recibodatos);
                String leido = flujoEntrada.readUTF();

                usuarios[usuariosConectados] = leido;
                usuariosConectados++;

                VentanaServidor.areaTexto.append("\n Id:" + idCliente + " Usuario:" + leido + " CONECTADO");
                cliente.close();
                flujosalida.close();
            }

            socketServidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}