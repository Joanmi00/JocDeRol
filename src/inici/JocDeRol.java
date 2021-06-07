package inici;

import joc.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JocDeRol {
    static Scanner teclat = new Scanner(System.in);
    static final int vida = 100;
    static ArrayList<Team> teams = new ArrayList<Team>(1);
    static ArrayList<Item> items = new ArrayList<Item>(1);
    static ArrayList<Player> players = new ArrayList<Player>(1);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        boolean salir = true;
        do {
            System.out.println("-----------------------------------");
            System.out.println("|         JOC DE ROL        |");
            System.out.println("|--------------------------------|");
            System.out.println("| 1. Configuración.       |");
            System.out.println("| 2. Iniciar.                     |");
            System.out.println("| 3. Salir.                         |");
            System.out.println("-----------------------------------");
            System.out.println("Elige una opción: ");
            int op = teclat.nextInt();
            teclat.nextLine();


            switch (op) {
                case 1:
                    configuarar();
                    break;
                case 2:
                    iniciar();
                    break;
                case 3:
                    salir = false;
                    System.out.println("Gracias por jugar");
                    break;
                default:
                    System.out.println("Opción incorrecta!");
            }
        } while (salir);
    }

    public static void configuarar() {
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("|          CONFIGURACIÓN        |");
            System.out.println("|-----------------------------------------|");
            System.out.println("| 1.1. Gestionar Jugadores.   |");
            System.out.println("| 1.2. Gestionar Equipos.       |");
            System.out.println("| 1.3. Gestionar Objetos.        |");
            System.out.println("| 1.4. Salir.                                 |");
            System.out.println("--------------------------------------------");
            System.out.println("Elige una opción: ");
            int op = teclat.nextInt();
            teclat.nextLine();

            switch (op) {
                case 1:
                    Jugadores();
                    break;
                case 2:
                    Equipos();
                    break;
                case 3:
                    Items();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("Opción incorrecta!");
            }
        }
    }

    public static void iniciar() {
        while (true) {
            int vi = 0;
            for (Player Ataca : players) {
                Player Defensa;
                do {
                    Defensa = Aleatorio();
                } while (Defensa.equals(Ataca));
                Ataca.attack(Defensa);

                if (Ataca.getLife() < 0) {
                    System.out.println("El jugador " + Ataca.getName() + " ha muerto!");
                }
                if (Defensa.getLife() < 0) {
                    System.out.println("El jugador " + Defensa.getName() + " ha muerto!");
                }


            }
            for (Player player : players) {
                if (player.getLife() > 0) {
                    vi++;
                }
            }
            if (vi == 1) {
                for (Player gana : players) {
                    if (gana.getLife() > 0) {
                        System.out.println("El ganador es " + gana.getName());
                    }
                }
                return;
            }
        }
    }


    public static void Jugadores() {
        while (true) {
            String player, team, item;
            System.out.println("--------------------------------------------------------------");
            System.out.println("|                           JUGADORES                       |");
            System.out.println("|-----------------------------------------------------------|");
            System.out.println("| 1.1.1. Crear Jugador.                                  |");
            System.out.println("| 1.1.2. Mostrar Jugadores.                         |");
            System.out.println("| 1.1.3. Eliminar Jugador                             |");
            System.out.println("| 1.1.4. Asignar Jugador a un Equipo.      |");
            System.out.println("| 1.1.5. Asignar Objeto a un Jugador.       |");
            System.out.println("| 1.1.6. Salir                                                     |");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Elige una opción: ");
            int op = teclat.nextInt();
            teclat.nextLine();

            switch (op) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    for (Player p : players) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    eliminarJugador();
                    break;
                case 4:
                    agregarEquipo();
                    break;
                case 5:
                    agregarItem();
                    break;
                case 6:
                    configuarar();
                    break;
                default:
                    System.out.println("Opción incorrecta!");
            }
        }
    }

    public static void Equipos() {
        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                                EQUIPOS                             |");
            System.out.println("|---------------------------------------------------------------|");
            System.out.println("| 1.2.1. Crear Equipo.                                         |");
            System.out.println("| 1.2.2. Mostrar Equipos.                                   |");
            System.out.println("| 1.2.3. Eliminar Equipos                                   |");
            System.out.println("| 1.2.4. Asignar un Jugador a un Equipo.      |");
            System.out.println("| 1.2.5. Salir                                                           |");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Elige una opción: ");
            int op = teclat.nextInt();
            teclat.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Di el nombre del equipo que quieres crear:");
                    String nom = teclat.nextLine();
                    Team equipo = new Team(nom);
                    teams.add(equipo);
                    break;
                case 2:
                    for (Team t : teams) {
                        System.out.println(t);
                    }
                    break;
                case 3:
                    eliminarEquipos();
                    break;
                case 4:
                    agregarEquipo();
                    break;
                case 5:
                    configuarar();
                default:
                    System.out.println("Opción incorrecta!");
            }
        }
    }

    public static void Items() {
        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("|                                   ITEMS                               |");
            System.out.println("|---------------------------------------------------------------|");
            System.out.println("| 1.3.1. Crear Objeto.                                         |");
            System.out.println("| 1.3.2. Mostrar Objetos.                                   |");
            System.out.println("| 1.3.3. Eliminar Objeto                                     |");
            System.out.println("| 1.3.4. Asignar un Objeto a un Jugador.      |");
            System.out.println("| 1.3.5. Salir                                                          |");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Elige una opción: ");
            int op = teclat.nextInt();
            teclat.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Di el nombre del objeto que quieres crear:");
                    String nom = teclat.nextLine();
                    System.out.println("Ataque extra del objeto:");
                    int ataque = teclat.nextInt();
                    teclat.nextLine();
                    System.out.println("Defensa extra del objeto:");
                    int defensa = teclat.nextInt();
                    teclat.nextLine();

                    Item objeto = new Item(nom, ataque, defensa);
                    items.add(objeto);
                    break;
                case 2:
                    for (Item i : items) {
                        System.out.println(i);
                    }
                    break;
                case 3:
                    eliminarItem();
                    break;
                case 4:
                    agregarItem();
                    break;
                case 5:
                    configuarar();
                default:
                    System.out.println("Opción incorrecta!");
            }
        }
    }

    public static void crearJugador() {

        System.out.println("Que tipo de jugador quieres crear?");
        System.out.println("1. Humano");
        System.out.println("2. Guerrero");
        System.out.println("3. Alien");
        int jugador = teclat.nextInt();
        teclat.nextLine();

        System.out.println("Di el nombre del jugador:");
        String nombre = teclat.nextLine();

        System.out.println("Di el ataque que tiene el jugador:");
        System.out.println("Recuerda que no puede ser mayor de 100 o menor de 0.\n En tal caso se le asignaran estos valores");
        int ataque = teclat.nextInt();
        teclat.nextLine();

        if (ataque > 100) {
            ataque = 100;
        } else if (ataque < 0) {
            ataque = 0;
        }
        int defensa = 100 - ataque;

        while (true) {
            switch (jugador) {
                case 1:
                    Human humano = new Human(nombre, ataque, defensa, vida);
                    players.add(humano);
                    configuarar();
                    break;
                case 2:
                    Warrior guerrero = new Warrior(nombre, ataque, defensa, vida);
                    players.add(guerrero);
                    configuarar();
                    break;
                case 3:
                    Alien alien = new Alien(nombre, ataque, defensa, vida);
                    players.add(alien);
                    configuarar();
                    break;
                default:
                    System.out.println("Opción incorrecta!");
                    configuarar();
            }
        }
    }


    public static void eliminarJugador() {
        System.out.println("Di el jugador que quieres eliminar:");
        String juga = teclat.nextLine();

        Player p = juga(juga);
        players.remove(p);
        System.out.println("Jugador eliminado");

    }

    public static void agregarEquipo() {
        System.out.println("Di el jugador que quieres agragar a un equipo:");
        String juga = teclat.nextLine();
        System.out.println("En que equipo?");
        String equi = teclat.nextLine();

        Player p = juga(juga);
        Team e = equi(equi);

        e.ad(p);
        System.out.println("El jugador " + juga + " ha sido agregado al equipo " + equi);

    }

    public static void eliminarEquipos() {
        System.out.println("Que equipo quieres eliminar?");
        String equi = teclat.nextLine();

        Team e = equi(equi);
        for (Player pl : players) {
            if (pl.getTeams().contains(e)) {
                pl.getTeams().remove(e);
                System.out.println("El equipo " + equi + " se ha eliminado");
            }
        }
    }

    public static void eliminarItem() {
        System.out.println("Que item quieres eliminar?");
        String ite = teclat.nextLine();

        Item i = ite(ite);
        for (Player pl : players) {
            if (pl.getItems().contains(i)) {
                pl.getItems().remove(i);
            }
        }
    }

    public static void agregarItem() {
        System.out.println("Di el nombre del Item que quieres agregar:");
        String ite = teclat.nextLine();
        Item i = ite(ite);

        System.out.println("A que jugador lo quieres agregar?");
        String juga = teclat.nextLine();
        Player p = juga(juga);
        System.out.println();
        p.addItem(i);
    }

    public static Player juga(String jugador) {
        for (Player c : players) {
            if (c.getName().equalsIgnoreCase(jugador)) {
                return c;
            }
        }
        return null;
    }

    public static Team equi(String equipo) {
        for (Team t : teams) {
            if (t.getName().equalsIgnoreCase(equipo)) {
                return t;
            }
        }
        return null;
    }

    public static Item ite(String objeto) {
        for (Item i : items) {
            if (i.getName().equalsIgnoreCase(objeto)) {
                return i;
            }
        }
        return null;
    }

    public static Player Aleatorio() {
        int hola = (int) (Math.random() * players.size());
        return players.get(hola);
    }
}