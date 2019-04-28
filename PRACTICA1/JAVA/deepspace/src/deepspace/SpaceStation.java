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
public class SpaceStation {
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
    
    // Weapons[] y shieldBOosters[] o con ArrayList??
    
    
    
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
    //Cambio 
    SpaceStation(String n, SuppliesPackage supplies){
        name = n;
        ammoPower = supplies.getAmmoPower();
        shieldPower = supplies.getShieldPower();
        assignFuelValue(supplies.getFuelUnits());
        shieldBoosters = new ArrayList();
        weapons = new ArrayList();
        hangar = null;
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
        if (i>=0 && i<weapons.size()){
            Weapon w = new Weapon(weapons.get(i));
            weapons.remove(i);
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
    public float fire(){
        float factor = 1;
        for(int i=0; i< weapons.size(); i++){
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
    
    //cambio ShieldBooster[] por array
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    public float getShieldPower(){
        return shieldPower;
    }
    
    //mirar lo de float
    public float getSpeed(){
        return (fuelUnits/MAXFUEL);
    }
    
    
    public SpaceStationToUI getUIversion(){
         return new SpaceStationToUI(this);
    }
    
    // lo mismo que con  shieldbooster[]
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
    //Cambio
    public void move(){
        if ((fuelUnits - getSpeed()*fuelUnits) > 0)
            fuelUnits = fuelUnits - getSpeed()*fuelUnits;
        else 
            fuelUnits = 0;
    }
    public float protection(){
        float factor = 1;
        for(int i=0; i<shieldBoosters.size(); i++)
            factor *= shieldBoosters.get(i).useIt();
        
        return factor*shieldPower;
    }
    public void receiveHangar(Hangar h){
        if (hangar == null)
            hangar = h; // CONSTRUCTOR DE COPIA PUEDE PETAR
    }
    public boolean receiveShieldBooster(ShieldBooster s){
        if (hangar != null) 
            return hangar.addShieldBooster(s);
        return false;
    }
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
    //CAMBIO assignFuelValue(s.getFuelUnits())
    public void receiveSupplies(SuppliesPackage s){
        ammoPower+= s.getAmmoPower();
        assignFuelValue(s.getFuelUnits()+fuelUnits);
        shieldPower+= s.getShieldPower();
    }
     
    public boolean receiveWeapon(Weapon w){
        if (hangar != null) // PUEDE PETAR
            return hangar.addWeapon(w);
        return false;
    }
    //CAMBIO Hangar hangar
    //CAMBIO Hangar prov = dealer.nextHangar();
            //Hangar hangar2 = new Hangar(prov);
            //receiveHangar(hangar2)
    public void setLoot(Loot loot){
        CardDealer dealer = CardDealer.getInstance();
        int h = loot.getNHangars();
        
        if (h>0){
            receiveHangar(dealer.nextHangar());
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
        
    }
    
    //cambio def de funcion en Damage
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
