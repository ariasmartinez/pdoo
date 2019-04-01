/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author celia
 */
public class GameUniverse {
    private static final int WIN = 10;
    private int currentStationIndex;
    private int turns;
    private Dice dice;
    private GameStateController gameState;
    private ArrayList<SpaceStation> spaceStations;
    private EnemyStarShip currentEnemy;
    private SpaceStation currentStation;
    
    public GameUniverse(){
        currentStationIndex = 0;
        turns = 0;
        dice = new Dice();
        gameState = new GameStateController();
        spaceStations = new ArrayList();
        currentEnemy = null;
        currentStation = null;
    }
    
    public GameUniverse(int csi, int turn){
        currentStationIndex = csi;
        turns = turn;
        dice = new Dice();
        gameState = new GameStateController();
        spaceStations = new ArrayList();
        currentEnemy = null;
        currentStation = null;
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        throw new UnsupportedOperationException();
    }
    
    public CombatResult combat(){
        throw new UnsupportedOperationException();
    }
    
    public void discardHangar(){
        if ((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardHangar();
    }
    
    public void discardShieldBooster(int i){
        if ((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardShieldBooster(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
         if ((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardShieldBoosterInHangar(i);
    }
    public void discardWeapon(int i){
        if ((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardWeapon(i);
    }
    public void discardWeaponInHangar(int i){
         if ((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardWeaponInHangar(i);
    }
    public GameState getState(){
        return gameState.getState();
    }
    
    public GameUniverseToUI getUIVersion(){
        return new GameUniverseToUI(currentStation, currentEnemy);
    }
    public boolean haveAWinner(){
        if (spaceStations.get(currentStationIndex).getNMedals() == WIN)
            return true;
        return false;
                   
    }
    public void init(String [] names){
        throw new UnsupportedOperationException();
    }
    public void mountShieldBooster(int i){
        if ((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
          spaceStations.get(currentStationIndex).mountShieldBooster(i);
    }
    public void mountWeapon(int i){
         if ((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).mountWeapon(i);
    }
    public boolean nextTurn(){
        throw new UnsupportedOperationException();
    }    
}
