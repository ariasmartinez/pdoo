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
public class SpecificDamage extends Damage{
    private ArrayList<WeaponType> weapons;
   
    public SpecificDamage(ArrayList<WeaponType> wl, int s ){
       super(s);
       weapons = new ArrayList<>();
       for(int i=0; i<wl.size(); i++){
            weapons.add(wl.get(i));
       }
    }
    
    public SpecificDamage copy(){
        return new SpecificDamage(weapons,getNShields());
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
    
    @Override
    public SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int shields = super.adjust(s);
        int pos;
        ArrayList<Weapon> weapontype_prov = new ArrayList<Weapon>();
        for(int i=0; i<w.size(); i++){
            weapontype_prov.add(w.get(i));
        }
            
        ArrayList<WeaponType> weapon_prov = new ArrayList<WeaponType>();
            
        for (int i=0; i<weapons.size(); i++){
           pos = arrayContainsType(weapontype_prov,weapons.get(i));
           if (pos!=-1){
                weapon_prov.add(weapons.get(i));
                weapontype_prov.remove(pos);
           }
        }
        return new SpecificDamage(weapon_prov,shields);
    }
    
    public void discardWeapon(Weapon w){
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
    
    @Override
    public boolean hasNoEffect(){
        return (weapons.isEmpty() && super.hasNoEffect());
    }
    
    public ArrayList<WeaponType> getWeapons(){
        return weapons;
    }
    
    @Override
    public String toString(){
        String mensaje= super.toString()+" y la coleccion de armas es "+weapons.toString();
        return mensaje;
    }
     
    SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
}
