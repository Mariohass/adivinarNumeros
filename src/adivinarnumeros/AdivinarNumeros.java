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
public class AdivinarNumeros {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        GeneradorAleatorios Aleatorio = new GeneradorAleatorios();
        Temporizador Tiempo = new Temporizador();

        int cantidadNum;
        int numIntroducido;
        int aciertos = 0;

        System.out.println("Indique el tiempo (en segundos) que va a durar el juego:");
        Tiempo.setSegundos(reader.nextInt());
        Tiempo.comprobarTiempoPositivo();
        
        System.out.println("Cantidad de numeros a adivinar (en " + Tiempo.getSegundos() + " segundos.)");
        cantidadNum = reader.nextInt();
        comprobarCantidadNumPositiva(reader, cantidadNum);

        Aleatorio.introducirExtremosyGenerarIntervalo();
        Aleatorio.DerMayorQueIzq();
        Aleatorio.comprobarIntervalo();
 
        System.out.println("Ya tenemos todos los datos necesarios para empezar el juego");
        System.out.println("Empezemos:");
        
        Tiempo.setTiempoInicio();
        
        while (aciertos < cantidadNum) {
            Aleatorio.generarAleatorio();
            numIntroducido = introducirNumeroAAdivinar(reader);
            numIntroducido = numIntroducidoNegativo(numIntroducido, reader);
            numIntroducido = numFueraDeIntervalo(reader, Aleatorio, numIntroducido);
            
            while (numIntroducido != Aleatorio.getNumAleatorio() && Tiempo.tiempoRestante() > 0) {
                System.out.println("Lo siento, " + numIntroducido + " no es el número.");
                mostrarSiNumMayorOMenor(numIntroducido, Aleatorio);
                mostrarTiempoRestante(Tiempo);
                numIntroducido = introducirNumeroAAdivinar(reader);
                numIntroducido = numIntroducidoNegativo(numIntroducido, reader);
                numIntroducido = numFueraDeIntervalo(reader, Aleatorio, numIntroducido);
                
            }
                
            if (Tiempo.tiempoRestante()>0){
                aciertos++;
                System.out.println("¡MUY BIEN, HAS ACERTADO!");
                System.out.println("Llevas " + aciertos + " números acertados.");
            } else {
                System.out.println("Se ha terminado el tiempo.");
                System.out.println("Has adivinado " + aciertos + " NÚMEROS");
                break;
            }
        }
        if (aciertos == cantidadNum){
            System.out.println("¡ENHORABUENA, HAS ACERTADO TODOS LOS NÚMEROS!");
            }
        }


    public static int comprobarCantidadNumPositiva(Scanner reader, int cantidadNum){
        while (cantidadNum < 0) {
            System.out.println("La cantidad ha de ser positiva");
            cantidadNum = reader.nextInt();
        }
        return cantidadNum;
    }
    
     public static int introducirNumeroAAdivinar(Scanner reader) {
        int numIntroducido;
        System.out.println("Intente adivinar el número");
        numIntroducido = reader.nextInt();
        return numIntroducido;
    }
     
    public static int numIntroducidoNegativo(int numIntroducido, Scanner reader) {
        while (numIntroducido<0){
            System.out.println("El numero ha de ser positivo");
            numIntroducido = introducirNumeroAAdivinar(reader);
        }
        return numIntroducido;
    }
    
    public static int numFueraDeIntervalo(Scanner reader, GeneradorAleatorios Aleatorio, int numIntroducido) {
        while (numIntroducido < Aleatorio.getExtIzq() || numIntroducido > Aleatorio.getExtDer()){
            System.out.println("El número ha de estar entre " + Aleatorio.getExtIzq() + " y " + Aleatorio.getExtDer());
            numIntroducido = introducirNumeroAAdivinar(reader);
        }
        return numIntroducido;
    }
    
    public static void mostrarSiNumMayorOMenor(int numIntroducido, GeneradorAleatorios Aleatorio) {
        if (numIntroducido < Aleatorio.getNumAleatorio()) {
            System.out.println("El número a adivinar es mayor que " + numIntroducido);
        } else {
            System.out.println("El número a adivinar es menor que " + numIntroducido);
        }
    }
    
    public static void mostrarTiempoRestante(Temporizador Tiempo) {
        Tiempo.setTiempoActual();
        Tiempo.tiempoTranscurrido();
        System.out.println("Te quedan " + Tiempo.tiempoRestante() + " segundos.");
    }
}
