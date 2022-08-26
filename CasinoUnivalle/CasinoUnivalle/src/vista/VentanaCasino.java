/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import logica.*;
import modelo.Jugador;


/**
 *
 * @author mauricio.munoz
 */
public class VentanaCasino extends JFrame{
    private JLabel lblRonda;
    private JLabel lblJ1Nombre;
    private JLabel lblJ2Nombre;
    private JLabel lblEmpates;
    private JLabel lblGanando; 
    private JLabel lblRestantes;
    private JLabel lblGanador;
    private JLabel lblDado1;
    private JLabel lblDado2;
    private ImageIcon imgDado1;
    private ImageIcon imgDado2;
    private ImageIcon imgDado3;
    private ImageIcon imgDado4;
    private ImageIcon imgDado5;
    private ImageIcon imgDado6;
    private JButton btnLanzar;
    private JLabel lblPuntosJ1;
    private JLabel lblPuntosJ2;
    private JLabel lblLanzamientosJ2;
    private JLabel lblLanzamientosJ1;
    private JLabel lblGano;
    private Casino miCasino;
    private Jugador jugador1;
    private Jugador jugador2;
    private int modoJuego;
    private int lanzamientosRonda;
    private int numRondas;
    private int mejorRondaNum;
    private int mejorPuntaje;
    private String nombreMejorPuntaje;
    
    
    private Container ContenedorInfo;
   

    
    VentanaCasino(String nombre1, int modo, int lanzamientos){
        iniciarVentana();
        iniciarComponentes(nombre1,"IA",lanzamientos);
        
        jugador1 = new Jugador(nombre1);
        jugador2 = new Jugador("IA");
        miCasino =  new Casino(jugador1,jugador2, modo);
        miCasino.IniciarLanzamientos(lanzamientos);
        lanzamientosRonda = lanzamientos;
        modoJuego = modo;
        numRondas = 1;
    }
    
    VentanaCasino(String nombre1, String nombre2, int modo, int lanzamientos){
        iniciarVentana();
        iniciarComponentes(nombre1, nombre2, lanzamientos);
        jugador1 = new Jugador(nombre1);
        jugador2 = new Jugador(nombre2);
        miCasino =  new Casino(jugador1, jugador2, modo);
        miCasino.IniciarLanzamientos(lanzamientos);
        lanzamientosRonda = lanzamientos;
        modoJuego = modo;
        numRondas = 1;
    }
    
    public void iniciarVentana(){
        setSize(730,510);
        setVisible(true);
        setLocationRelativeTo(null);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Casino Univalle");
        setResizable(false);
    }    
    
