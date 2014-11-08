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
public class Muerte extends Ficha {
    public Muerte(String c){
        super(3,1,4,c);
        nombre ="M";
    }
    
    public void ataqueLanza(Ficha a){
        a.vida -= 2;
    }
    
    public Zombie CrearZombie(int x,int y){
       Zombie z= new Zombie(color); 
       return z;
    }
    
    public void ataqueZombie(Ficha h){
        if(h.escudo>0)
            h.escudo -=1;
        else
            h.vida -=1;
    }
    
    
    
    
}
