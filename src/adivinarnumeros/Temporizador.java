package adivinarnumeros;
import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario
 */
public class Temporizador {

    Scanner reader = new Scanner(System.in);
    
    private int segundos;
    private int tiempoActual;
    private int tiempoInicio;
    private int tiempoTranscurrido;
    
    public Temporizador(){
        
    }
    
    public int getSegundos() {
        return segundos;
    }
   
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    public void comprobarTiempoPositivo(){
        
        while (getSegundos()<0){
            System.out.println("El tiempo ha de ser positivo");
            setSegundos(reader.nextInt());
        }
    }
    
    public void tiempoTranscurrido(){
        setTiempoTranscurrido(getTiempoActual()- getTiempoInicio());
     }
    
    public int tiempoRestante(){
        int tiempoRestante = getSegundos() - getTiempoTranscurrido();
        return tiempoRestante;
    }
  
   
    /**
     * @return the tiempoTranscurrido
     */
    public int getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }

    /**
     * @param tiempoTranscurrido the tiempoTranscurrido to set
     */
    public void setTiempoTranscurrido(int tiempoTranscurrido) {
        this.tiempoTranscurrido = tiempoTranscurrido;
    }

    /**
     * @return the tiempoInicio
     */
    public int getTiempoInicio() {
        return tiempoInicio;
    }

    /**
     * @param tiempoInicio the tiempoInicio to set
     */
    public void setTiempoInicio() {
        this.tiempoInicio = (int)System.currentTimeMillis()/1000;
    }

    /**
     * @return the tiempoActual
     */
    public int getTiempoActual() {
        return tiempoActual;
    }

    /**
     * @param tiempoActual the tiempoActual to set
     */
    public void setTiempoActual() {
        this.tiempoActual = (int)System.currentTimeMillis()/1000;
    }
}
