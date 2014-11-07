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
public class Battle {
    public static void main(String[] args) {
        String[][] tablero = new String[6][6];
        for(int x=0; x<6;x++){
            for(int y=0;y<6;y++){
                tablero[x][y]="[ ]";
            }
        }
        
        for(int x=0; x<6;x++){
            for(int y=0;y<6;y++){
                System.out.print(tablero[x][y]);
            }
            System.out.println("");
        }
        Ficha vampiro = new Vampiro("Blanco");
        Ficha vampiro2 = new Vampiro("Negro");
        Muerte muerte = new Muerte("Negro");
        
        ((Vampiro)vampiro).chuparSangre(vampiro2);
        
        System.out.println("Vida vampiro1 "+vampiro.vida +"\nVida vampiro 2: "+vampiro2.vida +"\nEscudo vampiro2: "+vampiro2.escudo);
        
    }
}
