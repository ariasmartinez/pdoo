/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;
import java.lang.Math;

/**
 *
 * @author Lucía Salamanca López
 *         Celia Arias Martínez
 */
public class SpaceStation implements SpaceFighter{
    private static final int MAXFUEL = 100;
    private static final double SHIELDLOSSPERUNITSHOT = 0.1;
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private ArrayList<ShieldBooster> shieldBoosters ;
    private ArrayList<Weapon> weapons;
    private Hangar hangar;
    
    
    
    
    
    private void assignFuelValue(float f){
        if (f < MAXFUEL)
            fuelUnits = f;
        else
            fuelUnits = MAXFUEL;
    }
    
    private void cleanPendingDamage(){
        if (getPendingDamage().hasNoEffect())
            pendingDamage = null; 
    }
     
    SpaceStation(String n, SuppliesPackage supplies){
        name = n;
        ammoPower = supplies.getAmmoPower();
        shieldPower = supplies.getShieldPower();
        assignFuelValue(supplies.getFuelUnits());
        shieldBoosters = new ArrayList();
        weapons = new ArrayList();
        hangar = null;
    }
    public SpaceStation(SpaceStation station) {
        weapons=new ArrayList<>();
        shieldBoosters=new ArrayList<>();         
        
        name=station.getName();
        nMedals=station.getNMedals();
        
        ammoPower=station.getAmmoPower();
        fuelUnits=station.getFuelUnits();
        shieldPower=station.getShieldPower();
        
        for (Weapon w:station.getWeapons()) {
            weapons.add(w);
        }
        
        for(ShieldBooster s:station.getShieldBoosters()) {
            shieldBoosters.add(s);
        }
        
        Hangar h=station.getHangar();
        if (h!=null) {
            hangar=h;
        }
        else {
            hangar=null;
        }
      
        
        Damage d = station.getPendingDamage();
        if (d != null) {
          pendingDamage = d;
        } else {
          pendingDamage = null;
        }
            
    }
    public void cleanUpMountedItems(){
 
       for (int i = 0; i < weapons.size(); i++){
           if (weapons.get(i).getUses() == 0){
               weapons.remove(i);
               i = i-1;
           }
       }
       
       for (int i = 0; i < shieldBoosters.size();  i++){
           if (shieldBoosters.get(i).getUses() == 0){
               shieldBoosters.remove(i);
               i = i-1;
           }
       }
    }
    public void discardHangar(){
        hangar = null;
    }
    public void discardShieldBooster(int i){
        if (i>=0 && i<shieldBoosters.size()){
            shieldBoosters.remove(i);
            if (pendingDamage != null){
                pendingDamage.discardShieldBooster();
                cleanPendingDamage(); 
            }
        }
    }
    public void discardShieldBoosterInHangar(int i){
        if (hangar != null)
            hangar.removeShieldBooster(i);
    }
    
    public void discardWeapon(int i){
        int size = weapons.size();
        if (i>=0 && i<size){
            
            Weapon w = weapons.remove(i);
            if (pendingDamage != null){
                pendingDamage.discardWeapon(w);
                cleanPendingDamage(); 
            }
        }
    }
    public void discardWeaponInHangar(int i){
        if (hangar != null)
           hangar.removeWeapon(i);
    }
    @Override
    public float fire(){
        float factor = 1;
        int size = weapons.size();
        for(int i=0; i<size; i++){
                factor *= weapons.get(i).useIt();
        }
        return ammoPower*factor;
    }
    
    public float getAmmoPower(){
        return ammoPower;
    }
    public float getFuelUnits(){
        return fuelUnits;
    }
    public Hangar getHangar(){
        return hangar;
    }
    public String getName(){
        return name;
    }
    public int getNMedals(){
        return nMedals;
    }
    
    
    public Damage getPendingDamage(){
        return pendingDamage;
    }
    
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    public float getShieldPower(){
        return shieldPower;
    }
    
    
    public float getSpeed(){
        return (fuelUnits/MAXFUEL);
    }
    
    
    public SpaceStationToUI getUIversion(){
         return new SpaceStationToUI(this);
    }
    
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    public void mountShieldBooster(int i){
        if (hangar != null){
            ShieldBooster esc = hangar.removeShieldBooster(i);
            if (esc != null){
                shieldBoosters.add(esc);
            }
        }
    }
    public void mountWeapon(int i){
        if (hangar != null){
            Weapon arma_aux = hangar.removeWeapon(i);
            if (arma_aux != null){
                weapons.add(arma_aux);
            }
        }
    }
    
    public void move(){
        if ((fuelUnits - getSpeed()*fuelUnits) > 0)
            fuelUnits = fuelUnits - getSpeed()*fuelUnits;
        else 
            fuelUnits = 0;
    }
    @Override
    public float protection(){
        float factor = 1;
        for(int i=0; i<shieldBoosters.size(); i++)
            factor *= shieldBoosters.get(i).useIt();
        
        return factor*shieldPower;
    }
    public void receiveHangar(Hangar h){
        if (hangar == null)
            hangar = h;
    }
    public boolean receiveShieldBooster(ShieldBooster s){
        if (hangar != null) 
            return hangar.addShieldBooster(s);
        return false;
    }
    @Override
    public ShotResult receiveShot(float shot){
        float myProtection = protection();
        if (myProtection >= shot){
            shieldPower-=SHIELDLOSSPERUNITSHOT*shot;
            shieldPower = Math.max(0.0f,shieldPower);
            return ShotResult.RESIST;
        }
        else {
            shieldPower = 0.0f;
            return ShotResult.DONOTRESIST;
            
        }
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower+= s.getAmmoPower();
        assignFuelValue(s.getFuelUnits()+fuelUnits);
        shieldPower+= s.getShieldPower();
    }
     
    public boolean receiveWeapon(Weapon w){
        if (hangar != null) 
            return hangar.addWeapon(w);
        return false;
    }
    
    public Transformation setLoot(Loot loot){
        CardDealer dealer = CardDealer.getInstance();
        int h = loot.getNHangars();
        
        if (h>0){
            Hangar hangar = dealer.nextHangar();
            receiveHangar(hangar);
        }
        int elements = loot.getNSupplies();
        for(int i=1; i<= elements; i++){
            receiveSupplies(dealer.nextSuppliesPackage());
        }
        
        elements = loot.getNWeapons();
        for(int i=1; i<= elements; i++){
            receiveWeapon(dealer.nextWeapon());
        }
        
        elements = loot.getNShields();
        for(int i=1; i<= elements; i++){
            receiveShieldBooster(dealer.nextShieldBooster());
        }
        
        int medals = loot.getNMedals();
        nMedals += medals;
        if (loot.getEfficient())
           return Transformation.GETEFFICIENT;
        else if (loot.spaceCity())
           return Transformation.SPACECITY;
        else 
           return Transformation.NOTRANSFORM;
    }
    
  
    public void setPendingDamage(Damage d){
        pendingDamage = d.adjust(weapons, shieldBoosters);
        cleanPendingDamage();
    }
    public boolean validState(){  
        if ( getPendingDamage() == null || getPendingDamage().hasNoEffect())
            return true;
        return false;
    }
    
    
}
