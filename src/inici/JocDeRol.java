package inici;

import joc.*;

public class JocDeRol {

    public static void main(String[] args) {


        provaFase();
    }
    public static void provaFase(){

        System.out.println("Voy a crear un humano: ");
        Human Antonio = new Human("Antonio", 50, 30, 200);

        System.out.println("\n Voy a crear un Alien: ");
        Alien Manolo = new Alien("Manolo", 60, 40, 200);

        System.out.println("\n Voy a crear un Guerrero: ");
        Warrior Camilo = new Warrior("Camilo", 80, 15, 200);


        System.out.println("\n Antonio reta a Manolo a un combate");
        Antonio.attack(Manolo);

        System.out.println("\n Camilo reta a Manolo a un combate");
        Camilo.attack(Antonio);
        System.out.println("\n Manolo reta a Camilo a un combate");
        Manolo.attack(Camilo);
    }
}
