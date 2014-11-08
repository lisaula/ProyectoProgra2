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
    
    static Ficha[][] tablero = new Ficha[6][6];
    
    public static void printTablero(){
        for(int x=0;x<6;x++){
            for(int y=0;y<6;y++){
                if(tablero[x][y]== null)
                    System.out.print(" [ ]");
                else
                    System.out.print(" "+tablero[x][y].toString());
            }
            System.out.println("");
        }
    }
    

    public static void main(String[] args) {
        Ficha vampiro = new Vampiro("b");
        Ficha vampiro2 = new Vampiro("b");
        Ficha vampiro3 = new Vampiro("n");
        Ficha vampiro4 = new Vampiro("n");
        Ficha muerte = new Muerte("b");
        Ficha muerte2 = new Muerte("b");
        Ficha muerte3 = new Muerte("n");
        Ficha muerte4 = new Muerte("n");
        Ficha lobo = new Lobo("b");
        Ficha lobo2 = new Lobo("b");
        Ficha lobo3 = new Lobo("n");
        Ficha lobo4 = new Lobo("n");
        
        tablero[0][0]=lobo;
        tablero[0][5]=lobo2;
        tablero[5][0]=lobo3;
        tablero[5][5]=lobo4;
        tablero[0][1]=vampiro;
        tablero[0][4]=vampiro2;
        tablero[5][1]=vampiro3;
        tablero[5][4]=vampiro4;
        tablero[0][2]=muerte;
        tablero[0][3]=muerte2;
        tablero[5][2]=muerte3;
        tablero[5][3]=muerte4;
        
        printTablero(); 
        
        
        
        
        
    }
}
