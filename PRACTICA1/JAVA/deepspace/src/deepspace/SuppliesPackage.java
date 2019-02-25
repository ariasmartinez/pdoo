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
class SuppliesPackage {
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    SuppliesPackage(float ammo, float fuel, float shield){
        ammoPower = ammo;
        fuelUnits = fuel;
        shieldPower = shield;
    }
    
    SuppliesPackage(SuppliesPackage otro){
        ammoPower = otro.ammoPower;
        fuelUnits = otro.fuelUnits;
        shieldPower = otro.shieldPower;
    }
    
    float getAmmoPower(){
        return ammoPower;
    }
    float getFuelUnits(){
        return fuelUnits;
    }
    float getShieldPower(){
        return shieldPower;
    }
}
