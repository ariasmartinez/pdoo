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
public class GameUniverse {
    private static final int WIN = 10;
    private int currentStationIndex;
    private int turns;
    
    public GameUniverse(){
        currentStationIndex = 0;
        turns = 0;
    }
    
    public GameUniverse(int csi, int turn){
        currentStationIndex = csi;
        turns = turn;
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        throw new UnsupportedOperationException();
    }
    
    public CombatResult combat(){
        throw new UnsupportedOperationException();
    }
    
    public void discardHangar(){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBoosterInHangar(int i){
        throw new UnsupportedOperationException();
    }
    public void discardWeapon(int i){
        throw new UnsupportedOperationException();
    }
    public void discardWeaponInHangar(int i){
        throw new UnsupportedOperationException();
    }
    public GameState getState(){
        throw new UnsupportedOperationException();
    }
    
    public GameUniverseToUI getUIVersion(){
        throw new UnsupportedOperationException();
    }
    public boolean haveAWinner(){
        throw new UnsupportedOperationException();
    }
    public void init(String [] names){
        throw new UnsupportedOperationException();
    }
    public void mountShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    public void mountWeapon(int i){
        throw new UnsupportedOperationException();
    }
    public boolean nextTurn(){
        throw new UnsupportedOperationException();
    }    
}
