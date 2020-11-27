/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrares;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import javax.swing.JOptionPane;

/**
 *
 * @author Ayo
 */
public class RegistrarES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int comensales; //variable que guarda el numero de pesonas en el comedor
        // Se crea un fichero de acceso aleatorio. Como el fichero es accedido
        // por otro proceso se ha decidido almacenar el valor del entero en
        // lugar de caracteres.
        try (RandomAccessFile flujoFichero = new RandomAccessFile(
                new File ("comensales.txt"), "rws"); 
                FileLock bloqueo = flujoFichero.getChannel().lock()) {
            // Se el fichero está vacío se inicializa a 0 y se coloca el puntero
            // al inicio.
            if (flujoFichero.length() == 0){
                flujoFichero.writeInt(0);
                flujoFichero.seek(0);
            }
            // Se lee el valor entero del fichero y se sobreescribe añadiendo o
            // restando un comensal en función de si el argumento es 1, +1 o -1
            comensales = flujoFichero.readInt();
            flujoFichero.seek(0);
            if (args[0].equals("1") || 
                    args[0].equals("+1") || 
                    args[0].equals("-1")){
                // Se avisa si habiendo 0 comensales se registra una salida
                if (comensales + Integer.parseInt(args[0]) < 0){
                    JOptionPane.showMessageDialog(null, 
                            "Salida registrada sin haber comensales"+
                                    "Nº de comensales permanece en 0", 
                            "Aviso: Número de Comensales", 
                            JOptionPane.WARNING_MESSAGE);
                }
                else
                    flujoFichero.writeInt(
                            comensales + Integer.parseInt(args[0]));
            }
            // Se indica si el valor no alguno de los admitidos
            else
                System.out.println("El valor del argumento no es correcto.");
            
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error: " + ex.toString());
        }    
    }  
}
