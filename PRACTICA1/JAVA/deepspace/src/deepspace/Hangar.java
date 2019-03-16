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
public class Hangar {
    private int maxElements;
    
    Hangar(int capacity){
        throw new UnsupportedOperationException();
    }
    Hangar(Hangar h){
        throw new UnsupportedOperationException();
    }
    HangarToUI getUIversion(){
        throw new UnsupportedOperationException();
    }
    public boolean spaceAvailable(){
        throw new UnsupportedOperationException();
    }
    public boolean addWeapon(Weapon w){
        throw new UnsupportedOperationException();
    }
    public boolean addShieldBooster(ShieldBooster s){
        throw new UnsupportedOperationException();
    }
    public int getMaxElements(){
        throw new UnsupportedOperationException();
    }
    public ShieldBooster[] getShieldBoosters(){
        throw new UnsupportedOperationException();
    }
    public Weapon[] getWeapons(){
        throw new UnsupportedOperationException();
    }
    public ShieldBooster removeShieldBooster(int s){
        throw new UnsupportedOperationException();
    }
    public Weapon removeWeapon(int w){
        throw new UnsupportedOperationException();
    }
}