    public void iniciarComponentes(String j1,String j2,int lanzamientos){
        lblRonda = new JLabel("Ronda: "+ numRondas);
        lblRonda.setHorizontalAlignment(JLabel.CENTER);
        lblRonda.setBounds(10, 10, 80, 20);
        
        lblJ1Nombre = new JLabel("J1: "+j1);
        lblJ1Nombre.setHorizontalAlignment(JLabel.CENTER);
        lblJ1Nombre.setBounds(80, 10, 80, 20);
        
        lblJ2Nombre = new JLabel("J2: "+j2);
        lblJ2Nombre.setHorizontalAlignment(JLabel.CENTER);
        lblJ2Nombre.setBounds(230, 10, 80, 20);
        
        lblEmpates = new JLabel("Empates:");
        lblEmpates.setHorizontalAlignment(JLabel.CENTER);
        lblEmpates.setBounds(380, 10, 80, 20);        
        
        lblGanando = new JLabel("Ganando:");
        lblGanando.setHorizontalAlignment(JLabel.CENTER);
        lblGanando.setBounds(480, 10, 80, 20);        
        
        lblRestantes = new JLabel("Restantes: "+lanzamientos);
        lblRestantes.setHorizontalAlignment(JLabel.CENTER);
        lblRestantes.setBounds(580, 10, 80, 20);   
        
        lblGanador = new JLabel("El Ganador Del Lanzamiento es");
        lblGanador.setHorizontalAlignment(JLabel.CENTER);
        lblGanador.setBounds(250, 80, 200, 20); 
        
        lblGano = new JLabel("XXX");
        lblGano.setHorizontalAlignment(JLabel.CENTER);
        lblGano.setBounds(250, 80, 200, 50);
        
        lblPuntosJ1 = new JLabel("J1 puntos: ");
        lblPuntosJ1.setHorizontalAlignment(JLabel.CENTER);
        lblPuntosJ1.setBounds(200, 300, 80, 20); 
        
        lblLanzamientosJ1 = new JLabel("Lanzamientos: ");
        lblLanzamientosJ1.setHorizontalAlignment(JLabel.CENTER);
        lblLanzamientosJ1.setBounds(165, 350, 150, 20); 
        
        
        lblPuntosJ2 = new JLabel("J2 puntos: ");
        lblPuntosJ2.setHorizontalAlignment(JLabel.CENTER);
        lblPuntosJ2.setBounds(450, 300, 80, 20); 
        
        lblLanzamientosJ2 = new JLabel("Lanzamientos: ");
        lblLanzamientosJ2.setHorizontalAlignment(JLabel.CENTER);
        lblLanzamientosJ2.setBounds(415, 350, 150, 20); 
        
        btnLanzar = new JButton("Lanzar");
        btnLanzar.setBounds(320, 400, 80, 40);
        
        imgDado1 = new ImageIcon(getClass().getResource("/imagenes/dado1.jpg"));
        imgDado2 = new ImageIcon(getClass().getResource("/imagenes/dado2.jpg"));
        imgDado3 = new ImageIcon(getClass().getResource("/imagenes/dado3.jpg"));
        imgDado4 = new ImageIcon(getClass().getResource("/imagenes/dado4.jpg"));
        imgDado5 = new ImageIcon(getClass().getResource("/imagenes/dado5.jpg"));
        imgDado6 = new ImageIcon(getClass().getResource("/imagenes/dado6.jpg"));
        
        lblDado1 = new JLabel(imgDado1);
        lblDado1.setBounds(185, 170, 105, 105);
        
        lblDado2 = new JLabel(imgDado1);
        lblDado2.setBounds(435, 170, 105, 105);
        
        ContenedorInfo = getContentPane();
        ContenedorInfo.setLayout(null);
        ContenedorInfo.setBackground(Color.white);
        
        
        //ContenedorInfo.setBackground(Color.red);
        
        ContenedorInfo.add(lblRonda);
        ContenedorInfo.add(lblJ1Nombre);
        ContenedorInfo.add(lblJ2Nombre);
        ContenedorInfo.add(lblEmpates);
        ContenedorInfo.add(lblGanando);
        ContenedorInfo.add(lblRestantes);
        ContenedorInfo.add(lblGanador);
        ContenedorInfo.add(lblPuntosJ1);
        ContenedorInfo.add(lblPuntosJ2);
        ContenedorInfo.add(lblLanzamientosJ1);
        ContenedorInfo.add(lblLanzamientosJ2);
        ContenedorInfo.add(lblGano);
        
        ContenedorInfo.add(btnLanzar);
        
        ContenedorInfo.add(lblDado1);
        ContenedorInfo.add(lblDado2);
        
        btnLanzar.addActionListener(new ManejadorCasino());
        
    }
    
