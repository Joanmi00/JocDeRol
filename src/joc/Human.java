package joc;

public class Human extends Player{

    public Human(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);

        if(super.getLife() > 100){
            setLife(100);
        }

        System.out.println("He creado un Humano.");

    }
}

