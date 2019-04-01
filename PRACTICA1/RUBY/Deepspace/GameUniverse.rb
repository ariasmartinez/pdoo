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
    @spaceStations  = Array.new #Array SpaceStation
    @currentEnemy = nil  #EnemyStarShip
    @currentStation = nil # SpaceStation

  end

  def combatGo(station, enemy)
#siguiente práctica
  end

  def combat
#siguiente práctica
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

  def init(names)
#siguiente práctica
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

  def nextTurn
#siguiente práctica
  end


  def to_s
    out = "Estación actual -> #{@currentStation}\n"
    out +="Enemigo actual --> #{@currentEnemy}"
    return out
  end

end

end