    public void finDeRonda(){
        mejorRonda();
        
        JPanel panel = new JPanel(); 
        
        JLabel lblGanador = new JLabel("");
        lblGanador.setBounds(20,10,200,20);
        JLabel lblPuntosGanador = new JLabel("Puntaje ganador: #");
        lblPuntosGanador.setBounds(20,40,200,20);
        
        switch(miCasino.quienVaGanando())
                {
                    case 1:
                        lblGanador.setText(jugador1.getNombre() + " ha ganado");
                        lblPuntosGanador.setText("Puntos obtenidos " 
                                +  miCasino.puntos(jugador1));
                        break;
                    
                    case 2:
                        lblGanador.setText(jugador2.getNombre() + " ha ganado");
                        lblPuntosGanador.setText("Puntos obtenidos " 
                                + miCasino.puntos(jugador2)+"");
                        break;   
                    case 0:
                        lblGanador.setText("Nadie ha ganado (empate)");
                        lblPuntosGanador.setText("Puntos obtenidos " 
                                + miCasino.puntos(jugador1)+"");
                        break;
                }
        
        JLabel lblLanzamientos = new JLabel("Lanzamientos: " + 
                lanzamientosRonda);
        lblLanzamientos.setBounds(20,70,200,20);
        JLabel lblEmpates = new JLabel("Empates: " + miCasino.getEmpates());
        lblEmpates.setBounds(20,100,200,20);
        
        panel.setLayout(null);
        panel.add(lblGanador);
        panel.add(lblLanzamientos);
        panel.add(lblEmpates);
        panel.add(lblPuntosGanador);
        
        UIManager.put("OptionPane.minimumSize",new Dimension(350,190)); 
        
        Object[] options = {"Jugar otra vez",
                    "Terminar",
                    };
        int n = JOptionPane.showOptionDialog(this,
        panel,
        "Fin de la Ronda - Resumen",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null,
        options,
        options[1]);
        
        if(n == 0){
            int respuesta;
            
            respuesta = JOptionPane.showConfirmDialog(this, 
                    "Desea conservar los mismos jugadores?",
                    "Nuevo Juego",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(respuesta == JOptionPane.YES_OPTION){
                jugador1 = new Jugador(jugador1.getNombre());
                jugador2 = new Jugador(jugador2.getNombre());
                miCasino =  new Casino(jugador1,jugador2, modoJuego);
                miCasino.IniciarLanzamientos(lanzamientosRonda);
                numRondas += 1;
                actualizarVentana();
            }
            else if(respuesta == JOptionPane.NO_OPTION){
                JPanel panel2 = new JPanel();
                
                JLabel lblNombre1 = new JLabel("Nombre 1");
                lblNombre1.setBounds(20, 10, 200, 20);
                
                JTextField txtNombre1 = new JTextField("");
                txtNombre1.setBounds(20, 30, 200, 20);
                
                JLabel lblNombre2 = new JLabel("Nombre 2");
                lblNombre2.setBounds(20, 80, 200, 20);
                
                JTextField txtNombre2 = new JTextField("");
                txtNombre2.setBounds(20, 100, 200, 20);
                
                panel2.setLayout(null);
                panel2.add(lblNombre1);
                panel2.add(txtNombre1);
                panel2.add(lblNombre2);
                panel2.add(txtNombre2);
                
                Object[] options2 = {"Un Jugador",
                        "Dos Jugadores",
                    };
                int m = JOptionPane.showOptionDialog(this,
                panel2,
                "CasinoUnivalle - Nueva Ronda",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options2,
                options[1]);
                
                if(m == 0){
                    if((txtNombre1.getText()).equals("")){
                       JOptionPane.showMessageDialog(null, 
                            "La casilla de nombre 1 está vacia", "Error", 1); 
                    }else{
                        jugador1 = new Jugador(txtNombre1.getText());
                        jugador2 = new Jugador("IA");
                        miCasino =  new Casino(jugador1,jugador2, m);
                        miCasino.IniciarLanzamientos(lanzamientosRonda);
                        numRondas += 1;
                        actualizarVentana();
                    }
                }else if(m == 1){
                    if((txtNombre1.getText()).equals("") || 
                            (txtNombre1.getText()).equals("")){
                        JOptionPane.showMessageDialog(null, 
                            "Introduce un nombre en las dos casillas",
                            "Error", 1);
                    }
                    else{
                        jugador1 = new Jugador(txtNombre1.getText());
                        jugador2 = new Jugador(txtNombre2.getText());
                        miCasino =  new Casino(jugador1,jugador2, m);
                        miCasino.IniciarLanzamientos(lanzamientosRonda);
                        numRondas += 1;
                        actualizarVentana();
                    }
                }
            }
        }else if(n == 1){
            dispose();
            
            
            JPanel panel3 = new JPanel();
            
            JLabel lblMejorPuntaje = new JLabel("Mejor Puntaje: " 
                    + mejorPuntaje);
            lblMejorPuntaje.setBounds(20,10,200,20);
            
            JLabel lblMejorRonda = new JLabel("Fue obtenido en la ronda " 
                    + mejorRondaNum);
            lblMejorRonda.setBounds(20,40,200,20);
            
            JLabel lblNombreMejorPuntaje = new JLabel("Fue obtenido por " 
                    + nombreMejorPuntaje);
            lblNombreMejorPuntaje.setBounds(20,70,200,20);
            
            JLabel lblFin = new JLabel("Gracias por jugar, hasta la proxima!");
            lblFin.setBounds(20,100,250,20);
            
            panel3.setLayout(null);
            panel3.add(lblMejorPuntaje);
            panel3.add(lblMejorRonda);
            panel3.add(lblNombreMejorPuntaje);
            panel3.add(lblFin);
            
            JOptionPane.showMessageDialog(null, panel3, "Fin del Juego",
                    JOptionPane.PLAIN_MESSAGE);
            
        }
    }
    
    private void actualizarVentana(){
        lblJ1Nombre.setText("J1: " + jugador1.getNombre());
        lblJ2Nombre.setText("J2: " + jugador2.getNombre());
        
        lblRonda.setText("Ronda: " + numRondas);
        
        lblPuntosJ1.setText("J1 puntos: "+miCasino.puntos(jugador1));
                
        lblLanzamientosJ1.setText("Lanzamientos: "
                + miCasino.lanzamientos(jugador1));
                
        lblPuntosJ2.setText("J2 puntos: "+ miCasino.puntos(jugador2));
                
        lblLanzamientosJ2.setText("Lanzamientos: " 
                + miCasino.lanzamientos(jugador2));
                
        lblRestantes.setText("Restantes: "
                + miCasino.getIntentosRestantes()); 
                
        lblEmpates.setText("Empates: " 
                + miCasino.getEmpates());
                
        switch(miCasino.quienVaGanando())
            {
                case 0:
                    lblGanando.setText("Ganando:N/A");
                    break;
                    
                case 1:
                    lblGanando.setText("Ganando: J1");
                    break;
                    
                case 2:
                    lblGanando.setText("Ganando: J2");
                    break;
                   
            }
        switch(miCasino.getGanadorLanzamiento())
            {
                case 0:
                    lblGano.setText("Nadie (ha habido empate)");
                    break;
                case 1:
                    lblGano.setText(""+jugador1.getNombre());
                    break;
                case 2:
                    lblGano.setText("" + jugador2.getNombre());
                    break;
                case 3:
                    lblGano.setText("XXX");
                    break;
            }
    }
    
    private void mejorRonda(){
        if(numRondas == 1){
            mejorRondaNum = 1;
            switch(miCasino.quienVaGanando()){
                case 1:
                    mejorPuntaje = jugador1.getPuntos();
                    nombreMejorPuntaje = jugador1.getNombre();
                    break;
                case 2:
                    mejorPuntaje = jugador2.getPuntos();
                    nombreMejorPuntaje = jugador2.getNombre();
                    break;
                case 3:
                    mejorPuntaje = jugador1.getPuntos();
                    nombreMejorPuntaje = jugador1.getNombre() 
                            + " y " 
                            + jugador2.getNombre();
                    break;
            }
        }
        else
        {
            if(mejorPuntaje < jugador1.getPuntos() ||
                    mejorPuntaje < jugador2.getPuntos()){
                mejorRondaNum = numRondas;
                switch(miCasino.quienVaGanando()){
                    case 1:
                        mejorPuntaje = jugador1.getPuntos();
                        nombreMejorPuntaje = jugador1.getNombre();
                        break;
                    case 2:
                        mejorPuntaje = jugador2.getPuntos();
                        nombreMejorPuntaje = jugador2.getNombre();
                        break;
                    case 3:
                        mejorPuntaje = jugador1.getPuntos();
                        nombreMejorPuntaje = jugador1.getNombre() 
                            + " y " 
                            + jugador2.getNombre();
                        break;
                }
            }
        }
    }
    
    class ManejadorCasino implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (modoJuego==0) {
                if (miCasino.getIntentosRestantes()!=0) {
                
                miCasino.agregarLanzamiento(jugador1);
                actualizarVentana();
            } 
            
            } else {
                
                if (miCasino.getIntentosRestantes()!=0) {
                    
                        if (miCasino.getTurno()==1) {
                            miCasino.agregarLanzamiento(jugador1);
                            miCasino.setTurno(0);
                        } else {
                            miCasino.agregarLanzamiento(jugador2);
                            miCasino.setTurno(1);
                        }   
                        actualizarVentana();
                    }
                }
            
            switch(miCasino.getDado1()){
                case 1: lblDado1.setIcon(imgDado1); break;
                case 2: lblDado1.setIcon(imgDado2); break;
                case 3: lblDado1.setIcon(imgDado3); break;
                case 4: lblDado1.setIcon(imgDado4); break;
                case 5: lblDado1.setIcon(imgDado5); break;
                case 6: lblDado1.setIcon(imgDado6); break;
            }
            
            switch(miCasino.getDado2()){
                case 1: lblDado2.setIcon(imgDado1); break;
                case 2: lblDado2.setIcon(imgDado2); break;
                case 3: lblDado2.setIcon(imgDado3); break;
                case 4: lblDado2.setIcon(imgDado4); break;
                case 5: lblDado2.setIcon(imgDado5); break;
                case 6: lblDado2.setIcon(imgDado6); break;
            }
            
            if(miCasino.getIntentosRestantes() == 0){
                finDeRonda();
            }
        }   
    }
}
