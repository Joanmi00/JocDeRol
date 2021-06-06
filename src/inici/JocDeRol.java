package inici;

import joc.*;

public class JocDeRol {
    public static void main(String[] args) {

        provaFase();
    }
    public static void provaFase(){

        // Creem els personatges
        System.out.println("Voy a crear un humano: ");
        Human Antonio = new Human("Antonio", 50, 30, 200);

        System.out.println("\n Voy a crear un Alien: ");
        Alien Manolo = new Alien("Manolo", 60, 40, 200);

        System.out.println("\n Voy a crear un Guerrero: ");
        Warrior Camilo = new Warrior("Camilo", 80, 15, 200);

        //Creem els equips
        Team Team1 = new Team("MEMBRILLOS");
        Team Team2 = new Team("ESPE APROVAM");

        //Afegim els integrants dels equips
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

        //Mostrem per pantalla els integrants de cada equip
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(Team1);
        System.out.println("");
        System.out.println(Team2);

        //Creem els items amb els bonus
        Item Item1 = new Item("varita de los bosques", 10, 10);
        Item Item2 = new Item("escudo magico", 0,20);
        Item Item3 = new Item("espada laser", 20, 0);

        //Afegim els items als jugadors
        System.out.println("");
        System.out.println("Añadiendo items a los jugadores");
        System.out.println("---------------------------------------------------------------------------------------------");
        Antonio.addItem(Item1);
        System.out.println("El item " + Item1.getName() + " a sido añadido a " + Antonio.getName());
        Manolo.addItem(Item2);
        System.out.println("El item " + Item2.getName() + " a sido añadido a " + Manolo.getName());
        Manolo.addItem(Item3);
        System.out.println("El item " + Item3.getName() + " a sido añadido a " + Manolo.getName());
        Camilo.addItem(Item3);
        System.out.println("El item " + Item3.getName() + " a sido añadido a " + Camilo.getName());
        Camilo.addItem(Item1);
        System.out.println("El item " + Item1.getName() + " a sido añadido a " + Camilo.getName());
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("");

        //Comats entre jugadors
        System.out.println("\n Antonio reta a Manolo a un combate");
        Antonio.attack(Manolo);

        System.out.println("\n Camilo reta a Manolo a un combate");
        Camilo.attack(Antonio);

        System.out.println("\n Manolo reta a Camilo a un combate");
        Manolo.attack(Camilo);

        //Eliminem algun integrant dels equips
        System.out.println("");
        Team1.remove(Antonio);
        System.out.println(Antonio.getName() + " eliminado del equipo " + Team1.getName());
        Team2.remove(Camilo);
        System.out.println(Camilo.getName() + "  eliminado del equipo " + Team2.getName());

        //Eliminem algun item dels jugadors
        System.out.println("");
        Camilo.removeItem(Item1);
        System.out.println("El item " + Item1.getName() + " a sido eliminado de " + Camilo.getName());
        Manolo.removeItem(Item3);
        System.out.println("El item " + Item3.getName() + " a sido eliminado de " + Manolo.getName());

        //Mostrem com queden els equips i els items
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(Team1);
        System.out.println(Team2);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}
