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
public class EnemyStarShip {
    private float ammoPower;
    private String name;
    private float ShieldPower;
    
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        throw new UnsupportedOperationException();
    }
    EnemyStarShip(EnemyStarShip e){
        throw new UnsupportedOperationException();
    }
    EnemyToUI getUIversion(){
       throw new UnsupportedOperationException(); 
    }
    public float fire(){
       throw new UnsupportedOperationException(); 
    }
    public float getAmmoPower(){
        throw new UnsupportedOperationException();
    }
    public Damage getDamage(){
        throw new UnsupportedOperationException();
    }
    public Loot getLoot(){
        throw new UnsupportedOperationException();
    }
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public float getShieldPower(){
        throw new UnsupportedOperationException();
    }
    public float protection(){
        throw new UnsupportedOperationException();
    }
    public ShotResult receiveShot(float shot){
        throw new UnsupportedOperationException();
    }
}
