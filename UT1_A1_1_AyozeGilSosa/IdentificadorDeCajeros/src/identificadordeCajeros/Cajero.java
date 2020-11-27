/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identificadordeCajeros;

/**
 *
 * @author Ayo
 */
public class Cajero {
    
    private String identificador;
    private String direccion;
    private int numero_oficina;

    public Cajero(String identificador, String direccion, int numero_oficina) {
        this.identificador = identificador;
        this.direccion = direccion;
        this.numero_oficina = numero_oficina;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero_oficina() {
        return numero_oficina;
    }

    public void setNumero_oficina(int numero_oficina) {
        this.numero_oficina = numero_oficina;
    }

    @Override
    public String toString() {
        return "Cajero " + identificador + " {Direccion = " + direccion 
                + "; Nº Oficina = " + numero_oficina + '}';
    }
}
