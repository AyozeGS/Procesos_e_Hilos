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
public class ParkingDeBicicletas {
    
    //Atributos
    private int numCascos;
    private int numBicicletas;
    private final int tiempoExcursionMilisegundos;
    
    //Constructor
    public ParkingDeBicicletas(int numCascos, int numBicicletas, int tiempo) {
        this.numCascos = numCascos;
        this.numBicicletas = numBicicletas;
        this.tiempoExcursionMilisegundos = tiempo;
    }
    
    // Método que deja el hilo en estado de suspensión el tiempo indicado
    public void realizarExcursion(String nombre){
        System.out.println("El " + nombre + " comienza la excursión.");
        try {
            Thread.sleep(tiempoExcursionMilisegundos);
        } catch (InterruptedException ex) {}
        System.out.println("El " + nombre + " ha terminado la excursión.");
    }
    
    // Método que decrementa el número de cascos
    public synchronized void cogerCasco(String nombre){
        if (numCascos == 0){
            try {
                this.wait();
            } catch (InterruptedException ex) {}
        }
        numCascos--;
        System.out.println("El " + nombre + " ha cogido el casco.");
    }
    
    // Método que incrementa el número de cascos
    public synchronized void dejarCasco(String nombre){
        numCascos++;
        System.out.println("El " + nombre + " ha devuelto el casco.");
        System.out.println("Cascos libres: " + numCascos);
        notifyAll();
    }
    
    // Método que decrementa el número de bicicletas
    public synchronized void cogerBicicleta(String nombre){
        if (numBicicletas == 0){
            try {
                this.wait();
            } catch (InterruptedException ex) {}
        }
        numBicicletas--;
        System.out.println("El " + nombre + " ha cogido la bicicleta.");
    }
    
    // Método que incrementa el número de cascos
    public synchronized void dejarBicicleta(String nombre){
        numBicicletas++;
        System.out.println("El " + nombre + " ha devuelto la bicicleta.");
        System.out.println("Bicicletas libres: " + numBicicletas);
        notifyAll();
    }
}
