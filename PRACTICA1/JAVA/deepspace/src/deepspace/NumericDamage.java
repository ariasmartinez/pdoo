/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author Celia Arias Martínez, Lucía Salamanca López
 */
public class NumericDamage extends Damage{
    private int nWeapons;
    
    public NumericDamage(int w, int s ){
        super(s);
        nWeapons = w;
    }
    
    public NumericDamage copy(){
        return new NumericDamage(nWeapons, getNShields());
    }
    
    @Override
    public NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int shields = super.adjust(s);
        if (nWeapons > w.size())
            return new NumericDamage(w.size(),shields);
        else 
            return new NumericDamage(nWeapons,shields);
    }
    
    @Override
    public void discardWeapon(Weapon w){
        if (nWeapons>0)
            nWeapons --;
    }
    
    @Override
    public boolean hasNoEffect(){
        return ((nWeapons == 0) && super.hasNoEffect());
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    @Override
    public String toString(){
        String mensaje = super.toString()+"y "+nWeapons+" armas.";
        return mensaje;
    }
    
    NumericDamageToUI getUIversion(){
        return new NumericDamageToUI(this);
    }
}
