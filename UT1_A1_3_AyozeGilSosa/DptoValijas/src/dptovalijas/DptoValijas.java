/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dptovalijas;

/**
 *
 * @author Ayo
 */
public class DptoValijas {                                                                                                                  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Atributos
        BuzonCentral buzonCentral;
        Reponedor reponedor;
        Repartidor repartidor;
        boolean reponedorFinalizado = false, repartidorFinalizado = false;

        try{
            // Se generan excepciones si los argumentos no son correctos
            int smartPoints = Integer.valueOf(args[0]);
            int numSobres = Integer.valueOf(args[1]);
            if (args.length > 2) throw new ArrayIndexOutOfBoundsException();
            if (smartPoints<0 || numSobres<0) throw new NumberFormatException();
            
            System.out.println("Número máx. de sobres permitidos en el "
                    + "buzón Central: " + smartPoints);
            System.out.println("Número máx. de sobres a repartir por el "
                    + "reponedor y el repartidor: " + numSobres);
            
            // Se crea una instancia de BuzonCentral
            buzonCentral = new BuzonCentral(smartPoints);
            // Se crean y ejecutan los hilos
            reponedor = new Reponedor("Reponedor", buzonCentral, numSobres);
            repartidor = new Repartidor("Repartidor", buzonCentral, numSobres);
            repartidor.start();
            reponedor.start();
            
            //Bucle que comprueba si los hilos han terminado
            while(true){
                if(!reponedorFinalizado && !reponedor.isAlive()){
                    reponedorFinalizado = true;
                    System.out.println(reponedor.getName()+" ha terminado");
                }  
                if(!repartidorFinalizado && !repartidor.isAlive()){
                    repartidorFinalizado = true;
                    System.out.println(repartidor.getName()+" ha terminado");
                }
                if(reponedorFinalizado && repartidorFinalizado)
                    break;
            }
            // A la finalización de los hilos el proceso continúa
            System.out.println("El reparto ha terminado");
            
        }catch(NumberFormatException ex){
            System.out.println("Los argumentos deben ser enteros positivos");
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("No ha introducido los argumentos necesarios");
        }
        
        
    }
    
}
