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
public class EnemyStarShip {
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Damage damage;
    private Loot loot;
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        name = n; // no se si funcionará
        ammoPower = a;
        shieldPower = s;
        l = new Loot(l.getNSupplies(), l.getNWeapons(), l.getNShields(), l.getNHangars(), l.getNMedals());
        damage = d;  // mirar constructor de damage
    }
    EnemyStarShip(EnemyStarShip e){
        e = new EnemyStarShip(e.getName(), e.getAmmoPower(), e.getShieldPower(), e.getLoot(), e.getDamage());
    }
    EnemyToUI getUIversion(){
       return new EnemyToUI(this);
    }
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
    public float protection(){
        return getShieldPower();
    }
    public ShotResult receiveShot(float shot){
        if (protection() < shot)
            return ShotResult.DONOTRESIST;
        return ShotResult.RESIST;
    }
}
