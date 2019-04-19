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
        if (gameState.getState() == GameState.CANNOTPLAY){
            spaceStations = new ArrayList<SpaceStation>();
            CardDealer dealer = CardDealer.getInstance();
            for(int i=1; i<=names.length; i++){
                SuppliesPackage supplies = dealer.nextSuppliesPackage();
                SpaceStation station = new SpaceStation(names[i], supplies);
                spaceStations.add(station);
                int nh = dice.initWithNHangars();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();
                Loot lo = new Loot(0,nw,ns,nh,0);
                station.setLoot(lo);
            } 
            
            currentStationIndex = dice.whoStarts(names.length);
            currentStation = spaceStations.get(currentStationIndex);
            currentEnemy = dealer.nextEnemy();
            gameState.next(turns,spaceStations.size());
        }
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
        if(gameState.getState() == GameState.AFTERCOMBAT){
            boolean stationState = currentStation.validState();
            if(stationState){
                currentStationIndex = (currentStationIndex+1)%spaceStations.size();
                turns ++;
                currentStation = spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                CardDealer dealer = CardDealer.getInstance(); 
                currentEnemy = dealer.nextEnemy();
                gameState.next(turns, spaceStations.size());
                return true;
            }
            return false;
        }
        return false;
    }    
}
