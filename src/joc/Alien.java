package joc;

public class Alien extends Player{

    public Alien(String nombre, int ataque, int defensa, int vida) {
        super(nombre, ataque, defensa, vida);

        System.out.println("He creado un Alien.");
    }
}
