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
    private int ranking;
    
    
    public Jugador(String n){
        nombre = n;
        ranking = 0; 
        
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    
}
