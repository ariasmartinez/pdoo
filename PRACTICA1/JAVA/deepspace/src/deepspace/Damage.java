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
public abstract class Damage {
    private int nShields;
    
    
    
    public Damage(int s){
       nShields = s;
    }
    
    abstract public DamageToUI getUIversion();
    
    abstract public Damage adjust(ArrayList<Weapon> w,ArrayList<ShieldBooster> s);
   
    protected int adjustShields(ArrayList<ShieldBooster> s){
        int shields;
        if (getNShields() > s.size())
            shields = s.size();
        else 
            shields = getNShields();
        return shields;
    }
    public void discardShieldBooster(){
        if (nShields != 0)
            nShields --;
    }
    public boolean hasNoEffect(){
        return (nShields == 0);
    }
    public int getNShields(){
        return nShields;
    }
    
    public String toString(){
        String mensaje = "El daño es "+nShields+" escudos ";
        return mensaje;
    }
    abstract public void discardWeapon(Weapon w);
}
