/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectordecajeros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ayo
 */
public class LectorDeCajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creamos un objeto Scanner para leer el contenido del fichero
        try (Scanner flujoFichero = 
                new Scanner(new File("CajerosNoOperativos.txt"))) {
            
            //Bucle para leer cada línea del fichero con el Scanner
            while (flujoFichero.hasNextLine()) {
                System.out.println(flujoFichero.nextLine());
            }

        } catch (IOException ex) {
            System.out.println("Error de lectura del fichero");
        } 
    }
}
