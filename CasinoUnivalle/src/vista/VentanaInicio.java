/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



/**
 *
 * @author mauricio.munoz
 */
public class VentanaInicio extends JFrame{
    private JLabel lblTitulo;
    private JTextField txtLanzamientos;
    private JButton btnUnJugador;
    private JButton btnMultijugador;
    private Container contenedorInicial;
    
    
    public VentanaInicio(){
        iniciarComponentes();   
        setSize(380,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Casino Univalle");
        setResizable(false);
    }
    
    public void iniciarComponentes(){
        
        lblTitulo = new JLabel("Casino Univalle");
        lblTitulo.setBounds(90, 40, 200, 20);
        lblTitulo.setFont(new Font("Comic Sans",Font.BOLD,25));

        txtLanzamientos = new JTextField("Introduce el numero de lanzamientos");
        txtLanzamientos.setBounds(80, 120, 220, 20);
        
        btnUnJugador = new JButton("Un Jugador");
        btnUnJugador.setBounds(60, 175, 105, 45);
        
        btnMultijugador = new JButton("Multijugador");
        btnMultijugador.setBounds(205, 175, 105, 45);
        
        contenedorInicial = getContentPane();
        contenedorInicial.setLayout(null);
        
        contenedorInicial.add(lblTitulo);
        contenedorInicial.add(txtLanzamientos);
        contenedorInicial.add(btnUnJugador);
        contenedorInicial.add(btnMultijugador);
        
        btnUnJugador.addActionListener(new EventosInicial());
        btnMultijugador.addActionListener(new EventosInicial());
    }
    
    class EventosInicial implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnUnJugador){
                System.out.println("J1");
            }
            if(e.getSource() == btnMultijugador){
                System.out.println("J2");
            }
        }
        
    }
}
