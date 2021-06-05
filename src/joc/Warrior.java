package joc;

public class Warrior extends Human{


    public Warrior(String nombre, int ataque, int defensa, int vida) {
        super(nombre, ataque, defensa, vida);

        System.out.println("He creado un Guerrero.");
    }

    @Override
    protected void hit(int attackPoints){

        int defensa = this.getDefensePoints();
        int vida = this.getLife();
        int atac = attackPoints - defensa;

        if( atac < 5){
            atac = 0;
        }
        int vi = vida-atac;

        if (vi <= 0){
            System.out.println("HA MUERTO!!");
            vi = 0;
        }else{
            System.out.println(this.getName() + " es golpeado con "+ attackPoints + " puntos y se defiende con " + defensa + ". Vida: " + vida + " - " + atac + " = " + vi);
        }
        this.setLife(vi);
    }
}
