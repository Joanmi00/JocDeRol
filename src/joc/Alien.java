package joc;

public class Alien extends Player{

    public Alien(String nombre, int ataque, int defensa, int vida) {
        super(nombre, ataque, defensa, vida);

        System.out.println("He creado un Alien.");
    }

    @Override
    public void attack(Player p){

        System.out.println(" ");
        System.out.println("ANTES DEL ATAQUE");
        System.out.println("----------------------------------------------------------");
        System.out.println("Atacante: "+ this);
        System.out.println("Atacado: "+ p);
        System.out.println("");
        System.out.println("ATAQUE:");
        System.out.println("----------------------------------------------------------");

        if(this.getLife() > 20){
            this.setAttackPoints(this.getAttackPoints()+3);
            this.setDefensePoints(this.getDefensePoints()-3);
        }

        p.hit(this.getAttackPoints());

        if (p.getLife() > 0) {
            this.hit(p.getAttackPoints());
        }
        System.out.println(" ");
        System.out.println("DESPUES DEL ATAQUE");
        System.out.println("----------------------------------------------------------");
        System.out.println("Atacante: "+ this);
        System.out.println("Atacado: "+ p);
    }
}
