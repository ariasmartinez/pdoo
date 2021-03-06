/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.Random;

/**
 *
 * @author Lucía Salamanca López
 *         Celia Arias Martínez
 */
class Dice {
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    private final float EXTRAEFFICIENCYPROB;
    private Random generator;
    
    Dice(){
        generator = new Random(System.currentTimeMillis());
        NHANGARSPROB=0.25f;
        NSHIELDSPROB=0.25f;
        NWEAPONSPROB=0.33f;
        FIRSTSHOTPROB=0.5f;
        EXTRAEFFICIENCYPROB=0.8f;
    }
    
    int initWithNHangars(){
        if (generator.nextFloat() < NHANGARSPROB)
            return 0;
        return 1;
    }
    
    int initWithNWeapons(){
        float aleat = generator.nextFloat();
        if ( aleat < NWEAPONSPROB)
            return 1;
        else if(aleat < 2*NWEAPONSPROB)
            return 2;
        else 
            return 3;
    }
    
    int initWithNShields(){
        if (generator.nextFloat() < NSHIELDSPROB)
           return 0;
        return 1;
    }
    
    int whoStarts(int nPlayers){
        return generator.nextInt(nPlayers);
    }
    
    GameCharacter firstShot(){
        GameCharacter personaje;
        if (generator.nextFloat() < FIRSTSHOTPROB)
            personaje = GameCharacter.SPACESTATION; 
        else
            personaje = GameCharacter.ENEMYSTARSHIP;
        return personaje;    
    }
    
    boolean spaceStationMoves(float speed){
        if (generator.nextFloat() < speed)
           return true;
        return false;
    }
    
    public boolean extraEfficiency(){
        if (generator.nextFloat() < EXTRAEFFICIENCYPROB)
            return true;
        
        return false;
                    
    }
    
    public String toString(){
        String mensaje = "Este dado tiene de probabilidad de Hangar :"+NHANGARSPROB+", de Shield: " +NSHIELDSPROB+", de Weapons: " +NWEAPONSPROB+", y de FirstShot: "+ FIRSTSHOTPROB+".";
 
        return mensaje;
    }
}
