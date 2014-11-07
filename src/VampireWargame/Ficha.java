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
public class Ficha {
    protected int vida, escudo, espada;
    protected String color;

    public Ficha(int vida, int escudo, int espada, String color) {
        this.vida = vida;
        this.escudo = escudo;
        this.espada = espada;
        this.color = color;
    }
    
      
    public void atacar(Ficha atacado ) {
        if(atacado.escudo !=0){
           atacado.escudo -= espada;
           if(atacado.escudo<0){
               atacado.vida -=atacado.escudo;
               atacado.escudo=0;
           }
        }
        else{
            atacado.vida -= espada;
        }
    }
    
    
    
    
    
    
    
    
}
