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
    private ArrayList<WeaponType> weapons;
    
    public Damage(int w, int s){
       nShields = s;
       nWeapons = w;
       weapons = null;
    }
    public Damage(ArrayList<WeaponType> wl, int s ){
       weapons = new ArrayList<WeaponType>();
       for(int i=0; i<wl.size(); i++){
            weapons.add(wl.get(i));
       }
       nShields = s;
       nWeapons = 0;
    }
    Damage(Damage d){
        nShields = d.nShields;
        nWeapons = d.nWeapons;
        if(d.weapons!=null){
            for(int i=0; i<d.weapons.size(); i++)
                weapons.add(d.weapons.get(i));
        }
        else {
            d.weapons = null;
        }
        
    }
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    }
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
           int pos = -1;
           boolean cond = false;
           int i = 0;
           while (!cond && i<w.size()){
                if (w.get(i).getType() == t){
                    pos = i;
                    cond = true;
                }
                i++;
            }
           return pos;
    }
    
    //cambio Weapon[] por ArrayList<Weapon>
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        throw new UnsupportedOperationException();
    }
    public void discardWeapon(Weapon w){
        if(weapons!=null){
            int pos = -1;
            boolean cond = false;
            for (int i=0; !cond &&i<weapons.size();i++){
                if(weapons.get(i) == w.getType()){
                    pos = i;
                    cond = true;
                }
            }
            if (pos!=-1){
                weapons.remove(pos);
            }
        }
        else if (nWeapons!=0)
            nWeapons --;
    }
    public void discardShieldBooster(){
        if (nShields != 0)
            nShields --;
    }
    public boolean hasNoEffect(){
        if(nShields == 0 && nWeapons == 0 && weapons == null)
            return true;
        else 
            return false;
    }
    public int getNShields(){
        return nShields;
    }
    public int getNWeapons(){
        return nWeapons;
    }
    public ArrayList<WeaponType> getWeapons(){
        return weapons;
    }
}
