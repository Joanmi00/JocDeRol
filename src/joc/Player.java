package joc;

public abstract class Player {
    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;

    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.setName(name);
        this.setAttackPoints(attackPoints);
        this.setDefensePoints(defensePoints);
        this.setLife(life);
    }

    public void attack(Player p){

        System.out.println(" ");
        System.out.println("ANTES DEL ATAQUE");
        System.out.println("----------------------------------------------------------");
        System.out.println("Atacante: "+ this);
        System.out.println("Atacado: "+ p);
        System.out.println("");
        System.out.println("ATAQUE:");
        System.out.println("----------------------------------------------------------");


        p.hit(this.getAttackPoints());

        if (p.life>0){
            this.hit(p.getAttackPoints());
        }

        System.out.println(" ");
        System.out.println("DESPUES DEL ATAQUE");
        System.out.println("----------------------------------------------------------");
        System.out.println("Atacante: "+ this);
        System.out.println("Atacado: "+ p);
    }

    protected void hit(int attackPoints){
        int defensa=this.getDefensePoints();
        int vida=this.getLife();
        int atac=attackPoints - defensa;
        int vi=vida-atac;

        if (vi <= 0){
            System.out.println("HA MUERTO!!");
            vi = 0;
        }else{
            System.out.println(this.getName() + " es golpeado con "+ attackPoints + " puntos y se defiende con " + defensa + ". Vida: " + vida + " - " + atac + " = " + vi);
        }
        this.setLife(vi);
    }

    @Override
    public String toString() {
        return this.name + " PA: " + this.attackPoints + "  /  PD: " + this.defensePoints + "  /  PV: " + this.life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

}
