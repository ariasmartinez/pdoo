/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author celia
 */
public class Damage {
    private int nShields;
    private int nWeapons;
    
    public Damage(int w, int s){
       nShields = s;
       nWeapons = w;
    }
    public Damage(WeaponType[] wl, int s ){
        throw new UnsupportedOperationException();
    }
    Damage(Damage d){
        throw new UnsupportedOperationException();
    }
    DamageToUI getUIversion(){
        throw new UnsupportedOperationException();
    }
    private int arrayContainsType(Weapon[] w, WeaponType t){
        throw new UnsupportedOperationException();
    }
    
    //cambio Weapon[] por ArrayList<Weapon>
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        throw new UnsupportedOperationException();
    }
    public void discardWeapon(Weapon w){
        throw new UnsupportedOperationException();
    }
    public void discardShieldBooster(){
        throw new UnsupportedOperationException();
    }
    public boolean hasNoEffect(){
        throw new UnsupportedOperationException();
    }
    public int getNShields(){
        throw new UnsupportedOperationException();
    }
    public int getNWeapons(){
        throw new UnsupportedOperationException();
    }
    public ArrayList<WeaponType> getWeapons(){
        throw new UnsupportedOperationException();
    }
}
