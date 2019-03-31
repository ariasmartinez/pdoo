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
    
    public float getAmmoPower(){
        return ammoPower;
    }
    public float getFuelUnits(){
        return fuelUnits;
    }
    public float getShieldPower(){
        return shieldPower;
    }
    
    public String toString(){
        String mensaje = "El SuppliesPackage tiene de municiones de energía: "+ammoPower+", de combustible: "+fuelUnits+" y de poder de escudo: "+shieldPower+".";
        return mensaje;
    }
}
