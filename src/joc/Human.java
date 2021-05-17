package joc;

public class Human extends Player{

    public Human(String nombre, int ataque, int defensa, int vida) {
        super(nombre, ataque, defensa, vida);

        System.out.println("He creado un Humano.");
    }

}
