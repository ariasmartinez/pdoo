#encoding:utf-8
require'./Dice.rb'
require './GameStateController'
require'./EnemyStarShip'
module Deepspace


# @author Lucía Salamanca López, Celia Arias Martínez
class GameUniverse
  @@WIN = 10

# Hay que crear un dado
# controlador de estados?
  def initialize
    @currentStationIndex = nil #int   # no sé que hay que poner   Es lo mismo que currentStation?
    @turns = 0 #int
    @dice = Dice.new #Dice     #hace falta poner new?  (poner new o no)
    @gameState  = GameStateController.new   #GameStateController  (poner new o no)
    @spaceStations  = Array.new #Array SpaceStation  (poner new o no)
    @currentEnemy = nil  #EnemyStarShip   #EnemyStarShip.new   lo pongo a nil porque habria que pasarle parametros
    @currentStation = nil # SpaceStation   lo pongo asi para que no de error SpaceStation.new()  #hay que pasarle algo

  end

  def combatGo(station, enemy)
#siguiente práctica
  end

  def combat
#siguiente práctica
  end

  def discardHangar
    if (@gameState == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardHangar
    end
  end

  def discardShieldBooster(i)
    if (@gameState == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardShieldBooster(i)
    end
  end

  def discardShieldBoosterinHangar(i)
    if (@gameState == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardShieldBoosterinHangar(i)
    end
  end

  def discardWeapon(i)
    if (@gameState == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].discardWeapon(i)
    end
  end

  def discardWeaponinHangar(i)
    if (@gameState == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
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
    if (@gameState == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].mountShieldBooster(i)
    end
  end

  def mountWeapon(i)
    if (@gameState == GameState::INIT or @gameState == GameState::AFTERCOMBAT)
      @spaceStations[@currentStationIndex].mountWeapon(i)
    end
  end

  def nextTurn
#siguiente práctica
  end

  #lo he puesto igual que el toUI
  def to_s
    out = "Estación actual -> #{@currentStation}\n"
    out +="Enemigo actual --> #{@currentEnemy}"
    return out
  end

end

end
