/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;
import java.util.ArrayList;
/**
 *
 * @author Lucía Salamanca López
 *         Celia Arias Martínez
 */
public class Hangar {
    private int maxElements;
    private ArrayList<ShieldBooster> shieldBoosters;
    private ArrayList<Weapon> weapons;
    
    Hangar(int capacity){
        maxElements = capacity;
    }
    Hangar(Hangar h){
        throw new UnsupportedOperationException();
    }
    HangarToUI getUIversion(){
        return new HangarToUI(this);
    }
    
    public boolean spaceAvailable(){
       if ((shieldBoosters.size()+weapons.size()) < maxElements)
               return true;
       return false;
    }
    
    
    public boolean addWeapon(Weapon w){
        if(spaceAvailable()){
            weapons.add(w);
            return true;
        }
        return false;
    }
    
    public boolean addShieldBooster(ShieldBooster s){
         if(spaceAvailable()){
            shieldBoosters.add(s);
            return true;
        }
        return false;
    }
    public int getMaxElements(){
        return maxElements;
    }
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    //cambio Weapon[] por Arraylist
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    public ShieldBooster removeShieldBooster(int s){
          if (s > (shieldBoosters.size()-1))
            return null;
        return shieldBoosters.remove(s);
    }
    public Weapon removeWeapon(int w){
        if (w > (weapons.size()-1))
            return null;
        return weapons.remove(w);
    }
}
