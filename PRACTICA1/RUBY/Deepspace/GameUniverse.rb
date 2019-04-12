#encoding:utf-8
require'./Dice.rb'
require './GameStateController'
require'./EnemyStarShip'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class GameUniverse
  @@WIN = 10

  def initialize
    @currentStationIndex = nil #int
    @turns = 0 #int
    @dice = Dice.new #Dice
    @gameState  = GameStateController.new   #GameStateController
    @spaceStations  = nil #Array SpaceStation  (lo cambio a nil porque se inicializa en init)
    @currentEnemy = nil  #EnemyStarShip
    @currentStation = nil # SpaceStation

  end

  def combatGo(station, enemy)
      ch = @dice.firstShot 
      if (ch == GameCharacter::ENEMYSTARSHIP)
        fire = enemy.fire
        result = station.receiveShot(fire)
        if (result == ShotResult::RESIST)
          fire = station.fire 
          result = enemy.receiveShot(fire)
          enemyWins = (result == ShotResult::RESIST)
        else 
          enemyWins = true
        end
      else 
        fire = station.fire 
        result = enemy.receiveShot(fire)
        enemyWins = (result == ShotResult::RESIST)
      end

      if (enemyWins)
        s = station.getSpeed
        moves = @dice.spaceStationMoves(s)
        if (!moves)
          damage = enemy.damage 
          station.setPendingDamage(damage)
          combatResult = CombatResult::ENEMYWINS 
        else 
          station.move
          combatResult = CombatResult::STATIONESCAPES
        end 
      else 
        aLoot = enemy.loot
        station.setLoot(aLoot)
        combatResult = CombatResult::STATIONWINS
      end
      @gameState.next(turns, station.length)
      return combatResult
     
  end

  def combat
    state = @gameState.state 
    if ((state == GameState::BEFORECOMBAT) || (state == GameState::INIT) ) 
      combatGo(@currentStation, @currentEnemy)
    else 
      return CombatResult::NOCOMBAT
    end
  end

  def discardHangar
    if (@gameState.state == GameState::INIT or @gameState.state == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardHangar
    end
  end

  def discardShieldBooster(i)
    if (@gameState.state == GameState::INIT or @gameState.state == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardShieldBooster(i)
    end
  end

  def discardShieldBoosterinHangar(i)
    if (@gameState.state == GameState::INIT or @gameState.state == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardShieldBoosterinHangar(i)
    end
  end

  def discardWeapon(i)
    if (@gameState.state == GameState::INIT or @gameState.state == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardWeapon(i)
    end
  end

  def discardWeaponinHangar(i)
    if (@gameState.state == GameState::INIT or @gameState.state == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardWeaponinHangar(i)
    end
  end

  def getState
    return @gameState
  end

  def getUIversion
    GameUniverseToUI.new(self)
  end

  def haveAWinner
    if (@spaceStations[@currentStationIndex].nMedals == @@WIN)
      return true
    end
    return false
  end

  def init(names)  #names es un string, devuelve void
      estado = @gameState.state
      if (estado == GameState::CANNOTPLAY)
          @spaceStations = Array.new 
          dealer = CardDealer.instance
          for i in names  #duda
            supplies = dealer.nextSuppliesPackage()
            estacion = SpaceStation.new(name, supplies)
            @spaceStations << estacion
            nh = @dice.initWithHangar
            nw = @dice.initWithWeapons
            ns = @dice.initWithSHields
            lo = Loot.new(0, nw, ns, nh, 0)
            estacion.setLoot(lo)
          end
          @currentStationIndex = @dice.whoStarts(names.length)
          @currentStation = @spaceStations[@currentStationIndex]
          @currentEnemy = dealer.nextEnemy
          @gameState.next(turns, @spaceStations.length)
      end
  end

  def mountShieldBooster(i)
    if (@gameState.state == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].mountShieldBooster(i)
    end
  end

  def mountWeapon(i)
    if (@gameState.state == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].mountWeapon(i)
    end
  end

  def nextTurn   #devuelve un boolean
    state = @gameState.state 
    if ( state == GameState::AFTERCOMBAT)
      stationState = @currentStation.validState
      if (stationState)
        @currentStationIndex = (@currentStationIndex+1) % @spaceStations.length
        @turns+=1
        @currentStation = @spaceStations[@currentStationIndex]
        @currentStation.cleanUpMountedItems
        dealer = CardDealer.instance 
        @currentEnemy = dealer.nextEnemy
        @gameState.next(turns, @spaceStations.length)
        return true
      else 
        return false
      end   
    else 
      return false
    end 
  end


  def to_s
    out = "Estación actual -> #{@currentStation}\n"
    out +="Enemigo actual --> #{@currentEnemy}"
    return out
  end

end

end
