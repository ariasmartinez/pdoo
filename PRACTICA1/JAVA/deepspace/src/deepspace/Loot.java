/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author Celia Arias Martínez, Lucía Salamanca López
 */
class Loot {
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    private boolean getEfficient;
    private boolean spaceCity;
    
    Loot (int nsu, int nw, int nsh, int nh, int nm, boolean ef, boolean city){
        nSupplies = nsu;
        nWeapons = nw;
        nShields = nsh;
        nHangars = nh;
        nMedals = nm;
        getEfficient = ef;
        spaceCity = city;
    }
    
    Loot (int nsu, int nw, int nsh, int nh, int nm){
        nSupplies = nsu;
        nWeapons = nw;
        nShields = nsh;
        nHangars = nh;
        nMedals = nm;
        getEfficient = false;
        spaceCity = false;
    }
    
    public int getNSupplies(){
        return nSupplies;
    }
    
    public int getNWeapons(){
        return nWeapons;
    }

    public int getNShields(){
        return nShields;
    }
    
    public int getNHangars(){
        return nHangars;
    }
    
    public int getNMedals(){
        return nMedals;
    }
    
    public boolean getEfficient(){
        return getEfficient;
    }
    
    public boolean spaceCity(){
        return spaceCity;
    }
    
    public String toString(){
        String mensaje = "El botín tiene "+nSupplies+" suministros, "+nWeapons+" armas, "+nShields+" escudos, "+nHangars+" hangares "+nMedals+" medallas, eficiencia: "+getEfficient+" spaceCity: "+spaceCity;
        return mensaje;
    }
    LootToUI getUIversion(){
       return new LootToUI(this);
    }
}
