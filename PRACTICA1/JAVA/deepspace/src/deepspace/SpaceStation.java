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
public class SpaceStation {
    private static final int MAXFUEL = 100;
    private static final double SHIELDLOSSPERUNITSHOT = 0.1;
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage daño;
    private ShieldBooster[] aum_escudo;
    private Weapon [] arma;
    private Hangar hang;
    
    // VER SI HAY QUE PONER EL SHIELDBOOSTER[] Y WEAPON[] Y COMO SE PONE
    
    
    
    private void assignFuelValue(float f){
        assert(f <= MAXFUEL);
        fuelUnits = f;
    }
    /*si el daño pendiente no tiene efecto fija la referencia al mismo a null*/
    private void cleanPendingDamage(){
        if (getPendingDamage().hasNoEffect())
            daño = null; //ESTO NO ESTA CLARO
    }
    
    SpaceStation(String n, SuppliesPackage supplies){
        name = n;
        ammoPower = supplies.getAmmoPower();
        fuelUnits = supplies.getFuelUnits();
        shieldPower = supplies.getShieldPower();
    }
    //ME HE RAYADO PORQUE NO SE SI QUITARLO DEL HANGAR O DE DONDE
    //¿¿ES NECESARIO TENER LOS ARRAYS DE WEAPON Y HANGAR? RT EN CLASE HANGAR
    public void cleanUpMountedItems(){
       /* for (int i = 0; i < arma.size(); i++){
            if(arma[i].getUses() == 0)
                
        }*/
    }
    public void discardHangar(){
        hang = null;
    }
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    public void discardShieldBoosterInHangar(int i){
        if (hang != null)
            hang.removeShieldBooster(i);
    }
    public void discardWeapon(int i){
        throw new UnsupportedOperationException();
    }
    public void discardWeaponInHangar(int i){
        if (hang != null)
           hang.removeWeapon(i);
    }
    public float fire(){
        throw new UnsupportedOperationException();
    }
    public float getAmmoPower(){
        return ammoPower;
    }
    public float getFuelUnits(){
        return fuelUnits;
    }
    public Hangar getHangar(){
        return hang;
    }
    public String getName(){
        return name;
    }
    public int getNMedals(){
        return nMedals;
    }
    
    // HAY QUE HACERLO PERO NO SE DONDE ESTA EL PENDING DAMAGE
    public Damage getPendingDamage(){
        throw new UnsupportedOperationException();
    }
    
    //depende de si lo ponemos como atributo o no
    public ShieldBooster[] getShieldBoosters(){
        throw new UnsupportedOperationException();
    }
    public float getShieldPower(){
        return shieldPower;
    }
    public float getSpeed(){
        return (fuelUnits/MAXFUEL);
    }
    
    //llamar al constructor y ya??
    public SpaceStationToUI getUIversion(){
        throw new UnsupportedOperationException();
    }
    
    // lo mismo que con  shieldbooster[]
    public Weapon[] getWeapons(){
        throw new UnsupportedOperationException();
    }
    public void mountShieldBooster(int i){
        if (hang != null){
            ShieldBooster esc = hang.removeShieldBooster(i);
            if (esc != null){}
                
            //aniador el arma a arma[] ¿puede ser arrayist??
        }
    }
    public void mountWeapon(int i){
        if (hang != null){
            Weapon arma_aux = hang.removeWeapon(i);
            if (arma_aux != null){}
            //aniador el arma a arma[] ¿puede ser arrayist??
        }
    }
    public void move(){
        if ((fuelUnits - getSpeed()*fuelUnits) > 0)
            fuelUnits = fuelUnits - getSpeed()*fuelUnits;
    }
    public void protection(){
        throw new UnsupportedOperationException();
    }
    public void receiveHangar(Hangar h){
        if (hang == null)
            hang = h; // CONSTRUCTOR DE COPIA PUEDE PETAR
    }
    public boolean receiveShieldBooster(ShieldBooster s){
        if (hang != null) //PUEDE PETAR
            return hang.addShieldBooster(s);
        return false;
    }
    public ShotResult receiveShotResult(float shot){
        throw new UnsupportedOperationException();
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower+= s.getAmmoPower();
        fuelUnits+= s.getFuelUnits();
        shieldPower+= s.getShieldPower();
    }
     /*si se dispone de hangar devuelve el resultado de intentar añadir el hangar al mismo*/
    public boolean receiveWeapon(Weapon w){
        if (hang != null) // PUEDE PETAR
            return hang.addWeapon(w);
        return false;
    }
    public void setLoot(Loot loot){
        throw new UnsupportedOperationException();
    }
    
    public void setPendingDamage(Damage d){
        daño = d.adjust(arma, aum_escudo);
    }
    public boolean validState(){  // revisar condiciones que me lio con las dobles negaciones xd
        if ( getPendingDamage() == null || getPendingDamage().hasNoEffect())
            return true;
        return false;
    }
    
    
}
