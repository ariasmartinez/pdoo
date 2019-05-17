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
    private boolean haveSpaceCity;
    
    public GameUniverse(){
        currentStationIndex = 0;
        turns = 0;
        dice = new Dice();
        gameState = new GameStateController();
        spaceStations = new ArrayList();
        currentEnemy = null;
        currentStation = null;
        haveSpaceCity = false;
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
        float fire;
        ShotResult result;
        boolean enemyWins;
        CombatResult combatResult;
        if(dice.firstShot() == GameCharacter.ENEMYSTARSHIP){
            fire = enemy.fire();
            result = station.receiveShot(fire);
            if (result == ShotResult.RESIST){
                fire = station.fire();
                result = station.receiveShot(fire);
                enemyWins=(result == ShotResult.RESIST);
            }
            else 
                enemyWins = true;
        }
        else{
            fire = station.fire();
            result = enemy.receiveShot(fire);
            enemyWins=(result==ShotResult.RESIST);
        }
        
        if (enemyWins){
            if (!(dice.spaceStationMoves(station.getSpeed()))){
                station.setPendingDamage(enemy.getDamage());
                combatResult = CombatResult.ENEMYWINS;
            }
            else{
                station.move();
                combatResult = CombatResult.STATIONESCAPES;
            }
        }
        else {
            Transformation trans= station.setLoot(enemy.getLoot());
            combatResult = CombatResult.STATIONWINS;
            
            if(trans == Transformation.GETEFFICIENT)
                makeStationEfficient();
            else if (trans == Transformation.SPACECITY)
                createSpaceCity();
            
        }
        gameState.next(turns, spaceStations.size());
        return combatResult;
        
    }
    
    public CombatResult combat(){
        if((getState() == GameState.BEFORECOMBAT) || (getState() == GameState.INIT))
            return combat(currentStation,currentEnemy);
        else 
            return CombatResult.NOCOMBAT;
    }
    
    public void discardHangar(){
        if ((getState() == GameState.INIT) || (getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardHangar();
    }
    
    public void discardShieldBooster(int i){
        if ((getState() == GameState.INIT) || (getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardShieldBooster(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
         if ((getState() == GameState.INIT) || (getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardShieldBoosterInHangar(i);
    }
    public void discardWeapon(int i){
        if ((getState() == GameState.INIT) || (getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardWeapon(i);
    }
    public void discardWeaponInHangar(int i){
         if ((getState() == GameState.INIT) || (getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).discardWeaponInHangar(i);
    }
    public GameState getState(){
        return gameState.getState();
    }
    
    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(currentStation, currentEnemy);
    }
    public boolean haveAWinner(){
        if (spaceStations.get(currentStationIndex).getNMedals() == WIN)
            return true;
        return false;
                   
    }
    
    //CAMBIO indices for
    public void init(ArrayList<String> names){
        if (getState() == GameState.CANNOTPLAY){
            spaceStations = new ArrayList<SpaceStation>();
            CardDealer dealer = CardDealer.getInstance();
            for(int i=0; i<names.size(); i++){
                SuppliesPackage supplies = dealer.nextSuppliesPackage();
                SpaceStation station = new SpaceStation(names.get(i), supplies);
                spaceStations.add(station);
                int nh = dice.initWithNHangars();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();
                Loot lo = new Loot(0,nw,ns,nh,0);
                station.setLoot(lo);
            } 
            
            currentStationIndex = dice.whoStarts(names.size());
            currentStation = spaceStations.get(currentStationIndex);
            currentEnemy = dealer.nextEnemy();
            gameState.next(turns,spaceStations.size());
        }
    }
    public void mountShieldBooster(int i){
        if ((getState() == GameState.INIT) || (getState() == GameState.AFTERCOMBAT))
          spaceStations.get(currentStationIndex).mountShieldBooster(i);
    }
    public void mountWeapon(int i){
         if ((getState() == GameState.INIT) || (getState() == GameState.AFTERCOMBAT))
            spaceStations.get(currentStationIndex).mountWeapon(i);
    }
    public boolean nextTurn(){
        if(getState() == GameState.AFTERCOMBAT){
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
    
    private void createSpaceCity(){
        if(!haveSpaceCity){
            ArrayList<SpaceStation> collaborators = new ArrayList<>();
            
            for(int i=0; i<spaceStations.size(); i++){
                if (i!=currentStationIndex)
                    collaborators.add(spaceStations.get(i));
            }
            currentStation = new SpaceCity(currentStation,collaborators);
            haveSpaceCity = true;
            
            spaceStations.remove(currentStationIndex);
            spaceStations.add(currentStationIndex, currentStation);
        }
    }
    
    private void makeStationEfficient(){
        currentStation= new PowerEfficientSpaceStation(currentStation);
        if (dice.extraEfficiency())
            currentStation=new BetaPowerEfficientSpaceStation(currentStation);
        
        spaceStations.remove(currentStationIndex);
        spaceStations.add(currentStationIndex, currentStation);
    }
    
    public String toString(){
        String mensaje = "Estación actual -> "+currentStation.toString()+"\nEnemigo actual --> "+currentEnemy.toString();
        return mensaje;
    }
}
