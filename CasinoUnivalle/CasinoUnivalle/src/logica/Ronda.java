/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author jose9
 */
public class Ronda {
    private int totalLanzamientos;
    private int empates;
    private int mejorLanzamiento;
    private int mejorRonda;
    private int totalRondas;
    private int turno=1;
    
    public Ronda(){
        totalRondas++;
        
    }

    public int getTotalLanzamientos() {
        return totalLanzamientos;
    }

    public void setTotalLanzamientos(int totalLanzamientos) {
        this.totalLanzamientos += totalLanzamientos;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates += empates;
    }

    public int getMejorLanzamiento() {
        return mejorLanzamiento;
    }

    public void setMejorLanzamiento(int mejorLanzamiento) {
        this.mejorLanzamiento = mejorLanzamiento;
    }

    public int getMejorRonda() {
        return mejorRonda;
    }

    public void setMejorRonda(int mejorRonda) {
        this.mejorRonda = mejorRonda;
    }

    public int getTotalRondas() {
        return totalRondas;
    }

    public void setTotalRondas(int totalRondas) {
        this.totalRondas = totalRondas;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
