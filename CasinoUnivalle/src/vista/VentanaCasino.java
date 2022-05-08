/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JFrame;

/**
 *
 * @author mauricio.munoz
 */
public class VentanaCasino extends JFrame{
    
    
    VentanaCasino(String nombre1, int modo, int lanzamientos){
        iniciarComponentes();
    }
    
    VentanaCasino(String nombre1, String nombre2, int modo, int lanzamientos){
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        setSize(600,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Casino Univalle");
        setResizable(false);
    }    
}
