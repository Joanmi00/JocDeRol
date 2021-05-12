package inici;

import joc.*;

public class JocDeRol {

    public static void main(String[] args) {


        provaFase();
    }
    public static void provaFase(){

        System.out.println("Voy a crear un humano: ");
        Human Antonio = new Human();

        System.out.println("\n Voy a crear un Alien: ");
        Alien Manolo = new Alien();

        System.out.println("\n Voy a crear un Guerrero: ");
        Warrior Camilo = new Warrior();
    }
}
