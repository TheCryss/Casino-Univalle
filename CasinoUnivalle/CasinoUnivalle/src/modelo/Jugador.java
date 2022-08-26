/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jose9
 */
public class Jugador {
    private String nombre;
    private int puntos=0;
    private int lanzamientos=0;
    private boolean lanzo=false;
    
    public Jugador(String nombre){
        this.nombre=nombre;
}

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getLanzamientos() {
        return lanzamientos;
    }

    public void setLanzamientos(int lanzamientos) {
        this.lanzamientos += lanzamientos;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isLanzo() {
        return lanzo;
    }

    public void setLanzo(boolean lanzo) {
        this.lanzo = lanzo;
    }
    
    
}
