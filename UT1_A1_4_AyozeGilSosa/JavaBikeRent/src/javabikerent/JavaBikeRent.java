/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabikerent;

/**
 *
 * @author Ayo
 */
public class JavaBikeRent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ParkingDeBicicletas parkingDeBicicletas;
        Excursionista[] excursionistas; //Array de objetos Excursionista
        
        try{
            // Se generan excepciones si los argumentos no son correctos
            int nExcursionistas = Integer.parseInt(args[0]);
            int numCascos = Integer.parseInt(args[1]);
            int numBicicletas = Integer.parseInt(args[2]);
            int tiempoExcursion = Integer.parseInt(args[3]);
            if (args.length > 4) throw new ArrayIndexOutOfBoundsException();
            if (nExcursionistas<0 || numCascos<0 || numBicicletas<0 ||
                    tiempoExcursion<0 ) throw new NumberFormatException();
            
            System.out.println("Número de excursionistas: " + nExcursionistas);
            System.out.println("Número de bicicletas: " + numBicicletas);
            System.out.println("Número de cascos: " + numCascos);
            System.out.println("Duración de la excursión: " + tiempoExcursion);
            
            parkingDeBicicletas = new ParkingDeBicicletas(
                    numCascos, numBicicletas, tiempoExcursion);
            excursionistas = new Excursionista[nExcursionistas];
            
            // Bucle que instancia los objetos Excursionista a partir de los
            // número obtenido en los argumentos y asigna nombres a los hilos
            for(int i=0; i<nExcursionistas; i++){
                excursionistas[i] = new Excursionista(
                        "excursionista "+(i+1), parkingDeBicicletas);
                excursionistas[i].start();
            }
            
        }catch(NumberFormatException ex){
            System.out.println("Los argumentos deben ser enteros positivos");
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("No ha introducido los argumentos necesarios");
        }
    } 
}
