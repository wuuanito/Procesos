import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.xml.transform.OutputKeys;

public class InicioCliente {

    private static Socket cliente;

    public static void main(String[] args) {
        VentanaCliente ventanaCliente = new VentanaCliente();
        ventanaCliente.setVisible(true);

        String host = "localhost";

        try {
            ActionListener conectarCliente = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        cliente = new Socket(host, Integer.parseInt(ventanaCliente.numeroPuerto.getText()));
                        InputStream entrada = cliente.getInputStream();
                        DataInputStream flujoEntrada = new DataInputStream(entrada);
                        String recibido = flujoEntrada.readUTF();
                        ventanaCliente.areaCliente.append(recibido);


                        OutputStream enviarDatos=null;
                        enviarDatos = cliente.getOutputStream();
                        DataOutputStream datosAlServidor = new DataOutputStream(enviarDatos);
                        datosAlServidor.writeUTF(ventanaCliente.nombre.getText());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            };
            ventanaCliente.conectar.addActionListener(conectarCliente);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}