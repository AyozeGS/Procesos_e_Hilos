/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identificadordeCajeros;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Ayo
 */
public class IdentificadorDeCajeros {

    //Array de objetos Cajero con sus datos
    static final ArrayList<Cajero> LISTA_CAJEROS = new ArrayList<Cajero>(){{
            add(new Cajero("A000","C/Aconcagua, 2",134));
            add(new Cajero("A001","Carretera del Rincon, 23",123));
            add(new Cajero("A002","Paseo de las Delicias, 5",134));
            add(new Cajero("A003","C/ Romerales, 34",122));
            add(new Cajero("A004","Avenida Tirajana, 8",123));
            add(new Cajero("A005","C.C. Las Arenas, Local 21",134));
            add(new Cajero("A006","C/ Tajinaste, 8",101));
            add(new Cajero("A007","C/ Hermanos Mendoza, 11",134));
            add(new Cajero("A008","Avenida Escaleritas, 99",134));
            add(new Cajero("A009","Paseo de Chil, 33",101));
        }};
    
    //Método para comprobar si el identificador pertenece a un cajero
    static void comprobarIdentificacion(String idCajero){
        Cajero cajero;
        boolean registrado = false;
        //Bucle para comprar cada cajero de la lista con el identificador dado
        for (Iterator<Cajero> i = LISTA_CAJEROS.iterator(); i.hasNext();){
            cajero = i.next();
            if(idCajero.equals(cajero.getIdentificador())){
                System.out.println(cajero.toString());
                registrado = true;
                break;
            }
        }
        if (!registrado) //Indicamos si el identificador no aparece en la lista
            System.out.println("Cajero "+idCajero+" no identificado");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        String idCajero;
        Scanner flujoEntrada;
        
        //Bucle para comprobar ids introducidos como argumentos
        for (String s : args){
            comprobarIdentificacion(s);
        }
        //Bucle para comprobar ids desde la entrada estándar del sistema
        flujoEntrada = new Scanner(System.in);
        while (flujoEntrada.hasNextLine()){
            idCajero = flujoEntrada.nextLine();
            if (idCajero.equals(""))
                break;
            comprobarIdentificacion(idCajero);
        }
        System.out.println("Fin del programa.");
    }
}
