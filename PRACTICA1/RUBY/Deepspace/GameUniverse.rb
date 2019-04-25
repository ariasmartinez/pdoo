#encoding:utf-8
require'./Dice.rb'
require './GameStateController'
require'./EnemyStarShip'
require './CombatResult'
require './CardDealer'
require './SpaceStation'
require './GameUniverseToUI'
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

    #duda
  def combatGo(station, enemy)   #station es una StationSpace (@current), enemy es un EnemyStarSHip (@current)
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
          #no habria que hacer cleanpendingDamage ??
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
      @gameState.next(@turns, @spaceStations.length)
      return combatResult    
  end

  def combat
    state = state()
    puts "GameUNiverse::combat state"+state.to_s #borrar
    if ((state == GameState::BEFORECOMBAT) || (state == GameState::INIT) ) 
      combatGo(@currentStation, @currentEnemy)
    else 
      return CombatResult::NOCOMBAT
    end
  end

  def discardHangar
    if (state() == GameState::INIT or state() == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardHangar
    end
  end

  def discardShieldBooster(i)
    if (state() == GameState::INIT or state() == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardShieldBooster(i)
    end
  end

  def discardShieldBoosterInHangar(i)
    if (state() == GameState::INIT or state() == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardShieldBoosterInHangar(i)
    end
  end

  def discardWeapon(i)
    if (state() == GameState::INIT or state() == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardWeapon(i)
    end
  end

  def discardWeaponInHangar(i)
    if (state() == GameState::INIT or state() == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardWeaponInHangar(i)
    end
  end

  def state
    return @gameState.state
  end

  def getUIversion
    GameUniverseToUI.new(@currentStation, @currentEnemy)
  end

  def haveAWinner
    if (@spaceStations[@currentStationIndex].nMedals == @@WIN)
      return true
    end
    return false
  end

  def init(names)  #names es un string, devuelve void
      estado = state()
      if (estado == GameState::CANNOTPLAY)
          @spaceStations = Array.new 
          dealer = CardDealer.instance
          for i in names  
            supplies = dealer.nextSuppliesPackage()
            estacion = SpaceStation.new(i, supplies)
            @spaceStations << estacion
            nh = @dice.initWithNHangars
            nw = @dice.initWithNWeapons
            ns = @dice.initWithNShields
            lo = Loot.new(0, nw, ns, nh, 0)
            estacion.setLoot(lo)
          end
          @currentStationIndex = @dice.whoStarts(names.length)
          @currentStation = @spaceStations[@currentStationIndex]
          @currentEnemy = dealer.nextEnemy
          @gameState.next(@turns, @spaceStations.length)
      end
  end

  def mountShieldBooster(i)
    if (state() == GameState::INIT or state() == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].mountShieldBooster(i)
    end
  end

  def mountWeapon(i)
    if (state() == GameState::INIT or state() == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].mountWeapon(i)
    end
  end

  def nextTurn   #devuelve un boolean
    state = state()     
    if ( state == GameState::AFTERCOMBAT)
      stationState = @currentStation.validState
      if (stationState)
        @currentStationIndex = (@currentStationIndex+1) % @spaceStations.length
        @turns+=1
        @currentStation = @spaceStations[@currentStationIndex]
        @currentStation.cleanUpMountedItems
        dealer = CardDealer.instance 
        @currentEnemy = dealer.nextEnemy
        @gameState.next(@turns, @spaceStations.length)
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
