/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author Lucía Salamanca López
 *         Celia Arias Martínez
 */
public class EnemyStarShip implements SpaceFighter{
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Damage damage;
    private Loot loot;
    

    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        name = n; 
        ammoPower = a;
        shieldPower = s;
        loot = new Loot(l.getNSupplies(), l.getNWeapons(), l.getNShields(), l.getNHangars(), l.getNMedals(), l.getEfficient(), l.spaceCity()); 
        damage = d; 
    }

    EnemyStarShip(EnemyStarShip e){
       name = e.getName();
       ammoPower = e.getAmmoPower();
       shieldPower = e.getShieldPower();
       loot = e.getLoot();
       damage = e.getDamage();
    }
    EnemyToUI getUIversion(){
       return new EnemyToUI(this);
    }
    
    @Override
    public float fire(){
       return getAmmoPower(); 
    }
    public float getAmmoPower(){
        return ammoPower;
    }
    public Damage getDamage(){
        return damage;
    }
    public Loot getLoot(){
        return loot;
    }
    public String getName(){
        return name;
    }
    public float getShieldPower(){
        return shieldPower;
    }
    @Override
    public float protection(){
        return getShieldPower();
    }
    @Override
    public ShotResult receiveShot(float shot){
        if (protection() < shot)
            return ShotResult.DONOTRESIST;
        return ShotResult.RESIST;
    }
    public String toString(){
        String mensaje = "Name: "+name+ ", Ammo Power: "+ammoPower+", Shield Power: "+shieldPower+"\n\tLoot..:"+loot.toString()+"\n\tDamage: "+damage.toString();
        return mensaje;
    }
}
