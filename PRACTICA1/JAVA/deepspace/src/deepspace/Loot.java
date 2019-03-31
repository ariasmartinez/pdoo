/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author celia
 */
class Loot {
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    
    Loot (int sum, int armas, int escudos, int hang, int med){
        nSupplies = sum;
        nWeapons = armas;
        nShields = escudos;
        nHangars = hang;
        nMedals = med;
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
    
    public String toString(){
        String mensaje = "El botín tiene "+nSupplies+" suministros, "+nWeapons+" armas, "+nShields+" escudos, "+nHangars+" hangares y "+nMedals+" medallas";
        return mensaje;
    }
    LootToUI getUIversion(){
       return new LootToUI(this);
    }
}
