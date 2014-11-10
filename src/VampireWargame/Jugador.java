/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VampireWargame;

/**
 *
 * @author admin
 */
public class Jugador {
    private String nombre;
    private int ranking,puntos=0;
    
    
    public Jugador(String n){
        nombre = n;
        ranking = 0; 
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos() {
        puntos+=3;
    }
    
    
    
    
}
