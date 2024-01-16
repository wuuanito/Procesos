import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class VentanaServidor extends JFrame {

    public JPanel ventanaPrincipal;
    public static  JTextArea areaTexto;
    public JButton activarServer;
    public static  JTextField textoIncoming;

    public static  JTextField nPuerto;
    public static  JSpinner spinnerClientes;

    public VentanaServidor() {
        inciarComponentes();
        setSize(400, 700);
        setResizable(false);
        setTitle("Servidor");
        setLocationRelativeTo(null);


    }

    public void inciarComponentes() {
        panes();
        botones();
        etiquetas();
    }

    public void panes() {
        ventanaPrincipal = new JPanel();
        ventanaPrincipal.setSize(400, 700);
        ventanaPrincipal.setLayout(null);
        this.getContentPane().add(ventanaPrincipal);


    }

    public void botones() {
        activarServer = new JButton("Activate Server");
        activarServer.setBounds(120,220,150,30);
        ventanaPrincipal.add(activarServer);
     

        ActionListener encenderServidor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Servidor servidor1 = new Servidor();
                servidor1.start();

            }
        };activarServer.addActionListener(encenderServidor);




    }

    public void etiquetas() {
        JLabel titulo = new JLabel("PSP SERVER");
        titulo.setBounds(150,50,100,30);
        JLabel primnerCampo = new JLabel("CONFIG");
        primnerCampo.setBounds(150,70,100,30);
        JLabel mensajeRecibido = new JLabel("Income Message:");
        mensajeRecibido.setBounds(10,100,130,30);
        JLabel clientes = new JLabel("Max. Nº of Clients:");
        clientes.setBounds(10,140,150,30);
        SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
        spinnerClientes = new JSpinner(model);
        spinnerClientes.setBounds(170,140,30,30);

         textoIncoming = new JTextField();
        textoIncoming.setBounds(150,100,130,30);

        JLabel puertp = new JLabel("Port Nº");
        puertp.setBounds(250,140,80,30);
        nPuerto = new JTextField();
        nPuerto.setBounds(300,140,80,30);

        JLabel status = new JLabel("STATUS");
        status.setBounds(150,260,80,30);

        areaTexto = new JTextArea();
        areaTexto.setBounds(30,300,350,350);
        ventanaPrincipal.add(areaTexto);
        ventanaPrincipal.add(status);
        ventanaPrincipal.add(nPuerto);
        ventanaPrincipal.add(puertp);
        ventanaPrincipal.add(textoIncoming);
        ventanaPrincipal.add(spinnerClientes);
        ventanaPrincipal.add(clientes);

        ventanaPrincipal.add(mensajeRecibido);
        ventanaPrincipal.add(titulo);
        ventanaPrincipal.add(primnerCampo);

    }


}