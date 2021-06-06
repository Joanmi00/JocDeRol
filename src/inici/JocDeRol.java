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


        Team Team1 = new Team("MEMBRILLOS");
        Team Team2 = new Team("ESPE APROVAM");


        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Agregando integrantes a los equipos:");
        System.out.println("");
        Team1.ad(Antonio);
        System.out.println(Antonio.getName() + " añadido al equipo " + Team1.getName());
        Team2.ad(Antonio);
        System.out.println(Antonio.getName() + " añadido al equipo " + Team2.getName());
        Team2.ad(Manolo);
        System.out.println(Manolo.getName() + " añadido al equipo " + Team2.getName());
        Team1.ad(Camilo);
        System.out.println(Camilo.getName() + " añadido al equipo " + Team1.getName());
        Team2.ad(Camilo);
        System.out.println(Camilo.getName() + " añadido al equipo " + Team2.getName());

        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(Team1);
        System.out.println("");
        System.out.println(Team2);
        System.out.println("---------------------------------------------------------------------------------------------");



        System.out.println("\n Antonio reta a Manolo a un combate");
        Antonio.attack(Manolo);

        System.out.println("\n Camilo reta a Manolo a un combate");
        Camilo.attack(Antonio);

        System.out.println("\n Manolo reta a Camilo a un combate");
        Manolo.attack(Camilo);

        Team1.remove(Antonio);
        Team2.remove(Camilo);

        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(Team1);
        System.out.println("");
        System.out.println(Team2);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}
