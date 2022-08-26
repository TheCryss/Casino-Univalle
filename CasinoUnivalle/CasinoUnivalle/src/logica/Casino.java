/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Jugador;

/**
 *
 * @author jose9
 */
public class Casino {
    private Jugador j2;
    private Jugador j1;
    private Ronda ronda;
    private int lanzamiento;
    private int modoDeJuego;
    private int ganadorLanzamiento;
    private int p1,p2;
    private int dado1, dado2;
    
    public Casino(Jugador j1,Jugador j2, int modo){
        this.j1=j1;
        this.j2=j2;
        modoDeJuego = modo;
        ganadorLanzamiento = 3;
    }
    
    public void IniciarLanzamientos(int lanzamientos){
        ronda = new Ronda();
        ronda.setTotalLanzamientos(lanzamientos);

    } 
    
    public int lanzar()
    {
        dado1 = (int)((Math.random()*6) +1);
        dado2 = (int) ((Math.random()*6) +1);
        lanzamiento = dado1 + dado2;
        return lanzamiento;
    }
    
    public void agregarLanzamiento(Jugador j)
    {
        
        if (modoDeJuego==0) {
            
            lanzar();
            j.setPuntos(lanzamiento);
            j.setLanzamientos(1);
            p1=lanzamiento;
            lanzar();
            j2.setPuntos(lanzamiento);
            j2.setLanzamientos(1);
            ronda.setTotalLanzamientos(-1);
            p2=lanzamiento;
            if (p2==p1) {
                ronda.setEmpates(1);
                ronda.setTotalLanzamientos(1);
                j1.setPuntos(-lanzamiento);
                j2.setPuntos(-lanzamiento);
            }
            gano(p1,p2);
        } else {
           
            if (ronda.getTurno()==1) {
                lanzar();
                j.setPuntos(lanzamiento);
                j.setLanzamientos(1);
                p1=lanzamiento;
                ronda.setTurno(2);
            } else {
                lanzar();
                j.setPuntos(lanzamiento);
                j.setLanzamientos(1);
                p2=lanzamiento;
                ronda.setTotalLanzamientos(-1);
                if (p2==p1) {
                    ronda.setEmpates(1);
                    ronda.setTotalLanzamientos(1);
                    j1.setPuntos(-lanzamiento);
                    j2.setPuntos(-lanzamiento);
                    ronda.setTurno(1);
                }
                gano(p1,p2);

            }
        }
        
    }
    
    public void gano(int j1,int j2)
    {
        if (j1>j2) {
            ganadorLanzamiento=1;
           
        }else if (j1<j2) {

            ganadorLanzamiento=2;
        }else{
            if(j1 == 0){
                ganadorLanzamiento = 3;
            }
            else {
                ganadorLanzamiento =0;
            }
        }
    }
    public int getGanadorLanzamiento()
    {
        return ganadorLanzamiento;
    }
    public int puntos(Jugador j)
    {
        return j.getPuntos();
    }
    
    public int lanzamientos(Jugador j)
    {
        return j.getLanzamientos();
    }

    public int getIntentosRestantes()
    {
        return ronda.getTotalLanzamientos();
    }
    public int getEmpates()
    {
        return ronda.getEmpates();
    }
    public int quienVaGanando()
    {
        if (j1.getPuntos()>j2.getPuntos()) {
            return 1;
        }else if (j1.getPuntos()<j2.getPuntos()) {
            return 2;
        }else{
            return 0;
        }
    }
    
    public void setTurno(int t)
    {
        ronda.setTurno(t);
    }
    public int getTurno()
    {
        
        return ronda.getTurno();
        
    }
    public int getDado1(){
        return dado1;
    }
    public int getDado2(){
        return dado2;
    }
    
    public int getNumRondas(){
        return ronda.getTotalRondas();
    }
}
