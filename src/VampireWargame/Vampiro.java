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
public class Vampiro extends Ficha{
    
    public Vampiro(String c){
        super(4,5,3,c);
        nombre ="V";
    }
    
    public void chuparSangre(Ficha c){
        if(c.escudo !=0){
           c.escudo -= 1;
           if(c.escudo<0){
               c.vida -=c.escudo;
           }
        }
        else{
            c.vida -= 1;
        }
        vida += 1;
    }
    
}
