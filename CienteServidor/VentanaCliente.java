import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCliente extends JFrame {


    public static JPanel ventanaCliente;
    public JButton conectar;
    public static JTextField nombre;
    public static JTextField numeroPuerto;
    public static JTextArea areaCliente;

    public JButton obtenerFecha,desconectar;

    public VentanaCliente(){
        setSize(500,300);
        setResizable(false);
        setTitle("Cliente");
        setLocationRelativeTo(null);
        inciarComponentes();
    }
public void inciarComponentes() {
        panes();
        botones();
        etiquetas();
    }

    public void panes() {

        ventanaCliente = new JPanel();
        ventanaCliente.setLayout(null);
        this.getContentPane().add(ventanaCliente);
       

    }

    public void botones() {
       
    conectar = new JButton("CONNECT");
    conectar.setBounds(300,90,130,30);
    ventanaCliente.add(conectar);

    obtenerFecha = new JButton("Obtner Fecha");
    obtenerFecha.setBounds(380,120,100,30);
    desconectar = new JButton("Salir");
    desconectar.setBounds(380,170,100,30);
    ventanaCliente.add(desconectar);



    }

    public void etiquetas() {

        JLabel titulo = new JLabel("PSP CLIENT");
        titulo.setBounds(200, 20, 150, 30);
        ventanaCliente.add(titulo);

        JLabel nombreCliente = new JLabel("Client Name");
        nombreCliente.setBounds(30, 60 , 100, 30);
        ventanaCliente.add(nombreCliente);
       nombre = new JTextField();
       nombre.setBounds(200,60,250,30);
       ventanaCliente.add(nombre);
       JLabel puertJLabel = new JLabel("Port");
       puertJLabel.setBounds(30,90, 60, 30);
       ventanaCliente.add(puertJLabel);

       numeroPuerto = new JTextField();
       numeroPuerto.setBounds(200, 90, 70, 30);
       ventanaCliente.add(numeroPuerto);

       areaCliente = new JTextArea();
       areaCliente.setBounds(30, 140, 350, 100);
       ventanaCliente.add(areaCliente);
    }






    
}


