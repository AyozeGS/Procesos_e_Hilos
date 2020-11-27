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
public class Repartidor extends Thread{
    
    private BuzonCentral buzonCentral;
    private int numSobres;

    //Constructor
    public Repartidor(String nombre, BuzonCentral buzonCentral, int numSobres) {
        super(nombre);
        this.buzonCentral = buzonCentral;
        this.numSobres = numSobres;
    }

    //Método que llama al método reponer las veces indicadas por numSobres
    //constructor
    @Override
    public void run() {
        for (int i=1; i<=numSobres; i++){
            buzonCentral.repartir(this.getName());
            System.out.println("El "+this.getName()+" ha retirado "
                    + "el sobre número: "+i);
            try {
                Thread.sleep(150); //El hilo duerme tras repartir cada sobre
            } catch (InterruptedException ex) {}
        }
    }
    
    //Métodos getter y setter
    public BuzonCentral getBuzonCentral() {
        return buzonCentral;
    }

    public void setBuzonCentral(BuzonCentral buzonCentral) {
        this.buzonCentral = buzonCentral;
    }

    public int getNumSobres() {
        return numSobres;
    }

    public void setNumSobres(int numSobres) {
        this.numSobres = numSobres;
    }
}
