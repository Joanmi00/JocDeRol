package joc;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    private ArrayList<Team> teams;
    private  ArrayList<Item> items;

    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.setName(name);
        this.setAttackPoints(attackPoints);
        this.setDefensePoints(defensePoints);
        this.setLife(life);
        setTeams(new ArrayList<>());
        setItems(new ArrayList<>());
    }

    //inici del atac
    public void attack(Player p){

        //Mostrem qui es el atacant y qui es atacat
        System.out.println(" ");
        System.out.println("ANTES DEL ATAQUE");
        System.out.println("---------------------------------------------------------------------------------------------");

        System.out.println("Atacante: "+ this);
        System.out.println("Atacado: "+ p);
        System.out.println("");
        System.out.println("ATAQUE:");
        System.out.println("---------------------------------------------------------------------------------------------");

        //Afegim el bonus de atac del item
        int a = this.getAttackPoints();
        for(Item item : this.items){
            a += item.getAttackBonus();
        }

        //El atacant colpeja al atacat
        p.hit(a);

        //Si la vida del colpejat no baixa a 0 li tornara el atac
        if (p.life>0){
            int ap = p.getAttackPoints();
            for(Item item : p.items){
                ap += item.getAttackBonus();
            }
            this.hit(ap);
        }

        //Informació despres del atac
        System.out.println(" ");
        System.out.println("DESPUES DEL ATAQUE");
        System.out.println("---------------------------------------------------------------------------------------------");

        System.out.println("Atacante: "+ this);
        System.out.println("Atacado: "+ p);
    }

    //Atac
    protected void hit(int attackPoints){
        int defensa=this.getDefensePoints();

        //Afegim el bonus de defensa del item
        for(Item item: this.items){
            defensa+=item.getDefenseBonus();
        }

        int vida=this.getLife();
        int atac=attackPoints - defensa;
        int vi=vida-atac;

        //Si la vida del atacat baixa a 0 mostrara que el jugador a mort
        if (vi <= 0){
            System.out.println("HA MUERTO!!");
            vi = 0;
            //Sino mostrara el atac i a la vida que li queda
        }else{
            System.out.println(this.getName() + " es golpeado con "+ attackPoints + " puntos y se defiende con " + defensa + ". Vida: " + vida + " - " + atac + " = " + vi);
        }
        this.setLife(vi);
    }

    //Informació del jugador seleccionat
    @Override
    public String toString() {
        String i = "\n";
        for(Item item: items){
            i += item + "\n";
        }
        return this.name + " PA: " + this.attackPoints + "  /  PD: " + this.defensePoints + "  /  PV: " + this.life + " (Pertenece a " + this.getTeams().size() + " equipos) tiene los items:" + i;
    }

    //Afegir integrant a un equip
    public void ad(Team t){
        this.getTeams().add(t);
        if(!t.players.contains(this)){
            t.ad(this);
        }
    }

    //Eliminar un integrant de un equip
    public void remove(Team t){
        this.getTeams().remove(t);
        if(t.players.contains(this)){
            t.remove(this);
        }
    }

    public boolean equals(Player p) {
        if (this.name.compareTo(p.name) == 0 && this.attackPoints - p.getAttackPoints() == 0 && this.defensePoints - p.getDefensePoints() == 0 && this.life - p.getLife() == 0){
            return true;
        }
        return false;
    }

    //Afegir un item a un jugador
    public void addItem(Item item){
        this.items.add(item);
    }

    //Eliminar un item d'un jugador
    public void removeItem(Item item){
        this.items.remove(item);
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

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

}
