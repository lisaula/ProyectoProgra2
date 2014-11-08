/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VampireWargame;

import java.util.ArrayList;
import java.util.Scanner;

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
                    System.out.print("[  ]");
                else
                    System.out.print(""+tablero[x][y].toString()+"");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        ArrayList <Jugador> players = new ArrayList<>();
        int op;
        do{
            System.out.println("1-INICIAR PARTIDA\n" +
                    "2-RANKING HISTORICO DE JUGADORES\n" +
                    "3-LOG DE ULTIMAS 10 PARTIDAS\n" +
                    "4-SALIR");
            System.out.print("R: ");
            op=lea.nextInt();
            
            switch(op){
                case 1:
                    System.out.print("Ingrese USERNAME de Player #1:");
                    players.add(new Jugador(lea.next()));
                    System.out.print("Ingrese USERNAME de Player #2:");
                    players.add(new Jugador(lea.next()));
                    
                    Ficha vampiro = new Vampiro("B",0,1);
                    Ficha vampiro2 = new Vampiro("B",0,4);
                    Ficha vampiro3 = new Vampiro("N",5,1);
                    Ficha vampiro4 = new Vampiro("N",5,4);
                    Ficha muerte = new Muerte("B",0,2);
                    Ficha muerte2 = new Muerte("B",0,3);
                    Ficha muerte3 = new Muerte("N",5,2);
                    Ficha muerte4 = new Muerte("N",5,3);
                    Ficha lobo = new Lobo("B",0,0);
                    Ficha lobo2 = new Lobo("B",0,5);
                    Ficha lobo3 = new Lobo("N",5,0);
                    Ficha lobo4 = new Lobo("N",5,5);

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
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    if(op==4){
                        System.out.println("Usted a escogido salir del sistema\nADIOS");
                        
                    }else{
                        System.out.println("Opcion no valida.");
                    }
                    break;
                    
            }
            
            
            
        }while(op!=4);
        
        
        
        
        
        
       
       
        
        
//        printTablero();
//        tablero[2][0].moverPieza(tablero);
//        printTablero();
          //tablero[0][0].atacar(); 
//        if(tablero[0][0].moverPieza(tablero))
//            System.out.println("Movido");
//        else
//            tablero[0][0].moverPieza(tablero);
        
//        if(tablero[0][0] instanceof Lobo ){
//           tablero[0][0].moverPieza(tablero);
//        }else
//            System.out.println("No es lobo");
        
       
        
        
        
        
        
        
        
    }
}
