/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leercomensales;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Ayo
 */
public class LeerComensales {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   
        // Creamos un flujo para leer el fichero comensales.txt
        // en modo de acceso aleatorio
        try (RandomAccessFile flujoFichero = new RandomAccessFile(
                new File("comensales.txt"), "r")) {
            
            System.out.println("Hay "+flujoFichero.readInt()+" comensales"); 
            
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error: " + ex.toString());
        }  
    }
}