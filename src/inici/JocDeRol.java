package inici;

import joc.*;

public class JocDeRol {

    public static void main(String[] args) {


        provaFase();
    }
    public static void provaFase(){

        System.out.println("Voy a crear un humano: ");
        Human Antonio = new Human("Antonio", 13, 8, 39);

        System.out.println("\n Voy a crear un Alien: ");
        Alien Manolo = new Alien("Manolo", 27, 2, 32);

        System.out.println("\n Voy a crear un Guerrero: ");
        Warrior Camilo = new Warrior("Camilo", 20, 10, 27);

        Antonio.attack(Manolo);
        Camilo.attack(Antonio);
        Manolo.attack(Camilo);
    }
}
