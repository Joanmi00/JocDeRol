package joc;

import java.util.ArrayList;

public class Team {
    String name;
    ArrayList<Player> players;


    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    @Override
    public String toString() {
        String equips = "Integrantes del equipo:  " + name;
        for (Player p : players) {
            equips += "\n" + p ;
        }
        return equips;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Team t) {
        if (this.name.compareTo(t.name) == 0 && this.players == t.players){
            return true;
        }
        return false;
    }

    public void ad(Player p){
        this.players.add(p);
        if(!p.getTeams().contains(this)){
            p.ad(this);
        }
    }
    public void remove(Player p){
        this.players.remove(p);
        if(p.getTeams().contains(this)){
            p.remove(this);
        }
    }
}
