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
public class BuzonCentral {
    
    private int numSobres;
    private int smartPoints; //Indica el máx de sobres que puede contener

    public BuzonCentral(int smartPoints) {
        //Atributos
        this.numSobres = 0;
        this.smartPoints = smartPoints; 
    }
    
    //Método que decrementa el número de sobres en una unidad
    public synchronized void repartir(String nombreHilo){
        try{
            while(numSobres == 0){
                System.out.println(nombreHilo + " en espera porque no hay "
                        + "sobres en el buzón central");
                this.wait();
            }
        } catch (InterruptedException ex) {}
        numSobres--;
        this.notify();//Notifica al siguiente hilo en la cola que continue
    }
    
    //Método que incrementa el número de sobres en una unidad
    public synchronized void reponer(String nombreHilo){
        try{
            //
            while(numSobres == smartPoints){
                System.out.println("Reponedor en espera porque hay "+numSobres
                        + " sobres en el buzón Central");
                this.wait();
            }
        } catch (InterruptedException ex) {}
        numSobres++;
        this.notify();//Notifica al siguiente hilo en la cola que continue
    } 

    // Métodos getters y setters
    public int getNumSobres() {
        return numSobres;
    }

    public void setNumSobres(int numSobres) {
        this.numSobres = numSobres;
    }

    public int getSmartPoints() {
        return smartPoints;
    }

    public void setSmartPoints(int smartPoints) {
        this.smartPoints = smartPoints;
    }
    
    
}
