
package VampireWargame;

import java.util.*;

public class Battle {

    static ArrayList<Jugador> players = new ArrayList<>();
    static Ficha[][] tablero = new Ficha[6][6];

    public static void printTablero() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (tablero[x][y] == null) {
                    System.out.print("[  ]");
                } else {
                    System.out.print("" + tablero[x][y].toString() + "");
                }
            }
            System.out.println("");
        }
    }

    public static Jugador buscarPlayer(String n) {
        for (Jugador j : players) {
            if (j.getNombre().equalsIgnoreCase(n)) {
                return j;
            }
        }
         return null;
    }

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        Random rnd = new Random();
        String arr[] = {"VAMPIRO", "MUERTE", "LOBO"};
        int op;
        do {
            System.out.println("1-INICIAR PARTIDA\n"
                    + "2-RANKING HISTORICO DE JUGADORES\n"
                    + "3-LOG DE ULTIMAS 10 PARTIDAS\n"
                    + "4-SALIR");
            System.out.print("R: ");
            op = lea.nextInt();

            switch (op) {
                case 1:
                    Jugador player1;
                    Jugador player2;

                    System.out.print("Ingrese USERNAME de Player #1:");
                    String j1 = lea.next();
                    if (buscarPlayer(j1) != null) {
                        player1 = buscarPlayer(j1);
                    } else {
                     players.add(new Jugador(j1));
                    }

                    System.out.print("Ingrese USERNAME de Player #2:");
                    String j2 = lea.next();
                    players.add(new Jugador(j2));
                    if (buscarPlayer(j2) != null) {
                        player2 = buscarPlayer(j2);
                    } else {
                        players.add(new Jugador(j2));
                    }

                    Ficha vampiro = new Vampiro("B", 0, 1);
                    Ficha vampiro2 = new Vampiro("B", 0, 4);
                    Ficha vampiro3 = new Vampiro("N", 5, 1);
                    Ficha vampiro4 = new Vampiro("N", 5, 4);
                    Ficha muerte = new Muerte("B", 0, 2);
                    Ficha muerte2 = new Muerte("B", 0, 3);
                    Ficha muerte3 = new Muerte("N", 5, 2);
                    Ficha muerte4 = new Muerte("N", 5, 3);
                    Ficha lobo = new Lobo("B", 0, 0);
                    Ficha lobo2 = new Lobo("B", 0, 5);
                    Ficha lobo3 = new Lobo("N", 5, 0);
                    Ficha lobo4 = new Lobo("N", 5, 5);

                    tablero[0][0] = lobo;
                    tablero[0][5] = lobo2;
                    tablero[5][0] = lobo3;
                    tablero[5][5] = lobo4;
                    tablero[0][1] = vampiro;
                    tablero[0][4] = vampiro2;
                    tablero[5][1] = vampiro3;
                    tablero[5][4] = vampiro4;
                    tablero[0][2] = muerte;
                    tablero[0][3] = muerte2;
                    tablero[5][2] = muerte3;
                    tablero[5][3] = muerte4;

                    String espectroAlAzar = arr[rnd.nextInt(arr.length)];//sselecciona al azar
                    System.out.println("Su opcion a mover es un(a) " + espectroAlAzar);
                    int fa,ca;
                    
                    printTablero();
                    while (true) {
                        System.out.print("Ingrese posicion fila actual: ");
                        fa = lea.nextInt();
                        System.out.print("Ingrese posicion columna actual: ");
                        ca = lea.nextInt();

                        if (tablero[fa][ca].nombreEspectro.equals(espectroAlAzar)) {//compara que la posicion que ingreso sea del tipo que le salio
                            break;
                        } else if (fa == -1 && ca == -1) {
                            System.out.print("En realidad desea salir del juego? ");
                            String res = lea.next();
                            if (res.equalsIgnoreCase("si")) {
                                System.out.println("Se ha retirado");
                                 break;
                            }
                           continue;
                        }
                        System.out.println("coordenadas incorrectas, ingreselas de nuevo");
                    }
                    tablero[fa][ca].subMenu(fa,ca);
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Usted a escogido salir del sistema\nADIOS");
                     break;
                default:
                    System.out.println("Opcion no valida.");
                }

        } while (op != 4);

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
