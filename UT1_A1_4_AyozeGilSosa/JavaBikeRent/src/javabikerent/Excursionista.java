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
public class Excursionista extends Thread {
    //Atributo
    ParkingDeBicicletas parkingDeBicicletas;
    //Constructor
    public Excursionista(String nombre, 
            ParkingDeBicicletas parkingDeBicicletas){
        super(nombre); 
        this.parkingDeBicicletas = parkingDeBicicletas;
    }
    // El método sobreescrito hace llamadas a métodos del parkingDeBicicletas
    @Override
    public void run() {
        parkingDeBicicletas.cogerCasco(this.getName());
        Thread.yield();
        parkingDeBicicletas.cogerBicicleta(this.getName());
        parkingDeBicicletas.realizarExcursion(this.getName());
        //Esta parte del bloque se realiza de forma completa 
        synchronized(parkingDeBicicletas){
            parkingDeBicicletas.dejarBicicleta(this.getName());
            parkingDeBicicletas.dejarCasco(this.getName());
            parkingDeBicicletas.notifyAll();
        }
    }
}
