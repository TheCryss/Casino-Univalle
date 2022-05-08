/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mauricio.munoz
 */
public class VentanaNombres extends JFrame{
    private int lanzamientos;
    private int modoJuego;
    private JLabel lblJugador1; 
    private JLabel lblJugador2;
    private JTextField txtJugador1;
    private JTextField txtJugador2;
    private JButton btnContinuar;
    private Container contenedorNombres;
    
    VentanaNombres(int lanza, int modo){
        lanzamientos = lanza;
        modoJuego = modo;
        
        iniciarComponentes();
        setSize(380,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Casino Univalle - Nombres");
        setResizable(false);
    }
    
    public void iniciarComponentes(){
        
        lblJugador1 = new JLabel("Nombre jugador 1");
        lblJugador1.setHorizontalAlignment(JLabel.CENTER);
        lblJugador1.setBounds(90, 40, 200, 20);
        
        txtJugador1 = new JTextField("");
        txtJugador1.setBounds(90, 60, 200, 20);
        
        lblJugador2 = new JLabel("Nombre jugador 2");
        lblJugador2.setHorizontalAlignment(JLabel.CENTER);
        lblJugador2.setBounds(90, 120, 200, 20);
        
        txtJugador2 = new JTextField("");
        txtJugador2.setBounds(90, 140, 200, 20);
        
        btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(137, 185, 105, 45);
        
        contenedorNombres = getContentPane();
        contenedorNombres.setLayout(null);
        
        contenedorNombres.add(lblJugador1);
        contenedorNombres.add(txtJugador1);
        contenedorNombres.add(btnContinuar);
        contenedorNombres.add(lblJugador2);
        contenedorNombres.add(txtJugador2);
        lblJugador2.setVisible(false);
        txtJugador2.setVisible(false);
        
        if(modoJuego == 2){
            lblJugador2.setVisible(true);
            txtJugador2.setVisible(true);
        } 
        btnContinuar.addActionListener(new EventosNombres());
    }
    
    private void iniciarVentanaCasino(String nombre1){
        dispose();
        VentanaCasino ventanaCasino = new VentanaCasino(nombre1, modoJuego, 
                lanzamientos);
        System.out.println("Modo 1");
    }
    
    private void iniciarVentanaCasino(String nombre1, String nombre2){
        dispose();
        VentanaCasino ventanaCasino = new VentanaCasino(nombre1, nombre2, 
                modoJuego, lanzamientos);
        System.out.println("Modo 2");
    }
    
    class EventosNombres implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        boolean sinNombre = false; 
            if((txtJugador1.getText()).equals("")){
                sinNombre = true;
            }
            if(modoJuego == 2){
                if((txtJugador2.getText()).equals("")){
                    sinNombre = true;
                }
            }
            
            if(sinNombre){
                JOptionPane.showMessageDialog(null, "Hay casillas sin nombre"
                    , "Error", 1);
                sinNombre = false;
            }
            else{
                if(modoJuego == 1){
                    iniciarVentanaCasino(txtJugador1.getText());
                }else if(modoJuego == 2){
                    iniciarVentanaCasino(txtJugador1.getText(),
                            txtJugador2.getText());
                }
            }
        }
    }
}
