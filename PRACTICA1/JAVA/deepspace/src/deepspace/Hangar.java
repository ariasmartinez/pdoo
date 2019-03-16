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
public class Hangar {
    private int maxElements;
    //mirar (arrays?)
    private ArrayList<ShieldBooster> aum_escudo;
    private ArrayList<Weapon> arma;
    
    Hangar(int capacity){
        maxElements = capacity;
    }
    Hangar(Hangar h){
        throw new UnsupportedOperationException();
    }
    HangarToUI getUIversion(){
        throw new UnsupportedOperationException();
    }
    /*la suma ha sido cosa mia puede petar*/
    public boolean spaceAvailable(){
       if ((aum_escudo.size()+arma.size()) < maxElements)
               return true;
       return false;
    }
    
    
    public boolean addWeapon(Weapon w){
        if(spaceAvailable()){
            arma.add(w);
            return true;
        }
        return false;
    }
    
    public boolean addShieldBooster(ShieldBooster s){
         if(spaceAvailable()){
            aum_escudo.add(s);
            return true;
        }
        return false;
    }
    public int getMaxElements(){
        return maxElements;
    }
    public ArrayList<ShieldBooster> getShieldBoosters(){
        throw new UnsupportedOperationException();
    }
    //cambio Weapon[] por Arraylist
    public ArrayList<Weapon> getWeapons(){
        return arma;
    }
    public ShieldBooster removeShieldBooster(int s){
          if (s > aum_escudo.size())
            return null;
        return aum_escudo.remove(s);
    }
    public Weapon removeWeapon(int w){
        if (w > arma.size())
            return null;
        return arma.remove(w);
    }
}
