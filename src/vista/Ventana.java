
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Ventana extends JFrame{
    
    //Atributos
    
    private JPanel panel;
    private JLabel titulo;
    private JButton btnRojo;
    private JButton btnVerde;
    private JButton btnAzul;
    private int pulsado = 0;
    private int contRojo=0,contVerde=0,contAzul=0;
    
    //Constructor
    
    public Ventana(){
        
        //Dimension de la ventana
        this.setSize(500, 400);
        //Titulo ventana
        this.setTitle("RGB");
        //Centrar en la mitad de la pantalla
        this.setLocationRelativeTo(null);
        //Llamar componentes
        inicializarComponentes();
        //Cerrar ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    //Inicializar componentes
    private void inicializarComponentes(){
        agregarPanel();
        agregarTitulo();
        agregarBotones();
    }
    
    
    //Agregar el panel
    private void agregarPanel(){
        panel = new JPanel();
        //Quitar el diseño del panel
        panel.setLayout(null);
        
        //agregar el panel a la ventana
        this.add(panel);
        //Evento  de rueda de boton
        eventoRuedaBoton();
    }
    
    //Agregar etiqueta titulo
    private void agregarTitulo(){
        //Instanciar la etiqueta, darle dimension y posicion
        titulo = new JLabel();
        titulo.setText("Color ("+"Rojo, "+"Verde,"+" Azul)");
        titulo.setFont(new Font("arial",1,18));
        titulo.setBounds(0, 30, this.getWidth(), 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(titulo);
    }
    
    //Agregar botones
    
    private void agregarBotones(){
        //Boton rojo
        btnRojo = new JButton("Rojo");
        btnRojo.setBounds(20, 240, 90, 40);
        btnRojo.setFont(new Font("arial", 1, 16));
        btnRojo.setForeground(Color.red);
        panel.add(btnRojo);
        
        //Boton verde
        btnVerde = new JButton("Verde");
        btnVerde.setBounds(200, 240, 90, 40);
        btnVerde.setFont(new Font("arial",1,16));
        btnVerde.setForeground(Color.GREEN);
        panel.add(btnVerde);
        
        //Boton azul
        btnAzul = new JButton("Azul");
        btnAzul.setBounds(370, 240, 90, 40);
        btnAzul.setFont(new Font("arial",1,16));
        btnAzul.setForeground(Color.BLUE);
        panel.add(btnAzul);
        
        //Llamar al evento click
        eventoClick();
        
    }
    
    
    //Evento click boton 
    private void eventoClick(){
        //Boton rojo
        ActionListener evento1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 1;
            }
        };
        btnRojo.addActionListener(evento1);
        
        //Boton verde
        
        ActionListener evento2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 2;
            }
        };
        btnVerde.addActionListener(evento2);
        
        //Boton Azul
        
        ActionListener evento3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 3;
            }
        };
        btnAzul.addActionListener(evento3);
        
    }
    
   
    
    private void eventoRuedaBoton(){
        
        MouseWheelListener evento2 = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(pulsado != 0){
                    if(pulsado == 1){//Se ha presioando el boton rojo
                        contRojo += e.getWheelRotation();
                        if(contRojo<0){
                            contRojo = 0;
                        }
                        else if(contRojo > 255){
                            contRojo = 255;
                        }
                    }
                    else if(pulsado == 2){//Se ha pulsado el boton verde
                        contVerde += e.getWheelRotation();
                        if(contVerde<0){
                            contVerde = 0;
                        }
                        else if(contVerde > 255){
                            contVerde = 255;
                        }
                    }
                    else{//se ha pulsado el boton azul
                        contAzul += e.getWheelRotation();
                        
                        if(contAzul<0){
                            contAzul = 0;
                        }
                        else if(contAzul > 255){
                            contAzul = 255;
                        }
                    }
                    panel.setBackground(new Color(contRojo, contVerde, contAzul));
                    titulo.setText("Color ("+"Rojo = "+contRojo+", "+"Verde = "+contVerde+", Azul = "+contAzul+")");

                }
                       
            }
        };
        
        panel.addMouseWheelListener(evento2);
        
    }
    
    
}
