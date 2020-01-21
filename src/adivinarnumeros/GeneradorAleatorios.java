/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinarnumeros;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class GeneradorAleatorios {
    Scanner reader = new Scanner(System.in);

    private int extIzq;
    private int extDer;
    private int intervalo;
    private int numAleatorio;
    
    public GeneradorAleatorios(){
    }
    
    public void generarIntervalo(){
        setIntervalo((extDer - extIzq) + 1);
    }

    public void introducirExtremosyGenerarIntervalo() {
        System.out.println("Inserte el extremo izquierdo del intervalo:");
        setExtIzq(reader.nextInt());
        System.out.println("Inserte el extremo derecho del intervalo:");
        setExtDer(reader.nextInt());
        generarIntervalo();
    }
    
    public void DerMayorQueIzq() {
    	while (getExtIzq() > getExtDer()){
            System.out.println("El extremo izquierdo ha de ser menor que el derecho.");
            introducirExtremosyGenerarIntervalo();
        }
    }
    
    public void comprobarIntervalo(){
        while (getIntervalo() < 30){
            System.out.println("El intervalo no es correcto.");
            introducirExtremosyGenerarIntervalo();
        }
    }
    
    public void generarAleatorio(){
       setNumAleatorio((int)(Math.random()*(getIntervalo()) + getExtIzq()));  
    }
    
    /**
     * @return the numAleatorio
     */
    public int getNumAleatorio() {
        return numAleatorio;
    }

    /**
     * @param numAleatorio the numAleatorio to set
     */
    public void setNumAleatorio(int numAleatorio) {
        this.numAleatorio = numAleatorio;
    }
    
        /**
     * @return the extIzq
     */
    public int getExtIzq() {
        return extIzq;
    }

    /**
     * @param extIzq the extIzq to set
     */
    public void setExtIzq(int extIzq) {
        this.extIzq = extIzq;
    }

    /**
     * @return the extDer
     */
    public int getExtDer() {
        return extDer;
    }

    /**
     * @param extDer the extDer to set
     */
    public void setExtDer(int extDer) {
        this.extDer = extDer;
    }
    
    /**
     * @return the intervalo
     */
    public int getIntervalo() {
        return intervalo;
    }

    /**
     * @param intervalo the intervalo to set
     */
    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    
}

