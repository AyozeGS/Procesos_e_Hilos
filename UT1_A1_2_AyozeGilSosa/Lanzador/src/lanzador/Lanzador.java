/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzador;

import java.io.IOException;
import static java.lang.Math.abs;

/**
 *
 * @author Ayo
 */
public class Lanzador {

    // metodo que ejecuta el proceso RegistrarES contenido en la misma carpeta
    // indicancole un valor como parametro de entrada
    static void lanzarRegistrarES(String registroES){
        Process nuevoProceso;
        try{
                nuevoProceso = Runtime.getRuntime().exec(
                        "java -jar RegistrarES.jar "+registroES);
        } catch (SecurityException ex){
            System.out.println("No se ha podido iniciar el proceso");
        } catch (IOException ex) {
            System.out.println("No se ha podido ejecutar RegistrarES");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numEntradas = 0, numSalidas = 0; //Inicializamos a 0 las E/S
        
        //Se comprueba que el numero de argumentos sea 2.
        if (args.length != 2)
            System.out.println("Debes indicar el número de entradas y de salidas");
        else {
            // Se convierten a tipo entero los argumentos y se llama al método
            // lanzarRegistrarES tantos veces como indiquen ambos valores
            // pasándole como parámetros de entrada +1 y -1 respectivamente.
            try{
                numEntradas = abs(Integer.parseInt(args[0]));
                numSalidas = abs(Integer.parseInt(args[1]));
                
                System.out.println("Número de entradas: "+numEntradas);
                for (int i=0; i<numEntradas; i++){
                    lanzarRegistrarES("+1");
                }
                System.out.println("Número de salidas: "+numSalidas);
                for (int i=0; i<numSalidas; i++){
                    lanzarRegistrarES("-1");
                } 
        
            } catch (NumberFormatException nfe){
                System.out.println("Debes indicar las entradas y salidas con números");
            }
        }
    }  
}
