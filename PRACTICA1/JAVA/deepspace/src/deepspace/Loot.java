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
    
    int getNSupplies(){
        return nSupplies;
    }
    
    int getNWeapons(){
        return nWeapons;
    }

    int getNShields(){
        return nShields;
    }
    
    int getNHangars(){
        return nHangars;
    }
    
    int getNMedals(){
        return nMedals;
    }
    
    
}
